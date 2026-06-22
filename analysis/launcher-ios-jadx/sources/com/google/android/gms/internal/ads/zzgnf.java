package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnf {
    private final Class zza;
    private zzgnh zzd;
    private Map zzb = new HashMap();
    private final List zzc = new ArrayList();
    private zzgln zze = zzgln.zza;

    public /* synthetic */ zzgnf(Class cls, zzgne zzgneVar) {
        this.zza = cls;
    }

    private final zzgnf zze(Object obj, zzgdy zzgdyVar, zzgtg zzgtgVar, boolean z) throws GeneralSecurityException {
        byte[] bArrZzc;
        if (this.zzb == null) {
            throw new IllegalStateException("addEntry cannot be called after build");
        }
        if (zzgtgVar.zzk() != 3) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        int iOrdinal = zzgtgVar.zzf().ordinal();
        if (iOrdinal == 1) {
            bArrZzc = zzgml.zzb(zzgtgVar.zza()).zzc();
        } else if (iOrdinal == 2) {
            bArrZzc = zzgml.zza(zzgtgVar.zza()).zzc();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzc = zzgml.zza(zzgtgVar.zza()).zzc();
        } else {
            bArrZzc = zzgdt.zza;
        }
        zzgnh zzgnhVar = new zzgnh(obj, zzgvr.zzb(bArrZzc), zzgtgVar.zzk(), zzgtgVar.zzf(), zzgtgVar.zza(), zzgtgVar.zzc().zzg(), zzgdyVar, null);
        Map map = this.zzb;
        List list = this.zzc;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzgnhVar);
        List list2 = (List) map.put(zzgnhVar.zzb, Collections.unmodifiableList(arrayList));
        if (list2 != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list2);
            arrayList2.add(zzgnhVar);
            map.put(zzgnhVar.zzb, Collections.unmodifiableList(arrayList2));
        }
        list.add(zzgnhVar);
        if (!z) {
            return this;
        }
        if (this.zzd != null) {
            throw new IllegalStateException("you cannot set two primary primitives");
        }
        this.zzd = zzgnhVar;
        return this;
    }

    public final zzgnf zza(Object obj, zzgdy zzgdyVar, zzgtg zzgtgVar) {
        zze(obj, zzgdyVar, zzgtgVar, false);
        return this;
    }

    public final zzgnf zzb(Object obj, zzgdy zzgdyVar, zzgtg zzgtgVar) {
        zze(obj, zzgdyVar, zzgtgVar, true);
        return this;
    }

    public final zzgnf zzc(zzgln zzglnVar) {
        if (this.zzb == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        this.zze = zzglnVar;
        return this;
    }

    public final zzgnj zzd() {
        Map map = this.zzb;
        if (map == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzgnj zzgnjVar = new zzgnj(map, this.zzc, this.zzd, this.zze, this.zza, null);
        this.zzb = null;
        return zzgnjVar;
    }
}
