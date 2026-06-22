package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class zzaqx extends zzhel {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzhev zzm;
    private long zzn;

    public zzaqx() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzhev.zza;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzheq.zza(zzaqt.zzf(byteBuffer));
            this.zzh = zzheq.zza(zzaqt.zzf(byteBuffer));
            this.zzi = zzaqt.zze(byteBuffer);
            this.zzj = zzaqt.zzf(byteBuffer);
        } else {
            this.zzg = zzheq.zza(zzaqt.zze(byteBuffer));
            this.zzh = zzheq.zza(zzaqt.zze(byteBuffer));
            this.zzi = zzaqt.zze(byteBuffer);
            this.zzj = zzaqt.zze(byteBuffer);
        }
        this.zzk = zzaqt.zzb(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzl = ((short) ((r1[1] & 255) | ((short) (65280 & (r1[0] << 8))))) / 256.0f;
        zzaqt.zzd(byteBuffer);
        zzaqt.zze(byteBuffer);
        zzaqt.zze(byteBuffer);
        this.zzm = new zzhev(zzaqt.zzb(byteBuffer), zzaqt.zzb(byteBuffer), zzaqt.zzb(byteBuffer), zzaqt.zzb(byteBuffer), zzaqt.zza(byteBuffer), zzaqt.zza(byteBuffer), zzaqt.zza(byteBuffer), zzaqt.zzb(byteBuffer), zzaqt.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzaqt.zze(byteBuffer);
    }
}
