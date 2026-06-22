package defpackage;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class w32 extends Binder implements IInterface {
    public final /* synthetic */ int g = 0;
    public Object h;

    public /* synthetic */ w32() {
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.g;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z;
        switch (this.g) {
            case 0:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (!super.onTransact(i, parcel, parcel2, i2)) {
                }
                if (i == 1) {
                    Parcelable.Creator<jp0> creator = jp0.CREATOR;
                    int i3 = j62.a;
                    jp0 jp0VarCreateFromParcel = parcel.readInt() == 0 ? null : creator.createFromParcel(parcel);
                    iw1 iw1Var = (iw1) this.h;
                    iw1Var.getClass();
                    Status status = jp0VarCreateFromParcel.g;
                    z = status.g <= 0;
                    qm1 qm1Var = (qm1) iw1Var.g;
                    if (z) {
                        qm1Var.a(new ip0());
                    } else {
                        PendingIntent pendingIntent = status.i;
                        od2 od2Var = qm1Var.a;
                        if (pendingIntent != null) {
                            od2Var.g(new cb1(status));
                        } else {
                            od2Var.g(new v5(status));
                        }
                    }
                    this.h = null;
                }
                break;
            default:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (!super.onTransact(i, parcel, parcel2, i2)) {
                }
                if (i == 1) {
                    Parcelable.Creator<Status> creator2 = Status.CREATOR;
                    int i4 = h62.a;
                    Status statusCreateFromParcel = parcel.readInt() == 0 ? null : creator2.createFromParcel(parcel);
                    f62 f62VarCreateFromParcel = parcel.readInt() == 0 ? null : f62.CREATOR.createFromParcel(parcel);
                    f7 f7Var = f62VarCreateFromParcel != null ? new f7(f62VarCreateFromParcel.g, f62VarCreateFromParcel.h) : null;
                    z = statusCreateFromParcel.g <= 0;
                    qm1 qm1Var2 = (qm1) this.h;
                    if (!z) {
                        qm1Var2.a.g(new v5(statusCreateFromParcel));
                    } else {
                        qm1Var2.a(f7Var);
                    }
                }
                break;
        }
        return false;
    }

    public w32(qm1 qm1Var) {
        this.h = qm1Var;
        attachInterface(this, "com.google.android.gms.appset.internal.IAppSetIdCallback");
    }
}
