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

public class Practice5DrawOvalView extends View {

    private Paint mPaint;

    public Practice5DrawOvalView(Context context) {
        super(context);
        initPaint();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public void initPaint() {
        mPaint = new Paint();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawOval() 方法画椭圆
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        canvas.drawOval(getWidth() / 3, (getHeight() - 100) / 2, (getWidth() / 3) * 2,
                (getHeight() - 50) / 2 + 100, mPaint);
    }
}
