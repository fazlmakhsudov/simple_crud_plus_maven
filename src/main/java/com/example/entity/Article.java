package com.example.entity;

import java.util.Objects;

/**
 * bean class, entity class it keeps data of Article objects
 */
public class Article extends Entity {
    private String mTitle;
    private String mText;
    private long mUser_id;

    public Article() {
    }

    public Article(String mTitle, String mText, long mUser_id) {
        this.mTitle = mTitle;
        this.mText = mText;
        this.mUser_id = mUser_id;
    }

    public Article(long id, String mTitle, String mText, long mUser_id) {
        super(id);
        this.mTitle = mTitle;
        this.mText = mText;
        this.mUser_id = mUser_id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public long getUser_id() {
        return mUser_id;
    }

    public void setUser_id(long mUser_id) {
        this.mUser_id = mUser_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return mUser_id == article.mUser_id && mId == article.mId &&
                Objects.equals(mTitle, article.mTitle) &&
                Objects.equals(mText, article.mText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle, mText, mUser_id);
    }

    @Override
    public String toString() {
        return "Article{" +
                "mTitle='" + mTitle + '\'' +
                ", mText='" + mText + '\'' +
                ", mUser_id=" + mUser_id +
                ", mId=" + mId +
                '}';
    }

    public boolean matchUserId(long user_id) {
        if (this.mUser_id == user_id) {
            return true;
        }
        return false;
    }

    public boolean matchTitle(String title) {
        if (this.mTitle == title) {
            return true;
        }
        return false;
    }

    public static Article valueOf(String title, String text, int user_id) {
        return new Article(title, text, user_id);
    }
}