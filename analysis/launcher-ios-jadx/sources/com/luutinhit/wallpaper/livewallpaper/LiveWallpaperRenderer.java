package com.luutinhit.wallpaper.livewallpaper;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import defpackage.fl0;
import defpackage.lv1;
import defpackage.m90;
import defpackage.po0;
import defpackage.q61;
import defpackage.so0;
import java.io.File;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.apache.commons.collections4.queue.CircularFifoQueue;

/* JADX INFO: loaded from: classes.dex */
public class LiveWallpaperRenderer implements GLSurfaceView.Renderer {
    private static final float MAX_BIAS_RANGE = 0.003f;
    private static final int REFRESH_RATE = 60;
    private static final String TAG = "LiveWallpaperRenderer";
    private float biasRange;
    private float currentOrientationOffsetX;
    private float currentOrientationOffsetY;
    private boolean isDefaultWallpaper;
    private po0 mCallbacks;
    private final Context mContext;
    private float orientationOffsetX;
    private float orientationOffsetY;
    private float preA;
    private float preB;
    private float screenAspectRatio;
    private int screenH;
    private float scrollRange;
    private ScheduledFuture<?> transitionHandle;
    private lv1 wallpaper;
    private float wallpaperAspectRatio;
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final float transitionStep = 1.0f;
    private float scrollStep = 1.0f;
    private Queue<Float> scrollOffsetXQueue = new CircularFifoQueue(10);
    private float scrollOffsetX = 0.5f;
    private float scrollOffsetXBackup = 0.5f;
    private boolean scrollMode = true;
    private int delay = 3;
    private final Runnable transition = new fl0(this, 4);
    private boolean needsRefreshWallpaper = true;

    public LiveWallpaperRenderer(Context context, po0 po0Var) {
        this.mContext = context;
        this.mCallbacks = po0Var;
    }

