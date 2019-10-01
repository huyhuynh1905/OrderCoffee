package android.huyhuynh.orderserverapp.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Huy Huynh on 30-09-2019.
 */
public class NhanVien {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("hoTen")
    @Expose
    private String hoTen;
    @SerializedName("namSinh")
    @Expose
    private Integer namSinh;
    @SerializedName("soDienThoai")
    @Expose
    private String soDienThoai;
    @SerializedName("diaChi")
    @Expose
    private String diaChi;
    @SerializedName("chucVu")
    @Expose
    private Boolean chucVu;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Boolean getChucVu() {
        return chucVu;
    }

    public void setChucVu(Boolean chucVu) {
        this.chucVu = chucVu;
    }

}
