package android.huyhuynh.orderserverapp.views;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.huyhuynh.orderserverapp.R;
import android.huyhuynh.orderserverapp.model.Menu;
import android.huyhuynh.orderserverapp.model.MenuAdapter;
import android.huyhuynh.orderserverapp.model.Message;
import android.huyhuynh.orderserverapp.retrofit.APIUltils;
import android.huyhuynh.orderserverapp.retrofit.DataClient;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Huy Huynh on 02-10-2019.
 */
public class FragmentMenu extends Fragment {

    EditText edtMaTu, edtTenTu, edtDongiaTu, edtGhichuTu;
    Button btnThemTu, btnCapNhatTu, btnXoaTu, btnThemAnh;
    ImageView imgHinhAnh;
    ListView lvMenu;

    List<Menu> arrMenu;
    MenuAdapter mMenuAdapter;
    int select = -1;
    String realPath = "";
    final int REQUEST_IMG = 19;
    String uploadimg = "";
    String file_path="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thucdon,container,false);

        edtMaTu = view.findViewById(R.id.edtMaTu);
        edtTenTu = view.findViewById(R.id.edtTenTu);
        edtDongiaTu = view.findViewById(R.id.edtDongiaTu);
        edtGhichuTu = view.findViewById(R.id.edtGhichuTu);
        btnThemTu = view.findViewById(R.id.btnThemTu);
        btnCapNhatTu = view.findViewById(R.id.btnCapNhaTu);
        btnXoaTu = view.findViewById(R.id.btnXoaTu);
        btnThemAnh = view.findViewById(R.id.btnThemAnhTu);
        imgHinhAnh = view.findViewById(R.id.imgHinhAnhTu);
        lvMenu = view.findViewById(R.id.lvMenu);

