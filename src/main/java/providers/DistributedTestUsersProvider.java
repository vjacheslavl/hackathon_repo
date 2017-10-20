package providers;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import dataobjects.TestUser;
import org.slf4j.MDC;
import providers.dto.UserPayload;
import providers.dto.UserStatus;

public class DistributedTestUsersProvider {

    private static DistributedTestUsersProvider instance = null;
    ApplicationEndpoints applicationEndpoints;

    protected DistributedTestUsersProvider() {
        // Exists only to defeat instantiation.
    }

    public static DistributedTestUsersProvider getInstance() {
        if(instance == null) {
            instance = new DistributedTestUsersProvider();
            instance.initialize();
        }
        return instance;
    }

    protected void initialize() {
        applicationEndpoints = new RestClient().createClient();
    }

    public synchronized void release(TestUser testUser) {
        final UserPayload userPayload = testUser.getUserPayload();
        userPayload.setUserstatus(UserStatus.FREE_TO_USE);
        applicationEndpoints.modifyUser(userPayload);
    }

    public synchronized TestUser take() {
        final UserPayload userPayload = applicationEndpoints.getAllUsers().getItems().stream().findFirst().get();
        userPayload.setUserstatus(UserStatus.LOCKED);
        applicationEndpoints.modifyUser(userPayload);

        final String email = userPayload.getId();
        final String password = userPayload.getPassword();

        MDC.put("email", email);

        final TestUser testUser = new TestUser(email, password);
        testUser.setUserPayload(userPayload);
        return testUser;
    }

}
