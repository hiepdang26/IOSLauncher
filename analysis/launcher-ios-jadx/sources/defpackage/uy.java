package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class uy extends os {
    public final /* synthetic */ vy f;

    public uy(vy vyVar) {
        this.f = vyVar;
    }

    @Override // defpackage.os
    public final void n(Throwable th) {
        this.f.a.d(th);
    }

    @Override // defpackage.os
    public final void o(hz1 hz1Var) {
        vy vyVar = this.f;
        vyVar.c = hz1Var;
        vyVar.b = new v21(vyVar.c, new jl1(15), vyVar.a.h);
        zy zyVar = vyVar.a;
        zyVar.getClass();
        ArrayList arrayList = new ArrayList();
        zyVar.a.writeLock().lock();
        try {
            zyVar.c = 1;
            arrayList.addAll(zyVar.b);
            zyVar.b.clear();
            zyVar.a.writeLock().unlock();
            zyVar.d.post(new s1(arrayList, zyVar.c, null));
        } catch (Throwable th) {
            zyVar.a.writeLock().unlock();
            throw th;
        }
    }
}
