package com.shinguang.drawerlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.shinguang.drawerlayout.adapter.QuickAdapter;
import com.shinguang.drawerlayout.adapter.QuickAdapter2;
import com.shinguang.drawerlayout.bean.Department;
import com.shinguang.drawerlayout.bean.Staff;
import com.shinguang.drawerlayout.line.DividerItemDecoration;
import com.shinguang.drawerlayout.view.CircleImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.header)
    RelativeLayout header;
    @Bind(R.id.btn)
    Button btn;
    @Bind(R.id.lv)
    ListView lv;
    @Bind(R.id.activity_main)
    DrawerLayout activityMain;
    @Bind(R.id.rv)
    RecyclerView rv;
    @Bind(R.id.rv_header_title)
    TextView rvHeaderTitle;
    @Bind(R.id.rv_header)
    RelativeLayout rvHeader;
    @Bind(R.id.rv2)
    RecyclerView rv2;
    @Bind(R.id.bttn)
    CircleImageView bttn;
    private int[] imageIds;
    private String[] textStrings;
    private String[] listString;
    private QuickAdapter qAdapter;
    private QuickAdapter2 qAdapter2;
    private int currentChoose = 0;
    private Boolean isChoose;
    ArrayList<Department> list = new ArrayList<>();
    ArrayList<Staff> listStaff = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRv1();
        initRv2();
        initLv();
    }

    /**
     * 部门员工列表
     * 模拟...
     */
    private void initRv2() {
        if (listStaff.size() != 0) {
            listStaff.clear();
        }
        for (int i = 0; i < (int) (1 + Math.random() * (10)); i++) {
            listStaff.add(new Staff("噗噗", list.get(currentChoose).getName(), "已上报"));
        }
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        rvHeaderTitle.setText(list.get(currentChoose).getName().toString());
        if (qAdapter2 == null) {
            qAdapter2 = new QuickAdapter2(listStaff);
            rv2.setAdapter(qAdapter2);
        } else {
            qAdapter2.notifyDataSetChanged();
        }
        rv2.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
//                Toast.makeText(MainActivity.this, listStaff.get(i).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 瀑布流
     */
    private void initRv1() {

        listString = new String[]{"经理室", "解决方案部", "技术研发部", "人力资源部", "北斗事业部", "财务部", "市场合作部", "综合部"};
        for (int i = 0; i < listString.length; i++) {
            if (i == 0) {
                isChoose = true;
            } else {
                isChoose = false;
            }
            list.add(new Department(listString[i], isChoose));
        }
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));
        qAdapter = new QuickAdapter(list);
        rv.setAdapter(qAdapter);
        rv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                changeChoose(i);
                initRv2();//相当于重新获取列表
//                Toast.makeText(MainActivity.this, list.get(i).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 瀑布流换选择状态
     *
     * @param i 选择的哪一个
     */
    private void changeChoose(int i) {
        list.get(currentChoose).setChoose(false);
        list.get(i).setChoose(true);
        currentChoose = i;
        qAdapter.notifyDataSetChanged();
    }

    /**
     * 侧拉菜单的listview设置
     */
    private void initLv() {
        imageIds = new int[]{R.drawable.f, R.drawable.f,
                R.drawable.f};
        textStrings = new String[]{"文件管理", "个人信息修改", "修改密码"};
        List<Map<String, Object>> mData = new ArrayList<>();
        ;
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", imageIds[i]);
            item.put("title", textStrings[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                mData,
                R.layout.item,
                new String[]{"image", "title"},
                new int[]{R.id.image, R.id.title});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                activityMain.closeDrawers();
                switch (i) {
                    case 0:// 文件管理
                        Toast.makeText(MainActivity.this, "文件管理", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:// 个人信息修改
                        Toast.makeText(MainActivity.this, "个人信息修改", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:// 修改密码
                        Toast.makeText(MainActivity.this, "修改密码", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @OnClick({R.id.header, R.id.btn, R.id.bttn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header:
                Toast.makeText(this, "头像", Toast.LENGTH_SHORT).show();
                activityMain.closeDrawers();
                break;
            case R.id.btn:
                Toast.makeText(this, "注销", Toast.LENGTH_SHORT).show();
                activityMain.closeDrawers();
                break;
            case R.id.bttn:
                Toast.makeText(this, "打开", Toast.LENGTH_SHORT).show();
                activityMain.openDrawer(Gravity.LEFT);
                break;
        }
    }

}
