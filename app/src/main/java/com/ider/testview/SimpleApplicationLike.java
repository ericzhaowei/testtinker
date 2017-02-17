package com.ider.testview;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by ider-eric on 2017/2/17.
 */
@DefaultLifeCycle(application = "com.ider.testview.SampleApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class SimpleApplicationLike extends ApplicationLike {
    public SimpleApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        TinkerInstaller.install(this);
    }
}
