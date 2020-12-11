
#include <com_xhiston_diffpatch_DiffPatchUtil.h>

jint
Java_com_xhiston_diffpatch_DiffPatchUtil_patch (JNIEnv *env, jclass clazz, jstring old, jstring new, jstring patch) {
    int args=4;
    int resutlt = args;
    char *argv[args];
    argv[0] = "bspatch";
    argv[1] = (char*)((*env)->GetStringUTFChars(env, old, 0));
    argv[2] = (char*)((*env)->GetStringUTFChars(env, new, 0));
    argv[3] = (char*)((*env)->GetStringUTFChars(env, patch, 0));
    resutlt = mybspatch(env,clazz,args,argv);
    (*env)->ReleaseStringUTFChars(env,old, argv[1]);
    (*env)->ReleaseStringUTFChars(env,new, argv[2]);
    (*env)->ReleaseStringUTFChars(env,patch,argv[3]);
    return resutlt;
}


jint
Java_com_xhiston_diffpatch_DiffPatchUtil_diff (JNIEnv *env, jobject clazz, jstring old, jstring new, jstring patch) {
       int args=4;
       int resutlt = args;
       char *argv[args];
       argv[0] = "bsdiff";
       argv[1] = (char*)((*env)->GetStringUTFChars(env, old, 0));
       argv[2] = (char*)((*env)->GetStringUTFChars(env, new, 0));
       argv[3] = (char*)((*env)->GetStringUTFChars(env, patch, 0));
       resutlt= mybsdiff(env,clazz,args,argv);
       (*env)->ReleaseStringUTFChars(env,old, argv[1]);
       (*env)->ReleaseStringUTFChars(env,new, argv[2]);
       (*env)->ReleaseStringUTFChars(env,patch,argv[3]);
 return resutlt;
}