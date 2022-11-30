package com.zejing.qqzone.pojo;

import java.sql.Date;

public class UserDetail {

    private Integer id;
    private String realName;
    private String tel;
    private String email;
    private Date birth;
    private String star;

    public UserDetail() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(final String realName) {
        this.realName = realName;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(final String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getBirth() {
        return this.birth;
    }

    public void setBirth(final Date birth) {
        this.birth = birth;
    }

    public String getStar() {
        return this.star;
    }

    public void setStar(final String star) {
        this.star = star;
    }
}
