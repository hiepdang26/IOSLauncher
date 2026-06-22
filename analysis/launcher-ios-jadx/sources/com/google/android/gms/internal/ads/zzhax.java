package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzhax extends zzhay {
    public zzhax(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final byte zza(long j) {
        return Memory.peekByte(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final double zzb(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzd(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray(j, bArr, (int) j2, (int) j3);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhaz.zzk(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhaz.zzl(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.ads.zzhaz.zzl(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.ads.zzhaz.zzk(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zze(Object obj, long j, boolean z) {
        if (zzhaz.zzb) {
            zzhaz.zzk(obj, j, z);
        } else {
            zzhaz.zzl(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzf(Object obj, long j, byte b) {
        if (zzhaz.zzb) {
            zzhaz.zzG(obj, j, b);
        } else {
            zzhaz.zzH(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zzh(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final boolean zzi(Object obj, long j) {
        return zzhaz.zzb ? zzhaz.zzw(obj, j) : zzhaz.zzx(obj, j);
    }
}
