package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzaco {
    public static int zza(zzacl zzaclVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int iZzb = zzaclVar.zzb(bArr, i + i3, i2 - i3);
            if (iZzb == -1) {
                break;
            }
            i3 += iZzb;
        }
        return i3;
    }

    public static void zzb(boolean z, String str) throws zzbo {
        if (!z) {
            throw zzbo.zza(str, null);
        }
    }

    public static boolean zzc(zzacl zzaclVar, byte[] bArr, int i, int i2, boolean z) throws EOFException {
        try {
            return zzaclVar.zzm(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static boolean zzd(zzacl zzaclVar, byte[] bArr, int i, int i2) throws InterruptedIOException {
        try {
            ((zzaby) zzaclVar).zzn(bArr, i, i2, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzacl zzaclVar, int i) throws InterruptedIOException {
        try {
            ((zzaby) zzaclVar).zzo(i, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
