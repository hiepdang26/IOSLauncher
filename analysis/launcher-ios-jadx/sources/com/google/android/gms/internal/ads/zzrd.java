package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zzrd {
    public final int zza;
    public final zzui zzb;
    private final CopyOnWriteArrayList zzc;

    private zzrd(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzui zzuiVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuiVar;
    }

    public final zzrd zza(int i, zzui zzuiVar) {
        return new zzrd(this.zzc, 0, zzuiVar);
    }

    public final void zzb(Handler handler, zzre zzreVar) {
        this.zzc.add(new zzrc(handler, zzreVar));
    }

    public final void zzc(zzre zzreVar) {
        for (zzrc zzrcVar : this.zzc) {
            if (zzrcVar.zza == zzreVar) {
                this.zzc.remove(zzrcVar);
            }
        }
    }

    public zzrd() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
