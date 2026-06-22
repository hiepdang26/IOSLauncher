package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zzaah {
    private final zzaag zza;
    private final zzaal zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzj = 1.0f;

    public zzaah(Context context, zzaag zzaagVar, long j) {
        this.zza = zzaagVar;
        this.zzb = new zzaal(context);
    }

    private final void zzp(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        if (r6 > 100000) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
    
        if (r23 >= r27) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        if (r20.zzc != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(long r21, long r23, long r25, long r27, boolean r29, com.google.android.gms.internal.ads.zzaaf r30) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaah.zza(long, long, long, long, boolean, com.google.android.gms.internal.ads.zzaaf):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzh = -9223372036854775807L;
    }

    public final void zzd() {
        zzp(0);
    }

    public final void zze(boolean z) {
        this.zzd = z ? 1 : 0;
    }

    public final void zzf() {
        zzp(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzet.zzr(SystemClock.elapsedRealtime());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzp(1);
        this.zzh = -9223372036854775807L;
    }

    public final void zzj(int i) {
        this.zzb.zzj(i);
    }

    public final void zzk(float f) {
        this.zzb.zzc(f);
    }

    public final void zzl(Surface surface) {
        this.zzb.zzi(surface);
        zzp(1);
    }

    public final void zzm(float f) {
        this.zzj = f;
        this.zzb.zze(f);
    }

    public final boolean zzn(boolean z) {
        boolean z2 = true;
        if (z && this.zzd == 3) {
            this.zzh = -9223372036854775807L;
        } else {
            if (this.zzh == -9223372036854775807L) {
                return false;
            }
            if (SystemClock.elapsedRealtime() >= this.zzh) {
                z2 = false;
                this.zzh = -9223372036854775807L;
            }
        }
        return z2;
    }

    public final boolean zzo() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzet.zzr(SystemClock.elapsedRealtime());
        return i != 3;
    }
}
