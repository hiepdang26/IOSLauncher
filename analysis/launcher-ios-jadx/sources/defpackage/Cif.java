package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

/* JADX INFO: renamed from: if, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class Cif implements mg0 {
    public final /* synthetic */ int a;

    public /* synthetic */ Cif(int i) {
        this.a = i;
    }

    public static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static tb1 c(tb1 tb1Var) {
        if (tb1Var == null || tb1Var.m == null) {
            return tb1Var;
        }
        sb1 sb1VarB = tb1Var.b();
        sb1VarB.g = null;
        return sb1VarB.a();
    }

    @Override // defpackage.mg0
    public final tb1 a(g81 g81Var) throws Throwable {
        boolean z;
        sb1 sb1VarB;
        Throwable th = null;
        sb1 sb1VarB2 = null;
        switch (this.a) {
            case 0:
                System.currentTimeMillis();
                ia1 ia1Var = g81Var.e;
                q11 q11Var = new q11(ia1Var, (Object) null, 5);
                if (ia1Var != null) {
                    gf gfVarA = ia1Var.f;
                    if (gfVarA == null) {
                        gfVarA = gf.a(ia1Var.c);
                        ia1Var.f = gfVarA;
                    }
                    if (gfVarA.j) {
                        q11Var = new q11((Object) null, (Object) null, 5);
                    }
                }
                ia1 ia1Var2 = (ia1) q11Var.h;
                tb1 tb1Var = (tb1) q11Var.i;
                if (ia1Var2 == null && tb1Var == null) {
                    sb1 sb1Var = new sb1();
                    sb1Var.a = g81Var.e;
                    sb1Var.b = z31.HTTP_1_1;
                    sb1Var.c = 504;
                    sb1Var.d = "Unsatisfiable Request (only-if-cached)";
                    sb1Var.g = wq1.d;
                    sb1Var.k = -1L;
                    sb1Var.l = System.currentTimeMillis();
                    return sb1Var.a();
                }
                if (ia1Var2 == null) {
                    sb1 sb1VarB3 = tb1Var.b();
                    tb1 tb1VarC = c(tb1Var);
                    if (tb1VarC != null) {
                        sb1.b("cacheResponse", tb1VarC);
                    }
                    sb1VarB3.i = tb1VarC;
                    return sb1VarB3.a();
                }
                tb1 tb1VarA = g81Var.a(ia1Var2);
                if (tb1Var != null) {
                    if (tb1VarA.i == 304) {
                        sb1 sb1VarB4 = tb1Var.b();
                        ArrayList arrayList = new ArrayList(20);
                        ob0 ob0Var = tb1Var.l;
                        int iG = ob0Var.g();
                        int i = 0;
                        while (true) {
                            ob0 ob0Var2 = tb1VarA.l;
                            Throwable th2 = th;
                            if (i >= iG) {
                                int iG2 = ob0Var2.g();
                                for (int i2 = 0; i2 < iG2; i2++) {
                                    String strD = ob0Var2.d(i2);
                                    if (!"Content-Length".equalsIgnoreCase(strD) && !"Content-Encoding".equalsIgnoreCase(strD) && !"Content-Type".equalsIgnoreCase(strD) && b(strD)) {
                                        ka0 ka0Var = ka0.q;
                                        String strH = ob0Var2.h(i2);
                                        ka0Var.getClass();
                                        arrayList.add(strD);
                                        arrayList.add(strH.trim());
                                    }
                                }
                                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                                nb0 nb0Var = new nb0();
                                Collections.addAll(nb0Var.a, strArr);
                                sb1VarB4.f = nb0Var;
                                sb1VarB4.k = tb1VarA.q;
                                sb1VarB4.l = tb1VarA.r;
                                tb1 tb1VarC2 = c(tb1Var);
                                if (tb1VarC2 != null) {
                                    sb1.b("cacheResponse", tb1VarC2);
                                }
                                sb1VarB4.i = tb1VarC2;
                                tb1 tb1VarC3 = c(tb1VarA);
                                if (tb1VarC3 != null) {
                                    sb1.b("networkResponse", tb1VarC3);
                                }
                                sb1VarB4.h = tb1VarC3;
                                sb1VarB4.a();
                                tb1VarA.m.close();
                                throw th2;
                            }
                            String strD2 = ob0Var.d(i);
                            String strH2 = ob0Var.h(i);
                            if ((!"Warning".equalsIgnoreCase(strD2) || !strH2.startsWith("1")) && ("Content-Length".equalsIgnoreCase(strD2) || "Content-Encoding".equalsIgnoreCase(strD2) || "Content-Type".equalsIgnoreCase(strD2) || !b(strD2) || ob0Var2.c(strD2) == null)) {
                                ka0.q.getClass();
                                arrayList.add(strD2);
                                arrayList.add(strH2.trim());
                            }
                            i++;
                            th = th2;
                        }
                    } else {
                        wq1.c(tb1Var.m);
                    }
                }
                sb1 sb1VarB5 = tb1VarA.b();
                tb1 tb1VarC4 = c(tb1Var);
                if (tb1VarC4 != null) {
                    sb1.b("cacheResponse", tb1VarC4);
                }
                sb1VarB5.i = tb1VarC4;
                tb1 tb1VarC5 = c(tb1VarA);
                if (tb1VarC5 != null) {
                    sb1.b("networkResponse", tb1VarC5);
                }
                sb1VarB5.h = tb1VarC5;
                return sb1VarB5.a();
            case 1:
                e10 e10Var = g81Var.c;
                if (e10Var == null) {
                    throw new IllegalStateException();
                }
                iy iyVar = e10Var.b;
                f10 f10Var = e10Var.d;
                ia1 ia1Var3 = g81Var.e;
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    iyVar.getClass();
                    f10Var.g(ia1Var3);
                    boolean zD = qg0.D(ia1Var3.b);
                    hp1 hp1Var = e10Var.a;
                    la1 la1Var = ia1Var3.d;
                    if (!zD || la1Var == null) {
                        hp1Var.c(e10Var, true, false, null);
                        z = false;
                    } else {
                        if ("100-continue".equalsIgnoreCase(ia1Var3.c.c("Expect"))) {
                            try {
                                f10Var.c();
                                iyVar.getClass();
                                sb1VarB = e10Var.b(true);
                                z = true;
                            } catch (IOException e) {
                                iyVar.getClass();
                                e10Var.c(e);
                                throw e;
                            }
                        } else {
                            sb1VarB = null;
                            z = false;
                        }
                        if (sb1VarB != null) {
                            hp1Var.c(e10Var, true, false, null);
                            if (f10Var.h().h == null) {
                                f10Var.h().i();
                            }
                        } else if (la1Var.isDuplex()) {
                            try {
                                f10Var.c();
                                e10Var.e = true;
                                long jContentLength = la1Var.contentLength();
                                iyVar.getClass();
                                c10 c10Var = new c10(e10Var, f10Var.d(ia1Var3, jContentLength), jContentLength);
                                Logger logger = jy0.a;
                                la1Var.writeTo(new a81(c10Var));
                            } catch (IOException e2) {
                                iyVar.getClass();
                                e10Var.c(e2);
                                throw e2;
                            }
                        } else {
                            e10Var.e = false;
                            long jContentLength2 = la1Var.contentLength();
                            iyVar.getClass();
                            c10 c10Var2 = new c10(e10Var, f10Var.d(ia1Var3, jContentLength2), jContentLength2);
                            Logger logger2 = jy0.a;
                            a81 a81Var = new a81(c10Var2);
                            la1Var.writeTo(a81Var);
                            a81Var.close();
                        }
                        sb1VarB2 = sb1VarB;
                    }
                    if (la1Var == null || !la1Var.isDuplex()) {
                        try {
                            f10Var.b();
                        } catch (IOException e3) {
                            e10Var.c(e3);
                            throw e3;
                        }
                    }
                    if (!z) {
                        iyVar.getClass();
                    }
                    if (sb1VarB2 == null) {
                        sb1VarB2 = e10Var.b(false);
                    }
                    sb1VarB2.a = ia1Var3;
                    sb1VarB2.e = f10Var.h().f;
                    sb1VarB2.k = jCurrentTimeMillis;
                    sb1VarB2.l = System.currentTimeMillis();
                    tb1 tb1VarA2 = sb1VarB2.a();
                    int i3 = tb1VarA2.i;
                    if (i3 == 100) {
                        sb1 sb1VarB6 = e10Var.b(false);
                        sb1VarB6.a = ia1Var3;
                        sb1VarB6.e = f10Var.h().f;
                        sb1VarB6.k = jCurrentTimeMillis;
                        sb1VarB6.l = System.currentTimeMillis();
                        tb1VarA2 = sb1VarB6.a();
                        i3 = tb1VarA2.i;
                    }
                    sb1 sb1VarB7 = tb1VarA2.b();
                    try {
                        String strA = tb1VarA2.a("Content-Type");
                        long jF = f10Var.f(tb1VarA2);
                        d10 d10Var = new d10(e10Var, f10Var.a(tb1VarA2), jF);
                        Logger logger3 = jy0.a;
                        sb1VarB7.g = new h81(strA, jF, new b81(d10Var), 0);
                        tb1 tb1VarA3 = sb1VarB7.a();
                        if ("close".equalsIgnoreCase(tb1VarA3.g.c.c("Connection")) || "close".equalsIgnoreCase(tb1VarA3.a("Connection"))) {
                            f10Var.h().i();
                        }
                        if (i3 == 204 || i3 == 205) {
                            vb1 vb1Var = tb1VarA3.m;
                            if (vb1Var.contentLength() > 0) {
                                StringBuilder sbL = uo.l(i3, "HTTP ", " had non-zero Content-Length: ");
                                sbL.append(vb1Var.contentLength());
                                throw new ProtocolException(sbL.toString());
                            }
                        }
                        return tb1VarA3;
                    } catch (IOException e4) {
                        e10Var.c(e4);
                        throw e4;
                    }
                } catch (IOException e5) {
                    iyVar.getClass();
                    e10Var.c(e5);
                    throw e5;
                }
                break;
            default:
                ia1 ia1Var4 = g81Var.e;
                hp1 hp1Var2 = g81Var.b;
                boolean z2 = !ia1Var4.b.equals("GET");
                synchronized (hp1Var2.b) {
                    if (hp1Var2.o) {
                        throw new IllegalStateException("released");
                    }
                    if (hp1Var2.j != null) {
                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                    }
                }
                g10 g10Var = hp1Var2.h;
                iy0 iy0Var = hp1Var2.a;
                g10Var.getClass();
                int i4 = g81Var.g;
                int i5 = g81Var.h;
                int i6 = g81Var.i;
                iy0Var.getClass();
                try {
                    e10 e10Var2 = new e10(hp1Var2, hp1Var2.c, hp1Var2.d, hp1Var2.h, g10Var.b(i4, i5, i6, iy0Var.z, z2).h(iy0Var, g81Var));
                    synchronized (hp1Var2.b) {
                        hp1Var2.j = e10Var2;
                        hp1Var2.k = false;
                        hp1Var2.l = false;
                        break;
                    }
                    return g81Var.b(ia1Var4, hp1Var2, e10Var2);
                } catch (IOException e6) {
                    g10Var.e();
                    throw new uc1(e6);
                } catch (uc1 e7) {
                    g10Var.e();
                    throw e7;
                }
        }
    }
}
