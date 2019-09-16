package android.huyhuynh.orderapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Huy Huynh on 16-09-2019.
 */
public class Menu {

    @SerializedName("maThucUong")
    @Expose
    private String maThucUong;
    @SerializedName("tenThucUong")
    @Expose
    private String tenThucUong;
    @SerializedName("donGia")
    @Expose
    private double donGia;
    @SerializedName("hinhAnh")
    @Expose
    private String hinhAnh;
    @SerializedName("ghiChu")
    @Expose
    private String ghiChu;

    public Menu(String maThucUong, String tenThucUong, double donGia, String hinhAnh, String ghiChu) {
        this.maThucUong = maThucUong;
        this.tenThucUong = tenThucUong;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.ghiChu = ghiChu;
    }

    public Menu() {
    }

    public String getMaThucUong() {
        return maThucUong;
    }

    public void setMaThucUong(String maThucUong) {
        this.maThucUong = maThucUong;
    }

    public String getTenThucUong() {
        return tenThucUong;
    }

    public void setTenThucUong(String tenThucUong) {
        this.tenThucUong = tenThucUong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}