package com.song.service;

import com.song.mapper.CovidAndChargeMapper;
import com.song.pojo.CovidAndCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidAndChargeServiceImp {
    @Autowired
    CovidAndChargeMapper cac;
    public List<CovidAndCharge> findCovidAndChargeAll() {
        return cac.findCovidAndChargeAll();
    }

    public Boolean updateCovidAndCharge(CovidAndCharge c) {
        return cac.updateCovidAndCharge(c);
    }
}
