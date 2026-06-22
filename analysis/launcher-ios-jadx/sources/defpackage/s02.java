package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class s02 implements IInterface {
    public final /* synthetic */ int g;
    public final IBinder h;
    public final String i;

    public /* synthetic */ s02(IBinder iBinder, String str, int i) {
        this.g = i;
        this.h = iBinder;
        this.i = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.g) {
        }
        return this.h;
    }

    public Parcel f(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.h.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    public Parcel p() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.i);
        return parcelObtain;
    }
}
