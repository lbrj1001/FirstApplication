package com.liangbo.com.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Administrator on 2017/8/10.
 */

public class StrokeSquare implements Cloneable{
    public StrokeSquare()
    {
        x=(int)(Math.random()*50);
        y=(int)(Math.random()*50);
    }
    public StrokeSquare(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public boolean isEat() {
        return isEat;
    }

    public void setEat(boolean eat) {
        isEat = eat;
    }

    void drawSquare(Canvas canvas, Paint mPaint)
    {
        rect.set(SnakeFinalData.beginX+x*SnakeFinalData.squareLength,
                SnakeFinalData.beginY+y*SnakeFinalData.squareLength,
                SnakeFinalData.beginX+(x+1)*SnakeFinalData.squareLength,
                SnakeFinalData.beginY+(y+1)*SnakeFinalData.squareLength+1);
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rect,mPaint);
    }

    @Override
    protected StrokeSquare clone() throws CloneNotSupportedException {
        return (StrokeSquare) super.clone();
    }

    public synchronized void  Update()
    {
        x=(int)(Math.random()*50);
        y=(int)(Math.random()*50);
        isEat=false;
    }
    static Rect rect=new Rect(0,0,1,1);
    int x;//逻辑坐标x
    int y;//逻辑坐标y
    boolean isEat;
}
