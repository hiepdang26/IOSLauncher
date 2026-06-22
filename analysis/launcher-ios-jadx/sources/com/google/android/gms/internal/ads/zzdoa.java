package com.google.android.gms.internal.ads;

import android.content.Context;
import defpackage.a22;
import defpackage.do0;
import defpackage.h42;
import defpackage.hd2;
import defpackage.n42;
import defpackage.or1;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdoa {
    private final a22 zzb;
    private final Context zzc;
    private final zzdsk zzd;
    private final Executor zze;
    private final zzauo zzf;
    private final or1 zzg;
    private final zzedh zzi;
    private final zzfll zzj;
    private final zzeds zzk;
    private final zzffk zzl;
    private do0 zzm;
    private final zzdnn zza = new zzdnn();
    private final zzbjn zzh = new zzbjn();

    public zzdoa(zzdnx zzdnxVar) {
        this.zzc = zzdnxVar.zzb;
        this.zze = zzdnxVar.zze;
        this.zzf = zzdnxVar.zzf;
        this.zzg = zzdnxVar.zzg;
        this.zzb = zzdnxVar.zza;
        this.zzi = zzdnxVar.zzd;
        this.zzj = zzdnxVar.zzh;
        this.zzd = zzdnxVar.zzc;
        this.zzk = zzdnxVar.zzi;
        this.zzl = zzdnxVar.zzj;
    }

    public final /* synthetic */ zzcej zza(zzcej zzcejVar) {
        zzcejVar.zzag("/result", this.zzh);
        zzcgb zzcgbVarZzN = zzcejVar.zzN();
        h42 h42Var = new h42(this.zzc, null);
        zzedh zzedhVar = this.zzi;
        zzfll zzfllVar = this.zzj;
        zzdsk zzdskVar = this.zzd;
        zzdnn zzdnnVar = this.zza;
        zzcgbVarZzN.zzR(null, zzdnnVar, zzdnnVar, zzdnnVar, zzdnnVar, false, null, h42Var, null, null, zzedhVar, zzfllVar, zzdskVar, null, null, null, null, null, null);
        return zzcejVar;
    }

    public final /* synthetic */ do0 zzf(String str, JSONObject jSONObject, zzcej zzcejVar) {
        return this.zzh.zzb(zzcejVar, str, jSONObject);
    }

    public final synchronized do0 zzg(final String str, final JSONObject jSONObject) {
        do0 do0Var = this.zzm;
        if (do0Var == null) {
            return zzgcj.zzh(null);
        }
        return zzgcj.zzn(do0Var, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdno
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzf(str, jSONObject, (zzcej) obj);
            }
        }, this.zze);
    }

    public final synchronized void zzh(zzfel zzfelVar, zzfeo zzfeoVar, zzcni zzcniVar) {
        do0 do0Var = this.zzm;
        if (do0Var == null) {
            return;
        }
        zzgcj.zzr(do0Var, new zzdnu(this, zzfelVar, zzfeoVar, zzcniVar), this.zze);
    }

    public final synchronized void zzi() {
        do0 do0Var = this.zzm;
        if (do0Var == null) {
            return;
        }
        zzgcj.zzr(do0Var, new zzdnq(this), this.zze);
        this.zzm = null;
    }

    public final synchronized void zzj(String str, Map map) {
        do0 do0Var = this.zzm;
        if (do0Var == null) {
            return;
        }
        zzgcj.zzr(do0Var, new zzdnt(this, "sendMessageToNativeJs", map), this.zze);
    }

    public final synchronized void zzk() {
        final String str = (String) n42.d.c.zza(zzbbw.zzdr);
        final Context context = this.zzc;
        final zzauo zzauoVar = this.zzf;
        final or1 or1Var = this.zzg;
        final a22 a22Var = this.zzb;
        final zzeds zzedsVar = this.zzk;
        final zzffk zzffkVar = this.zzl;
        do0 do0VarZzm = zzgcj.zzm(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzceu
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final do0 zza() throws zzcev {
                zzcew zzcewVar = hd2.B.d;
                Context context2 = context;
                zzcgd zzcgdVarZza = zzcgd.zza();
                zzauo zzauoVar2 = zzauoVar;
                zzeds zzedsVar2 = zzedsVar;
                a22 a22Var2 = a22Var;
                zzcej zzcejVarZza = zzcew.zza(context2, zzcgdVarZza, "", false, false, zzauoVar2, null, or1Var, null, null, a22Var2, zzbav.zza(), null, null, zzedsVar2, zzffkVar);
                final zzbzs zzbzsVarZza = zzbzs.zza((Object) zzcejVarZza);
                zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzcet
                    @Override // com.google.android.gms.internal.ads.zzcfz
                    public final void zza(boolean z, int i, String str2, String str3) {
                        zzbzsVarZza.zzb();
                    }
                });
                zzcejVarZza.loadUrl(str);
                return zzbzsVarZza;
            }
        }, zzbzo.zze), new zzful() { // from class: com.google.android.gms.internal.ads.zzdnp
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                zzcej zzcejVar = (zzcej) obj;
                this.zza.zza(zzcejVar);
                return zzcejVar;
            }
        }, this.zze);
        this.zzm = do0VarZzm;
        zzbzr.zza(do0VarZzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzbix zzbixVar) {
        do0 do0Var = this.zzm;
        if (do0Var == null) {
            return;
        }
        zzgcj.zzr(do0Var, new zzdnr(this, str, zzbixVar), this.zze);
    }

    public final void zzm(WeakReference weakReference, String str, zzbix zzbixVar) {
        zzl(str, new zzdnz(this, weakReference, str, zzbixVar, null));
    }

    public final synchronized void zzn(String str, zzbix zzbixVar) {
        do0 do0Var = this.zzm;
        if (do0Var == null) {
            return;
        }
        zzgcj.zzr(do0Var, new zzdns(this, str, zzbixVar), this.zze);
    }
}
