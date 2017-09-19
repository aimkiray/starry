package com.sinitial.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Post {
    private Integer postId;

    private String postTitle;

    private String postStatus;

    private Integer postAuthor;

    private String postMimeType;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date postDate;

    private String postType;

    private String postContent;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Integer getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Integer postAuthor) {
        this.postAuthor = postAuthor;
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

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }
}