package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class r50 extends la1 {
    public static final ks0 c = ks0.a("application/x-www-form-urlencoded");
    public final List a;
    public final List b;

    public r50(ArrayList arrayList, ArrayList arrayList2) {
        this.a = wq1.j(arrayList);
        this.b = wq1.j(arrayList2);
    }

    public final long a(ne neVar, boolean z) {
        fe feVar = z ? new fe() : neVar.d();
        List list = this.a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                feVar.K(38);
            }
            String str = (String) list.get(i);
            feVar.getClass();
            feVar.O(0, str.length(), str);
            feVar.K(61);
            String str2 = (String) this.b.get(i);
            feVar.O(0, str2.length(), str2);
        }
        if (!z) {
            return 0L;
        }
        long j = feVar.h;
        feVar.a();
        return j;
    }

    @Override // defpackage.la1
    public final long contentLength() {
        return a(null, true);
    }

    @Override // defpackage.la1
    public final ks0 contentType() {
        return c;
    }

    @Override // defpackage.la1
    public final void writeTo(ne neVar) {
        a(neVar, false);
    }
}
