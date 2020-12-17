# DiffPatchDemo
差分算法实现diffpatch增量更新依赖库<br>
![image](https://github.com/XHiStone/DiffPatchDemo/blob/master/picture/%E5%A2%9E%E9%87%8F%E6%9B%B4%E6%96%B0.gif)<br>
```
allprojects {
    repositories {
        maven { url('https://oranges.bintray.com/DiffPatch') }
    }
}

implementation 'com.xhiston.diffpatch:diffpatch:1.0.0'

DiffPatchUtil diffPatchUtil = new DiffPatchUtil(context);

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

File file = new File(newApk);
//打出差分补丁包路径为patch
diffPatchUtil.diff(getApplicationInfo().sourceDir, newApk, patch);        

File file = new File(patch);       
//根据补丁包路径patch合成新的apk路径为patchApk       
diffPatchUtil.patch(getApplicationInfo().sourceDir, patchApk, patch);                        
```                
当然还有不能忘记加入权限
```
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```
如果准备自己手写一个增量更新注意你的Android Api Level 为29以上的话请在manifest中加入以下一行代码，否则就算打开了读写权限也会无法读写本地文件，如果依赖的是我的lib就不用写了因为我已经加入了本行代码：
```
<application android:requestLegacyExternalStorage="true" />
```
最后别忘了下载[so库](https://github.com/XHiStone/DiffPatchDemo/tree/master/diffpatch/src/main/libs)导入项目，如果项目中发现有问题随时欢迎告知我及时修正。
