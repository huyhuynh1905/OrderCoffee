package android.huyhuynh.orderapp.views;

import android.huyhuynh.orderapp.R;
import android.huyhuynh.orderapp.model.OrderAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

/**
 * Created by Huy Huynh on 08/18/19.
 */
public class FragmentListOrder extends ListFragment {

    public static OrderAdapter mOrderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mOrderAdapter = new OrderAdapter(getActivity(), R.layout.item_order, MenuActivity.arrOrder);
        setListAdapter(mOrderAdapter);
        mOrderAdapter.notifyDataSetChanged();
        return inflater.inflate(R.layout.list_order_fragment, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mOrderAdapter.notifyDataSetChanged();
        super.onListItemClick(l, v, position, id);
    }
}
