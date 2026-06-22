package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes.dex */
public class CircleImageView extends AppCompatImageView {
    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static Bitmap b(int i, Bitmap bitmap) {
        Bitmap bitmapCreateScaledBitmap;
        try {
            if (bitmap.getWidth() == i && bitmap.getHeight() == i) {
                bitmapCreateScaledBitmap = bitmap;
            } else {
                float fMin = Math.min(bitmap.getWidth(), bitmap.getHeight()) / i;
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / fMin), (int) (bitmap.getHeight() / fMin), false);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, i, i);
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(Color.parseColor("#BAB399"));
            float f = i / 2.0f;
            canvas.drawCircle(f, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmapCreateScaledBitmap, rect, rect, paint);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                super.onDraw(canvas);
                return;
            }
            if (getWidth() != 0 && getHeight() != 0) {
                Bitmap bitmapCopy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int width = getWidth();
                getHeight();
                canvas.drawBitmap(b(width, bitmapCopy), 0.0f, 0.0f, (Paint) null);
                return;
            }
            super.onDraw(canvas);
        } catch (Throwable unused) {
            super.onDraw(canvas);
        }
    }
}
