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

public class Practice7DrawRoundRectView extends View {

    private Paint mPaint;

    public Practice7DrawRoundRectView(Context context) {
        super(context);
        initPaint();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        //        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        canvas.drawRoundRect(getWidth() / 3, (getHeight() / 6) * 2, (getWidth() / 3) * 2, (getHeight() / 6) * 4, 20, 20, mPaint);
    }
}
