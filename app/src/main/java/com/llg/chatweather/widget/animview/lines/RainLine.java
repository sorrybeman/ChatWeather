package com.llg.chatweather.widget.animview.lines;

/**
 * create by loogen on 2019-4-9
 */
public class RainLine extends BaseLine {


    public RainLine(int maxX, int maxY) {
        super(maxX, maxY);
    }

    @Override
    public void change() {
        int Dy = 10;
        if (mStartY + Dy > mMaxY) {
            mStartY = 0;
            //一次下落后随机改变x坐标
            mStartX = mRandom.nextInt(mMaxX);
        } else {
            mStartY += Dy;
        }
    }
}
