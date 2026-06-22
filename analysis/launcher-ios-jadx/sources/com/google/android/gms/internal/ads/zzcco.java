package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcco implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final zzccn zza(zzcbk zzcbkVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzccn zzccnVar = (zzccn) it.next();
            if (zzccnVar.zza == zzcbkVar) {
                return zzccnVar;
            }
        }
        return null;
    }

    public final void zzb(zzccn zzccnVar) {
        this.zza.add(zzccnVar);
    }

    public final void zzc(zzccn zzccnVar) {
        this.zza.remove(zzccnVar);
    }

    public final boolean zzd(zzcbk zzcbkVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzccn zzccnVar = (zzccn) it.next();
            if (zzccnVar.zza == zzcbkVar) {
                arrayList.add(zzccnVar);
            }
        }
        int i = 0;
        if (arrayList.isEmpty()) {
            return false;
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((zzccn) obj).zzb.zzf();
        }
        return true;
    }
}
