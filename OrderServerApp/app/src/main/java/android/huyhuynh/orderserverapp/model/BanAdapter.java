package android.huyhuynh.orderserverapp.model;

import android.content.Context;
import android.huyhuynh.orderserverapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huy Huynh on 03-10-2019.
 */
public class BanAdapter extends BaseAdapter {

    Context mContext;
    int layout;
    List<Ban> arrBan;

    public BanAdapter(Context context, int layout, List<Ban> arrBan) {
        mContext = context;
        this.layout = layout;
        this.arrBan = arrBan;
    }

    @Override
    public int getCount() {
        return arrBan.size();
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
            viewHolder.txtMaBan = view.findViewById(R.id.txtItemMaBan);
            viewHolder.txtTenBan = view.findViewById(R.id.txtItemTenBan);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtMaBan.setText(arrBan.get(i).getMaBan());
        viewHolder.txtTenBan.setText(arrBan.get(i).getTenBan());

        return view;
    }

    class ViewHolder{
        TextView txtMaBan, txtTenBan;
    }
}
