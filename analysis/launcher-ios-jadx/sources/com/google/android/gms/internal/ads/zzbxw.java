package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import defpackage.hd2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxw implements zzaxw {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzbxw(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final String zza() {
        return this.zzc;
    }

    public final void zzb(boolean z) {
        hd2 hd2Var = hd2.B;
        if (hd2Var.x.zzp(this.zza)) {
            synchronized (this.zzb) {
                try {
                    if (this.zzd == z) {
                        return;
                    }
                    this.zzd = z;
                    if (TextUtils.isEmpty(this.zzc)) {
                        return;
                    }
                    if (this.zzd) {
                        hd2Var.x.zzf(this.zza, this.zzc);
                    } else {
                        hd2Var.x.zzg(this.zza, this.zzc);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        zzb(zzaxvVar.zzj);
    }
}
