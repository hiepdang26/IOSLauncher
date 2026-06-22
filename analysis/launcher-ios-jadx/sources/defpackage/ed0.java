package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class ed0 implements Closeable, AutoCloseable {
    public static final Logger k = Logger.getLogger(qc0.class.getName());
    public final b81 g;
    public final dd0 h;
    public final boolean i;
    public final gc0 j;

    public ed0(b81 b81Var, boolean z) {
        this.g = b81Var;
        this.i = z;
        dd0 dd0Var = new dd0(b81Var);
        this.h = dd0Var;
        this.j = new gc0(dd0Var);
    }

    public static int A(b81 b81Var) {
        return (b81Var.h() & 255) | ((b81Var.h() & 255) << 16) | ((b81Var.h() & 255) << 8);
    }

    public static int a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        qc0.c("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    public final void B(ad0 ad0Var, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            qc0.c("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            qc0.c("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        int iR = this.g.r();
        int iR2 = this.g.r();
        boolean z = (b & 1) != 0;
        ad0Var.getClass();
        if (!z) {
            try {
                bd0 bd0Var = (bd0) ad0Var.j;
                bd0Var.n.execute(new zc0(bd0Var, iR, iR2));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (((bd0) ad0Var.j)) {
            try {
                if (iR == 1) {
                    ((bd0) ad0Var.j).q++;
                } else if (iR == 2) {
                    ((bd0) ad0Var.j).s++;
                } else if (iR == 3) {
                    bd0 bd0Var2 = (bd0) ad0Var.j;
                    bd0Var2.getClass();
                    bd0Var2.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C(ad0 ad0Var, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            qc0.c("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short sH = (b & 8) != 0 ? (short) (this.g.h() & 255) : (short) 0;
        int iR = this.g.r() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        ArrayList arrayListR = r(a(i - 4, b, sH), sH, b, i2);
        bd0 bd0Var = (bd0) ad0Var.j;
        synchronized (bd0Var) {
            try {
                if (bd0Var.B.contains(Integer.valueOf(iR))) {
                    bd0Var.B(iR, 2);
                    return;
                }
                bd0Var.B.add(Integer.valueOf(iR));
                try {
                    bd0Var.k(new uc0(bd0Var, new Object[]{bd0Var.j, Integer.valueOf(iR)}, iR, arrayListR));
                } catch (RejectedExecutionException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(boolean z, ad0 ad0Var) throws IOException {
        int i;
        try {
            this.g.C(9L);
            int iA = A(this.g);
            if (iA < 0 || iA > 16384) {
                qc0.c("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
                throw null;
            }
            byte bH = (byte) (this.g.h() & 255);
            if (z && bH != 4) {
                qc0.c("Expected a SETTINGS frame but was %s", Byte.valueOf(bH));
                throw null;
            }
            byte bH2 = (byte) (this.g.h() & 255);
            int iR = this.g.r();
            int i2 = Integer.MAX_VALUE & iR;
            Logger logger = k;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(qc0.a(true, i2, iA, bH, bH2));
            }
            switch (bH) {
                case 0:
                    k(ad0Var, iA, bH2, i2);
                    return true;
                case 1:
                    z(ad0Var, iA, bH2, i2);
                    return true;
                case 2:
                    if (iA != 5) {
                        qc0.c("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i2 == 0) {
                        qc0.c("TYPE_PRIORITY streamId == 0", new Object[0]);
                        throw null;
                    }
                    b81 b81Var = this.g;
                    b81Var.r();
                    b81Var.h();
                    ad0Var.getClass();
                    return true;
                case 3:
                    if (iA != 4) {
                        qc0.c("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iA));
                        throw null;
                    }
                    if (i2 == 0) {
                        qc0.c("TYPE_RST_STREAM streamId == 0", new Object[0]);
                        throw null;
                    }
                    int iR2 = this.g.r();
                    int[] iArrY = uo.y(11);
                    int length = iArrY.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            i = iArrY[i3];
                            if (uo.a(i) != iR2) {
                                i3++;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        qc0.c("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iR2));
                        throw null;
                    }
                    bd0 bd0Var = (bd0) ad0Var.j;
                    bd0Var.getClass();
                    if (i2 != 0 && (iR & 1) == 0) {
                        bd0Var.k(new uc0(bd0Var, new Object[]{bd0Var.j, Integer.valueOf(i2)}, i2, i));
                        return true;
                    }
                    id0 id0VarN = bd0Var.n(i2);
                    if (id0VarN != null) {
                        id0VarN.j(i);
                    }
                    return true;
                case 4:
                    if (i2 != 0) {
                        qc0.c("TYPE_SETTINGS streamId != 0", new Object[0]);
                        throw null;
                    }
                    if ((bH2 & 1) != 0) {
                        if (iA != 0) {
                            qc0.c("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                            throw null;
                        }
                        ad0Var.getClass();
                    } else {
                        if (iA % 6 != 0) {
                            qc0.c("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(iA));
                            throw null;
                        }
                        t3 t3Var = new t3(8, false);
                        for (int i4 = 0; i4 < iA; i4 += 6) {
                            b81 b81Var2 = this.g;
                            int iZ = b81Var2.z() & 65535;
                            int iR3 = b81Var2.r();
                            if (iZ == 2) {
                                if (iR3 != 0 && iR3 != 1) {
                                    qc0.c("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                    throw null;
                                }
                            } else if (iZ == 3) {
                                iZ = 4;
                            } else if (iZ != 4) {
                                if (iZ == 5 && (iR3 < 16384 || iR3 > 16777215)) {
                                    qc0.c("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iR3));
                                    throw null;
                                }
                            } else {
                                if (iR3 < 0) {
                                    qc0.c("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    throw null;
                                }
                                iZ = 7;
                            }
                            t3Var.h(iZ, iR3);
                        }
                        ad0Var.getClass();
                        try {
                            bd0 bd0Var2 = (bd0) ad0Var.j;
                            bd0Var2.n.execute(new ad0(ad0Var, new Object[]{bd0Var2.j}, t3Var));
                            break;
                        } catch (RejectedExecutionException unused) {
                        }
                    }
                    return true;
                case 5:
                    C(ad0Var, iA, bH2, i2);
                    return true;
                case 6:
                    B(ad0Var, iA, bH2, i2);
                    return true;
                case 7:
                    n(ad0Var, iA, i2);
                    return true;
                case 8:
                    if (iA != 4) {
                        qc0.c("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iA));
                        throw null;
                    }
                    long jR = ((long) this.g.r()) & 2147483647L;
                    if (jR == 0) {
                        qc0.c("windowSizeIncrement was 0", Long.valueOf(jR));
                        throw null;
                    }
                    if (i2 == 0) {
                        synchronized (((bd0) ad0Var.j)) {
                            bd0 bd0Var3 = (bd0) ad0Var.j;
                            bd0Var3.v += jR;
                            bd0Var3.notifyAll();
                            break;
                        }
                        return true;
                    }
                    id0 id0VarB = ((bd0) ad0Var.j).b(i2);
                    if (id0VarB != null) {
                        synchronized (id0VarB) {
                            id0VarB.b += jR;
                            if (jR > 0) {
                                id0VarB.notifyAll();
                            }
                            break;
                        }
                        return true;
                    }
                    return true;
                default:
                    this.g.D(iA);
                    return true;
            }
        } catch (EOFException unused2) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.g.close();
    }

    public final void h(ad0 ad0Var) throws IOException {
        if (this.i) {
            if (b(true, ad0Var)) {
                return;
            }
            qc0.c("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        df dfVar = qc0.a;
        df dfVarK = this.g.k(dfVar.g.length);
        Level level = Level.FINE;
        Logger logger = k;
        if (logger.isLoggable(level)) {
            String strE = dfVarK.e();
            byte[] bArr = wq1.a;
            Locale locale = Locale.US;
            logger.fine("<< CONNECTION " + strE);
        }
        if (dfVar.equals(dfVarK)) {
            return;
        }
        qc0.c("Expected a connection header but was %s", dfVarK.l());
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0133, code lost:
    
        if (r8 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0135, code lost:
    
        r4.i(defpackage.wq1.c, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(defpackage.ad0 r17, int r18, byte r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ed0.k(ad0, int, byte, int):void");
    }

    public final void n(ad0 ad0Var, int i, int i2) throws IOException {
        int i3;
        id0[] id0VarArr;
        if (i < 8) {
            qc0.c("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            qc0.c("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int iR = this.g.r();
        int iR2 = this.g.r();
        int i4 = i - 8;
        int[] iArrY = uo.y(11);
        int length = iArrY.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i3 = 0;
                break;
            }
            i3 = iArrY[i5];
            if (uo.a(i3) == iR2) {
                break;
            } else {
                i5++;
            }
        }
        if (i3 == 0) {
            qc0.c("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iR2));
            throw null;
        }
        df dfVarK = df.k;
        if (i4 > 0) {
            dfVarK = this.g.k(i4);
        }
        ad0Var.getClass();
        dfVarK.i();
        synchronized (((bd0) ad0Var.j)) {
            id0VarArr = (id0[]) ((bd0) ad0Var.j).i.values().toArray(new id0[((bd0) ad0Var.j).i.size()]);
            ((bd0) ad0Var.j).m = true;
        }
        for (id0 id0Var : id0VarArr) {
            if (id0Var.c > iR && id0Var.g()) {
                id0Var.j(5);
                ((bd0) ad0Var.j).n(id0Var.c);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        throw new java.io.IOException(defpackage.k31.k(r4, "Header index too large "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList r(int r3, short r4, byte r5, int r6) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ed0.r(int, short, byte, int):java.util.ArrayList");
    }

    public final void z(ad0 ad0Var, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            qc0.c("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b & 1) != 0;
        short sH = (b & 8) != 0 ? (short) (this.g.h() & 255) : (short) 0;
        if ((b & 32) != 0) {
            b81 b81Var = this.g;
            b81Var.r();
            b81Var.h();
            ad0Var.getClass();
            i -= 5;
        }
        ArrayList arrayListR = r(a(i, b, sH), sH, b, i2);
        ((bd0) ad0Var.j).getClass();
        if (i2 != 0 && (i2 & 1) == 0) {
            bd0 bd0Var = (bd0) ad0Var.j;
            bd0Var.getClass();
            try {
                bd0Var.k(new uc0(bd0Var, new Object[]{bd0Var.j, Integer.valueOf(i2)}, i2, arrayListR, z));
                return;
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        synchronized (((bd0) ad0Var.j)) {
            try {
                id0 id0VarB = ((bd0) ad0Var.j).b(i2);
                if (id0VarB != null) {
                    id0VarB.i(wq1.s(arrayListR), z);
                    return;
                }
                bd0 bd0Var2 = (bd0) ad0Var.j;
                if (bd0Var2.m) {
                    return;
                }
                if (i2 <= bd0Var2.k) {
                    return;
                }
                if (i2 % 2 == bd0Var2.l % 2) {
                    return;
                }
                id0 id0Var = new id0(i2, (bd0) ad0Var.j, false, z, wq1.s(arrayListR));
                bd0 bd0Var3 = (bd0) ad0Var.j;
                bd0Var3.k = i2;
                bd0Var3.i.put(Integer.valueOf(i2), id0Var);
                bd0.C.execute(new ad0(ad0Var, new Object[]{((bd0) ad0Var.j).j, Integer.valueOf(i2)}, id0Var));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
