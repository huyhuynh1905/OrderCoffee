package android.huyhuynh.orderserverapp.model;

import android.content.Context;
import android.huyhuynh.orderserverapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Huy Huynh on 03-10-2019.
 */
public class MenuAdapter extends BaseAdapter {

    Context mContext;
    int layout;
    List<Menu> arrMenu;

    public MenuAdapter(Context context, int layout, List<Menu> arrMenu) {
        mContext = context;
        this.layout = layout;
        this.arrMenu = arrMenu;
    }

    @Override
    public int getCount() {
        return arrMenu.size();
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

            viewHolder.txtMaMenu = view.findViewById(R.id.txtItemMaMenu);
            viewHolder.txtTenMenu = view.findViewById(R.id.txtItemTenMenu);
            viewHolder.txtDonGia = view.findViewById(R.id.txtItemDonGiaMenu);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtMaMenu.setText(arrMenu.get(i).getMaThucUong());
        viewHolder.txtTenMenu.setText(arrMenu.get(i).getTenThucUong());
        DecimalFormat format = new DecimalFormat("###,###");
        double donGia = arrMenu.get(i).getDonGia();
        viewHolder.txtDonGia.setText(format.format(donGia)+"vnđ");

        return view;
    }

    class ViewHolder{
        TextView txtMaMenu, txtTenMenu, txtDonGia;
    }

}
