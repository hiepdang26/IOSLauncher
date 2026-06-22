package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g81 {
    public final ArrayList a;
    public final hp1 b;
    public final e10 c;
    public final int d;
    public final ia1 e;
    public final d81 f;
    public final int g;
    public final int h;
    public final int i;
    public int j;

    public g81(ArrayList arrayList, hp1 hp1Var, e10 e10Var, int i, ia1 ia1Var, d81 d81Var, int i2, int i3, int i4) {
        this.a = arrayList;
        this.b = hp1Var;
        this.c = e10Var;
        this.d = i;
        this.e = ia1Var;
        this.f = d81Var;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public final tb1 a(ia1 ia1Var) {
        return b(ia1Var, this.b, this.c);
    }

    public final tb1 b(ia1 ia1Var, hp1 hp1Var, e10 e10Var) {
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = this.d;
        if (i >= size) {
            throw new AssertionError();
        }
        this.j++;
        e10 e10Var2 = this.c;
        if (e10Var2 != null && !e10Var2.d.h().k(ia1Var.a)) {
            throw new IllegalStateException("network interceptor " + arrayList.get(i - 1) + " must retain the same host and port");
        }
        if (e10Var2 != null && this.j > 1) {
            throw new IllegalStateException("network interceptor " + arrayList.get(i - 1) + " must call proceed() exactly once");
        }
        int i2 = i + 1;
        g81 g81Var = new g81(arrayList, hp1Var, e10Var, i2, ia1Var, this.f, this.g, this.h, this.i);
        mg0 mg0Var = (mg0) arrayList.get(i);
        tb1 tb1VarA = mg0Var.a(g81Var);
        if (e10Var != null && i2 < arrayList.size() && g81Var.j != 1) {
            throw new IllegalStateException("network interceptor " + mg0Var + " must call proceed() exactly once");
        }
        if (tb1VarA == null) {
            throw new NullPointerException("interceptor " + mg0Var + " returned null");
        }
        if (tb1VarA.m != null) {
            return tb1VarA;
        }
        throw new IllegalStateException("interceptor " + mg0Var + " returned a response with no body");
    }
}
