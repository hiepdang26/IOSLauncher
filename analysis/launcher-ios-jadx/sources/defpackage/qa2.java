package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class qa2 extends zzaxn implements m82 {
    public qa2() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static m82 f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return iInterfaceQueryLocalInterface instanceof m82 ? (m82) iInterfaceQueryLocalInterface : new k82(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzaxo.zzc(parcel);
            parcel2.writeNoException();
        } else {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            int i3 = zzaxo.zza;
            parcel2.writeInt(1);
        }
        return true;
    }

    @Override // defpackage.m82
    public final boolean zzf() {
        return true;
    }

    @Override // defpackage.m82
    public final void b(xc2 xc2Var) {
    }
}