    private Bitmap cropBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float f = width / height;
        this.wallpaperAspectRatio = f;
        float f2 = this.screenAspectRatio;
        if (f >= f2) {
            double height2 = bitmap.getHeight();
            int i = this.screenH;
            if (height2 <= ((double) i) * 1.1d) {
                return bitmap;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (((double) i) * 1.1d * ((double) this.wallpaperAspectRatio)), (int) (((double) i) * 1.1d), true);
            bitmap.recycle();
            return bitmapCreateScaledBitmap;
        }
        this.scrollRange = 1.0f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, ((int) (height - (width / f2))) / 2, (int) width, (int) (width / f2));
        bitmap.recycle();
        double height3 = bitmapCreateBitmap.getHeight();
        int i2 = this.screenH;
        if (height3 <= ((double) i2) * 1.1d) {
            return bitmapCreateBitmap;
        }
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (((double) i2) * 1.1d * ((double) this.screenAspectRatio)), (int) (((double) i2) * 1.1d), true);
        bitmapCreateBitmap.recycle();
        return bitmapCreateScaledBitmap2;
    }

    private Bitmap getSavedWallpaperFromStorage() {
        try {
            return BitmapFactory.decodeStream(new FileInputStream(new File(new ContextWrapper(this.mContext).getDir("image", 0), "wallpaper")));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void loadTexture() {
        int[] iArr;
        try {
            Bitmap bitmapDecodeStream = null;
            try {
                if (this.isDefaultWallpaper) {
                    try {
                        bitmapDecodeStream = getSavedWallpaperFromStorage();
                    } catch (Throwable th) {
                        th.getMessage();
                        try {
                            bitmapDecodeStream = ((BitmapDrawable) WallpaperManager.getInstance(this.mContext).getDrawable()).getBitmap();
                        } catch (Throwable th2) {
                            th2.getMessage();
                        }
                    }
                    if (bitmapDecodeStream == null) {
                        bitmapDecodeStream = BitmapFactory.decodeStream(this.mContext.getResources().openRawResource(q61.wallpaper_default_3));
                    }
                } else {
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(this.mContext.getResources().openRawResource(q61.wallpaper_default_3));
                    } catch (Throwable unused) {
                        this.isDefaultWallpaper = true;
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            if (bitmapDecodeStream == null) {
                return;
            }
            lv1 lv1Var = this.wallpaper;
            if (lv1Var != null && (iArr = lv1Var.k) != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                m90.c("Destroy picture");
            }
            this.wallpaper = new lv1(cropBitmap(bitmapDecodeStream));
            preCalculate();
            System.gc();
        } catch (Throwable th4) {
            th4.getMessage();
        }
    }

    private void preCalculate() {
        float f = this.scrollStep;
        if (f > 0.0f) {
            float f2 = this.wallpaperAspectRatio;
            float f3 = this.screenAspectRatio;
            if (f2 > ((1.0f / (f * 3.0f)) + 1.0f) * f3) {
                this.scrollRange = (1.0f / (f * 3.0f)) + 1.0f;
            } else if (f2 >= f3) {
                this.scrollRange = f2 / f3;
            } else {
                this.scrollRange = 1.0f;
            }
        } else {
            this.scrollRange = 1.0f;
        }
        float f4 = this.screenAspectRatio;
        this.preA = (this.scrollRange - 1.0f) * f4;
        if (f4 < 1.0f) {
            this.preB = (this.biasRange / f4) - 1.0f;
        } else {
            this.preB = (this.biasRange * f4) - 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionCal() {
        boolean z;
        boolean z2 = true;
        if (Math.abs(this.currentOrientationOffsetX - this.orientationOffsetX) > 1.0E-4d || Math.abs(this.currentOrientationOffsetY - this.orientationOffsetY) > 1.0E-4d) {
            float f = this.orientationOffsetX;
            float f2 = this.currentOrientationOffsetX;
            int i = this.delay;
            float f3 = this.orientationOffsetY;
            float f4 = this.currentOrientationOffsetY;
            this.currentOrientationOffsetX = f2 + ((f - f2) / (i * 1.0f));
            this.currentOrientationOffsetY = f4 + ((f3 - f4) / (i * 1.0f));
            z = true;
        } else {
            z = false;
        }
        if (this.scrollOffsetXQueue.isEmpty()) {
            z2 = z;
        } else {
            this.scrollOffsetX = this.scrollOffsetXQueue.poll().floatValue();
        }
        if (z2) {
            ((so0) this.mCallbacks).b();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            if (this.needsRefreshWallpaper) {
                loadTexture();
                this.needsRefreshWallpaper = false;
            }
            GLES20.glClear(16640);
            float f = (((this.scrollOffsetX * (-2.0f)) + 1.0f) * this.preA) + this.currentOrientationOffsetX;
            float f2 = this.currentOrientationOffsetY;
            Matrix.setLookAtM(this.mViewMatrix, 0, f, f2, this.preB, f, f2, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectionMatrix, 0, this.mViewMatrix, 0);
            this.wallpaper.a(this.mMVPMatrix);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (i2 == 0) {
            i2 = 1;
        }
        this.screenAspectRatio = i / i2;
        this.screenH = i2;
        GLES20.glViewport(0, 0, i, i2);
        float[] fArr = this.mProjectionMatrix;
        float f = this.screenAspectRatio;
        Matrix.frustumM(fArr, 0, f * (-0.1f), f * 0.1f, -0.1f, 0.1f, 0.1f, 2.0f);
        this.needsRefreshWallpaper = true;
        ((so0) this.mCallbacks).b();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 1);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int iGlCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(iGlCreateShader, "uniform mat4 uMVPMatrix;attribute vec4 aPosition;attribute vec2 aTexCoords;varying vec2 vTexCoords;void main(){  vTexCoords = aTexCoords;  gl_Position = uMVPMatrix * aPosition;}");
        GLES20.glCompileShader(iGlCreateShader);
        m90.c("glCompileShader");
        int iGlCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(iGlCreateShader2, "precision mediump float;uniform sampler2D uTexture;varying vec2 vTexCoords;void main(){  gl_FragColor = texture2D(uTexture, vTexCoords);}");
        GLES20.glCompileShader(iGlCreateShader2);
        m90.c("glCompileShader");
        int iGlCreateProgram = GLES20.glCreateProgram();
        m90.c("glCreateProgram");
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader);
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader2);
        GLES20.glLinkProgram(iGlCreateProgram);
        m90.c("glLinkProgram");
        GLES20.glDeleteShader(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader2);
        lv1.n = iGlCreateProgram;
        lv1.o = GLES20.glGetAttribLocation(iGlCreateProgram, "aPosition");
        lv1.p = GLES20.glGetAttribLocation(lv1.n, "aTexCoords");
        lv1.r = GLES20.glGetUniformLocation(lv1.n, "uMVPMatrix");
        lv1.q = GLES20.glGetUniformLocation(lv1.n, "uTexture");
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        lv1.m = iArr[0];
    }

    public void release() {
        int[] iArr;
        lv1 lv1Var = this.wallpaper;
        if (lv1Var != null && (iArr = lv1Var.k) != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            m90.c("Destroy picture");
        }
        stopTransition();
        this.scheduler.shutdown();
    }

    public void setBiasRange(int i) {
        this.biasRange = (i * MAX_BIAS_RANGE) + 0.03f;
        preCalculate();
        ((so0) this.mCallbacks).b();
    }

    public void setDelay(int i) {
        this.delay = i;
    }

    public void setIsDefaultWallpaper(boolean z) {
        this.isDefaultWallpaper = z;
        this.needsRefreshWallpaper = true;
        ((so0) this.mCallbacks).b();
    }

    public void setOffset(float f, float f2) {
        if (!this.scrollMode) {
            this.scrollOffsetXBackup = f;
        } else {
            this.scrollOffsetXBackup = f;
            this.scrollOffsetXQueue.offer(Float.valueOf(f));
        }
    }

    public void setOffsetStep(float f, float f2) {
        if (this.scrollStep != f) {
            this.scrollStep = f;
            preCalculate();
        }
    }

    public void setOrientationAngle(float f, float f2) {
        this.orientationOffsetX = (float) (Math.sin(f) * ((double) this.biasRange));
        this.orientationOffsetY = (float) (Math.sin(f2) * ((double) this.biasRange));
    }

    public void setScrollMode(boolean z) {
        this.scrollMode = z;
        if (z) {
            this.scrollOffsetXQueue.offer(Float.valueOf(this.scrollOffsetXBackup));
        } else {
            this.scrollOffsetXQueue.clear();
            this.scrollOffsetXQueue.offer(Float.valueOf(0.5f));
        }
    }

    public void startTransition() {
        try {
            stopTransition();
            this.transitionHandle = this.scheduler.scheduleAtFixedRate(this.transition, 0L, 16L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void stopTransition() {
        ScheduledFuture<?> scheduledFuture = this.transitionHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
