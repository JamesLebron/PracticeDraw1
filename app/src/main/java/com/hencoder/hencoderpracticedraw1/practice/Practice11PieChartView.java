package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private Path mPath;
    private List<PhoneData> mPhoneData = new ArrayList<>();
    private String[] mColors = {"#2196f3", "#009688", "#9e9e9e", "#9c27b0", "#509e6a", "#f44336", "#ffc107"};
    //    private int[] mColors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.WHITE, Color.CYAN};
    private float mPerDegree;
    private int mArcMagrin = 2;
    private int mRadius = 0;

    public Practice11PieChartView(Context context) {
        super(context);
        initPaint();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mRadius = (getMeasuredHeight() - 100) / 2;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPath = new Path();
        //初始化数据
        mPhoneData.add(new PhoneData("Foyo", 10));
        mPhoneData.add(new PhoneData("GB", 20));
        mPhoneData.add(new PhoneData("ICS", 30));
        mPhoneData.add(new PhoneData("JB", 40));
        mPhoneData.add(new PhoneData("Kitkat", 70));
        mPhoneData.add(new PhoneData("L", 80));
        mPhoneData.add(new PhoneData("M", 100));
        //计算数据总量
        int allNum = 0;
        for (PhoneData phoneData : mPhoneData) {
            allNum = phoneData.getPhoneUseNum() + allNum;
        }
        //将数据排序,最后画最大的,因为最大的圆心需要移动,分隔开
        Collections.sort(mPhoneData, new Comparator<PhoneData>() {
            @Override
            public int compare(PhoneData o1, PhoneData o2) {
                return o1.getPhoneUseNum() - o2.getPhoneUseNum();
            }
        });
        //每份占比多少度,总共是360度,去除4个饼之间的间隙(5度)
        mPerDegree = (360 - 6 * mArcMagrin) / (float) allNum;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setAntiAlias(true);
        int left = 60;
        int right = left + mRadius * 2;
        int top = 10;
        int bottom = mRadius * 2;
        //lastDegree是上次绘制之后的最终角度,需要记录下来
        int lastDegree = 0;
        //这次需要旋转的角度
        int swapeDegree = 0;
        for (int i = 0; i < mPhoneData.size(); i++) {
            mPaint.setColor(Color.parseColor(mColors[i]));
            //根据获取的值,计算旋转的角度
            swapeDegree = (int) (mPhoneData.get(i).getPhoneUseNum() * mPerDegree);
            //当是最后一次旋转的时候,移动top.right... 可以理解为圆心来实现块的效果
            if (i == mPhoneData.size() - 1) {
                canvas.drawArc(left + 10, top - 10, right + 10, bottom - 10, lastDegree, swapeDegree, true, mPaint);
            } else {
                canvas.drawArc(left, top, right, bottom, lastDegree, swapeDegree, true, mPaint);
                //选中之后,设置最终角度
                lastDegree = lastDegree + swapeDegree + mArcMagrin;
            }
        }
    }
}
