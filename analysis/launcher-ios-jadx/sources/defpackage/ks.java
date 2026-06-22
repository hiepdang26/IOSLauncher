package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class ks {
    public final Context a;
    public final String b;
    public final vk1 c;
    public final fz1 d;
    public final ArrayList e;
    public final boolean f;
    public final int g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final LinkedHashSet l;
    public final ArrayList m;
    public final ArrayList n;

    public ks(Context context, String str, vk1 vk1Var, fz1 fz1Var, ArrayList arrayList, boolean z, int i, Executor executor, Executor executor2, boolean z2, boolean z3, LinkedHashSet linkedHashSet, ArrayList arrayList2, ArrayList arrayList3) {
        qg0.l(context, "context");
        qg0.l(fz1Var, "migrationContainer");
        uo.p(i, "journalMode");
        qg0.l(executor, "queryExecutor");
        qg0.l(executor2, "transactionExecutor");
        qg0.l(arrayList2, "typeConverters");
        qg0.l(arrayList3, "autoMigrationSpecs");
        this.a = context;
        this.b = str;
        this.c = vk1Var;
        this.d = fz1Var;
        this.e = arrayList;
        this.f = z;
        this.g = i;
        this.h = executor;
        this.i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = linkedHashSet;
        this.m = arrayList2;
        this.n = arrayList3;
    }
}
