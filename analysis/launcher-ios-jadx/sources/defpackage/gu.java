package defpackage;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: classes.dex */
public final class gu implements GLSurfaceView.EGLWindowSurfaceFactory {
    @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = null;
        while (eGLSurfaceEglCreateWindowSurface == null) {
            try {
                eGLSurfaceEglCreateWindowSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (Throwable unused) {
                if (eGLSurfaceEglCreateWindowSurface == null) {
                }
            }
            if (eGLSurfaceEglCreateWindowSurface == null) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused2) {
                }
            }
        }
        return eGLSurfaceEglCreateWindowSurface;
    }

    @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}
