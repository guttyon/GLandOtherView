package com.example.jackjack.glandotherview;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/////////////////////////////////////////////////////////////////////////////
public class MainActivity extends Activity {

    private GLSurfaceView mGlView;
    private boolean mIsInitScreenSize;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // GLViewを取り出す
        this.mGlView = (GLSurfaceView)this.findViewById(R.id.glview1);
        this.mGlView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);

        // 描画用のクラスを登録する
        this.mGlView.setRenderer(new GLRender());
        this.mIsInitScreenSize = false;
    }

    /** 表示されるときの呼ばれる */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        // スクリーンサイズ調整が済んでいない場合は調整する
        if (this.mIsInitScreenSize == false) {
            int width = this.mGlView.getWidth();

            // GLSurfaceViewのサイズを変更する
            // ただ、背景色と違う色でGlSurfaceViewがクリアされていると、サイズ変更が丸見えになる
            // 親のレイアウトによってparamsを変更する必要がある
            // RelativeLayout使ってるならRelativeLayout.LayoutParams
            // LinearLayout使ってるならLinearLayout.LayoutParams

            //LinearLayout.LayoutParams params =
            //        new LinearLayout.LayoutParams(width, width);
            RelativeLayout.LayoutParams params =
                    new RelativeLayout.LayoutParams(width, width);
            this.mGlView.setLayoutParams(params);
        }

        super.onWindowFocusChanged(hasFocus);
    }
}



/////////////////////////////////////////////////////////////////////////////
//OpenGlの描画クラス(ただ塗りつぶすだけよ)
class GLRender implements GLSurfaceView.Renderer {

    /** コンストラクタ */
    public GLRender() {
    }

    /** 毎フレーム呼ばれるやつ */
    public void onDrawFrame(GL10 gl) {
        // ビューの塗りつぶし
        gl.glClearColor(1.0f, 0.5f, 0.5f, 1.f);
        // 各バッファのクリア
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }

    /** 描画領域が変更されたときに呼ばれる */
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // TODO 自動生成されたメソッド・スタブ

    }

    /** 描画領域が作られ時に呼ばれる */
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // TODO 自動生成されたメソッド・スタブ

    }

}