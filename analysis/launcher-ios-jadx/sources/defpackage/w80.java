package defpackage;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes.dex */
public final class w80 implements GLSurfaceView.EGLConfigChooser {
    public final /* synthetic */ y80 a;

    public w80(y80 y80Var) {
        this.a = y80Var;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 64, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, eGLConfigArr, 1, iArr);
        y80 y80Var = this.a;
        if (zEglChooseConfig && iArr[0] > 0) {
            y80Var.M = 3;
            return eGLConfigArr[0];
        }
        if (egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, eGLConfigArr, 1, iArr) && iArr[0] > 0) {
            y80Var.M = 2;
            return eGLConfigArr[0];
        }
        if (!egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 4, 12321, 1, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) {
            throw new IllegalArgumentException("No EGLConfig chosen.");
        }
        y80Var.M = 2;
        return eGLConfigArr[0];
    }
}
