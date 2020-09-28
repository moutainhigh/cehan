package com.nj.baijiayun.module_common.widget.jptabbar.animate;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;


/**
 * Author jpeng
 * Date: 16-11-15
 * E-mail:peng8350@gmail.com
 * 实现翻转的动画类
 */
public class FlipAnimater implements Animatable {

    @Override
    public void onPressDown(View v, boolean selected) {
        v.setRotationY(selected?54f:126f);
    }

    @Override
    public void onTouchOut(View v, boolean selected) {
        v.setRotationY(selected?180f:0f);
    }

    @Override
    public void onSelectChanged(View v,boolean selected) {
        float end = selected?180f:0f;
        ObjectAnimator flipAnimator = ObjectAnimator.ofFloat(v,"rotationY",end);
        flipAnimator.setDuration(400);
        flipAnimator.setInterpolator(new DecelerateInterpolator());
        flipAnimator.start();
    }

    @Override
    public void onPageAnimate(View v,float offset) {
        v.setRotationY(180*offset);
    }

    @Override
    public boolean isNeedPageAnimate() {
        return true ;
    }

}
