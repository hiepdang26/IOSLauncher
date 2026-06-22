package com.luutinhit.weather;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.ar1;
import defpackage.l51;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWeatherLayout extends ConstraintLayout {
    public final int g;
    public final int h;

    public ConstraintWeatherLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            Point point = new Point();
            if (ar1.o) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            this.g = point.x;
            this.h = point.y;
        }
    }

    public void setBackground(int i) {
        try {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), i);
            if (bitmapDecodeResource != null) {
                int width = bitmapDecodeResource.getWidth();
                bitmapDecodeResource.getHeight();
                int i2 = this.g;
                if (width > i2) {
                    bitmapDecodeResource = Bitmap.createScaledBitmap(bitmapDecodeResource, i2, this.h, true);
                }
                setBackground(new BitmapDrawable(getResources(), bitmapDecodeResource));
            }
        } catch (Throwable unused) {
            setBackgroundResource(l51.weather_background_default);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        ObjectAnimator duration = ObjectAnimator.ofInt(drawable, Key.ALPHA, 0, 255).setDuration(600L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }
}
