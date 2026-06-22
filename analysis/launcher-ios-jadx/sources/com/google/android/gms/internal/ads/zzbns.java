package com.google.android.gms.internal.ads;

import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbns implements zzbne {
    private final zzbng zza;
    private final zzbnh zzb;
    private final zzbna zzc;
    private final String zzd;

    public zzbns(zzbna zzbnaVar, String str, zzbnh zzbnhVar, zzbng zzbngVar) {
        this.zzc = zzbnaVar;
        this.zzd = str;
        this.zzb = zzbnhVar;
        this.zza = zzbngVar;
    }

    public static void zzd(zzbns zzbnsVar, zzbmu zzbmuVar, zzbnb zzbnbVar, Object obj, zzbzt zzbztVar) {
        try {
            cd2 cd2Var = hd2.B.c;
            String string = UUID.randomUUID().toString();
            zzbiw.zzo.zzc(string, new zzbnr(zzbnsVar, zzbmuVar, zzbztVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", string);
            jSONObject.put("args", zzbnsVar.zzb.zzb(obj));
            zzbnbVar.zzl(zzbnsVar.zzd, jSONObject);
        } catch (Exception e) {
            try {
                zzbztVar.zzd(e);
                k92.f();
            } finally {
                zzbmuVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbq
    public final do0 zza(Object obj) {
        return zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbne
    public final do0 zzb(Object obj) {
        zzbzt zzbztVar = new zzbzt();
        zzbmu zzbmuVarZzb = this.zzc.zzb(null);
        k92.a("callJs > getEngine: Promise created");
        zzbmuVarZzb.zzj(new zzbnp(this, zzbmuVarZzb, obj, zzbztVar), new zzbnq(this, zzbztVar, zzbmuVarZzb));
        return zzbztVar;
    }
}
