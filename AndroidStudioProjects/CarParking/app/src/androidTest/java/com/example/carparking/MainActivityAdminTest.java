package com.example.carparking;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//import com.example.userlogin.Login;
//import com.example.userlogin.MainActivityAdmin;

@RunWith(AndroidJUnit4.class)
public class MainActivityAdminTest {
    @Rule
    public ActivityScenarioRule<MainActivityAdmin> activityRule =
            new ActivityScenarioRule<>(MainActivityAdmin.class);

    @Before
    public void setup() {
        // Initialize the Intents API for intent verification
        Intents.init();
    }

    @After
    public void cleanup() {
        // Release the Intents API resources
        Intents.release();
    }

    @Test
    public void testLogoutButton() {
        // Check if the Logout button is displayed
        Espresso.onView(ViewMatchers.withId(R.id.logout))
                .check(matches(isDisplayed()));

        // Perform a click on the Logout button
        Espresso.onView(ViewMatchers.withId(R.id.logout))
                .perform(click());

        // Verify that the Login activity is started
        Intents.intended(IntentMatchers.hasComponent(Login.class.getName()));
    }

    @Test
    public void testScanButton() {
        // Check if the Scan button is displayed
        Espresso.onView(withId(R.id.scan))
                .check(matches(isDisplayed()));

        // Perform a click on the Scan button
        Espresso.onView(withId(R.id.scan))
                .perform(click());

        // TODO: Add verification steps for the scanning functionality
        // For example, you can check if the scan results are displayed correctly in the UI.
    }
}
