package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzfmt implements zzfmm {
    private static zzfmt zza;
    private float zzb = 0.0f;
    private zzfmh zzc;
    private zzfml zzd;

    public zzfmt(zzfmi zzfmiVar, zzfmg zzfmgVar) {
    }

    public static zzfmt zzb() {
        if (zza == null) {
            zza = new zzfmt(new zzfmi(), new zzfmg());
        }
        return zza;
    }

    public final float zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmm
    public final void zzc(boolean z) {
        if (z) {
            zzfnt.zzd().zzi();
        } else {
            zzfnt.zzd().zzh();
        }
    }

    public final void zzd(Context context) {
        this.zzc = new zzfmh(new Handler(), context, new zzfmf(), this);
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzd == null) {
            this.zzd = zzfml.zza();
        }
        Iterator it = this.zzd.zzb().iterator();
        while (it.hasNext()) {
            ((zzflu) it.next()).zzg().zzl(f);
        }
    }

    public final void zzf() {
        zzfmk.zza().zze(this);
        zzfmk.zza().zzf();
        zzfnt.zzd().zzi();
        this.zzc.zza();
    }

    public final void zzg() {
        zzfnt.zzd().zzj();
        zzfmk.zza().zzg();
        this.zzc.zzb();
    }
}
