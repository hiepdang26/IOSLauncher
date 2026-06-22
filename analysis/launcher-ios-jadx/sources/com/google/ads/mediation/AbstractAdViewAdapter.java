package com.google.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbhl;
import defpackage.ba2;
import defpackage.c92;
import defpackage.cw0;
import defpackage.k42;
import defpackage.k92;
import defpackage.ka2;
import defpackage.l2;
import defpackage.l42;
import defpackage.m2;
import defpackage.n42;
import defpackage.n92;
import defpackage.nx0;
import defpackage.o62;
import defpackage.o92;
import defpackage.og0;
import defpackage.os0;
import defpackage.q52;
import defpackage.s2;
import defpackage.ta2;
import defpackage.ts0;
import defpackage.u2;
import defpackage.ur1;
import defpackage.v2;
import defpackage.v52;
import defpackage.vv0;
import defpackage.x32;
import defpackage.x82;
import defpackage.xa2;
import defpackage.xs0;
import defpackage.z92;
import defpackage.zr1;
import defpackage.zs0;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private m2 adLoader;
    protected v2 mAdView;
    protected og0 mInterstitialAd;

    public s2 buildAdRequest(Context context, os0 os0Var, Bundle bundle, Bundle bundle2) {
        nx0 nx0Var = new nx0(2);
        Set keywords = os0Var.getKeywords();
        c92 c92Var = (c92) nx0Var.h;
        if (keywords != null) {
            Iterator it = keywords.iterator();
            while (it.hasNext()) {
                c92Var.a.add((String) it.next());
            }
        }
        if (os0Var.isTesting()) {
            ka2 ka2Var = x32.f.a;
            c92Var.d.add(ka2.o(context));
        }
        if (os0Var.taggedForChildDirectedTreatment() != -1) {
            c92Var.h = os0Var.taggedForChildDirectedTreatment() != 1 ? 0 : 1;
        }
        c92Var.i = os0Var.isDesignedForFamilies();
        nx0Var.q(buildExtrasBundle(bundle, bundle2));
        return new s2(nx0Var);
    }

    public abstract Bundle buildExtrasBundle(Bundle bundle, Bundle bundle2);

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.mAdView;
    }

    public og0 getInterstitialAd() {
        return this.mInterstitialAd;
    }

    public x82 getVideoController() {
        x82 x82Var;
        v2 v2Var = this.mAdView;
        if (v2Var == null) {
            return null;
        }
        ur1 ur1Var = v2Var.g.c;
        synchronized (ur1Var.a) {
            x82Var = ur1Var.b;
        }
        return x82Var;
    }

    public l2 newAdLoader(Context context, String str) {
        return new l2(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDestroy() {
        /*
            r5 = this;
            v2 r0 = r5.mAdView
            r1 = 0
            if (r0 == 0) goto L4d
            android.content.Context r2 = r0.getContext()
            com.google.android.gms.internal.ads.zzbbw.zza(r2)
            com.google.android.gms.internal.ads.zzbdc r2 = com.google.android.gms.internal.ads.zzbdq.zze
            java.lang.Object r2 = r2.zze()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L38
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzki
            n42 r3 = defpackage.n42.d
            com.google.android.gms.internal.ads.zzbbu r3 = r3.c
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L38
            java.util.concurrent.ExecutorService r2 = defpackage.k42.b
            o62 r3 = new o62
            r4 = 1
            r3.<init>(r0, r4)
            r2.execute(r3)
            goto L4b
        L38:
            o92 r0 = r0.g
            r0.getClass()
            v52 r0 = r0.i     // Catch: android.os.RemoteException -> L45
            if (r0 == 0) goto L4b
            r0.zzx()     // Catch: android.os.RemoteException -> L45
            goto L4b
        L45:
            r0 = move-exception
            java.lang.String r2 = "#007 Could not call remote method."
            defpackage.k92.i(r2, r0)
        L4b:
            r5.mAdView = r1
        L4d:
            og0 r0 = r5.mInterstitialAd
            if (r0 == 0) goto L53
            r5.mInterstitialAd = r1
        L53:
            m2 r0 = r5.adLoader
            if (r0 == 0) goto L59
            r5.adLoader = r1
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.mediation.AbstractAdViewAdapter.onDestroy():void");
    }

    public void onImmersiveModeUpdated(boolean z) {
        og0 og0Var = this.mInterstitialAd;
        if (og0Var != null) {
            og0Var.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onPause() {
        v2 v2Var = this.mAdView;
        if (v2Var != null) {
            zzbbw.zza(v2Var.getContext());
            if (((Boolean) zzbdq.zzg.zze()).booleanValue()) {
                if (((Boolean) n42.d.c.zza(zzbbw.zzkj)).booleanValue()) {
                    k42.b.execute(new o62(v2Var, 2));
                    return;
                }
            }
            o92 o92Var = v2Var.g;
            o92Var.getClass();
            try {
                v52 v52Var = o92Var.i;
                if (v52Var != null) {
                    v52Var.zzz();
                }
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onResume() {
        v2 v2Var = this.mAdView;
        if (v2Var != null) {
            zzbbw.zza(v2Var.getContext());
            if (((Boolean) zzbdq.zzh.zze()).booleanValue()) {
                if (((Boolean) n42.d.c.zza(zzbbw.zzkh)).booleanValue()) {
                    k42.b.execute(new o62(v2Var, 0));
                    return;
                }
            }
            o92 o92Var = v2Var.g;
            o92Var.getClass();
            try {
                v52 v52Var = o92Var.i;
                if (v52Var != null) {
                    v52Var.zzB();
                }
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, ts0 ts0Var, Bundle bundle, u2 u2Var, os0 os0Var, Bundle bundle2) {
        v2 v2Var = new v2(context);
        this.mAdView = v2Var;
        v2Var.setAdSize(new u2(u2Var.a, u2Var.b));
        this.mAdView.setAdUnitId(getAdUnitId(bundle));
        this.mAdView.setAdListener(new l42(this, ts0Var));
        this.mAdView.a(buildAdRequest(context, os0Var, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, xs0 xs0Var, Bundle bundle, os0 os0Var, Bundle bundle2) {
        og0.load(context, getAdUnitId(bundle), buildAdRequest(context, os0Var, bundle2, bundle), new a(this, xs0Var));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, zs0 zs0Var, Bundle bundle, cw0 cw0Var, Bundle bundle2) {
        int i;
        m2 m2Var;
        boolean z;
        boolean z2;
        int i2;
        zr1 zr1Var;
        n92 n92Var = new n92(this, zs0Var);
        l2 l2VarNewAdLoader = newAdLoader(context, bundle.getString(AD_UNIT_ID_PARAMETER));
        l2VarNewAdLoader.getClass();
        q52 q52Var = l2VarNewAdLoader.b;
        try {
            q52Var.zzl(new xa2(n92Var));
        } catch (RemoteException unused) {
            k92.j(5);
        }
        try {
            q52Var.zzo(new zzbes(cw0Var.getNativeAdOptions()));
        } catch (RemoteException unused2) {
            k92.j(5);
        }
        vv0 nativeAdRequestOptions = cw0Var.getNativeAdRequestOptions();
        try {
            z = nativeAdRequestOptions.a;
            z2 = nativeAdRequestOptions.c;
            i2 = nativeAdRequestOptions.d;
            zr1Var = nativeAdRequestOptions.e;
            i = 5;
        } catch (RemoteException unused3) {
            i = 5;
        }
        try {
            q52Var.zzo(new zzbes(4, z, -1, z2, i2, zr1Var != null ? new ta2(zr1Var) : null, nativeAdRequestOptions.f, nativeAdRequestOptions.b, nativeAdRequestOptions.h, nativeAdRequestOptions.g, nativeAdRequestOptions.i - 1));
        } catch (RemoteException unused4) {
            k92.j(i);
        }
        if (cw0Var.isUnifiedNativeAdRequested()) {
            try {
                q52Var.zzk(new zzbhl(n92Var));
            } catch (RemoteException unused5) {
                k92.j(i);
            }
        }
        if (cw0Var.zzb()) {
            for (String str : cw0Var.zza().keySet()) {
                zzbhi zzbhiVar = new zzbhi(n92Var, true != ((Boolean) cw0Var.zza().get(str)).booleanValue() ? null : n92Var);
                try {
                    q52Var.zzh(str, zzbhiVar.zzd(), zzbhiVar.zzc());
                } catch (RemoteException unused6) {
                    k92.j(i);
                }
            }
        }
        Context context2 = l2VarNewAdLoader.a;
        try {
            m2Var = new m2(context2, q52Var.zze());
        } catch (RemoteException unused7) {
            k92.f();
            m2Var = new m2(context2, new z92(new ba2()));
        }
        this.adLoader = m2Var;
        m2Var.a(buildAdRequest(context, cw0Var, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        og0 og0Var = this.mInterstitialAd;
        if (og0Var != null) {
            og0Var.show(null);
        }
    }
}
