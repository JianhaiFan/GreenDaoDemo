package com.xiaofan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by fanjianhai on 2017/2/16.
 */
@Entity
public class Picture implements Serializable {
    @Id
    private Long id;
    @Property
    private long customerId;
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 185136503)
    public Picture(Long id, long customerId) {
        this.id = id;
        this.customerId = customerId;
    }
    @Generated(hash = 1602548376)
    public Picture() {
    }

}
