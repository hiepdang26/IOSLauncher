package defpackage;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class m20 extends s {
    public final o00 h = new o00(1);

    @Override // defpackage.s
    public final Random a() {
        Object obj = this.h.get();
        qg0.k(obj, "get(...)");
        return (Random) obj;
    }
}
