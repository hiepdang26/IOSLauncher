package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import defpackage.do0;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.ug1;
import defpackage.v92;
import defpackage.x82;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjb {
    private int zza;
    private x82 zzb;
    private zzbew zzc;
    private View zzd;
    private List zze;
    private v92 zzg;
    private Bundle zzh;
    private zzcej zzi;
    private zzcej zzj;
    private zzcej zzk;
    private zzeeo zzl;
    private do0 zzm;
    private zzbzt zzn;
    private View zzo;
    private View zzp;
    private he0 zzq;
    private double zzr;
    private zzbfd zzs;
    private zzbfd zzt;
    private String zzu;
    private float zzx;
    private String zzy;
    private final ug1 zzv = new ug1(0);
    private final ug1 zzw = new ug1(0);
    private List zzf = Collections.EMPTY_LIST;

    public static zzdjb zzag(zzbox zzboxVar) {
        zzdjb zzdjbVar;
        zzdja zzdjaVarZzak;
        zzbew zzbewVarZzh;
        View view;
        String strZzo;
        List listZzr;
        String strZzm;
        Bundle bundleZzf;
        String strZzn;
        View view2;
        he0 he0VarZzl;
        String strZzq;
        String strZzp;
        double dZze;
        zzbfd zzbfdVarZzi;
        try {
            zzdjaVarZzak = zzak(zzboxVar.zzg(), null);
            zzbewVarZzh = zzboxVar.zzh();
            view = (View) zzam(zzboxVar.zzj());
            strZzo = zzboxVar.zzo();
            listZzr = zzboxVar.zzr();
            strZzm = zzboxVar.zzm();
            bundleZzf = zzboxVar.zzf();
            strZzn = zzboxVar.zzn();
            view2 = (View) zzam(zzboxVar.zzk());
            he0VarZzl = zzboxVar.zzl();
            strZzq = zzboxVar.zzq();
            strZzp = zzboxVar.zzp();
            dZze = zzboxVar.zze();
            zzbfdVarZzi = zzboxVar.zzi();
            zzdjbVar = null;
        } catch (RemoteException unused) {
            zzdjbVar = null;
        }
        try {
            zzdjb zzdjbVar2 = new zzdjb();
            zzdjbVar2.zza = 2;
            zzdjbVar2.zzb = zzdjaVarZzak;
            zzdjbVar2.zzc = zzbewVarZzh;
            zzdjbVar2.zzd = view;
            zzdjbVar2.zzZ("headline", strZzo);
            zzdjbVar2.zze = listZzr;
            zzdjbVar2.zzZ("body", strZzm);
            zzdjbVar2.zzh = bundleZzf;
            zzdjbVar2.zzZ("call_to_action", strZzn);
            zzdjbVar2.zzo = view2;
            zzdjbVar2.zzq = he0VarZzl;
            zzdjbVar2.zzZ("store", strZzq);
            zzdjbVar2.zzZ("price", strZzp);
            zzdjbVar2.zzr = dZze;
            zzdjbVar2.zzs = zzbfdVarZzi;
            return zzdjbVar2;
        } catch (RemoteException unused2) {
            k92.j(5);
            return zzdjbVar;
        }
    }

    public static zzdjb zzah(zzboy zzboyVar) {
        try {
            zzdja zzdjaVarZzak = zzak(zzboyVar.zzf(), null);
            zzbew zzbewVarZzg = zzboyVar.zzg();
            View view = (View) zzam(zzboyVar.zzi());
            String strZzo = zzboyVar.zzo();
            List listZzp = zzboyVar.zzp();
            String strZzm = zzboyVar.zzm();
            Bundle bundleZze = zzboyVar.zze();
            String strZzn = zzboyVar.zzn();
            View view2 = (View) zzam(zzboyVar.zzj());
            he0 he0VarZzk = zzboyVar.zzk();
            String strZzl = zzboyVar.zzl();
            zzbfd zzbfdVarZzh = zzboyVar.zzh();
            zzdjb zzdjbVar = new zzdjb();
            zzdjbVar.zza = 1;
            zzdjbVar.zzb = zzdjaVarZzak;
            zzdjbVar.zzc = zzbewVarZzg;
            zzdjbVar.zzd = view;
            zzdjbVar.zzZ("headline", strZzo);
            zzdjbVar.zze = listZzp;
            zzdjbVar.zzZ("body", strZzm);
            zzdjbVar.zzh = bundleZze;
            zzdjbVar.zzZ("call_to_action", strZzn);
            zzdjbVar.zzo = view2;
            zzdjbVar.zzq = he0VarZzk;
            zzdjbVar.zzZ("advertiser", strZzl);
            zzdjbVar.zzt = zzbfdVarZzh;
            return zzdjbVar;
        } catch (RemoteException unused) {
            k92.j(5);
            return null;
        }
    }

    public static zzdjb zzai(zzbox zzboxVar) {
        try {
            return zzal(zzak(zzboxVar.zzg(), null), zzboxVar.zzh(), (View) zzam(zzboxVar.zzj()), zzboxVar.zzo(), zzboxVar.zzr(), zzboxVar.zzm(), zzboxVar.zzf(), zzboxVar.zzn(), (View) zzam(zzboxVar.zzk()), zzboxVar.zzl(), zzboxVar.zzq(), zzboxVar.zzp(), zzboxVar.zze(), zzboxVar.zzi(), null, 0.0f);
        } catch (RemoteException unused) {
            k92.j(5);
            return null;
        }
    }

    public static zzdjb zzaj(zzboy zzboyVar) {
        try {
            return zzal(zzak(zzboyVar.zzf(), null), zzboyVar.zzg(), (View) zzam(zzboyVar.zzi()), zzboyVar.zzo(), zzboyVar.zzp(), zzboyVar.zzm(), zzboyVar.zze(), zzboyVar.zzn(), (View) zzam(zzboyVar.zzj()), zzboyVar.zzk(), null, null, -1.0d, zzboyVar.zzh(), zzboyVar.zzl(), 0.0f);
        } catch (RemoteException unused) {
            k92.j(5);
            return null;
        }
    }

    private static zzdja zzak(x82 x82Var, zzbpb zzbpbVar) {
        if (x82Var == null) {
            return null;
        }
        return new zzdja(x82Var, zzbpbVar);
    }

    private static zzdjb zzal(x82 x82Var, zzbew zzbewVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, he0 he0Var, String str4, String str5, double d, zzbfd zzbfdVar, String str6, float f) {
        zzdjb zzdjbVar = new zzdjb();
        zzdjbVar.zza = 6;
        zzdjbVar.zzb = x82Var;
        zzdjbVar.zzc = zzbewVar;
        zzdjbVar.zzd = view;
        zzdjbVar.zzZ("headline", str);
        zzdjbVar.zze = list;
        zzdjbVar.zzZ("body", str2);
        zzdjbVar.zzh = bundle;
        zzdjbVar.zzZ("call_to_action", str3);
        zzdjbVar.zzo = view2;
        zzdjbVar.zzq = he0Var;
        zzdjbVar.zzZ("store", str4);
        zzdjbVar.zzZ("price", str5);
        zzdjbVar.zzr = d;
        zzdjbVar.zzs = zzbfdVar;
        zzdjbVar.zzZ("advertiser", str6);
        zzdjbVar.zzR(f);
        return zzdjbVar;
    }

    private static Object zzam(he0 he0Var) {
        if (he0Var == null) {
            return null;
        }
        return gy0.r(he0Var);
    }

    public static zzdjb zzt(zzbpb zzbpbVar) {
        try {
            return zzal(zzak(zzbpbVar.zzj(), zzbpbVar), zzbpbVar.zzk(), (View) zzam(zzbpbVar.zzm()), zzbpbVar.zzs(), zzbpbVar.zzv(), zzbpbVar.zzq(), zzbpbVar.zzi(), zzbpbVar.zzr(), (View) zzam(zzbpbVar.zzn()), zzbpbVar.zzo(), zzbpbVar.zzu(), zzbpbVar.zzt(), zzbpbVar.zze(), zzbpbVar.zzl(), zzbpbVar.zzp(), zzbpbVar.zzf());
        } catch (RemoteException unused) {
            k92.j(5);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF("price");
    }

    public final synchronized String zzE() {
        return zzF("store");
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        try {
            zzcej zzcejVar = this.zzi;
            if (zzcejVar != null) {
                zzcejVar.destroy();
                this.zzi = null;
            }
            zzcej zzcejVar2 = this.zzj;
            if (zzcejVar2 != null) {
                zzcejVar2.destroy();
                this.zzj = null;
            }
            zzcej zzcejVar3 = this.zzk;
            if (zzcejVar3 != null) {
                zzcejVar3.destroy();
                this.zzk = null;
            }
            do0 do0Var = this.zzm;
            if (do0Var != null) {
                do0Var.cancel(false);
                this.zzm = null;
            }
            zzbzt zzbztVar = this.zzn;
            if (zzbztVar != null) {
                zzbztVar.cancel(false);
                this.zzn = null;
            }
            this.zzl = null;
            this.zzv.clear();
            this.zzw.clear();
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzh = null;
            this.zzo = null;
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            this.zzt = null;
            this.zzu = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzJ(zzbew zzbewVar) {
        this.zzc = zzbewVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(v92 v92Var) {
        this.zzg = v92Var;
    }

    public final synchronized void zzM(zzbfd zzbfdVar) {
        this.zzs = zzbfdVar;
    }

    public final synchronized void zzN(String str, zzbeq zzbeqVar) {
        if (zzbeqVar == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbeqVar);
        }
    }

    public final synchronized void zzO(zzcej zzcejVar) {
        this.zzj = zzcejVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbfd zzbfdVar) {
        this.zzt = zzbfdVar;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcej zzcejVar) {
        this.zzk = zzcejVar;
    }

    public final synchronized void zzU(do0 do0Var) {
        this.zzm = do0Var;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzeeo zzeeoVar) {
        this.zzl = zzeeoVar;
    }

    public final synchronized void zzX(zzbzt zzbztVar) {
        this.zzn = zzbztVar;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(x82 x82Var) {
        this.zzb = x82Var;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcej zzcejVar) {
        this.zzi = zzcejVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        try {
            if (this.zzh == null) {
                this.zzh = new Bundle();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized ug1 zzh() {
        return this.zzv;
    }

    public final synchronized ug1 zzi() {
        return this.zzw;
    }

    public final synchronized x82 zzj() {
        return this.zzb;
    }

    public final synchronized v92 zzk() {
        return this.zzg;
    }

    public final synchronized zzbew zzl() {
        return this.zzc;
    }

    public final zzbfd zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbfc.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbfd zzn() {
        return this.zzs;
    }

    public final synchronized zzbfd zzo() {
        return this.zzt;
    }

    public final synchronized zzbzt zzp() {
        return this.zzn;
    }

    public final synchronized zzcej zzq() {
        return this.zzj;
    }

    public final synchronized zzcej zzr() {
        return this.zzk;
    }

    public final synchronized zzcej zzs() {
        return this.zzi;
    }

    public final synchronized zzeeo zzu() {
        return this.zzl;
    }

    public final synchronized he0 zzv() {
        return this.zzq;
    }

    public final synchronized do0 zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
