package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpt implements zzcxl {
    private final zzcej zza;

    public zzdpt(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(Context context) {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(Context context) {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(Context context) {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.onResume();
        }
    }
}
