package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadg {
    public final zzadj zza;
    public final zzadj zzb;

    public zzadg(zzadj zzadjVar, zzadj zzadjVar2) {
        this.zza = zzadjVar;
        this.zzb = zzadjVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadg.class == obj.getClass()) {
            zzadg zzadgVar = (zzadg) obj;
            if (this.zza.equals(zzadgVar.zza) && this.zzb.equals(zzadgVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        zzadj zzadjVar = this.zza;
        zzadj zzadjVar2 = this.zzb;
        return "[" + zzadjVar.toString() + (zzadjVar.equals(zzadjVar2) ? "" : ", ".concat(this.zzb.toString())) + "]";
    }
}
