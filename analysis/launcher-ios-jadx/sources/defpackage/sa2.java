package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class sa2 extends b0 {
    public static final Parcelable.Creator<sa2> CREATOR = new d82(5);
    public final String g;

    public sa2(String str) {
        this.g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 15, this.g);
        os.F(iE, parcel);
    }
}
