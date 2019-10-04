package android.huyhuynh.orderserverapp.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.huyhuynh.orderserverapp.R;
import android.huyhuynh.orderserverapp.model.Ban;
import android.huyhuynh.orderserverapp.model.BanAdapter;
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
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentBan extends Fragment {

    EditText edtMaBan, edtTenBan, edtMoTa;
    Button btnThemBan, btnCapNhatBan, btnXoaBan;
    ListView lvBan;

    List<Ban> arrBan;
    BanAdapter mBanAdapter;

    int select = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ban,container,false);
        //Ánh xạ
        edtMaBan = view.findViewById(R.id.edtMaBan);
        edtTenBan = view.findViewById(R.id.edtTenBan);
        edtMoTa = view.findViewById(R.id.edtMoTa);
        btnThemBan = view.findViewById(R.id.btnThemBan);
        btnCapNhatBan = view.findViewById(R.id.btnCapNhatBan);
        btnXoaBan = view.findViewById(R.id.btnXoaBan);
        lvBan = view.findViewById(R.id.lvFragBan);

        //Khởi tạo
        arrBan = new ArrayList<>();
        mBanAdapter = new BanAdapter(getActivity(),R.layout.item_listview_ban,arrBan);
        lvBan.setAdapter(mBanAdapter);

        loadListBan();

        //Sự kiện
        lvBan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                select = i;
                clickItemBan(select);
            }
        });

        btnThemBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themBan();
            }
        });

        btnCapNhatBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capNhatBan();
            }
        });
        
        btnXoaBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoaBan();
            }
        });

        return view;
    }

    private void xoaBan() {
        if (kiemTraForm()){
            String maban = edtMaBan.getText().toString().trim();
            String tenban = edtTenBan.getText().toString().trim();
            String mota = edtMoTa.getText().toString().trim();
            Ban ban = new Ban(maban,tenban,mota);
            DataClient dataClient = APIUltils.getDataClient();
            Call<Message> callback = dataClient.xoaBan(ban);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success")){
                        arrBan.clear();
                        thongBao("Xoá thành công!");
                        loadListBan();
                    } else {
                        thongBao("Xoá thất bại, không tìm thấy mã bàn!");
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("BanFrag","Err - themBan: "+t.toString());
                }
            });
        } else {
            thongBao("Vui lòng điền đầy đủ thông tin, mã bàn không quá 5 kí tự!");
        }
    }

    private void capNhatBan() {
        if (kiemTraForm()){
            String maban = edtMaBan.getText().toString().trim();
            String tenban = edtTenBan.getText().toString().trim();
            String mota = edtMoTa.getText().toString().trim();
            Ban ban = new Ban(maban,tenban,mota);
            DataClient dataClient = APIUltils.getDataClient();
            Call<Message> callback = dataClient.capNhatBan(ban);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success")){
                        arrBan.clear();
                        thongBao("Cập nhật thành công!");
                        loadListBan();
                    } else {
                        thongBao("Cập nhật thất bại, không tìm thấy mã bàn!");
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("BanFrag","Err - themBan: "+t.toString());
                }
            });
        } else {
            thongBao("Vui lòng điền đầy đủ thông tin, mã bàn không quá 5 kí tự!");
        }
    }

    private void clickItemBan(int select) {
        Ban ban = arrBan.get(select);
        edtMaBan.setText(ban.getMaBan());
        edtTenBan.setText(ban.getTenBan());
        edtMoTa.setText(ban.getMoTa());
    }

    private void themBan() {
        if (kiemTraForm()){
            String maban = edtMaBan.getText().toString().trim();
            String tenban = edtTenBan.getText().toString().trim();
            String mota = edtMoTa.getText().toString().trim();
            Ban ban = new Ban(maban,tenban,mota);
            DataClient dataClient = APIUltils.getDataClient();
            Call<Message> callback = dataClient.themBan(ban);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success")){
                        arrBan.clear();
                        thongBao("Thêm thành công!");
                        loadListBan();
                    } else {
                        thongBao("Thêm thất bại, mã bàn đã tồn tại!");
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("BanFrag","Err - themBan: "+t.toString());
                }
            });
        } else {
            thongBao("Vui lòng điền đầy đủ thông tin, mã bàn không quá 5 kí tự!");
        }
    }

    private void loadListBan() {
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<Ban>> callback = dataClient.getListBan();
        callback.enqueue(new Callback<List<Ban>>() {
            @Override
            public void onResponse(Call<List<Ban>> call, Response<List<Ban>> response) {
                List<Ban> bans = response.body();
                for (Ban ban : bans){
                    arrBan.add(ban);
                }
                mBanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Ban>> call, Throwable t) {
                Log.d("BanFrag","Err - loadListBan: "+t.toString());
            }
        });
    }

    private boolean kiemTraForm(){
        if (edtMaBan.getText().toString().trim().equals("")|edtMaBan.getText().toString().trim().length()>5){
            return false;
        } else if (edtTenBan.getText().toString().trim().equals("")){
            return false;
        } else if (edtMoTa.getText().toString().trim().equals("")){
            return false;
        }
        return true;
    }

    private void thongBao(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
