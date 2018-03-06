package com.oneToMany_bfk;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/3/1.
 * 学生实体类,测试1对多双向映射
 */
@Entity()
public class Students implements Serializable {

    private static final long serialVersionUID = -8019929135094013110L;

    private int sid;//学号
    private String sname;//学生姓名
    private String gender;//性别
    private Date birthday;//出生日期
    private String major;//专业

    private ClassRoom classRoom;//多方持有一方的引用

    public Students() {
    }

    public Students(String sname,String gender, Date birthday, String major) {
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
    }

    @Id
    @GeneratedValue
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "cid",referencedColumnName = "CID")
    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}

