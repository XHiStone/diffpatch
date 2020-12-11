#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <android/log.h>
#include <jni.h>
#include <errno.h>

#define LOG_TAG "diffpatch"
#define LOG_E(fmt, args...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, fmt, ##args)

void errx(char a, char* format, char* param);

void err(char a, char* format);

void onDiffStart(JNIEnv *env,jobject clazz);

void onDiffSuccess(JNIEnv *env,jobject clazz);

void onDiffError(JNIEnv *env,jobject clazz, char *msg);

void onPatchStart(JNIEnv *env,jobject clazz);

void onPatchSuccess(JNIEnv *env,jobject clazz);

void onPatchError(JNIEnv *env,jobject clazz, char *msg);
