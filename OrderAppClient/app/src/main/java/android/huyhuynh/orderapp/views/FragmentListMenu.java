package android.huyhuynh.orderapp.views;

import android.huyhuynh.orderapp.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.fragment.app.ListFragment;

/**
 * Created by Huy Huynh on 08/18/19.
 */
public class FragmentListMenu extends ListFragment {
    String[] mang = {"Huế","Sài Gòn","Hà Nội","Đà Nẵng","Cà Mau"};
    ArrayAdapter mArrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mArrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mang);
        setListAdapter(mArrayAdapter);
        return inflater.inflate(R.layout.list_menu_fragment,container,false);
    }
}