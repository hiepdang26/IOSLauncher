package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class sb2 extends b0 {
    public static final Parcelable.Creator<sb2> CREATOR = new d82(9);
    public final boolean g;
    public final boolean h;
    public final String i;
    public final boolean j;
    public final float k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    public sb2(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this.g = z;
        this.h = z2;
        this.i = str;
        this.j = z3;
        this.k = f;
        this.l = i;
        this.m = z4;
        this.n = z5;
        this.o = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 2, 4);
        parcel.writeInt(this.g ? 1 : 0);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.h ? 1 : 0);
        os.z(parcel, 4, this.i);
        os.G(parcel, 5, 4);
        parcel.writeInt(this.j ? 1 : 0);
        os.G(parcel, 6, 4);
        parcel.writeFloat(this.k);
        os.G(parcel, 7, 4);
        parcel.writeInt(this.l);
        os.G(parcel, 8, 4);
        parcel.writeInt(this.m ? 1 : 0);
        os.G(parcel, 9, 4);
        parcel.writeInt(this.n ? 1 : 0);
        os.G(parcel, 10, 4);
        parcel.writeInt(this.o ? 1 : 0);
        os.F(iE, parcel);
    }

    public sb2(boolean z, boolean z2, boolean z3, float f, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f, -1, z4, z5, z6);
    }
}
