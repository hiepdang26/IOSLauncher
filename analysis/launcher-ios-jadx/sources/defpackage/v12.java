package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class v12 extends b0 {
    public static final Parcelable.Creator<v12> CREATOR = new zb1(13);
    public final int g;
    public final IBinder h;
    public final vl i;
    public final boolean j;
    public final boolean k;

    public v12(int i, IBinder iBinder, vl vlVar, boolean z, boolean z2) {
        this.g = i;
        this.h = iBinder;
        this.i = vlVar;
        this.j = z;
        this.k = z2;
    }

    public final boolean equals(Object obj) {
        Object nd2Var;
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof v12)) {
                return false;
            }
            v12 v12Var = (v12) obj;
            if (!this.i.equals(v12Var.i)) {
                return false;
            }
            Object nd2Var2 = null;
            IBinder iBinder = this.h;
            if (iBinder == null) {
                nd2Var = null;
            } else {
                int i = c1.h;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                nd2Var = iInterfaceQueryLocalInterface instanceof sd0 ? (sd0) iInterfaceQueryLocalInterface : new nd2(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = v12Var.h;
            if (iBinder2 != null) {
                int i2 = c1.h;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                nd2Var2 = iInterfaceQueryLocalInterface2 instanceof sd0 ? (sd0) iInterfaceQueryLocalInterface2 : new nd2(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (!bf1.c(nd2Var, nd2Var2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g);
        os.x(parcel, 2, this.h);
        os.y(parcel, 3, this.i, i);
        os.G(parcel, 4, 4);
        parcel.writeInt(this.j ? 1 : 0);
        os.G(parcel, 5, 4);
        parcel.writeInt(this.k ? 1 : 0);
        os.F(iE, parcel);
    }
}
