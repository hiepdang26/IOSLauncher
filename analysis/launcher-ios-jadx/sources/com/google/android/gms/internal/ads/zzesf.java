package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzesf implements zzevn {
    public final String zza;
    public final boolean zzb;

    public zzesf(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", "1");
        }
    }
}
