package com.song.pojo;

import java.io.Serializable;

public class WeiXin implements Serializable {

    private static final long serialVersionUID = -2091815554677663339L;


    private String timestamp; // 必填，生成签名的时间戳
    private String nonce; // 必填，生成签名的随机串

    private String signature; // 必填，签名
    private String other; // 必填，签名

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
