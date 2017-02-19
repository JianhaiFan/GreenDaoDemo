package com.xiaofan.application;

import android.app.Application;
import android.text.TextUtils;

import com.xiaofan.constant.CommonConstant;
import com.xiaofan.constant.SqlConstant;
import com.xiaofan.db.GreenDaoSqliteOpenHelper;
import com.xiaofan.greendao.DaoMaster;
import com.xiaofan.greendao.DaoSession;
import com.xiaofan.greendao.GreenDaoContext;
import com.xiaofan.util.ExternalStorageUtil;

/**
 * @author: 范建海
 * @createTime: 2017/2/13 15:02
 * @className:  GreenDaoApplication
 * @description: 应用程序类
 * @changed by:
 */
public class GreenDaoApplication extends Application {
    // 应用实例
    private static GreenDaoApplication instance;
    // DAO管理器实例
    private static DaoMaster daoMaster;
    // DAOsession
    private static DaoSession daoSession;
    // 数据库帮助类
    private static GreenDaoSqliteOpenHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    /**
     * 获取应用实例
     */
    public static GreenDaoApplication getInstance() {
        return instance;
    }

    /**
     * 获取DAO session
     * @param partyId 当前用户的唯一标识
     * @return
     */
    public static DaoSession getDaoSession(String partyId) {
        if(!TextUtils.isEmpty(partyId)) {
            // 数据库名称
            String dbName = SqlConstant.SQLITE_FILE_NAME + "_" + partyId + SqlConstant.DB_EXTENSION_NAME;
            // 实例为空，或者数据库文件不存在，需要重新创建数据库
            if (daoMaster == null || !ExternalStorageUtil.exists(CommonConstant.DB_PATH + dbName) ) {
                helper = new GreenDaoSqliteOpenHelper(new GreenDaoContext(instance), dbName);
                if (helper != null) {
                    daoMaster = new DaoMaster(helper.getWritableDatabase());
                }
            }

            if(daoMaster != null) {
                daoSession = daoMaster.newSession();
            }
        }

        return daoSession;
    }

}
