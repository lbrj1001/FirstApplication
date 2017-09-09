package com.liangbo.com.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 *
 * Created by Administrator on 2017/9/7.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
    SurfaceHolder holder=getHolder();
    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {

    }
}
