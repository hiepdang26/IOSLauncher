package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzahv extends zzahx {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzahv(int i, long j) {
        super(i);
        this.zza = j;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzahx
    public final String toString() {
        List list = this.zzb;
        return zzahx.zzf(this.zzd) + " leaves: " + Arrays.toString(list.toArray()) + " containers: " + Arrays.toString(this.zzc.toArray());
    }

    public final zzahv zza(int i) {
        int size = this.zzc.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzahv zzahvVar = (zzahv) this.zzc.get(i2);
            if (zzahvVar.zzd == i) {
                return zzahvVar;
            }
        }
        return null;
    }

    public final zzahw zzb(int i) {
        int size = this.zzb.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzahw zzahwVar = (zzahw) this.zzb.get(i2);
            if (zzahwVar.zzd == i) {
                return zzahwVar;
            }
        }
        return null;
    }

    public final void zzc(zzahv zzahvVar) {
        this.zzc.add(zzahvVar);
    }

    public final void zzd(zzahw zzahwVar) {
        this.zzb.add(zzahwVar);
    }
}
