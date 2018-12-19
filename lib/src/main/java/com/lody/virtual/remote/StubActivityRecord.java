package com.lody.virtual.remote;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/**
 * @author Lody
 */
//
public class StubActivityRecord  {
        public Intent intent;
        public ActivityInfo info;
        public ComponentName caller;
        public int userId;

        public StubActivityRecord(Intent intent, ActivityInfo info, ComponentName caller, int userId) {
            this.intent = intent;
            this.info = info;
            this.caller = caller;
            this.userId = userId;
        }

        // 获取原版 Intent 和一些其他信息
        public StubActivityRecord(Intent stub) {
            this.intent = stub.getParcelableExtra("_VA_|_intent_");
            this.info = stub.getParcelableExtra("_VA_|_info_");
            this.caller = stub.getParcelableExtra("_VA_|_caller_");
            this.userId = stub.getIntExtra("_VA_|_user_id_", 0);
        }

    // 将原版 Intent 塞到 Stub Intent
    public void saveToIntent(Intent stub) {
        stub.putExtra("_VA_|_intent_", intent);
        stub.putExtra("_VA_|_info_", info);
        stub.putExtra("_VA_|_caller_", caller);
        stub.putExtra("_VA_|_user_id_", userId);
    }
}
