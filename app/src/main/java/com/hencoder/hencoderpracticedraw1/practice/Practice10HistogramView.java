package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class Practice10HistogramView extends View {

    private Paint mPaint;
    private int retangleNum = 7;
    private int marginTop = 20;
    private int marginLeft = 60;
    private int marginRight = 60;
    private int marginBottom = 60;
    //这个XY轴图形的宽度
    private int mViewWidth;
    //每一个柱体的宽度
    private int mPerViewWidth;
    //柱体之间的间隔
    private int perViewMargin = 15;
    private List<PhoneData> mPhoneData = new ArrayList<>();
    //这个XY轴图形的高度
    private int mViewHeight;
    //以phoneData里面的数据,来计算每份的高度,最终的高度=mPerHeight * PhoneData.getPhoneUseNum
    private float mPerHeight;


    public Practice10HistogramView(Context context) {
        super(context);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPhoneData.add(new PhoneData("Foyo", 10));
        mPhoneData.add(new PhoneData("GB", 20));
        mPhoneData.add(new PhoneData("ICS", 30));
        mPhoneData.add(new PhoneData("JB", 40));
        mPhoneData.add(new PhoneData("Kitkat", 70));
        mPhoneData.add(new PhoneData("L", 80));
        mPhoneData.add(new PhoneData("M", 100));
        mPaint = new Paint();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initWidth();
    }

    private void initWidth() {
        mViewWidth = getMeasuredWidth() - marginLeft - marginRight;
        mViewHeight = getMeasuredHeight() - marginTop - marginBottom;
        mPerHeight = mViewHeight / 100;
        mPerViewWidth = (mViewWidth - (retangleNum + 1) * perViewMargin) / retangleNum;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //画X轴Y轴
        drawXY(canvas);
        //画文字
        drawText(canvas);
        //画树状图
        drawRetangle(canvas);
    }


    /**
     * 画XY轴
     *
     * @param canvas
     */
    private void drawXY(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(marginLeft, marginTop, marginLeft, getHeight() - marginBottom, mPaint);
        canvas.drawLine(marginLeft, getHeight() - marginBottom,
                getWidth() - marginRight, getHeight() - marginBottom, mPaint);

    }

    /**
     * 画文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        mPaint.setTextSize(16);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextAlign(Paint.Align.CENTER);
        int y = getHeight() - marginBottom + 15;
        for (int i = 0; i < retangleNum; i++) {
            int x = (i + 1) * perViewMargin + i * mPerViewWidth + marginLeft;
            canvas.drawText(mPhoneData.get(i).getPhoneName(), x + 30, y, mPaint);
            Log.d("Practice10HistogramView", "x:" + x);
        }
    }

    /**
     * 画矩形柱体
     *
     * @param canvas
     */
    private void drawRetangle(Canvas canvas) {
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#72b916"));
        for (int i = 0; i < retangleNum; i++) {
            int left = marginLeft + (i + 1) * perViewMargin + i * mPerViewWidth;
            int right = left + mPerViewWidth;
            int top = (int) (getHeight() - marginBottom - mPhoneData.get(i).getPhoneUseNum() * mPerHeight + marginTop);
            int bottom = getHeight() - marginBottom;
            canvas.drawRect(left, top, right, bottom, mPaint);
            Log.d("Practice10HistogramView", "left:" + left + " right:" + right + " top:" + top + " bottom:" + bottom);
        }
    }
}
