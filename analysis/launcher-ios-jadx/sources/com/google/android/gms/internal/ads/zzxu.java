package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzxu {
    public final zzcd zza;
    public final int[] zzb;

    public zzxu(zzcd zzcdVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzea.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzcdVar;
        this.zzb = iArr;
    }
}
