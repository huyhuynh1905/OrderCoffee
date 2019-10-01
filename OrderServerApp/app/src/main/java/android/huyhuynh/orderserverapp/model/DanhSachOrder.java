package android.huyhuynh.orderserverapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Huy Huynh on 30-09-2019.
 */
public class DanhSachOrder {

    @SerializedName("maOrder")
    @Expose
    private String maOrder;
    @SerializedName("tenBan")
    @Expose
    private String tenBan;
    @SerializedName("listMenuOrder")
    @Expose
    private List<MenuOrder> listMenuOrder;
    @SerializedName("tongGia")
    @Expose
    private Double tongGia;
    @SerializedName("message")
    @Expose
    private String message;

    public DanhSachOrder(String maOrder, String tenBan, List<MenuOrder> listMenuOrder, Double tongGia) {
        this.maOrder = maOrder;
        this.tenBan = tenBan;
        this.listMenuOrder = listMenuOrder;
        this.tongGia = tongGia;
    }

    public String getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(String maOrder) {
        this.maOrder = maOrder;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public List<MenuOrder> getListMenuOrder() {
        return listMenuOrder;
    }

    public void setListMenuOrder(List<MenuOrder> listMenuOrder) {
        this.listMenuOrder = listMenuOrder;
    }

    public Double getTongGia() {
        return tongGia;
    }

    public void setTongGia(Double tongGia) {
        this.tongGia = tongGia;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}