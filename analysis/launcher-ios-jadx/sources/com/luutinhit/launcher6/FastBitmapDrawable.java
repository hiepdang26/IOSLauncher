package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.bo1;
import defpackage.e51;
import defpackage.n20;
import defpackage.o20;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class FastBitmapDrawable extends Drawable {
    public static final n20 o = new n20(0);
    public static final SparseArray p = new SparseArray();
    public static final ColorMatrix q = new ColorMatrix();
    public static final ColorMatrix r = new ColorMatrix();
    public final Paint a;
    public final Bitmap b;
    public o20 c;
    public int d;
    public int e;
    public int f;
    public int g;
    public AnimatorSet h;
    public final float i;
    public final int j;
    public final RectF k;
    public final boolean l;
    public final Paint m;
    public ColorMatrixColorFilter n;

    public FastBitmapDrawable(t tVar, Bitmap bitmap) {
        this.a = new Paint(2);
        this.c = o20.NORMAL;
        this.d = 0;
        this.e = 0;
        this.f = 255;
        this.g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.l = false;
        this.m = new Paint();
        this.b = bitmap;
        setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        e(tVar);
    }

    public static ColorMatrixColorFilter b(int i, Bitmap bitmap) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        if (bitmap != null && d(bitmap) >= 0.6f) {
            colorMatrix.postConcat(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        }
        colorMatrix.postConcat(new ColorMatrix(new float[]{2.0f, 0.0f, 0.0f, 0.0f, -255.0f, 0.0f, 2.0f, 0.0f, 0.0f, -255.0f, 0.0f, 0.0f, 2.0f, 0.0f, -255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        colorMatrix.postConcat(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(i), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(i), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(i), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        return new ColorMatrixColorFilter(colorMatrix);
    }

    public static int c(o20 o20Var, o20 o20Var2) {
        int iOrdinal = o20Var2.ordinal();
        if (iOrdinal == 0) {
            int iOrdinal2 = o20Var.ordinal();
            if (iOrdinal2 != 1) {
                return (iOrdinal2 == 2 || iOrdinal2 == 3) ? 275 : 368;
            }
            return 0;
        }
        if (iOrdinal == 1) {
            return 368;
        }
        if (iOrdinal == 2) {
            return 225;
        }
        if (iOrdinal != 3) {
            return 0;
        }
        Objects.requireNonNull(o20Var);
        return o20Var == o20.NORMAL ? 225 : 150;
    }

    public static float d(Bitmap bitmap) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), bitmapCreateScaledBitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
        int width = bitmapCreateBitmap.getWidth();
        int height = bitmapCreateBitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmapCreateBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == -1) {
                i2++;
            }
        }
        float f = i2 / i;
        float f2 = 2;
        return f * f2 * f2;
    }

    public final boolean a(o20 o20Var) {
        o20 o20Var2 = this.c;
        int i = 0;
        if (o20Var2 == o20Var) {
            return false;
        }
        this.c = o20Var;
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.h = null;
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.h = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this, "desaturation", o20Var.g), ObjectAnimator.ofFloat(this, "brightness", o20Var.h));
        this.h.setInterpolator(o20Var.i);
        this.h.setDuration(c(o20Var2, o20Var));
        AnimatorSet animatorSet3 = this.h;
        if (o20Var == o20.FAST_SCROLL_UNHIGHLIGHTED) {
            Objects.requireNonNull(o20Var2);
            if (o20Var2 == o20.NORMAL) {
                i = 37;
            }
        }
        animatorSet3.setStartDelay(i);
        this.h.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z = this.l;
        Paint paint = this.a;
        Bitmap bitmap = this.b;
        if (!z) {
            canvas.drawBitmap(bitmap, (Rect) null, getBounds(), paint);
            return;
        }
        RectF rectF = this.k;
        Paint paint2 = this.m;
        float f = this.i;
        canvas.drawRoundRect(rectF, f, f, paint2);
        int i = this.j;
        canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, (i * 4) / 5, (i * 4) / 5, true), i / 10.0f, i / 10.0f, paint);
    }

    public final void e(t tVar) {
        bo1 tinyDB = tVar.getTinyDB();
        int i = tinyDB.a.getInt("color_icon_style", 1);
        if (i == 2) {
            g(tinyDB.a.getInt("color_tinted_app", -1));
        } else if (i == 0) {
            g(0);
        }
    }

    public final boolean f(o20 o20Var) {
        if (this.c == o20Var) {
            return false;
        }
        this.c = o20Var;
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.h = null;
        setDesaturation(o20Var.g);
        setBrightness(o20Var.h);
        return true;
    }

    public final void g(int i) {
        Paint paint = this.a;
        try {
            if (i == -1) {
                this.n = null;
                paint.setColorFilter(null);
            } else {
                Bitmap bitmap = this.b;
                if (i == 0) {
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.setSaturation(0.0f);
                    if (bitmap != null && d(bitmap) >= 0.5f) {
                        colorMatrix.postConcat(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
                    }
                    ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
                    this.n = colorMatrixColorFilter;
                    paint.setColorFilter(colorMatrixColorFilter);
                } else {
                    ColorMatrixColorFilter colorMatrixColorFilterB = b(i, bitmap);
                    this.n = colorMatrixColorFilterB;
                    paint.setColorFilter(colorMatrixColorFilterB);
                }
            }
            invalidateSelf();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.b.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.b.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0021 A[Catch: all -> 0x000d, TRY_LEAVE, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r9 = this;
            int r0 = r9.d     // Catch: java.lang.Throwable -> Ld
            r1 = -1
            r2 = 0
            if (r0 <= 0) goto L10
            int r0 = r0 << 16
            int r3 = r9.e     // Catch: java.lang.Throwable -> Ld
            r0 = r0 | r3
        Lb:
            r3 = 0
            goto L1b
        Ld:
            r0 = move-exception
            goto L91
        L10:
            int r0 = r9.e     // Catch: java.lang.Throwable -> Ld
            if (r0 <= 0) goto L19
            r3 = 65536(0x10000, float:9.1835E-41)
            r0 = r0 | r3
            r3 = 1
            goto L1b
        L19:
            r0 = -1
            goto Lb
        L1b:
            int r4 = r9.g     // Catch: java.lang.Throwable -> Ld
            if (r0 != r4) goto L21
            goto L94
        L21:
            r9.g = r0     // Catch: java.lang.Throwable -> Ld
            android.graphics.Paint r4 = r9.a
            if (r0 == r1) goto L88
            android.util.SparseArray r1 = com.luutinhit.launcher6.FastBitmapDrawable.p     // Catch: java.lang.Throwable -> Ld
            java.lang.Object r5 = r1.get(r0)     // Catch: java.lang.Throwable -> Ld
            android.graphics.ColorFilter r5 = (android.graphics.ColorFilter) r5     // Catch: java.lang.Throwable -> Ld
            if (r5 != 0) goto L84
            int r5 = r9.e     // Catch: java.lang.Throwable -> Ld
            float r5 = (float) r5     // Catch: java.lang.Throwable -> Ld
            r6 = 1111490560(0x42400000, float:48.0)
            float r5 = r5 / r6
            r7 = 1132396544(0x437f0000, float:255.0)
            float r7 = r7 * r5
            int r7 = (int) r7     // Catch: java.lang.Throwable -> Ld
            if (r3 == 0) goto L4b
            android.graphics.PorterDuffColorFilter r3 = new android.graphics.PorterDuffColorFilter     // Catch: java.lang.Throwable -> Ld
            int r2 = android.graphics.Color.argb(r7, r2, r2, r2)     // Catch: java.lang.Throwable -> Ld
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.SRC_ATOP     // Catch: java.lang.Throwable -> Ld
            r3.<init>(r2, r5)     // Catch: java.lang.Throwable -> Ld
            r5 = r3
            goto L81
        L4b:
            int r3 = r9.d     // Catch: java.lang.Throwable -> Ld
            float r3 = (float) r3     // Catch: java.lang.Throwable -> Ld
            float r3 = r3 / r6
            r6 = 1065353216(0x3f800000, float:1.0)
            float r3 = r6 - r3
            android.graphics.ColorMatrix r8 = com.luutinhit.launcher6.FastBitmapDrawable.r     // Catch: java.lang.Throwable -> Ld
            r8.setSaturation(r3)     // Catch: java.lang.Throwable -> Ld
            int r3 = r9.e     // Catch: java.lang.Throwable -> Ld
            if (r3 <= 0) goto L7b
            float r6 = r6 - r5
            android.graphics.ColorMatrix r3 = com.luutinhit.launcher6.FastBitmapDrawable.q     // Catch: java.lang.Throwable -> Ld
            float[] r5 = r3.getArray()     // Catch: java.lang.Throwable -> Ld
            r5[r2] = r6     // Catch: java.lang.Throwable -> Ld
            r2 = 6
            r5[r2] = r6     // Catch: java.lang.Throwable -> Ld
            r2 = 12
            r5[r2] = r6     // Catch: java.lang.Throwable -> Ld
            float r2 = (float) r7     // Catch: java.lang.Throwable -> Ld
            r6 = 4
            r5[r6] = r2     // Catch: java.lang.Throwable -> Ld
            r6 = 9
            r5[r6] = r2     // Catch: java.lang.Throwable -> Ld
            r6 = 14
            r5[r6] = r2     // Catch: java.lang.Throwable -> Ld
            r8.preConcat(r3)     // Catch: java.lang.Throwable -> Ld
        L7b:
            android.graphics.ColorMatrixColorFilter r2 = new android.graphics.ColorMatrixColorFilter     // Catch: java.lang.Throwable -> Ld
            r2.<init>(r8)     // Catch: java.lang.Throwable -> Ld
            r5 = r2
        L81:
            r1.append(r0, r5)     // Catch: java.lang.Throwable -> Ld
        L84:
            r4.setColorFilter(r5)     // Catch: java.lang.Throwable -> Ld
            goto L8d
        L88:
            android.graphics.ColorMatrixColorFilter r0 = r9.n     // Catch: java.lang.Throwable -> Ld
            r4.setColorFilter(r0)     // Catch: java.lang.Throwable -> Ld
        L8d:
            r9.invalidateSelf()     // Catch: java.lang.Throwable -> Ld
            return
        L91:
            r0.getMessage()
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.FastBitmapDrawable.h():void");
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f = i;
        this.a.setAlpha(i);
    }

    public void setBrightness(float f) {
        int iFloor = (int) Math.floor(f * 48.0f);
        if (this.e != iFloor) {
            this.e = iFloor;
            h();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public void setDesaturation(float f) {
        int iFloor = (int) Math.floor(f * 48.0f);
        if (this.d != iFloor) {
            this.d = iFloor;
            h();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        Paint paint = this.a;
        paint.setFilterBitmap(z);
        paint.setAntiAlias(z);
    }

    public FastBitmapDrawable(t tVar, Bitmap bitmap, int i, boolean z) {
        this.a = new Paint(2);
        this.c = o20.NORMAL;
        this.d = 0;
        this.e = 0;
        this.f = 255;
        this.g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.l = false;
        Paint paint = new Paint();
        this.m = paint;
        this.b = bitmap;
        this.l = z;
        setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (z) {
            this.j = i;
            this.i = tVar.getResources().getDimensionPixelSize(e51.icon_round_corner);
            float f = i;
            this.k = new RectF(0.0f, 0.0f, f, f);
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
        }
        e(tVar);
    }
}
