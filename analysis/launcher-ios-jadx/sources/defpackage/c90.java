package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.TypedValue;
import android.view.Choreographer;
import com.luutinhit.launcher6.t;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c90 {
    public static c90 A;
    public static final float[] B = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] C = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public final Context a;
    public final EGLDisplay b;
    public final EGLContext c;
    public final EGLConfig d;
    public final EGLSurface e;
    public final int f;
    public int g = 0;
    public int h = 0;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final FloatBuffer s;
    public final FloatBuffer t;
    public final ArrayDeque u;
    public final ConcurrentHashMap v;
    public int w;
    public int x;
    public final boolean y;
    public final l5 z;

    public c90(Context context) {
        String strI;
        String strI2;
        this.b = EGL14.EGL_NO_DISPLAY;
        this.c = EGL14.EGL_NO_CONTEXT;
        this.e = EGL14.EGL_NO_SURFACE;
        this.f = 0;
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        float[] fArr = B;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.s = floatBufferAsFloatBuffer;
        float[] fArr2 = C;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        this.t = floatBufferAsFloatBuffer2;
        this.u = new ArrayDeque();
        this.v = new ConcurrentHashMap();
        this.y = false;
        this.z = new l5(this, 1);
        this.a = context;
        float fApplyDimension = TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        float fApplyDimension2 = TypedValue.applyDimension(1, -55.0f, context.getResources().getDisplayMetrics());
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.b = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            EGL14.eglGetError();
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.b, iArr, 0, iArr, 1)) {
            EGL14.eglGetError();
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(EGL14.eglGetDisplay(0), new int[]{12352, 64, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        EGLConfig eGLConfig = iArr2[0] > 0 ? eGLConfigArr[0] : null;
        this.d = eGLConfig;
        if (eGLConfig != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.b, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
            this.c = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext != EGL14.EGL_NO_CONTEXT) {
                this.y = true;
            }
        }
        if (this.c == EGL14.EGL_NO_CONTEXT) {
            EGLConfig[] eGLConfigArr2 = new EGLConfig[1];
            int[] iArr3 = new int[1];
            EGL14.eglChooseConfig(EGL14.eglGetDisplay(0), new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr2, 0, 1, iArr3, 0);
            EGLConfig eGLConfig2 = iArr3[0] > 0 ? eGLConfigArr2[0] : null;
            this.d = eGLConfig2;
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.b, eGLConfig2, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.c = eGLContextEglCreateContext2;
            if (eGLContextEglCreateContext2 == EGL14.EGL_NO_CONTEXT) {
                EGL14.eglGetError();
            }
            this.y = false;
        }
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.b, this.d, new int[]{12375, 1, 12374, 1, 12344}, 0);
        this.e = eGLSurfaceEglCreatePbufferSurface;
        if (eGLSurfaceEglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("eglCreatePbufferSurface failed: " + EGL14.eglGetError());
        }
        if (!EGL14.eglMakeCurrent(this.b, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, this.c)) {
            throw new RuntimeException("eglMakeCurrent (pbuffer) failed: " + EGL14.eglGetError());
        }
        String strI3 = "";
        if (this.y) {
            GLES20.glDisable(3024);
            GLES20.glDisable(2929);
            GLES20.glDisable(2884);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            try {
                strI2 = z71.i(context, hs0.c);
            } catch (Throwable unused) {
                strI2 = "";
            }
            try {
                strI3 = z71.i(context, hg0.k);
            } catch (Throwable unused2) {
            }
            int iB = b(strI2, strI3);
            this.f = iB;
            GLES20.glUseProgram(iB);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) this.s);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) this.t);
            this.i = GLES20.glGetUniformLocation(this.f, "u_ViewSize");
            this.j = GLES20.glGetUniformLocation(this.f, "u_CornerRadius");
            this.k = GLES20.glGetUniformLocation(this.f, "u_RefractionHeight");
            this.l = GLES20.glGetUniformLocation(this.f, "u_RefractionAmount");
            this.m = GLES20.glGetUniformLocation(this.f, "u_DepthEffect");
            this.n = GLES20.glGetUniformLocation(this.f, "u_BackgroundSize");
            this.o = GLES20.glGetUniformLocation(this.f, "u_GlViewPosition");
            this.p = GLES20.glGetUniformLocation(this.f, "u_StrokeWidth");
            this.q = GLES20.glGetUniformLocation(this.f, "u_Texture");
            this.r = GLES20.glGetUniformLocation(this.f, "u_SDFMask");
            int i = this.k;
            if (i != -1) {
                GLES20.glUniform1f(i, fApplyDimension);
            }
            int i2 = this.l;
            if (i2 != -1) {
                GLES20.glUniform1f(i2, fApplyDimension2);
            }
            int i3 = this.m;
            if (i3 != -1) {
                GLES20.glUniform1f(i3, 1.0f);
            }
            int i4 = this.p;
            if (i4 != -1) {
                GLES20.glUniform1f(i4, 0.88f);
            }
            int i5 = this.n;
            if (i5 != -1) {
                try {
                    GLES20.glUniform2f(i5, ((t) context).screenWidth, ((t) context).screenHeight);
                } catch (Throwable unused3) {
                }
            }
            int i6 = this.q;
            if (i6 != -1) {
                GLES20.glUniform1i(i6, 0);
            }
            int i7 = this.r;
            if (i7 != -1) {
                GLES20.glUniform1i(i7, 1);
            }
        } else {
            GLES20.glDisable(3024);
            GLES20.glDisable(2929);
            GLES20.glDisable(2884);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            try {
                strI = z71.i(context, qg0.d);
            } catch (Throwable unused4) {
                strI = "";
            }
            try {
                strI3 = z71.i(context, n90.f);
            } catch (Throwable unused5) {
            }
            String str = strI3;
            int iB2 = b(strI.contains("precision") ? strI : "precision mediump float;\n".concat(strI), str.contains("precision") ? str : "precision mediump float;\n".concat(str));
            this.f = iB2;
            GLES20.glUseProgram(iB2);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) this.s);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) this.t);
            this.i = GLES20.glGetUniformLocation(this.f, "u_ViewSize");
            this.j = GLES20.glGetUniformLocation(this.f, "u_CornerRadius");
            this.k = GLES20.glGetUniformLocation(this.f, "u_RefractionHeight");
            this.l = GLES20.glGetUniformLocation(this.f, "u_RefractionAmount");
            this.m = GLES20.glGetUniformLocation(this.f, "u_DepthEffect");
            this.n = GLES20.glGetUniformLocation(this.f, "u_BackgroundSize");
            this.o = GLES20.glGetUniformLocation(this.f, "u_GlViewPosition");
            this.p = GLES20.glGetUniformLocation(this.f, "u_StrokeWidth");
            this.q = GLES20.glGetUniformLocation(this.f, "u_Texture");
            this.r = GLES20.glGetUniformLocation(this.f, "u_SDFMask");
            int i8 = this.k;
            if (i8 != -1) {
                GLES20.glUniform1f(i8, fApplyDimension);
            }
            int i9 = this.l;
            if (i9 != -1) {
                GLES20.glUniform1f(i9, fApplyDimension2);
            }
            int i10 = this.m;
            if (i10 != -1) {
                GLES20.glUniform1f(i10, 1.0f);
            }
            int i11 = this.p;
            if (i11 != -1) {
                GLES20.glUniform1f(i11, 0.88f);
            }
            int i12 = this.n;
            if (i12 != -1) {
                try {
                    GLES20.glUniform2f(i12, ((t) context).screenWidth, ((t) context).screenHeight);
                } catch (Throwable unused6) {
                }
            }
            int i13 = this.q;
            if (i13 != -1) {
                GLES20.glUniform1i(i13, 0);
            }
            int i14 = this.r;
            if (i14 != -1) {
                GLES20.glUniform1i(i14, 1);
            }
        }
        Choreographer.getInstance().postFrameCallback(this.z);
    }

    public static c90 c(Context context) {
        if (A == null) {
            synchronized (c90.class) {
                try {
                    if (A == null) {
                        A = new c90(context);
                    }
                } finally {
                }
            }
        }
        return A;
    }

    public final int a(int i, String str) {
        if (str == null) {
            return 0;
        }
        if (this.y) {
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
        int iGlCreateShader2 = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader2, str);
        GLES20.glCompileShader(iGlCreateShader2);
        int[] iArr2 = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader2, 35713, iArr2, 0);
        if (iArr2[0] != 0) {
            return iGlCreateShader2;
        }
        GLES20.glGetShaderInfoLog(iGlCreateShader2);
        GLES20.glDeleteShader(iGlCreateShader2);
        return 0;
    }

    public final int b(String str, String str2) {
        if (this.y) {
            int iA = a(35633, str);
            int iA2 = a(35632, str2);
            if (iA != 0 && iA2 != 0) {
                int iGlCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(iGlCreateProgram, iA);
                GLES20.glAttachShader(iGlCreateProgram, iA2);
                GLES20.glBindAttribLocation(iGlCreateProgram, 0, "a_Position");
                GLES20.glBindAttribLocation(iGlCreateProgram, 1, "a_TexCoord");
                GLES20.glLinkProgram(iGlCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                if (iArr[0] == 1) {
                    return iGlCreateProgram;
                }
                GLES20.glGetProgramInfoLog(iGlCreateProgram);
                GLES20.glDeleteProgram(iGlCreateProgram);
                return 0;
            }
        } else {
            int iA3 = a(35633, str);
            int iA4 = a(35632, str2);
            if (iA3 != 0 && iA4 != 0) {
                int iGlCreateProgram2 = GLES20.glCreateProgram();
                GLES20.glAttachShader(iGlCreateProgram2, iA3);
                GLES20.glAttachShader(iGlCreateProgram2, iA4);
                GLES20.glBindAttribLocation(iGlCreateProgram2, 0, "a_Position");
                GLES20.glBindAttribLocation(iGlCreateProgram2, 1, "a_TexCoord");
                GLES20.glLinkProgram(iGlCreateProgram2);
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram2, 35714, iArr2, 0);
                if (iArr2[0] == 1) {
                    return iGlCreateProgram2;
                }
                GLES20.glGetProgramInfoLog(iGlCreateProgram2);
                GLES20.glDeleteProgram(iGlCreateProgram2);
                return 0;
            }
        }
        return 0;
    }

    public final int d(int i, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        boolean z = i == 0;
        if (this.y) {
            if (!z) {
                GLES20.glBindTexture(3553, i);
                GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
                GLES20.glBindTexture(3553, 0);
                return i;
            }
            if (i != 0) {
                GLES20.glDeleteTextures(1, new int[]{i}, 0);
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
        if (!z) {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            GLES20.glBindTexture(3553, 0);
            return i;
        }
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        int i3 = iArr2[0];
        GLES20.glBindTexture(3553, i3);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        return i3;
    }

    public final void e(Runnable runnable) {
        synchronized (this.u) {
            this.u.addLast(runnable);
        }
    }

    public final void f(int i) {
        Bitmap bitmapDecodeResource;
        if (i == 0 || (bitmapDecodeResource = BitmapFactory.decodeResource(this.a.getResources(), i)) == null) {
            return;
        }
        Bitmap.Config config = bitmapDecodeResource.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            bitmapDecodeResource = bitmapDecodeResource.copy(config2, false);
        }
        e(new a90(this, bitmapDecodeResource, 0));
    }
}
