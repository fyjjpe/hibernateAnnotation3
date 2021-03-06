package com.oneToMany_bfk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yuanjie.fang on 2018/3/1.
 * 班级实体类
 */
@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name = "cid",strategy = "assigned")
    @Column(length = 4)
    private String cid;//班级编号

    private String cname;//班级名称

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Set<Students> stus;//一方持有多方的集合

    public ClassRoom() {
    }

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Students> getStus() {
        return stus;
    }

    public void setStus(Set<Students> stus) {
        this.stus = stus;
    }
}
