package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.hd2;
import defpackage.ib2;
import defpackage.k92;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaym {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final zzayl zza(boolean z) {
        synchronized (this.zzb) {
            try {
                zzayl zzaylVar = null;
                if (this.zzc.isEmpty()) {
                    k92.d("Queue empty");
                    return null;
                }
                int i = 0;
                if (this.zzc.size() < 2) {
                    zzayl zzaylVar2 = (zzayl) this.zzc.get(0);
                    if (z) {
                        this.zzc.remove(0);
                    } else {
                        zzaylVar2.zzi();
                    }
                    return zzaylVar2;
                }
                int i2 = RtlSpacingHelper.UNDEFINED;
                int i3 = 0;
                for (zzayl zzaylVar3 : this.zzc) {
                    int iZzb = zzaylVar3.zzb();
                    if (iZzb > i2) {
                        i = i3;
                    }
                    int i4 = iZzb > i2 ? iZzb : i2;
                    if (iZzb > i2) {
                        zzaylVar = zzaylVar3;
                    }
                    i3++;
                    i2 = i4;
                }
                this.zzc.remove(i);
                return zzaylVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(zzayl zzaylVar) {
        synchronized (this.zzb) {
            try {
                if (this.zzc.size() >= 10) {
                    k92.d("Queue is full, current size = " + this.zzc.size());
                    this.zzc.remove(0);
                }
                int i = this.zza;
                this.zza = i + 1;
                zzaylVar.zzj(i);
                zzaylVar.zzn();
                this.zzc.add(zzaylVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(zzayl zzaylVar) {
        synchronized (this.zzb) {
            try {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    zzayl zzaylVar2 = (zzayl) it.next();
                    hd2 hd2Var = hd2.B;
                    if (((ib2) hd2Var.g.zzi()).n()) {
                        if (!((ib2) hd2Var.g.zzi()).o() && !zzaylVar.equals(zzaylVar2) && zzaylVar2.zzf().equals(zzaylVar.zzf())) {
                            it.remove();
                            return true;
                        }
                    } else if (!zzaylVar.equals(zzaylVar2) && zzaylVar2.zzd().equals(zzaylVar.zzd())) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzd(zzayl zzaylVar) {
        synchronized (this.zzb) {
            try {
                return this.zzc.contains(zzaylVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
