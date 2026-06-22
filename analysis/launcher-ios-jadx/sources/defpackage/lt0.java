package defpackage;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class lt0 {
    public final Runnable a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final HashMap c = new HashMap();

    public lt0(Runnable runnable) {
        this.a = runnable;
    }

    public final void a() {
        this.b.remove((Object) null);
        kt0 kt0Var = (kt0) this.c.remove(null);
        if (kt0Var != null) {
            kt0Var.a.f(kt0Var.b);
            kt0Var.b = null;
        }
        this.a.run();
    }
}
