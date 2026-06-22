package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaju {
    public static void zza(zzajv zzajvVar, zzajz zzajzVar, zzdn zzdnVar) {
        for (int i = 0; i < zzajvVar.zza(); i++) {
            long jZzb = zzajvVar.zzb(i);
            List listZzc = zzajvVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzajvVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzajvVar.zzb(i + 1) - zzajvVar.zzb(i);
                if (jZzb2 > 0) {
                    zzdnVar.zza(new zzajs(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
