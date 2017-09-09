package com.liangbo.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Administrator on 2017/8/9.
 */

public class MainView extends View {
    static int sQuareCount=50;
    static int beginX=0;
    static int beginY=0;
    Paint mPaint;
    int ScreenWidth;
    int sQuareLength;
    StrokeSquare goal;
    SquareList snake;
    public MainView(Context context,StrokeSquare goal,SquareList snake) {
        super(context);
        this.goal=goal;
        this.snake=snake;
        mPaint = new Paint();
    }

    public MainView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画正方形
        ScreenWidth = getMeasuredWidth();
        sQuareLength=ScreenWidth/sQuareCount;
        beginY=beginX=(ScreenWidth%sQuareCount)/2;
        SnakeFinalData.init(beginX,beginY,sQuareCount,sQuareLength);
        mPaint.setColor(Color.CYAN);
        mPaint.setStrokeWidth(1);
//        for (int i=0;i<=sQuareCount;i++)
//        {
//            canvas.drawLine(beginX+i*sQuareLength,beginY,beginX+i*sQuareLength,beginY+sQuareLength*sQuareCount,mPaint);
//            canvas.drawLine(beginX,beginY+i*sQuareLength,beginX+sQuareLength*sQuareCount,beginY+i*sQuareLength,mPaint);
//        }

        //画方块
        goal.drawSquare(canvas,mPaint);

        //画蛇
        snake.drawSnake(canvas,mPaint);
    }
}
