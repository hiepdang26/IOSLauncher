package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class m60 implements Parcelable {
    public static final Parcelable.Creator<m60> CREATOR = new z1(10);
    public final String g;
    public final String h;
    public final boolean i;
    public final int j;
    public final int k;
    public final String l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final Bundle p;
    public final boolean q;
    public final int r;
    public Bundle s;

    public m60(w50 w50Var) {
        this.g = w50Var.getClass().getName();
        this.h = w50Var.l;
        this.i = w50Var.t;
        this.j = w50Var.C;
        this.k = w50Var.D;
        this.l = w50Var.E;
        this.m = w50Var.H;
        this.n = w50Var.s;
        this.o = w50Var.G;
        this.p = w50Var.m;
        this.q = w50Var.F;
        this.r = w50Var.S.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.g);
        sb.append(" (");
        sb.append(this.h);
        sb.append(")}:");
        if (this.i) {
            sb.append(" fromLayout");
        }
        int i = this.k;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.l;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.m) {
            sb.append(" retainInstance");
        }
        if (this.n) {
            sb.append(" removing");
        }
        if (this.o) {
            sb.append(" detached");
        }
        if (this.q) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeString(this.l);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeInt(this.o ? 1 : 0);
        parcel.writeBundle(this.p);
        parcel.writeInt(this.q ? 1 : 0);
        parcel.writeBundle(this.s);
        parcel.writeInt(this.r);
    }

    public m60(Parcel parcel) {
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readString();
        this.m = parcel.readInt() != 0;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readInt() != 0;
        this.p = parcel.readBundle();
        this.q = parcel.readInt() != 0;
        this.s = parcel.readBundle();
        this.r = parcel.readInt();
    }
}
