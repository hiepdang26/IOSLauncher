package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import defpackage.at0;
import defpackage.bt0;
import defpackage.he0;
import defpackage.k92;
import defpackage.ka2;
import defpackage.qs0;
import defpackage.rc2;
import defpackage.rs0;
import defpackage.ss0;
import defpackage.tb2;
import defpackage.u2;
import defpackage.vs0;
import defpackage.ws0;
import defpackage.x32;
import defpackage.x82;
import defpackage.ys0;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqy extends zzbqk {
    private final RtbAdapter zza;
    private vs0 zzb;
    private at0 zzc;
    private qs0 zzd;
    private String zze = "";

    public zzbqy(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(tb2 tb2Var) {
        Bundle bundle;
        Bundle bundle2 = tb2Var.s;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        k92.h("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException unused) {
            k92.f();
            throw new RemoteException();
        }
    }

    private static final boolean zzx(tb2 tb2Var) {
        if (tb2Var.l) {
            return true;
        }
        ka2 ka2Var = x32.f.a;
        return ka2.l();
    }

    private static final String zzy(String str, tb2 tb2Var) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return tb2Var.A;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final x82 zze() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzf() {
        this.zza.getVersionInfo();
        return zzbra.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzg() {
        this.zza.getSDKVersionInfo();
        return zzbra.zza(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    @Override // com.google.android.gms.internal.ads.zzbql
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(defpackage.he0 r3, java.lang.String r4, android.os.Bundle r5, android.os.Bundle r6, defpackage.rc2 r7, com.google.android.gms.internal.ads.zzbqo r8) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqy.zzh(he0, java.lang.String, android.os.Bundle, android.os.Bundle, rc2, com.google.android.gms.internal.ads.zzbqo):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzi(String str, String str2, tb2 tb2Var, he0 he0Var, zzbpw zzbpwVar, zzbos zzbosVar) throws RemoteException {
        try {
            zzbqv zzbqvVar = new zzbqv(this, zzbpwVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            rtbAdapter.loadRtbAppOpenAd(new rs0(), zzbqvVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzj(String str, String str2, tb2 tb2Var, he0 he0Var, zzbpz zzbpzVar, zzbos zzbosVar, rc2 rc2Var) throws RemoteException {
        try {
            zzbqq zzbqqVar = new zzbqq(this, zzbpzVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            new u2(rc2Var.k, rc2Var.h, rc2Var.g);
            rtbAdapter.loadRtbBannerAd(new ss0(), zzbqqVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzk(String str, String str2, tb2 tb2Var, he0 he0Var, zzbpz zzbpzVar, zzbos zzbosVar, rc2 rc2Var) throws RemoteException {
        try {
            zzbqr zzbqrVar = new zzbqr(this, zzbpzVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            new u2(rc2Var.k, rc2Var.h, rc2Var.g);
            rtbAdapter.loadRtbInterscrollerAd(new ss0(), zzbqrVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzl(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqc zzbqcVar, zzbos zzbosVar) throws RemoteException {
        try {
            zzbqs zzbqsVar = new zzbqs(this, zzbqcVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            rtbAdapter.loadRtbInterstitialAd(new ws0(), zzbqsVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzm(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqf zzbqfVar, zzbos zzbosVar) throws RemoteException {
        zzn(str, str2, tb2Var, he0Var, zzbqfVar, zzbosVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzn(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqf zzbqfVar, zzbos zzbosVar, zzbes zzbesVar) throws RemoteException {
        try {
            zzbqt zzbqtVar = new zzbqt(this, zzbqfVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            rtbAdapter.loadRtbNativeAdMapper(new ys0(), zzbqtVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbNativeAdMapper");
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                throw new RemoteException();
            }
            try {
                zzbqu zzbquVar = new zzbqu(this, zzbqfVar, zzbosVar);
                RtbAdapter rtbAdapter2 = this.zza;
                zzw(str2);
                zzv(tb2Var);
                zzx(tb2Var);
                Location location2 = tb2Var.q;
                zzy(str2, tb2Var);
                rtbAdapter2.loadRtbNativeAd(new ys0(), zzbquVar);
            } catch (Throwable th2) {
                k92.f();
                zzboj.zza(he0Var, th2, "adapter.loadRtbNativeAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzo(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException {
        try {
            zzbqx zzbqxVar = new zzbqx(this, zzbqiVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            rtbAdapter.loadRtbRewardedInterstitialAd(new bt0(), zzbqxVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzp(String str, String str2, tb2 tb2Var, he0 he0Var, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException {
        try {
            zzbqx zzbqxVar = new zzbqx(this, zzbqiVar, zzbosVar);
            RtbAdapter rtbAdapter = this.zza;
            zzw(str2);
            zzv(tb2Var);
            zzx(tb2Var);
            Location location = tb2Var.q;
            zzy(str2, tb2Var);
            rtbAdapter.loadRtbRewardedAd(new bt0(), zzbqxVar);
        } catch (Throwable th) {
            k92.f();
            zzboj.zza(he0Var, th, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzq(String str) {
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzr(he0 he0Var) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzs(he0 he0Var) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzt(he0 he0Var) {
        return false;
    }
}
