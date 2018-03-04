package com.huanghy.packagesee;

import android.graphics.drawable.Drawable;

/**
 * @Description:
 * @Author: huanghy
 * @Date: Created in 2018/3/4 11:07
 * @Since:
 * @Modified by:
 */
public class AppInfo {

    private String appName;
    private Drawable appIcon;
    private String packageName;
    private String luancherActivity;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getLuancherActivity() {
        return luancherActivity;
    }

    public void setLuancherActivity(String luancherActivity) {
        this.luancherActivity = luancherActivity;
    }
}
