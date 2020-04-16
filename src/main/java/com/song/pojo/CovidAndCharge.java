package com.song.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

public class CovidAndCharge {
    /**
     *
     */
    private static final long serialVersionUID = 4517148792211901384L;

    private Integer id;
    private Integer zhengzhouInc;
    private Integer heNanInc;
    private Integer heNanRes;


    private Integer zhengZhouRes;
    private Integer dianfei;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZhengzhouInc() {
        return zhengzhouInc;
    }

    public void setZhengzhouInc(Integer zhengzhouInc) {
        this.zhengzhouInc = zhengzhouInc;
    }

    public Integer getHeNanInc() {
        return heNanInc;
    }

    public void setHeNanInc(Integer heNanInc) {
        this.heNanInc = heNanInc;
    }

    public Integer getHeNanRes() {
        return heNanRes;
    }

    public void setHeNanRes(Integer heNanRes) {
        this.heNanRes = heNanRes;
    }

    public Integer getZhengZhouRes() {
        return zhengZhouRes;
    }

    public void setZhengZhouRes(Integer zhengZhouRes) {
        this.zhengZhouRes = zhengZhouRes;
    }

    public Integer getDianfei() {
        return dianfei;
    }

    public void setDianfei(Integer dianfei) {
        this.dianfei = dianfei;
    }

    public Date getDateData() {
        return dateData;
    }

    public void setDateData(Date dateData) {
        this.dateData = dateData;
    }


    public float getElectronicCharge() {
        return electronicCharge;
    }

    public void setElectronicCharge(float electronicCharge) {
        this.electronicCharge = electronicCharge;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateData;
    private float electronicCharge;


}
