package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.t;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class h90 extends View {
    public final Paint g;
    public final RuntimeShader h;
    public Bitmap i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public final int[] q;
    public final int[] r;
    public final Handler s;
    public final boolean t;
    public final Path u;
    public final ConcurrentLinkedQueue v;
    public final ExecutorService w;

    public h90(Context context, boolean z) {
        super(context, null);
        Paint paint = new Paint(1);
        this.g = paint;
        this.j = 0.25f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = new int[2];
        this.r = new int[]{-1, -1};
        this.u = new Path();
        this.v = new ConcurrentLinkedQueue();
        this.w = Executors.newFixedThreadPool(2);
        this.t = z;
        RuntimeShader runtimeShaderA = k0.a(z71.i(context, os.c));
        this.h = runtimeShaderA;
        paint.setAntiAlias(true);
        paint.setShader(runtimeShaderA);
        HandlerThread handlerThread = new HandlerThread("PixelCopyThread");
        handlerThread.start();
        this.s = new Handler(handlerThread.getLooper());
        runtimeShaderA.setFloatUniform("u_RefractionHeight", b(12.0f));
        runtimeShaderA.setFloatUniform("u_RefractionAmount", b(-50.0f));
        runtimeShaderA.setFloatUniform("u_DepthEffect", 1.0f);
        runtimeShaderA.setFloatUniform("u_Scale", 1.0f, 1.0f);
        runtimeShaderA.setFloatUniform("u_StrokeWidth", b(1.6f));
        if (z) {
            getViewBitmap();
        }
    }

    public static void c(DragLayer dragLayer, f90 f90Var) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getWidth(), dragLayer.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = dragLayer.getBackground();
        if (background != null) {
            background.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            background.draw(canvas);
        }
        dragLayer.draw(canvas);
        f90Var.a(bitmapCreateBitmap);
    }

    public static boolean d(float f, float f2, float f3, float f4, float f5, float f6) {
        return f < f5 && f + f3 > 0.0f && f2 < f6 && f2 + f4 > 0.0f;
    }

    public static Bitmap e(Bitmap bitmap, Bitmap bitmap2, float f) {
        Bitmap bitmap3;
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap2;
        }
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return bitmap;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        bitmap2.getWidth();
        bitmap2.getHeight();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMax = Math.max(1, Math.round(width / f));
        int iMax2 = Math.max(1, Math.round(height / f));
        Bitmap bitmapA = null;
        try {
            System.nanoTime();
            if (!bitmap.isRecycled()) {
                if (bitmap2.isRecycled()) {
                    bitmap2 = bitmap;
                } else {
                    float width2 = bitmap2.getWidth();
                    float height2 = bitmap2.getHeight();
                    if (width2 <= 0.0f || height2 <= 0.0f) {
                        bitmap2 = null;
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) width2, (int) height2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, width2, height2), (Paint) null);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        bitmap2 = bitmapCreateBitmap;
                    }
                }
            }
        } catch (Throwable unused) {
            bitmap3 = null;
        }
        try {
            bitmap2 = Bitmap.createScaledBitmap(bitmap2, iMax, iMax2, true);
            bitmapA = Toolkit.a.a(6, bitmap2);
            System.nanoTime();
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapA, width, height, true);
            System.nanoTime();
            bitmap2.recycle();
            if (bitmapA != null) {
                bitmapA.recycle();
            }
            return bitmapCreateScaledBitmap;
        } catch (Throwable unused2) {
            Bitmap bitmap4 = bitmapA;
            bitmapA = bitmap2;
            bitmap3 = bitmap4;
            try {
                return bf1.y((int) 6, Bitmap.createScaledBitmap(bitmap, iMax, iMax2, true));
            } finally {
                if (bitmapA != null) {
                    bitmapA.recycle();
                }
                if (bitmap3 != null) {
                    bitmap3.recycle();
                }
            }
        }
    }

    private void getViewBitmap() {
        Window window = ((t) getContext()).getWindow();
        DragLayer dragLayer = ((t) getContext()).getDragLayer();
        o5 o5Var = new o5(this, 4);
        if (this.i != null) {
            a(window, dragLayer, new k8(this, o5Var, 2));
        } else {
            this.v.add(new g90(dragLayer, o5Var));
        }
    }

    public final void a(Window window, DragLayer dragLayer, f90 f90Var) {
        if (Build.VERSION.SDK_INT < 26) {
            c(dragLayer, f90Var);
            return;
        }
        int[] iArr = new int[2];
        dragLayer.getLocationInWindow(iArr);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], dragLayer.getWidth() + i, dragLayer.getHeight() + iArr[1]);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getWidth(), dragLayer.getHeight(), Bitmap.Config.ARGB_8888);
        PixelCopy.request(window, rect, bitmapCreateBitmap, new e90(this, bitmapCreateBitmap, f90Var, dragLayer), this.s);
    }

    public final float b(float f) {
        return getResources().getDisplayMetrics().density * f;
    }

    public final void f(float f) {
        int i = this.q[1];
        Objects.toString(getParent());
        this.h.setFloatUniform("u_GlViewPosition", f, r0[1]);
        invalidate();
    }

    public final void g() {
        int[] iArr = this.r;
        getLocationOnScreen(iArr);
        int[] iArr2 = this.q;
        if (Arrays.equals(iArr, iArr2)) {
            return;
        }
        int i = iArr[0];
        iArr2[0] = i;
        int i2 = iArr[1];
        iArr2[1] = i2;
        if (d(i, i2, this.l, this.k, this.m, this.n)) {
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            Objects.toString(getParent());
            this.h.setFloatUniform("u_GlViewPosition", iArr2[0], iArr2[1]);
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap;
        if (!canvas.isHardwareAccelerated() || (bitmap = this.i) == null || bitmap.isRecycled()) {
            super.onDraw(canvas);
        } else {
            canvas.drawPath(this.u, this.g);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            getLocationOnScreen(new int[2]);
            this.h.setFloatUniform("u_GlViewPosition", r2[0], r2[1]);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        this.l = f;
        float f2 = i2;
        this.k = f2;
        this.o = (f * 1.0f) / 2.0f;
        this.p = (f2 * 1.0f) / 2.0f;
        float f3 = this.j * f2;
        this.h.setFloatUniform("u_ViewSize", f, f2);
        this.h.setFloatUniform("u_CornerRadius", f3);
        Path path = this.u;
        path.reset();
        Path path2 = new Path();
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        float f4 = f - 0.0f;
        float f5 = f2 - 0.0f;
        float f6 = f4 / 2.0f;
        float f7 = this.o - f6;
        float f8 = f5 / 2.0f;
        float f9 = this.p - f8;
        float fMin = ((double) (f3 / Math.min(f6, f8))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f3 / Math.min(f6, f8)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = ((double) (f3 / Math.min(f6, f8))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f3 / Math.min(f6, f8)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        path2.moveTo(f7 + f6, f9);
        float f10 = f3 / 100.0f;
        float f11 = 128.19f * f10 * fMin;
        float f12 = f4 - f11;
        path2.lineTo(Math.max(f6, f12) + f7, f9);
        float f13 = f4 + f7;
        float f14 = fMin2 * 83.62f * f10;
        float f15 = f13 - f14;
        float f16 = f10 * 67.45f;
        float f17 = f13 - f16;
        float f18 = f10 * 4.64f;
        float f19 = f9 + f18;
        float f20 = 51.16f * f10;
        float f21 = f13 - f20;
        float f22 = 13.36f * f10;
        float f23 = f9 + f22;
        path2.cubicTo(f15, f9, f17, f19, f21, f23);
        float f24 = f10 * 34.86f;
        float f25 = f13 - f24;
        float f26 = f10 * 22.07f;
        float f27 = f9 + f26;
        float f28 = f13 - f26;
        float f29 = f9 + f24;
        float f30 = f13 - f22;
        float f31 = f9 + f20;
        path2.cubicTo(f25, f27, f28, f29, f30, f31);
        float f32 = f13 - f18;
        float f33 = f9 + f16;
        float f34 = f9 + f14;
        path2.cubicTo(f32, f33, f13, f34, f13, Math.min(f8, f11) + f9);
        float f35 = f5 - f11;
        path2.lineTo(f13, Math.max(f8, f35) + f9);
        float f36 = f9 + f5;
        float f37 = f36 - f14;
        float f38 = f36 - f16;
        float f39 = f36 - f20;
        path2.cubicTo(f13, f37, f32, f38, f30, f39);
        float f40 = f36 - f24;
        float f41 = f36 - f26;
        float f42 = f36 - f22;
        path2.cubicTo(f28, f40, f25, f41, f21, f42);
        float f43 = f36 - f18;
        path2.cubicTo(f17, f43, f15, f36, Math.max(f6, f12) + f7, f36);
        path2.lineTo(Math.min(f6, f11) + f7, f36);
        float f44 = f7 + f14;
        float f45 = f7 + f16;
        float f46 = f7 + f20;
        path2.cubicTo(f44, f36, f45, f43, f46, f42);
        float f47 = f7 + f24;
        float f48 = f7 + f26;
        float f49 = f7 + f22;
        path2.cubicTo(f47, f41, f48, f40, f49, f39);
        float f50 = f7 + f18;
        path2.cubicTo(f50, f38, f7, f37, f7, Math.max(f8, f35) + f9);
        path2.lineTo(f7, Math.min(f8, f11) + f9);
        path2.cubicTo(f7, f34, f50, f33, f49, f31);
        path2.cubicTo(f48, f29, f47, f27, f46, f23);
        path2.cubicTo(f45, f19, f44, f9, Math.min(f6, f11) + f7, f9);
        path2.close();
        path.addPath(path2);
    }

    public void setCornerRadiusPercent(float f) {
        this.j = f;
    }

    public void setFullBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.i == bitmap) {
            return;
        }
        this.m = bitmap.getWidth();
        this.n = bitmap.getHeight();
        this.i = bitmap;
        if (this.t) {
            while (true) {
                g90 g90Var = (g90) this.v.poll();
                if (g90Var == null) {
                    break;
                }
                a(((t) getContext()).getWindow(), g90Var.a, new k8(this, g90Var, 1));
            }
        }
        Bitmap bitmap2 = this.i;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.h.setInputShader("u_Texture", new BitmapShader(bitmap2, tileMode, tileMode));
        this.h.setFloatUniform("u_BackgroundSize", this.m, this.n);
        invalidate();
    }

    public void setSdfTexture(int i) {
        if (i == 0) {
            return;
        }
        if (i == l51.draff) {
            this.j = 0.23f;
            this.h.setFloatUniform("u_RefractionHeight", b(18.0f));
            this.h.setFloatUniform("u_RefractionAmount", b(-50.0f));
        } else if (i == l51.scale) {
            this.j = 0.11f;
        } else if (i == l51.long_round) {
            this.j = 0.42f;
            this.h.setFloatUniform("u_RefractionHeight", b(12.0f));
            this.h.setFloatUniform("u_RefractionAmount", b(-50.0f));
        } else if (i == l51.lib) {
            this.j = 0.18f;
        }
        this.h.setFloatUniform("u_CornerRadius", this.k * this.j);
    }
}
