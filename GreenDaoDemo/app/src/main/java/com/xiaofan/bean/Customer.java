package com.xiaofan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

@Entity
public class Customer implements Serializable {
    @Id
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 470110355)
    public Customer(Long id) {
        this.id = id;
    }

    @Generated(hash = 60841032)
    public Customer() {

    }
}