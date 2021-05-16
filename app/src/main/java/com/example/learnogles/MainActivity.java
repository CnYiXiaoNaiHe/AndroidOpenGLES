package com.example.learnogles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class HangyuGLSurfaceViewRenderer implements GLSurfaceView.Renderer{

    public void onSurfaceCreated(GL10 gl, EGLConfig config){//视口初始化时
        MainActivity.Instance().Init(MainActivity.Instance().getAssets());
    }

    public void onSurfaceChanged(GL10 gl, int width, int height){//视口改变时
       MainActivity.Instance().OnViewportChanged(width, height);
    }

    public void onDrawFrame(GL10 gl){//绘制时候
      MainActivity.Instance().Render();
    }
}

class HnagyuGLSurfaceView extends GLSurfaceView{ //重载GLSurfaceView
    GLSurfaceView.Renderer mRenderer;//渲染器
    public HnagyuGLSurfaceView(Context context){
       super(context);
       setEGLContextClientVersion(2);//设置openGLES的版本号
        mRenderer = new HangyuGLSurfaceViewRenderer();//生成一个渲染器
        setRenderer(mRenderer);//设置渲染器
   }
}


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("baohangyu"); //会加载动态库
    }

    static  MainActivity mSelf;

    HnagyuGLSurfaceView mGLview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSelf = this;
        mGLview = new HnagyuGLSurfaceView(getApplication());//new一个视口
        setContentView(mGLview);//设置渲染视口
    }
    public static MainActivity Instance(){//实例化方法
        return mSelf;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //OpenGLES C++接口
    public native  void Init(AssetManager am);
    public native  void OnViewportChanged(int width, int height);
    public native  void Render();


}