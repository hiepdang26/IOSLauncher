package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class am extends b0 {
    public static final Parcelable.Creator<am> CREATOR = new d82(10);
    public final nc1 g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int[] l;

    public am(nc1 nc1Var, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.g = nc1Var;
        this.h = z;
        this.i = z2;
        this.j = iArr;
        this.k = i;
        this.l = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.y(parcel, 1, this.g, i);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h ? 1 : 0);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i ? 1 : 0);
        int[] iArr = this.j;
        if (iArr != null) {
            int iE2 = os.E(4, parcel);
            parcel.writeIntArray(iArr);
            os.F(iE2, parcel);
        }
        os.G(parcel, 5, 4);
        parcel.writeInt(this.k);
        int[] iArr2 = this.l;
        if (iArr2 != null) {
            int iE3 = os.E(6, parcel);
            parcel.writeIntArray(iArr2);
            os.F(iE3, parcel);
        }
        os.F(iE, parcel);
    }
}
