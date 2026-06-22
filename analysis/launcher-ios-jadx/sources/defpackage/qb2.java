package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class qb2 extends b0 {
    public static final Parcelable.Creator<qb2> CREATOR = new d82(8);
    public Bundle g;
    public v20[] h;
    public int i;
    public am j;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.v(parcel, 1, this.g);
        os.C(parcel, 2, this.h, i);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i);
        os.y(parcel, 4, this.j, i);
        os.F(iE, parcel);
    }
}
