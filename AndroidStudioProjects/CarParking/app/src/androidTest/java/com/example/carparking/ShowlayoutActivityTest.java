package com.example.carparking;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.carparking.showlayout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ShowlayoutActivityTest {

    @Rule
    public ActivityTestRule<showlayout> activityRule = new ActivityTestRule<>(showlayout.class);

    @Test
    public void verifyGridViewIsDisplayed() {
        // Check if the GridView is displayed
        Espresso.onView(ViewMatchers.withId(R.id.simpleGridView)).check(matches(isDisplayed()));
    }

    @Test
    public void verifyGridItemClick() {
        // Perform a click on a grid item and verify the behavior
        Espresso.onData(withId(R.id.simpleGridView)).inAdapterView(withId(R.id.simpleGridView));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // For example, check if a dialog or new activity is launched
    }

    // Add more test methods to cover other aspects of the activity's behavior

}
