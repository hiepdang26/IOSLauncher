package com.google.android.gms.internal.ads;

import androidx.profileinstaller.ProfileVerifier;
import defpackage.uo;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzht implements zzkb {
    private final zzyk zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final HashMap zzg;
    private long zzh;

    public zzht() {
        zzyk zzykVar = new zzyk(true, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
        zzk(2500, 0, "bufferForPlaybackMs", "0");
        zzk(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzk(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzk(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzk(50000, 50000, "maxBufferMs", "minBufferMs");
        zzk(0, 0, "backBufferDurationMs", "0");
        this.zza = zzykVar;
        this.zzb = zzet.zzr(50000L);
        this.zzc = zzet.zzr(50000L);
        this.zzd = zzet.zzr(2500L);
        this.zze = zzet.zzr(5000L);
        this.zzf = zzet.zzr(0L);
        this.zzg = new HashMap();
        this.zzh = -1L;
    }

    private static void zzk(int i, int i2, String str, String str2) {
        zzdi.zze(i >= i2, uo.i(str, " cannot be less than ", str2));
    }

    private final void zzl(zznz zznzVar) {
        if (this.zzg.remove(zznzVar) != null) {
            zzm();
        }
    }

    private final void zzm() {
        if (this.zzg.isEmpty()) {
            this.zza.zze();
        } else {
            this.zza.zzf(zza());
        }
    }

    public final int zza() {
        Iterator it = this.zzg.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((zzhs) it.next()).zzb;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final long zzb(zznz zznzVar) {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzc(zznz zznzVar) {
        long id = Thread.currentThread().getId();
        long j = this.zzh;
        boolean z = true;
        if (j != -1 && j != id) {
            z = false;
        }
        zzdi.zzg(z, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzh = id;
        if (!this.zzg.containsKey(zznzVar)) {
            this.zzg.put(zznzVar, new zzhs(null));
        }
        zzhs zzhsVar = (zzhs) this.zzg.get(zznzVar);
        zzhsVar.getClass();
        zzhsVar.zzb = 13107200;
        zzhsVar.zza = false;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzd(zznz zznzVar) {
        zzl(zznzVar);
        if (this.zzg.isEmpty()) {
            this.zzh = -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zze(zznz zznzVar) {
        zzl(zznzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final void zzf(zznz zznzVar, zzcc zzccVar, zzui zzuiVar, zzle[] zzleVarArr, zzwi zzwiVar, zzxv[] zzxvVarArr) {
        zzhs zzhsVar = (zzhs) this.zzg.get(zznzVar);
        zzhsVar.getClass();
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzleVarArr.length;
            if (i >= 2) {
                zzhsVar.zzb = Math.max(13107200, i2);
                zzm();
                return;
            } else {
                if (zzxvVarArr[i] != null) {
                    i2 += zzleVarArr[i].zzb() != 1 ? 131072000 : 13107200;
                }
                i++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzg(zznz zznzVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzh(zzka zzkaVar) {
        zzhs zzhsVar = (zzhs) this.zzg.get(zzkaVar.zza);
        zzhsVar.getClass();
        int iZza = this.zza.zza();
        int iZza2 = zza();
        long jMin = this.zzb;
        float f = zzkaVar.zzc;
        if (f > 1.0f) {
            jMin = Math.min(zzet.zzp(jMin, f), this.zzc);
        }
        long j = zzkaVar.zzb;
        if (j < Math.max(jMin, 500000L)) {
            boolean z = iZza < iZza2;
            zzhsVar.zza = z;
            if (!z && j < 500000) {
                zzea.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.zzc || iZza >= iZza2) {
            zzhsVar.zza = false;
        }
        return zzhsVar.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final boolean zzi(zzka zzkaVar) {
        boolean z = zzkaVar.zzd;
        long jZzq = zzet.zzq(zzkaVar.zzb, zzkaVar.zzc);
        long jMin = z ? this.zze : this.zzd;
        long j = zzkaVar.zze;
        if (j != -9223372036854775807L) {
            jMin = Math.min(j / 2, jMin);
        }
        return jMin <= 0 || jZzq >= jMin || this.zza.zza() >= zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkb
    public final zzyk zzj() {
        return this.zza;
    }
}
