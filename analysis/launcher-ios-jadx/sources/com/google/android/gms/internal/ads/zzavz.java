package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzavz extends zzaxd {
    private final Activity zzh;
    private final View zzi;

    public zzavz(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i, int i2, View view, Activity activity) {
        super(zzavpVar, "GC4CZUnPsyUcm5NrWw7C8gSktjb/gtBCDrSKBLlqImuOnQy7zHyo6XlIzkH3EMVH", "Kx8fghNUQq+sA+EfmK6qh0KjuKvw753ECuaCFV8szVM=", zzaroVar, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    public final void zza() {
        if (this.zzi == null) {
            return;
        }
        Boolean bool = (Boolean) n42.d.c.zza(zzbbw.zzcp);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, this.zzi, this.zzh, bool);
        synchronized (this.zzd) {
            try {
                this.zzd.zzc(((Long) objArr[0]).longValue());
                this.zzd.zze(((Long) objArr[1]).longValue());
                if (zBooleanValue) {
                    this.zzd.zzd((String) objArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
