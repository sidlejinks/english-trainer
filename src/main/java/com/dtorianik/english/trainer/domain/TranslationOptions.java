package com.dtorianik.english.trainer.domain;

/**
 * Created by dtorianik on 9/9/2015.
 */
public class TranslationOptions {

    private Language source;
    private Language target;

    public Language getSource() {
        return source;
    }

    public void setSource(Language source) {
        this.source = source;
    }

    public Language getTarget() {
        return target;
    }

    public void setTarget(Language target) {
        this.target = target;
    }
}
