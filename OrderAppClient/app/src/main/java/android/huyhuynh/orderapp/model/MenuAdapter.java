package android.huyhuynh.orderapp.model;

import android.content.Context;
import android.huyhuynh.orderapp.R;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.fragment.app.FragmentActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Huy Huynh on 16-09-2019.
 */
public class MenuAdapter extends BaseAdapter {

    private Context mContext;
    private int mLayout;
    private List<Menu> arrMenu;

    public MenuAdapter(Context context, int layout, List<Menu> arrMenu) {
        mContext = context;
        mLayout = layout;
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
            view = inflater.inflate(mLayout,null);
            viewHolder = new ViewHolder();
            viewHolder.imgHinhAnh = view.findViewById(R.id.imgHinhAnh);
            viewHolder.txtTenThucUong = view.findViewById(R.id.txtTenThucUong);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //Gán
        viewHolder.txtTenThucUong.setText(arrMenu.get(i).getTenThucUong());
        viewHolder.txtGia.setText("Giá: "+String.valueOf(arrMenu.get(i).getDonGia()));
        Picasso.get().load(arrMenu.get(i).getHinhAnh()).into(viewHolder.imgHinhAnh);

        return view;
    }

    private class ViewHolder{
        ImageView imgHinhAnh;
        TextView txtTenThucUong, txtGia;
    }
}
