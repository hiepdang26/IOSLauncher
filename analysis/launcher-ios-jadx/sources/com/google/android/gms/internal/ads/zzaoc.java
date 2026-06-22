package com.google.android.gms.internal.ads;

import android.util.Pair;
import defpackage.k31;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
final class zzaoc {
    public static Pair zza(zzacl zzaclVar) throws zzbo, EOFException, InterruptedIOException {
        zzaclVar.zzj();
        zzaob zzaobVarZzd = zzd(1684108385, zzaclVar, new zzek(8));
        ((zzaby) zzaclVar).zzo(8, false);
        return Pair.create(Long.valueOf(zzaclVar.zzf()), Long.valueOf(zzaobVarZzd.zzb));
    }

    public static zzaoa zzb(zzacl zzaclVar) throws zzbo, EOFException, InterruptedIOException {
        byte[] bArr;
        zzek zzekVar = new zzek(16);
        zzaob zzaobVarZzd = zzd(1718449184, zzaclVar, zzekVar);
        zzdi.zzf(zzaobVarZzd.zzb >= 16);
        zzaby zzabyVar = (zzaby) zzaclVar;
        zzabyVar.zzm(zzekVar.zzM(), 0, 16, false);
        zzekVar.zzK(0);
        int iZzk = zzekVar.zzk();
        int iZzk2 = zzekVar.zzk();
        int iZzj = zzekVar.zzj();
        int iZzj2 = zzekVar.zzj();
        int iZzk3 = zzekVar.zzk();
        int iZzk4 = zzekVar.zzk();
        int i = ((int) zzaobVarZzd.zzb) - 16;
        if (i > 0) {
            bArr = new byte[i];
            zzabyVar.zzm(bArr, 0, i, false);
        } else {
            bArr = zzet.zzf;
        }
        byte[] bArr2 = bArr;
        ((zzaby) zzaclVar).zzo((int) (zzaclVar.zze() - zzaclVar.zzf()), false);
        return new zzaoa(iZzk, iZzk2, iZzj, iZzj2, iZzk3, iZzk4, bArr2);
    }

    public static boolean zzc(zzacl zzaclVar) {
        zzek zzekVar = new zzek(8);
        int i = zzaob.zza(zzaclVar, zzekVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzaby) zzaclVar).zzm(zzekVar.zzM(), 0, 4, false);
        zzekVar.zzK(0);
        int iZzg = zzekVar.zzg();
        if (iZzg == 1463899717) {
            return true;
        }
        zzea.zzc("WavHeaderReader", "Unsupported form type: " + iZzg);
        return false;
    }

    private static zzaob zzd(int i, zzacl zzaclVar, zzek zzekVar) throws zzbo, EOFException, InterruptedIOException {
        zzaob zzaobVarZza = zzaob.zza(zzaclVar, zzekVar);
        while (true) {
            int i2 = zzaobVarZza.zza;
            if (i2 == i) {
                return zzaobVarZza;
            }
            k31.n(i2, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
            long j = zzaobVarZza.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                throw zzbo.zzc("Chunk is too large (~2GB+) to skip; id: " + zzaobVarZza.zza);
            }
            ((zzaby) zzaclVar).zzo((int) j2, false);
            zzaobVarZza = zzaob.zza(zzaclVar, zzekVar);
        }
    }
}
