package com.xiaofan.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.xiaofan.bean.Person;
import com.xiaofan.bean.Order;
import com.xiaofan.bean.Customer;
import com.xiaofan.bean.User;
import com.xiaofan.bean.Picture;

import com.xiaofan.greendao.PersonDao;
import com.xiaofan.greendao.OrderDao;
import com.xiaofan.greendao.CustomerDao;
import com.xiaofan.greendao.UserDao;
import com.xiaofan.greendao.PictureDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig personDaoConfig;
    private final DaoConfig orderDaoConfig;
    private final DaoConfig customerDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig pictureDaoConfig;

    private final PersonDao personDao;
    private final OrderDao orderDao;
    private final CustomerDao customerDao;
    private final UserDao userDao;
    private final PictureDao pictureDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        personDaoConfig = daoConfigMap.get(PersonDao.class).clone();
        personDaoConfig.initIdentityScope(type);

        orderDaoConfig = daoConfigMap.get(OrderDao.class).clone();
        orderDaoConfig.initIdentityScope(type);

        customerDaoConfig = daoConfigMap.get(CustomerDao.class).clone();
        customerDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        pictureDaoConfig = daoConfigMap.get(PictureDao.class).clone();
        pictureDaoConfig.initIdentityScope(type);

        personDao = new PersonDao(personDaoConfig, this);
        orderDao = new OrderDao(orderDaoConfig, this);
        customerDao = new CustomerDao(customerDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        pictureDao = new PictureDao(pictureDaoConfig, this);

        registerDao(Person.class, personDao);
        registerDao(Order.class, orderDao);
        registerDao(Customer.class, customerDao);
        registerDao(User.class, userDao);
        registerDao(Picture.class, pictureDao);
    }
    
    public void clear() {
        personDaoConfig.clearIdentityScope();
        orderDaoConfig.clearIdentityScope();
        customerDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
        pictureDaoConfig.clearIdentityScope();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public PictureDao getPictureDao() {
        return pictureDao;
    }

}