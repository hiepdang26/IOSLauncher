package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class j92 extends b0 {
    public static final Parcelable.Creator<j92> CREATOR = new d82(3);
    public final int g;
    public final String h;
    public final String i;
    public j92 j;
    public IBinder k;

    public j92(int i, String str, String str2, j92 j92Var, IBinder iBinder) {
        this.g = i;
        this.h = str;
        this.i = str2;
        this.j = j92Var;
        this.k = iBinder;
    }

    public final h2 a() {
        j92 j92Var = this.j;
        return new h2(this.g, this.h, this.i, j92Var != null ? new h2(j92Var.g, j92Var.h, j92Var.i, null) : null);
    }

    public final xo0 b() {
        u82 s82Var;
        j92 j92Var = this.j;
        h2 h2Var = j92Var == null ? null : new h2(j92Var.g, j92Var.h, j92Var.i, null);
        IBinder iBinder = this.k;
        if (iBinder == null) {
            s82Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            s82Var = iInterfaceQueryLocalInterface instanceof u82 ? (u82) iInterfaceQueryLocalInterface : new s82(iBinder);
        }
        return new xo0(this.g, this.h, this.i, h2Var, s82Var != null ? new wb1(s82Var) : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.z(parcel, 2, this.h);
        os.z(parcel, 3, this.i);
        os.y(parcel, 4, this.j, i);
        os.x(parcel, 5, this.k);
        os.F(iE, parcel);
    }
}
