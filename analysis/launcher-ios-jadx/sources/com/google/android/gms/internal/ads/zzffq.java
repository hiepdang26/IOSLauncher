package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
final class zzffq implements zzgcf {
    final /* synthetic */ zzcej zza;
    final /* synthetic */ zzcni zzb;
    final /* synthetic */ zzfll zzc;
    final /* synthetic */ zzedh zzd;

    public zzffq(zzcej zzcejVar, zzcni zzcniVar, zzfll zzfllVar, zzedh zzedhVar) {
        this.zza = zzcejVar;
        this.zzb = zzcniVar;
        this.zzc = zzfllVar;
        this.zzd = zzedhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzai) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzjg)).booleanValue() && this.zzb != null && zzcni.zzj(str)) {
                this.zzb.zzi(str, this.zzc, x32.f.e);
                return;
            } else {
                this.zzc.zzc(str, null);
                return;
            }
        }
        hd2 hd2Var = hd2.B;
        hd2Var.j.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str2 = this.zza.zzR().zzb;
        int i = 2;
        if (!hd2Var.g.zzA(this.zza.getContext())) {
            if ((!((Boolean) n42.d.c.zza(zzbbw.zzfD)).booleanValue() || !this.zza.zzD().zzS) && this.zza.zzD().zzad == null) {
                i = 1;
            }
        }
        this.zzd.zzd(new zzedj(jCurrentTimeMillis, str2, str, i));
    }
}
