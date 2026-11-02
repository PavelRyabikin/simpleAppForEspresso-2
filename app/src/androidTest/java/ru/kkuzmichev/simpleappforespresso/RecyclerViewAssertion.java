package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;

import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

import static org.hamcrest.Matchers.instanceOf;

public class RecyclerViewAssertion implements ViewAssertion {

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        Matcher<View> matcher = instanceOf(RecyclerView.class);

        if (!matcher.matches(view)) {
            throw new AssertionError(
                    "View не является RecyclerView: " +
                            StringDescription.asString(matcher)
            );
        }
    }
}