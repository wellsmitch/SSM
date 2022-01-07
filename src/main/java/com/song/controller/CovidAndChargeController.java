package com.song.controller;

import com.song.pojo.CovidAndCharge;
import com.song.pojo.ReadhubFavorite;
import com.song.service.CovidAndChargeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class CovidAndChargeController {
    @Autowired
    CovidAndChargeServiceImp covidAndCharge_;

    @RequestMapping(value = "item/getCovid.action")
    @ResponseBody
    public Object userLoginRes() {
        List<CovidAndCharge> cac = null;
        cac = covidAndCharge_.findCovidAndChargeAll();
        return cac;
    }

    @RequestMapping(value = "getCovid.action")
    @ResponseBody
    public Object userLoginRes1() {
        List<CovidAndCharge> cac = null;
        cac = covidAndCharge_.findCovidAndChargeAll();
        return cac;
    }

    @RequestMapping(value = "item/updateCovid.action")
    @ResponseBody
    public void updateCovidMethod(@RequestBody CovidAndCharge covi) {//@ModelAttribute("CovidAndCharge") CovidAndCharge covi
        System.out.println(covi);
        Boolean cac = null;
        cac = covidAndCharge_.updateCovidAndCharge(covi);
//        return cac;
    }

    @RequestMapping(value = "item/updateCovidByFormData.action")
    @ResponseBody
    public void updateCovidByFormData(CovidAndCharge covi) {//@ModelAttribute("CovidAndCharge") CovidAndCharge covi
        System.out.println(covi);
        Boolean cac = null;
        cac = covidAndCharge_.updateCovidAndCharge(covi);
//        return cac;
    }
    @RequestMapping(value = "item/getFavoriteList1.action")
    @ResponseBody
    public SimpleJsonResult getFavoriteList(String openId){
        List<ReadhubFavorite> cac = null;
        openId += "iopaasd";
        System.out.println(openId);
//        cac = readhubFavoriteServiceImpl.findReadhubFavoriteList(r);
        return new SimpleJsonResult(true, cac);
    }


    @RequestMapping(value = "item/deleteCovid.action")
    @ResponseBody
    public void deleteCovidMethod(@RequestBody CovidAndCharge covi1,CovidAndCharge covi, HttpServletRequest request,Date dateData) {//@ModelAttribute("CovidAndCharge") CovidAndCharge covi
        System.out.println(covi);
        System.out.println(covi1);
        System.out.println(dateData);
        System.out.println(request);

        Boolean cac = null;
        cac = covidAndCharge_.deleteCovidAndCharge(covi1);
//        return cac;
    }

    @RequestMapping(value = "item/insertCovid.action")
    @ResponseBody
    public void insertCovidMethod(@RequestBody CovidAndCharge covi) {//@ModelAttribute("CovidAndCharge") CovidAndCharge covi
        System.out.println(covi);
        Boolean cac = null;
        cac = covidAndCharge_.insertCovidAndCharge(covi);
//        return cac;
    }
}
