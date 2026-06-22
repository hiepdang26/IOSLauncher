package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class b90 {
    public final d90 a;
    public Surface b;
    public volatile int d;
    public volatile int e;
    public EGLSurface c = EGL14.EGL_NO_SURFACE;
    public volatile float f = 0.0f;
    public volatile float g = 0.0f;
    public volatile boolean h = false;

    public b90(d90 d90Var) {
        this.a = d90Var;
        this.d = Math.max(1, d90Var.getWidth());
        this.e = Math.max(1, d90Var.getHeight());
    }

    public final void a(EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        if (this.c != EGL14.EGL_NO_SURFACE) {
            return;
        }
        if (this.b == null) {
            SurfaceTexture surfaceTexture = this.a.getSurfaceTexture();
            if (surfaceTexture == null) {
                return;
            }
            try {
                this.b = new Surface(surfaceTexture);
            } catch (Throwable unused) {
                this.b = null;
            }
        }
        this.c = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, this.b, new int[]{12344}, 0);
    }
}
