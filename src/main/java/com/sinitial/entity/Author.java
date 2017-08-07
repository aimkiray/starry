package com.sinitial.entity;

import java.util.Date;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 *      ┏┓   ┏┓
 *     ┏┛┻━━━┛┻┓
 *     ┃       ┃
 *     ┃   ━   ┃
 *     ┃ ┳┛ ┗┳ ┃
 *     ┃       ┃
 *     ┃   ┻   ┃ Created by nekuata.
 *     ┃       ┃
 *     ┗━┓   ┏━┛ Code is far away from bug with the
 *       ┃   ┃   animal protecting.
 *       ┃   ┃   神兽保佑,代码无bug.
 *       ┃   ┗━━━┓
 *       ┃       ┣┓
 *       ┃       ┏┛
 *       ┗┓┓┏━┳┓┏┛
 *        ┃┫┫ ┃┫┫
 *        ┗┻┛ ┗┻┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */

public class Author {
    private int authorId;
    private String authorName;
    private String authorPassword;
    private String authorInfo;
    private Date authorDate;
    private List<Post> posts;

    public Author(int authorId, String authorName, String authorPassword, String authorInfo, Date authorDate, List<Post> posts) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorPassword = authorPassword;
        this.authorInfo = authorInfo;
        this.authorDate = authorDate;
        this.posts = posts;
    }

    public Author(String authorName, String authorPassword, String authorInfo, Date authorDate, List<Post> posts) {
        this.authorName = authorName;
        this.authorPassword = authorPassword;
        this.authorInfo = authorInfo;
        this.authorDate = authorDate;
        this.posts = posts;
    }

    public Author(int authorId, String authorName, String authorPassword, String authorInfo, Date authorDate) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorPassword = authorPassword;
        this.authorInfo = authorInfo;
        this.authorDate = authorDate;
    }

    public Author() {
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    public Date getAuthorDate() {
        return authorDate;
    }

    public void setAuthorDate(Date authorDate) {
        this.authorDate = authorDate;
    }

    public String getAuthorPassword() {
        return authorPassword;
    }

    public void setAuthorPassword(String authorPassword) {
        this.authorPassword = authorPassword;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorPassword='" + authorPassword + '\'' +
                ", authorInfo='" + authorInfo + '\'' +
                ", authorDate=" + authorDate +
                '}';
    }
}
