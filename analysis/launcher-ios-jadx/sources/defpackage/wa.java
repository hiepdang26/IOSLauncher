package defpackage;

import android.opengl.GLSurfaceView;
import com.google.android.gms.internal.ads.zzbbc;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes.dex */
public class wa implements GLSurfaceView.EGLConfigChooser {
    public final int[] a;
    public int b;
    public int c;
    public int d;
    public final int e;
    public final int[] f;

    public wa(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = {12324, i, 12323, i2, 12322, i3, 12321, 0, 12325, i4, 12326, 0, 12344};
        if (i5 == 2) {
            int[] iArr2 = new int[15];
            System.arraycopy(iArr, 0, iArr2, 0, 12);
            iArr2[12] = 12352;
            iArr2[13] = 4;
            iArr2[14] = 12344;
            iArr = iArr2;
        }
        this.a = iArr;
        this.f = new int[1];
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public final int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
        int[] iArr = this.f;
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr)) {
            return iArr[0];
        }
        return 0;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        if (!egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        EGLConfig eGLConfig = null;
        int i2 = zzbbc.zzq.zzf;
        for (int i3 = 0; i3 < i; i3++) {
            EGLConfig eGLConfig2 = eGLConfigArr[i3];
            int iA = a(egl10, eGLDisplay, eGLConfig2, 12325);
            int iA2 = a(egl10, eGLDisplay, eGLConfig2, 12326);
            if (iA >= this.e && iA2 >= 0) {
                int iA3 = a(egl10, eGLDisplay, eGLConfig2, 12324);
                int iA4 = a(egl10, eGLDisplay, eGLConfig2, 12323);
                int iA5 = a(egl10, eGLDisplay, eGLConfig2, 12322);
                int iA6 = a(egl10, eGLDisplay, eGLConfig2, 12321);
                int iAbs = Math.abs(iA6) + Math.abs(iA5 - this.d) + Math.abs(iA4 - this.c) + Math.abs(iA3 - this.b);
                if (iAbs < i2) {
                    eGLConfig = eGLConfig2;
                    i2 = iAbs;
                }
            }
        }
        if (eGLConfig != null) {
            return eGLConfig;
        }
        throw new IllegalArgumentException("No config chosen");
    }
}
