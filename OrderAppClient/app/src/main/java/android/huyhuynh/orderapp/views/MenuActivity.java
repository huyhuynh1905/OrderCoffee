package android.huyhuynh.orderapp.views;

import android.huyhuynh.orderapp.R;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;


public class MenuActivity extends AppCompatActivity {
    TextView txtBan, txtHuongdan;
    Button btnOrder;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuNav:
                    txtHuongdan.setText("Kích chọn thức uống để order:");
                    return true;
                case R.id.orderNav:
                    txtHuongdan.setText("Đã chọn:");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        init();
    }

    private void init() {
        txtBan = findViewById(R.id.txtBan);
        txtHuongdan = findViewById(R.id.txtHuongdan);
        btnOrder = findViewById(R.id.btnOrder);
    }

}
