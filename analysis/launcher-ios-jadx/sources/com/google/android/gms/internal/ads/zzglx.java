package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzglx {
    public static final zzglo zza = new zzglw(null);

    public static zzglu zza(zzgnj zzgnjVar) {
        zzgea zzgeaVar;
        zzglq zzglqVar = new zzglq();
        zzglqVar.zzb(zzgnjVar.zza());
        Iterator it = zzgnjVar.zze().iterator();
        while (it.hasNext()) {
            for (zzgnh zzgnhVar : (List) it.next()) {
                int iZzf = zzgnhVar.zzf() - 2;
                if (iZzf == 1) {
                    zzgeaVar = zzgea.zza;
                } else if (iZzf == 2) {
                    zzgeaVar = zzgea.zzb;
                } else {
                    if (iZzf != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzgeaVar = zzgea.zzc;
                }
                int iZza = zzgnhVar.zza();
                String strZze = zzgnhVar.zze();
                if (strZze.startsWith("type.googleapis.com/google.crypto.")) {
                    strZze = strZze.substring(34);
                }
                zzglqVar.zza(zzgeaVar, iZza, strZze, zzgnhVar.zzb().name());
            }
        }
        if (zzgnjVar.zzc() != null) {
            zzglqVar.zzc(zzgnjVar.zzc().zza());
        }
        try {
            return zzglqVar.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
