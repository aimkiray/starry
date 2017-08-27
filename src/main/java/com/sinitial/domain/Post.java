package com.sinitial.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("post")
public class Post {
    private Integer postId;

    private String postTitle;

    private String postStatus;

    private String postType;

    private User user;

    private String postMimeType;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date postDate;

    private String postContent;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus == null ? null : postStatus.trim();
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    public User getPostAuthor() {
        return user;
    }

    public void setPostAuthor(User user) {
        this.user = user;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType == null ? null : postMimeType.trim();
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", postType='" + postType + '\'' +
                ", user=" + user +
                ", postMimeType='" + postMimeType + '\'' +
                ", postDate=" + postDate +
                ", postContent='" + postContent + '\'' +
                '}';
    }
}