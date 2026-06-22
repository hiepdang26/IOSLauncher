package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class xc1 {
    public hx1 a;
    public ArrayList b;

    public static long a(vu vuVar, long j) {
        hx1 hx1Var = vuVar.d;
        if (hx1Var instanceof yb0) {
            return j;
        }
        ArrayList arrayList = vuVar.k;
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            ru ruVar = (ru) arrayList.get(i);
            if (ruVar instanceof vu) {
                vu vuVar2 = (vu) ruVar;
                if (vuVar2.d != hx1Var) {
                    jMin = Math.min(jMin, a(vuVar2, ((long) vuVar2.f) + j));
                }
            }
        }
        if (vuVar != hx1Var.i) {
            return jMin;
        }
        long j2 = hx1Var.j();
        vu vuVar3 = hx1Var.h;
        long j3 = j - j2;
        return Math.min(Math.min(jMin, a(vuVar3, j3)), j3 - ((long) vuVar3.f));
    }

    public static long b(vu vuVar, long j) {
        hx1 hx1Var = vuVar.d;
        if (hx1Var instanceof yb0) {
            return j;
        }
        ArrayList arrayList = vuVar.k;
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            ru ruVar = (ru) arrayList.get(i);
            if (ruVar instanceof vu) {
                vu vuVar2 = (vu) ruVar;
                if (vuVar2.d != hx1Var) {
                    jMax = Math.max(jMax, b(vuVar2, ((long) vuVar2.f) + j));
                }
            }
        }
        if (vuVar != hx1Var.h) {
            return jMax;
        }
        long j2 = hx1Var.j();
        vu vuVar3 = hx1Var.i;
        long j3 = j + j2;
        return Math.max(Math.max(jMax, b(vuVar3, j3)), j3 - ((long) vuVar3.f));
    }
}
