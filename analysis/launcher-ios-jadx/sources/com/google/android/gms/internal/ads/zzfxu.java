package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfxu implements Map, Serializable {
    private transient zzfxw zza;
    private transient zzfxw zzb;
    private transient zzfxm zzc;

    public static zzfxu zzc(Map map) {
        Set setEntrySet = map.entrySet();
        zzfxt zzfxtVar = new zzfxt(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        zzfxtVar.zzb(setEntrySet);
        return zzfxtVar.zzc();
    }

    public static zzfxu zzd() {
        return zzfzi.zza;
    }

    public static zzfxu zze(Object obj, Object obj2) {
        zzfwo.zzb("dialog_not_shown_reason", obj2);
        return zzfzi.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return zzfyo.zzb(this, obj);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzfzt.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfwo.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public abstract zzfxm zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzfxm values() {
        zzfxm zzfxmVar = this.zzc;
        if (zzfxmVar != null) {
            return zzfxmVar;
        }
        zzfxm zzfxmVarZza = zza();
        this.zzc = zzfxmVarZza;
        return zzfxmVarZza;
    }

    public abstract zzfxw zzf();

    public abstract zzfxw zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzfxw entrySet() {
        zzfxw zzfxwVar = this.zza;
        if (zzfxwVar != null) {
            return zzfxwVar;
        }
        zzfxw zzfxwVarZzf = zzf();
        this.zza = zzfxwVarZzf;
        return zzfxwVarZzf;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzfxw keySet() {
        zzfxw zzfxwVar = this.zzb;
        if (zzfxwVar != null) {
            return zzfxwVar;
        }
        zzfxw zzfxwVarZzg = zzg();
        this.zzb = zzfxwVarZzg;
        return zzfxwVarZzg;
    }
}
