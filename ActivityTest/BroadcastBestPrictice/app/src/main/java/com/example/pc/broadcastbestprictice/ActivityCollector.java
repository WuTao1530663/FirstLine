package com.example.pc.broadcastbestprictice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/1/12.
 */

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity:activities)
            if(!activity.isFinishing())
                activity.finish();

    }
}
