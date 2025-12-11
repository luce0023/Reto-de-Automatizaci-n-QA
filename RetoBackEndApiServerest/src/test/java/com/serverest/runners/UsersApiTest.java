package com.serverest.runners;

import com.intuit.karate.junit5.Karate;

class UsersApiTest {

    @Karate.Test
    Karate runUsers() {
        return Karate.run(
                "classpath:features/users/GetUsers.feature",
                "classpath:features/users/PostUser.feature",
                "classpath:features/users/GetUserById.feature",
                "classpath:features/users/PutUser.feature",
                "classpath:features/users/DeleteUser.feature"
        );
    }
}
