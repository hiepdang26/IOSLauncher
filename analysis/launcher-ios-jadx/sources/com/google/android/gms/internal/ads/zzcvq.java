package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class zzcvq implements zzcye, zzcxl {
    private final zzfel zza;

    public zzcvq(Context context, zzfel zzfelVar, zzbss zzbssVar) {
        this.zza = zzfelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        zzbst zzbstVar = this.zza.zzad;
        if (zzbstVar == null || !zzbstVar.zza) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.zza.zzad.zzb.isEmpty()) {
            return;
        }
        arrayList.add(this.zza.zzad.zzb);
    }
}
