package android.huyhuynh.orderserverapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.huyhuynh.orderserverapp.model.DanhSachOrder;
import android.huyhuynh.orderserverapp.model.DanhSachOrderAdapter;
import android.huyhuynh.orderserverapp.model.MenuOrder;
import android.huyhuynh.orderserverapp.model.MenuOrderAdapter;
import android.huyhuynh.orderserverapp.model.Message;
import android.huyhuynh.orderserverapp.retrofit.APIUltils;
import android.huyhuynh.orderserverapp.retrofit.DataClient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    ListView lvOrder,lvItemMenuOrder;
    TextView txtTenBanOrder, txtTongGiaOrder;
    DanhSachOrderAdapter mOrderAdapter;
    MenuOrderAdapter mMenuOrderAdapter;
    List<DanhSachOrder> arrOrder = new ArrayList<>();
    List<MenuOrder> arrMenuOrder = new ArrayList<>();
    int selectItemOrder = -1;
    String user = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        init();

        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        lvOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectItemOrder = i;
                clickItemOrder(selectItemOrder);
            }
        });

    }

    //Kích vào item
    private void clickItemOrder(int posion) {
        List<MenuOrder> menuOrders = arrOrder.get(posion).getListMenuOrder();
        arrMenuOrder.clear();
        for (MenuOrder menuOrder : menuOrders){
            arrMenuOrder.add(menuOrder);
        }
        mOrderAdapter.notifyDataSetChanged();
        mMenuOrderAdapter.notifyDataSetChanged();
        Log.d("ItemClick", "clickItemOrder: "+arrMenuOrder.get(0).getTenThucUong());
        DecimalFormat format = new DecimalFormat("###,###");
        double tongGia = arrOrder.get(posion).getTongGia();
        txtTenBanOrder.setText("Tên bàn: "+arrOrder.get(posion).getTenBan());
        txtTongGiaOrder.setText("Tổng tiền: "+format.format(tongGia)+"vnđ");
    }

    private void init() {
        //Ánh xạ
        lvOrder = findViewById(R.id.lvOrder);
        lvItemMenuOrder = findViewById(R.id.lvItemMenuOrder);
        txtTenBanOrder = findViewById(R.id.txtTenBan);
        txtTongGiaOrder = findViewById(R.id.txtTonggia);


        loadListOrder();
        mOrderAdapter = new DanhSachOrderAdapter(OrderActivity.this,R.layout.item_listview_order,arrOrder);
        lvOrder.setAdapter(mOrderAdapter);

        mMenuOrderAdapter = new MenuOrderAdapter(OrderActivity.this,R.layout.item_listview_ordermenu,arrMenuOrder);
        lvItemMenuOrder.setAdapter(mMenuOrderAdapter);

    }


    //Lấy danh sách đang order
    public void loadListOrder(){
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<DanhSachOrder>> callback = dataClient.getListOrder("");
        callback.enqueue(new Callback<List<DanhSachOrder>>() {
            @Override
            public void onResponse(Call<List<DanhSachOrder>> call, Response<List<DanhSachOrder>> response) {
                List<DanhSachOrder> orders = response.body();
                arrOrder.clear();
                for (DanhSachOrder order : orders){
                    arrOrder.add(order);
                }
                Collections.reverse(arrOrder);
                mOrderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DanhSachOrder>> call, Throwable t) {
                Log.d("OrderActivity", "ErrorRetrofit - loadListOrder: "+t.getMessage());
            }
        });
    }

    public void xacNhanOrder(View view) {
        DataClient dataClient = APIUltils.getDataClient();
        if (selectItemOrder!=-1){
            final DanhSachOrder sachOrder = arrOrder.get(selectItemOrder);
            sachOrder.setMessage(user);
            retrofit2.Call<Message> callback = dataClient.xacNhanOrder(sachOrder);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success!")){
                        arrOrder.remove(sachOrder);
                        arrMenuOrder.clear();
                        Toast.makeText(OrderActivity.this,"Đã xác nhận!", Toast.LENGTH_LONG).show();
                    }
                    Log.d("XÁC Nhận","Message: "+message.getMessage());
                    mOrderAdapter.notifyDataSetChanged();
                    mMenuOrderAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("OrderActivity", "ErrorRetrofit - xacNhanOrder: "+t.getMessage());
                }
            });
            selectItemOrder = -1;
        } else {
            Toast.makeText(OrderActivity.this,"Vui lòng chọn trước khi xác nhận!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void huyOrder(View view) {
        DataClient dataClient = APIUltils.getDataClient();
        if (selectItemOrder!=-1){
            final DanhSachOrder sachOrder = arrOrder.get(selectItemOrder);
            retrofit2.Call<Message> callback = dataClient.huyOrder(sachOrder);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success!")){
                        arrOrder.remove(sachOrder);
                        arrMenuOrder.clear();
                        Toast.makeText(OrderActivity.this,"Đã huỷ!", Toast.LENGTH_LONG).show();
                    }
                    Log.d("Huỷ","Message: "+message.getMessage());
                    mOrderAdapter.notifyDataSetChanged();
                    mMenuOrderAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("OrderActivity", "ErrorRetrofit - xacNhanOrder: "+t.getMessage());
                }
            });
            selectItemOrder = -1;
        } else {
            Toast.makeText(OrderActivity.this,"Vui lòng chọn trước khi xác nhận!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void logOutOrder(View view) {
        Intent intent = new Intent(OrderActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void lamMoi(View view) {
        loadListOrder();
    }
}
