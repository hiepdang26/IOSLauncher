package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import defpackage.ab;
import defpackage.bb;
import defpackage.vl;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzfoq implements ab, bb {
    protected final zzfpo zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzfoh zzf;
    private final long zzg;
    private final int zzh;

    public zzfoq(Context context, int i, int i2, String str, String str2, String str3, zzfoh zzfohVar) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzfohVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zzfpo zzfpoVar = new zzfpo(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfpoVar;
        this.zzd = new LinkedBlockingQueue();
        zzfpoVar.checkAvailabilityAndConnect();
    }

    public static zzfqa zza() {
        return new zzfqa(null, 1);
    }

    private final void zze(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    @Override // defpackage.ab
    public final void onConnected(Bundle bundle) {
        zzfpt zzfptVarZzd = zzd();
        if (zzfptVarZzd != null) {
            try {
                zzfqa zzfqaVarZzf = zzfptVarZzd.zzf(new zzfpy(1, this.zzh, this.zzb, this.zzc));
                zze(5011, this.zzg, null);
                this.zzd.put(zzfqaVarZzf);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        try {
            zze(4012, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
        try {
            zze(4011, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzfqa zzb(int i) {
        zzfqa zzfqaVar;
        try {
            zzfqaVar = (zzfqa) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zze(2009, this.zzg, e);
            zzfqaVar = null;
        }
        zze(3004, this.zzg, null);
        if (zzfqaVar != null) {
            if (zzfqaVar.zzc == 7) {
                zzfoh.zzg(3);
            } else {
                zzfoh.zzg(2);
            }
        }
        return zzfqaVar == null ? zza() : zzfqaVar;
    }

    public final void zzc() {
        zzfpo zzfpoVar = this.zza;
        if (zzfpoVar != null) {
            if (zzfpoVar.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
        }
    }

    public final zzfpt zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
