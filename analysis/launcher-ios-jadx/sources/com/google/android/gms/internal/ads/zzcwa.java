package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzcwa {
    private final Context zza;
    private final zzffg zzb;
    private final Bundle zzc;
    private final zzfey zzd;
    private final zzcvs zze;
    private final zzeey zzf;

    public /* synthetic */ zzcwa(zzcvy zzcvyVar, zzcvz zzcvzVar) {
        this.zza = zzcvyVar.zza;
        this.zzb = zzcvyVar.zzb;
        this.zzc = zzcvyVar.zzc;
        this.zzd = zzcvyVar.zzd;
        this.zze = zzcvyVar.zze;
        this.zzf = zzcvyVar.zzf;
    }

    public final Context zza(Context context) {
        return this.zza;
    }

    public final Bundle zzb() {
        return this.zzc;
    }

    public final zzcvs zzc() {
        return this.zze;
    }

    public final zzcvy zzd() {
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(this.zza);
        zzcvyVar.zzi(this.zzb);
        zzcvyVar.zzf(this.zzc);
        zzcvyVar.zzg(this.zze);
        zzcvyVar.zzd(this.zzf);
        return zzcvyVar;
    }

    public final zzeey zze(String str) {
        zzeey zzeeyVar = this.zzf;
        return zzeeyVar != null ? zzeeyVar : new zzeey(str);
    }

    public final zzfey zzf() {
        return this.zzd;
    }

    public final zzffg zzg() {
        return this.zzb;
    }
}
