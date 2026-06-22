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
final class zzfoo implements ab, bb {
    protected final zzfpo zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;

    public zzfoo(Context context, String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzfpo zzfpoVar = new zzfpo(context, handlerThread.getLooper(), this, this, 9200000);
        this.zza = zzfpoVar;
        this.zzd = new LinkedBlockingQueue();
        zzfpoVar.checkAvailabilityAndConnect();
    }

    public static zzasj zza() {
        zzaro zzaroVarZza = zzasj.zza();
        zzaroVarZza.zzD(32768L);
        return (zzasj) zzaroVarZza.zzbr();
    }

    @Override // defpackage.ab
    public final void onConnected(Bundle bundle) {
        zzfpt zzfptVarZzd = zzd();
        if (zzfptVarZzd != null) {
            try {
                try {
                    this.zzd.put(zzfptVarZzd.zze(new zzfpp(this.zzb, this.zzc)).zza());
                } catch (Throwable unused) {
                    this.zzd.put(zza());
                }
            } catch (InterruptedException unused2) {
            } catch (Throwable th) {
                zzc();
                this.zze.quit();
                throw th;
            }
            zzc();
            this.zze.quit();
        }
    }

    @Override // defpackage.bb
    public final void onConnectionFailed(vl vlVar) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // defpackage.ab
    public final void onConnectionSuspended(int i) {
        try {
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzasj zzb(int i) {
        zzasj zzasjVar;
        try {
            zzasjVar = (zzasj) this.zzd.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zzasjVar = null;
        }
        return zzasjVar == null ? zza() : zzasjVar;
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
