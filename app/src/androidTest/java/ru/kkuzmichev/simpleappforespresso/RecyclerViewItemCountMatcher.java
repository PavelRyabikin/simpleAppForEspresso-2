package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;

public class RecyclerViewItemCountMatcher extends BoundedMatcher<View, RecyclerView> {

    private final int expectedCount;

    public RecyclerViewItemCountMatcher(int expectedCount) {
        super(RecyclerView.class);
        this.expectedCount = expectedCount;
    }

    @Override
    protected boolean matchesSafely(RecyclerView recyclerView) {
        return recyclerView.getAdapter().getItemCount() == expectedCount;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("RecyclerView должен содержать ")
                .appendValue(expectedCount)
                .appendText(" items");
    }
}