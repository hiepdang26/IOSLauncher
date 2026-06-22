package defpackage;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcu;

/* JADX INFO: loaded from: classes.dex */
public final class kr extends Binder implements IInterface {
    public final Handler g;
    public final /* synthetic */ zzbcu h;

    public kr(zzbcu zzbcuVar) {
        this.h = zzbcuVar;
        attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        this.g = new Handler(Looper.getMainLooper());
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundleExtraCallbackWithResult;
        if (i == 1598968902) {
            parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
            return true;
        }
        Handler handler = this.g;
        zzbcu zzbcuVar = this.h;
        switch (i) {
            case 2:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                int i3 = parcel.readInt();
                bundleExtraCallbackWithResult = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                if (zzbcuVar != null) {
                    handler.post(new s1(this, i3, bundleExtraCallbackWithResult, 4));
                }
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                String string = parcel.readString();
                bundleExtraCallbackWithResult = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                if (zzbcuVar != null) {
                    handler.post(new ir(this, string, bundleExtraCallbackWithResult, 0));
                }
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                bundleExtraCallbackWithResult = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                if (zzbcuVar != null) {
                    handler.post(new w1(this, bundleExtraCallbackWithResult, 9, false));
                }
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                String string2 = parcel.readString();
                bundleExtraCallbackWithResult = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                if (zzbcuVar != null) {
                    handler.post(new ir(this, string2, bundleExtraCallbackWithResult, 1));
                }
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                int i4 = parcel.readInt();
                Uri uri = parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null;
                boolean z = parcel.readInt() != 0;
                bundleExtraCallbackWithResult = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                if (zzbcuVar != null) {
                    handler.post(new jr(this, i4, uri, z, bundleExtraCallbackWithResult));
                }
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                bundleExtraCallbackWithResult = zzbcuVar != null ? zzbcuVar.extraCallbackWithResult(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null) : null;
                parcel2.writeNoException();
                if (bundleExtraCallbackWithResult == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                bundleExtraCallbackWithResult.writeToParcel(parcel2, 1);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
