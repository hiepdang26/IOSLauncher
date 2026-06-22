package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zztu {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzfr zzc;

    public zztu(zzacp zzacpVar, zzajy zzajyVar) {
    }

    public final void zza(zzfr zzfrVar) {
        if (zzfrVar != this.zzc) {
            this.zzc = zzfrVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
