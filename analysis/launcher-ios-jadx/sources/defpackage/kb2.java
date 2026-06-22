package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class kb2 extends b12 implements g22 {
    public final int h;

    public kb2(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.h = Arrays.hashCode(bArr);
    }

    public static byte[] q(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g22)) {
            return false;
        }
        try {
            g22 g22Var = (g22) obj;
            if (((kb2) g22Var).h != this.h) {
                return false;
            }
            return Arrays.equals(r(), (byte[]) gy0.r(new gy0(((kb2) g22Var).r())));
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return this.h;
    }

    @Override // defpackage.b12
    public final boolean p(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            gy0 gy0Var = new gy0(r());
            parcel2.writeNoException();
            i62.c(parcel2, gy0Var);
            return true;
        }
        if (i != 2) {
            return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(this.h);
        return true;
    }

    public abstract byte[] r();
}
