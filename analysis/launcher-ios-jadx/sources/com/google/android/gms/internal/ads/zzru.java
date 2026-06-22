package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import defpackage.xb2;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzru implements zzsd {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzdm zzg;
    private boolean zzh;

    public zzru(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdm zzdmVar = new zzdm(zzdj.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdmVar;
        this.zzf = new AtomicReference();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* bridge */ /* synthetic */ void zza(com.google.android.gms.internal.ads.zzru r10, android.os.Message r11) {
        /*
            int r0 = r11.what
            r1 = 0
            if (r0 == 0) goto L59
            r2 = 1
            if (r0 == r2) goto L37
            r2 = 2
            if (r0 == r2) goto L31
            r2 = 3
            if (r0 == r2) goto L1f
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r0.<init>(r11)
            com.google.android.gms.internal.ads.zzrr.zza(r10, r1, r0)
            goto L73
        L1f:
            java.lang.Object r11 = r11.obj
            android.os.Bundle r11 = (android.os.Bundle) r11
            android.media.MediaCodec r0 = r10.zzc     // Catch: java.lang.RuntimeException -> L29
            r0.setParameters(r11)     // Catch: java.lang.RuntimeException -> L29
            goto L73
        L29:
            r0 = move-exception
            r11 = r0
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            com.google.android.gms.internal.ads.zzrr.zza(r10, r1, r11)
            goto L73
        L31:
            com.google.android.gms.internal.ads.zzdm r10 = r10.zzg
            r10.zze()
            goto L73
        L37:
            java.lang.Object r11 = r11.obj
            com.google.android.gms.internal.ads.zzrt r11 = (com.google.android.gms.internal.ads.zzrt) r11
            int r3 = r11.zza
            android.media.MediaCodec$CryptoInfo r5 = r11.zzd
            long r6 = r11.zze
            int r8 = r11.zzf
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzru.zzb     // Catch: java.lang.RuntimeException -> L51
            monitor-enter(r9)     // Catch: java.lang.RuntimeException -> L51
            android.media.MediaCodec r2 = r10.zzc     // Catch: java.lang.Throwable -> L4e
            r4 = 0
            r2.queueSecureInputBuffer(r3, r4, r5, r6, r8)     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L4e
            goto L57
        L4e:
            r0 = move-exception
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L4e
            throw r0     // Catch: java.lang.RuntimeException -> L51
        L51:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            com.google.android.gms.internal.ads.zzrr.zza(r10, r1, r0)
        L57:
            r1 = r11
            goto L73
        L59:
            java.lang.Object r11 = r11.obj
            com.google.android.gms.internal.ads.zzrt r11 = (com.google.android.gms.internal.ads.zzrt) r11
            int r3 = r11.zza
            int r5 = r11.zzc
            long r6 = r11.zze
            int r8 = r11.zzf
            android.media.MediaCodec r2 = r10.zzc     // Catch: java.lang.RuntimeException -> L6c
            r4 = 0
            r2.queueInputBuffer(r3, r4, r5, r6, r8)     // Catch: java.lang.RuntimeException -> L6c
            goto L57
        L6c:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r10 = r10.zzf
            com.google.android.gms.internal.ads.zzrr.zza(r10, r1, r0)
            goto L57
        L73:
            if (r1 == 0) goto L81
            java.util.ArrayDeque r10 = com.google.android.gms.internal.ads.zzru.zza
            monitor-enter(r10)
            r10.add(r1)     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7d
            goto L81
        L7d:
            r0 = move-exception
            r11 = r0
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7d
            throw r11
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzru.zza(com.google.android.gms.internal.ads.zzru, android.os.Message):void");
    }

    private static zzrt zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new zzrt();
                }
                return (zzrt) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static byte[] zzj(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzk(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                this.zzg.zzc();
                Handler handler2 = this.zze;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(2).sendToTarget();
                this.zzg.zza();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzc() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzd(int i, int i2, int i3, long j, int i4) {
        zzc();
        zzrt zzrtVarZzi = zzi();
        zzrtVarZzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        int i5 = zzet.zza;
        handler.obtainMessage(0, zzrtVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zze(int i, int i2, zzha zzhaVar, long j, int i3) {
        zzc();
        zzrt zzrtVarZzi = zzi();
        zzrtVarZzi.zza(i, 0, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzrtVarZzi.zzd;
        cryptoInfo.numSubSamples = zzhaVar.zzf;
        cryptoInfo.numBytesOfClearData = zzk(zzhaVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzk(zzhaVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzj = zzj(zzhaVar.zzb, cryptoInfo.key);
        bArrZzj.getClass();
        cryptoInfo.key = bArrZzj;
        byte[] bArrZzj2 = zzj(zzhaVar.zza, cryptoInfo.iv);
        bArrZzj2.getClass();
        cryptoInfo.iv = bArrZzj2;
        cryptoInfo.mode = zzhaVar.zzc;
        if (zzet.zza >= 24) {
            xb2.e();
            cryptoInfo.setPattern(xb2.b(zzhaVar.zzg, zzhaVar.zzh));
        }
        this.zze.obtainMessage(1, zzrtVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzf(Bundle bundle) {
        zzc();
        Handler handler = this.zze;
        int i = zzet.zza;
        handler.obtainMessage(3, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzg() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzsd
    public final void zzh() {
        if (this.zzh) {
            return;
        }
        this.zzd.start();
        this.zze = new zzrs(this, this.zzd.getLooper());
        this.zzh = true;
    }
}
