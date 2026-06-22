package defpackage;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k8 implements ef0, f90, i90, fk {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ k8(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    @Override // defpackage.f90, defpackage.i90
    public void a(Bitmap bitmap) {
        switch (this.g) {
            case 1:
                h90 h90Var = (h90) this.h;
                h90Var.w.execute(new bd((View) h90Var, bitmap, this.i, 2));
                break;
            case 2:
                h90 h90Var2 = (h90) this.h;
                h90Var2.w.execute(new bd((View) h90Var2, bitmap, this.i, 3));
                break;
            case 3:
                l90 l90Var = (l90) this.h;
                l90Var.a0.execute(new bd((View) l90Var, bitmap, this.i, 4));
                break;
            default:
                l90 l90Var2 = (l90) this.h;
                l90Var2.a0.execute(new bd((View) l90Var2, bitmap, this.i, 5));
                break;
        }
    }
}
