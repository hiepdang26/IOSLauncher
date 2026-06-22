package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzku implements zzkl {
    public final zzud zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzku(zzuk zzukVar, boolean z) {
        this.zza = new zzud(zzukVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzcc zza() {
        return this.zza.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i) {
        this.zzd = i;
        this.zze = false;
        this.zzc.clear();
    }
}
