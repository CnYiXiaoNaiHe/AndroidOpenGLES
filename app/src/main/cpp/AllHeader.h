#pragma once

#include <stdio.h>
#include <string.h>
#include <time.h>
#include <jni.h>
#include <iostream>
#include <string>

//引入数学库
#include "Glm/glm.hpp"
#include "Glm/ext.hpp"

//opengles相关头文件
#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>
#include <GLES2/gl2platform.h>

#include <android/log.h>//安卓日志打印头文件
#define HANGYU_LOG_TAG "HANGYUOpenGLES"

//在NDK层加载外部文件相关
#include <android/asset_manager.h>
#include <android/asset_manager_jni.h>
