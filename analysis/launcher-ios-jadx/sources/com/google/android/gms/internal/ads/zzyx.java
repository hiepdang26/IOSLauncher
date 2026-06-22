package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzyx {
    public static final zzyr zza = new zzyr(2, -9223372036854775807L, null);
    public static final zzyr zzb = new zzyr(3, -9223372036854775807L, null);
    private final ExecutorService zzc = zzet.zzE("ExoPlayer:Loader:ProgressiveMediaPeriod");
    private zzys zzd;
    private IOException zze;

    public zzyx(String str) {
    }

    public static zzyr zzb(boolean z, long j) {
        return new zzyr(z ? 1 : 0, j, null);
    }

    public final long zza(zzyt zzytVar, zzyp zzypVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        zzdi.zzb(looperMyLooper);
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzys(this, looperMyLooper, zzytVar, zzypVar, i, jElapsedRealtime).zzc(0L);
        return jElapsedRealtime;
    }

    public final void zzg() {
        zzys zzysVar = this.zzd;
        zzdi.zzb(zzysVar);
        zzysVar.zza(false);
    }

    public final void zzh() {
        this.zze = null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzys zzysVar = this.zzd;
        if (zzysVar != null) {
            zzysVar.zzb(i);
        }
    }

    public final void zzj(zzyu zzyuVar) {
        zzys zzysVar = this.zzd;
        if (zzysVar != null) {
            zzysVar.zza(true);
        }
        this.zzc.execute(new zzyv(zzyuVar));
        this.zzc.shutdown();
    }

    public final boolean zzk() {
        return this.zze != null;
    }

    public final boolean zzl() {
        return this.zzd != null;
    }
}
