package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f62 extends b0 {
    public static final Parcelable.Creator<f62> CREATOR = new d82(0);
    public final String g;
    public final int h;

    public f62(String str, int i) {
        this.g = str;
        this.h = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        os.F(iE, parcel);
    }
}
