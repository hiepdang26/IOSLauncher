package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class xd0 implements yd0 {
    public IBinder g;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.g;
    }

    @Override // defpackage.yd0
    public final void e(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(yd0.c);
            parcelObtain.writeStringArray(strArr);
            this.g.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
