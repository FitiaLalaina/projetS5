package com.culture.API.Controllers.Front.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp  initializeFirebase() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/kultora-66a9f-firebase-adminsdk-tcuux-61aeccebab.json"); // Update the path

        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://kultora-66a9f-default-rtdb.europe-west1.firebasedatabase.app")
        .build();

        return FirebaseApp.initializeApp(options);
    }
}
