package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzfxt {
    Object[] zza;
    int zzb;
    zzfxs zzc;

    public zzfxt() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzfxl.zze(length, i2));
        }
    }

    public final zzfxt zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfwo.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzfxt zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(iterable.size() + this.zzb);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzfxu zzc() {
        zzfxs zzfxsVar = this.zzc;
        if (zzfxsVar != null) {
            throw zzfxsVar.zza();
        }
        zzfzi zzfziVarZzj = zzfzi.zzj(this.zzb, this.zza, this);
        zzfxs zzfxsVar2 = this.zzc;
        if (zzfxsVar2 == null) {
            return zzfziVarZzj;
        }
        throw zzfxsVar2.zza();
    }

    public zzfxt(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
