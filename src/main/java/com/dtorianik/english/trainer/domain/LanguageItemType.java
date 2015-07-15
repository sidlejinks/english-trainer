package com.dtorianik.english.trainer.domain;

public enum LanguageItemType {
    WORD("word"),
    PHRASE("phrase");

    private String typeName;

    LanguageItemType(String typeName) {
        this.typeName = typeName;
    }
}
