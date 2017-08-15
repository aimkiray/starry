package com.sinitial.domain;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
@Component("post")
public class Post {
    private Integer postId;

    private String postTitle = "去找爱丽丝玩";

    private String postStatus;

    private String postType;

    @Resource(name = "author")
    private Author author;

    private String postMimeType;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", postType='" + postType + '\'' +
                ", author=" + author +
                ", postMimeType='" + postMimeType + '\'' +
                ", postDate=" + postDate +
                ", postContent='" + postContent + '\'' +
                '}';
    }
}