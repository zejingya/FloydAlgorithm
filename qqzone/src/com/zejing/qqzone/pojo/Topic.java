package com.zejing.qqzone.pojo;

import java.time.LocalDateTime;
import java.util.List;

public class Topic {//主页信息

    private Integer id;
    private String  title;
    private String content;
    private LocalDateTime topicDate;
    private UserBasic author;

    private List<Reply> replyList;


    public Topic() {}

    public Topic(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public LocalDateTime getTopicDate() {
        return this.topicDate;
    }

    public void setTopicDate(final LocalDateTime topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return this.author;
    }

    public void setAuthor(final UserBasic author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return this.replyList;
    }

    public void setReplyList(final List<Reply> replyList) {
        this.replyList = replyList;
    }
}
