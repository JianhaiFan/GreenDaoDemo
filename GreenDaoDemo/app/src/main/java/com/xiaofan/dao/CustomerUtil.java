package com.xiaofan.dao;

import com.xiaofan.application.GreenDaoApplication;
import com.xiaofan.bean.Customer;
import com.xiaofan.constant.CommonConstant;
import com.xiaofan.constant.SqlConstant;
import com.xiaofan.greendao.CustomerDao;
import com.xiaofan.util.ExternalStorageUtil;
import com.xiaofan.util.LogUtil;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by fanjianhai on 2017/2/16.
 */
public class CustomerUtil {

    private static CustomerDao customerDao;

    private static void getCustomerDao() {
        String partyId = "10086";
        String dbName = SqlConstant.SQLITE_FILE_NAME + "_" + partyId + SqlConstant.DB_EXTENSION_NAME;
        if(customerDao == null || !ExternalStorageUtil.exists(CommonConstant.DB_PATH + dbName)) {
            customerDao = GreenDaoApplication.getDaoSession(partyId).getCustomerDao();
        }
    }

    /**
     * 插入一条记录
     * @param customers 实体
     */
    public static void insertPersons(List<Customer> customers) {
        if (customers != null && customers.size() > 0) {
            getCustomerDao();
            customerDao.insertOrReplaceInTx(customers);
        }
    }

    public static void show(List<Customer> orders) {
        LogUtil.e("========================");
        if (orders != null && orders.size() > 0) {
            for (Customer o : orders) {
                LogUtil.e("Id: " + o.getId() + "\n");
            }
        }
        LogUtil.e("========================");
    }


    /**
     * 查询记录
     * @param arg0          条件
     * @param conditions    条件内容
     * @return
     */
    public static List<Customer> queryOrders(WhereCondition arg0, WhereCondition... conditions) {
        List<Customer> persons = null;
        getCustomerDao();
        QueryBuilder<Customer> qb = customerDao.queryBuilder();
        if(arg0 != null && conditions != null) {
            qb.where(arg0, conditions);
        }
        persons = qb.list();

        return persons;
    }

}
