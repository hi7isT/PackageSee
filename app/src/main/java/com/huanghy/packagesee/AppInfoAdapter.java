package com.huanghy.packagesee;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @Description:
 * @Author: huanghy
 * @Date: Created in 2018/3/4 11:57
 * @Since:
 * @Modified by:
 */
public class AppInfoAdapter extends BaseAdapter {

    private List<AppInfo> mlistAppInfo = null;

    LayoutInflater infater = null;

    public AppInfoAdapter(Context context, List<AppInfo> apps) {
        infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mlistAppInfo = apps ;
    }
    @Override
    public int getCount() {
        return mlistAppInfo.size();
    }
    @Override
    public Object getItem(int position) {
        return mlistAppInfo.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertview, ViewGroup arg2) {
        View view = null;
        ViewHolder holder = null;
        if (convertview == null || convertview.getTag() == null) {
            view = infater.inflate(R.layout.packagesee_item_lv, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else{
            view = convertview ;
            holder = (ViewHolder) convertview.getTag() ;
        }
        AppInfo appInfo = (AppInfo) getItem(position);
        holder.icon.setImageDrawable(appInfo.getAppIcon());
        holder.appNmae.setText(appInfo.getAppName());
        holder.packageName.setText("包名："+appInfo.getPackageName());
        if (!TextUtils.isEmpty(appInfo.getLuancherActivity())) {
            holder.launcherName.setText("启动类名："+appInfo.getLuancherActivity());
        }
        return view;
    }

    class ViewHolder {
        ImageView icon;
        TextView appNmae;
        TextView packageName;
        TextView launcherName;

        public ViewHolder(View view) {
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.appNmae = (TextView) view.findViewById(R.id.appNmae);
            this.packageName = (TextView) view.findViewById(R.id.packageName);
            this.launcherName = (TextView) view.findViewById(R.id.launcherName);
        }
    }
}
