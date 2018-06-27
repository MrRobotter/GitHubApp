package com.joinyon.githubapp.compz;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.joinyon.githubapp.common.AppLog;
import com.joinyon.githubapp.common.CrashHelper;
import com.joinyon.githubapp.common.ImageLoader;
import com.joinyon.githubapp.common.PushManager;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;

/**
 * 作者： JoinYon on 2018/6/26.
 * 邮箱：2816886869@qq.com
 */

public class InitializeService extends IntentService {
    private static final String ACTION_INIT_WHEN_APP_CREATE = "com.joinyon.githubapp.service.action.INIT";

    public InitializeService() {
        super("InitializeService");
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_INIT_WHEN_APP_CREATE.equals(action)) {
                performInit();
            }
        }

    }


    private void performInit() {
        AppLog.d("performInit begin:" + System.currentTimeMillis());

        // init Drawer image loader
        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                ImageLoader.loadWithCircle(getApplicationContext(), uri, imageView);
            }
        });
        // init crash helper
        CrashHelper.init(this.getApplicationContext());

        // init push
        PushManager.init(this.getApplicationContext());


        AppLog.e("performInit end:" + System.currentTimeMillis());
    }

}
