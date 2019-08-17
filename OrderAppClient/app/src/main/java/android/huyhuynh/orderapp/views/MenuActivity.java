package android.huyhuynh.orderapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.huyhuynh.orderapp.R;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
