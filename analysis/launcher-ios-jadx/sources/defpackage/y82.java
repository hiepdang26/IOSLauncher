package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class y82 extends zzaxm implements a92 {
    public y82(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // defpackage.a92
    public final void j(boolean z) {
        Parcel parcelZza = zza();
        int i = zzaxo.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdc(5, parcelZza);
    }

    @Override // defpackage.a92
    public final void zze() {
        zzdc(4, zza());
    }

    @Override // defpackage.a92
    public final void zzg() {
        zzdc(3, zza());
    }

    @Override // defpackage.a92
    public final void zzh() {
        zzdc(2, zza());
    }

    @Override // defpackage.a92
    public final void zzi() {
        zzdc(1, zza());
    }
}
