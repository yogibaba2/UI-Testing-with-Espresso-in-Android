package com.lambdatest.proverbial;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void checkTitleText() throws  InterruptedException {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
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
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Thread.sleep(3000);
        onView(withId(R.id.color)).check(matches(isDisplayed()));
        onView(withId(R.id.navigationBar)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfTextBtnIsClicked() throws InterruptedException {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Thread.sleep(3000);
        onView(withId(R.id.Text)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.Textbox)).check(matches(withText("Proverbial")));

    }

    @Test
    public void checkIfSpeedTestPageIsDisplayed() throws InterruptedException {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Thread.sleep(3000);
        onView(withId(R.id.speedTest)).perform(click());
        Thread.sleep(2000);
        onView(withId(R.id.find)).check(matches(isDisplayed()));
    }

}