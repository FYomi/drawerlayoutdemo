package com.shinguang.drawerlayout.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shinguang.drawerlayout.R;
import com.shinguang.drawerlayout.bean.Staff;

import java.util.List;

/**
 * Created by amdin on 2016/12/6.
 */

public class QuickAdapter2 extends BaseItemDraggableAdapter<Staff> {
    private List<Staff> list;

    public QuickAdapter2(List<Staff> data) {
        super(R.layout.rv_mb2, data);
        this.list = data;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Staff staff) {
//        if (department.getChoose()) {
//            baseViewHolder.setText(R.id.lala, department.getName())
//                    .setTextColor(R.id.lala, mContext.getResources().getColor(R.color.colorWh))
//                    .setBackgroundRes(R.id.enheng, R.drawable.text_bg_yes);
//        } else {
//            baseViewHolder.setText(R.id.lala, department.getName())
//                    .setBackgroundRes(R.id.enheng, R.drawable.text_bg_no)
//            .setTextColor(R.id.lala,mContext.getResources().getColor(R.color.colorBg));
//        }
        baseViewHolder.setText(R.id.rv2_name, staff.getName())
                .setText(R.id.rv2_job, staff.getJob())
                .setText(R.id.state, staff.getState());
//                    .setTextColor(R.id.lala, mContext.getResources().getColor(R.color.colorWh))
//                    .setBackgroundRes(R.id.enheng, R.drawable.text_bg_yes);
    }


}
