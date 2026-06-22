package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class pd2 extends b0 {
    public static final Parcelable.Creator<pd2> CREATOR = new d82(18);
    public final int g;

    public pd2(int i) {
        this.g = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.g);
        os.F(iE, parcel);
    }
}
