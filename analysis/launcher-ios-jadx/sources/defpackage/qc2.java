package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class qc2 extends s02 {
    public final he0 q(gy0 gy0Var, String str, int i) {
        Parcel parcelP = p();
        i62.c(parcelP, gy0Var);
        parcelP.writeString(str);
        parcelP.writeInt(i);
        return k31.i(f(2, parcelP));
    }

    public final he0 r(gy0 gy0Var, String str, int i, gy0 gy0Var2) {
        Parcel parcelP = p();
        i62.c(parcelP, gy0Var);
        parcelP.writeString(str);
        parcelP.writeInt(i);
        i62.c(parcelP, gy0Var2);
        return k31.i(f(8, parcelP));
    }

    public final he0 s(gy0 gy0Var, String str, int i) {
        Parcel parcelP = p();
        i62.c(parcelP, gy0Var);
        parcelP.writeString(str);
        parcelP.writeInt(i);
        return k31.i(f(4, parcelP));
    }
}
