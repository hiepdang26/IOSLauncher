package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class au0 {
    public volatile int a = -1;

    public static final void c(au0 au0Var, byte[] bArr, int i) throws tg0 {
        try {
            rj rjVar = new rj(bArr, i);
            au0Var.b(rjVar);
            if (rjVar.e == 0) {
            } else {
                throw new tg0("Protocol message end-group tag did not match expected tag.");
            }
        } catch (tg0 e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] d(au0 au0Var) {
        int iA = au0Var.a();
        au0Var.a = iA;
        byte[] bArr = new byte[iA];
        try {
            tj tjVar = new tj(bArr, iA);
            au0Var.e(tjVar);
            if (tjVar.g.remaining() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract int a();

    public abstract au0 b(rj rjVar);

    public final Object clone() {
        return (au0) super.clone();
    }

    public abstract void e(tj tjVar);

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            os.p(null, this, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            return "Error printing proto: " + e.getMessage();
        } catch (InvocationTargetException e2) {
            return "Error printing proto: " + e2.getMessage();
        }
    }
}
