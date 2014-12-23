package com.company;

import com.sun.javafx.beans.annotations.NonNull;

public class Desease {
    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    private Skin skin;

    public Desease(@NonNull Skin skin) {
        this.skin = skin;
    }
}