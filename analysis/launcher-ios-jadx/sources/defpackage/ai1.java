package defpackage;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class ai1 extends z81 {
    public boolean a = false;
    public final /* synthetic */ f11 b;

    public ai1(f11 f11Var) {
        this.b = f11Var;
    }

    @Override // defpackage.z81
    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0 && this.a) {
            this.a = false;
            this.b.h();
        }
    }

    @Override // defpackage.z81
    public final void b(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.a = true;
    }
}
