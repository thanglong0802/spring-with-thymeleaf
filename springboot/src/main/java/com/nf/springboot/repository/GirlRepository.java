package com.nf.springboot.repository;

import com.nf.springboot.model.Girl;

public interface GirlRepository {
    Girl getGirlByNameAndID(int id, String name);
}
