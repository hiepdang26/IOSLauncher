package defpackage;

import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e91 extends o81 {
    public final /* synthetic */ RecyclerView a;

    public e91(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override // defpackage.o81
    public final void a() {
        RecyclerView recyclerView = this.a;
        recyclerView.m(null);
        recyclerView.n0.f = true;
        recyclerView.c0(true);
        if (recyclerView.k.h()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override // defpackage.o81
    public final void b(int i, int i2, Preference preference) {
        RecyclerView recyclerView = this.a;
        recyclerView.m(null);
        y2 y2Var = recyclerView.k;
        if (i2 < 1) {
            y2Var.getClass();
            return;
        }
        ArrayList arrayList = (ArrayList) y2Var.c;
        arrayList.add(y2Var.i(4, i, i2, preference));
        y2Var.a |= 4;
        if (arrayList.size() == 1) {
            f();
        }
    }

    @Override // defpackage.o81
    public final void c(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.m(null);
        y2 y2Var = recyclerView.k;
        if (i2 < 1) {
            y2Var.getClass();
            return;
        }
        ArrayList arrayList = (ArrayList) y2Var.c;
        arrayList.add(y2Var.i(1, i, i2, null));
        y2Var.a |= 1;
        if (arrayList.size() == 1) {
            f();
        }
    }

    @Override // defpackage.o81
    public final void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.m(null);
        y2 y2Var = recyclerView.k;
        y2Var.getClass();
        if (i == i2) {
            return;
        }
        ArrayList arrayList = (ArrayList) y2Var.c;
        arrayList.add(y2Var.i(8, i, i2, null));
        y2Var.a |= 8;
        if (arrayList.size() == 1) {
            f();
        }
    }

    @Override // defpackage.o81
    public final void e(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.m(null);
        y2 y2Var = recyclerView.k;
        if (i2 < 1) {
            y2Var.getClass();
            return;
        }
        ArrayList arrayList = (ArrayList) y2Var.c;
        arrayList.add(y2Var.i(2, i, i2, null));
        y2Var.a |= 2;
        if (arrayList.size() == 1) {
            f();
        }
    }

    public final void f() {
        boolean z = RecyclerView.L0;
        RecyclerView recyclerView = this.a;
        if (z && recyclerView.z && recyclerView.y) {
            WeakHashMap weakHashMap = qs1.a;
            recyclerView.postOnAnimation(recyclerView.o);
        } else {
            recyclerView.G = true;
            recyclerView.requestLayout();
        }
    }
}
