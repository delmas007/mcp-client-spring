package com.example.datas_craping.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public final class SlugUtils {

    private SlugUtils() {
    }

    public static String slugify(String input) {
        final String slug = String.format("%s, %s", input, UUID.randomUUID());
        final Slugify slg = Slugify.builder().build();
        return slg.slugify(slug);
    }
}
