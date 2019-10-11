package android.huyhuynh.orderapp.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

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

        loadMenuList(MenuActivity.maBan);
        mMenuAdapter = new MenuAdapter(getActivity(),R.layout.item_menu,arrMenu);
        setListAdapter(mMenuAdapter);
        return inflater.inflate(R.layout.list_menu_fragment,container,false);
    }

    //Sự kiện kick item


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (MenuActivity.bol==false){
            thongBao("Nhấn vào nút \"Order khác!\" để tiếp tục đặt!");
        } else {
            FragmentOrderDialog fragmentOrderDialog = new FragmentOrderDialog();
            fragmentOrderDialog.setPositionfromlist(position);
            fragmentOrderDialog.show(getFragmentManager(), "fragmentDialog");
        }
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
                if (menus!=null){
                    for (Menu mn : menus){
                        Menu menu = new Menu(mn.getMaThucUong(),mn.getTenThucUong(),mn.getDonGia(),
                                mn.getHinhAnh(),mn.getGhiChu());
                        Log.d("AAA","loadList - "+ mn.getHinhAnh());
                        arrMenu.add(menu);
                    }
                    mMenuAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getActivity(),"Lỗi kết nối máy chủ!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Menu>> call, Throwable t) {
                Log.d("AAA",t.toString());
            }
        });
    }
    private void thongBao(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Thông báo");
        builder.setMessage(message);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
