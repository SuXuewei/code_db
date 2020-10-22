package com.suxw.dbcode.activity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.suxw.dbcode.R;
import com.suxw.dbcode.base.BaseActivity;

import androidx.annotation.Nullable;

/**
 * @ClassName: AnimationRotateCase
 * @Description: 旋转动画代码
 * @Author: able
 * @Mail: g_su_xw@163.com
 * @Date: 2020/10/21
 */
public class AnimationRotateCase extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_rotate);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        LinearInterpolator interPolator = new LinearInterpolator();
        rotate.setInterpolator(interPolator);
        ImageView imageView = (ImageView)findViewById(R.id.anim_rotate_img);
        imageView.setAnimation(rotate);
        imageView.startAnimation(rotate);
    }
}
