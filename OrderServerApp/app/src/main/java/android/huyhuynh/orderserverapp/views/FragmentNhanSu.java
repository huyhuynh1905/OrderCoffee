package android.huyhuynh.orderserverapp.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.huyhuynh.orderserverapp.R;
import android.huyhuynh.orderserverapp.model.Message;
import android.huyhuynh.orderserverapp.model.NhanVien;
import android.huyhuynh.orderserverapp.model.NhanVienAdapter;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
public class FragmentNhanSu extends Fragment {

    EditText edtUsername, edtTenNv, edtNamsinh, edtPhoneNv, edtPass, edtPassNhaplai, edtDiachi;
    RadioGroup mRadioGroup;
    RadioButton radQuanli, radNhanvien;
    Button btnThemNv, btnCapnhatNv, btnXoaNv;
    ListView lvNhanvien;
    List<NhanVien> arrNhanVien;
    NhanVienAdapter mNhanVienAdapter;

    int select = -1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quanlinhansu,container,false);
        //Ánh xạ
        edtUsername = view.findViewById(R.id.edtUsernameNv);
        edtTenNv = view.findViewById(R.id.edtTenNv);
        edtNamsinh = view.findViewById(R.id.edtNamsinh);
        edtPhoneNv = view.findViewById(R.id.edtPhoneNv);
        edtPass = view.findViewById(R.id.edtPassNv);
        edtPassNhaplai = view.findViewById(R.id.edtPassNhapLaiNv);
        edtDiachi = view.findViewById(R.id.edtDiachiNv);
        mRadioGroup = view.findViewById(R.id.radioGroup);
        radNhanvien = view.findViewById(R.id.radNhanvien);
        radQuanli = view.findViewById(R.id.radQuanli);
        btnThemNv = view.findViewById(R.id.btnThemNv);
        btnCapnhatNv = view.findViewById(R.id.btnCapNhatNv);
        btnXoaNv = view.findViewById(R.id.btnXoaNv);
        lvNhanvien = view.findViewById(R.id.lvNhanvien);

        //khởi tạo
        arrNhanVien = new ArrayList<>();
        mNhanVienAdapter = new NhanVienAdapter(getActivity(),R.layout.item_listview_nhanvien,arrNhanVien);
        lvNhanvien.setAdapter(mNhanVienAdapter);
        getListNv();

        //
        lvNhanvien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                select = i;
                clickItemNv(select);
            }
        });

        btnThemNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themNv();
            }
        });

        btnCapnhatNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capNhatNv();
            }
        });

        btnXoaNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoaNv();
            }
        });

        return view;
    }

    private void xoaNv() {
        String username = edtUsername.getText().toString();
        NhanVien nv = new NhanVien();
        nv.setUsername(username);
        DataClient dataClient = APIUltils.getDataClient();
        Call<Message> callback = dataClient.xoaNhanVien(nv);
        callback.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                if (message.getMessage().equals("Success")){
                    thongBao("Xoá thành công!");
                    arrNhanVien.clear();
                    getListNv();
                } else {
                    thongBao("Xoá thất bại, tài khoản không tồn tại!");
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("FragNv", "Err xoaNv: "+t.toString());
            }
        });
    }

    private void capNhatNv() {
        if (kiemTraForm()){
            String username = edtUsername.getText().toString();
            String tennv = edtTenNv.getText().toString();
            int namsinh = Integer.parseInt(edtNamsinh.getText().toString());
            String phone = edtPhoneNv.getText().toString();
            String pass = edtPass.getText().toString();
            String diachi = edtDiachi.getText().toString();
            boolean chucvu = false;
            if (radNhanvien.isChecked()){
                chucvu = false;
            } else chucvu = true;
            NhanVien nv = new NhanVien(username,pass,tennv,namsinh,phone,diachi,chucvu);
            capNhatNhanVienToServer(nv);
        } else {
            thongBao("Vui lòng nhập đầy đủ thông tin và nhập mật khẩu trùng khớp!");
        }
    }

    private void capNhatNhanVienToServer(NhanVien nv) {
        DataClient dataClient = APIUltils.getDataClient();
        Call<Message> callback = dataClient.capNhatNhanVien(nv);
        callback.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                if (message.getMessage().equals("Success")){
                    thongBao("Cập nhật thành công!");
                    arrNhanVien.clear();
                    getListNv();
                } else {
                    thongBao("Cập nhật thất bại, tài khoản không tồn tại!");
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("FragNv", "Err capNhatNhanVienToServer: "+t.toString());
            }
        });
    }

    private void themNv() {
        if (kiemTraForm()){
            String username = edtUsername.getText().toString();
            String tennv = edtTenNv.getText().toString();
            int namsinh = Integer.parseInt(edtNamsinh.getText().toString());
            String phone = edtPhoneNv.getText().toString();
            String pass = edtPass.getText().toString();
            String diachi = edtDiachi.getText().toString();
            boolean chucvu = false;
            if (radNhanvien.isChecked()){
                chucvu = false;
            } else chucvu = true;
            NhanVien nv = new NhanVien(username,pass,tennv,namsinh,phone,diachi,chucvu);
            themNhanVienToServer(nv);

        } else {
            thongBao("Vui lòng nhập đầy đủ thông tin và nhập mật khẩu trùng khớp!");
        }
    }

    private void themNhanVienToServer(NhanVien nv) {
        DataClient dataClient = APIUltils.getDataClient();
        Call<Message> callback = dataClient.themNhanVien(nv);
        callback.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                if (message.getMessage().equals("Success")){
                    thongBao("Thêm thành công!");
                    arrNhanVien.clear();
                    getListNv();
                } else {
                    thongBao("Thêm không thành công, tài khoản đã tồn tại!");
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("FragNv", "Err themNhanVienToServer: "+t.toString());
            }
        });

    }

    private void clickItemNv(int i) {
        NhanVien nv = arrNhanVien.get(i);
        edtUsername.setText(nv.getUsername());
        edtTenNv.setText(nv.getHoTen());
        edtNamsinh.setText(nv.getNamSinh()+"");
        edtPhoneNv.setText(nv.getSoDienThoai());
        edtPass.setText(nv.getPassword());
        edtPassNhaplai.setText(nv.getPassword());
        edtDiachi.setText(nv.getDiaChi());
        if (nv.getChucVu()){
            radQuanli.setChecked(true);
        } else radNhanvien.setChecked(true);
    }


    //Lấy danh sách nhân viên:
    public void getListNv(){
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<NhanVien>> callback = dataClient.getAllNhanVien();
        callback.enqueue(new Callback<List<NhanVien>>() {
            @Override
            public void onResponse(Call<List<NhanVien>> call, Response<List<NhanVien>> response) {
                List<NhanVien> listNv = response.body();
                for (NhanVien nv : listNv){
                    arrNhanVien.add(nv);
                }
                mNhanVienAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NhanVien>> call, Throwable t) {
                Log.d("FragNv", "Err getListNv: "+t.toString());
            }
        });
    }

    //Kiểm tra hợp lệ
    public boolean kiemTraForm(){
        boolean flag = true;
        if (edtTenNv.getText().toString().trim().equals("")){
            return false;
        } else if (edtUsername.getText().toString().trim().equals("")){
            return false;
        } else if (edtTenNv.getText().toString().trim().equals("")){
            return false;
        } else if (edtPhoneNv.getText().toString().trim().equals("")){
            return false;
        } else if (edtDiachi.getText().toString().trim().equals("")){
            return false;
        } else if (edtNamsinh.getText().toString().trim().equals("")){
            return false;
        } else if (edtPass.getText().toString().trim().equals("")){
            return false;
        } else if (edtPassNhaplai.getText().toString().trim().equals("")){
            return false;
        } else if (!edtPassNhaplai.getText().toString().trim().equals(edtPass.getText().toString().trim())) {
            return false;
        }
        return flag;
    }

    public void thongBao(String message){
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
