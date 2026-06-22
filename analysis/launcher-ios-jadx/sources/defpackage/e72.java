package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbom;

/* JADX INFO: loaded from: classes.dex */
public abstract class e72 extends zzaxn implements g72 {
    public static g72 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return iInterfaceQueryLocalInterface instanceof g72 ? (g72) iInterfaceQueryLocalInterface : new c72(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            w92 liteSdkVersion = getLiteSdkVersion();
            parcel2.writeNoException();
            zzaxo.zze(parcel2, liteSdkVersion);
        } else {
            if (i != 2) {
                return false;
            }
            zzbom adapterCreator = getAdapterCreator();
            parcel2.writeNoException();
            zzaxo.zzf(parcel2, adapterCreator);
        }
        return true;
    }
}
