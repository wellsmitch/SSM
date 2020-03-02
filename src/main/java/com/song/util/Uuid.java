package com.song.util;

import java.util.UUID;
public class Uuid {
    private static String Uuid;

    static String getUuid() {
        Uuid = UUID.randomUUID().toString();
        return Uuid;
    }

}
