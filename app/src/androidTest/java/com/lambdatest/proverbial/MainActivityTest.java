package com.lambdatest.proverbial;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    /**
     * Use {@link ActivityScenarioRule} androi This is a replacement for {@link androidx.test.rule.ActivityTestRule}.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkTitleText() throws  InterruptedException {
        Thread.sleep(3000);
        //validate title is displayed and have content as expected
        onView(withId(R.id.Textbox)).check(matches(isDisplayed()));
        onView(withId(R.id.Textbox)).check(matches(withText("Hello! Welcome to lambdatest Sample App called Proverbial")));

        //click on Text button
        onView(withId(R.id.Text)).perform(click());
        onView(withId(R.id.Textbox)).check(matches(withText("Proverbial")));

    }

    @Test
    public void isActivityInView() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.color)).check(matches(isDisplayed()));
        onView(withId(R.id.navigationBar)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfTextBtnIsClicked() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.Text)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.Textbox)).check(matches(withText("Proverbial")));

    }

    @Test
    public void checkIfSpeedTestPageIsDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.speedTest)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.find)).check(matches(isDisplayed()));
    }

}