package com.example.penny.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**创建BasicActivity为所有活动的父类
 * Created by penny on 2016/10/22.
 */

public class BasicActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
