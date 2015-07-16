package com.dtorianik.english.trainer.service.impl;

import com.dtorianik.english.trainer.converters.Converter;
import com.dtorianik.english.trainer.dao.LanguageItemDao;
import com.dtorianik.english.trainer.domain.LanguageItem;
import com.dtorianik.english.trainer.dto.AddItemFormDto;
import com.dtorianik.english.trainer.service.LanguageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dtorianik on 7/16/2015.
 */
@Service
public class DefaultLanguageItemService implements LanguageItemService {

    @Autowired
    private LanguageItemDao languageItemDao;

    @Autowired
    @Qualifier("addItemFormToLanguageItemConverter")
    private Converter<AddItemFormDto, LanguageItem> addItemFormConverter;

    @Override
    public void save(AddItemFormDto item) {
        languageItemDao.save(addItemFormConverter.convert(item));
    }

    @Override
    public List<LanguageItem> find() {
        return languageItemDao.find();
    }
}
