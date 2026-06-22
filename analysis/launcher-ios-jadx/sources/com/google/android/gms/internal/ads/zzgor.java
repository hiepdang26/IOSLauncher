package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgor implements zzgnk {
    private static final zzgor zza = new zzgor();

    private zzgor() {
    }

    public static void zzd() {
        zzgmh.zza().zzf(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zza() {
        return zzgoo.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final Class zzb() {
        return zzgoo.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgnk
    public final /* bridge */ /* synthetic */ Object zzc(zzgnj zzgnjVar) throws GeneralSecurityException {
        if (zzgnjVar.zzc() == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        Iterator it = zzgnjVar.zze().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new zzgoq(zzgnjVar, null);
    }
}
