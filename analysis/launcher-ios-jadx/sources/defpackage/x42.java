package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;

/* JADX INFO: loaded from: classes.dex */
public final class x42 extends zzaxm implements a52 {
    public x42(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // defpackage.a52
    public final void zzc() {
        zzdc(6, zza());
    }

    @Override // defpackage.a52
    public final void zzd() {
        zzdc(1, zza());
    }

    @Override // defpackage.a52
    public final void zze(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdc(2, parcelZza);
    }

    @Override // defpackage.a52
    public final void zzf(j92 j92Var) {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, j92Var);
        zzdc(8, parcelZza);
    }

    @Override // defpackage.a52
    public final void zzg() {
        zzdc(7, zza());
    }

    @Override // defpackage.a52
    public final void zzh() {
        zzdc(3, zza());
    }

    @Override // defpackage.a52
    public final void zzi() {
        zzdc(4, zza());
    }

    @Override // defpackage.a52
    public final void zzj() {
        zzdc(5, zza());
    }

    @Override // defpackage.a52
    public final void zzk() {
        zzdc(9, zza());
    }
}
