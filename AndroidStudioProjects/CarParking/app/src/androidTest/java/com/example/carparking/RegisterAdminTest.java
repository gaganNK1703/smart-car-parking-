package com.example.carparking;

import android.util.Log;
import android.widget.Toast;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class RegisterAdminTest {

    @Rule
    public ActivityScenarioRule<RegisterAdmin> activityScenarioRule = new ActivityScenarioRule<>(RegisterAdmin.class);

    @Test
    public void testRegistration() {
            //Initialize Firebase Authentication emulator
       FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.useEmulator("10.0.2.2", 9099); // Replace with the appropriate emulator host and port


            String testEmail = "gnk@gmail.com";
            String testPassword = "1234567";

//        auth.createUserWithEmailAndPassword(testEmail, testPassword).addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                // User creation success
//                FirebaseUser user = auth.getCurrentUser();
//                // Perform further actions or show success message
//                Log.d("Registration", "User creation success");
//            } else {
//                // User creation failed
//                Exception exception = task.getException();
//                // Handle the failure or show error message
//                Log.e("Registration", "User creation failed", exception);
//            }
//        });
//       String email = String.valueOf(editTextEmail.getText());
//        String password = String.valueOf(editTextPassword.getText());

        //Type the email and password
        Espresso.onView(ViewMatchers.withId(R.id.email)).perform(ViewActions.typeText(testEmail));
        Espresso.onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.typeText(testPassword));

        // Close the soft keyboard
        Espresso.closeSoftKeyboard();

        // Click the Register button
        Espresso.onView(ViewMatchers.withId(R.id.btn_register)).perform(ViewActions.click());

        // Verify the registration process
        // You can use Firebase Authentication APIs to verify the registration status
        // For example, you can check if the user is successfully created:
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if (currentUser != null) {
//            // User is successfully created
//            Log.d("Registration", "User created: " + currentUser.getEmail());
//        } else {
//            // User creation failed
//            Log.d("Registration", "User creation failed");
       // }
    }
}
