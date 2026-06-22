package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class td0 implements vd0 {
    public IBinder g;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.g;
    }

    public final boolean f(kr krVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            parcelObtain.writeStrongBinder(krVar);
            if (!this.g.transact(3, parcelObtain, parcelObtain2, 0)) {
                int i = ud0.g;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final int p(kr krVar, String str, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            parcelObtain.writeStrongBinder(krVar);
            parcelObtain.writeString(str);
            parcelObtain.writeInt(1);
            bundle.writeToParcel(parcelObtain, 0);
            if (!this.g.transact(8, parcelObtain, parcelObtain2, 0)) {
                int i = ud0.g;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    public final boolean q(kr krVar, Uri uri) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            parcelObtain.writeStrongBinder(krVar);
            if (uri != null) {
                parcelObtain.writeInt(1);
                uri.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            if (!this.g.transact(7, parcelObtain, parcelObtain2, 0)) {
                int i = ud0.g;
            }
            parcelObtain2.readException();
            boolean z = parcelObtain2.readInt() != 0;
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return z;
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }

    public final boolean r() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
            parcelObtain.writeLong(0L);
            if (!this.g.transact(2, parcelObtain, parcelObtain2, 0)) {
                int i = ud0.g;
            }
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
