package com.google.android.gms.internal.ads;

import defpackage.j92;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzeke implements zzcxz {
    boolean zza = false;
    final /* synthetic */ zzeew zzb;
    final /* synthetic */ zzbzt zzc;

    public zzeke(zzekf zzekfVar, zzeew zzeewVar, zzbzt zzbztVar) {
        this.zzb = zzeewVar;
        this.zzc = zzbztVar;
    }

    private final synchronized void zze(j92 j92Var) {
        int i = 1;
        if (true == ((Boolean) n42.d.c.zza(zzbbw.zzeQ)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzeex(i, j92Var));
    }

    @Override // com.google.android.gms.internal.ads.zzcxz
    public final synchronized void zza(int i) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new j92(i, zzekf.zze(this.zzb.zza, i), "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcxz
    public final synchronized void zzb(j92 j92Var) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(j92Var);
    }

    @Override // com.google.android.gms.internal.ads.zzcxz
    public final synchronized void zzc(int i, String str) {
        try {
            if (this.zza) {
                return;
            }
            this.zza = true;
            if (str == null) {
                str = zzekf.zze(this.zzb.zza, i);
            }
            zze(new j92(i, str, "undefined", null, null));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxz
    public final synchronized void zzd() {
        this.zzc.zzc(null);
    }
}
