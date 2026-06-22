package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcp {
    public static final zzcp zza = new zzcp(0, 0, 0, 1.0f);
    public final int zzb;
    public final int zzc;
    public final int zzd = 0;
    public final float zze;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
    }

    public zzcp(int i, int i2, int i3, float f) {
        this.zzb = i;
        this.zzc = i2;
        this.zze = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcp) {
            zzcp zzcpVar = (zzcp) obj;
            if (this.zzb == zzcpVar.zzb && this.zzc == zzcpVar.zzc && this.zze == zzcpVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.zzb + 217) * 31) + this.zzc;
        return Float.floatToRawIntBits(this.zze) + (i * 961);
    }
}
