package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    private Paint mPaint;

    public Practice3DrawRectView(Context context) {
        super(context);
        initPaint();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public void initPaint() {
        mPaint = new Paint();
    }

    /**
     * @param canvas /**
     *               Draw the specified Rect using the specified paint. The rectangle will
     *               be filled or framed based on the Style in the paint.
     * @param left   The left side of the rectangle to be drawn
     * @param top    The top side of the rectangle to be drawn
     * @param right  The right side of the rectangle to be drawn
     * @param bottom The bottom side of the rectangle to be drawn
     * @param paint  The paint used to draw the rect
     *               <p>
     *               <p>
     *               left和right是矩形的边离X轴的距离,可以利用Width 来计算
     *               top和bottom是矩形的边离Y轴的距离,可以利用Height来计算
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawRect() 方法画矩形
        //画正方形 定义正方形的边长为240,然后计算其他的left ...等
        int length = 270;
        int left = (getWidth() - length) / 2;
        int top = (getHeight() - length) / 2;
        int right = left + length;
        int bottom = top + length;
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
