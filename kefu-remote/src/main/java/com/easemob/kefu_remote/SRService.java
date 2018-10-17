package com.easemob.kefu_remote;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.hyphenate.chat.ChatClient;

public class SRService extends Service {

    @Override public IBinder onBind(Intent intent) {
        startForeground(10, new Notification());
        return new SRBinder();
    }

    public void startc(int requestCode, int resultCode, Intent data) {
        ChatClient.getInstance().callManager().onActivityResult(requestCode, resultCode, data);
    }

    @Override public void onCreate() {
        super.onCreate();
    }

    public class SRBinder extends Binder {
        public SRService getSRService() {
            return SRService.this;
        }
    }
}
