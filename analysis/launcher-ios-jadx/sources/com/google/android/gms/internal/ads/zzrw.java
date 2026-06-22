package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import defpackage.ri;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
final class zzrw extends MediaCodec.Callback {
    private final HandlerThread zzb;
    private Handler zzc;
    private MediaFormat zzh;
    private MediaFormat zzi;
    private MediaCodec.CodecException zzj;
    private MediaCodec.CryptoException zzk;
    private long zzl;
    private boolean zzm;
    private IllegalStateException zzn;
    private zzsb zzo;
    private final Object zza = new Object();
    private final ri zzd = new ri();
    private final ri zze = new ri();
    private final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();

    public zzrw(HandlerThread handlerThread) {
        this.zzb = handlerThread;
    }

    public static /* synthetic */ void zzd(zzrw zzrwVar) {
        synchronized (zzrwVar.zza) {
            try {
                if (zzrwVar.zzm) {
                    return;
                }
                long j = zzrwVar.zzl - 1;
                zzrwVar.zzl = j;
                if (j > 0) {
                    return;
                }
                if (j >= 0) {
                    zzrwVar.zzj();
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                synchronized (zzrwVar.zza) {
                    zzrwVar.zzn = illegalStateException;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzi(MediaFormat mediaFormat) {
        this.zze.a(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzj() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        ri riVar = this.zzd;
        riVar.c = riVar.b;
        ri riVar2 = this.zze;
        riVar2.c = riVar2.b;
        this.zzf.clear();
        this.zzg.clear();
    }

    private final void zzk() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException != null) {
            this.zzn = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.zzk;
        if (cryptoException == null) {
            return;
        }
        this.zzk = null;
        throw cryptoException;
    }

    private final boolean zzl() {
        return this.zzl > 0 || this.zzm;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.zza) {
            try {
                this.zzd.a(i);
                zzsb zzsbVar = this.zzo;
                if (zzsbVar != null) {
                    zzso zzsoVar = ((zzsm) zzsbVar).zza;
                    if (zzsoVar.zzo != null) {
                        zzsoVar.zzo.zza();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            try {
                MediaFormat mediaFormat = this.zzi;
                if (mediaFormat != null) {
                    zzi(mediaFormat);
                    this.zzi = null;
                }
                this.zze.a(i);
                this.zzf.add(bufferInfo);
                zzsb zzsbVar = this.zzo;
                if (zzsbVar != null) {
                    zzso zzsoVar = ((zzsm) zzsbVar).zza;
                    if (zzsoVar.zzo != null) {
                        zzsoVar.zzo.zza();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzi(mediaFormat);
            this.zzi = null;
        }
    }

    public final int zza() {
        synchronized (this.zza) {
            try {
                zzk();
                int i = -1;
                if (zzl()) {
                    return -1;
                }
                ri riVar = this.zzd;
                int i2 = riVar.b;
                int i3 = riVar.c;
                if (!(i2 == i3)) {
                    if (i2 == i3) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    i = riVar.a[i2];
                    riVar.b = (i2 + 1) & riVar.d;
                }
                return i;
            } finally {
            }
        }
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            try {
                zzk();
                if (zzl()) {
                    return -1;
                }
                ri riVar = this.zze;
                int i = riVar.b;
                int i2 = riVar.c;
                if (i == i2) {
                    return -1;
                }
                if (i == i2) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i3 = riVar.a[i];
                riVar.b = (i + 1) & riVar.d;
                if (i3 >= 0) {
                    zzdi.zzb(this.zzh);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.zzf.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (i3 == -2) {
                    this.zzh = (MediaFormat) this.zzg.remove();
                    i3 = -2;
                }
                return i3;
            } finally {
            }
        }
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            try {
                mediaFormat = this.zzh;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            int i = zzet.zza;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzrv
                @Override // java.lang.Runnable
                public final void run() {
                    zzrw.zzd(this.zza);
                }
            });
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        zzdi.zzf(this.zzc == null);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg(zzsb zzsbVar) {
        synchronized (this.zza) {
            this.zzo = zzsbVar;
        }
    }

    public final void zzh() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzj();
        }
    }
}
