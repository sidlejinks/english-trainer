package com.dtorianik.english.trainer.domain;

/**
 * Created by dtorianik on 9/9/2015.
 */
public enum GenderType {
    M("Male"),
    F("Female"),
    UNKNOWN("Unknown");

    private String description;

    GenderType(String description) {
        this.description = description;
    }
}
