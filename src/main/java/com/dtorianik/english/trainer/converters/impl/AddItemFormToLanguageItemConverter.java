package com.dtorianik.english.trainer.converters.impl;

import com.dtorianik.english.trainer.converters.Converter;
import com.dtorianik.english.trainer.domain.LanguageItem;
import com.dtorianik.english.trainer.domain.LanguageItemType;
import com.dtorianik.english.trainer.dto.AddItemFormDto;
import org.springframework.stereotype.Component;

/**
 * Created by dtorianik on 7/16/2015.
 */
@Component(value = "addItemFormToLanguageItemConverter")
public class AddItemFormToLanguageItemConverter implements Converter<AddItemFormDto, LanguageItem> {

    @Override
    public LanguageItem convert(AddItemFormDto from) {
        LanguageItemType type = resolveLanguageItemType(from.getOriginal());
        return new LanguageItem(from.getOriginal(), from.getTranslation(), type);
    }

    private LanguageItemType resolveLanguageItemType(String item) {
        int startIndex = 0;

        if (item.startsWith("a ")) {
            startIndex = 2;
        } else if (item.startsWith("the ")) {
            startIndex = 4;
        }

        return (item.substring(startIndex).contains(" ")) ? LanguageItemType.PHRASE : LanguageItemType.WORD;
    }
}
