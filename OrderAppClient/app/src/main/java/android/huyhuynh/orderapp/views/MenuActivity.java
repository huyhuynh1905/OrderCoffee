package android.huyhuynh.orderapp.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.huyhuynh.orderapp.R;
import android.huyhuynh.orderapp.model.DataModel;
import android.huyhuynh.orderapp.model.Menu;
import android.huyhuynh.orderapp.model.Message;
import android.huyhuynh.orderapp.model.Order;
import android.huyhuynh.orderapp.retrofit2.APIUltils;
import android.huyhuynh.orderapp.retrofit2.DataClient;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MenuActivity extends AppCompatActivity implements DataOrderDialog, DataModel {

    public TextView txtBan;
    TextView txtHuongdan;
    Button btnOrder;
    public static List<Order> arrOrder;
    public static List<Menu> arrMenuOrder;
    public static double tonggia = 0;
    public static String maBan = "";
    public static boolean bol = true;

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
        Intent intent = getIntent();
        String tenBanStr = intent.getStringExtra("tenBan");
        maBan = intent.getStringExtra("maBan");
        txtBan.setText(tenBanStr); //gán tên bàn quét được
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
        //Kiểm tra trong list order đã có chưa
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

    public void sendOrder(View view) {
        //Sự kiện button order
        if (tonggia==0){
            thongBao("Mời bạn chọn thức uống để order!");
        } else {
            if (btnOrder.getText().toString().equals("Order khác!")) {
                btnOrder.setText(0 + "vnđ\nOrder Ngay!");
                tonggia = 0;
                arrOrder.clear();
                arrMenuOrder.clear();
                bol = true;
            } else {
                int current = (int) System.currentTimeMillis();
                for (Order order : arrOrder) {
                    order.setMaOrder(String.valueOf(current));
                }
                sendOrderToServer();
                bol =false;
                btnOrder.setText("Order khác!");
            }
        }
    }


    //Retrofit send order
    public void sendOrderToServer(){
        DataClient dataClient = APIUltils.getDataClient();
        Call<Message> callback = dataClient.sendOrder(arrOrder);
        callback.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                Log.d("AAA","1- "+response.body());
                Toast.makeText(MenuActivity.this,message.getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("AAA","MenuActivity162 - "+t.toString());
            }
        });
    }

    private void thongBao(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage(message);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
