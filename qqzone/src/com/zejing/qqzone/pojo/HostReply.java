package com.zejing.qqzone.pojo;

import java.util.Date;

public class HostReply {//主人的回复

    private Integer id;
    private String content;
    private Date hostReplyDate;
    private UserBasic author;
    private Reply reply;

    public HostReply() {}

    public HostReply(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Date getHostReplyDate() {
        return this.hostReplyDate;
    }

    public void setHostReplyDate(final Date hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public UserBasic getAuthor() {
        return this.author;
    }

    public void setAuthor(final UserBasic author) {
        this.author = author;
    }

    public Reply getReply() {
        return this.reply;
    }

    public void setReply(final Reply reply) {
        this.reply = reply;
    }
}
