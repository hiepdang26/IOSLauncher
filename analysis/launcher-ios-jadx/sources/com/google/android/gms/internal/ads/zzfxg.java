package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfxg {
    private static final zzfxg zza = new zzfxd();
    private static final zzfxg zzb = new zzfxe(-1);
    private static final zzfxg zzc = new zzfxe(1);

    public /* synthetic */ zzfxg(zzfxf zzfxfVar) {
    }

    public static zzfxg zzj() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfxg zzb(int i, int i2);

    public abstract zzfxg zzc(Object obj, Object obj2, Comparator comparator);

    public abstract zzfxg zzd(boolean z, boolean z2);

    public abstract zzfxg zze(boolean z, boolean z2);
}
