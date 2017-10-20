/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import dataobjects.TestUser;
import org.junit.Test;
import providers.DistributedTestUsersProvider;

import static org.junit.Assert.assertNotNull;

public class DistributedUsersProviderTest {

    @Test
    public void getAndReleaseUser() {
        final DistributedTestUsersProvider testUserProvider = DistributedTestUsersProvider.getInstance();
        final TestUser testUser = testUserProvider.take();
        assertNotNull(testUser.getEmail());
        assertNotNull(testUser.getPassword());

        final Runnable parallelUserTake = () -> {
            final TestUser userAfterRelease = testUserProvider.take();
            assertNotNull(userAfterRelease.getEmail());
            assertNotNull(userAfterRelease.getPassword());
        };

        new Thread(parallelUserTake).start();

        testUserProvider.release(testUser);
    }

}
