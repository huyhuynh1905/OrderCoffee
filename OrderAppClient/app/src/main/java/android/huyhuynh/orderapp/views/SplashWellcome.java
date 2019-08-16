package android.huyhuynh.orderapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Service;
import android.content.Intent;
import android.huyhuynh.orderapp.MainActivity;
import android.huyhuynh.orderapp.R;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

public class SplashWellcome extends AppCompatActivity {
    ProgressBar loadProgress;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Chỉnh full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_wellcome);
        //Ánh xạ
        init();
        final ConstraintLayout splashConstrLayout = findViewById(R.id.splashConstrLayout);

        //Load internect
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    int n = 100;
                    while (n<3500){
                        n=n+100;
                        sleep(100);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (!isConnected()){
                        loadProgress.setVisibility(View.INVISIBLE);
                        Snackbar snackbar = Snackbar.make(splashConstrLayout,"Không có kết nối Internet!",
                                Snackbar.LENGTH_INDEFINITE)
                                .setAction("Thử Lại", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        recreate();
                                    }
                                });
                        snackbar.show();
                    } else {
                        synchronized (this){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    loadProgress.setVisibility(View.INVISIBLE);
                                    btnStart.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                    }
                }
            }
        };
        thread.start();
    }

    private void init() {
        loadProgress = findViewById(R.id.loadProgress);
        btnStart = findViewById(R.id.btnStart);
        btnStart.setVisibility(View.INVISIBLE);
    }

    //Kiểm tra có kết nối internet không
    public boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Service.CONNECTIVITY_SERVICE);
        if (connectivityManager!=null){
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null){
                if (networkInfo.getState()==NetworkInfo.State.CONNECTED){
                    return true;
                }
                if (networkInfo.getState()==NetworkInfo.State.DISCONNECTED){
                    return false;
                }
            }
        }
        return false;
    }

    //Load về trang chủ
    public void goMainActivity(){
        Intent intent = new Intent(SplashWellcome.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void loadHomepage(View view) {
        goMainActivity();
    }
}
