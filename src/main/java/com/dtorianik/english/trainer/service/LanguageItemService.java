package com.dtorianik.english.trainer.service;

import com.dtorianik.english.trainer.domain.LanguageItem;
import com.dtorianik.english.trainer.dto.AddItemFormDto;

import java.util.List;

/**
 * Created by dtorianik on 7/16/2015.
 */
public interface LanguageItemService {
    void save(AddItemFormDto item);
    List<LanguageItem> find();
}
