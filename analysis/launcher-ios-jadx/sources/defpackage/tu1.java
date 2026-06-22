package defpackage;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class tu1 extends su1 {
    @Override // defpackage.qu1
    public final float E(View view) {
        return view.getTransitionAlpha();
    }

    @Override // defpackage.qu1
    public final void F(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // defpackage.qu1
    public final void G(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // defpackage.qu1
    public final void H(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // defpackage.ru1, defpackage.hs0
    public final void r(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // defpackage.su1, defpackage.hs0
    public final void s(int i, View view) {
        view.setTransitionVisibility(i);
    }
}
