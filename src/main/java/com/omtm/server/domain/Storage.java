package com.omtm.server.domain;

public enum Storage {
    FRIDGE("FRIDGE"), FREEZER("FREEZER"), ROOM("ROOM");

    private final String text;

    Storage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
