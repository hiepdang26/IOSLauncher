package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.BlurScreenLayout;
import com.luutinhit.launcher6.util.BadgeTextView;
import defpackage.ar1;
import defpackage.e51;
import defpackage.fd;
import defpackage.g61;
import defpackage.l51;
import defpackage.pk0;
import defpackage.rl0;
import defpackage.wc;
import defpackage.yc;
import defpackage.zc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BlurScreenLayout extends InsertAbleFrameLayout {
    public static final /* synthetic */ int q = 0;
    public final float g;
    public final Paint h;
    public boolean i;
    public int j;
    public View k;
    public final t l;
    public final Handler m;
    public final Handler n;
    public BitmapDrawable o;
    public boolean p;

    public BlurScreenLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0.125f;
        this.p = false;
        if (context instanceof t) {
            this.l = (t) context;
        }
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        this.m = new Handler(rl0.w.getLooper(), new yc(this, 0));
        this.n = new Handler(Looper.getMainLooper(), new yc(this, 1));
        this.g = 1.0f / getResources().getInteger(g61.down_sample_factor);
    }

    public static Bitmap b(BlurScreenLayout blurScreenLayout, View view) {
        Bitmap bitmapA;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmapC;
        t tVar = blurScreenLayout.l;
        Bitmap bitmapF = null;
        try {
            bitmapC = blurScreenLayout.c(tVar.getDragLayer());
        } catch (Throwable th) {
            th = th;
            bitmapA = null;
            bitmapCreateBitmap = null;
        }
        if (bitmapC == null) {
            return null;
        }
        try {
            boolean zIsOpeningFolder = tVar.isOpeningFolder();
            float f = blurScreenLayout.g;
            if (zIsOpeningFolder && tVar.showingFloatingMenu) {
                bitmapA = ar1.a(bitmapC, f);
                try {
                    if (bitmapC.isRecycled()) {
                        return bitmapA;
                    }
                    bitmapC.recycle();
                    return bitmapA;
                } catch (Throwable th2) {
                    th = th2;
                    bitmapCreateBitmap = null;
                }
            } else {
                bitmapCreateBitmap = tVar.getBlurWallpaperProvider().e;
                if (bitmapCreateBitmap != null) {
                    try {
                        bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, tVar.screenWidth, tVar.screenHeight);
                    } catch (Throwable th3) {
                        th = th3;
                        bitmapA = bitmapF;
                    }
                }
                if ((bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled()) && (bitmapCreateBitmap = blurScreenLayout.getBlurImageFromStorage()) == null) {
                    bitmapCreateBitmap = BitmapFactory.decodeResource(blurScreenLayout.getResources(), l51.blur_default);
                }
                bitmapF = view == null ? bitmapC : blurScreenLayout.f(bitmapC, view);
                bitmapA = ar1.a(bitmapF, f);
                if (bitmapF != null && !bitmapF.isRecycled()) {
                    bitmapF.recycle();
                }
                if (bitmapCreateBitmap == null || bitmapA == null) {
                    return bitmapCreateBitmap != null ? bitmapCreateBitmap : bitmapA;
                }
                try {
                    return e(bitmapCreateBitmap, bitmapA);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            bitmapA = bitmapF;
            bitmapCreateBitmap = bitmapA;
        }
        bitmapF = bitmapC;
        th.getMessage();
        if (bitmapF != null && !bitmapF.isRecycled()) {
            bitmapF.recycle();
        }
        return bitmapCreateBitmap != null ? bitmapCreateBitmap : bitmapA;
    }

    public static Bitmap e(Bitmap bitmap, Bitmap bitmap2) {
        boolean zIsRecycled;
        Objects.toString(bitmap);
        Objects.toString(bitmap2);
        try {
        } catch (Throwable th) {
            try {
                th.getMessage();
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            } finally {
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            }
        }
        if (bitmap.isRecycled()) {
            if (!bitmap2.isRecycled()) {
                if (!zIsRecycled) {
                    return bitmap2;
                }
                return bitmap2;
            }
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
                return null;
            }
        } else {
            if (bitmap2.isRecycled()) {
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                return bitmap;
            }
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap2.getConfig());
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, width, height), (Paint) null);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                return bitmapCreateBitmap;
            }
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getAppsLibraryBlurBackground() {
        try {
            Bitmap bitmapA = ar1.a(c(this.l.getDragLayer()), this.g);
            if (bitmapA != null) {
                return bitmapA;
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private Bitmap getBlurImageFromStorage() {
        t tVar = this.l;
        try {
            return BitmapFactory.decodeStream(new FileInputStream(new File(new ContextWrapper(tVar).getDir("image", 0), "blur")));
        } catch (FileNotFoundException e) {
            e.getMessage();
            fd blurWallpaperProvider = tVar.getBlurWallpaperProvider();
            blurWallpaperProvider.getClass();
            ar1.q.execute(blurWallpaperProvider.p);
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [xc] */
    public final Bitmap c(DragLayer dragLayer) {
        Bitmap bitmapC = ar1.c(dragLayer);
        if (bitmapC != null) {
            bitmapC.toString();
            return bitmapC;
        }
        boolean z = ar1.d;
        t tVar = this.l;
        if (z) {
            Window window = tVar.getWindow();
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getMeasuredWidth(), dragLayer.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                int[] iArr = new int[2];
                dragLayer.getLocationInWindow(iArr);
                int i = iArr[0];
                try {
                    PixelCopy.request(window, new Rect(i, iArr[1], dragLayer.getWidth() + i, iArr[1] + dragLayer.getHeight()), bitmapCreateBitmap, (PixelCopy.OnPixelCopyFinishedListener) new PixelCopy.OnPixelCopyFinishedListener() { // from class: xc
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public final void onPixelCopyFinished(int i2) {
                            BlurScreenLayout blurScreenLayout = this.a;
                            if (i2 == 0) {
                                blurScreenLayout.p = true;
                            } else {
                                int i3 = BlurScreenLayout.q;
                                blurScreenLayout.getClass();
                            }
                        }
                    }, new Handler());
                } catch (Throwable th) {
                    th.getMessage();
                }
                bitmapC = bitmapCreateBitmap;
            } catch (Throwable th2) {
                th2.getMessage();
                bitmapC = null;
            }
            Objects.toString(bitmapC);
            if (this.p && bitmapC != null && bitmapC.getWidth() > 0 && bitmapC.getHeight() > 0) {
                this.p = false;
                return bitmapC;
            }
        }
        if (tVar.getDragController() != null) {
            tVar.getDragController().getClass();
            dragLayer.clearFocus();
            dragLayer.setPressed(false);
            boolean zWillNotCacheDrawing = dragLayer.willNotCacheDrawing();
            dragLayer.setWillNotCacheDrawing(false);
            int drawingCacheBackgroundColor = dragLayer.getDrawingCacheBackgroundColor();
            dragLayer.setDrawingCacheBackgroundColor(0);
            float alpha = dragLayer.getAlpha();
            dragLayer.setAlpha(1.0f);
            if (drawingCacheBackgroundColor != 0) {
                dragLayer.destroyDrawingCache();
            }
            dragLayer.buildDrawingCache();
            Bitmap drawingCache = dragLayer.getDrawingCache();
            if (drawingCache == null) {
                dragLayer.toString();
                new RuntimeException();
                bitmapC = null;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(drawingCache);
                dragLayer.destroyDrawingCache();
                dragLayer.setAlpha(alpha);
                dragLayer.setWillNotCacheDrawing(zWillNotCacheDrawing);
                dragLayer.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
                bitmapC = bitmapCreateBitmap2;
            }
            Objects.toString(bitmapC);
            if (bitmapC != null) {
                return bitmapC;
            }
        }
        View decorView = tVar.getWindow().getDecorView();
        if (decorView.getWidth() <= 0 || decorView.getHeight() <= 0) {
            return null;
        }
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache2 = decorView.getDrawingCache();
        if (drawingCache2 != null) {
            bitmapC = Bitmap.createBitmap(drawingCache2);
        }
        decorView.setDrawingCacheEnabled(false);
        Objects.toString(bitmapC);
        return bitmapC;
    }

    public final void d(boolean z) {
        if (this.l.isOpeningSearchView() && getBackground() == null) {
            return;
        }
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        getBackground();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, Key.ALPHA, 0.0f).setDuration((long) ((getAlpha() > 0.0f ? getAlpha() : 1.0f) * 255.0f));
        duration.addListener(new zc(this, z, 0));
        if (duration.isRunning()) {
            return;
        }
        duration.getDuration();
        duration.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Objects.toString(Looper.myLooper());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new wc(this, canvas, 0));
            return;
        }
        if (this.i) {
            int width = getWidth();
            synchronized (canvas) {
                try {
                    try {
                        canvas.drawRect(width - this.j, 0.0f, width, getHeight(), this.h);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    public final Bitmap f(Bitmap bitmap, View view) {
        float f;
        float dimensionPixelSize;
        float width;
        float height;
        float width2;
        float height2;
        BadgeTextView badgeTextView;
        Objects.toString(view);
        Objects.toString(Looper.myLooper());
        if (bitmap.isRecycled() || view == null) {
            return null;
        }
        int[] locationWidget = new int[2];
        boolean z = view instanceof BubbleTextView;
        if (z) {
            locationWidget = ((BubbleTextView) view).getLocationIcon();
        } else if (view instanceof pk0) {
            locationWidget = ((pk0) view).getLocationWidget();
        } else {
            view.getLocationOnScreen(locationWidget);
        }
        int i = locationWidget[0];
        int i2 = locationWidget[1];
        t tVar = this.l;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, tVar.screenWidth, tVar.screenHeight, true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(tVar.screenWidth, tVar.screenHeight, bitmapCreateScaledBitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if (!bitmapCreateScaledBitmap.isRecycled()) {
            bitmapCreateScaledBitmap.recycle();
        }
        if (z) {
            dimensionPixelSize = getResources().getDimensionPixelSize(e51.icon_round_corner) * 1.1f;
            float f2 = (tVar.getDeviceProfile().D * 0.1f) / 2.0f;
            width = locationWidget[0] - f2;
            height = locationWidget[1] - f2;
            width2 = (tVar.getDeviceProfile().D * 1.1f) + width;
            height2 = (tVar.getDeviceProfile().D * 1.1f) + height;
            f = 1.1f;
        } else {
            float f3 = 1.6f;
            if (view instanceof pk0) {
                pk0 pk0Var = (pk0) view;
                int width3 = pk0Var.getWidth();
                int height3 = pk0Var.getHeight() - pk0Var.q;
                f = 1.1f;
                float dimensionPixelSize2 = getResources().getDimensionPixelSize(e51.icon_round_corner);
                if (width3 <= tVar.getDeviceProfile().H && height3 <= tVar.getDeviceProfile().I) {
                    f3 = 1.0f;
                }
                float f4 = width3;
                float f5 = height3;
                float f6 = locationWidget[0] - ((f4 * 0.05f) / 2.0f);
                height = locationWidget[1] - ((0.05f * f5) / 2.0f);
                dimensionPixelSize = dimensionPixelSize2 * f3;
                width2 = (f4 * 1.05f) + f6;
                width = f6;
                height2 = (f5 * 1.05f) + height;
            } else {
                f = 1.1f;
                dimensionPixelSize = getResources().getDimensionPixelSize(e51.icon_round_corner) * 1.6f;
                width = locationWidget[0] - ((view.getWidth() * 0.05f) / 2.0f);
                height = locationWidget[1] - ((view.getHeight() * 0.05f) / 2.0f);
                width2 = (view.getWidth() * 1.05f) + width;
                height2 = (view.getHeight() * 1.05f) + height;
            }
        }
        canvas.drawRoundRect(new RectF(width, height, width2, height2), dimensionPixelSize, dimensionPixelSize, paint);
        Objects.toString(Looper.myLooper());
        if (z && (badgeTextView = ((BubbleTextView) view).v) != null && badgeTextView.getVisibility() == 0) {
            Objects.toString(Looper.myLooper());
            canvas.drawCircle(width2, height, ((getResources().getDimensionPixelSize(e51.icon_badge_size) - 2.0f) / 2.0f) * f, paint);
            Objects.toString(Looper.myLooper());
        }
        Objects.toString(Looper.myLooper());
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        boolean z = rect.right > 0 && (!ar1.i || ((ActivityManager) getContext().getSystemService(ActivityManager.class)).isLowRamDevice());
        this.i = z;
        this.j = rect.right;
        setInsets(z ? new Rect(0, rect.top, 0, rect.bottom) : rect);
        View view = this.k;
        if (view != null && this.i) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i = marginLayoutParams.leftMargin;
            int i2 = rect.left;
            if (i != i2 || marginLayoutParams.rightMargin != rect.right) {
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = rect.right;
                this.k.setLayoutParams(marginLayoutParams);
            }
        }
        return true;
    }

    public Bitmap getBlurBitmap() {
        BitmapDrawable bitmapDrawable = this.o;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getBitmap();
        }
        return null;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        if (getChildCount() > 0) {
            this.k = getChildAt(0);
        }
        super.onFinishInflate();
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
    }
}
