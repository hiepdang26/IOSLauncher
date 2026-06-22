package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class wj1 extends ByteArrayOutputStream {
    public final /* synthetic */ xj1 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wj1(xj1 xj1Var, int i) {
        super(i);
        this.g = xj1Var;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i = ((ByteArrayOutputStream) this).count;
        if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
            i--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i, this.g.h.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
