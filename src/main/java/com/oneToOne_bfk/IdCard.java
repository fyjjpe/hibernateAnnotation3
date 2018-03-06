package com.oneToOne_bfk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by yuanjie.fang on 2018/3/1.
 * 身份证类
 */
@Entity
public class IdCard {
    @Id
    @GeneratedValue(generator = "pid")
    @GenericGenerator(name = "pid", strategy = "assigned")
    @Column(length = 18)
    private String pid;//身份证号码

    private String sname;//学生姓名

    @OneToOne(mappedBy = "card")
    private Students stu;

    public IdCard() {
    }

    public IdCard(String pid, String sname) {
        this.pid = pid;
        this.sname = sname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Students getStu() {
        return stu;
    }

    public void setStu(Students stu) {
        this.stu = stu;
    }
}
