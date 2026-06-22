package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzz {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzz zza(int i) {
        zzdi.zzf(!this.zzb);
        this.zza.append(i, true);
        return this;
    }

    public final zzab zzb() {
        zzdi.zzf(!this.zzb);
        this.zzb = true;
        return new zzab(this.zza, null);
    }
}
