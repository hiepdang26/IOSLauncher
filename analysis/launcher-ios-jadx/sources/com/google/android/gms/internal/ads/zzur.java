package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzur {
    public final int zza;
    public final zzui zzb;
    private final CopyOnWriteArrayList zzc;

    private zzur(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzui zzuiVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuiVar;
    }

    public final zzur zza(int i, zzui zzuiVar) {
        return new zzur(this.zzc, 0, zzuiVar);
    }

    public final void zzb(Handler handler, zzus zzusVar) {
        this.zzc.add(new zzuq(handler, zzusVar));
    }

    public final void zzc(final zzue zzueVar) {
        for (zzuq zzuqVar : this.zzc) {
            final zzus zzusVar = zzuqVar.zzb;
            zzet.zzO(zzuqVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzul
                @Override // java.lang.Runnable
                public final void run() {
                    zzusVar.zzae(0, this.zza.zzb, zzueVar);
                }
            });
        }
    }

    public final void zzd(final zztz zztzVar, final zzue zzueVar) {
        for (zzuq zzuqVar : this.zzc) {
            final zzus zzusVar = zzuqVar.zzb;
            zzet.zzO(zzuqVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzup
                @Override // java.lang.Runnable
                public final void run() {
                    zzusVar.zzaf(0, this.zza.zzb, zztzVar, zzueVar);
                }
            });
        }
    }

    public final void zze(final zztz zztzVar, final zzue zzueVar) {
        for (zzuq zzuqVar : this.zzc) {
            final zzus zzusVar = zzuqVar.zzb;
            zzet.zzO(zzuqVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzun
                @Override // java.lang.Runnable
                public final void run() {
                    zzusVar.zzag(0, this.zza.zzb, zztzVar, zzueVar);
                }
            });
        }
    }

    public final void zzf(final zztz zztzVar, final zzue zzueVar, final IOException iOException, final boolean z) {
        for (zzuq zzuqVar : this.zzc) {
            final zzus zzusVar = zzuqVar.zzb;
            zzet.zzO(zzuqVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzuo
                @Override // java.lang.Runnable
                public final void run() {
                    zzusVar.zzah(0, this.zza.zzb, zztzVar, zzueVar, iOException, z);
                }
            });
        }
    }

    public final void zzg(final zztz zztzVar, final zzue zzueVar) {
        for (zzuq zzuqVar : this.zzc) {
            final zzus zzusVar = zzuqVar.zzb;
            zzet.zzO(zzuqVar.zza, new Runnable() { // from class: com.google.android.gms.internal.ads.zzum
                @Override // java.lang.Runnable
                public final void run() {
                    zzusVar.zzai(0, this.zza.zzb, zztzVar, zzueVar);
                }
            });
        }
    }

    public final void zzh(zzus zzusVar) {
        for (zzuq zzuqVar : this.zzc) {
            if (zzuqVar.zzb == zzusVar) {
                this.zzc.remove(zzuqVar);
            }
        }
    }

    public zzur() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
