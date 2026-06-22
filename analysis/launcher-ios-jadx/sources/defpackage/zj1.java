package defpackage;

import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class zj1 extends az1 {
    public final /* synthetic */ HashSet h;

    public zj1(HashSet hashSet) {
        this.h = hashSet;
    }

    @Override // defpackage.az1
    public final boolean B(String str) {
        return this.h.contains(str);
    }
}
