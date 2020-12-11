package com.xhiston.diffpatch;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by xie on 2020/10/20.
 */
public class DiffPatchUtil {
    private Context context;
    private OnDiffClickListener onDiffClickListener;
    private OnPatchClickListener onPatchClickListener;

    static {
        System.loadLibrary("diffpatch");
    }

    public DiffPatchUtil(Context context) {
        this.context = context;
    }

    /**
     * 采用差分算法将当前包与新包打patch补丁包，生成xxx.patch文件
     **/
    public native int diff(String oldApk, String newApk, String patch);

    /**
     * 采用差分算法将patch补丁包与当前包合并生成新包，生成apk文件
     **/
    public native int patch(String oldApk, String newApk, String patch);

    public void onDiffStart() {
        if (onDiffClickListener != null) onDiffClickListener.onStart();
    }

    public void onDiffSuccess() {
        if (onDiffClickListener != null) onDiffClickListener.onSuccess();
    }

    public void onDiffError(String msg) {
        if (onDiffClickListener != null) onDiffClickListener.onError(msg);
    }

    public void onPatchStart() {
        if (onPatchClickListener != null) onPatchClickListener.onStart();
    }

    public void onPatchSuccess() {
        if (onPatchClickListener != null) onPatchClickListener.onSuccess();
    }

    public void onPatchError(String msg) {
        if (onPatchClickListener != null) onPatchClickListener.onError(msg);
    }

    public void setOnDiffClickListener(OnDiffClickListener onDiffClickListener) {
        this.onDiffClickListener = onDiffClickListener;
    }

    public void setOnPatchClickListener(OnPatchClickListener onPatchClickListener) {
        this.onPatchClickListener = onPatchClickListener;
    }

    public void showMessage(String msg) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        } else {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnDiffClickListener {
        void onStart();

        void onSuccess();

        void onError(String msg);
    }

    public interface OnPatchClickListener {
        void onStart();

        void onSuccess();

        void onError(String msg);
    }
}
