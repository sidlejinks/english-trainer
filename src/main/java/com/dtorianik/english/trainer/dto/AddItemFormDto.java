package com.dtorianik.english.trainer.dto;

import java.io.Serializable;

/**
 * Created by dtorianik on 7/16/2015.
 */
public class AddItemFormDto implements Serializable {

    private String original;
    private String translation;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
