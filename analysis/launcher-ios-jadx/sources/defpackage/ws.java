package defpackage;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes.dex */
public final class ws implements GLSurfaceView.EGLContextFactory {
    public int a;

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int i = this.a;
        int[] iArr = {12440, i, 12344};
        if (i == 0) {
            iArr = null;
        }
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
    }
}
