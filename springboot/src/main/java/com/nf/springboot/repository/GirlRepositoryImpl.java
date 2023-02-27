package com.nf.springboot.repository;

import com.nf.springboot.model.Girl;
import org.springframework.stereotype.Repository;

@Repository
public class GirlRepositoryImpl implements GirlRepository {

    @Override
    public Girl getGirlByNameAndID(int id, String name) {
        return new Girl(id, name);
    }
}
