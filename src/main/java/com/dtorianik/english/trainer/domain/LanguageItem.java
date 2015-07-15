package com.dtorianik.english.trainer.domain;

/**
 * @author Dmytro Torianik
 * @since 1.0
 */
public class LanguageItem {

    private String id;
    private String content;
    private LanguageItemType type;

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LanguageItemType getType() {
        return type;
    }

    public void setType(LanguageItemType type) {
        this.type = type;
    }
}
