package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzajk extends zzajo {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    public static boolean zzd(zzek zzekVar) {
        return zzk(zzekVar, zza);
    }

    private static boolean zzk(zzek zzekVar, byte[] bArr) {
        if (zzekVar.zzb() < 8) {
            return false;
        }
        int iZzd = zzekVar.zzd();
        byte[] bArr2 = new byte[8];
        zzekVar.zzG(bArr2, 0, 8);
        zzekVar.zzK(iZzd);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final long zza(zzek zzekVar) {
        return zzg(zzade.zzd(zzekVar.zzM()));
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) {
        if (zzk(zzekVar, zza)) {
            byte[] bArrCopyOf = Arrays.copyOf(zzekVar.zzM(), zzekVar.zze());
            int i = bArrCopyOf[9] & 255;
            List listZze = zzade.zze(bArrCopyOf);
            if (zzajlVar.zza == null) {
                zzad zzadVar = new zzad();
                zzadVar.zzX("audio/opus");
                zzadVar.zzy(i);
                zzadVar.zzY(48000);
                zzadVar.zzL(listZze);
                zzajlVar.zza = zzadVar.zzad();
                return true;
            }
        } else {
            if (!zzk(zzekVar, zzb)) {
                zzdi.zzb(zzajlVar.zza);
                return false;
            }
            zzdi.zzb(zzajlVar.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzekVar.zzL(8);
                zzbk zzbkVarZzb = zzadv.zzb(zzfxr.zzl(zzadv.zzc(zzekVar, false, false).zza));
                if (zzbkVarZzb != null) {
                    zzad zzadVarZzb = zzajlVar.zza.zzb();
                    zzadVarZzb.zzQ(zzbkVarZzb.zzd(zzajlVar.zza.zzk));
                    zzajlVar.zza = zzadVarZzb.zzad();
                }
            }
        }
        return true;
    }
}
