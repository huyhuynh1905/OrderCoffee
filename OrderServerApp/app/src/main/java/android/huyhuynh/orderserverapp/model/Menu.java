package android.huyhuynh.orderserverapp.model;

/**
 * Created by Huy Huynh on 03-10-2019.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {

    @SerializedName("maThucUong")
    @Expose
    private String maThucUong;
    @SerializedName("tenThucUong")
    @Expose
    private String tenThucUong;
    @SerializedName("donGia")
    @Expose
    private Double donGia;
    @SerializedName("hinhAnh")
    @Expose
    private String hinhAnh;
    @SerializedName("ghiChu")
    @Expose
    private String ghiChu;

    public Menu() {
    }

    public Menu(String maThucUong, String tenThucUong, Double donGia, String hinhAnh, String ghiChu) {
        this.maThucUong = maThucUong;
        this.tenThucUong = tenThucUong;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
        this.ghiChu = ghiChu;
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

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
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
