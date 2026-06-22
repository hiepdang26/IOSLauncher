package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import defpackage.b21;
import defpackage.cw0;
import defpackage.h2;
import defpackage.k92;
import defpackage.m21;
import defpackage.os0;
import defpackage.ta1;
import defpackage.ts0;
import defpackage.u2;
import defpackage.xs0;
import defpackage.zs0;

/* JADX INFO: loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final h2 d = new h2(0, "Could not instantiate custom event adapter", "com.google.android.gms.ads", null);
    public CustomEventBanner a;
    public CustomEventInterstitial b;
    public CustomEventNative c;

    public static Object a(Class cls, String str) {
        try {
            if (str != null) {
                return cls.cast(Class.forName(str).getDeclaredConstructor(null).newInstance(null));
            }
            throw null;
        } catch (Throwable th) {
            k92.h("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return null;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onDestroy() {
        CustomEventBanner customEventBanner = this.a;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.b;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.c;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onPause() {
        CustomEventBanner customEventBanner = this.a;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.b;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.c;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onResume() {
        CustomEventBanner customEventBanner = this.a;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.b;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.c;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, ts0 ts0Var, Bundle bundle, u2 u2Var, os0 os0Var, Bundle bundle2) {
        CustomEventBanner customEventBanner = (CustomEventBanner) a(CustomEventBanner.class, bundle.getString("class_name"));
        this.a = customEventBanner;
        if (customEventBanner == null) {
            ts0Var.onAdFailedToLoad(this, d);
            return;
        }
        Bundle bundle3 = bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name"));
        CustomEventBanner customEventBanner2 = this.a;
        customEventBanner2.getClass();
        customEventBanner2.requestBannerAd(context, new ta1(10), bundle.getString("parameter"), u2Var, os0Var, bundle3);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, xs0 xs0Var, Bundle bundle, os0 os0Var, Bundle bundle2) {
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) a(CustomEventInterstitial.class, bundle.getString("class_name"));
        this.b = customEventInterstitial;
        if (customEventInterstitial == null) {
            xs0Var.onAdFailedToLoad(this, d);
            return;
        }
        Bundle bundle3 = bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name"));
        CustomEventInterstitial customEventInterstitial2 = this.b;
        customEventInterstitial2.getClass();
        customEventInterstitial2.requestInterstitialAd(context, new m21(), bundle.getString("parameter"), os0Var, bundle3);
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, zs0 zs0Var, Bundle bundle, cw0 cw0Var, Bundle bundle2) {
        CustomEventNative customEventNative = (CustomEventNative) a(CustomEventNative.class, bundle.getString("class_name"));
        this.c = customEventNative;
        if (customEventNative == null) {
            zs0Var.onAdFailedToLoad(this, d);
            return;
        }
        Bundle bundle3 = bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name"));
        CustomEventNative customEventNative2 = this.c;
        customEventNative2.getClass();
        customEventNative2.requestNativeAd(context, new b21(13), bundle.getString("parameter"), cw0Var, bundle3);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        CustomEventInterstitial customEventInterstitial = this.b;
        if (customEventInterstitial != null) {
            customEventInterstitial.showInterstitial();
        }
    }
}
