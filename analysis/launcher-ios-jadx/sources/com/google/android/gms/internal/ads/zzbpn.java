package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import defpackage.at0;
import defpackage.bt0;
import defpackage.gy0;
import defpackage.he0;
import defpackage.k92;
import defpackage.ka2;
import defpackage.ps0;
import defpackage.qs0;
import defpackage.rc2;
import defpackage.rs0;
import defpackage.ss0;
import defpackage.sv0;
import defpackage.tb2;
import defpackage.u2;
import defpackage.us0;
import defpackage.vs0;
import defpackage.w2;
import defpackage.ws0;
import defpackage.x32;
import defpackage.x82;
import defpackage.xp1;
import defpackage.ys0;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpn extends zzboo {
    private final Object zza;
    private zzbpp zzb;
    private zzbvy zzc;
    private he0 zzd;
    private View zze;
    private vs0 zzf;
    private xp1 zzg;
    private sv0 zzh;
    private at0 zzi;
    private us0 zzj;
    private qs0 zzk;
    private final String zzl = "";

    public zzbpn(w2 w2Var) {
        this.zza = w2Var;
    }

    private final Bundle zzV(tb2 tb2Var) {
        Bundle bundle;
        Bundle bundle2 = tb2Var.s;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private final Bundle zzW(String str, tb2 tb2Var, String str2) {
        k92.d("Server parameters: ".concat(String.valueOf(str)));
        Bundle bundle = new Bundle();
        if (str != null) {
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            bundle = bundle2;
        }
        if (this.zza instanceof AdMobAdapter) {
            bundle.putString("adJson", str2);
            if (tb2Var != null) {
                bundle.putInt("tagForChildDirectedTreatment", tb2Var.m);
            }
        }
        bundle.remove("max_ad_content_rating");
        return bundle;
    }

    private static final boolean zzX(tb2 tb2Var) {
        if (tb2Var.l) {
            return true;
        }
        ka2 ka2Var = x32.f.a;
        return ka2.l();
    }

    private static final String zzY(String str, tb2 tb2Var) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return tb2Var.A;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzA(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof w2)) {
            k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting rewarded ad from adapter.");
        try {
            w2 w2Var = (w2) this.zza;
            zzbpl zzbplVar = new zzbpl(this, zzbosVar);
            zzW(str, tb2Var, null);
            zzV(tb2Var);
            zzX(tb2Var);
            Location location = tb2Var.q;
            zzY(str, tb2Var);
            w2Var.loadRewardedAd(new bt0(), zzbplVar);
        } catch (Exception e) {
            k92.f();
            zzboj.zza(he0Var, e, "adapter.loadRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzB(tb2 tb2Var, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof w2) {
            zzA(this.zzd, tb2Var, str, new zzbpq((w2) obj, this.zzc));
            return;
        }
        k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzC(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof w2)) {
            k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting rewarded interstitial ad from adapter.");
        try {
            w2 w2Var = (w2) this.zza;
            zzbpl zzbplVar = new zzbpl(this, zzbosVar);
            zzW(str, tb2Var, null);
            zzV(tb2Var);
            zzX(tb2Var);
            Location location = tb2Var.q;
            zzY(str, tb2Var);
            w2Var.loadRewardedInterstitialAd(new bt0(), zzbplVar);
        } catch (Exception e) {
            zzboj.zza(he0Var, e, "adapter.loadRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzD(he0 he0Var) {
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzE() {
        Object obj = this.zza;
        if (obj instanceof ps0) {
            ((ps0) obj).onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzF() {
        Object obj = this.zza;
        if (obj instanceof ps0) {
            ((ps0) obj).onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzG(boolean z) {
        Object obj = this.zza;
        if (obj instanceof AbstractAdViewAdapter) {
            try {
                ((AbstractAdViewAdapter) obj).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable unused) {
                k92.f();
                return;
            }
        }
        k92.d(AbstractAdViewAdapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzH(he0 he0Var) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof w2) {
            k92.d("Show app open ad from adapter.");
            k92.e("Can not show null mediation app open ad.");
            throw new RemoteException();
        }
        k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzI() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationInterstitialAdapter) {
            k92.d("Showing interstitial from adapter.");
            ((MediationInterstitialAdapter) this.zza).showInterstitial();
            return;
        }
        k92.h(MediationInterstitialAdapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzJ(he0 he0Var) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof w2) || (obj instanceof MediationInterstitialAdapter)) {
            if (obj instanceof MediationInterstitialAdapter) {
                zzI();
                return;
            } else {
                k92.d("Show interstitial ad from adapter.");
                k92.e("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
        k92.h(MediationInterstitialAdapter.class.getCanonicalName() + " or " + w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzK(he0 he0Var) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof w2) {
            k92.d("Show rewarded ad from adapter.");
            k92.e("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
        k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzL() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof w2) {
            k92.e("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
        k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzM() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzN() throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof w2) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.zzc != null;
        }
        Object obj2 = this.zza;
        k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj2.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbox zzO() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzboy zzP() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zze() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzf() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzg() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final x82 zzh() {
        Object obj = this.zza;
        if (obj instanceof AbstractAdViewAdapter) {
            try {
                return ((AbstractAdViewAdapter) obj).getVideoController();
            } catch (Throwable unused) {
                k92.f();
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbfx zzi() {
        zzbfy zzbfyVarZzc;
        zzbpp zzbppVar = this.zzb;
        if (zzbppVar == null || (zzbfyVarZzc = zzbppVar.zzc()) == null) {
            return null;
        }
        return zzbfyVarZzc.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbov zzj() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbpb zzk() {
        xp1 xp1Var;
        xp1 xp1VarZza;
        Object obj = this.zza;
        if (!(obj instanceof MediationNativeAdapter)) {
            if (!(obj instanceof w2) || (xp1Var = this.zzg) == null) {
                return null;
            }
            return new zzbpt(xp1Var);
        }
        zzbpp zzbppVar = this.zzb;
        if (zzbppVar == null || (xp1VarZza = zzbppVar.zza()) == null) {
            return null;
        }
        return new zzbpt(xp1VarZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbra zzl() {
        Object obj = this.zza;
        if (!(obj instanceof w2)) {
            return null;
        }
        ((w2) obj).getVersionInfo();
        return zzbra.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbra zzm() {
        Object obj = this.zza;
        if (!(obj instanceof w2)) {
            return null;
        }
        ((w2) obj).getSDKVersionInfo();
        return zzbra.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final he0 zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            return new gy0(((MediationBannerAdapter) obj).getBannerView());
        }
        if (obj instanceof w2) {
            return new gy0(this.zze);
        }
        k92.h(MediationBannerAdapter.class.getCanonicalName() + " or " + w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzo() {
        Object obj = this.zza;
        if (obj instanceof ps0) {
            ((ps0) obj).onDestroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzp(he0 he0Var, tb2 tb2Var, String str, zzbvy zzbvyVar, String str2) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof w2) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.zzd = he0Var;
            this.zzc = zzbvyVar;
            zzbvyVar.zzl(new gy0(this.zza));
            return;
        }
        Object obj2 = this.zza;
        k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj2.getClass().getCanonicalName());
        throw new RemoteException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    @Override // com.google.android.gms.internal.ads.zzbop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzq(defpackage.he0 r6, com.google.android.gms.internal.ads.zzbkz r7, java.util.List r8) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpn.zzq(he0, com.google.android.gms.internal.ads.zzbkz, java.util.List):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzr(he0 he0Var, zzbvy zzbvyVar, List list) throws RemoteException {
        k92.h("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzs(tb2 tb2Var, String str) throws RemoteException {
        zzB(tb2Var, str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzt(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof w2)) {
            k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting app open ad from adapter.");
        try {
            w2 w2Var = (w2) this.zza;
            zzbpm zzbpmVar = new zzbpm(this, zzbosVar);
            zzW(str, tb2Var, null);
            zzV(tb2Var);
            zzX(tb2Var);
            Location location = tb2Var.q;
            zzY(str, tb2Var);
            w2Var.loadAppOpenAd(new rs0(), zzbpmVar);
        } catch (Exception e) {
            k92.f();
            zzboj.zza(he0Var, e, "adapter.loadAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzu(he0 he0Var, rc2 rc2Var, tb2 tb2Var, String str, zzbos zzbosVar) throws RemoteException {
        zzv(he0Var, rc2Var, tb2Var, str, null, zzbosVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzv(he0 he0Var, rc2 rc2Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar) throws RemoteException {
        u2 u2Var;
        Object obj = this.zza;
        if (!(obj instanceof MediationBannerAdapter) && !(obj instanceof w2)) {
            k92.h(MediationBannerAdapter.class.getCanonicalName() + " or " + w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting banner ad from adapter.");
        boolean z = rc2Var.t;
        int i = rc2Var.h;
        int i2 = rc2Var.k;
        if (z) {
            u2 u2Var2 = new u2(i2, i);
            u2Var2.d = true;
            u2Var2.e = i;
            u2Var = u2Var2;
        } else {
            u2Var = new u2(i2, i, rc2Var.g);
        }
        Object obj2 = this.zza;
        if (obj2 instanceof MediationBannerAdapter) {
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                List list = tb2Var.k;
                HashSet hashSet = list != null ? new HashSet(list) : null;
                long j = tb2Var.h;
                zzbpe zzbpeVar = new zzbpe(j == -1 ? null : new Date(j), tb2Var.j, hashSet, tb2Var.q, zzX(tb2Var), tb2Var.m, tb2Var.x, tb2Var.z, zzY(str, tb2Var));
                Bundle bundle = tb2Var.s;
                mediationBannerAdapter.requestBannerAd((Context) gy0.r(he0Var), new zzbpp(zzbosVar), zzW(str, tb2Var, str2), u2Var, zzbpeVar, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                k92.f();
                zzboj.zza(he0Var, th, "adapter.requestBannerAd");
                throw new RemoteException();
            }
        }
        if (obj2 instanceof w2) {
            try {
                zzbph zzbphVar = new zzbph(this, zzbosVar);
                zzW(str, tb2Var, str2);
                zzV(tb2Var);
                zzX(tb2Var);
                Location location = tb2Var.q;
                zzY(str, tb2Var);
                ((w2) obj2).loadBannerAd(new ss0(), zzbphVar);
            } catch (Throwable th2) {
                k92.f();
                zzboj.zza(he0Var, th2, "adapter.loadBannerAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzw(he0 he0Var, rc2 rc2Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof w2)) {
            k92.h(w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting interscroller ad from adapter.");
        try {
            w2 w2Var = (w2) this.zza;
            zzbpf zzbpfVar = new zzbpf(this, zzbosVar, w2Var);
            zzW(str, tb2Var, str2);
            zzV(tb2Var);
            zzX(tb2Var);
            Location location = tb2Var.q;
            zzY(str, tb2Var);
            int i = rc2Var.k;
            int i2 = rc2Var.h;
            u2 u2Var = new u2(i, i2);
            u2Var.f = true;
            u2Var.g = i2;
            w2Var.loadInterscrollerAd(new ss0(), zzbpfVar);
        } catch (Exception e) {
            k92.f();
            zzboj.zza(he0Var, e, "adapter.loadInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzx(he0 he0Var, tb2 tb2Var, String str, zzbos zzbosVar) throws RemoteException {
        zzy(he0Var, tb2Var, str, null, zzbosVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzy(he0 he0Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof MediationInterstitialAdapter) && !(obj instanceof w2)) {
            k92.h(MediationInterstitialAdapter.class.getCanonicalName() + " or " + w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting interstitial ad from adapter.");
        Object obj2 = this.zza;
        if (obj2 instanceof MediationInterstitialAdapter) {
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                List list = tb2Var.k;
                HashSet hashSet = list != null ? new HashSet(list) : null;
                long j = tb2Var.h;
                zzbpe zzbpeVar = new zzbpe(j == -1 ? null : new Date(j), tb2Var.j, hashSet, tb2Var.q, zzX(tb2Var), tb2Var.m, tb2Var.x, tb2Var.z, zzY(str, tb2Var));
                Bundle bundle = tb2Var.s;
                mediationInterstitialAdapter.requestInterstitialAd((Context) gy0.r(he0Var), new zzbpp(zzbosVar), zzW(str, tb2Var, str2), zzbpeVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                k92.f();
                zzboj.zza(he0Var, th, "adapter.requestInterstitialAd");
                throw new RemoteException();
            }
        }
        if (obj2 instanceof w2) {
            try {
                zzbpi zzbpiVar = new zzbpi(this, zzbosVar);
                zzW(str, tb2Var, str2);
                zzV(tb2Var);
                zzX(tb2Var);
                Location location = tb2Var.q;
                zzY(str, tb2Var);
                ((w2) obj2).loadInterstitialAd(new ws0(), zzbpiVar);
            } catch (Throwable th2) {
                k92.f();
                zzboj.zza(he0Var, th2, "adapter.loadInterstitialAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzz(he0 he0Var, tb2 tb2Var, String str, String str2, zzbos zzbosVar, zzbes zzbesVar, List list) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof MediationNativeAdapter) && !(obj instanceof w2)) {
            k92.h(MediationNativeAdapter.class.getCanonicalName() + " or " + w2.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        k92.d("Requesting native ad from adapter.");
        Object obj2 = this.zza;
        if (obj2 instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                List list2 = tb2Var.k;
                HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                long j = tb2Var.h;
                zzbps zzbpsVar = new zzbps(j == -1 ? null : new Date(j), tb2Var.j, hashSet, tb2Var.q, zzX(tb2Var), tb2Var.m, zzbesVar, list, tb2Var.x, tb2Var.z, zzY(str, tb2Var));
                Bundle bundle = tb2Var.s;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzb = new zzbpp(zzbosVar);
                mediationNativeAdapter.requestNativeAd((Context) gy0.r(he0Var), this.zzb, zzW(str, tb2Var, str2), zzbpsVar, bundle2);
                return;
            } catch (Throwable th) {
                k92.f();
                zzboj.zza(he0Var, th, "adapter.requestNativeAd");
                throw new RemoteException();
            }
        }
        if (obj2 instanceof w2) {
            try {
                zzbpk zzbpkVar = new zzbpk(this, zzbosVar);
                zzW(str, tb2Var, str2);
                zzV(tb2Var);
                zzX(tb2Var);
                Location location = tb2Var.q;
                zzY(str, tb2Var);
                ((w2) obj2).loadNativeAdMapper(new ys0(), zzbpkVar);
            } catch (Throwable th2) {
                k92.f();
                zzboj.zza(he0Var, th2, "adapter.loadNativeAdMapper");
                String message = th2.getMessage();
                if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                    throw new RemoteException();
                }
                try {
                    w2 w2Var = (w2) this.zza;
                    zzbpj zzbpjVar = new zzbpj(this, zzbosVar);
                    zzW(str, tb2Var, str2);
                    zzV(tb2Var);
                    zzX(tb2Var);
                    Location location2 = tb2Var.q;
                    zzY(str, tb2Var);
                    w2Var.loadNativeAd(new ys0(), zzbpjVar);
                } catch (Throwable th3) {
                    k92.f();
                    zzboj.zza(he0Var, th3, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        }
    }

    public zzbpn(ps0 ps0Var) {
        this.zza = ps0Var;
    }
}
