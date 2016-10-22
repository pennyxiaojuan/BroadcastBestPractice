package com.example.penny.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**新建ActivityCollector类用于管理左右的活动
 * Created by penny on 2016/10/22.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
