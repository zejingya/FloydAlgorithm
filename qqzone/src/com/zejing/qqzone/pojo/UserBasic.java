package com.zejing.qqzone.pojo;

import java.util.List;

public class UserBasic {

    private Integer id;
    private String loginId;
    private String nickName;
    private String pwd;
    private String headlmg;

    private UserDetail userDetail;//
    private List<Topic> topicList;//主页信息
    private List<UserBasic> friendList;//好友列表


    public UserBasic() {}

    public UserBasic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(final String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(final String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }

    public String getHeadlmg() {
        return this.headlmg;
    }

    public void setHeadlmg(final String headlmg) {
        this.headlmg = headlmg;
    }

    public UserDetail getUserDetail() {
        return this.userDetail;
    }

    public void setUserDetail(final UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Topic> getTopicList() {
        return this.topicList;
    }

    public void setTopicList(final List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<UserBasic> getFriendList() {
        return this.friendList;
    }

    public void setFriendList(final List<UserBasic> friendList) {
        this.friendList = friendList;
    }
}
