package defpackage;

import java.util.LinkedHashSet;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class mz0 {
    public final UUID a;
    public final lz1 b;
    public final LinkedHashSet c;

    public mz0(UUID uuid, lz1 lz1Var, LinkedHashSet linkedHashSet) {
        qg0.l(uuid, "id");
        qg0.l(lz1Var, "workSpec");
        qg0.l(linkedHashSet, "tags");
        this.a = uuid;
        this.b = lz1Var;
        this.c = linkedHashSet;
    }
}
