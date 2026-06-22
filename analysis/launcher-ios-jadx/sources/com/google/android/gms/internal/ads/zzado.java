package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzado {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzado(int i, byte[] bArr, int i2, int i3) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzado.class == obj.getClass()) {
            zzado zzadoVar = (zzado) obj;
            if (this.zza == zzadoVar.zza && this.zzc == zzadoVar.zzc && this.zzd == zzadoVar.zzd && Arrays.equals(this.zzb, zzadoVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        return ((((Arrays.hashCode(this.zzb) + (i * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
