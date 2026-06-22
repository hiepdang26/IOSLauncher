package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class f72 extends b0 {
    public static final Parcelable.Creator<f72> CREATOR = new zb1(28);
    public final long g;
    public final long h;
    public final boolean i;
    public final String j;
    public final String k;
    public final String l;
    public final Bundle m;
    public final String n;

    public f72(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.g = j;
        this.h = j2;
        this.i = z;
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = bundle;
        this.n = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 8);
        parcel.writeLong(this.g);
        os.G(parcel, 2, 8);
        parcel.writeLong(this.h);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i ? 1 : 0);
        os.z(parcel, 4, this.j);
        os.z(parcel, 5, this.k);
        os.z(parcel, 6, this.l);
        os.v(parcel, 7, this.m);
        os.z(parcel, 8, this.n);
        os.F(iE, parcel);
    }
}