        //khởi tạo
        arrMenu = new ArrayList<>();
        mMenuAdapter = new MenuAdapter(getActivity(),R.layout.item_listview_menu,arrMenu);
        lvMenu.setAdapter(mMenuAdapter);
        loadListMenu();
        //sự kiện
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                select = i;
                clickItemMenu(select);
            }
        });

        btnThemAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermissionForReadExtertalStorage()){
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_IMG);
                } else {
                    requestPermissionForReadExtertalStorage();
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, REQUEST_IMG);
                }

            }
        });

        btnThemTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themMenu();
            }
        });

        btnCapNhatTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capNhatMenu();
            }
        });

        btnXoaTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xoaMenu();
            }
        });

        return view;
    }

    private void xoaMenu() {
        String matu = edtMaTu.getText().toString().trim();
        if (!matu.equals("")){
            Menu mn = new Menu();
            mn.setMaThucUong(matu);
            DataClient dataClient = APIUltils.getDataClient();
            Call<Message> callback = dataClient.xoaMenu(mn);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message mess = response.body();
                    if (mess.getMessage().equals("Success")){
                        arrMenu.clear();
                        thongBao("Xoá thành công!");
                        loadListMenu();
                    } else {
                        thongBao("Xoá thất bại! Không tìm thấy thức uống!");
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("MenuFrag","Err xoaMenu: "+t.toString());
                }
            });
        } else {
            thongBao("Vui lòng chọn thức uống muốn xoá!");
        }

    }

    private void capNhatMenu() {
        if (kiemTraForm()){
            Menu menuClick = arrMenu.get(select);
            String matu = edtMaTu.getText().toString().trim();
            String tentu = edtTenTu.getText().toString().trim();
            double gia = Double.parseDouble(edtDongiaTu.getText().toString().trim());
            String ghichu = edtGhichuTu.getText().toString().trim();
            String linkimage = menuClick.getHinhAnh();
            if (!file_path.equals("")){
                linkimage = "http://192.168.1.102:86/ordercoffee/image/"+file_path;
            }
            Menu mn = new Menu(matu,tentu,gia,linkimage,ghichu);
            DataClient dataClient = APIUltils.getDataClient();
            Call<Message> callback = dataClient.capNhatMenu(mn);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success")){
                        arrMenu.clear();
                        thongBao("Cập nhật thành công!");
                        loadListMenu();
                    } else {
                        thongBao("Cập nhật thất bại! Không tìm thấy thức uống!");
                    }
                }
                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("MenuFrag","Err capNhatMenu: "+t.toString());
                }
            });
            uploadimg = "";
            file_path = "";
        } else {
            thongBao("Vui lòng điền đầy đủ thông tin (Mã không quá 5 kí tự) và hình ảnh!");
        }
    }

    private void themMenu() {
        upLoadImage();
        if (kiemTraForm()){
            String matu = edtMaTu.getText().toString().trim();
            String tentu = edtTenTu.getText().toString().trim();
            double gia = Double.parseDouble(edtDongiaTu.getText().toString().trim());
            String ghichu = edtGhichuTu.getText().toString().trim();
            String linkimage = "http://192.168.1.102:86/ordercoffee/image/"+file_path;

            Menu mn = new Menu(matu,tentu,gia,linkimage,ghichu);
            DataClient dataClient = APIUltils.getDataClient();
            Call<Message> callback = dataClient.themMenu(mn);
            callback.enqueue(new Callback<Message>() {
                @Override
                public void onResponse(Call<Message> call, Response<Message> response) {
                    Message message = response.body();
                    if (message.getMessage().equals("Success")){
                        arrMenu.clear();
                        thongBao("Thêm thành công!");
                        loadListMenu();
                    } else {
                        thongBao("Thêm thất bại! Thức uống có thể đã tồn tại!");
                    }
                }

                @Override
                public void onFailure(Call<Message> call, Throwable t) {
                    Log.d("MenuFrag","Err themMenu: "+t.toString());
                }
            });

            uploadimg = "";
            file_path = "";
        } else {
            thongBao("Vui lòng điền đầy đủ thông tin (Mã không quá 5 kí tự) và hình ảnh!");
        }
    }

    private void clickItemMenu(int select) {
        Menu mn = arrMenu.get(select);
        edtMaTu.setText(mn.getMaThucUong());
        edtTenTu.setText(mn.getTenThucUong());
        edtDongiaTu.setText(mn.getDonGia()+"");
        edtGhichuTu.setText(mn.getGhiChu());
        Picasso.get().load(mn.getHinhAnh()).into(imgHinhAnh);
    }

    private void loadListMenu() {
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<Menu>> callback = dataClient.getListMenu();
        callback.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                List<Menu> menus = response.body();
                for (Menu mn : menus){
                    arrMenu.add(mn);
                }
                mMenuAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.d("MenuFrag","Err loadList: "+t.toString());
            }
        });
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

    private boolean kiemTraForm(){
        if (edtMaTu.getText().toString().trim().equals("")|edtMaTu.getText().toString().trim().length()>5){
            return false;
        } else if (edtTenTu.getText().toString().trim().equals("")){
            return false;
        } else if (edtDongiaTu.getText().toString().trim().equals("")){
            return false;
        }
        return true;
    }

    public void upLoadImage(){
        File file = new File(realPath);
        file_path = file.getAbsolutePath();
        String[] filename = file_path.split("/");
        String name = filename[filename.length-1];
        String[] arrTenFile = name.split("\\.");
        file_path = arrTenFile[0] + System.currentTimeMillis() + "." + arrTenFile[1];
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        Log.d("Message", "upLoadImage: "+file_path);
        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",file_path,requestBody);
        DataClient dataClient = APIUltils.getDataClient();
        Call<Message> callback = dataClient.UploadPhoto(body);
        callback.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message mess = response.body();
                uploadimg = mess.getMessage();
                Toast.makeText(getContext(),uploadimg,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.d("MenuFrag","Err upLoadImage: "+t.toString());
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMG && resultCode == RESULT_OK && data!=null){
            Uri uri = data.getData();
            realPath = getRealPathFromURI(uri);
            try {
                InputStream inputStream = getActivity().getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgHinhAnh.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getActivity().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

    public boolean checkPermissionForReadExtertalStorage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int result = getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    public void requestPermissionForReadExtertalStorage(){
        try {
            ActivityCompat.requestPermissions((Activity) getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_IMG);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
