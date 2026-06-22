package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.n42;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzezb implements zzhfc {
    public static zzevr zza(Context context, zzbys zzbysVar, zzbyt zzbytVar, Object obj, zzewu zzewuVar, zzeyh zzeyhVar, zzhew zzhewVar, zzhew zzhewVar2, zzhew zzhewVar3, zzhew zzhewVar4, zzhew zzhewVar5, zzhew zzhewVar6, zzhew zzhewVar7, zzhew zzhewVar8, Executor executor, zzfkf zzfkfVar, zzdsk zzdskVar) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzeya) obj);
        hashSet.add(zzewuVar);
        hashSet.add(zzeyhVar);
        zzbbn zzbbnVar = zzbbw.zzff;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            hashSet.add((zzevo) zzhewVar.zzb());
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzfg)).booleanValue()) {
            hashSet.add((zzevo) zzhewVar2.zzb());
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzfh)).booleanValue()) {
            hashSet.add((zzevo) zzhewVar3.zzb());
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzfj)).booleanValue()) {
            hashSet.add((zzevo) zzhewVar5.zzb());
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzfk)).booleanValue()) {
            hashSet.add((zzevo) zzhewVar6.zzb());
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzcC)).booleanValue()) {
            hashSet.add((zzevo) zzhewVar8.zzb());
        }
        return new zzevr(context, executor, hashSet, zzfkfVar, zzdskVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
