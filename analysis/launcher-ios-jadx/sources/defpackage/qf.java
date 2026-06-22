package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class qf implements zi0, Serializable {
    public transient zi0 g;
    public final Object h;
    public final Class i;
    public final String j;
    public final String k;
    public final boolean l;

    public qf(Object obj, Class cls, String str, String str2, boolean z) {
        this.h = obj;
        this.i = cls;
        this.j = str;
        this.k = str2;
        this.l = z;
    }

    public final yi a() {
        Class cls = this.i;
        if (this.l) {
            u91.a.getClass();
            return new u01(cls);
        }
        u91.a.getClass();
        return new zi(cls);
    }
}
