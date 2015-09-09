package com.dtorianik.english.trainer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

import static com.dtorianik.english.trainer.dao.impl.MongoApplicationUserDao.APP_USER_COLLECTION;

@Document(collection = APP_USER_COLLECTION)
public class ApplicationUser {

    @Id
    private String id;
    private String username;
    private String password;
    private List<String> groups;
    private UserInfo info;

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

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }
}
