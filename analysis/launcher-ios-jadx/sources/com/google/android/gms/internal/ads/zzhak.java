package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzhak implements Iterator {
    final /* synthetic */ zzhao zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzhak(zzhao zzhaoVar, zzhaj zzhajVar) {
        this.zza = zzhaoVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzb.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb + 1 >= this.zza.zza.size()) {
            return !this.zza.zzb.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return i < this.zza.zza.size() ? (Map.Entry) this.zza.zza.get(this.zzb) : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzn();
        if (this.zzb >= this.zza.zza.size()) {
            zza().remove();
            return;
        }
        zzhao zzhaoVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zzhaoVar.zzl(i);
    }
}
