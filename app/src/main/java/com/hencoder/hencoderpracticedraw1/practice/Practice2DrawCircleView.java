package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.width;
import static android.support.v7.widget.AppCompatDrawableManager.get;

public class Practice2DrawCircleView extends View {

    private Paint mPaint;

    public Practice2DrawCircleView(Context context) {
        super(context);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void initPaint() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        drawCircle(canvas);
        drawStrokeCircle(canvas);
        drawBlueCircle(canvas);
        draw20PxStrokeCircle(canvas);
    }

    private void drawCircle(Canvas canvas) {
        //圆心坐标
        int x = getWidth() / 4;
        int y = getHeight() / 4;
        //半径
        int radius = getWidth() / 8;
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, mPaint);
    }

    private void drawStrokeCircle(Canvas canvas) {
        //圆心坐标
        int x = getWidth() / 4 * 3;
        int y = (getHeight() / 4);
        //半径
        int radius = getWidth() / 8;
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, y, radius, mPaint);
    }

    private void drawBlueCircle(Canvas canvas) {
        //圆心坐标
        int x = getWidth() / 4;
        int y = (getHeight() / 4) * 3;
        //半径
        int radius = getWidth() / 8;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#4a90e2"));
        mPaint.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, mPaint);
    }

    private void draw20PxStrokeCircle(Canvas canvas) {
        //圆心坐标
        int x = (getWidth() / 4) * 3;
        int y = (getHeight() / 4) * 3;
        //半径
        int radius = getWidth() / 8;
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(30);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(x, y, radius, mPaint);
    }


}
