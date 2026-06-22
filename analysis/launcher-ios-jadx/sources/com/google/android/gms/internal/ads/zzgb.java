package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgb implements zzfr {
    private zzgu zzb;
    private String zzc;
    private boolean zzf;
    private final zzgo zza = new zzgo();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzgb zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzgb zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzgb zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzgb zze(zzgu zzguVar) {
        this.zzb = zzguVar;
        return this;
    }

    public final zzgb zzf(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfr
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgg zza() {
        zzgg zzggVar = new zzgg(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, null, false, null);
        zzgu zzguVar = this.zzb;
        if (zzguVar != null) {
            zzggVar.zzf(zzguVar);
        }
        return zzggVar;
    }
}
