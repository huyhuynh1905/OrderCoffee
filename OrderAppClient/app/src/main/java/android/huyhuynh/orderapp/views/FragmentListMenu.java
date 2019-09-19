package android.huyhuynh.orderapp.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.huyhuynh.orderapp.MainActivity;
import android.huyhuynh.orderapp.R;
import android.huyhuynh.orderapp.model.Menu;
import android.huyhuynh.orderapp.model.MenuAdapter;
import android.huyhuynh.orderapp.retrofit2.APIUltils;
import android.huyhuynh.orderapp.retrofit2.DataClient;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.UiThread;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Huy Huynh on 08/18/19.
 */
public class FragmentListMenu extends ListFragment {

    public static List<Menu> arrMenu;
    MenuAdapter mMenuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        arrMenu = new ArrayList<>();

        loadMenuList(MainActivity.maBan);
        mMenuAdapter = new MenuAdapter(getActivity(),R.layout.item_menu,arrMenu);
        setListAdapter(mMenuAdapter);
        return inflater.inflate(R.layout.list_menu_fragment,container,false);
    }

    //Sự kiện kick item


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        FragmentOrderDialog fragmentOrderDialog = new FragmentOrderDialog();
        fragmentOrderDialog.setPositionfromlist(position);
        fragmentOrderDialog.show(getFragmentManager(),"fragmentDialog");
        super.onListItemClick(l, v, position, id);
    }

    public void loadMenuList(String maBan){
        DataClient dataClient = APIUltils.getDataClient();
        Call<List<Menu>> callBack = dataClient.getListMenu(maBan);
        callBack.enqueue(new Callback<List<Menu>>() {
            @Override
            public void onResponse(Call<List<Menu>> call, Response<List<Menu>> response) {
                List<Menu> menus;
                menus = response.body();
                arrMenu.clear();
                Log.d("AAA","1- "+ menus.get(2).getTenThucUong());
                for (int i = 0; i <  menus.size(); i++){
                    Menu menu = new Menu(menus.get(i).getMaThucUong(),menus.get(i).getTenThucUong(),menus.get(i).getDonGia(),
                            menus.get(i).getHinhAnh(),menus.get(i).getGhiChu());
                    arrMenu.add(menu);
                }
                mMenuAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.d("AAA",t.toString());
            }
        });
    }
}
