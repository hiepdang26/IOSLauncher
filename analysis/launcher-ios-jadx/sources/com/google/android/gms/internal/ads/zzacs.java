package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzacs {
    public static zzbk zza(zzacl zzaclVar, boolean z) throws EOFException, InterruptedIOException {
        zzbk zzbkVarZza = new zzada().zza(zzaclVar, z ? null : zzagc.zza);
        if (zzbkVarZza == null || zzbkVarZza.zza() == 0) {
            return null;
        }
        return zzbkVarZza;
    }

    public static zzacu zzb(zzek zzekVar) {
        zzekVar.zzL(1);
        int iZzo = zzekVar.zzo();
        long jZzd = zzekVar.zzd();
        long j = iZzo;
        int i = iZzo / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jZzt = zzekVar.zzt();
            if (jZzt == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZzt;
            jArrCopyOf2[i2] = zzekVar.zzt();
            zzekVar.zzL(2);
            i2++;
        }
        zzekVar.zzL((int) ((jZzd + j) - ((long) zzekVar.zzd())));
        return new zzacu(jArrCopyOf, jArrCopyOf2);
    }
}
