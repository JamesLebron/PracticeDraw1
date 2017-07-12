package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint mPaint;

    public Practice8DrawArcView(Context context) {
        super(context);
        initPaint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public void initPaint() {
        mPaint = new Paint();
    }

    /**
     * @param canvas drawArc() 是使用一个椭圆来描述弧形的。
     *               left, top, right, bottom 描述的是这个弧形所在的椭圆；
     *               startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）
     *               sweepAngle 是弧形划过的角度；
     *               useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int left = getWidth() / 3;
        int right = getWidth() - left;
        int top = getHeight() / 3;
        int bottom = getHeight() - top;
        //画扇形
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(left, top, right, bottom, -110, 100, true, mPaint);
        //画弧形,可以使用true和false.来运行看效果,实际上是去掉了两点之间连接之后和原点形成的三角形,去掉了这个三角形
        canvas.drawArc(left, top, right, bottom, 20, 140, false, mPaint);
        //画扇形点
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(left, top, right, bottom, 180, 60, false, mPaint); // 绘制不封口的弧形
    }
}
