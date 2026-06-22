package defpackage;

import android.view.SurfaceHolder;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperRenderer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
public final class b80 extends Thread {
    public SurfaceHolder h;
    public boolean i;
    public b80 j;
    public final wa k;
    public final ws l;
    public final gu m;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public final LiveWallpaperRenderer v;
    public ry w;
    public final fz1 g = new fz1(this, 17);
    public boolean n = true;

    public b80(LiveWallpaperRenderer liveWallpaperRenderer, wa waVar, ws wsVar, gu guVar) {
        new ArrayList();
        this.i = false;
        this.r = 0;
        this.s = 0;
        this.u = true;
        this.t = 1;
        this.v = liveWallpaperRenderer;
        this.k = waVar;
        this.l = wsVar;
        this.m = guVar;
    }

    public final void a() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        boolean z3;
        wa waVar = this.k;
        ws wsVar = this.l;
        gu guVar = this.m;
        ry ryVar = new ry();
        ryVar.f = waVar;
        ryVar.g = wsVar;
        ryVar.h = guVar;
        this.w = ryVar;
        GL10 gl10 = null;
        boolean z4 = true;
        boolean z5 = true;
        while (!b()) {
            try {
                synchronized (this.g) {
                    z = false;
                    while (true) {
                        try {
                            if (this.o) {
                                if (!this.q && this.g.I(this)) {
                                    this.q = true;
                                    this.w.c();
                                    this.u = true;
                                    z = true;
                                }
                            } else if (!this.p) {
                                c();
                                this.p = true;
                                this.g.notifyAll();
                            }
                            if (!this.i) {
                                z2 = this.o;
                                if (z2 && this.q && (i = this.r) > 0 && (i2 = this.s) > 0 && (this.u || this.t == 1)) {
                                    break;
                                } else {
                                    this.g.wait();
                                }
                            } else {
                                synchronized (this.g) {
                                    c();
                                    this.w.b();
                                }
                                return;
                            }
                        } finally {
                        }
                    }
                    z3 = this.n;
                    this.n = false;
                    this.u = false;
                    if (z2 && this.p) {
                        this.p = false;
                        this.g.notifyAll();
                        z3 = true;
                    }
                }
                if (z) {
                    z4 = true;
                    z3 = true;
                }
                if (z3) {
                    gl10 = (GL10) this.w.a(this.h);
                    z5 = true;
                }
                if (z4) {
                    this.v.onSurfaceCreated(gl10, (EGLConfig) this.w.a);
                    z4 = false;
                }
                if (z5) {
                    this.v.onSurfaceChanged(gl10, i, i2);
                    z5 = false;
                }
                if (i > 0 && i2 > 0) {
                    this.v.onDrawFrame(gl10);
                    ry ryVar2 = this.w;
                    ((EGL10) ryVar2.b).eglSwapBuffers((EGLDisplay) ryVar2.c, (EGLSurface) ryVar2.d);
                    ((EGL10) ryVar2.b).eglGetError();
                    Thread.sleep(10L);
                }
            } catch (Throwable th) {
                synchronized (this.g) {
                    c();
                    this.w.b();
                    throw th;
                }
            }
        }
        synchronized (this.g) {
            c();
            this.w.b();
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.g) {
            z = this.i;
        }
        return z;
    }

    public final void c() {
        EGLSurface eGLSurface;
        if (this.q) {
            this.q = false;
            ry ryVar = this.w;
            EGLSurface eGLSurface2 = (EGLSurface) ryVar.d;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                ((EGL10) ryVar.b).eglMakeCurrent((EGLDisplay) ryVar.c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                EGL10 egl10 = (EGL10) ryVar.b;
                EGLDisplay eGLDisplay = (EGLDisplay) ryVar.c;
                EGLSurface eGLSurface3 = (EGLSurface) ryVar.d;
                ((gu) ryVar.h).getClass();
                egl10.eglDestroySurface(eGLDisplay, eGLSurface3);
                ryVar.d = null;
            }
            fz1 fz1Var = this.g;
            synchronized (fz1Var) {
                b80 b80Var = (b80) fz1Var.h;
                if (b80Var.j == this) {
                    b80Var.j = null;
                }
                fz1Var.notifyAll();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        fz1 fz1Var = this.g;
        setName("GLThread " + getId());
        try {
            a();
            fz1Var.H(this);
        } catch (Throwable unused) {
            fz1Var.H(this);
        }
    }
}
