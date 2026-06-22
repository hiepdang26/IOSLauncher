package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class d52 extends b0 {
    public static final Parcelable.Creator<d52> CREATOR = new zb1(22);
    public final String g;
    public final String h;
    public final String i;

    public d52(String str, String str2, String str3) {
        this.i = str;
        this.g = str2;
        this.h = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, this.g);
        os.z(parcel, 2, this.h);
        os.z(parcel, 5, this.i);
        os.F(iE, parcel);
    }
}
