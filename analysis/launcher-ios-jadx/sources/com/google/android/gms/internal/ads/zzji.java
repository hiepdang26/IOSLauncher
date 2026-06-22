package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* JADX INFO: loaded from: classes.dex */
final class zzji implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzaay, zzpe, zzwl, zztg, zzhk, zzhg {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzjm zza;

    public /* synthetic */ zzji(zzjm zzjmVar, zzjh zzjhVar) {
        this.zza = zzjmVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzjm.zzK(this.zza, surfaceTexture);
        this.zza.zzaa(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzad(null);
        this.zza.zzaa(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzaa(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzaa(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzaa(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zza(Exception exc) {
        this.zza.zzq.zzv(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzb(String str, long j, long j2) {
        this.zza.zzq.zzw(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzc(String str) {
        this.zza.zzq.zzx(str);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzd(zzhn zzhnVar) {
        this.zza.zzq.zzy(zzhnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zze(zzhn zzhnVar) {
        this.zza.zzq.zzz(zzhnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzf(zzaf zzafVar, zzho zzhoVar) {
        this.zza.zzq.zzA(zzafVar, zzhoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzg(long j) {
        this.zza.zzq.zzB(j);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzh(Exception exc) {
        this.zza.zzq.zzC(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzi(zzpf zzpfVar) {
        this.zza.zzq.zzD(zzpfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzj(zzpf zzpfVar) {
        this.zza.zzq.zzE(zzpfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzk(int i, long j, long j2) {
        this.zza.zzq.zzF(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzl(int i, long j) {
        this.zza.zzq.zzG(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzm(Object obj, long j) {
        this.zza.zzq.zzH(obj, j);
        zzjm zzjmVar = this.zza;
        if (zzjmVar.zzG == obj) {
            zzdz zzdzVar = zzjmVar.zzl;
            zzdzVar.zzd(26, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjg
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj2) {
                }
            });
            zzdzVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    public final void zzn(final boolean z) {
        zzjm zzjmVar = this.zza;
        if (zzjmVar.zzN == z) {
            return;
        }
        zzjmVar.zzN = z;
        zzdz zzdzVar = this.zza.zzl;
        zzdzVar.zzd(23, new zzdw() { // from class: com.google.android.gms.internal.ads.zzje
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzbu) obj).zzn(z);
            }
        });
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzo(Exception exc) {
        this.zza.zzq.zzI(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzp(String str, long j, long j2) {
        this.zza.zzq.zzJ(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzq(String str) {
        this.zza.zzq.zzK(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzr(zzhn zzhnVar) {
        this.zza.zzq.zzL(zzhnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzs(zzhn zzhnVar) {
        this.zza.zzq.zzM(zzhnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzt(long j, int i) {
        this.zza.zzq.zzN(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzu(zzaf zzafVar, zzho zzhoVar) {
        this.zza.zzq.zzO(zzafVar, zzhoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaay
    public final void zzv(final zzcp zzcpVar) {
        zzdz zzdzVar = this.zza.zzl;
        zzdzVar.zzd(25, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjf
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzbu) obj).zzr(zzcpVar);
            }
        });
        zzdzVar.zzc();
    }
}
