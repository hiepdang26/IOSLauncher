package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class cg implements Runnable {
    public final /* synthetic */ int g;
    public final Object h;

    public cg(String str, Object[] objArr) {
        this.g = 1;
        byte[] bArr = wq1.a;
        this.h = String.format(Locale.US, str, objArr);
    }

    public static void a(cz1 cz1Var, String str) {
        uz1 uz1VarB;
        WorkDatabase workDatabase = cz1Var.j;
        mz1 mz1VarU = workDatabase.u();
        tu tuVarP = workDatabase.p();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int iF = mz1VarU.f(str2);
            if (iF != 3 && iF != 4) {
                WorkDatabase_Impl workDatabase_Impl = mz1VarU.a;
                workDatabase_Impl.b();
                pm0 pm0Var = mz1VarU.e;
                z60 z60VarA = pm0Var.a();
                if (str2 == null) {
                    z60VarA.g(1);
                } else {
                    z60VarA.e(1, str2);
                }
                workDatabase_Impl.c();
                try {
                    z60VarA.a();
                    workDatabase_Impl.n();
                } finally {
                    workDatabase_Impl.j();
                    pm0Var.d(z60VarA);
                }
            }
            linkedList.addAll(tuVarP.g(str2));
        }
        s31 s31Var = cz1Var.m;
        synchronized (s31Var.k) {
            ka0.j().getClass();
            s31Var.i.add(str);
            uz1VarB = s31Var.b(str);
        }
        s31.e(uz1VarB, 1);
        Iterator it = cz1Var.l.iterator();
        while (it.hasNext()) {
            ((ud1) it.next()).a(str);
        }
    }

    public abstract void b();

    public abstract void c();

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                c01 c01Var = (c01) this.h;
                try {
                    c();
                    c01Var.a(c01.c);
                    return;
                } catch (Throwable th) {
                    c01Var.a(new zz0(th));
                    return;
                }
            default:
                String name = Thread.currentThread().getName();
                Thread.currentThread().setName((String) this.h);
                try {
                    b();
                    return;
                } finally {
                    Thread.currentThread().setName(name);
                }
        }
    }

    public cg() {
        this.g = 0;
        this.h = new c01();
    }
}
