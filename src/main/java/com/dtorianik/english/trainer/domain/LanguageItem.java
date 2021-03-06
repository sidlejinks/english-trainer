package com.dtorianik.english.trainer.domain;

import com.dtorianik.english.trainer.dao.impl.MongoLanguageItemDao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import static com.dtorianik.english.trainer.dao.impl.MongoLanguageItemDao.LANGUAGE_ITEM_COLLECTION;
import static com.dtorianik.english.trainer.domain.Language.UNKNOWN;

/**
 * @author Dmytro Torianik
 * @since 1.0
 */
@Document(collection = LANGUAGE_ITEM_COLLECTION)
public class LanguageItem implements Serializable {

    @Id
    private String id;
    private String original;
    private String translation;
    private TranslationOptions options;
    private LanguageItemType type;

    public LanguageItem(String original, String translation, LanguageItemType type) {
        this.original = original;
        this.translation = translation;
        this.type = type;
        this.options = new TranslationOptions(UNKNOWN, UNKNOWN);
    }

    public LanguageItem(String original, String translation, TranslationOptions options, LanguageItemType type) {
        this.original = original;
        this.translation = translation;
        this.options = options;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public LanguageItemType getType() {
        return type;
    }

    public void setType(LanguageItemType type) {
        this.type = type;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public TranslationOptions getOptions() {
        return options;
    }

    public void setOptions(TranslationOptions options) {
        this.options = options;
    }
}
