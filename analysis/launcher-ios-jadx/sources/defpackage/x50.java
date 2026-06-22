package defpackage;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.a;

/* JADX INFO: loaded from: classes.dex */
public final class x50 extends wd implements dt1, en0, k60 {
    public final e6 B;
    public final e6 C;
    public final Handler D;
    public final h60 E;
    public final /* synthetic */ e6 F;

    public x50(e6 e6Var) {
        this.F = e6Var;
        Handler handler = new Handler();
        this.E = new h60();
        this.B = e6Var;
        this.C = e6Var;
        this.D = handler;
    }

    @Override // defpackage.dt1
    public final ct1 j() {
        return this.F.j();
    }

    @Override // defpackage.en0
    public final a l() {
        return this.F.v;
    }

    @Override // defpackage.wd
    public final View w(int i) {
        return this.F.findViewById(i);
    }

    @Override // defpackage.wd
    public final boolean x() {
        Window window = this.F.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // defpackage.k60
    public final void b() {
    }
}
