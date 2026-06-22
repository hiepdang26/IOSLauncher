package defpackage;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class v02 implements fa0, ga0 {
    public final s5 h;
    public final b6 i;
    public final oz1 j;
    public final int m;
    public final g12 n;
    public boolean o;
    public final /* synthetic */ ha0 s;
    public final LinkedList g = new LinkedList();
    public final HashSet k = new HashSet();
    public final HashMap l = new HashMap();
    public final ArrayList p = new ArrayList();
    public vl q = null;
    public int r = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public v02(ha0 ha0Var, ca0 ca0Var) {
        this.s = ha0Var;
        Looper looper = ha0Var.t.getLooper();
        wb2 wb2VarB = ca0Var.b();
        mj mjVar = new mj((g9) wb2VarB.h, (String) wb2VarB.i, (String) wb2VarB.j);
        n90 n90Var = (n90) ca0Var.i.i;
        hg0.i(n90Var);
        s5 s5VarA = n90Var.a(ca0Var.g, looper, mjVar, ca0Var.j, this, this);
        String str = ca0Var.h;
        if (str != null && (s5VarA instanceof eb)) {
            ((eb) s5VarA).setAttributionTag(str);
        }
        if (str != null && (s5VarA instanceof rx0)) {
            k31.q(s5VarA);
            throw null;
        }
        this.h = s5VarA;
        this.i = ca0Var.k;
        this.j = new oz1(9);
        this.m = ca0Var.l;
        if (!s5VarA.requiresSignIn()) {
            this.n = null;
            return;
        }
        t12 t12Var = ha0Var.t;
        wb2 wb2VarB2 = ca0Var.b();
        this.n = new g12(ha0Var.k, t12Var, new mj((g9) wb2VarB2.h, (String) wb2VarB2.i, (String) wb2VarB2.j));
    }

    public final void a(vl vlVar) {
        HashSet hashSet = this.k;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (bf1.c(vlVar, vl.k)) {
                this.h.getEndpointPackageName();
            }
            throw null;
        }
    }

    public final void b(Status status) {
        hg0.f(this.s.t);
        c(status, null, false);
    }

    public final void c(Status status, RuntimeException runtimeException, boolean z) {
        hg0.f(this.s.t);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            y02 y02Var = (y02) it.next();
            if (!z || y02Var.a == 2) {
                if (status != null) {
                    y02Var.c(status);
                } else {
                    y02Var.d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void d() {
        LinkedList linkedList = this.g;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            y02 y02Var = (y02) arrayList.get(i);
            if (!this.h.isConnected()) {
                return;
            }
            if (i(y02Var)) {
                linkedList.remove(y02Var);
            }
        }
    }

    public final void e() {
        ha0 ha0Var = this.s;
        hg0.f(ha0Var.t);
        this.q = null;
        a(vl.k);
        if (this.o) {
            t12 t12Var = ha0Var.t;
            b6 b6Var = this.i;
            t12Var.removeMessages(11, b6Var);
            ha0Var.t.removeMessages(9, b6Var);
            this.o = false;
        }
        Iterator it = this.l.values().iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        d();
        h();
    }

    @Override // defpackage.fa0
    public final void f() {
        Looper looperMyLooper = Looper.myLooper();
        ha0 ha0Var = this.s;
        if (looperMyLooper == ha0Var.t.getLooper()) {
            e();
        } else {
            ha0Var.t.post(new fl0(this, 23));
        }
    }

    public final void g(int i) {
        ha0 ha0Var = this.s;
        hg0.f(ha0Var.t);
        this.q = null;
        this.o = true;
        String lastDisconnectMessage = this.h.getLastDisconnectMessage();
        oz1 oz1Var = this.j;
        oz1Var.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        oz1Var.k(true, new Status(20, sb.toString(), null, null));
        t12 t12Var = ha0Var.t;
        b6 b6Var = this.i;
        t12Var.sendMessageDelayed(Message.obtain(t12Var, 9, b6Var), 5000L);
        t12 t12Var2 = ha0Var.t;
        t12Var2.sendMessageDelayed(Message.obtain(t12Var2, 11, b6Var), 120000L);
        ((SparseIntArray) ha0Var.m.g).clear();
        Iterator it = this.l.values().iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
    }

    public final void h() {
        ha0 ha0Var = this.s;
        t12 t12Var = ha0Var.t;
        b6 b6Var = this.i;
        t12Var.removeMessages(12, b6Var);
        t12 t12Var2 = ha0Var.t;
        t12Var2.sendMessageDelayed(t12Var2.obtainMessage(12, b6Var), ha0Var.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(defpackage.y02 r15) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v02.i(y02):boolean");
    }

    public final boolean j(vl vlVar) {
        synchronized (ha0.x) {
            try {
                ha0 ha0Var = this.s;
                if (ha0Var.q == null || !ha0Var.r.contains(this.i)) {
                    return false;
                }
                t02 t02Var = this.s.q;
                int i = this.m;
                t02Var.getClass();
                q12 q12Var = new q12(vlVar, i);
                AtomicReference atomicReference = t02Var.i;
                while (true) {
                    if (atomicReference.compareAndSet(null, q12Var)) {
                        t02Var.j.post(new el0(t02Var, q12Var, 22));
                        break;
                    }
                    if (atomicReference.get() != null) {
                        break;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        ha0 ha0Var = this.s;
        hg0.f(ha0Var.t);
        s5 s5Var = this.h;
        if (s5Var.isConnected() || s5Var.isConnecting()) {
            return;
        }
        try {
            b52 b52Var = ha0Var.m;
            Context context = ha0Var.k;
            b52Var.getClass();
            hg0.i(context);
            int iC = 0;
            if (s5Var.requiresGooglePlayServices()) {
                int minApkVersion = s5Var.getMinApkVersion();
                SparseIntArray sparseIntArray = (SparseIntArray) b52Var.g;
                int i = sparseIntArray.get(minApkVersion, -1);
                if (i != -1) {
                    iC = i;
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= sparseIntArray.size()) {
                            iC = -1;
                            break;
                        }
                        int iKeyAt = sparseIntArray.keyAt(i2);
                        if (iKeyAt > minApkVersion && sparseIntArray.get(iKeyAt) == 0) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (iC == -1) {
                        iC = ((da0) b52Var.h).c(context, minApkVersion);
                    }
                    sparseIntArray.put(minApkVersion, iC);
                }
            }
            if (iC != 0) {
                vl vlVar = new vl(iC, null);
                new StringBuilder(s5Var.getClass().getName().length() + 35 + vlVar.toString().length());
                m(vlVar, null);
                return;
            }
            b6 b6Var = this.i;
            wc0 wc0Var = new wc0();
            wc0Var.l = ha0Var;
            wc0Var.j = null;
            wc0Var.k = null;
            wc0Var.g = false;
            wc0Var.h = s5Var;
            wc0Var.i = b6Var;
            if (s5Var.requiresSignIn()) {
                g12 g12Var = this.n;
                hg0.i(g12Var);
                rg1 rg1Var = g12Var.m;
                if (rg1Var != null) {
                    rg1Var.disconnect();
                }
                Integer numValueOf = Integer.valueOf(System.identityHashCode(g12Var));
                mj mjVar = g12Var.l;
                mjVar.g = numValueOf;
                t12 t12Var = g12Var.i;
                Looper looper = t12Var.getLooper();
                g12Var.m = (rg1) g12Var.j.a(g12Var.h, looper, mjVar, (sg1) mjVar.f, g12Var, g12Var);
                g12Var.n = wc0Var;
                Set set = g12Var.k;
                if (set == null || set.isEmpty()) {
                    t12Var.post(new fl0(g12Var, 25));
                } else {
                    rg1 rg1Var2 = g12Var.m;
                    rg1Var2.getClass();
                    rg1Var2.connect(new fz1(rg1Var2, 4));
                }
            }
            try {
                s5Var.connect(wc0Var);
            } catch (SecurityException e) {
                m(new vl(10), e);
            }
        } catch (IllegalStateException e2) {
            m(new vl(10), e2);
        }
    }

    public final void l(y02 y02Var) {
        hg0.f(this.s.t);
        boolean zIsConnected = this.h.isConnected();
        LinkedList linkedList = this.g;
        if (zIsConnected) {
            if (i(y02Var)) {
                h();
                return;
            } else {
                linkedList.add(y02Var);
                return;
            }
        }
        linkedList.add(y02Var);
        vl vlVar = this.q;
        if (vlVar == null || vlVar.h == 0 || vlVar.i == null) {
            k();
        } else {
            m(vlVar, null);
        }
    }

    public final void m(vl vlVar, RuntimeException runtimeException) {
        rg1 rg1Var;
        hg0.f(this.s.t);
        g12 g12Var = this.n;
        if (g12Var != null && (rg1Var = g12Var.m) != null) {
            rg1Var.disconnect();
        }
        hg0.f(this.s.t);
        this.q = null;
        ((SparseIntArray) this.s.m.g).clear();
        a(vlVar);
        if ((this.h instanceof s12) && vlVar.h != 24) {
            ha0 ha0Var = this.s;
            ha0Var.h = true;
            t12 t12Var = ha0Var.t;
            t12Var.sendMessageDelayed(t12Var.obtainMessage(19), 300000L);
        }
        if (vlVar.h == 4) {
            b(ha0.w);
            return;
        }
        if (this.g.isEmpty()) {
            this.q = vlVar;
            return;
        }
        if (runtimeException != null) {
            hg0.f(this.s.t);
            c(null, runtimeException, false);
            return;
        }
        if (!this.s.u) {
            b(ha0.d(this.i, vlVar));
            return;
        }
        c(ha0.d(this.i, vlVar), null, true);
        if (this.g.isEmpty() || j(vlVar) || this.s.c(vlVar, this.m)) {
            return;
        }
        if (vlVar.h == 18) {
            this.o = true;
        }
        if (!this.o) {
            b(ha0.d(this.i, vlVar));
            return;
        }
        t12 t12Var2 = this.s.t;
        Message messageObtain = Message.obtain(t12Var2, 9, this.i);
        this.s.getClass();
        t12Var2.sendMessageDelayed(messageObtain, 5000L);
    }

    public final void n() {
        hg0.f(this.s.t);
        Status status = ha0.v;
        b(status);
        this.j.k(false, status);
        for (jo0 jo0Var : (jo0[]) this.l.keySet().toArray(new jo0[0])) {
            l(new m12(new qm1()));
        }
        a(new vl(4));
        s5 s5Var = this.h;
        if (s5Var.isConnected()) {
            s5Var.onUserSignOut(new xz1(this));
        }
    }

    @Override // defpackage.ga0
    public final void onConnectionFailed(vl vlVar) {
        m(vlVar, null);
    }

    @Override // defpackage.fa0
    public final void onConnectionSuspended(int i) {
        Looper looperMyLooper = Looper.myLooper();
        ha0 ha0Var = this.s;
        if (looperMyLooper == ha0Var.t.getLooper()) {
            g(i);
        } else {
            ha0Var.t.post(new yf(this, i, 6));
        }
    }
}
