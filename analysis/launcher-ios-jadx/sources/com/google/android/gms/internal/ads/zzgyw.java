package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzgyw {
    public static final List zza(Object obj, long j) {
        zzgyk zzgykVar = (zzgyk) zzhaz.zzh(obj, j);
        if (zzgykVar.zzc()) {
            return zzgykVar;
        }
        int size = zzgykVar.size();
        zzgyk zzgykVarZzf = zzgykVar.zzf(size == 0 ? 10 : size + size);
        zzhaz.zzv(obj, j, zzgykVarZzf);
        return zzgykVarZzf;
    }
}
