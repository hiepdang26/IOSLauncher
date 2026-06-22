package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxn;

/* JADX INFO: loaded from: classes.dex */
public final class v92 extends zzaxn implements s72 {
    public final String g;
    public final String h;

    public v92(String str, String str2) {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        this.g = str;
        this.h = str2;
    }

    public static s72 f(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return iInterfaceQueryLocalInterface instanceof s72 ? (s72) iInterfaceQueryLocalInterface : new r72(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    @Override // com.google.android.gms.internal.ads.zzaxn
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel2.writeNoException();
            parcel2.writeString(this.g);
        } else {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeString(this.h);
        }
        return true;
    }

    @Override // defpackage.s72
    public final String zze() {
        return this.g;
    }

    @Override // defpackage.s72
    public final String zzf() {
        return this.h;
    }
}
