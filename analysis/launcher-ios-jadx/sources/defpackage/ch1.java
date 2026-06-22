package defpackage;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class ch1 implements cm {
    public final /* synthetic */ hh1 a;

    public ch1(hh1 hh1Var) {
        this.a = hh1Var;
    }

    @Override // defpackage.cm
    public final void a(boolean z) {
        ArrayList arrayList;
        vq1.a();
        synchronized (this.a) {
            arrayList = new ArrayList((HashSet) this.a.b);
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((cm) obj).a(z);
        }
    }
}
