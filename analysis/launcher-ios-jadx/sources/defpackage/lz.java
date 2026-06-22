package defpackage;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class lz extends m90 {
    public final kz l;

    public lz(TextView textView) {
        this.l = new kz(textView);
    }

    @Override // defpackage.m90
    public final InputFilter[] j(InputFilter[] inputFilterArr) {
        return !(zy.j != null) ? inputFilterArr : this.l.j(inputFilterArr);
    }

    @Override // defpackage.m90
    public final boolean l() {
        return this.l.n;
    }

    @Override // defpackage.m90
    public final void p(boolean z) {
        if (zy.j != null) {
            this.l.p(z);
        }
    }

    @Override // defpackage.m90
    public final void q(boolean z) {
        boolean z2 = zy.j != null;
        kz kzVar = this.l;
        if (z2) {
            kzVar.q(z);
        } else {
            kzVar.n = z;
        }
    }

    @Override // defpackage.m90
    public final TransformationMethod t(TransformationMethod transformationMethod) {
        return !(zy.j != null) ? transformationMethod : this.l.t(transformationMethod);
    }
}
