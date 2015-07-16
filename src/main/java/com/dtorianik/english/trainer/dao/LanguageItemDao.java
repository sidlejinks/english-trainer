package com.dtorianik.english.trainer.dao;

import com.dtorianik.english.trainer.domain.LanguageItem;

import java.util.List;

/**
 * Created by dtorianik on 7/16/2015.
 */
public interface LanguageItemDao {
    void save(LanguageItem item);
    List<LanguageItem> find();
}
