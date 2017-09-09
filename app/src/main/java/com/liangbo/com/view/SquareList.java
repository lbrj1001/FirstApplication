package com.liangbo.com.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */

public class SquareList {
    public static final int Up = 1;
    public static final int Down = -1;
    public static final int Left = -2;
    public static final int Right = 2;
    int CurDirection;
    StrokeSquare goal = null;
    //该list用于存储贪吃蛇,贪吃蛇运动规律为将尾巴设为脑袋，遇到障碍，障碍成为脑袋
    //list头存放脑袋,list尾存放尾巴
    static List<StrokeSquare> list = new LinkedList<StrokeSquare>();

    public SquareList(int count) {
        for (int i = 0; i < count; i++) {
            list.add(0, new StrokeSquare(i, 25));
        }
        CurDirection = Right;
    }

    /**
     * snake move one step
     *
     * @param direction
     */
    public void move(int direction) {
        CurDirection = direction;
        StrokeSquare square = null;
        try {
            square = list.get(0).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if(isAddTail(square,goal))
        {
            addTail();
            goal.Update();
            return;
        }
        switch (direction) {
            case Up:
                square.y -= 1;
                break;
            case Down:
                square.y += 1;
                break;
            case Left:
                square.x -= 1;
                break;
            case Right:
                square.x += 1;
                break;
        }
        if (square.x == 50) {
            square.x = 0;
        }
        ;
        if (square.x == -1) {
            square.x = 49;
        }
        ;
        if (square.y == 50) {
            square.y = 0;
        }
        ;
        if (square.y == -1) {
            square.y = 49;
        }
        ;
        list.remove(list.size() - 1);
        list.add(0, square);

    }

    void drawSnake(Canvas canvas, Paint mpaint) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).drawSquare(canvas, mpaint);
        }
    }

    /**
     * 此处贪吃蛇只负责找目标，不会吃目标
     * @return
     */
    public boolean findGoal() {
        StrokeSquare head = list.get(0);
        switch (CurDirection) {
            case Up:
                if (head.y == goal.y) {
                    if (head.x < goal.x) {
                        this.move(Left);
                    } else if (head.x > goal.x) {
                        this.move(Right);
                    }
                } else {
                    this.move(Up);
                }
            case Down:
                if (head.y == goal.y) {
                    if (head.x < goal.x) {
                        this.move(Left);
                    } else if (head.x > goal.x) {
                        this.move(Right);
                    }
                } else {
                    this.move(Down);
                }
            case Left:
                if (head.x == goal.x) {
                    if (head.y < goal.y) {
                        this.move(Down);
                    } else if (head.y > goal.y) {
                        this.move(Up);
                    }
                } else {
                    this.move(Left);
                }
            case Right:
                if (head.x == goal.x) {
                    if (head.y < goal.y) {
                        this.move(Down);
                    } else if (head.y > goal.y) {
                        this.move(Up);
                    }
                } else {
                    this.move(Right);
                }

        }
        return goal.isEat();
    }

    Handler handler;

    /**
     * 如果要吃的话就不走那一步了，直接将目标作为头
     * @param head
     * @param goal
     * @return
     */
    public boolean isAddTail(StrokeSquare head,StrokeSquare goal)
    {
        int deltaX=head.x-goal.x;
        int deltaY=head.y-goal.y;
        if(deltaX==0)
        {
            if(deltaY==1||deltaY==-49)
            {
                CurDirection=Up;
                return true;
            }
            else if(deltaY==-1||deltaY==49)
            {
                CurDirection=Down;
                return true;
            }

        }
        else if(deltaY==0)
        {
            if(deltaX==1||deltaX==-49)
            {
                CurDirection=Left;
                return true;
            }
            else if(deltaX==-1||deltaX==49)
            {
                CurDirection=Right;
                return true;
            }
        }
        return false;
    }
    public void addTail() {
        try {
            list.add(0,goal.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    public void setGoal(StrokeSquare goal)
    {
        this.goal=goal;
    }
    public void DefaultMove(final View view, final StrokeSquare goal) {
        setGoal(goal);
        handler = new Handler(
                new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        view.invalidate();
                        return true;
                    }
                }
        );
        thread.start();
    }

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    findGoal();
                    handler.sendEmptyMessage(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });
}
