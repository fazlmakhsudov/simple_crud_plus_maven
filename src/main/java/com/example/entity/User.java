package com.example.entity;

import java.util.Objects;

/**
 * bean class, entity class it keeps data of User objects
 */
public class User extends Entity {
    private String mName;
    private String mSurName;
    private int mAge;

    public User() {
    }

    public User(String mName, String mSurName, int mAge) {
        this.mName = mName;
        this.mSurName = mSurName;
        this.mAge = mAge;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurName() {
        return mSurName;
    }

    public void setmSurName(String mSurName) {
        this.mSurName = mSurName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return mId == user.mId &&                           // I think it would be better to exclude mId from equals()
                Objects.equals(mName, user.mName) &&
                Objects.equals(mSurName, user.mSurName) &&
                (mAge == user.mAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mSurName, mAge);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + mId +
                ", mName='" + mName + '\'' +
                ", mSurName='" + mSurName + '\'' +
                ", mAge=" + mAge +
                '}';
    }

    public static User valueOf(String name, String surName, int age) {
        return new User(name, surName, age);
    }
}