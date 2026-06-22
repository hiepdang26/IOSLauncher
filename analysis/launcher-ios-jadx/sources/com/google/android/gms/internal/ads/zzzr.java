package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzzr implements zzabc, zzzj {
    final /* synthetic */ zzzt zza;
    private final Context zzb;
    private final int zzc;
    private final ArrayList zzd;
    private zzaf zze;
    private long zzf;
    private boolean zzg;
    private long zzh;
    private boolean zzi;
    private long zzj;
    private zzaba zzk;
    private Executor zzl;

    public zzzr(zzzt zzztVar, Context context) {
        this.zza = zzztVar;
        this.zzb = context;
        this.zzc = true != zzet.zzL(context) ? 5 : 1;
        this.zzd = new ArrayList();
        this.zzh = -9223372036854775807L;
        this.zzk = zzaba.zzb;
        this.zzl = zzzt.zza;
    }

    private final void zzl() {
        if (this.zze == null) {
            return;
        }
        new ArrayList().addAll(this.zzd);
        zzaf zzafVar = this.zze;
        zzafVar.getClass();
        zzdi.zzb(null);
        int i = zzafVar.zzs;
        zzag zzagVar = new zzag(zzzt.zzw(zzafVar.zzy), zzafVar.zzr, i);
        zzagVar.zza(zzafVar.zzv);
        zzagVar.zzb();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zza(zzzt zzztVar) {
        final zzaba zzabaVar = this.zzk;
        this.zzl.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzq
            @Override // java.lang.Runnable
            public final void run() {
                zzabaVar.zza(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zzb(zzzt zzztVar) {
        final zzaba zzabaVar = this.zzk;
        this.zzl.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzp
            @Override // java.lang.Runnable
            public final void run() {
                zzabaVar.zzb(this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zzc(zzzt zzztVar, final zzcp zzcpVar) {
        final zzaba zzabaVar = this.zzk;
        this.zzl.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzo
            @Override // java.lang.Runnable
            public final void run() {
                zzabaVar.zzc(this.zza, zzcpVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final long zzd(long j, boolean z) {
        zzdi.zzf(false);
        long j2 = this.zzj;
        if (j2 != -9223372036854775807L) {
            if (!zzzt.zzv(this.zza, j2)) {
                return -9223372036854775807L;
            }
            zzl();
            this.zzj = -9223372036854775807L;
        }
        zzdi.zzb(null);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zze() {
        this.zzi = false;
        this.zzh = -9223372036854775807L;
        zzzt.zzn(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzf(int i, zzaf zzafVar) {
        zzdi.zzf(false);
        this.zza.zzd.zzk(zzafVar.zzt);
        int i2 = zzet.zza;
        this.zze = zzafVar;
        if (this.zzi) {
            zzdi.zzf(this.zzh != -9223372036854775807L);
            this.zzj = this.zzh;
        } else {
            zzl();
            this.zzi = true;
            this.zzj = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzg(long j, long j2) throws zzabb {
        try {
            this.zza.zzt(j, j2);
        } catch (zzhw e) {
            zzaf zzafVarZzad = this.zze;
            if (zzafVarZzad == null) {
                zzafVarZzad = new zzad().zzad();
            }
            throw new zzabb(e, zzafVarZzad);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzh(zzaba zzabaVar, Executor executor) {
        this.zzk = zzabaVar;
        this.zzl = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzi(long j) {
        this.zzg = this.zzf != j;
        this.zzf = j;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final void zzj(List list) {
        this.zzd.clear();
        this.zzd.addAll(list);
        zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final boolean zzk() {
        return zzet.zzL(this.zzb);
    }
}
