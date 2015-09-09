package com.dtorianik.english.trainer.dao.impl;

import com.dtorianik.english.trainer.dao.ApplicationUserDao;
import com.dtorianik.english.trainer.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoApplicationUserDao implements ApplicationUserDao {

    public static final String APP_USER_COLLECTION = "app_user";

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public ApplicationUser find(String username) {
        return mongoOperations.findOne(new Query(Criteria.where("username").is(username)), ApplicationUser.class);
    }
}
