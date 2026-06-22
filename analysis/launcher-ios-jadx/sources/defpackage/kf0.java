package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class kf0 implements fi1, AutoCloseable {
    public final b81 g;
    public final Inflater h;
    public int i;
    public boolean j;

    public kf0(b81 b81Var, Inflater inflater) {
        this.g = b81Var;
        this.h = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.j) {
            return;
        }
        this.h.end();
        this.j = true;
        this.g.close();
    }

    @Override // defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
        }
        if (this.j) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            Inflater inflater = this.h;
            boolean zNeedsInput = inflater.needsInput();
            b81 b81Var = this.g;
            z = false;
            if (zNeedsInput) {
                int i = this.i;
                if (i != 0) {
                    int remaining = i - inflater.getRemaining();
                    this.i -= remaining;
                    b81Var.D(remaining);
                }
                if (inflater.getRemaining() != 0) {
                    throw new IllegalStateException("?");
                }
                if (b81Var.a()) {
                    z = true;
                } else {
                    ze1 ze1Var = b81Var.g.g;
                    int i2 = ze1Var.c;
                    int i3 = ze1Var.b;
                    int i4 = i2 - i3;
                    this.i = i4;
                    inflater.setInput(ze1Var.a, i3, i4);
                }
            }
            try {
                ze1 ze1VarI = feVar.I(1);
                int iInflate = inflater.inflate(ze1VarI.a, ze1VarI.c, (int) Math.min(j, 8192 - ze1VarI.c));
                if (iInflate > 0) {
                    ze1VarI.c += iInflate;
                    long j2 = iInflate;
                    feVar.h += j2;
                    return j2;
                }
                if (!inflater.finished() && !inflater.needsDictionary()) {
                }
                int i5 = this.i;
                if (i5 != 0) {
                    int remaining2 = i5 - inflater.getRemaining();
                    this.i -= remaining2;
                    b81Var.D(remaining2);
                }
                if (ze1VarI.b != ze1VarI.c) {
                    return -1L;
                }
                feVar.g = ze1VarI.a();
                bf1.s(ze1VarI);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!z);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return this.g.h.timeout();
    }
}
