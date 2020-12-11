LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
APP_ABI := All
APP_PLATFORM := android-16
LOCAL_C_INCLUDES :=bzip2
LOCAL_MODULE    := diffpatch
LOCAL_SRC_FILES := com_xhiston_diffpatch_DiffPatchUtil.h\
				   	com_xhiston_diffpatch_DiffPatchUtil.c\
					bspatch.c\
					bsdiff.c\
					myerr.h\
                    myerr.c\
                    	bzip2/blocksort.c\
                   		bzip2/bzip2.c\
                    	bzip2/bzip2recover.c\
                    	bzip2/bzlib.c\
                    	bzip2/bzlib.h\
                    	bzip2/bzlib_private.h\
                    	bzip2/compress.c\
                    	bzip2/crctable.c\
                        bzip2/decompress.c\
                        bzip2/huffman.c\
                        bzip2/randtable.c\

include $(BUILD_SHARED_LIBRARY)