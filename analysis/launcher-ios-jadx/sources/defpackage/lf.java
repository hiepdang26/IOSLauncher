package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class lf implements Parcelable {
    public static final Parcelable.Creator<lf> CREATOR = new z1(3);
    public final pu0 g;
    public final pu0 h;
    public final ls i;
    public final pu0 j;
    public final int k;
    public final int l;

    public lf(pu0 pu0Var, pu0 pu0Var2, ls lsVar, pu0 pu0Var3) {
        this.g = pu0Var;
        this.h = pu0Var2;
        this.j = pu0Var3;
        this.i = lsVar;
        if (pu0Var3 != null && pu0Var.g.compareTo(pu0Var3.g) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (pu0Var3 != null && pu0Var3.compareTo(pu0Var2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.l = pu0Var.f(pu0Var2) + 1;
        this.k = (pu0Var2.i - pu0Var.i) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lf)) {
            return false;
        }
        lf lfVar = (lf) obj;
        return this.g.equals(lfVar.g) && this.h.equals(lfVar.h) && Objects.equals(this.j, lfVar.j) && this.i.equals(lfVar.i);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.g, this.h, this.j, this.i});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.g, 0);
        parcel.writeParcelable(this.h, 0);
        parcel.writeParcelable(this.j, 0);
        parcel.writeParcelable(this.i, 0);
    }
}
