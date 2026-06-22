package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class jp0 extends b0 {
    public static final Parcelable.Creator<jp0> CREATOR = new zb1(24);
    public final Status g;
    public final kp0 h;

    public jp0(Status status, kp0 kp0Var) {
        this.g = status;
        this.h = kp0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = os.E(20293, parcel);
        os.y(parcel, 1, this.g, i);
        os.y(parcel, 2, this.h, i);
        os.F(iE, parcel);
    }
}
