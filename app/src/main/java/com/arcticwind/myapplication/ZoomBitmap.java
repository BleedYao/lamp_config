package com.arcticwind.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

public class ZoomBitmap {
    /**
     * 放缩图片
     *
     * @param bgimage
     * @param newWidth
     * @return
     */
    public static Bitmap zoomImage(Bitmap bgimage, double newWidth) {
        ///< ��ȡ���ͼƬ�Ŀ�͸�
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        ///< ��������ͼƬ�õ�matrix����
        Matrix matrix = new Matrix();
        ///< ������������
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = scaleWidth / (width / height);
        //float scaleHeight = ((float) newHeight) / height;
        ///< ����ͼƬ����
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        bgimage.recycle();
        bgimage = null;
        System.gc();

        return bitmap;
    }

    /**
     * 放缩图片
     *
     * @param bgimage
     * @param newWidth
     * @param newHeight
     * @return
     */
    public static Bitmap zoomImage(Bitmap bgimage, double newWidth, double newHeight) {
        ///< 获取图片的宽高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        ///< ��������ͼƬ�õ�matrix����
        Matrix matrix = new Matrix();
        ///< ������������
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        ///< ����ͼƬ����
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        bgimage.recycle();
        bgimage = null;
        System.gc();

        return bitmap;
    }

    /**
     * 将drawable转换成bitmap
     *
     * @param drawable
     * @return
     */
    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(
                drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        //canvas.setBitmap(bitmap);
        System.out.println("图片实际的大小是" + drawable.getIntrinsicWidth() + "^" + drawable.getIntrinsicHeight());
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 将bitmap透明化
     *
     * @param sourceImg
     * @param number    透明度:0全透明看不到~~~~~255不透明
     * @return
     */
    public static Bitmap getTransparentBitmap(Bitmap sourceImg, int number) {
        Bitmap bb = Bitmap.createBitmap(sourceImg.getWidth(), sourceImg.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bb);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);   //空心
        paint.setAlpha(number);
        c.drawBitmap(sourceImg, 0, 0, paint);
        sourceImg.recycle();
        return bb;
    }

    public static Bitmap ColorBitmap(int w, int h, int color) {

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(color);
        return bitmap;
    }

}
