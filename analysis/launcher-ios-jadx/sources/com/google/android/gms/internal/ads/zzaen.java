package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaen extends zzabu {
    public zzaen(final zzacv zzacvVar, int i, long j, long j2) {
        long j3;
        Objects.requireNonNull(zzacvVar);
        zzabr zzabrVar = new zzabr() { // from class: com.google.android.gms.internal.ads.zzaek
            @Override // com.google.android.gms.internal.ads.zzabr
            public final long zza(long j4) {
                return zzacvVar.zzb(j4);
            }
        };
        zzaem zzaemVar = new zzaem(zzacvVar, i, null);
        long jZza = zzacvVar.zza();
        long j4 = zzacvVar.zzj;
        int i2 = zzacvVar.zzd;
        if (i2 > 0) {
            j3 = ((((long) i2) + ((long) zzacvVar.zzc)) / 2) + 1;
        } else {
            int i3 = zzacvVar.zza;
            long j5 = 4096;
            if (i3 == zzacvVar.zzb && i3 > 0) {
                j5 = i3;
            }
            j3 = 64 + (((j5 * ((long) zzacvVar.zzg)) * ((long) zzacvVar.zzh)) / 8);
        }
        super(zzabrVar, zzaemVar, jZza, 0L, j4, j, j2, j3, Math.max(6, zzacvVar.zzc));
    }
}
