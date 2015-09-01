package com.dtorianik.english.trainer.dao;

import com.dtorianik.english.trainer.domain.ApplicationUser;

public interface ApplicationUserDao {
    ApplicationUser find(String username);
}
