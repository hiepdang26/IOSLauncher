package defpackage;

import android.content.res.Resources;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class kv implements cs {
    public final Resources.Theme g;
    public final Resources h;
    public final Object i;
    public final int j;
    public Object k;

    public kv(Resources.Theme theme, Resources resources, lv lvVar, int i) {
        this.g = theme;
        this.h = resources;
        this.i = lvVar;
        this.j = i;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, lv] */
    @Override // defpackage.cs
    public final Class a() {
        return this.i.a();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, lv] */
    @Override // defpackage.cs
    public final void b() {
        Object obj = this.k;
        if (obj != null) {
            try {
                this.i.b(obj);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, lv] */
    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) {
        try {
            Object objC = this.i.c(this.j, this.g, this.h);
            this.k = objC;
            bsVar.g(objC);
        } catch (Resources.NotFoundException e) {
            bsVar.e(e);
        }
    }

    @Override // defpackage.cs
    public final int d() {
        return 1;
    }

    @Override // defpackage.cs
    public final void cancel() {
    }
}
