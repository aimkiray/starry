package com.sinitial.entity;

import java.util.Date;

public class Post {
    private int postId;
    private String postTitle;
    private String postStatus;
    private String postType;
    private Author author;
    private String postContent;
    private String postMimeType;
    private Date postDate;

    public Post(int postId, String postTitle, String postStatus, String postType, Author author, String postContent, String postMimeType, Date postDate) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postStatus = postStatus;
        this.postType = postType;
        this.author = author;
        this.postContent = postContent;
        this.postMimeType = postMimeType;
        this.postDate = postDate;
    }

    public Post(String postTitle, String postStatus, String postType, Author author, String postContent, String postMimeType, Date postDate) {
        this.postTitle = postTitle;
        this.postStatus = postStatus;
        this.postType = postType;
        this.author = author;
        this.postContent = postContent;
        this.postMimeType = postMimeType;
        this.postDate = postDate;
    }

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", postType='" + postType + '\'' +
                ", author=" + author +
                ", postContent='" + postContent + '\'' +
                ", postMimeType='" + postMimeType + '\'' +
                '}';
    }
}
