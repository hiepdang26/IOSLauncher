package com.google.android.gms.internal.ads;

import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public final class zzph extends Exception {
    public final int zza;
    public final boolean zzb;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzph(int i, int i2, int i3, int i4, zzaf zzafVar, boolean z, Exception exc) {
        String strValueOf = String.valueOf(zzafVar);
        StringBuilder sbN = uo.n("AudioTrack init failed ", i, " Config(", i2, ", ");
        sbN.append(i3);
        sbN.append(", ");
        sbN.append(i4);
        sbN.append(") ");
        sbN.append(strValueOf);
        sbN.append(true != z ? "" : " (recoverable)");
        super(sbN.toString(), exc);
        this.zza = i;
        this.zzb = z;
    }
}
