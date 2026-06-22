package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzetf implements zzevn {
    public final zzfek zza;

    public zzetf(zzfek zzfekVar) {
        this.zza = zzfekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkW)).booleanValue()) {
                return;
            }
            bundle.putBoolean("render_in_browser", this.zza.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
