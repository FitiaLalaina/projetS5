package com.culture.API.Utils;
import java.util.UUID;

public class HashGenerator {

    public static String generateCode() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", ""); // Remove dashes to get a continuous string of characters
    }

}
