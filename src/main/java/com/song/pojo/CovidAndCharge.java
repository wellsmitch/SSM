package com.song.pojo;


import java.util.Date;

public class CovidAndCharge {
    /**
     *
     */
    private static final long serialVersionUID = 3L;

    private Integer id;
    private String zhengzhouInc;
    private String henNanInc;
    private String heNanRes;
    private String zhengZhouRes;
    private String dianfei;
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZhengzhouInc() {
        return zhengzhouInc;
    }

    public void setZhengzhouInc(String zhengzhouInc) {
        this.zhengzhouInc = zhengzhouInc;
    }

    public String getHenNanInc() {
        return henNanInc;
    }

    public void setHenNanInc(String henNanInc) {
        this.henNanInc = henNanInc;
    }

    public String getHeNanRes() {
        return heNanRes;
    }

    public void setHeNanRes(String heNanRes) {
        this.heNanRes = heNanRes;
    }

    public String getZhengZhouRes() {
        return zhengZhouRes;
    }

    public void setZhengZhouRes(String zhengZhouRes) {
        this.zhengZhouRes = zhengZhouRes;
    }

    public String getDianfei() {
        return dianfei;
    }

    public void setDianfei(String dianfei) {
        this.dianfei = dianfei;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
