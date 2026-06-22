package defpackage;

import android.animation.ObjectAnimator;
import android.view.Choreographer;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.Folder;

/* JADX INFO: loaded from: classes.dex */
public final class n40 implements Choreographer.FrameCallback {
    public final /* synthetic */ ObjectAnimator g;
    public final /* synthetic */ Folder h;

    public n40(Folder folder, ObjectAnimator objectAnimator) {
        this.h = folder;
        this.g = objectAnimator;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (this.g.isRunning()) {
            float fFloatValue = ((Float) this.g.getAnimatedValue(Key.SCALE_X)).floatValue();
            float fFloatValue2 = ((Float) this.g.getAnimatedValue(Key.SCALE_Y)).floatValue();
            Folder folder = this.h;
            l90 l90Var = folder.t;
            if (l90Var != null) {
                if (l90Var.u > 0 && l90Var.v > 0) {
                    l90Var.w = l90Var.u * fFloatValue;
                    l90Var.x = l90Var.v * fFloatValue2;
                    l90Var.getLocationInWindow(l90Var.W);
                    int i = l90Var.U;
                    int[] iArr = l90Var.W;
                    if (i != iArr[0] || l90Var.V != iArr[1] || l90Var.B.width() != l90Var.w || l90Var.B.height() != l90Var.x) {
                        int[] iArr2 = l90Var.W;
                        int i2 = iArr2[0];
                        l90Var.U = i2;
                        int i3 = iArr2[1];
                        l90Var.V = i3;
                        float f = i2;
                        l90Var.B.set(f, i3, l90Var.w + f, l90Var.V + l90Var.x);
                        l90Var.O.set(true);
                        l90Var.i();
                    }
                }
            } else if (folder.u != null && (Math.abs(fFloatValue - folder.v) > 0.001f || Math.abs(fFloatValue2 - this.h.w) > 0.001f)) {
                Folder folder2 = this.h;
                folder2.v = fFloatValue;
                folder2.w = fFloatValue2;
                int[] iArr3 = new int[2];
                folder2.u.getLocationInWindow(iArr3);
                if (Math.abs(this.h.x[0] - iArr3[0]) > 0.1f || Math.abs(this.h.x[1] - iArr3[1]) > 0.1f) {
                    Folder folder3 = this.h;
                    int[] iArr4 = folder3.x;
                    iArr4[0] = iArr3[0];
                    iArr4[1] = iArr3[1];
                    h90 h90Var = folder3.u;
                    float f2 = iArr3[0];
                    float f3 = iArr3[1];
                    h90Var.h.setFloatUniform("u_Scale", fFloatValue, fFloatValue2);
                    h90Var.h.setFloatUniform("u_GlViewPosition", f2, f3);
                    h90Var.invalidate();
                }
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }
}
