package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
public final class y80 extends GLSurfaceView implements GLSurfaceView.Renderer {
    public static final float[] f0 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] g0 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public int A;
    public int B;
    public int C;
    public int D;
    public final FloatBuffer E;
    public final FloatBuffer F;
    public int G;
    public final int[] H;
    public final int[] I;
    public final RectF J;
    public float K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public int P;
    public final int[] Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public float W;
    public float a0;
    public int b0;
    public int c0;
    public int d0;
    public int e0;
    public final Context g;
    public Bitmap h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public volatile int p;
    public volatile int q;
    public volatile int r;
    public volatile boolean s;
    public final float t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public y80(Context context, float f) {
        super(context);
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = false;
        this.t = 0.25f;
        this.G = 0;
        this.H = new int[2];
        this.I = new int[2];
        this.J = new RectF();
        this.L = true;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = new int[1];
        this.R = Float.NaN;
        this.S = Float.NaN;
        this.T = -1.0f;
        this.U = -1.0f;
        this.V = -1.0f;
        this.W = -1.0f;
        this.a0 = -1.0f;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        this.g = context;
        setEGLConfigChooser(new w80(this));
        setEGLContextFactory(new x80(this));
        getHolder().setFormat(-3);
        setZOrderOnTop(false);
        setRenderer(this);
        setRenderMode(0);
        float[] fArr = f0;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.E = floatBufferAsFloatBuffer;
        float[] fArr2 = g0;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        this.F = floatBufferAsFloatBuffer2;
        this.t = f;
    }

    public final void a(int i, int i2, int i3) {
        if (i2 == 0) {
            return;
        }
        if (this.M == 3) {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(i3, i);
        } else {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(i3, i);
        }
    }

    public final int b(int i, String str) {
        if (this.M == 2) {
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

    public final int c(String str, String str2) {
        if (this.M == 2) {
            int iB = b(35633, str);
            int iB2 = b(35632, str2);
            if (iB != 0 && iB2 != 0) {
                int iGlCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(iGlCreateProgram, iB);
                GLES20.glAttachShader(iGlCreateProgram, iB2);
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
            int iB3 = b(35633, str);
            int iB4 = b(35632, str2);
            if (iB3 != 0 && iB4 != 0) {
                int iGlCreateProgram2 = GLES20.glCreateProgram();
                GLES20.glAttachShader(iGlCreateProgram2, iB3);
                GLES20.glAttachShader(iGlCreateProgram2, iB4);
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

    public final int d(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        int i = this.M;
        int[] iArr = this.Q;
        if (i == 3) {
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glBindTexture(3553, i2);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindTexture(3553, 0);
            return i2;
        }
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        GLES20.glBindTexture(3553, i3);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        return i3;
    }

    public final void e() {
        int i;
        int i2;
        if (getVisibility() != 0) {
            return;
        }
        int[] iArr = this.H;
        getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        if (this.i == 0 || this.j == 0 || (i = this.k) == 0 || (i2 = this.l) == 0) {
            return;
        }
        int[] iArr2 = this.I;
        if (i3 == iArr2[0] && i4 == iArr2[1]) {
            return;
        }
        iArr2[0] = i3;
        iArr2[1] = i4;
        this.J.set(iArr[0], iArr[1], i + r1, i2 + r0);
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        try {
            queueEvent(new v80(this, 2));
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        if (!this.L) {
            if (this.M == 3) {
                GLES20.glClear(16384);
                return;
            } else {
                GLES20.glClear(16384);
                return;
            }
        }
        if (this.m == 0 || this.o == 0 || this.n == 0) {
            return;
        }
        if (this.M == 3) {
            GLES20.glClear(16384);
            if (this.o != this.r) {
                GLES20.glUseProgram(this.o);
                this.r = this.o;
            }
        } else {
            GLES20.glClear(16384);
            if (this.o != this.r) {
                GLES20.glUseProgram(this.o);
                this.r = this.o;
            }
        }
        if (this.m != this.p) {
            a(0, this.m, this.u);
            this.p = this.m;
        }
        if (this.n != this.q) {
            a(1, this.n, this.v);
            this.q = this.n;
        }
        if (!this.s) {
            int i = this.k;
            if (i != this.b0 || this.l != this.c0) {
                if (this.M == 3) {
                    GLES20.glUniform2f(this.w, i, this.l);
                } else {
                    GLES20.glUniform2f(this.w, i, this.l);
                }
                this.b0 = this.k;
                this.c0 = this.l;
            }
            float f = this.l * this.t;
            if (f != this.T) {
                if (this.M == 3) {
                    GLES20.glUniform1f(this.x, f);
                } else {
                    GLES20.glUniform1f(this.x, f);
                }
                this.T = f;
            }
            float f2 = this.R;
            if (f2 != this.U) {
                if (this.M == 3) {
                    GLES20.glUniform1f(this.y, f2);
                } else {
                    GLES20.glUniform1f(this.y, f2);
                }
                this.U = this.R;
            }
            float f3 = this.S;
            if (f3 != this.V) {
                if (this.M == 3) {
                    GLES20.glUniform1f(this.z, f3);
                } else {
                    GLES20.glUniform1f(this.z, f3);
                }
                this.V = this.S;
            }
            if (this.W != 1.0f) {
                if (this.M == 3) {
                    GLES20.glUniform1f(this.A, 1.0f);
                } else {
                    GLES20.glUniform1f(this.A, 1.0f);
                }
                this.W = 1.0f;
            }
            int i2 = this.i;
            if (i2 != this.d0 || this.j != this.e0) {
                if (this.M == 3) {
                    GLES20.glUniform2f(this.B, i2, this.j);
                } else {
                    GLES20.glUniform2f(this.B, i2, this.j);
                }
                this.d0 = this.i;
                this.e0 = this.j;
            }
            if (this.a0 != 2.0f) {
                if (this.M == 3) {
                    GLES20.glUniform1f(this.D, 0.8f);
                } else {
                    GLES20.glUniform1f(this.D, 0.88f);
                }
                this.a0 = 2.0f;
            }
            if (this.M == 3) {
                int i3 = this.C;
                RectF rectF = this.J;
                GLES20.glUniform2f(i3, rectF.left, rectF.top);
            } else {
                int i4 = this.C;
                RectF rectF2 = this.J;
                GLES20.glUniform2f(i4, rectF2.left, rectF2.top);
            }
            this.s = true;
        } else if (this.M == 3) {
            int i5 = this.C;
            RectF rectF3 = this.J;
            GLES20.glUniform2f(i5, rectF3.left, rectF3.top);
        } else {
            int i6 = this.C;
            RectF rectF4 = this.J;
            GLES20.glUniform2f(i6, rectF4.left, rectF4.top);
        }
        if (this.M != 3) {
            GLES20.glDrawArrays(5, 0, 4);
            return;
        }
        GLES30.glBindVertexArray(this.P);
        GLES20.glDrawArrays(5, 0, 4);
        GLES30.glBindVertexArray(0);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.k = i3 - i;
            this.l = i4 - i2;
            this.s = false;
            e();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.k = i;
        this.l = i2;
        if (this.M == 3) {
            GLES20.glViewport(0, 0, i, i2);
        } else {
            GLES20.glViewport(0, 0, i, i2);
        }
        Context context = this.g;
        this.R = TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        this.S = TypedValue.applyDimension(1, -55.0f, context.getResources().getDisplayMetrics());
        Bitmap bitmap = this.h;
        if (bitmap != null && this.m == 0) {
            this.m = d(bitmap);
            setSdfTexture(this.G);
        }
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (this.M == 3) {
            GLES20.glDisable(3024);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            int iC = c(z71.i(getContext(), hs0.c), z71.i(getContext(), hg0.k));
            this.o = iC;
            if (iC == 0) {
                return;
            }
            this.r = -1;
            GLES20.glUseProgram(this.o);
            this.w = GLES20.glGetUniformLocation(this.o, "u_ViewSize");
            this.x = GLES20.glGetUniformLocation(this.o, "u_CornerRadius");
            this.y = GLES20.glGetUniformLocation(this.o, "u_RefractionHeight");
            this.z = GLES20.glGetUniformLocation(this.o, "u_RefractionAmount");
            this.A = GLES20.glGetUniformLocation(this.o, "u_DepthEffect");
            this.B = GLES20.glGetUniformLocation(this.o, "u_BackgroundSize");
            this.C = GLES20.glGetUniformLocation(this.o, "u_GlViewPosition");
            this.D = GLES20.glGetUniformLocation(this.o, "u_StrokeWidth");
            this.u = GLES20.glGetUniformLocation(this.o, "u_Texture");
            this.v = GLES20.glGetUniformLocation(this.o, "u_SDFMask");
        } else {
            GLES20.glDisable(3024);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            int iC2 = c(z71.i(getContext(), qg0.d), z71.i(getContext(), n90.f));
            this.o = iC2;
            if (iC2 == 0) {
                return;
            }
            GLES20.glUseProgram(iC2);
            this.w = GLES20.glGetUniformLocation(this.o, "u_ViewSize");
            this.x = GLES20.glGetUniformLocation(this.o, "u_CornerRadius");
            this.y = GLES20.glGetUniformLocation(this.o, "u_RefractionHeight");
            this.z = GLES20.glGetUniformLocation(this.o, "u_RefractionAmount");
            this.A = GLES20.glGetUniformLocation(this.o, "u_DepthEffect");
            this.B = GLES20.glGetUniformLocation(this.o, "u_BackgroundSize");
            this.C = GLES20.glGetUniformLocation(this.o, "u_GlViewPosition");
            this.D = GLES20.glGetUniformLocation(this.o, "u_StrokeWidth");
            this.u = GLES20.glGetUniformLocation(this.o, "u_Texture");
            this.v = GLES20.glGetUniformLocation(this.o, "u_SDFMask");
        }
        int i = this.M;
        FloatBuffer floatBuffer = this.F;
        FloatBuffer floatBuffer2 = this.E;
        int[] iArr = this.Q;
        if (i == 3) {
            GLES20.glGenBuffers(1, iArr, 0);
            int i2 = iArr[0];
            this.N = i2;
            GLES20.glBindBuffer(34962, i2);
            floatBuffer2.position(0);
            GLES20.glBufferData(34962, floatBuffer2.capacity() * 4, floatBuffer2, 35044);
            GLES20.glGenBuffers(1, iArr, 0);
            int i3 = iArr[0];
            this.O = i3;
            GLES20.glBindBuffer(34962, i3);
            floatBuffer.position(0);
            GLES20.glBufferData(34962, floatBuffer.capacity() * 4, floatBuffer, 35044);
            GLES20.glBindBuffer(34962, 0);
            GLES30.glGenVertexArrays(1, iArr, 0);
            int i4 = iArr[0];
            this.P = i4;
            GLES30.glBindVertexArray(i4);
            GLES20.glBindBuffer(34962, this.N);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, 0);
            GLES20.glBindBuffer(34962, this.O);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, 0);
            GLES30.glBindVertexArray(0);
            GLES20.glBindBuffer(34962, 0);
        } else {
            GLES20.glGenBuffers(1, iArr, 0);
            int i5 = iArr[0];
            this.N = i5;
            GLES20.glBindBuffer(34962, i5);
            floatBuffer2.position(0);
            GLES20.glBufferData(34962, floatBuffer2.capacity() * 4, floatBuffer2, 35044);
            GLES20.glGenBuffers(1, iArr, 0);
            int i6 = iArr[0];
            this.O = i6;
            GLES20.glBindBuffer(34962, i6);
            floatBuffer.position(0);
            GLES20.glBufferData(34962, floatBuffer.capacity() * 4, floatBuffer, 35044);
            GLES20.glBindBuffer(34962, this.N);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, 0);
            GLES20.glBindBuffer(34962, this.O);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, 0);
            GLES20.glBindBuffer(34962, 0);
        }
        this.m = 0;
        this.n = 0;
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            this.m = d(bitmap);
        }
        int i7 = this.G;
        if (i7 != 0) {
            setSdfTexture(i7);
        }
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = false;
        int[] iArr2 = this.I;
        iArr2[0] = -1;
        iArr2[1] = -1;
        this.T = -1.0f;
        this.U = -1.0f;
        this.V = -1.0f;
        this.W = -1.0f;
        this.a0 = -1.0f;
        this.b0 = -1;
        this.c0 = -1;
        this.d0 = -1;
        this.e0 = -1;
        requestRender();
    }

    public void setFullBitmap(Bitmap bitmap) {
        if (bitmap == this.h || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.p = -1;
        this.h = bitmap;
        this.s = false;
        queueEvent(new v80(this, 3));
    }

    public void setSdfTexture(int i) {
        if (i == 0) {
            return;
        }
        this.G = i;
        this.q = -1;
        if (this.k <= 0 || this.l <= 0) {
            return;
        }
        queueEvent(new v80(this, 1));
    }

    public void setVisible(boolean z) {
        this.L = z;
        postOnAnimation(new v80(this, 0));
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        int[] iArr = this.I;
        iArr[0] = -1;
        iArr[1] = -1;
    }
}
