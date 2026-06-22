package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzfml {
    private static final zzfml zza = new zzfml();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfml() {
    }

    public static zzfml zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzflu zzfluVar) {
        this.zzb.add(zzfluVar);
    }

    public final void zze(zzflu zzfluVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzfluVar);
        this.zzc.remove(zzfluVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzfmt.zzb().zzg();
    }

    public final void zzf(zzflu zzfluVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzfluVar);
        if (zZzg) {
            return;
        }
        zzfmt.zzb().zzf();
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
