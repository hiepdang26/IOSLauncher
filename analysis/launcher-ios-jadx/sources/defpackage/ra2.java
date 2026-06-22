package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ra2 extends b0 {
    public static final Parcelable.Creator<ra2> CREATOR = new d82(4);
    public final int g;
    public final int h;

    public ra2(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        os.F(iE, parcel);
    }
}
