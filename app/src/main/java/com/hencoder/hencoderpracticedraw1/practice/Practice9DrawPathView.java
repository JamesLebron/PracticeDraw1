package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 在这个例子中耗费了过多的时间,因为始终无法理解forceMoveTo这个参数的意思,也无法理解这个path 的移动路径
 * 就是这个Point在整个path 的移动
 */
public class Practice9DrawPathView extends View {

    private Paint mPaint;
    private Path mPath;
    private int heartRadius = 50;

    public Practice9DrawPathView(Context context) {
        super(context);
        initPaint();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPath = new Path();
    }

    //练习内容：使用 canvas.drawPath() 方法画心形
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        float x = (getWidth() - heartRadius * 4) / 2;
        float y = getHeight() / 2;
        mPath.moveTo(x, y);
        //先画左边的半圆
        float left = (getWidth() / 2) - heartRadius * 2;
        float top = (getHeight() / 2) - heartRadius * 2;
        float right = left + heartRadius * 2;
        float bottom = top + heartRadius * 2;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.arcTo(left, top, right, bottom, -220, 220, true);
        }
        //再画右边的半圆
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.arcTo(right, top, right + heartRadius * 2, bottom, -180, 220, false);
        }
        //右边的半圆的点连接到桃心底部
        mPath.lineTo(x + heartRadius * 2, (getHeight() / 3) * 2);
        canvas.drawPath(mPath, mPaint);
        //桃心底部自动连接Path起点,自动Close
    }
}
