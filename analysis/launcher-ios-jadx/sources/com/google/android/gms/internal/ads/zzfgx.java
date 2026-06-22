package com.google.android.gms.internal.ads;

import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzfgx {
    private final zzfgw zza = new zzfgw();
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;

    public final zzfgw zza() {
        zzfgw zzfgwVar = this.zza;
        zzfgw zzfgwVarClone = zzfgwVar.clone();
        zzfgwVar.zza = false;
        zzfgwVar.zzb = false;
        return zzfgwVarClone;
    }

    public final String zzb() {
        StringBuilder sb = new StringBuilder("\n\tPool does not exist: ");
        sb.append(this.zzd);
        sb.append("\n\tNew pools created: ");
        sb.append(this.zzb);
        sb.append("\n\tPools removed: ");
        sb.append(this.zzc);
        sb.append("\n\tEntries added: ");
        sb.append(this.zzf);
        sb.append("\n\tNo entries retrieved: ");
        return uo.j(sb, this.zze, "\n");
    }

    public final void zzc() {
        this.zzf++;
    }

    public final void zzd() {
        this.zzb++;
        this.zza.zza = true;
    }

    public final void zze() {
        this.zze++;
    }

    public final void zzf() {
        this.zzd++;
    }

    public final void zzg() {
        this.zzc++;
        this.zza.zzb = true;
    }
}
