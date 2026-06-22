package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class o12 extends b0 {
    public static final Parcelable.Creator<o12> CREATOR = new zb1(10);
    public final int g;
    public final vl h;
    public final v12 i;

    public o12(int i, vl vlVar, v12 v12Var) {
        this.g = i;
        this.h = vlVar;
        this.i = v12Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.y(parcel, 2, this.h, i);
        os.y(parcel, 3, this.i, i);
        os.F(iE, parcel);
    }
}
