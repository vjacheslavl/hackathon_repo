/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import org.junit.Test;
import dataobjects.TestUser;
import providers.TestUsersProvider;

import static org.junit.Assert.assertNotNull;

public class TestUsersProviderTest {

    @Test
    public void getAndReleaseUser() {
        final TestUsersProvider testUserProvider = TestUsersProvider.getInstance();
        final TestUser testUser = testUserProvider.take();
        assertNotNull(testUser.getLogin());
        assertNotNull(testUser.getPassword());

        final Runnable parallelUserTake = () -> {
            final TestUser userAfterRelease = testUserProvider.take();
            assertNotNull(userAfterRelease.getLogin());
            assertNotNull(userAfterRelease.getPassword());
        };

        new Thread(parallelUserTake).start();

        testUserProvider.release(testUser);
    }

}
