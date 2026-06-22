package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class cd0 implements f10 {
    public static final List g = wq1.k("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List h = wq1.k("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public final g81 a;
    public final e81 b;
    public final bd0 c;
    public volatile id0 d;
    public final z31 e;
    public volatile boolean f;

    public cd0(iy0 iy0Var, e81 e81Var, g81 g81Var, bd0 bd0Var) {
        this.b = e81Var;
        this.a = g81Var;
        this.c = bd0Var;
        List list = iy0Var.h;
        z31 z31Var = z31.H2_PRIOR_KNOWLEDGE;
        this.e = list.contains(z31Var) ? z31Var : z31.HTTP_2;
    }

    @Override // defpackage.f10
    public final fi1 a(tb1 tb1Var) {
        return this.d.g;
    }

    @Override // defpackage.f10
    public final void b() {
        this.d.f().close();
    }

    @Override // defpackage.f10
    public final void c() {
        this.c.flush();
    }

    @Override // defpackage.f10
    public final void cancel() {
        this.f = true;
        if (this.d != null) {
            this.d.e(6);
        }
    }

    @Override // defpackage.f10
    public final ih1 d(ia1 ia1Var, long j) {
        return this.d.f();
    }

    @Override // defpackage.f10
    public final sb1 e(boolean z) throws IOException {
        ob0 ob0Var;
        id0 id0Var = this.d;
        synchronized (id0Var) {
            id0Var.i.i();
            while (id0Var.e.isEmpty() && id0Var.k == 0) {
                try {
                    id0Var.k();
                } catch (Throwable th) {
                    id0Var.i.n();
                    throw th;
                }
            }
            id0Var.i.n();
            if (id0Var.e.isEmpty()) {
                IOException iOException = id0Var.l;
                if (iOException != null) {
                    throw iOException;
                }
                throw new vj1(id0Var.k);
            }
            ob0Var = (ob0) id0Var.e.removeFirst();
        }
        z31 z31Var = this.e;
        ArrayList arrayList = new ArrayList(20);
        int iG = ob0Var.g();
        xk xkVarC = null;
        for (int i = 0; i < iG; i++) {
            String strD = ob0Var.d(i);
            String strH = ob0Var.h(i);
            if (strD.equals(":status")) {
                xkVarC = xk.c("HTTP/1.1 " + strH);
            } else if (!h.contains(strD)) {
                ka0.q.getClass();
                arrayList.add(strD);
                arrayList.add(strH.trim());
            }
        }
        if (xkVarC == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        sb1 sb1Var = new sb1();
        sb1Var.b = z31Var;
        sb1Var.c = xkVarC.b;
        sb1Var.d = (String) xkVarC.d;
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        nb0 nb0Var = new nb0();
        Collections.addAll(nb0Var.a, strArr);
        sb1Var.f = nb0Var;
        if (z) {
            ka0.q.getClass();
            if (sb1Var.c == 100) {
                return null;
            }
        }
        return sb1Var;
    }

    @Override // defpackage.f10
    public final long f(tb1 tb1Var) {
        return md0.a(tb1Var);
    }

    @Override // defpackage.f10
    public final void g(ia1 ia1Var) throws IOException {
        int i;
        id0 id0Var;
        if (this.d != null) {
            return;
        }
        boolean z = true;
        boolean z2 = ia1Var.d != null;
        ob0 ob0Var = ia1Var.c;
        ArrayList arrayList = new ArrayList(ob0Var.g() + 4);
        arrayList.add(new ib0(ib0.f, ia1Var.b));
        df dfVar = ib0.g;
        od0 od0Var = ia1Var.a;
        int length = od0Var.a.length() + 3;
        String str = od0Var.i;
        int iIndexOf = str.indexOf(47, length);
        String strSubstring = str.substring(iIndexOf, wq1.g(iIndexOf, str.length(), str, "?#"));
        String strE = od0Var.e();
        if (strE != null) {
            strSubstring = strSubstring + '?' + strE;
        }
        arrayList.add(new ib0(dfVar, strSubstring));
        String strC = ia1Var.c.c("Host");
        if (strC != null) {
            arrayList.add(new ib0(ib0.i, strC));
        }
        arrayList.add(new ib0(ib0.h, od0Var.a));
        int iG = ob0Var.g();
        for (int i2 = 0; i2 < iG; i2++) {
            String lowerCase = ob0Var.d(i2).toLowerCase(Locale.US);
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && ob0Var.h(i2).equals("trailers"))) {
                arrayList.add(new ib0(lowerCase, ob0Var.h(i2)));
            }
        }
        bd0 bd0Var = this.c;
        boolean z3 = !z2;
        synchronized (bd0Var.z) {
            synchronized (bd0Var) {
                try {
                    if (bd0Var.l > 1073741823) {
                        bd0Var.r(5);
                    }
                    if (bd0Var.m) {
                        throw new wl();
                    }
                    i = bd0Var.l;
                    bd0Var.l = i + 2;
                    id0Var = new id0(i, bd0Var, z3, false, null);
                    if (z2 && bd0Var.v != 0 && id0Var.b != 0) {
                        z = false;
                    }
                    if (id0Var.h()) {
                        bd0Var.i.put(Integer.valueOf(i), id0Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            bd0Var.z.n(i, arrayList, z3);
        }
        if (z) {
            bd0Var.z.flush();
        }
        this.d = id0Var;
        if (this.f) {
            this.d.e(6);
            throw new IOException("Canceled");
        }
        hd0 hd0Var = this.d.i;
        long j = this.a.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        hd0Var.g(j);
        this.d.j.g(this.a.i);
    }

    @Override // defpackage.f10
    public final e81 h() {
        return this.b;
    }
}
