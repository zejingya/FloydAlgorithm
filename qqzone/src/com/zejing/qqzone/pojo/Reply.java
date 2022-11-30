package com.zejing.qqzone.pojo;

import java.util.Date;


public class Reply {//其他人的回复

    private Integer id;
    private String content;
    private Date replyDate;
    private UserBasic author;
    private Topic topic;
    private HostReply hostReply;

    public Reply() {}

    public Reply(Integer id) {
        this.id = id;
    }

    public Reply(String content, Date replyDate, UserBasic author, Topic topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
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

    public Date getReplyDate() {
        return this.replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public UserBasic getAuthor() {
        return this.author;
    }

    public void setAuthor(final UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(final Topic topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return this.hostReply;
    }

    public void setHostReply(final HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
