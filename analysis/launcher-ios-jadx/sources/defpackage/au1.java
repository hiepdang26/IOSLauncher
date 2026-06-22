package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class au1 extends hg0 {
    public boolean l = false;
    public int m = 0;
    public final /* synthetic */ bu1 n;

    public au1(bu1 bu1Var) {
        this.n = bu1Var;
    }

    @Override // defpackage.cu1
    public final void onAnimationEnd(View view) {
        int i = this.m + 1;
        this.m = i;
        bu1 bu1Var = this.n;
        if (i == bu1Var.a.size()) {
            hg0 hg0Var = bu1Var.d;
            if (hg0Var != null) {
                hg0Var.onAnimationEnd(null);
            }
            this.m = 0;
            this.l = false;
            bu1Var.e = false;
        }
    }

    @Override // defpackage.hg0, defpackage.cu1
    public final void onAnimationStart(View view) {
        if (this.l) {
            return;
        }
        this.l = true;
        hg0 hg0Var = this.n.d;
        if (hg0Var != null) {
            hg0Var.onAnimationStart(null);
        }
    }
}
