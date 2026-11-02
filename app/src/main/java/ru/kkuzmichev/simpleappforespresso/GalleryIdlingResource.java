package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.idling.CountingIdlingResource;

public class GalleryIdlingResource {

    public static final CountingIdlingResource countingIdlingResource =
            new CountingIdlingResource("Gallery loading");
}