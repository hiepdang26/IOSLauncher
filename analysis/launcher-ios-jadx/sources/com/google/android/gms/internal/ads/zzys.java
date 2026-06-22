package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import com.google.android.gms.internal.ads.zzbbc;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class zzys extends Handler implements Runnable {
    final /* synthetic */ zzyx zza;
    private final zzyt zzb;
    private final long zzc;
    private zzyp zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzys(zzyx zzyxVar, Looper looper, zzyt zzytVar, zzyp zzypVar, int i, long j) {
        super(looper);
        this.zza = zzyxVar;
        this.zzb = zzytVar;
        this.zzd = zzypVar;
        this.zzc = j;
    }

    private final void zzd() {
        this.zze = null;
        zzyx zzyxVar = this.zza;
        ExecutorService executorService = zzyxVar.zzc;
        zzys zzysVar = zzyxVar.zzd;
        zzysVar.getClass();
        executorService.execute(zzysVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            zzd();
            return;
        }
        if (i == 3) {
            throw ((Error) message.obj);
        }
        this.zza.zzd = null;
        long j = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - j;
        zzyp zzypVar = this.zzd;
        zzypVar.getClass();
        if (this.zzh) {
            zzypVar.zzJ(this.zzb, jElapsedRealtime, j2, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            try {
                zzypVar.zzK(this.zzb, jElapsedRealtime, j2);
                return;
            } catch (RuntimeException e) {
                zzea.zzd("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zze = new zzyw(e);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i3 = this.zzf + 1;
        this.zzf = i3;
        zzyr zzyrVarZzu = zzypVar.zzu(this.zzb, jElapsedRealtime, j2, iOException, i3);
        if (zzyrVarZzu.zza == 3) {
            this.zza.zze = this.zze;
        } else if (zzyrVarZzu.zza != 2) {
            if (zzyrVarZzu.zza == 1) {
                this.zzf = 1;
            }
            zzc(zzyrVarZzu.zzb != -9223372036854775807L ? zzyrVarZzu.zzb : Math.min((this.zzf - 1) * zzbbc.zzq.zzf, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (!z) {
                Trace.beginSection("load:".concat(this.zzb.getClass().getSimpleName()));
                try {
                    this.zzb.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(2, e).sendToTarget();
        } catch (Exception e2) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "Unexpected exception loading stream", e2);
            obtainMessage(2, new zzyw(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            if (this.zzi) {
                return;
            }
            zzea.zzd("LoadTask", "OutOfMemory error loading stream", e3);
            obtainMessage(2, new zzyw(e3)).sendToTarget();
        } catch (Error e4) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                try {
                    this.zzh = true;
                    this.zzb.zzg();
                    Thread thread = this.zzg;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            this.zza.zzd = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzyp zzypVar = this.zzd;
            zzypVar.getClass();
            zzypVar.zzJ(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzdi.zzf(this.zza.zzd == null);
        this.zza.zzd = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }
}
