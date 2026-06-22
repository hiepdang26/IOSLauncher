package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzhaw extends zzhay {
    public zzhaw(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final byte zza(long j) {
        return Memory.peekByte((int) j);
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
        Memory.peekByteArray((int) j, bArr, (int) j2, (int) j3);
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    public final void zze(Object obj, long j, boolean z) {
        if (zzhaz.zzb) {
            zzhaz.zzG(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzhaz.zzH(obj, j, z ? (byte) 1 : (byte) 0);
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
