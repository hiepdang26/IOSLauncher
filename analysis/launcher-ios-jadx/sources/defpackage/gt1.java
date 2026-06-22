package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class gt1 extends jt1 {
    public float[] g;
    public hm h;

    @Override // defpackage.jt1
    public final void c(hm hmVar) {
        this.h = hmVar;
    }

    @Override // defpackage.jt1
    public final void d(View view, float f) {
        float fA = a(f);
        float[] fArr = this.g;
        fArr[0] = fA;
        qg0.I(this.h, view, fArr);
    }
}
