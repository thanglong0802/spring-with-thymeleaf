package com.nf.springboot.service;

import com.nf.springboot.model.Girl;
import com.nf.springboot.repository.GirlRepository;
//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {
    static int AUTO_ID = 0;
    @Autowired
    private GirlRepository girlRepository;

//    public Girl getRandomGirl() {
//        int id = AUTO_ID++;
//        String name = randomGirlName(10);
//        return girlRepository.getGirlByNameAndID(id, name);
//    }

//    private String randomGirlName(int i) {
//        return RandomStringUtils.randomAlphanumeric(i).toLowerCase();
//    }
}
