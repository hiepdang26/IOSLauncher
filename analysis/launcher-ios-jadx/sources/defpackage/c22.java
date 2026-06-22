package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class c22 extends b0 {
    public static final Parcelable.Creator<c22> CREATOR = new zb1(18);
    public final String g;
    public final String h;
    public final String i;

    public c22(String str, String str2, String str3) {
        this.g = str;
        this.h = str2;
        this.i = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, this.g);
        os.z(parcel, 2, this.h);
        os.z(parcel, 3, this.i);
        os.F(iE, parcel);
    }
}
