package com.example;

import java.io.Serializable;

/**
 * Created by mac on 16/4/1.
 */
public class StudentModel {
    // 学号,姓名,性别,年级,班级
    private long stuId;
    private String stuName;
    private String sex;
    private long grand;
    private String classmate;

    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getGrand() {
        return grand;
    }

    public void setGrand(long grand) {
        this.grand = grand;
    }

    public String getClassmate() {
        return classmate;
    }

    public void setClassmate(String classmate) {
        this.classmate = classmate;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", sex='" + sex + '\'' +
                ", grand=" + grand +
                ", classmate='" + classmate + '\'' +
                '}';
    }
}
