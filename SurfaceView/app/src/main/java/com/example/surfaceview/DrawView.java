package com.example.surfaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {

    DrawThread drawThread;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new DrawThread(getHolder(), getContext());
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        drawThread.setTouchX((int) event.getX());
        drawThread.setTouchY((int) event.getY());

        return true;
    }
}

class DrawThread extends Thread {
    SurfaceHolder surfaceHolder;
    Paint paint = new Paint();
    Bitmap bitmap;

    int touchX, touchY;

    public DrawThread(SurfaceHolder surfaceHolder, Context context) {
        this.surfaceHolder = surfaceHolder;
        paint.setColor(context.getColor(R.color.colorPrimary));
        paint.setStyle(Paint.Style.FILL);

        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(), R.raw.smile), 256, 256, false);
    }

    @Override
    public void run() {
        super.run();
        int smileX = 0;
        int smileY = 0;
        while (true) {
            Canvas canvas = surfaceHolder.lockCanvas();
            canvas.drawPaint(paint);
            canvas.drawBitmap(bitmap, smileX, smileY, paint);
            if (smileX + bitmap.getWidth() / 2 < touchX) smileX += 10;
            if (smileX + bitmap.getWidth() / 2 > touchX) smileX -= 10;
            if (smileY + bitmap.getHeight() / 2 < touchY) smileY += 10;
            if (smileY + bitmap.getHeight() / 2 > touchY) smileY -= 10;
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }


    public void setTouchX(int touchX) {
        this.touchX = touchX;
    }

    public void setTouchY(int touchY) {
        this.touchY = touchY;
    }
}

