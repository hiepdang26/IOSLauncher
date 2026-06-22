package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzcmy implements zzcxl {
    private final zzfge zza;

    public zzcmy(zzfge zzfgeVar) {
        this.zza = zzfgeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(Context context) {
        try {
            this.zza.zzg();
        } catch (zzffn unused) {
            k92.j(5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(Context context) {
        try {
            this.zza.zzt();
        } catch (zzffn unused) {
            k92.j(5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzffn unused) {
            k92.j(5);
        }
    }
}
