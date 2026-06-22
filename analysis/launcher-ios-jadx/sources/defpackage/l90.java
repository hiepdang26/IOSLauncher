package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.TypedValue;
import android.view.PixelCopy;
import android.view.TextureView;
import android.view.Window;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.t;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class l90 extends TextureView implements TextureView.SurfaceTextureListener {
    public static final float[] b0 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] c0 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public volatile boolean A;
    public final RectF B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public final FloatBuffer M;
    public final FloatBuffer N;
    public final AtomicBoolean O;
    public final AtomicBoolean P;
    public final float Q;
    public final float R;
    public final Handler S;
    public final ConcurrentLinkedQueue T;
    public int U;
    public int V;
    public final int[] W;
    public final ExecutorService a0;
    public final t g;
    public k90 h;
    public final Object i;
    public EGLDisplay j;
    public EGLContext k;
    public EGLSurface l;
    public int m;
    public int n;
    public int o;
    public volatile Bitmap p;
    public volatile int q;
    public volatile int r;
    public volatile int s;
    public volatile int t;
    public volatile int u;
    public volatile int v;
    public volatile float w;
    public volatile float x;
    public final float y;
    public int z;

    public l90(Context context) {
        super(context, null);
        this.i = new Object();
        this.j = EGL14.EGL_NO_DISPLAY;
        this.k = EGL14.EGL_NO_CONTEXT;
        this.l = EGL14.EGL_NO_SURFACE;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.13f;
        this.z = 0;
        this.A = true;
        this.B = new RectF();
        this.O = new AtomicBoolean(true);
        this.P = new AtomicBoolean(false);
        this.T = new ConcurrentLinkedQueue();
        this.W = new int[2];
        this.a0 = Executors.newFixedThreadPool(2);
        t tVar = (t) context;
        this.g = tVar;
        setSurfaceTextureListener(this);
        setOpaque(false);
        HandlerThread handlerThread = new HandlerThread("PixelCopyThread");
        handlerThread.start();
        this.S = new Handler(handlerThread.getLooper());
        float[] fArr = b0;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.M = floatBufferAsFloatBuffer;
        float[] fArr2 = c0;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        this.N = floatBufferAsFloatBuffer2;
        this.Q = TypedValue.applyDimension(1, 8.0f, tVar.getResources().getDisplayMetrics());
        this.R = TypedValue.applyDimension(1, -60.0f, tVar.getResources().getDisplayMetrics());
        getViewBitmap();
    }

    public static void a(l90 l90Var) {
        int i = l90Var.n;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            l90Var.n = 0;
        }
        int i2 = l90Var.o;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            l90Var.o = 0;
        }
        int i3 = l90Var.m;
        if (i3 != 0) {
            GLES20.glDeleteProgram(i3);
            l90Var.m = 0;
        }
        EGLDisplay eGLDisplay = l90Var.j;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGLSurface eGLSurface2 = l90Var.l;
        if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(l90Var.j, eGLSurface2);
        }
        EGLContext eGLContext = l90Var.k;
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(l90Var.j, eGLContext);
        }
        EGL14.eglTerminate(l90Var.j);
        l90Var.l = EGL14.EGL_NO_SURFACE;
        l90Var.k = EGL14.EGL_NO_CONTEXT;
        l90Var.j = EGL14.EGL_NO_DISPLAY;
    }

    public static void b(l90 l90Var) {
        if (!l90Var.A || l90Var.p == null || l90Var.m == 0) {
            GLES20.glViewport(0, 0, Math.max(1, l90Var.u), Math.max(1, l90Var.v));
            GLES20.glClear(16384);
            EGL14.eglSwapBuffers(l90Var.j, l90Var.l);
            return;
        }
        GLES20.glViewport(0, 0, Math.max(1, l90Var.u), Math.max(1, l90Var.v));
        GLES20.glClear(16384);
        GLES20.glUseProgram(l90Var.m);
        int i = l90Var.n;
        if (i != 0) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
        }
        int i2 = l90Var.o;
        if (i2 != 0) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, i2);
        }
        if (l90Var.O.getAndSet(false)) {
            GLES20.glUniform2f(l90Var.E, l90Var.w, l90Var.x);
            GLES20.glUniform1f(l90Var.F, l90Var.w * l90Var.y);
            GLES20.glUniform1f(l90Var.G, l90Var.Q);
            GLES20.glUniform1f(l90Var.H, l90Var.R);
            GLES20.glUniform1f(l90Var.I, 1.0f);
            int i3 = l90Var.J;
            t tVar = l90Var.g;
            GLES20.glUniform2f(i3, tVar.screenWidth, tVar.screenHeight);
            GLES20.glUniform1f(l90Var.L, 0.8f);
            int i4 = l90Var.K;
            RectF rectF = l90Var.B;
            GLES20.glUniform2f(i4, rectF.left, rectF.top);
            GLES20.glUniform1i(l90Var.C, 0);
            GLES20.glUniform1i(l90Var.D, 1);
        }
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) l90Var.M);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) l90Var.N);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(0);
        GLES20.glDisableVertexAttribArray(1);
        EGL14.eglSwapBuffers(l90Var.j, l90Var.l);
    }

    public static void c(l90 l90Var) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        l90Var.j = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed! " + EGL14.eglGetError());
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new RuntimeException("eglInitialize failed! " + EGL14.eglGetError());
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(l90Var.j, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        EGLConfig eGLConfig = iArr2[0] > 0 ? eGLConfigArr[0] : null;
        if (eGLConfig == null) {
            throw new RuntimeException("EGLConfig not found!");
        }
        l90Var.k = EGL14.eglCreateContext(l90Var.j, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(l90Var.j, eGLConfig, l90Var.getSurfaceTexture(), new int[]{12344}, 0);
        l90Var.l = eGLSurfaceEglCreateWindowSurface;
        if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("eglCreateWindowSurface failed! " + EGL14.eglGetError());
        }
        if (EGL14.eglMakeCurrent(l90Var.j, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, l90Var.k)) {
            return;
        }
        throw new RuntimeException("eglMakeCurrent failed! " + EGL14.eglGetError());
    }

    public static void d(l90 l90Var) {
        int iGlCreateProgram;
        Bitmap bitmapDecodeResource;
        int i;
        GLES20.glDisable(3024);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        String strI = z71.i(l90Var.getContext(), qg0.d);
        String strI2 = z71.i(l90Var.getContext(), n90.f);
        int iF = f(35633, strI);
        int iF2 = f(35632, strI2);
        if (iF == 0 || iF2 == 0) {
            iGlCreateProgram = 0;
        } else {
            iGlCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(iGlCreateProgram, iF);
            GLES20.glAttachShader(iGlCreateProgram, iF2);
            GLES20.glBindAttribLocation(iGlCreateProgram, 0, "a_Position");
            GLES20.glBindAttribLocation(iGlCreateProgram, 1, "a_TexCoord");
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                GLES20.glGetProgramInfoLog(iGlCreateProgram);
                GLES20.glDeleteProgram(iGlCreateProgram);
                iGlCreateProgram = 0;
            }
        }
        l90Var.m = iGlCreateProgram;
        if (iGlCreateProgram == 0) {
            return;
        }
        l90Var.E = GLES20.glGetUniformLocation(iGlCreateProgram, "u_ViewSize");
        l90Var.F = GLES20.glGetUniformLocation(l90Var.m, "u_CornerRadius");
        l90Var.G = GLES20.glGetUniformLocation(l90Var.m, "u_RefractionHeight");
        l90Var.H = GLES20.glGetUniformLocation(l90Var.m, "u_RefractionAmount");
        l90Var.I = GLES20.glGetUniformLocation(l90Var.m, "u_DepthEffect");
        l90Var.J = GLES20.glGetUniformLocation(l90Var.m, "u_BackgroundSize");
        l90Var.K = GLES20.glGetUniformLocation(l90Var.m, "u_GlViewPosition");
        l90Var.L = GLES20.glGetUniformLocation(l90Var.m, "u_StrokeWidth");
        l90Var.C = GLES20.glGetUniformLocation(l90Var.m, "u_Texture");
        l90Var.D = GLES20.glGetUniformLocation(l90Var.m, "u_SDFMask");
        if (l90Var.p != null && (i = l90Var.n) == 0) {
            l90Var.n = l90Var.h(l90Var.p, i, false);
        }
        if (l90Var.z != 0 && l90Var.o == 0 && (bitmapDecodeResource = BitmapFactory.decodeResource(l90Var.g.getResources(), l90Var.z)) != null) {
            Bitmap.Config config = bitmapDecodeResource.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCopy = config == config2 ? bitmapDecodeResource : bitmapDecodeResource.copy(config2, false);
            l90Var.o = l90Var.h(bitmapCopy, l90Var.o, true);
            if (bitmapCopy != bitmapDecodeResource) {
                bitmapDecodeResource.recycle();
            }
        }
        l90Var.O.set(true);
    }

    public static int f(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glGetShaderInfoLog(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static void g(DragLayer dragLayer, i90 i90Var) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getWidth(), dragLayer.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = dragLayer.getBackground();
        if (background != null) {
            background.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            background.draw(canvas);
        }
        dragLayer.draw(canvas);
        i90Var.a(Bitmap.createScaledBitmap(bitmapCreateBitmap, Math.max(1, dragLayer.getWidth() / 6), Math.max(1, dragLayer.getHeight() / 6), true));
    }

    private void getViewBitmap() {
        Window window = this.g.getWindow();
        DragLayer dragLayer = this.g.getDragLayer();
        o5 o5Var = new o5(this, 5);
        if (this.p != null) {
            e(window, dragLayer, new k8(this, o5Var, 4));
        } else {
            this.T.add(new j90(dragLayer, o5Var));
        }
    }

    public static Bitmap j(Bitmap bitmap, Bitmap bitmap2, float f) {
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
        Bitmap bitmap3 = null;
        try {
            if (!bitmap.isRecycled()) {
                if (bitmap2.isRecycled()) {
                    bitmap2 = bitmap;
                } else {
                    int width2 = bitmap2.getWidth();
                    int height2 = bitmap2.getHeight();
                    if (width2 <= 0 || height2 <= 0) {
                        bitmap2 = null;
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, width2, height2), (Paint) null);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        bitmap2 = bitmapCreateBitmap;
                    }
                }
            }
            try {
                System.nanoTime();
                Bitmap bitmapA = Toolkit.a.a(6, bitmap2);
                System.nanoTime();
                System.nanoTime();
                bitmap2.recycle();
                return bitmapA;
            } catch (Throwable unused) {
                bitmap3 = bitmap2;
                try {
                    return bf1.y(6, Bitmap.createScaledBitmap(bitmap, iMax, iMax2, true));
                } finally {
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public final void e(Window window, DragLayer dragLayer, i90 i90Var) {
        int iMax = Math.max(1, dragLayer.getWidth() / 6);
        int iMax2 = Math.max(1, dragLayer.getHeight() / 6);
        if (Build.VERSION.SDK_INT < 26) {
            g(dragLayer, i90Var);
            return;
        }
        int[] iArr = new int[2];
        dragLayer.getLocationInWindow(iArr);
        int i = iArr[0];
        Rect rect = new Rect(i, iArr[1], dragLayer.getWidth() + i, dragLayer.getHeight() + iArr[1]);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
        PixelCopy.request(window, rect, bitmapCreateBitmap, new e90(this, i90Var, bitmapCreateBitmap, dragLayer), this.S);
    }

    public final int h(Bitmap bitmap, int i, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i != 0 && (!z ? !(this.q == bitmap.getWidth() && this.r == bitmap.getHeight()) : !(this.s == bitmap.getWidth() && this.t == bitmap.getHeight()))) {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            GLES20.glBindTexture(3553, 0);
            return i;
        }
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
        if (z) {
            this.s = bitmap.getWidth();
            this.t = bitmap.getHeight();
        } else {
            this.q = bitmap.getWidth();
            this.r = bitmap.getHeight();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        return i2;
    }

    public final void i() {
        this.P.set(true);
        synchronized (this.i) {
            try {
                k90 k90Var = this.h;
                if (k90Var != null) {
                    k90Var.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.p = bitmap;
        while (true) {
            j90 j90Var = (j90) this.T.poll();
            if (j90Var == null) {
                break;
            } else {
                e(this.g.getWindow(), j90Var.a, new k8(this, j90Var, 3));
            }
        }
        synchronized (this.i) {
            try {
                k90 k90Var = this.h;
                if (k90Var != null) {
                    k90Var.a(new r1(this, 17));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.u = i3 - i;
            this.v = i4 - i2;
            this.w = this.u;
            this.x = this.v;
            this.O.set(true);
            i();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.u = i;
        this.v = i2;
        synchronized (this.i) {
            try {
                if (this.h == null) {
                    k90 k90Var = new k90(this);
                    this.h = k90Var;
                    k90Var.start();
                    i();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        synchronized (this.i) {
            try {
                k90 k90Var = this.h;
                if (k90Var != null) {
                    k90Var.g = false;
                    k90Var.b();
                    try {
                        k90Var.join();
                    } catch (InterruptedException unused) {
                    }
                    this.h = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.u = i;
        this.v = i2;
        this.O.set(true);
        i();
    }

    public void setSdfTexture(int i) {
        if (i == 0) {
            return;
        }
        this.z = i;
        Bitmap bitmapDecodeResource = null;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(this.g.getResources(), i);
            if (bitmapDecodeResource != null) {
                Bitmap.Config config = bitmapDecodeResource.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config != config2) {
                    Bitmap bitmapCopy = bitmapDecodeResource.copy(config2, false);
                    bitmapDecodeResource.recycle();
                    bitmapDecodeResource = bitmapCopy;
                }
            }
        } catch (Throwable unused) {
        }
        if (bitmapDecodeResource == null) {
            return;
        }
        synchronized (this.i) {
            k90 k90Var = this.h;
            if (k90Var != null) {
                k90Var.a(new wc(this, bitmapDecodeResource, 8));
            } else {
                try {
                    bitmapDecodeResource.recycle();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void setVisible(boolean z) {
        this.A = z;
        if (this.A) {
            i();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
