package com.manyToMany_fk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yuanjie.fang on 2018/3/6.
 * 教师实体类
 */
@Entity
public class Teachers implements Serializable{


    private static final long serialVersionUID = 2588139954954648068L;
    @Id
    @GeneratedValue(generator = "tid")
    @GenericGenerator(name = "tid",strategy = "assigned")
    @Column(length = 4)
    private String tid;//教师编号
    private String tname;//教师姓名

    public Teachers() {
    }

    public Teachers(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
