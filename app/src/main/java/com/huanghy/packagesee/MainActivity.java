package com.huanghy.packagesee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "MainActivity";



    RadioButton allApp,dsfApp;
    ListView listView;
    TextView tvLoad;

    AppInfoAdapter adapter;
    List<AppInfo> mdatas = new ArrayList<>();
    List<AppInfo> appInfos = new ArrayList<>();
    List<AppInfo> dsfappInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 异步初始化所有App和第三方App数据
     */
    private void initData() {
        // 构建适配器，并且注册到listView
        adapter = new AppInfoAdapter(this, mdatas);
        listView.setAdapter(adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                appInfos = AppModel.queryFilterAppInfo(getActivity(),AppModel.FILTER_ALL_APP); // 查询所有应用程序信息
                dsfappInfos = AppModel.queryFilterAppInfo(getActivity(),AppModel.FILTER_THIRD_APP); // 查询所有应用程序信息
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mdatas.addAll(appInfos);
                        adapter.notifyDataSetChanged();
                        tvLoad.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

    }

    private void initView() {
        allApp = findViewById(R.id.allApp);
        dsfApp = findViewById(R.id.dsfApp);
        tvLoad = findViewById(R.id.tvLoad);
        listView = findViewById(R.id.listView);
        allApp.setOnClickListener(this);
        dsfApp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.allApp:
                mdatas.clear();
                mdatas.addAll(appInfos);
                adapter.notifyDataSetChanged();
                break;
            case R.id.dsfApp:
                mdatas.clear();
                mdatas.addAll(dsfappInfos);
                adapter.notifyDataSetChanged();
                break;
        }
    }

    public AppCompatActivity getActivity() {
        return this;
    }
}
