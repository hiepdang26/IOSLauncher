package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class k20 extends zo1 {
    public final /* synthetic */ int g;
    public Object h;

    public /* synthetic */ k20() {
        this.g = 2;
    }

    @Override // defpackage.zo1, defpackage.vo1
    public void a(xo1 xo1Var) {
        switch (this.g) {
            case 2:
                ba baVar = (ba) this.h;
                if (!baVar.F) {
                    baVar.D();
                    baVar.F = true;
                }
                break;
        }
    }

    @Override // defpackage.vo1
    public final void d(xo1 xo1Var) {
        switch (this.g) {
            case 0:
                qu1 qu1Var = pu1.a;
                qu1Var.F((View) this.h, 1.0f);
                qu1Var.getClass();
                xo1Var.u(this);
                break;
            case 1:
                ((xo1) this.h).w();
                xo1Var.u(this);
                break;
            default:
                ba baVar = (ba) this.h;
                int i = baVar.E - 1;
                baVar.E = i;
                if (i == 0) {
                    baVar.F = false;
                    baVar.l();
                }
                xo1Var.u(this);
                break;
        }
    }

    public /* synthetic */ k20(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }
}
