package android.huyhuynh.orderserverapp.views;

import android.huyhuynh.orderserverapp.ManagerActivity;
import android.huyhuynh.orderserverapp.R;
import android.huyhuynh.orderserverapp.model.DanhSachOrder;
import android.huyhuynh.orderserverapp.model.DanhSachOrderAdapter;
import android.huyhuynh.orderserverapp.model.MenuOrder;
import android.huyhuynh.orderserverapp.model.MenuOrderAdapter;
import android.huyhuynh.orderserverapp.model.Message;
import android.huyhuynh.orderserverapp.retrofit.APIUltils;
import android.huyhuynh.orderserverapp.retrofit.DataClient;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentOrder extends Fragment {

    Button btnXacNhanFr, btnHuyFr, btnLamMoiFrag;
    TextView txtTenBanFr, txtTongGiaFr;
    ListView lvOrderFr, lvOrderFrItem;

    List<MenuOrder> arrMenuOrder;
    List<DanhSachOrder> arrDSOrder;

    DanhSachOrderAdapter mOrderAdapter;
    MenuOrderAdapter mMenuOrderAdapter;
    int selectItemOrder = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,container,false);
        //Ánh xạ
        btnXacNhanFr = view.findViewById(R.id.btnXacNhanFrag);
        btnHuyFr = view.findViewById(R.id.btnHuyFrag);
        btnLamMoiFrag = view.findViewById(R.id.btnLamMoiFrag);
        txtTenBanFr = view.findViewById(R.id.txtTenBanFrag);
        txtTongGiaFr = view.findViewById(R.id.txtTonggiaFrag);
        lvOrderFrItem = view.findViewById(R.id.lvItemFragOrder);
        lvOrderFr = view.findViewById(R.id.lvfragOrder);

        //
        arrDSOrder = new ArrayList<>();
        arrMenuOrder = new ArrayList<>();
        mMenuOrderAdapter = new MenuOrderAdapter(getActivity(),R.layout.item_listview_ordermenu,arrMenuOrder);
        lvOrderFrItem.setAdapter(mMenuOrderAdapter);
        mOrderAdapter = new DanhSachOrderAdapter(getActivity(),R.layout.item_listview_order,arrDSOrder);
        lvOrderFr.setAdapter(mOrderAdapter);

        //
        loadDanhSachOrder();
        lvOrderFr.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectItemOrder = i;
                clickItemOrder(i);
            }
        });

        btnXacNhanFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xacNhanOrder();
            }
        });
        btnHuyFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huyOrder();
            }
        });

        btnLamMoiFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDanhSachOrder();
            }
        });

        return view;
    }

    private void clickItemOrder(int posion) {
        List<MenuOrder> menuOrders = arrDSOrder.get(posion).getListMenuOrder();
        arrMenuOrder.clear();
        for (MenuOrder menuOrder : menuOrders){
            arrMenuOrder.add(menuOrder);
        }
        mOrderAdapter.notifyDataSetChanged();
        mMenuOrderAdapter.notifyDataSetChanged();
        Log.d("ItemClick", "clickItemOrder: "+arrMenuOrder.get(0).getTenThucUong());
        DecimalFormat format = new DecimalFormat("###,###");
        double tongGia = arrDSOrder.get(posion).getTongGia();
        txtTenBanFr.setText("Tên bàn: "+arrDSOrder.get(posion).getTenBan());
        txtTongGiaFr.setText("Tổng tiền: "+format.format(tongGia)+"vnđ");
    }

    private void loadDanhSachOrder() {
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<DanhSachOrder>> callback = dataClient.getListOrder("");
        callback.enqueue(new Callback<List<DanhSachOrder>>() {
            @Override
            public void onResponse(Call<List<DanhSachOrder>> call, Response<List<DanhSachOrder>> response) {
                List<DanhSachOrder> orders = response.body();
                arrDSOrder.clear();
                for (DanhSachOrder order : orders){
                    arrDSOrder.add(order);
                }
                Collections.reverse(arrDSOrder);
                mOrderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DanhSachOrder>> call, Throwable t) {
                Log.d("OrderActivity", "ErrorRetrofit - loadListOrder: "+t.getMessage());
            }
        });
    }

    public void xacNhanOrder() {
        DataClient dataClient = APIUltils.getDataClient();
        if (selectItemOrder!=-1){
            final DanhSachOrder sachOrder = arrDSOrder.get(selectItemOrder);
            sachOrder.setMessage(ManagerActivity.user);
            retrofit2.Call<Message> callback = dataClient.xacNhanOrder(sachOrder);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success!")){
                        arrDSOrder.remove(sachOrder);
                        arrMenuOrder.clear();
                        Toast.makeText(getActivity(),"Đã xác nhận!", Toast.LENGTH_LONG).show();
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
            Toast.makeText(getActivity(),"Vui lòng chọn trước khi xác nhận!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void huyOrder() {
        DataClient dataClient = APIUltils.getDataClient();
        if (selectItemOrder!=-1){
            final DanhSachOrder sachOrder = arrDSOrder.get(selectItemOrder);
            retrofit2.Call<Message> callback = dataClient.huyOrder(sachOrder);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success!")){
                        arrDSOrder.remove(sachOrder);
                        arrMenuOrder.clear();
                        Toast.makeText(getActivity(),"Đã huỷ!", Toast.LENGTH_LONG).show();
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
            Toast.makeText(getActivity(),"Vui lòng chọn trước khi xác nhận!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
