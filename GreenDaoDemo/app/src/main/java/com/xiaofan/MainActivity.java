package com.xiaofan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.xiaofan.bean.Customer;
import com.xiaofan.bean.Order;
import com.xiaofan.dao.CustomerUtil;
import com.xiaofan.dao.OrderDaoUtil;
import com.xiaofan.greendao.OrderDao;
import com.xiaofan.greendao.PersonDao;
import com.xiaofan.greendao.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    public void onClick(View view) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(10000L));
        customers.add(new Customer(20000L));
        CustomerUtil.insertPersons(customers);

        CustomerUtil.show(customers);

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L,10000));
        orders.add(new Order(2L,20000));
        OrderDaoUtil.insertPersons(orders);

        List<Order> os = OrderDaoUtil.queryOrders(null,null);
        Order order = os.get(0);
        order.setCustomer(new Customer(30000L));
        OrderDaoUtil.show(os);







    }


}
