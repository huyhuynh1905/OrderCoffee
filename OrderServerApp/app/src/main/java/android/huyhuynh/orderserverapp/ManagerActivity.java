package android.huyhuynh.orderserverapp;

import android.content.Intent;
import android.huyhuynh.orderserverapp.views.FragmentBan;
import android.huyhuynh.orderserverapp.views.FragmentMenu;
import android.huyhuynh.orderserverapp.views.FragmentNhanSu;
import android.huyhuynh.orderserverapp.views.FragmentOrder;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ManagerActivity extends AppCompatActivity {
    private TextView mTextMessage,usermanemanager;
    public static String user = "";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_nhansu:
                    mTextMessage.setText("Quản Lí Nhân Sự");
                    fragment = new FragmentNhanSu();
                    break;
                case R.id.navigation_menu:
                    mTextMessage.setText("Quản Lí Thực Đơn");
                    fragment = new FragmentMenu();
                    break;
                case R.id.navigation_order:
                    mTextMessage.setText("Order");
                    fragment = new FragmentOrder();
                    break;
                case R.id.navigation_ban:
                    mTextMessage.setText("Quản Lí Số Bàn");
                    fragment = new FragmentBan();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Intent intent = getIntent();
        user = intent.getStringExtra("username");
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                new FragmentNhanSu()).commit();
        init();
        usermanemanager.setText(user);
    }

    private void init() {
        usermanemanager = findViewById(R.id.usermanemanager);
        usermanemanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupmenu();
            }
        });
    }


    public void showPopupmenu(){
        PopupMenu popupMenu = new PopupMenu(this,usermanemanager);
        popupMenu.getMenuInflater().inflate(R.menu.menu_logout,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menulogout:
                        //
                        Intent intent = new Intent(ManagerActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

}
