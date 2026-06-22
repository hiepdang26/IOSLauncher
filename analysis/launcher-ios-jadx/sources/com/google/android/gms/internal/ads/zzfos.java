package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class zzfos {
    private final Context zza;
    private final Looper zzb;

    public zzfos(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfpg zzfpgVarZza = zzfpi.zza();
        zzfpgVarZza.zza(this.zza.getPackageName());
        zzfpgVarZza.zzc(2);
        zzfpd zzfpdVarZza = zzfpe.zza();
        zzfpdVarZza.zza(str);
        zzfpdVarZza.zzb(2);
        zzfpgVarZza.zzb(zzfpdVarZza);
        new zzfot(this.zza, this.zzb, (zzfpi) zzfpgVarZza.zzbr()).zza();
    }
}
