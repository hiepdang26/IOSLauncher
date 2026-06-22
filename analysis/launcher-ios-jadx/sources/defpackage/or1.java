package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class or1 extends b0 {
    public static final Parcelable.Creator<or1> CREATOR = new d82(15);
    public final String g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;

    public or1(String str, int i, int i2, boolean z, boolean z2) {
        this.g = str;
        this.h = i;
        this.i = i2;
        this.j = z;
        this.k = z2;
    }

    public static or1 a() {
        return new or1(12451000, 12451000, true, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 2, this.g);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.h);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.i);
        os.G(parcel, 5, 4);
        parcel.writeInt(this.j ? 1 : 0);
        os.G(parcel, 6, 4);
        parcel.writeInt(this.k ? 1 : 0);
        os.F(iE, parcel);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public or1(int i, int i2, boolean z, boolean z2) {
        String str;
        if (z) {
            str = "0";
        } else {
            str = "1";
        }
        StringBuilder sbN = uo.n("afma-sdk-a-v", i, ".", i2, ".");
        sbN.append(str);
        this(sbN.toString(), i, i2, z, z2);
    }
}
