package defpackage;

import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* JADX INFO: loaded from: classes.dex */
public final class ry {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    public GL a(SurfaceHolder surfaceHolder) {
        EGLSurface eGLSurface = (EGLSurface) this.d;
        gu guVar = (gu) this.h;
        EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
        if (eGLSurface != null && eGLSurface != eGLSurface2) {
            ((EGL10) this.b).eglMakeCurrent((EGLDisplay) this.c, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            EGL10 egl10 = (EGL10) this.b;
            EGLDisplay eGLDisplay = (EGLDisplay) this.c;
            EGLSurface eGLSurface3 = (EGLSurface) this.d;
            guVar.getClass();
            egl10.eglDestroySurface(eGLDisplay, eGLSurface3);
        }
        EGLSurface eGLSurfaceCreateWindowSurface = guVar.createWindowSurface((EGL10) this.b, (EGLDisplay) this.c, (EGLConfig) this.a, surfaceHolder);
        this.d = eGLSurfaceCreateWindowSurface;
        if (eGLSurfaceCreateWindowSurface == eGLSurface2) {
            throw new RuntimeException("createWindowSurface failed");
        }
        if (((EGL10) this.b).eglMakeCurrent((EGLDisplay) this.c, eGLSurfaceCreateWindowSurface, eGLSurfaceCreateWindowSurface, (EGLContext) this.e)) {
            return ((EGLContext) this.e).getGL();
        }
        throw new RuntimeException("eglMakeCurrent failed.");
    }

    public void b() {
        EGLContext eGLContext = (EGLContext) this.e;
        if (eGLContext != null) {
            EGL10 egl10 = (EGL10) this.b;
            EGLDisplay eGLDisplay = (EGLDisplay) this.c;
            ((ws) this.g).getClass();
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            this.e = null;
        }
        EGLDisplay eGLDisplay2 = (EGLDisplay) this.c;
        if (eGLDisplay2 != null) {
            ((EGL10) this.b).eglTerminate(eGLDisplay2);
            this.c = null;
        }
    }

    public void c() {
        if (((EGL10) this.b) == null) {
            this.b = (EGL10) EGLContext.getEGL();
        }
        if (((EGLDisplay) this.c) == null) {
            this.c = ((EGL10) this.b).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        }
        if (((EGLConfig) this.a) == null) {
            ((EGL10) this.b).eglInitialize((EGLDisplay) this.c, new int[2]);
            this.a = ((wa) this.f).chooseConfig((EGL10) this.b, (EGLDisplay) this.c);
        }
        if (((EGLContext) this.e) == null) {
            EGLContext eGLContextCreateContext = ((ws) this.g).createContext((EGL10) this.b, (EGLDisplay) this.c, (EGLConfig) this.a);
            this.e = eGLContextCreateContext;
            if (eGLContextCreateContext == null || eGLContextCreateContext == EGL10.EGL_NO_CONTEXT) {
                throw new RuntimeException("createContext failed");
            }
        }
        this.d = null;
    }
}
