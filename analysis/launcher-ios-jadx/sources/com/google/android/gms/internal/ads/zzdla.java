package com.google.android.gms.internal.ads;

import defpackage.do0;
import defpackage.e9;
import defpackage.n42;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdla implements zzcxk {
    private final zzdjb zza;
    private final zzdjg zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdla(zzdjb zzdjbVar, zzdjg zzdjgVar, Executor executor, Executor executor2) {
        this.zza = zzdjbVar;
        this.zzb = zzdjgVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcej zzcejVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdky
            @Override // java.lang.Runnable
            public final void run() {
                zzcejVar.zzd("onSdkImpression", new e9(0));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        if (this.zzb.zzd()) {
            zzdjb zzdjbVar = this.zza;
            zzeeo zzeeoVarZzu = zzdjbVar.zzu();
            if (zzeeoVarZzu == null && zzdjbVar.zzw() != null && ((Boolean) n42.d.c.zza(zzbbw.zzeH)).booleanValue()) {
                zzdjb zzdjbVar2 = this.zza;
                do0 do0VarZzw = zzdjbVar2.zzw();
                zzbzt zzbztVarZzp = zzdjbVar2.zzp();
                if (do0VarZzw == null || zzbztVarZzp == null) {
                    return;
                }
                zzgcj.zzr(zzgcj.zzl(do0VarZzw, zzbztVarZzp), new zzdkz(this), this.zzd);
                return;
            }
            if (zzeeoVarZzu != null) {
                zzdjb zzdjbVar3 = this.zza;
                zzcej zzcejVarZzr = zzdjbVar3.zzr();
                zzcej zzcejVarZzs = zzdjbVar3.zzs();
                if (zzcejVarZzr == null) {
                    zzcejVarZzr = zzcejVarZzs != null ? zzcejVarZzs : null;
                }
                if (zzcejVarZzr != null) {
                    zzb(zzcejVarZzr);
                }
            }
        }
    }
}
