package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class q62 implements v62, IInterface {
    public final IBinder g;

    public q62(IBinder iBinder) {
        this.g = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.g;
    }

    public final Parcel f() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return parcelObtain;
    }

    public final void p(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.g.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
