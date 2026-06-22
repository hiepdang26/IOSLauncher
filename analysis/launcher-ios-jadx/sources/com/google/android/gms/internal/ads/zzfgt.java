package com.google.android.gms.internal.ads;

import defpackage.hd2;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
final class zzfgt {
    private final int zzb;
    private final int zzc;
    private final LinkedList zza = new LinkedList();
    private final zzfhs zzd = new zzfhs();

    public zzfgt(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
    }

    private final void zzi() {
        while (!this.zza.isEmpty()) {
            zzfhd zzfhdVar = (zzfhd) this.zza.getFirst();
            hd2.B.j.getClass();
            if (System.currentTimeMillis() - zzfhdVar.zzd < this.zzc) {
                return;
            }
            this.zzd.zzg();
            this.zza.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzfhd zze() {
        this.zzd.zzf();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzfhd zzfhdVar = (zzfhd) this.zza.remove();
        if (zzfhdVar != null) {
            this.zzd.zzh();
        }
        return zzfhdVar;
    }

    public final zzfhr zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzfhd zzfhdVar) {
        this.zzd.zzf();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzfhdVar);
        return true;
    }
}
