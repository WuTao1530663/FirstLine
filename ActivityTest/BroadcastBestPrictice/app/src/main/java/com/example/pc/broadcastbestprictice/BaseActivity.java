package com.example.pc.broadcastbestprictice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by pc on 2017/1/12.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
