package defpackage;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class tb2 extends b0 {
    public static final Parcelable.Creator<tb2> CREATOR = new d82(11);
    public final String A;
    public final List B;
    public final int C;
    public final String D;
    public final int E;
    public final long F;
    public final int g;
    public final long h;
    public final Bundle i;
    public final int j;
    public final List k;
    public final boolean l;
    public final int m;
    public final boolean n;
    public final String o;
    public final sa2 p;
    public final Location q;
    public final String r;
    public final Bundle s;
    public final Bundle t;
    public final List u;
    public final String v;
    public final String w;
    public final boolean x;
    public final l62 y;
    public final int z;

    public tb2(int i, long j, Bundle bundle, int i2, List list, boolean z, int i3, boolean z2, String str, sa2 sa2Var, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3, l62 l62Var, int i4, String str5, List list3, int i5, String str6, int i6, long j2) {
        this.g = i;
        this.h = j;
        this.i = bundle == null ? new Bundle() : bundle;
        this.j = i2;
        this.k = list;
        this.l = z;
        this.m = i3;
        this.n = z2;
        this.o = str;
        this.p = sa2Var;
        this.q = location;
        this.r = str2;
        this.s = bundle2 == null ? new Bundle() : bundle2;
        this.t = bundle3;
        this.u = list2;
        this.v = str3;
        this.w = str4;
        this.x = z3;
        this.y = l62Var;
        this.z = i4;
        this.A = str5;
        this.B = list3 == null ? new ArrayList() : list3;
        this.C = i5;
        this.D = str6;
        this.E = i6;
        this.F = j2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof tb2)) {
            return false;
        }
        tb2 tb2Var = (tb2) obj;
        return this.g == tb2Var.g && this.h == tb2Var.h && p02.E(this.i, tb2Var.i) && this.j == tb2Var.j && bf1.c(this.k, tb2Var.k) && this.l == tb2Var.l && this.m == tb2Var.m && this.n == tb2Var.n && bf1.c(this.o, tb2Var.o) && bf1.c(this.p, tb2Var.p) && bf1.c(this.q, tb2Var.q) && bf1.c(this.r, tb2Var.r) && p02.E(this.s, tb2Var.s) && p02.E(this.t, tb2Var.t) && bf1.c(this.u, tb2Var.u) && bf1.c(this.v, tb2Var.v) && bf1.c(this.w, tb2Var.w) && this.x == tb2Var.x && this.z == tb2Var.z && bf1.c(this.A, tb2Var.A) && bf1.c(this.B, tb2Var.B) && this.C == tb2Var.C && bf1.c(this.D, tb2Var.D) && this.E == tb2Var.E && this.F == tb2Var.F;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.g), Long.valueOf(this.h), this.i, Integer.valueOf(this.j), this.k, Boolean.valueOf(this.l), Integer.valueOf(this.m), Boolean.valueOf(this.n), this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, Boolean.valueOf(this.x), Integer.valueOf(this.z), this.A, this.B, Integer.valueOf(this.C), this.D, Integer.valueOf(this.E), Long.valueOf(this.F)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.G(parcel, 2, 8);
        parcel.writeLong(this.h);
        os.v(parcel, 3, this.i);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.j);
        os.B(parcel, 5, this.k);
        os.G(parcel, 6, 4);
        parcel.writeInt(this.l ? 1 : 0);
        os.G(parcel, 7, 4);
        parcel.writeInt(this.m);
        os.G(parcel, 8, 4);
        parcel.writeInt(this.n ? 1 : 0);
        os.z(parcel, 9, this.o);
        os.y(parcel, 10, this.p, i);
        os.y(parcel, 11, this.q, i);
        os.z(parcel, 12, this.r);
        os.v(parcel, 13, this.s);
        os.v(parcel, 14, this.t);
        os.B(parcel, 15, this.u);
        os.z(parcel, 16, this.v);
        os.z(parcel, 17, this.w);
        os.G(parcel, 18, 4);
        parcel.writeInt(this.x ? 1 : 0);
        os.y(parcel, 19, this.y, i);
        os.G(parcel, 20, 4);
        parcel.writeInt(this.z);
        os.z(parcel, 21, this.A);
        os.B(parcel, 22, this.B);
        os.G(parcel, 23, 4);
        parcel.writeInt(this.C);
        os.z(parcel, 24, this.D);
        os.G(parcel, 25, 4);
        parcel.writeInt(this.E);
        os.G(parcel, 26, 8);
        parcel.writeLong(this.F);
        os.F(iE, parcel);
    }
}
