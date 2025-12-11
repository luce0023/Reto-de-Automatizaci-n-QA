package com.serverest.helpers;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    public static String uniqueEmail() {
    return "qa_" + UUID.randomUUID().toString().substring(0, 8) + "@teste.com";
}

    public static String randomName() {
        String[] names = {"Lucero", "Vale", "Ari", "Dana", "Leo", "Alex"};
        int i = ThreadLocalRandom.current().nextInt(names.length);
        return names[i] + "_" + UUID.randomUUID().toString().substring(0, 6);
    }

   public static String randomPassword() {
    return "1234";
}

    // Usuario válido mínimamente requerido por ServeRest
    public static String validUserJson() {
        String name = randomName();
        String email = uniqueEmail();
        String password = randomPassword();
        // ServeRest suele requerir: nome, email, password, administrador (boolean en string "true"/"false")
        return String.format("{\"nome\":\"%s\",\"email\":\"%s\",\"password\":\"%s\",\"administrador\":\"true\"}",
                name, email, password);
    }

    // Usuario inválido (email no válido)
    public static String invalidUserJson() {
        return "{\"nome\":\"\",\"email\":\"not-an-email\",\"password\":\"\",\"administrador\":\"false\"}";
    }
}
