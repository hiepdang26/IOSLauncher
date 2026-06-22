package com.google.android.gms.internal.ads;

import android.app.Activity;
import defpackage.yb2;

/* JADX INFO: loaded from: classes.dex */
final class zzecw extends zzedt {
    private Activity zza;
    private yb2 zzb;
    private String zzc;
    private String zzd;

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zza(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Null activity");
        }
        this.zza = activity;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zzb(yb2 yb2Var) {
        this.zzb = yb2Var;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zzc(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedt zzd(String str) {
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzedt
    public final zzedu zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzecy(activity, this.zzb, this.zzc, this.zzd, null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
