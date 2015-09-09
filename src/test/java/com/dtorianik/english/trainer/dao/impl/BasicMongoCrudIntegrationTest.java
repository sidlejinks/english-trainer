package com.dtorianik.english.trainer.dao.impl;

import com.dtorianik.english.trainer.dao.ApplicationUserDao;
import com.dtorianik.english.trainer.dao.LanguageItemDao;
import com.dtorianik.english.trainer.domain.ApplicationUser;
import com.dtorianik.english.trainer.domain.GenderType;
import com.dtorianik.english.trainer.domain.LanguageItem;
import com.dtorianik.english.trainer.domain.LanguageItemType;
import com.dtorianik.english.trainer.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by dtorianik on 7/16/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class BasicMongoCrudIntegrationTest {

    @Autowired
    private LanguageItemDao languageItemDao;
    @Autowired
    private ApplicationUserDao applicationUserDao;

    @Autowired
    private MongoOperations mongoOperations;

    @Test
    public void insertAndFindLanguageItemTest() {
        languageItemDao.save(new LanguageItem("Hello", "Привет", LanguageItemType.WORD));
        languageItemDao.save(new LanguageItem("How are you?", "Как дела?", LanguageItemType.PHRASE));
        findAllAndAssertEquals(2);
    }

    @Test
    public void removeLanguageItemsTest() {
        mongoOperations.remove(new Query(), LanguageItem.class);
        findAllAndAssertEquals(0);
    }

    @Test
    public void findDefaultUserTest() {
        ApplicationUser admin = applicationUserDao.find("admin");
        UserInfo adminInfo = admin.getInfo();
        assertEquals("Dmytro", adminInfo.getFirstName());
        assertEquals("Torianik", adminInfo.getLastName());
        assertSame(24, adminInfo.getAge());
        assertSame(GenderType.M, adminInfo.getGender());
    }

    private void findAllAndAssertEquals(int expected) {
        List<LanguageItem> languageItems = mongoOperations.findAll(LanguageItem.class);
        assertEquals("Wrong amount of test data in database!", expected, languageItems.size());
    }

}
