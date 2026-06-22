package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class kp0 extends b0 {
    public static final Parcelable.Creator<kp0> CREATOR = new zb1(25);
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;

    public kp0(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
        this.l = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g ? 1 : 0);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h ? 1 : 0);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i ? 1 : 0);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.j ? 1 : 0);
        os.G(parcel, 5, 4);
        parcel.writeInt(this.k ? 1 : 0);
        os.G(parcel, 6, 4);
        parcel.writeInt(this.l ? 1 : 0);
        os.F(iE, parcel);
    }
}
