package com.example.administrator.mserviceapplication;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/10.
 */

public class MyService extends Service {
    public static final String TAG="MyService";

    MyBinder mBinder=new MyBinder();
    @Override
    public void onCreate() {
        super.onCreate();
        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(MyService.this);
        PendingIntent contentIntent = PendingIntent.getActivities(MyService.this, 0,
                new Intent[]{new Intent(MyService.this, MainActivity.class)}, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.mipmap.ic_launcher)         //设置状态栏里面的图标（小图标）
 .setTicker("This is bitch.")                //设置状态栏的显示的信息
                .setWhen(System.currentTimeMillis())        //设置时间发生时间
                .setAutoCancel(true)                        //设置可以清除
                .setContentTitle("This is ContentTitle")    //设置下拉列表里的标题
                .setContentText("This is ContentText");     //设置上下文内容
        Notification notification = builder.getNotification();
        manager.notify(1, notification);
        Notification notification = builder.geNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand() excuted");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() excuted");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class MyBinder extends Binder{
        public void startDownload() {
            Log.d("TAG", "startDownload() executed");
            // 执行具体的下载任务
        }
    }
}
