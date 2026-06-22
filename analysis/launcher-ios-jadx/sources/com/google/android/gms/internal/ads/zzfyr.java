package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
final class zzfyr extends zzfyv {
    final /* synthetic */ Comparator zza;

    public zzfyr(Comparator comparator) {
        this.zza = comparator;
    }

    @Override // com.google.android.gms.internal.ads.zzfyv
    public final Map zza() {
        return new TreeMap(this.zza);
    }
}
