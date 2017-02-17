package com.xiaofan.dao;

import com.xiaofan.application.GreenDaoApplication;
import com.xiaofan.bean.Order;
import com.xiaofan.constant.CommonConstant;
import com.xiaofan.constant.SqlConstant;
import com.xiaofan.greendao.OrderDao;
import com.xiaofan.util.ExternalStorageUtil;
import com.xiaofan.util.LogUtil;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;

/**
 * Created by fanjianhai on 2017/2/16.
 */
public class OrderDaoUtil {

    private static OrderDao orderDao;

    private static void getOrderDao() {
        String partyId = "10086";
        String dbName = SqlConstant.SQLITE_FILE_NAME + "_" + partyId + SqlConstant.DB_EXTENSION_NAME;
        if(orderDao == null || !ExternalStorageUtil.exists(CommonConstant.DB_PATH + dbName)) {
            orderDao = GreenDaoApplication.getDaoSession(partyId).getOrderDao();
        }
    }

    /**
     * 插入一条记录
     * @param orders 实体
     */
    public static void insertPersons(List<Order>orders) {
        if (orders != null && orders.size() > 0) {
            getOrderDao();
            orderDao.insertOrReplaceInTx(orders);
        }
    }

    public static void show(List<Order> orders) {
        LogUtil.e("========================");
        if (orders != null && orders.size() > 0) {
            for (Order o : orders) {
                LogUtil.e("Id: " + o.getId() + ",customer: " + o.getCustomer() + ",customerId: " + o.getCustomerId() + "\n");
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
    public static List<Order> queryOrders(WhereCondition arg0, WhereCondition... conditions) {
        List<Order> persons = null;
        getOrderDao();
        QueryBuilder<Order> qb = orderDao.queryBuilder();
        if(arg0 != null && conditions != null) {
            qb.where(arg0, conditions);
        }
        persons = qb.list();

        return persons;
    }


}
