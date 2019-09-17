package android.huyhuynh.orderapp.views;

import android.huyhuynh.orderapp.R;
import android.huyhuynh.orderapp.model.DataModel;
import android.huyhuynh.orderapp.model.Menu;
import android.huyhuynh.orderapp.model.Order;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends AppCompatActivity implements DataOrderDialog, DataModel {

    TextView txtBan, txtHuongdan;
    Button btnOrder;
    public static List<Order> arrOrder;
    public static List<Menu> arrMenuOrder;
    public double tonggia = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.menuNav:
                    txtHuongdan.setText("Kích chọn thức uống để order:");
                    fragment = new FragmentListMenu();
                    break;
                case R.id.orderNav:
                    txtHuongdan.setText("Đã chọn:");
                    fragment = new FragmentListOrder();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frameFragment,fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Thêm button ở bot
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameFragment,
                new FragmentListMenu()).commit();

        init();
    }

    private void init() {
        txtBan = findViewById(R.id.txtBan);
        txtHuongdan = findViewById(R.id.txtHuongdan);
        btnOrder = findViewById(R.id.btnOrder);
        arrOrder = new ArrayList<>();
        arrMenuOrder = new ArrayList<>();
    }

    @Override
    public void getGia(double gia) {
        tonggia = tonggia+gia;
        DecimalFormat format = new DecimalFormat("###,###");
        btnOrder.setText(format.format(tonggia)+"vnđ\nOrder Ngay!");
    }

    @Override
    public void addToListOrder(Order order, Menu menu) {
        int i;
        boolean check = false;
        for (i = 0; i < arrOrder.size(); i++){
            if (arrOrder.get(i).getMaThucUong().equals(order.getMaThucUong())){
                check=true;
                break;
            }
        }
        if (check){
            int soluong = arrOrder.get(i).getSoLuong()+order.getSoLuong();
            double giaca = arrOrder.get(i).getDonGiaOrder()+order.getDonGiaOrder();
            arrOrder.get(i).setSoLuong(soluong);
            arrOrder.get(i).setDonGiaOrder(giaca);
        } else {
            arrOrder.add(order);
            arrMenuOrder.add(menu);
        }
    }

    @Override
    public void giamGiaXoaOrder(double sotien) {
        tonggia = tonggia-sotien;
        DecimalFormat format = new DecimalFormat("###,###");
        btnOrder.setText(format.format(tonggia)+"vnđ\nOrder Ngay!");
    }
}
