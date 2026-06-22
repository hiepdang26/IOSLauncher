package defpackage;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class rc2 extends b0 {
    public static final Parcelable.Creator<rc2> CREATOR = new d82(14);
    public final String g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final int l;
    public final rc2[] m;
    public final boolean n;
    public final boolean o;
    public boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public rc2(android.content.Context r18, defpackage.u2[] r19) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rc2.<init>(android.content.Context, u2[]):void");
    }

    public static rc2 a() {
        return new rc2("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false);
    }

    public static rc2 b() {
        return new rc2("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.z(parcel, 2, this.g);
        os.G(parcel, 3, 4);
        parcel.writeInt(this.h);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.i);
        os.G(parcel, 5, 4);
        parcel.writeInt(this.j ? 1 : 0);
        os.G(parcel, 6, 4);
        parcel.writeInt(this.k);
        os.G(parcel, 7, 4);
        parcel.writeInt(this.l);
        os.C(parcel, 8, this.m, i);
        os.G(parcel, 9, 4);
        parcel.writeInt(this.n ? 1 : 0);
        os.G(parcel, 10, 4);
        parcel.writeInt(this.o ? 1 : 0);
        boolean z = this.p;
        os.G(parcel, 11, 4);
        parcel.writeInt(z ? 1 : 0);
        os.G(parcel, 12, 4);
        parcel.writeInt(this.q ? 1 : 0);
        os.G(parcel, 13, 4);
        parcel.writeInt(this.r ? 1 : 0);
        os.G(parcel, 14, 4);
        parcel.writeInt(this.s ? 1 : 0);
        os.G(parcel, 15, 4);
        parcel.writeInt(this.t ? 1 : 0);
        os.G(parcel, 16, 4);
        parcel.writeInt(this.u ? 1 : 0);
        os.F(iE, parcel);
    }

    public rc2(String str, int i, int i2, boolean z, int i3, int i4, rc2[] rc2VarArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.g = str;
        this.h = i;
        this.i = i2;
        this.j = z;
        this.k = i3;
        this.l = i4;
        this.m = rc2VarArr;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = z6;
        this.s = z7;
        this.t = z8;
        this.u = z9;
    }

    public rc2() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public rc2(Context context, u2 u2Var) {
        this(context, new u2[]{u2Var});
    }
}
