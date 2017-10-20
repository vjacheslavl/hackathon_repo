package providers;/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import dataobjects.TestUser;

public interface TestUsersProvider {
    TestUser take();
    void release(TestUser testUser);
}
