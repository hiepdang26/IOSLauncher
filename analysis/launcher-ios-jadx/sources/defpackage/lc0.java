package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class lc0 extends jc0 {
    public final od0 j;
    public long k;
    public boolean l;
    public final /* synthetic */ pc0 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc0(pc0 pc0Var, od0 od0Var) {
        super(pc0Var);
        this.m = pc0Var;
        this.k = -1L;
        this.l = true;
        this.j = od0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zP;
        if (this.h) {
            return;
        }
        if (this.l) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                zP = wq1.p(this, 100);
            } catch (IOException unused) {
                zP = false;
            }
            if (!zP) {
                this.m.b.i();
                a();
            }
        }
        this.h = true;
    }

    @Override // defpackage.jc0, defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        long j2;
        fe feVar2;
        boolean z;
        byte bK;
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
        }
        if (this.h) {
            throw new IllegalStateException("closed");
        }
        long j3 = -1;
        if (!this.l) {
            return -1L;
        }
        long j4 = this.k;
        pc0 pc0Var = this.m;
        if (j4 == 0 || j4 == -1) {
            if (j4 != -1) {
                pc0Var.c.A(Long.MAX_VALUE);
            }
            try {
                b81 b81Var = pc0Var.c;
                b81Var.C(1L);
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    j2 = j3;
                    boolean zB = b81Var.B(i2);
                    feVar2 = b81Var.g;
                    if (!zB) {
                        z = false;
                        break;
                    }
                    z = false;
                    bK = feVar2.k(i);
                    if ((bK < 48 || bK > 57) && ((bK < 97 || bK > 102) && (bK < 65 || bK > 70))) {
                        break;
                    }
                    i = i2;
                    j3 = j2;
                }
                if (i == 0) {
                    throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bK)));
                }
                this.k = feVar2.A();
                String strTrim = pc0Var.c.A(Long.MAX_VALUE).trim();
                if (this.k < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.k + strTrim + "\"");
                }
                if (this.k == 0) {
                    this.l = z;
                    md0.d(pc0Var.a.n, this.j, pc0Var.j());
                    a();
                }
                if (!this.l) {
                    return j2;
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        } else {
            j2 = -1;
        }
        long j5 = super.read(feVar, Math.min(j, this.k));
        if (j5 != j2) {
            this.k -= j5;
            return j5;
        }
        pc0Var.b.i();
        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
        a();
        throw protocolException;
    }
}
