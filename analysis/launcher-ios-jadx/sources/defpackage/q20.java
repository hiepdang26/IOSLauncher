package defpackage;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class q20 extends gd1 {
    public final HashMap k = new HashMap();

    @Override // defpackage.gd1
    public final dd1 a(Object obj) {
        return (dd1) this.k.get(obj);
    }

    @Override // defpackage.gd1
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.k.remove(obj);
        return objB;
    }
}
