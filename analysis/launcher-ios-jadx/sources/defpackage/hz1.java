package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.work.impl.WorkDatabase_Impl;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class hz1 {
    public final Object a;
    public final Object b;
    public final Object c;
    public Object d;

    public hz1(WorkDatabase_Impl workDatabase_Impl) {
        this.a = workDatabase_Impl;
        this.b = new su(workDatabase_Impl, 6);
        this.c = new pm0(workDatabase_Impl, 3);
        this.d = new pm0(workDatabase_Impl, 4);
    }

    public synchronized void a(i00 i00Var, j00 j00Var) {
        q1 q1Var = (q1) ((HashMap) this.b).put(i00Var, new q1(i00Var, j00Var, (ReferenceQueue) this.c));
        if (q1Var != null) {
            q1Var.c = null;
            q1Var.clear();
        }
    }

    public void b(q1 q1Var) {
        eb1 eb1Var;
        synchronized (this) {
            ((HashMap) this.b).remove(q1Var.a);
            if (q1Var.b && (eb1Var = q1Var.c) != null) {
                ((d00) this.d).e(q1Var.a, new j00(eb1Var, true, false, q1Var.a, (d00) this.d));
            }
        }
    }

    public synchronized boolean c(yi0 yi0Var) {
        try {
            String str = yi0Var.h;
            if (!((HashMap) this.a).containsKey(str)) {
                ((HashMap) this.a).put(str, null);
                yi0Var.j(this);
                if (gv1.a) {
                    gv1.a("new request, sending to network %s", str);
                }
                return false;
            }
            List arrayList = (List) ((HashMap) this.a).get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            yi0Var.a("waiting-for-response");
            arrayList.add(yi0Var);
            ((HashMap) this.a).put(str, arrayList);
            if (gv1.a) {
                gv1.a("Request for cacheKey=%s is in flight, putting on hold.", str);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d(yi0 yi0Var) {
        PriorityBlockingQueue priorityBlockingQueue;
        try {
            String str = yi0Var.h;
            List list = (List) ((HashMap) this.a).remove(str);
            if (list != null && !list.isEmpty()) {
                if (gv1.a) {
                    gv1.b("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), str);
                }
                yi0 yi0Var2 = (yi0) list.remove(0);
                ((HashMap) this.a).put(str, list);
                yi0Var2.j(this);
                if (((hf) this.c) != null && (priorityBlockingQueue = (PriorityBlockingQueue) this.d) != null) {
                    try {
                        priorityBlockingQueue.put(yi0Var2);
                    } catch (InterruptedException e) {
                        gv1.a("Couldn't add request to queue. %s", e.toString());
                        Thread.currentThread().interrupt();
                        hf hfVar = (hf) this.c;
                        hfVar.k = true;
                        hfVar.interrupt();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void e(yi0 yi0Var, uv uvVar) {
        List list;
        ef efVar = (ef) uvVar.g;
        if (efVar == null || efVar.e < System.currentTimeMillis()) {
            d(yi0Var);
            return;
        }
        String str = yi0Var.h;
        synchronized (this) {
            list = (List) ((HashMap) this.a).remove(str);
        }
        if (list != null) {
            if (gv1.a) {
                gv1.b("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), str);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((mc1) this.b).z((yi0) it.next(), uvVar, null);
            }
        }
    }

    public hz1() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new p1(0));
        this.b = new HashMap();
        this.c = new ReferenceQueue();
        this.a = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new o1(this, 1));
    }

    public hz1(Context context, qm0 qm0Var) {
        Object jx0Var;
        Context applicationContext = context.getApplicationContext();
        qg0.k(applicationContext, "context.applicationContext");
        yb ybVar = new yb(applicationContext, qm0Var, 0);
        Context applicationContext2 = context.getApplicationContext();
        qg0.k(applicationContext2, "context.applicationContext");
        yb ybVar2 = new yb(applicationContext2, qm0Var, 1);
        Context applicationContext3 = context.getApplicationContext();
        qg0.k(applicationContext3, "context.applicationContext");
        int i = ix0.a;
        if (Build.VERSION.SDK_INT >= 24) {
            jx0Var = new hx0(applicationContext3, qm0Var);
        } else {
            jx0Var = new jx0(applicationContext3, qm0Var);
        }
        Context applicationContext4 = context.getApplicationContext();
        qg0.k(applicationContext4, "context.applicationContext");
        yb ybVar3 = new yb(applicationContext4, qm0Var, 2);
        this.a = ybVar;
        this.b = ybVar2;
        this.c = jx0Var;
        this.d = ybVar3;
    }

    public hz1(hf hfVar, PriorityBlockingQueue priorityBlockingQueue, mc1 mc1Var) {
        this.a = new HashMap();
        this.b = mc1Var;
        this.c = hfVar;
        this.d = priorityBlockingQueue;
    }

    public hz1(Typeface typeface, cu0 cu0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        this.d = typeface;
        this.a = cu0Var;
        this.c = new du0(1024);
        int iA = cu0Var.a(6);
        if (iA != 0) {
            int i5 = iA + cu0Var.g;
            i = ((ByteBuffer) cu0Var.j).getInt(((ByteBuffer) cu0Var.j).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.b = new char[i * 2];
        int iA2 = cu0Var.a(6);
        if (iA2 != 0) {
            int i6 = iA2 + cu0Var.g;
            i2 = ((ByteBuffer) cu0Var.j).getInt(((ByteBuffer) cu0Var.j).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            hz hzVar = new hz(this, i7);
            bu0 bu0VarB = hzVar.b();
            int iA3 = bu0VarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) bu0VarB.j).getInt(iA3 + bu0VarB.g) : 0, (char[]) this.b, i7 * 2);
            bu0 bu0VarB2 = hzVar.b();
            int iA4 = bu0VarB2.a(16);
            if (iA4 != 0) {
                int i8 = iA4 + bu0VarB2.g;
                i3 = ((ByteBuffer) bu0VarB2.j).getInt(((ByteBuffer) bu0VarB2.j).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            qg0.e("invalid metadata codepoint length", i3 > 0);
            bu0 bu0VarB3 = hzVar.b();
            int iA5 = bu0VarB3.a(16);
            if (iA5 != 0) {
                int i9 = iA5 + bu0VarB3.g;
                i4 = ((ByteBuffer) bu0VarB3.j).getInt(((ByteBuffer) bu0VarB3.j).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            ((du0) this.c).a(hzVar, 0, i4 - 1);
        }
    }
}
