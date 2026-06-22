package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class qs {
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public o90 c;
    public Object d;
    public int e;
    public int f;
    public Class g;
    public zn h;
    public g01 i;
    public jf j;
    public Class k;
    public boolean l;
    public boolean m;
    public bj0 n;
    public j31 o;
    public qv p;
    public boolean q;
    public boolean r;

    public final ArrayList a() {
        boolean z = this.m;
        ArrayList arrayList = this.b;
        if (!z) {
            this.m = true;
            arrayList.clear();
            ArrayList arrayListB = b();
            int size = arrayListB.size();
            for (int i = 0; i < size; i++) {
                ku0 ku0Var = (ku0) arrayListB.get(i);
                if (!arrayList.contains(ku0Var.a)) {
                    arrayList.add(ku0Var.a);
                }
                int i2 = 0;
                while (true) {
                    List list = ku0Var.b;
                    if (i2 < list.size()) {
                        if (!arrayList.contains(list.get(i2))) {
                            arrayList.add(list.get(i2));
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z = this.l;
        ArrayList arrayList = this.a;
        if (!z) {
            this.l = true;
            arrayList.clear();
            List listG = this.c.b().g(this.d);
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                ku0 ku0VarB = ((lu0) listG.get(i)).b(this.d, this.e, this.f, this.i);
                if (ku0VarB != null) {
                    arrayList.add(ku0VarB);
                }
            }
        }
        return arrayList;
    }

    public final yo0 c(Class cls) {
        yo0 yo0Var;
        Class cls2;
        x91 x91VarB = this.c.b();
        Class cls3 = this.g;
        Class cls4 = this.k;
        zo0 zo0Var = x91VarB.i;
        tu0 tu0Var = (tu0) zo0Var.b.getAndSet(null);
        if (tu0Var == null) {
            tu0Var = new tu0();
        }
        tu0Var.a = cls;
        tu0Var.b = cls3;
        tu0Var.c = cls4;
        synchronized (zo0Var.a) {
            yo0Var = (yo0) zo0Var.a.get(tu0Var);
        }
        zo0Var.b.set(tu0Var);
        x91VarB.i.getClass();
        if (zo0.c.equals(yo0Var)) {
            return null;
        }
        if (yo0Var != null) {
            return yo0Var;
        }
        yo0 yo0Var2 = null;
        ArrayList arrayListE = x91VarB.e(cls, cls3, cls4);
        if (arrayListE.isEmpty()) {
            cls2 = cls;
        } else {
            cls2 = cls;
            yo0Var2 = new yo0(cls2, cls3, cls4, arrayListE, x91VarB.j);
        }
        yo0 yo0Var3 = yo0Var2;
        x91VarB.i.a(cls2, cls3, cls4, yo0Var3);
        return yo0Var3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r1 = r5.b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.zz d(java.lang.Object r8) {
        /*
            r7 = this;
            o90 r0 = r7.c
            x91 r0 = r0.b()
            b00 r0 = r0.b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.a     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            a00 r5 = (defpackage.a00) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            zz r1 = r5.b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            goto L2e
        L2a:
            r8 = move-exception
            goto L49
        L2c:
            monitor-exit(r0)
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            return r1
        L31:
            w91 r0 = new w91
            java.lang.Class r8 = r8.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qs.d(java.lang.Object):zz");
    }

    public final ro1 e(Class cls) {
        ro1 ro1Var = (ro1) this.j.get(cls);
        if (ro1Var == null) {
            Iterator it = ((a9) this.j.entrySet()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    ro1Var = (ro1) entry.getValue();
                    break;
                }
            }
        }
        if (ro1Var != null) {
            return ro1Var;
        }
        if (!this.j.isEmpty() || !this.q) {
            return bq1.b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
