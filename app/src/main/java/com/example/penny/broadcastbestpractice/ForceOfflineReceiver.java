package com.example.penny.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**创建一个广播接收器
 * Created by penny on 2016/10/22.
 */

public class ForceOfflineReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(final Context context, Intent intent){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("warning");
        dialogBuilder.setMessage("you are forced to be offline. please try to login again.");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick (DialogInterface dialog, int which){
                        ActivityCollector.finishAll();//销毁所有的活动
                        Intent intent = new Intent(context, LoginActivity.class);

                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);//重新启动LoginActivity
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        //需要设置AlertDialog的类型，保证在光比接收器中正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }
}
