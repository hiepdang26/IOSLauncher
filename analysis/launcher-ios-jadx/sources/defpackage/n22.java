package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class n22 implements wd0 {
    public final IBinder g;

    public n22(IBinder iBinder) {
        this.g = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.g;
    }

    public final void f(x72 x72Var, i80 i80Var) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(x72Var);
            parcelObtain.writeInt(1);
            d82.a(i80Var, parcelObtain, 0);
            this.g.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
