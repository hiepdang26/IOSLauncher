package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public abstract class r62 extends zzaxn implements u62 {
    public static u62 zzd(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        return iInterfaceQueryLocalInterface instanceof u62 ? (u62) iInterfaceQueryLocalInterface : new e62(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        String string = parcel.readString();
        String string2 = parcel.readString();
        zzaxo.zzc(parcel);
        zzc(string, string2);
        parcel2.writeNoException();
        return true;
    }
}
