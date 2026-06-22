package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class a41 extends b0 {
    public static final Parcelable.Creator<a41> CREATOR = new d82(7);
    public final boolean g;
    public final u62 h;
    public final IBinder i;

    public a41(boolean z, IBinder iBinder, IBinder iBinder2) {
        this.g = z;
        this.h = iBinder != null ? r62.zzd(iBinder) : null;
        this.i = iBinder2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.G(parcel, 1, 4);
        parcel.writeInt(this.g ? 1 : 0);
        u62 u62Var = this.h;
        os.x(parcel, 2, u62Var == null ? null : u62Var.asBinder());
        os.x(parcel, 3, this.i);
        os.F(iE, parcel);
    }
}
