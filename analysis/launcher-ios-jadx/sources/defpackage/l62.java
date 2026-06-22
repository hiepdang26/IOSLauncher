package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class l62 extends b0 {
    public static final Parcelable.Creator<l62> CREATOR = new zb1(29);
    public final String g;
    public final String h;

    public l62(String str, String str2) {
        this.g = str;
        this.h = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, this.g);
        os.z(parcel, 2, this.h);
        os.F(iE, parcel);
    }
}
