package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class xi extends l60 {
    public ArrayList h;

    @Override // defpackage.d11
    public final int c() {
        ArrayList arrayList = this.h;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // defpackage.d11
    public final int d() {
        return -2;
    }

    @Override // defpackage.l60
    public final w50 k(int i) {
        return (w50) this.h.get(i);
    }

    @Override // defpackage.l60
    public final long l(int i) {
        return ((w50) this.h.get(i)).hashCode();
    }
}
