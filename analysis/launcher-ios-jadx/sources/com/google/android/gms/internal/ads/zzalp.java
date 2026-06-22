package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzalp implements Comparable {
    public final int zza;
    public final zzalj zzb;

    public zzalp(int i, zzalj zzaljVar) {
        this.zza = i;
        this.zzb = zzaljVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzalp) obj).zza);
    }
}
