package com.example.carparking;
import android.widget.Toast;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.example.carparking.R;
import com.example.carparking.register;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class RegisterActivityTest {

    @Rule
    public ActivityScenarioRule<register> activityRule = new ActivityScenarioRule<>(register.class);

    @Test
    public void testValidVehicleNumber() {
        // Enter a valid vehicle number
        Espresso.onView(ViewMatchers.withId(R.id.vehicle_no)).perform(ViewActions.typeText("KA20MA2345"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Perform button click
        Espresso.onView(ViewMatchers.withId(R.id.book_lots)).perform(ViewActions.click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verify that the MainActivity is launched
        Espresso.onView(ViewMatchers.withId(R.id.simpleGridView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidVehicleNumber() {
        // Enter an invalid vehicle number
        Espresso.onView(ViewMatchers.withId(R.id.vehicle_no)).perform(ViewActions.typeText("Invalid"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Perform button click
        Espresso.onView(ViewMatchers.withId(R.id.book_lots)).perform(ViewActions.click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Verify that a toast message is displayed
        Espresso.onView(ViewMatchers.withText("Invalid Vehicle No!!!"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
