package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
public final class zzevh implements zzevo {
    private final boolean zza;

    public zzevh(zzfcg zzfcgVar) {
        this.zza = zzfcgVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return zzgcj.zzh(this.zza ? new zzevn() { // from class: com.google.android.gms.internal.ads.zzevg
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                ((Bundle) obj).putBoolean("sdk_prefetch", true);
            }
        } : null);
    }
}
