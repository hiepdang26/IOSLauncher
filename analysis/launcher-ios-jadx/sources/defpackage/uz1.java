package defpackage;

import android.content.Context;
import android.database.Cursor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class uz1 implements Runnable {
    public static final /* synthetic */ int y = 0;
    public final Context g;
    public final String h;
    public final wb2 i;
    public final lz1 j;
    public io0 k;
    public final qm0 l;
    public final rl n;
    public final jl1 o;
    public final s31 p;
    public final WorkDatabase q;
    public final mz1 r;
    public final tu s;
    public final ArrayList t;
    public String u;
    public ho0 m = new eo0();
    public final nf1 v = new nf1();
    public final nf1 w = new nf1();
    public volatile int x = -256;

    static {
        ka0.r("WorkerWrapper");
    }

    public uz1(ry ryVar) {
        this.g = (Context) ryVar.a;
        this.l = (qm0) ryVar.c;
        this.p = (s31) ryVar.b;
        lz1 lz1Var = (lz1) ryVar.f;
        this.j = lz1Var;
        this.h = lz1Var.a;
        this.i = (wb2) ryVar.h;
        this.k = null;
        rl rlVar = (rl) ryVar.d;
        this.n = rlVar;
        this.o = rlVar.c;
        WorkDatabase workDatabase = (WorkDatabase) ryVar.e;
        this.q = workDatabase;
        this.r = workDatabase.u();
        this.s = workDatabase.p();
        this.t = (ArrayList) ryVar.g;
    }

    public final void a(ho0 ho0Var) {
        boolean z = ho0Var instanceof go0;
        lz1 lz1Var = this.j;
        if (!z) {
            if (ho0Var instanceof fo0) {
                ka0.j().getClass();
                c();
                return;
            }
            ka0.j().getClass();
            if (lz1Var.c()) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        ka0.j().getClass();
        if (lz1Var.c()) {
            d();
            return;
        }
        tu tuVar = this.s;
        String str = this.h;
        mz1 mz1Var = this.r;
        WorkDatabase workDatabase = this.q;
        workDatabase.c();
        try {
            mz1Var.n(3, str);
            mz1Var.m(str, ((go0) this.m).a);
            this.o.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayListG = tuVar.g(str);
            int size = arrayListG.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListG.get(i);
                i++;
                String str2 = (String) obj;
                if (mz1Var.f(str2) == 5) {
                    lc1 lc1VarA = lc1.a(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
                    if (str2 == null) {
                        lc1VarA.g(1);
                    } else {
                        lc1VarA.e(1, str2);
                    }
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) tuVar.h;
                    workDatabase_Impl.b();
                    Cursor cursorL = workDatabase_Impl.l(lc1VarA);
                    try {
                        if (cursorL.moveToFirst() && cursorL.getInt(0) != 0) {
                            ka0.j().getClass();
                            mz1Var.n(1, str2);
                            mz1Var.l(str2, jCurrentTimeMillis);
                        }
                    } finally {
                        cursorL.close();
                        lc1VarA.k();
                    }
                }
            }
            workDatabase.n();
            workDatabase.j();
            e(false);
        } catch (Throwable th) {
            workDatabase.j();
            e(false);
            throw th;
        }
    }

    public final void b() {
        if (h()) {
            return;
        }
        this.q.c();
        try {
            int iF = this.r.f(this.h);
            hz1 hz1VarT = this.q.t();
            String str = this.h;
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) hz1VarT.a;
            workDatabase_Impl.b();
            pm0 pm0Var = (pm0) hz1VarT.c;
            z60 z60VarA = pm0Var.a();
            if (str == null) {
                z60VarA.g(1);
            } else {
                z60VarA.e(1, str);
            }
            workDatabase_Impl.c();
            try {
                z60VarA.a();
                workDatabase_Impl.n();
                if (iF == 0) {
                    e(false);
                } else if (iF == 2) {
                    a(this.m);
                } else if (!k31.d(iF)) {
                    this.x = -512;
                    c();
                }
                this.q.n();
                this.q.j();
            } finally {
                workDatabase_Impl.j();
                pm0Var.d(z60VarA);
            }
        } catch (Throwable th) {
            this.q.j();
            throw th;
        }
    }

    public final void c() {
        String str = this.h;
        mz1 mz1Var = this.r;
        WorkDatabase workDatabase = this.q;
        workDatabase.c();
        try {
            mz1Var.n(1, str);
            this.o.getClass();
            mz1Var.l(str, System.currentTimeMillis());
            mz1Var.k(this.j.v, str);
            mz1Var.j(str, -1L);
            workDatabase.n();
        } finally {
            workDatabase.j();
            e(true);
        }
    }

    public final void d() {
        String str = this.h;
        mz1 mz1Var = this.r;
        WorkDatabase workDatabase = this.q;
        workDatabase.c();
        try {
            this.o.getClass();
            mz1Var.l(str, System.currentTimeMillis());
            mz1Var.n(1, str);
            WorkDatabase_Impl workDatabase_Impl = mz1Var.a;
            workDatabase_Impl.b();
            pm0 pm0Var = mz1Var.j;
            z60 z60VarA = pm0Var.a();
            if (str == null) {
                z60VarA.g(1);
            } else {
                z60VarA.e(1, str);
            }
            workDatabase_Impl.c();
            try {
                z60VarA.a();
                workDatabase_Impl.n();
                workDatabase_Impl.j();
                pm0Var.d(z60VarA);
                mz1Var.k(this.j.v, str);
                workDatabase_Impl.b();
                pm0 pm0Var2 = mz1Var.f;
                z60 z60VarA2 = pm0Var2.a();
                if (str == null) {
                    z60VarA2.g(1);
                } else {
                    z60VarA2.e(1, str);
                }
                workDatabase_Impl.c();
                try {
                    z60VarA2.a();
                    workDatabase_Impl.n();
                    workDatabase_Impl.j();
                    pm0Var2.d(z60VarA2);
                    mz1Var.j(str, -1L);
                    workDatabase.n();
                } catch (Throwable th) {
                    workDatabase_Impl.j();
                    pm0Var2.d(z60VarA2);
                    throw th;
                }
            } catch (Throwable th2) {
                workDatabase_Impl.j();
                pm0Var.d(z60VarA);
                throw th2;
            }
        } finally {
            workDatabase.j();
            e(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r6) {
        /*
            r5 = this;
            androidx.work.impl.WorkDatabase r0 = r5.q
            r0.c()
            androidx.work.impl.WorkDatabase r0 = r5.q     // Catch: java.lang.Throwable -> L40
            mz1 r0 = r0.u()     // Catch: java.lang.Throwable -> L40
            r0.getClass()     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"
            r2 = 0
            lc1 r1 = defpackage.lc1.a(r2, r1)     // Catch: java.lang.Throwable -> L40
            androidx.work.impl.WorkDatabase_Impl r0 = r0.a     // Catch: java.lang.Throwable -> L40
            r0.b()     // Catch: java.lang.Throwable -> L40
            android.database.Cursor r0 = r0.l(r1)     // Catch: java.lang.Throwable -> L40
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2d
            r4 = 1
            if (r3 == 0) goto L2f
            int r3 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto L2f
            r3 = 1
            goto L30
        L2d:
            r6 = move-exception
            goto L71
        L2f:
            r3 = 0
        L30:
            r0.close()     // Catch: java.lang.Throwable -> L40
            r1.k()     // Catch: java.lang.Throwable -> L40
            if (r3 != 0) goto L42
            android.content.Context r0 = r5.g     // Catch: java.lang.Throwable -> L40
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r1 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            defpackage.t01.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L40
            goto L42
        L40:
            r6 = move-exception
            goto L78
        L42:
            if (r6 == 0) goto L5d
            mz1 r0 = r5.r     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r5.h     // Catch: java.lang.Throwable -> L40
            r0.n(r4, r1)     // Catch: java.lang.Throwable -> L40
            mz1 r0 = r5.r     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r5.h     // Catch: java.lang.Throwable -> L40
            int r2 = r5.x     // Catch: java.lang.Throwable -> L40
            r0.o(r2, r1)     // Catch: java.lang.Throwable -> L40
            mz1 r0 = r5.r     // Catch: java.lang.Throwable -> L40
            java.lang.String r1 = r5.h     // Catch: java.lang.Throwable -> L40
            r2 = -1
            r0.j(r1, r2)     // Catch: java.lang.Throwable -> L40
        L5d:
            androidx.work.impl.WorkDatabase r0 = r5.q     // Catch: java.lang.Throwable -> L40
            r0.n()     // Catch: java.lang.Throwable -> L40
            androidx.work.impl.WorkDatabase r0 = r5.q
            r0.j()
            nf1 r0 = r5.v
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r0.i(r6)
            return
        L71:
            r0.close()     // Catch: java.lang.Throwable -> L40
            r1.k()     // Catch: java.lang.Throwable -> L40
            throw r6     // Catch: java.lang.Throwable -> L40
        L78:
            androidx.work.impl.WorkDatabase r0 = r5.q
            r0.j()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uz1.e(boolean):void");
    }

    public final void f() {
        if (this.r.f(this.h) == 2) {
            ka0.j().getClass();
            e(true);
        } else {
            ka0.j().getClass();
            e(false);
        }
    }

    public final void g() {
        String str = this.h;
        WorkDatabase workDatabase = this.q;
        workDatabase.c();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                mz1 mz1Var = this.r;
                if (zIsEmpty) {
                    wr wrVar = ((eo0) this.m).a;
                    mz1Var.k(this.j.v, str);
                    mz1Var.m(str, wrVar);
                    workDatabase.n();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (mz1Var.f(str2) != 6) {
                    mz1Var.n(4, str2);
                }
                linkedList.addAll(this.s.g(str2));
            }
        } finally {
            workDatabase.j();
            e(false);
        }
    }

    public final boolean h() {
        if (this.x == -256) {
            return false;
        }
        ka0.j().getClass();
        if (this.r.f(this.h) == 0) {
            e(false);
            return true;
        }
        e(!k31.d(r0));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0078 A[Catch: all -> 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:13:0x004d, B:15:0x0051, B:20:0x0065, B:22:0x006b, B:24:0x006f, B:34:0x009a, B:29:0x0078, B:31:0x0089), top: B:102:0x004d }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uz1.run():void");
    }
}
