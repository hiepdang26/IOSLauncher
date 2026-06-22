package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;
import defpackage.x32;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzffs {
    private final zzfel zza;
    private final zzfeo zzb;
    private final zzedh zzc;
    private final zzfll zzd;
    private final zzfkf zze;
    private final zzcni zzf;

    public zzffs(zzedh zzedhVar, zzfll zzfllVar, zzfel zzfelVar, zzfeo zzfeoVar, zzcni zzcniVar, zzfkf zzfkfVar) {
        this.zza = zzfelVar;
        this.zzb = zzfeoVar;
        this.zzc = zzedhVar;
        this.zzd = zzfllVar;
        this.zzf = zzcniVar;
        this.zze = zzfkfVar;
    }

    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), 2);
        }
    }

    public final void zzb(String str, int i) {
        if (!this.zza.zzai) {
            this.zzd.zzc(str, this.zze);
            return;
        }
        hd2.B.j.getClass();
        this.zzc.zzd(new zzedj(System.currentTimeMillis(), this.zzb.zzb, str, i));
    }

    public final void zzc(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzgcj.zzr((((Boolean) n42.d.c.zza(zzbbw.zzjg)).booleanValue() && zzcni.zzj(str)) ? this.zzf.zzb(str, x32.f.e) : zzgcj.zzh(str), new zzffr(this, i), zzbzo.zza);
        }
    }
}
