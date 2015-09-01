package com.dtorianik.english.trainer.domain;

import com.dtorianik.english.trainer.dao.impl.DefaultApplicationUserDao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

import static com.dtorianik.english.trainer.dao.impl.DefaultApplicationUserDao.APP_USER_COLLECTION;
import static com.dtorianik.english.trainer.dao.impl.MongoLanguageItemDao.LANGUAGE_ITEM_COLLECTION;

@Document(collection = APP_USER_COLLECTION)
public class ApplicationUser {

    @Id
    private String id;
    private String username;
    private String password;
    private List<String> groups;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getGroups() {
        return Collections.unmodifiableList(groups);
    }
}
