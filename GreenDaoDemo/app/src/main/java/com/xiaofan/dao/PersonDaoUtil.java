package com.xiaofan.dao;

import android.text.TextUtils;

import com.xiaofan.application.GreenDaoApplication;
import com.xiaofan.bean.Person;
import com.xiaofan.constant.CommonConstant;
import com.xiaofan.constant.SqlConstant;
import com.xiaofan.greendao.PersonDao;
import com.xiaofan.util.ExternalStorageUtil;
import com.xiaofan.util.LogUtil;

import org.greenrobot.greendao.query.DeleteQuery;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * @author: 范建海
 * @createTime: 2017/2/14 10:46
 * @className:  PersonDaoUtil
 * @description: 用户工具类
 * @changed by:
 */
public class PersonDaoUtil {

    private static PersonDao personDao;

    private static void getPersonDao() {
        String partyId = "10086";
        String dbName = SqlConstant.SQLITE_FILE_NAME + "_" + partyId + SqlConstant.DB_EXTENSION_NAME;
        if(personDao == null || !ExternalStorageUtil.exists(CommonConstant.DB_PATH + dbName)) {
            personDao = GreenDaoApplication.getDaoSession(partyId).getPersonDao();
        }
    }
    /**
     * 插入一条记录
     * @param person 实体
     */
    public static void insertPerson(Person person) {
        if (person != null) {
            getPersonDao();
            personDao.insertOrReplaceInTx(person);
        }
    }

    /**
     * 插入多条记录
     * @param persons 实体集合
     */
    public static void insertPersons(List<Person> persons){
        if(persons != null && persons.size() > 0) {
            getPersonDao();
            personDao.insertOrReplaceInTx(persons);
        }
    }

    /**
     * 删除一条记录
     * @param person 实体
     */
    public static void deletePerson(Person person) {
        if (person != null) {
            getPersonDao();
            personDao.delete(person);
        }
    }

    /**
     * 删除全部记录
     */
    public static void deleteAllPersons() {
        getPersonDao();
        personDao.deleteAll();
    }

    /**
     * 根据具体属性删除记录
     * @param name 名称
     */
    public static void deletePersonByName(String name) {
        if(!TextUtils.isEmpty(name)) {
            getPersonDao();
            QueryBuilder<Person> qb = personDao.queryBuilder();
            DeleteQuery<Person> bd = qb.where(PersonDao.Properties.Name.eq(name))
                    .buildDelete();
            bd.executeDeleteWithoutDetachingEntities();
        }
    }

    /**
     * 修改单条记录
     * @param person 实体
     */
    public static void updatePerson(Person person) {
        if (person != null) {
            getPersonDao();
            personDao.update(person);
        }
    }

    /**
     * 修改多条记录
     * @param persons 实体集合
     */
    public static void updatePersons(List<Person> persons) {
        if(persons != null && persons.size() > 0) {
            getPersonDao();
            personDao.updateInTx(persons);
        }
    }

    /**
     * 查询记录
     * @param arg0          条件
     * @param conditions    条件内容
     * @return
     */
    public static List<Person> queryPersons(WhereCondition arg0, WhereCondition... conditions) {
        List<Person> persons = null;
        getPersonDao();
        QueryBuilder<Person> qb = personDao.queryBuilder();
        if(arg0 != null && conditions != null) {
            qb.where(arg0, conditions);
        }
        persons = qb.list();

        return persons;
    }

    /**
     * 获取记录，并按照姓名升序排序
     * @return
     */
    public static List<Person> orderAscPerson() {
        getPersonDao();
        return personDao.queryBuilder().orderAsc(PersonDao.Properties.Age).list();
    }

    public static void show(List<Person> persons) {
        LogUtil.e("========================");
        if (persons != null && persons.size() > 0) {
            for (Person p : persons) {
                LogUtil.e("Id: " + p.getId() + ",name: " + p.getName() + ",age: " + p.getAge() + "\n");
            }
        }
        LogUtil.e("========================");
    }

}
