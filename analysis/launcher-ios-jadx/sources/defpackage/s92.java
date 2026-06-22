package defpackage;

import com.google.android.gms.internal.ads.zzblb;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class s92 extends zzblb {
    public final /* synthetic */ t92 g;

    public /* synthetic */ s92(t92 t92Var) {
        this.g = t92Var;
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final void zzb(List list) {
        int i;
        ArrayList arrayList;
        synchronized (this.g.a) {
            t92 t92Var = this.g;
            t92Var.b = false;
            t92Var.c = true;
            arrayList = new ArrayList((ArrayList) this.g.e);
            ((ArrayList) this.g.e).clear();
        }
        t92.o(list);
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((pf1) arrayList.get(i)).a();
        }
    }
}
