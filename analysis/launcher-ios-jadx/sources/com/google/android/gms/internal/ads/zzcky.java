package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import defpackage.cd2;
import defpackage.gy0;
import defpackage.h82;
import defpackage.hd2;
import defpackage.he0;
import defpackage.hg0;
import defpackage.ib2;
import defpackage.j72;
import defpackage.k92;
import defpackage.n42;
import defpackage.o32;
import defpackage.or1;
import defpackage.ra2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcky extends j72 {
    private final Context zza;
    private final or1 zzb;
    private final zzdqb zzc;
    private final zzeev zzd;
    private final zzelg zze;
    private final zzdun zzf;
    private final zzbya zzg;
    private final zzdqg zzh;
    private final zzdvi zzi;
    private final zzbel zzj;
    private final zzfki zzk;
    private final zzfgc zzl;
    private final zzcui zzm;
    private final zzdsk zzn;
    private boolean zzo = false;
    private final Long zzp;

    public zzcky(Context context, or1 or1Var, zzdqb zzdqbVar, zzeev zzeevVar, zzelg zzelgVar, zzdun zzdunVar, zzbya zzbyaVar, zzdqg zzdqgVar, zzdvi zzdviVar, zzbel zzbelVar, zzfki zzfkiVar, zzfgc zzfgcVar, zzcui zzcuiVar, zzdsk zzdskVar) {
        this.zza = context;
        this.zzb = or1Var;
        this.zzc = zzdqbVar;
        this.zzd = zzeevVar;
        this.zze = zzelgVar;
        this.zzf = zzdunVar;
        this.zzg = zzbyaVar;
        this.zzh = zzdqgVar;
        this.zzi = zzdviVar;
        this.zzj = zzbelVar;
        this.zzk = zzfkiVar;
        this.zzl = zzfgcVar;
        this.zzm = zzcuiVar;
        this.zzn = zzdskVar;
        hd2.B.j.getClass();
        this.zzp = Long.valueOf(SystemClock.elapsedRealtime());
    }

    public final void zzb() {
        String str;
        hd2 hd2Var = hd2.B;
        if (((ib2) hd2Var.g.zzi()).p()) {
            ib2 ib2Var = (ib2) hd2Var.g.zzi();
            ib2Var.r();
            synchronized (ib2Var.a) {
                str = ib2Var.z;
            }
            if (hd2Var.m.i(this.zza, str, this.zzb.g)) {
                return;
            }
            ((ib2) hd2Var.g.zzi()).b(false);
            ((ib2) hd2Var.g.zzi()).a("");
        }
    }

    public final void zzc(Runnable runnable) {
        hg0.g("Adapters must be initialized on the main thread.");
        Map mapZze = ((ib2) hd2.B.g.zzi()).x().zze();
        if (mapZze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
                k92.j(5);
                return;
            }
        }
        if (this.zzc.zzd()) {
            HashMap map = new HashMap();
            Iterator it = mapZze.values().iterator();
            while (it.hasNext()) {
                for (zzbof zzbofVar : ((zzbog) it.next()).zza) {
                    String str = zzbofVar.zzb;
                    for (String str2 : zzbofVar.zza) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzeew zzeewVarZza = this.zzd.zza(str3, jSONObject);
                    if (zzeewVarZza != null) {
                        zzfge zzfgeVar = (zzfge) zzeewVarZza.zzb;
                        if (!zzfgeVar.zzC() && zzfgeVar.zzB()) {
                            zzfgeVar.zzj(this.zza, (zzegq) zzeewVarZza.zzc, (List) entry.getValue());
                            k92.d("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzffn unused2) {
                    k92.j(5);
                }
            }
        }
    }

    public final /* synthetic */ void zzd() {
        zzfgl.zzb(this.zza, true);
    }

    @Override // defpackage.l72
    public final synchronized float zze() {
        return hd2.B.h.a();
    }

    @Override // defpackage.l72
    public final String zzf() {
        return this.zzb.g;
    }

    @Override // defpackage.l72
    public final List zzg() {
        return this.zzf.zzg();
    }

    @Override // defpackage.l72
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // defpackage.l72
    public final void zzi() {
        this.zzf.zzl();
    }

    @Override // defpackage.l72
    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfsc.zzi(this.zza).zzn(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    @Override // defpackage.l72
    public final synchronized void zzk() {
        if (this.zzo) {
            k92.h("Mobile ads is initialized already.");
            return;
        }
        zzbbw.zza(this.zza);
        Context context = this.zza;
        or1 or1Var = this.zzb;
        hd2 hd2Var = hd2.B;
        hd2Var.g.zzu(context, or1Var);
        this.zzm.zzd();
        hd2Var.i.zzi(this.zza);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zze();
        zzbbn zzbbnVar = zzbbw.zzdE;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) n42Var.c.zza(zzbbw.zzip)).booleanValue()) {
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckt
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzjY)).booleanValue()) {
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw();
                }
            });
        }
        if (((Boolean) n42Var.c.zza(zzbbw.zzcA)).booleanValue()) {
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcku
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.l72
    public final void zzl(String str, he0 he0Var) {
        String strE;
        Runnable runnable;
        zzbbw.zza(this.zza);
        if (((Boolean) n42.d.c.zza(zzbbw.zzdI)).booleanValue()) {
            try {
                cd2 cd2Var = hd2.B.c;
                strE = cd2.E(this.zza);
            } catch (RemoteException | RuntimeException e) {
                hd2.B.g.zzw(e, "NonagonMobileAdsSettingManager_AppId");
                strE = "";
            }
        } else {
            strE = "";
        }
        boolean z = true;
        String str2 = true == TextUtils.isEmpty(strE) ? str : strE;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbbn zzbbnVar = zzbbw.zzdC;
        n42 n42Var = n42.d;
        boolean zBooleanValue = ((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue();
        zzbbn zzbbnVar2 = zzbbw.zzaH;
        zzbbu zzbbuVar = n42Var.c;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue();
        if (((Boolean) zzbbuVar.zza(zzbbnVar2)).booleanValue()) {
            final Runnable runnable2 = (Runnable) gy0.r(he0Var);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzckw
                @Override // java.lang.Runnable
                public final void run() {
                    zzgcu zzgcuVar = zzbzo.zze;
                    final zzcky zzckyVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckx
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzckyVar.zzc(runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z = zBooleanValue2;
        }
        zzckw zzckwVar = runnable;
        if (z) {
            hd2.B.k.i(this.zza, this.zzb, true, null, str2, null, zzckwVar, this.zzk, this.zzn, this.zzp);
        }
    }

    @Override // defpackage.l72
    public final void zzm(h82 h82Var) {
        this.zzi.zzh(h82Var, zzdvh.API);
    }

    @Override // defpackage.l72
    public final void zzn(he0 he0Var, String str) {
        if (he0Var == null) {
            k92.e("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) gy0.r(he0Var);
        if (context == null) {
            k92.e("Context is null. Failed to open debug menu.");
            return;
        }
        o32 o32Var = new o32(context);
        o32Var.d = str;
        o32Var.e = this.zzb.g;
        o32Var.b();
    }

    @Override // defpackage.l72
    public final void zzo(zzbom zzbomVar) {
        this.zzl.zzf(zzbomVar);
    }

    @Override // defpackage.l72
    public final synchronized void zzp(boolean z) {
        hd2.B.h.b(z);
    }

    @Override // defpackage.l72
    public final synchronized void zzq(float f) {
        hd2.B.h.c(f);
    }

    @Override // defpackage.l72
    public final synchronized void zzr(String str) {
        zzbbw.zza(this.zza);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzdC)).booleanValue()) {
                hd2.B.k.i(this.zza, this.zzb, true, null, str, null, null, this.zzk, null, null);
            }
        }
    }

    @Override // defpackage.l72
    public final void zzs(zzblc zzblcVar) {
        this.zzf.zzs(zzblcVar);
    }

    @Override // defpackage.l72
    public final void zzt(String str) {
        if (((Boolean) n42.d.c.zza(zzbbw.zziA)).booleanValue()) {
            hd2.B.g.zzz(str);
        }
    }

    @Override // defpackage.l72
    public final void zzu(ra2 ra2Var) {
        this.zzg.zzn(this.zza, ra2Var);
    }

    @Override // defpackage.l72
    public final synchronized boolean zzv() {
        return hd2.B.h.d();
    }

    public final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbtv());
    }
}
