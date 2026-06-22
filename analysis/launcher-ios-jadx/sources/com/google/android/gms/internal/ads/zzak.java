package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzak {
    public final String zza;
    public final String zzb;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzak(String str, String str2) {
        this.zza = zzet.zzD(str);
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzak.class == obj.getClass()) {
            zzak zzakVar = (zzak) obj;
            if (zzet.zzG(this.zza, zzakVar.zza) && zzet.zzG(this.zzb, zzakVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() * 31;
        String str = this.zza;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
