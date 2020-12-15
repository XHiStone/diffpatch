#include <myerr.h>

void errx(char a, char* format, char* param){

    LOG_E(format,param);
}

void err(char a, char* format){
    LOG_E("%s",format);
}

void onDiffStart(JNIEnv *env,jobject clazz){
    jclass myclass = (*env)->FindClass(env,"com/xhiston/diffpatch/DiffPatchUtil");
    if(myclass==0){
         LOG_E("%s","find class error");
         return;
    }
    jmethodID mid = (*env)->GetMethodID(env,myclass,"onDiffStart","()V");
     if(mid==0){
         LOG_E("find method error");
          return;
     }
     (*env)->CallVoidMethod(env,clazz,mid);
}

void onDiffSuccess(JNIEnv *env,jobject clazz){
    jclass myclass = (*env)->FindClass(env,"com/xhiston/diffpatch/DiffPatchUtil");
    if(myclass==0){
         LOG_E("%s","find class error");
         return;
    }
    jmethodID mid = (*env)->GetMethodID(env,myclass,"onDiffSuccess","()V");
     if(mid==0){
         LOG_E("find method error");
          return;
     }
     (*env)->CallVoidMethod(env,clazz,mid);
}

void onDiffError(JNIEnv *env,jobject clazz, char *msg){
    jstring toast_msg =(jstring)(*env)->NewStringUTF(env,msg);
    jclass myclass = (*env)->FindClass(env,"com/xhiston/diffpatch/DiffPatchUtil");
    if(myclass==0){
         LOG_E("%s","find class error");
         return;
    }
    jmethodID mid = (*env)->GetMethodID(env,myclass,"onDiffError","(Ljava/lang/String;)V");
     if(mid==0){
         LOG_E("find method error");
          return;
     }
     /*
     jobject dpobj= (*env)->AllocObject(env,myclass);
     */
     (*env)->CallVoidMethod(env,clazz,mid,toast_msg);
}

void onPatchStart(JNIEnv *env,jobject clazz){
    jclass myclass = (*env)->FindClass(env,"com/xhiston/diffpatch/DiffPatchUtil");
    if(myclass==0){
         LOG_E("%s","find class error");
         return;
    }
    jmethodID mid = (*env)->GetMethodID(env,myclass,"onPatchStart","()V");
     if(mid==0){
         LOG_E("find method error");
          return;
     }
     (*env)->CallVoidMethod(env,clazz,mid);
}

void onPatchSuccess(JNIEnv *env,jobject clazz){
    jclass myclass = (*env)->FindClass(env,"com/xhiston/diffpatch/DiffPatchUtil");
    if(myclass==0){
         LOG_E("%s","find class error");
         return;
    }
    jmethodID mid = (*env)->GetMethodID(env,myclass,"onPatchSuccess","()V");
     if(mid==0){
         LOG_E("find method error");
          return;
     }
     (*env)->CallVoidMethod(env,clazz,mid);
}

void onPatchError(JNIEnv *env,jobject clazz, char *msg){
    jstring toast_msg =(jstring)(*env)->NewStringUTF(env,msg);
    jclass myclass = (*env)->FindClass(env,"com/xhiston/diffpatch/DiffPatchUtil");
    if(myclass==0){
         LOG_E("%s","find class error");
         return;
    }
    jmethodID mid = (*env)->GetMethodID(env,myclass,"onPatchError","(Ljava/lang/String;)V");
     if(mid==0){
         LOG_E("find method error");
          return;
     }
     /*
     jobject dpobj= (*env)->AllocObject(env,myclass);
     */
     (*env)->CallVoidMethod(env,clazz,mid,toast_msg);
}