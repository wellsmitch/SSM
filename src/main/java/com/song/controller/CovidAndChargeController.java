package com.song.controller;

import com.song.pojo.CovidAndCharge;
import com.song.service.CovidAndChargeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CovidAndChargeController {
    @Autowired
    CovidAndChargeServiceImp covidAndCharge_;

//    @RequestMapping(value = "item/getCovid.action")
//    @ResponseBody
//    public Object userLoginRes() {
//        List<CovidAndCharge> cac = null;
//        cac = covidAndCharge_.findCovidAndChargeAll();
//        return cac;
//    }

    @RequestMapping(value = "item/updateCovid.action")
    @ResponseBody
    public void updateCovidMethod(@RequestBody CovidAndCharge covi) {//@ModelAttribute("CovidAndCharge") CovidAndCharge covi
        System.out.println(covi);
        Boolean cac = null;
        cac = covidAndCharge_.updateCovidAndCharge(covi);
//        return cac;
    }
}
