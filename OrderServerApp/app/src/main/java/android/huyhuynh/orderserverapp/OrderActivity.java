package android.huyhuynh.orderserverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.huyhuynh.orderserverapp.model.DanhSachOrder;
import android.huyhuynh.orderserverapp.model.DanhSachOrderAdapter;
import android.huyhuynh.orderserverapp.model.MenuOrder;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    ListView lvOrder;
    DanhSachOrderAdapter mOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        init();
    }

    private void init() {
        lvOrder = findViewById(R.id.listViewOrder);

        //Test
        MenuOrder menuOrder1 = new MenuOrder("Nước Cam 1",2, (double) 48000);
        MenuOrder menuOrder2 = new MenuOrder("Nước Cam 2",2, (double) 48000);
        MenuOrder menuOrder3 = new MenuOrder("Nước Cam 3",2, (double) 48000);
        MenuOrder menuOrder4 = new MenuOrder("Nước Cam 4",2, (double) 48000);
        MenuOrder menuOrder5 = new MenuOrder("Nước Cam 5",2, (double) 48000);
        MenuOrder menuOrder6 = new MenuOrder("Nước Cam 6",2, (double) 48000);

        List<MenuOrder> listMenu1  = new ArrayList<>();
        listMenu1.add(menuOrder1);
        listMenu1.add(menuOrder2);
        listMenu1.add(menuOrder3);
        DanhSachOrder danhSachOrder1 = new DanhSachOrder("-2137966662","Bàn số 3", listMenu1, (double) (48000*3));

        List<MenuOrder> listMenu2  = new ArrayList<>();
        listMenu2.add(menuOrder4);
        listMenu2.add(menuOrder5);
        listMenu2.add(menuOrder6);
        DanhSachOrder danhSachOrder2 = new DanhSachOrder("-2138252421","Bàn số 5", listMenu2, (double) (48000*4));

        List<DanhSachOrder> arOrders = new ArrayList<>();
        arOrders.add(danhSachOrder1);
        arOrders.add(danhSachOrder2);

        mOrderAdapter = new DanhSachOrderAdapter(OrderActivity.this,R.layout.item_listview_order,arOrders);
        lvOrder.setAdapter(mOrderAdapter);

    }
}
