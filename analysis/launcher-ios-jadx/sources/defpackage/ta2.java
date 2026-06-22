package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ta2 extends b0 {
    public static final Parcelable.Creator<ta2> CREATOR = new d82(6);
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public ta2(zr1 zr1Var) {
        this(zr1Var.a, zr1Var.b, zr1Var.c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.g ? 1 : 0);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.h ? 1 : 0);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.i ? 1 : 0);
        os.F(iE, parcel);
    }

    public ta2(boolean z, boolean z2, boolean z3) {
        this.g = z;
        this.h = z2;
        this.i = z3;
    }
}
