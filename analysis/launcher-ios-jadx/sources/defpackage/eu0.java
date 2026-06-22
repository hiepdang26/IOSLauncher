package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class eu0 extends b0 {
    public static final Parcelable.Creator<eu0> CREATOR = new zb1(11);
    public final int g;
    public final int h;
    public final int i;
    public final long j;
    public final long k;
    public final String l;
    public final String m;
    public final int n;
    public final int o;

    public eu0(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = j;
        this.k = j2;
        this.l = str;
        this.m = str2;
        this.n = i4;
        this.o = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.h);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.i);
        os.G(parcel, 4, 8);
        parcel.writeLong(this.j);
        os.G(parcel, 5, 8);
        parcel.writeLong(this.k);
        os.z(parcel, 6, this.l);
        os.z(parcel, 7, this.m);
        os.G(parcel, 8, 4);
        parcel.writeInt(this.n);
        os.G(parcel, 9, 4);
        parcel.writeInt(this.o);
        os.F(iE, parcel);
    }
}
