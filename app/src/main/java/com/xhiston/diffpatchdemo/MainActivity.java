package com.xhiston.diffpatchdemo;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.xhiston.diffpatch.DiffPatchUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "差分包";
    private String newPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "差分新包";
    private String patch = path + File.separator + "patch.patch";
    //    private String newApk = newPath + File.separator + "new.apk";
    String sdpath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String newApk = newPath + File.separator + "new.apk";
    private String oldApk = path + File.separator + "base.apk";
    private String patchApk = newPath + File.separator + "patch.apk";
    private DiffPatchUtil diffPatchUtil;

    private void dspatch() {
        if (!new File(path).exists()) {
            boolean mks = new File(path).mkdirs();
            Log.e("MainActivity", "补丁包 mkdirs =" + mks);
        }
        if (!new File(newPath).exists()) {
            boolean mks = new File(newPath).mkdirs();
            Log.e("MainActivity", "新包 mkdirs =" + mks);
        }
//        File file = new File(patch);
//        if (file.exists()) {
//            int dif = DiffUpdateUtil.diff(getApplicationInfo().sourceDir, newApk, patch);
//            Log.e("tag", "组合Apk中 dif=" + dif);
//        }
    }

    protected boolean checkPermissions(String[] permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        diffPatchUtil = new DiffPatchUtil(this);

        diffPatchUtil.setOnDiffClickListener(new DiffPatchUtil.OnDiffClickListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess() {
                diffPatchUtil.showMessage("Success");
            }

            @Override
            public void onError(String msg) {
                diffPatchUtil.showMessage(msg);
            }
        });

        diffPatchUtil.setOnPatchClickListener(new DiffPatchUtil.OnPatchClickListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess() {
                diffPatchUtil.showMessage("Success");
            }

            @Override
            public void onError(String msg) {
                diffPatchUtil.showMessage(msg);
            }
        });

        dspatch();
        boolean p = checkPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE});
        if (!p) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE}, 10001);
        } else {
//            dspatch();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0 || PackageManager.PERMISSION_GRANTED != grantResults[0]) {

        } else {
            dspatch();
        }
    }

    public void diffpatch(View v) {
        File file = new File(newApk);
        Log.e("MainActivity", "newApk=" + newApk);
        if (file.exists()) {
            new Thread() {
                @Override
                public void run() {
                    int dif = diffPatchUtil.diff(getApplicationInfo().sourceDir, newApk, patch);
                    Log.e("MainActivity", "打Apk差分包 Environment=" + newApk);
                }
            }.start();
        } else {
            new File(newPath).mkdirs();
            Toast.makeText(this, "新版包不存在", Toast.LENGTH_SHORT).show();
        }
    }

    public void addpatch(View v) {
        File file = new File(patch);
        if (file.exists()) {
            new Thread() {
                @Override
                public void run() {
                    int dif = diffPatchUtil.patch(getApplicationInfo().sourceDir, patchApk, patch);
                    Log.e("MainActivity", "组合Apk中 dif=" + dif);
                }
            }.start();
        } else {
            new File(path).mkdirs();
            Toast.makeText(this, "补丁包不存在", Toast.LENGTH_SHORT).show();
        }
    }

}