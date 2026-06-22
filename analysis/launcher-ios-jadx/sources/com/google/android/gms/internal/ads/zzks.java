package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class zzks implements zzus, zzre {
    final /* synthetic */ zzkw zza;
    private final zzku zzb;

    public zzks(zzkw zzkwVar, zzku zzkuVar) {
        this.zza = zzkwVar;
        this.zzb = zzkuVar;
    }

    private final Pair zzf(int i, zzui zzuiVar) {
        zzui zzuiVarZza;
        zzui zzuiVar2 = null;
        if (zzuiVar != null) {
            zzku zzkuVar = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzkuVar.zzc.size()) {
                    zzuiVarZza = null;
                    break;
                }
                if (((zzui) zzkuVar.zzc.get(i2)).zzd == zzuiVar.zzd) {
                    zzuiVarZza = zzuiVar.zza(Pair.create(zzkuVar.zzb, zzuiVar.zza));
                    break;
                }
                i2++;
            }
            if (zzuiVarZza == null) {
                return null;
            }
            zzuiVar2 = zzuiVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzuiVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzae(int i, zzui zzuiVar, final zzue zzueVar) {
        final Pair pairZzf = zzf(0, zzuiVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkq
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzui) pair.second, zzueVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzaf(int i, zzui zzuiVar, final zztz zztzVar, final zzue zzueVar) {
        final Pair pairZzf = zzf(0, zzuiVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzko
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zzui) pair.second, zztzVar, zzueVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzag(int i, zzui zzuiVar, final zztz zztzVar, final zzue zzueVar) {
        final Pair pairZzf = zzf(0, zzuiVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkr
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zzui) pair.second, zztzVar, zzueVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzah(int i, zzui zzuiVar, final zztz zztzVar, final zzue zzueVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zzuiVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkn
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzui) pair.second, zztzVar, zzueVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzai(int i, zzui zzuiVar, final zztz zztzVar, final zzue zzueVar) {
        final Pair pairZzf = zzf(0, zzuiVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkp
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzui) pair.second, zztzVar, zzueVar);
                }
            });
        }
    }
}
