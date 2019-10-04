package android.huyhuynh.orderserverapp.retrofit;

import android.huyhuynh.orderserverapp.model.Ban;
import android.huyhuynh.orderserverapp.model.DanhSachOrder;
import android.huyhuynh.orderserverapp.model.Menu;
import android.huyhuynh.orderserverapp.model.Message;
import android.huyhuynh.orderserverapp.model.NhanVien;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Huy Huynh on 30-09-2019.
 */
public interface DataClient {

    @FormUrlEncoded
    @POST("nhanvien/login")
    Call<NhanVien> loginToServer(@Field("username") String username,@Field("password") String password);

    @FormUrlEncoded
    @POST("ordermanager/get")
    Call<List<DanhSachOrder>> getListOrder(@Field("username") String username);

    @POST("ordermanager/xacnhan")
    Call<Message> xacNhanOrder(@Body DanhSachOrder dsOrder);

    @POST("ordermanager/huyorder")
    Call<Message> huyOrder(@Body DanhSachOrder dsOrder);

    @POST("nhanvien/get")
    Call<List<NhanVien>> getAllNhanVien();

    @POST("nhanvien/add")
    Call<Message> themNhanVien(@Body NhanVien nv);

    @POST("nhanvien/update")
    Call<Message> capNhatNhanVien(@Body NhanVien nv);

    @POST("nhanvien/delete")
    Call<Message> xoaNhanVien(@Body NhanVien nv);

    @POST("ban/get")
    Call<List<Ban>> getListBan();

    @POST("ban/add")
    Call<Message> themBan(@Body Ban ban);

    @POST("ban/update")
    Call<Message> capNhatBan(@Body Ban ban);

    @POST("ban/delete")
    Call<Message> xoaBan(@Body Ban ban);

    @POST("menu/get")
    Call<List<Menu>> getListMenu();

    @Multipart
    @POST("uploadanh")
    Call<Message> UploadPhoto(@Part MultipartBody.Part photo);

    @POST("menu/add")
    Call<Message> themMenu(@Body Menu menu);

    @POST("menu/update")
    Call<Message> capNhatMenu(@Body Menu menu);

    @POST("menu/delete")
    Call<Message> xoaMenu(@Body Menu menu);

    /*@FormUrlEncoded
    @POST("menu/get")
    Call<List<Menu>> getListMenu(@Field("maBan") String maBan);

    @FormUrlEncoded
    @POST("ban/find")
    Call<Ban> loginWithQR(@Field("maBan") String maBan);

    @POST("order/addlist")
    Call<String> sendOrder(@Body List<Order> maBan);*/

}

