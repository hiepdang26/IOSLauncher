package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class w92 extends b0 {
    public static final Parcelable.Creator<w92> CREATOR = new d82(2);
    public final int g;
    public final int h;
    public final String i;

    public w92(int i, int i2, String str) {
        this.g = i;
        this.h = i2;
        this.i = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        os.z(parcel, 3, this.i);
        os.F(iE, parcel);
    }
}
