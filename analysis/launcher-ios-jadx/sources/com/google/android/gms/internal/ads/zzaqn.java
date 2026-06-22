package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
final class zzaqn implements zzaqc {
    final /* synthetic */ Context zza;
    private File zzb = null;

    public zzaqn(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaqc
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
