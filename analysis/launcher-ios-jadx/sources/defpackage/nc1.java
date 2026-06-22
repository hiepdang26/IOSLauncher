package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class nc1 extends b0 {
    public static final Parcelable.Creator<nc1> CREATOR = new zb1(15);
    public final int g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;

    public nc1(int i, int i2, int i3, boolean z, boolean z2) {
        this.g = i;
        this.h = z;
        this.i = z2;
        this.j = i2;
        this.k = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h ? 1 : 0);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i ? 1 : 0);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.j);
        os.G(parcel, 5, 4);
        parcel.writeInt(this.k);
        os.F(iE, parcel);
    }
}
