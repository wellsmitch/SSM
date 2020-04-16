package com.song.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private String uuid;
	private Integer id;
	private String username;
    private String nickName;
    private String password;
    private String qqcode;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    private String openid;
    private String QQPicURL;

    public String getQqcode() {
        return qqcode;
    }

    public void setQqcode(String qqcode) {
        this.qqcode = qqcode;
    }

    public String getQQPicURL() {
        return QQPicURL;
    }

    public void setQQPicURL(String QQPicURL) {
        this.QQPicURL = QQPicURL;
    }

    public String getQQpic() {
        return QQpic;
    }

    public void setQQpic(String QQpic) {
        this.QQpic = QQpic;
    }

    private String QQpic;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private MultipartFile file;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	private String sex;
	private String address;
	private Date datee;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}


    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", address=" + address + ", datee=" + datee
				+ "]";
	}

}
