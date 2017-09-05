package com.sinitial.domain;

public class PostTagLink {
    private Integer postTagId;

    private Integer postId;

    private Integer tagId;

    public Integer getPostTagId() {
        return postTagId;
    }

    public void setPostTagId(Integer postTagId) {
        this.postTagId = postTagId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}