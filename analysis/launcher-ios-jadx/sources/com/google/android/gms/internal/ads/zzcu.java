package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcu implements zzct {
    protected zzcr zzb;
    protected zzcr zzc;
    private zzcr zzd;
    private zzcr zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzcu() {
        ByteBuffer byteBuffer = zzct.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzcr zzcrVar = zzcr.zza;
        this.zzd = zzcrVar;
        this.zze = zzcrVar;
        this.zzb = zzcrVar;
        this.zzc = zzcrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final zzcr zza(zzcr zzcrVar) {
        this.zzd = zzcrVar;
        this.zze = zzi(zzcrVar);
        return zzg() ? this.zze : zzcr.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzct.zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zzc() {
        this.zzg = zzct.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public final void zzf() {
        zzc();
        this.zzf = zzct.zza;
        zzcr zzcrVar = zzcr.zza;
        this.zzd = zzcrVar;
        this.zze = zzcrVar;
        this.zzb = zzcrVar;
        this.zzc = zzcrVar;
        zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public boolean zzg() {
        return this.zze != zzcr.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzct
    public boolean zzh() {
        return this.zzh && this.zzg == zzct.zza;
    }

    public zzcr zzi(zzcr zzcrVar) {
        throw null;
    }

    public final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    public void zzk() {
    }

    public void zzl() {
    }

    public void zzm() {
    }

    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
