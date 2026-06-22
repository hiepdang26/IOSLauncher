package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.n42;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class zzevv implements zzevn {
    private final int zza;
    private final int zzb;

    public zzevv(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("sessions_without_flags", this.zza);
        bundle.putInt("crashes_without_flags", this.zzb);
        x32 x32Var = x32.f;
        if (n42.d.c.zze()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
