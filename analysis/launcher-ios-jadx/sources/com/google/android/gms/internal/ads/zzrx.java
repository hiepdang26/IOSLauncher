package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class zzrx extends zzhd {
    private long zzg;
    private int zzh;
    private int zzi;

    public zzrx() {
        super(2, 0);
        this.zzi = 32;
    }

    @Override // com.google.android.gms.internal.ads.zzhd, com.google.android.gms.internal.ads.zzgx
    public final void zzb() {
        super.zzb();
        this.zzh = 0;
    }

    public final int zzl() {
        return this.zzh;
    }

    public final long zzm() {
        return this.zzg;
    }

    public final void zzn(int i) {
        this.zzi = i;
    }

    public final boolean zzo(zzhd zzhdVar) {
        ByteBuffer byteBuffer;
        zzdi.zzd(!zzhdVar.zzd(1073741824));
        zzdi.zzd(!zzhdVar.zzd(268435456));
        zzdi.zzd(!zzhdVar.zzd(4));
        if (zzp()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzhdVar.zzc;
            if (byteBuffer2 != null && (byteBuffer = this.zzc) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.zzh;
        this.zzh = i + 1;
        if (i == 0) {
            this.zze = zzhdVar.zze;
            if (zzhdVar.zzd(1)) {
                zzc(1);
            }
        }
        ByteBuffer byteBuffer3 = zzhdVar.zzc;
        if (byteBuffer3 != null) {
            zzi(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzhdVar.zze;
        return true;
    }

    public final boolean zzp() {
        return this.zzh > 0;
    }
}
