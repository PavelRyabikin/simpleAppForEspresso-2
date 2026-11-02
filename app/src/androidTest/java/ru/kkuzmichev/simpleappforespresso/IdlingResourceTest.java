package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class IdlingResourceTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(
                GalleryIdlingResource.countingIdlingResource
        );
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(
                GalleryIdlingResource.countingIdlingResource
        );
    }

    @Test
    public void checkGalleryItemSeven() {
        onView(withContentDescription(R.string.navigation_drawer_open))
                .perform(click());

        onView(withId(R.id.nav_gallery))
                .perform(click());

        onView(allOf(
                withId(R.id.item_number),
                withText("7")
        )).check(matches(isDisplayed()));

        onView(withId(R.id.recycle_view))
                .check(matches(new RecyclerViewItemCountMatcher(10)))
                .check(new RecyclerViewAssertion());
    }
}