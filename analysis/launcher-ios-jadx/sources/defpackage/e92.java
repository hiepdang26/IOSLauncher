package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class e92 {
    public final ArrayList a;
    public final Set b;
    public final Bundle c;
    public final Map d;
    public final int e;
    public final Set f;
    public final Bundle g;
    public final Set h;
    public final boolean i;
    public final int j;
    public long k = 0;

    public e92(c92 c92Var) {
        c92Var.getClass();
        this.a = c92Var.g;
        this.b = Collections.unmodifiableSet(c92Var.a);
        this.c = c92Var.b;
        this.d = Collections.unmodifiableMap(c92Var.c);
        this.e = c92Var.h;
        this.f = Collections.unmodifiableSet(c92Var.d);
        this.g = c92Var.e;
        this.h = Collections.unmodifiableSet(c92Var.f);
        this.i = c92Var.i;
        this.j = c92Var.j;
    }
}
