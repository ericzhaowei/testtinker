package com.ider.testview;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

/**
 * Created by ider-eric on 2016/11/23.
 */

public class NewActivity extends Activity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
        setContentView(R.layout.activity_b);
        imageView = (ImageView) findViewById(R.id.image_b);
        imageView.setImageResource(R.mipmap.kobe);

        imageView.setVisibility(View.GONE);

    }

    public void fix(View view) {
        String patchPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tinker/tinker_patch.apk";
        Log.i("NewActivity", "fix: " + patchPath);
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), patchPath);
    }

}
