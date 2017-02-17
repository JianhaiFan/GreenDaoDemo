package com.xiaofan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author: 范建海
 * @createTime: 2017/2/13 15:49
 * @className:  Person
 * @description: 个人信息实体Bean
 * @changed by:
 */
@Entity(nameInDb = "Person")
public class Person implements Serializable {

    @Id
    private String id;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "age")
    private int age;
    @Property
    private String hobby;

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getHobby() {
        return this.hobby;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    @Generated(hash = 849545290)
    public Person(String id, String name, int age, String hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }

    


}
