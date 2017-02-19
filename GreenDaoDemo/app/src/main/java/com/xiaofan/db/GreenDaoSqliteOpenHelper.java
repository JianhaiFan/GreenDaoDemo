package com.xiaofan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.xiaofan.greendao.DaoMaster;
import com.xiaofan.greendao.MigrationHelper;
import com.xiaofan.greendao.UserBeanDao;
import com.xiaofan.util.LogUtil;


/**
 * @author: 范建海
 * @createTime: 2017/2/13 15:59
 * @className:  GreenDaoSqliteOpenHelper
 * @description: 数据库帮助类
 * @changed by:
 */

public class GreenDaoSqliteOpenHelper extends DaoMaster.OpenHelper  {

    public GreenDaoSqliteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public GreenDaoSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            LogUtil.e("数据库升级了...");
            //数据迁移模块
            MigrationHelper.migrate(db,UserBeanDao.class);
        }

    }
}
