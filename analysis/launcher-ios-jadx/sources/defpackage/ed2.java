package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ed2 extends b0 {
    public static final Parcelable.Creator<ed2> CREATOR = new d82(17);
    public final String g;
    public long h;
    public j92 i;
    public final Bundle j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public ed2(String str, long j, j92 j92Var, Bundle bundle, String str2, String str3, String str4, String str5) {
        this.g = str;
        this.h = j;
        this.i = j92Var;
        this.j = bundle;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.n = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 1, this.g);
        long j = this.h;
        os.G(parcel, 2, 8);
        parcel.writeLong(j);
        os.y(parcel, 3, this.i, i);
        os.v(parcel, 4, this.j);
        os.z(parcel, 5, this.k);
        os.z(parcel, 6, this.l);
        os.z(parcel, 7, this.m);
        os.z(parcel, 8, this.n);
        os.F(iE, parcel);
    }
}
