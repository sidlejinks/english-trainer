package com.dtorianik.english.trainer.dao.impl;

import com.dtorianik.english.trainer.dao.LanguageItemDao;
import com.dtorianik.english.trainer.domain.LanguageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dtorianik on 7/16/2015.
 */
@Repository
public class MongoLanguageItemDao implements LanguageItemDao {

    @Autowired
    private MongoOperations mongoOperations;

    public static final String LANGUAGE_ITEM_COLLECTION = "language_item";

    @Override
    public void save(LanguageItem item) {
        mongoOperations.save(item, LANGUAGE_ITEM_COLLECTION);
    }

    @Override
    public List<LanguageItem> find() {
        return mongoOperations.findAll(LanguageItem.class, LANGUAGE_ITEM_COLLECTION);
    }
}
