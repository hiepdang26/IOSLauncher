package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class p2 extends b0 {
    public static final Parcelable.Creator<p2> CREATOR = new zb1(27);
    public final boolean g;
    public final IBinder h;

    public p2(boolean z, IBinder iBinder) {
        this.g = z;
        this.h = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g ? 1 : 0);
        os.x(parcel, 2, this.h);
        os.F(iE, parcel);
    }
}
