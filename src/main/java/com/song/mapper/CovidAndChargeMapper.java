package com.song.mapper;

import com.song.pojo.CovidAndCharge;

import java.util.List;

public interface CovidAndChargeMapper {
    List<CovidAndCharge> findCovidAndChargeAll();
    Boolean updateCovidAndCharge(CovidAndCharge covidAndCharge);
}
