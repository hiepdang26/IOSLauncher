package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
final class zzavn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzavp zzb;

    public zzavn(zzavp zzavpVar, int i, boolean z) {
        this.zza = i;
        this.zzb = zzavpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzasj zzasjVarZza;
        int i = this.zza;
        zzavp zzavpVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * zzbbc.zzq.zzf);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzavpVar.zza.getPackageManager().getPackageInfo(zzavpVar.zza.getPackageName(), 0);
            Context context = zzavpVar.zza;
            zzasjVarZza = zzfop.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzasjVarZza = null;
        }
        this.zzb.zzm = zzasjVarZza;
        if (this.zza < 4) {
            if (zzasjVarZza != null && zzasjVarZza.zzaj() && !zzasjVarZza.zzh().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzasjVarZza.zzak() && zzasjVarZza.zzf().zze() && zzasjVarZza.zzf().zza() != -2) {
                return;
            }
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
