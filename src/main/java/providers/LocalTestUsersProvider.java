package providers;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import dataobjects.TestUser;
import org.apache.commons.io.IOUtils;
import org.slf4j.MDC;
import providers.dto.SingleUserResponse;
import providers.dto.UserPayload;
import providers.dto.UserStatus;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LocalTestUsersProvider implements TestUsersProvider {

    private static LocalTestUsersProvider instance = null;
    private static Queue<TestUser> queue = new LinkedList<>();
    private static final String DEFAULT_TEST_USERS_FILE = "testusers";

    protected LocalTestUsersProvider() {
        // Exists only to defeat instantiation.
    }

    public static LocalTestUsersProvider getInstance() {
        if(instance == null) {
            instance = new LocalTestUsersProvider();
            instance.initialize();
        }
        return instance;
    }

    protected void initialize(String fileName) {
        final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(DEFAULT_TEST_USERS_FILE);
        try {
            final String allUsers = IOUtils.toString(resourceAsStream);
            final String[] users = allUsers.split("\n");
            Arrays.stream(users)
                    .forEach(u -> {
                        final String[] loginPsw = u.split("\\|");
                        queue.add(new TestUser(loginPsw[0], loginPsw[1]));
                    });
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read test users file " + DEFAULT_TEST_USERS_FILE, e);
        }
    }

    protected void initialize() {
        initialize(DEFAULT_TEST_USERS_FILE);
    }

    @Override
    public synchronized void release(TestUser testUser) {
        ApplicationEndpoints applicationEndpoints = new RestClient().createClient();
        final SingleUserResponse user = applicationEndpoints.getUserById(testUser.getEmail());

        final UserPayload userPayload = user.getItem();
        userPayload.setUserstatus(UserStatus.FREE_TO_USE);
        applicationEndpoints.modifyUser(userPayload);

        queue.add(testUser);
        notify(); // notifyAll() for multiple producer/consumer threads
    }

    @Override
    public synchronized TestUser take() {

        while(queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        TestUser item = queue.remove();
        MDC.put("userId", item.getEmail());
        notify(); // notifyAll() for multiple producer/consumer threads
        return item;
    }

}
