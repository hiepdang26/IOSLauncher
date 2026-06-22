package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class r02 extends b0 {
    public static final Parcelable.Creator<r02> CREATOR = new zb1(7);
    public final int g;
    public final int h;
    public final Intent i;

    public r02(int i, int i2, Intent intent) {
        this.g = i;
        this.h = i2;
        this.i = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        os.y(parcel, 3, this.i, i);
        os.F(iE, parcel);
    }
}
