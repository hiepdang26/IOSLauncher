package com.google.android.gms.internal.ads;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfww implements Iterator {
    int zzb;
    int zzc;
    int zzd = -1;
    final /* synthetic */ zzfxa zze;

    public /* synthetic */ zzfww(zzfxa zzfxaVar, zzfwv zzfwvVar) {
        this.zze = zzfxaVar;
        this.zzb = zzfxaVar.zzf;
        this.zzc = zzfxaVar.zze();
    }

    private final void zzb() {
        if (this.zze.zzf != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        zzb();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.zzc;
        this.zzd = i;
        Object objZza = zza(i);
        this.zzc = this.zze.zzf(this.zzc);
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzb();
        zzfuu.zzk(this.zzd >= 0, "no calls to next() since the last call to remove()");
        this.zzb += 32;
        int i = this.zzd;
        zzfxa zzfxaVar = this.zze;
        zzfxaVar.remove(zzfxa.zzg(zzfxaVar, i));
        this.zzc--;
        this.zzd = -1;
    }

    public abstract Object zza(int i);
}
