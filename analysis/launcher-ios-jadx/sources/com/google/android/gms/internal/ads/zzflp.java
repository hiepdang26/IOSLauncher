package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzflp {
    private boolean zza;

    public final void zza(Context context) {
        zzfnj.zzc(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfmt.zzb().zzd(context);
        zzfmk.zza().zzd(context);
        zzfne.zzb(context);
        zzfnf.zzd(context);
        zzfni.zza(context);
        zzfmq.zzb().zzc(context);
        zzfmj.zza().zzd(context);
    }

    public final boolean zzb() {
        return this.zza;
    }
}
