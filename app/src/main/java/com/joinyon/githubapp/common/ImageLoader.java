package com.joinyon.githubapp.common;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.joinyon.githubapp.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 *
 *对Glide进行二次封装。
 */

public class ImageLoader {
    public static void load(Context context, Object source, ImageView view) {
        Glide.with(context)
                .load(source)
                .centerCrop()
                .into(view);
    }

    public static void load(Object source, ImageView view) {
        Glide.with(view.getContext())
                .load(source)
                .centerCrop()
                .into(view);
    }

    public static void loadWithCircle(Context context, Object source, ImageView view) {
        Glide.with(context)
                .load(source)
                .bitmapTransform(new CropCircleTransformation(context))
                .placeholder(R.drawable.ic_launcher_background)
                .into(view);
    }

    public static void loadWithCircle(Object source, ImageView view) {
        Glide.with(view.getContext())
                .load(source)
                .bitmapTransform(new CropCircleTransformation(view.getContext()))
                .into(view);
    }
}
