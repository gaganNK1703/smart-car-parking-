package com.example.carparking;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.ComponentNameMatchers;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;



import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class LoginTest {

    @Rule
    public ActivityScenarioRule<Login> activityRule = new ActivityScenarioRule<>(Login.class);

    @Before
    public void setup() {
        Intents.init();
    }

    @After
    public void cleanup() {
        Intents.release();
    }

    @Test
    public void loginTest() {
        // Perform login actions
        Espresso.onView(ViewMatchers.withId(R.id.email)).perform(ViewActions.typeText("gnk@gmail.com"));
        Espresso.onView(ViewMatchers.withId(R.id.password)).perform(ViewActions.typeText("1234567"));
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(ViewActions.click());

       // intending(toPackage(MainActivityAdmin.class.getPackage().getName()))
                //.respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));

        // Assert that the intended intent was sent
    //    intended(IntentMatchers.hasComponent(MainActivityAdmin.class.getName()));

        // TODO: Add assertions to verify the login result
        // For example, you can use Espresso.onView(...).check(...) to check if a certain view is displayed after login
        // or use IdlingResource to wait for asynchronous tasks to complete before checking the result.
    }
}
