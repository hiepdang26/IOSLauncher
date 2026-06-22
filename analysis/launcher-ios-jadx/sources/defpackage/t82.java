package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class t82 extends zzaxn implements u82 {
    public static u82 zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        return iInterfaceQueryLocalInterface instanceof u82 ? (u82) iInterfaceQueryLocalInterface : new s82(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String strZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 2:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 3:
                List listZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzj);
                return true;
            case 4:
                ed2 ed2VarZzf = zzf();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, ed2VarZzf);
                return true;
            case 5:
                Bundle bundleZze = zze();
                parcel2.writeNoException();
                zzaxo.zze(parcel2, bundleZze);
                return true;
            case 6:
                String strZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(strZzh);
                return true;
            default:
                return false;
        }
    }
}
