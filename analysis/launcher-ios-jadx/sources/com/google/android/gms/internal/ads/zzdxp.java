package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.do0;
import defpackage.n42;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzdxp implements zzdyo {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdwq zzb;
    private final zzgcu zzc;
    private final zzffg zzd;
    private final ScheduledExecutorService zze;
    private final zzecd zzf;
    private final zzfkf zzg;
    private final Context zzh;

    public zzdxp(Context context, zzffg zzffgVar, zzdwq zzdwqVar, zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzecd zzecdVar, zzfkf zzfkfVar) {
        this.zzh = context;
        this.zzd = zzffgVar;
        this.zzb = zzdwqVar;
        this.zzc = zzgcuVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzecdVar;
        this.zzg = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final do0 zzb(zzbvb zzbvbVar) {
        Context context = this.zzh;
        do0 do0VarZzc = this.zzb.zzc(zzbvbVar);
        zzfju zzfjuVarZza = zzfjt.zza(context, 11);
        zzfke.zzd(do0VarZzc, zzfjuVarZza);
        do0 do0VarZzn = zzgcj.zzn(do0VarZzc, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxm
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc((zzdyq) obj);
            }
        }, this.zzc);
        if (((Boolean) n42.d.c.zza(zzbbw.zzeT)).booleanValue()) {
            do0VarZzn = zzgcj.zzf(zzgcj.zzo(do0VarZzn, ((Integer) r2.c.zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdxn
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) {
                    return zzgcj.zzg(new zzdwl(5));
                }
            }, zzbzo.zzf);
        }
        zzfke.zza(do0VarZzn, this.zzg, zzfjuVarZza);
        zzgcj.zzr(do0VarZzn, new zzdxo(this), zzbzo.zzf);
        return do0VarZzn;
    }

    public final /* synthetic */ do0 zzc(zzdyq zzdyqVar) {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zzd), zzfew.zza(new InputStreamReader(zzdyqVar.zzb()), zzdyqVar.zza())));
    }
}
