package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgpt {
    public static final zzgpg zza = (zzgpg) zzgnz.zza(new zzgny() { // from class: com.google.android.gms.internal.ads.zzgpo
        @Override // com.google.android.gms.internal.ads.zzgny
        public final Object zza() {
            zzgpc zzgpcVar = new zzgpc(null);
            zzgpcVar.zzb(32);
            zzgpcVar.zzc(16);
            zzgpcVar.zzd(zzgpe.zza);
            zzgpcVar.zza(zzgpd.zzc);
            return zzgpcVar.zze();
        }
    });
    public static final zzgpg zzb;
    public static final zzgon zzc;

    static {
        zzb = (zzgpg) zzgnz.zza(new zzgny() { // from class: com.google.android.gms.internal.ads.zzgpr
            @Override // com.google.android.gms.internal.ads.zzgny
            public final Object zza() {
                zzgpc zzgpcVar = new zzgpc(null);
                zzgpcVar.zzb(64);
                zzgpcVar.zzc(64);
                zzgpcVar.zzd(zzgpe.zza);
                zzgpcVar.zza(zzgpd.zze);
                return zzgpcVar.zze();
            }
        });
        zzc = (zzgon) zzgnz.zza(new zzgny() { // from class: com.google.android.gms.internal.ads.zzgps
            @Override // com.google.android.gms.internal.ads.zzgny
            public final Object zza() throws GeneralSecurityException {
                zzgok zzgokVar = new zzgok(null);
                zzgokVar.zza(32);
                zzgokVar.zzb(16);
                zzgokVar.zzc(zzgol.zza);
                return zzgokVar.zzd();
            }
        });
    }
}
