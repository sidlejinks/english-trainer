package com.dtorianik.english.trainer.converters.impl;

import com.dtorianik.english.trainer.converters.Converter;
import com.dtorianik.english.trainer.domain.Language;
import com.dtorianik.english.trainer.domain.LanguageItem;
import com.dtorianik.english.trainer.domain.LanguageItemType;
import com.dtorianik.english.trainer.domain.TranslationOptions;
import com.dtorianik.english.trainer.dto.AddItemFormDto;
import org.apache.tika.language.LanguageIdentifier;
import org.springframework.stereotype.Component;

/**
 * Created by dtorianik on 7/16/2015.
 */
@Component(value = "addItemFormToLanguageItemConverter")
public class AddItemFormToLanguageItemConverter implements Converter<AddItemFormDto, LanguageItem> {

    @Override
    public LanguageItem convert(AddItemFormDto from) {
        LanguageItemType type = resolveItemType(from.getOriginal());
        return new LanguageItem(from.getOriginal(), from.getTranslation(),
                                resolveTranslationOptions(from), type);
    }

    private TranslationOptions resolveTranslationOptions(AddItemFormDto from) {
        // move this to Spring bean (factory)
        LanguageIdentifier identifier = new LanguageIdentifier(from.getOriginal());
        Language originalLanguage = createLanguage(identifier);
        identifier = new LanguageIdentifier(from.getTranslation());
        Language translationLanguage = createLanguage(identifier);
        return new TranslationOptions(originalLanguage, translationLanguage);
    }

    private Language createLanguage(LanguageIdentifier identifier) {
        Language result = Language.valueOf(identifier.getLanguage());
        return (result != null) ? result : Language.UNKNOWN;
    }

    private LanguageItemType resolveItemType(String item) {
        int startIndex = 0;

        if (item.startsWith("a ")) {
            startIndex = 2;
        } else if (item.startsWith("the ")) {
            startIndex = 4;
        }

        return (item.substring(startIndex).contains(" ")) ? LanguageItemType.PHRASE : LanguageItemType.WORD;
    }
}
