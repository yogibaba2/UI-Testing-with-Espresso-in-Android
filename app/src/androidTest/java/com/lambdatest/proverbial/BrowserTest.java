package com.lambdatest.proverbial;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.*;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(AndroidJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BrowserTest {

    @Before
    public void registerIdlingResource(){
        IdlingResource idlingResource = new CountingIdlingResource("resource_name");
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @Test
    public void checkBrowserPageIsOpened() throws InterruptedException {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Thread.sleep(3000);
        onView(withId(R.id.webview)).perform(click());
        Thread.sleep(3000);
        onView(withId(R.id.find)).check(matches(isDisplayed()));
    }

    @Test
    public void openURLInBrowser() throws InterruptedException {
        ActivityScenario activityScenario = ActivityScenario.launch(MainActivity.class);
        Thread.sleep(2000);
        onView(withId(R.id.webview)).perform(click());
        Thread.sleep(2000);

        onView(withId(R.id.url)).perform(typeText("https://mfml.in/api/getInfo"));
        Thread.sleep(2000);
        onView(withId(R.id.find)).perform(click());
        Thread.sleep(2000);
    }


}