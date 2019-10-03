package android.huyhuynh.orderserverapp.model;

import android.content.Context;
import android.huyhuynh.orderserverapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huy Huynh on 03-10-2019.
 */
public class NhanVienAdapter extends BaseAdapter {

    Context mContext;
    int layout;
    List<NhanVien> arrNhanVien;

    public NhanVienAdapter(Context context, int layout, List<NhanVien> arrNhanVien) {
        mContext = context;
        this.layout = layout;
        this.arrNhanVien = arrNhanVien;
    }

    @Override
    public int getCount() {
        return arrNhanVien.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolder = new ViewHolder();

            viewHolder.txtItemMaNv = view.findViewById(R.id.txtItemMaNv);
            viewHolder.txtItemTenNv = view.findViewById(R.id.txtItemTenNv);
            viewHolder.txtItemChucVu = view.findViewById(R.id.txtItemChucVuNv);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtItemMaNv.setText(arrNhanVien.get(i).getUsername());
        viewHolder.txtItemTenNv.setText(arrNhanVien.get(i).getHoTen());
        String chucvu = "";
        if (arrNhanVien.get(i).getChucVu()){
            chucvu = "Quản lí";
        } else {
            chucvu = "Nhân viên";
        }
        viewHolder.txtItemChucVu.setText(chucvu);

        return view;
    }

    class ViewHolder{
        TextView txtItemMaNv, txtItemTenNv, txtItemChucVu;
    }
}
