package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzaln {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzall
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((zzaln) obj).zzb.zzb, ((zzaln) obj2).zzb.zzb);
        }
    };
    private final zzalo zzb;
    private final int zzc;

    public /* synthetic */ zzaln(zzalo zzaloVar, int i, zzalm zzalmVar) {
        this.zzb = zzaloVar;
        this.zzc = i;
    }
}
