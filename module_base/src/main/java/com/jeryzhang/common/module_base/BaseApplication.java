package com.jeryzhang.common.module_base;

import android.app.ActivityManager;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import java.util.List;

public class BaseApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (mainProcess()) {
            onMaininProcess();
        }
    }

    protected void onMaininProcess() {

    }

    protected boolean mainProcess() {
        String curProcessName = getProcessName(this, android.os.Process.myPid());
        if (!TextUtils.isEmpty(curProcessName)) {
            return curProcessName.equals(getPackageName());
        }
        return false;
    }

    protected String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
            if (runningApps == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName;
                }
            }
        }
        return "";
    }

}
