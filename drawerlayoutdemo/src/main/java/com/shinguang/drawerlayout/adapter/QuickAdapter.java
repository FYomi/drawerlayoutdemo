package com.shinguang.drawerlayout.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shinguang.drawerlayout.R;
import com.shinguang.drawerlayout.bean.Department;

import java.util.List;

/**
 * Created by amdin on 2016/12/6.
 */

public class QuickAdapter extends BaseItemDraggableAdapter<Department> {
    private List<Department> list;

    public QuickAdapter(List<Department> data) {
        super(R.layout.rv_mb, data);
        this.list = data;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Department department) {
        if (department.getChoose()) {
            baseViewHolder.setText(R.id.lala, department.getName())
                    .setTextColor(R.id.lala, mContext.getResources().getColor(R.color.colorWh))
                    .setBackgroundRes(R.id.enheng, R.drawable.text_bg_yes);
        } else {
            baseViewHolder.setText(R.id.lala, department.getName())
                    .setBackgroundRes(R.id.enheng, R.drawable.text_bg_no)
            .setTextColor(R.id.lala,mContext.getResources().getColor(R.color.colorBg));
        }

    }


}
