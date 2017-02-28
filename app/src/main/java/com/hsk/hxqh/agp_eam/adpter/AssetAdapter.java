package com.hsk.hxqh.agp_eam.adpter;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.CardView;

import com.hsk.hxqh.agp_eam.R;
import com.hsk.hxqh.agp_eam.model.ASSET;
import com.hsk.hxqh.agp_eam.ui.widget.BaseViewHolder;

import java.util.List;


/**
 * Created by apple on 15/10/26
 */
public class AssetAdapter extends BaseQuickAdapter<ASSET> {
    public AssetAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < 5)
            anim.setStartDelay(index * 150);
    }

    @Override
    protected void convert(BaseViewHolder helper, ASSET item) {
        CardView cardView = helper.getView(R.id.card_container);
//        helper.setText(R.id.item_num_title, mContext.getString(R.string.udstick_text));
//        helper.setText(R.id.item_desc_title, mContext.getString(R.string.item_desc_title));
        helper.setText(R.id.item_num_text, item.getASSETNUM());
        helper.setText(R.id.item_desc_text, item.getDESCRIPTION());
    }


}
