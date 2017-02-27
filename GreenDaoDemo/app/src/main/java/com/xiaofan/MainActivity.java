package com.xiaofan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xiaofan.application.GreenDaoApplication;
import com.xiaofan.bean.UserBean;
import com.xiaofan.greendao.R;
import com.xiaofan.greendao.UserBeanDao;
import com.xiaofan.util.LogUtil;

import org.greenrobot.greendao.query.Query;

public class MainActivity extends AppCompatActivity {

    private TextView tv_content;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    public void onClick(View view) {
        // 查询实体
        UserBeanDao userBeanDao = GreenDaoApplication.getDaoSession("1314520").getUserBeanDao();
        UserBean userBean1 = new UserBean(10000L,"张三","23");
        UserBean userBean2 = new UserBean(20000L,"张龙","26");
        userBeanDao.insertOrReplaceInTx(userBean1);
        userBeanDao.insertOrReplaceInTx(userBean2);


//        UserBean userBean = userBeanDao.queryBuilder().where(UserBeanDao.Properties.UserName.eq("张三")).unique();
//        LogUtil.e("userBean: " + userBean);

        Query<UserBean> query = userBeanDao.queryBuilder().where(UserBeanDao.Properties.UserName.eq("张龙")).build();
        query.setParameter(0,"张三");
        // 多线程是必须加此方法
//        query.forCurrentThread();
        UserBean userBean = query.unique();
        // 轻吹缓存
//        userBeanDao.detachAll();

//        userBean = userBeanDao.queryBuilder().where(UserBeanDao.Properties.UserName.eq("张三")).unique();
        LogUtil.e("userBean: " + userBean);

    }


}
