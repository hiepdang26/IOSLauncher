package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.hg0;
import defpackage.tb2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzenr implements zzevn {
    final zzffg zza;
    private final long zzb;

    public zzenr(zzffg zzffgVar, long j) {
        hg0.j(zzffgVar, "the targeting must not be null");
        this.zza = zzffgVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        tb2 tb2Var = this.zza.zzd;
        bundle.putInt("http_timeout_millis", tb2Var.C);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i2 == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        bundle.putLong("start_signals_timestamp", this.zzb);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        long j = tb2Var.h;
        zzffu.zzf(bundle, "cust_age", simpleDateFormat.format(new Date(j)), j != -1);
        zzffu.zzb(bundle, "extras", tb2Var.i);
        int i3 = tb2Var.j;
        zzffu.zze(bundle, "cust_gender", i3, i3 != -1);
        zzffu.zzd(bundle, "kw", tb2Var.k);
        int i4 = tb2Var.m;
        zzffu.zze(bundle, "tag_for_child_directed_treatment", i4, i4 != -1);
        if (tb2Var.l) {
            bundle.putBoolean("test_request", true);
        }
        bundle.putInt("ppt_p13n", tb2Var.E);
        int i5 = tb2Var.g;
        zzffu.zze(bundle, "d_imp_hdr", 1, i5 >= 2 && tb2Var.n);
        String str = tb2Var.o;
        zzffu.zzf(bundle, "ppid", str, i5 >= 2 && !TextUtils.isEmpty(str));
        Location location = tb2Var.q;
        if (location != null) {
            float accuracy = location.getAccuracy() * 1000.0f;
            long time = location.getTime() * 1000;
            double latitude = location.getLatitude() * 1.0E7d;
            double longitude = 1.0E7d * location.getLongitude();
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", accuracy);
            bundle2.putLong("lat", (long) latitude);
            bundle2.putLong("long", (long) longitude);
            bundle2.putLong("time", time);
            bundle.putBundle("uule", bundle2);
        }
        zzffu.zzc(bundle, "url", tb2Var.r);
        zzffu.zzd(bundle, "neighboring_content_urls", tb2Var.B);
        zzffu.zzb(bundle, "custom_targeting", tb2Var.t);
        zzffu.zzd(bundle, "category_exclusions", tb2Var.u);
        zzffu.zzc(bundle, "request_agent", tb2Var.v);
        zzffu.zzc(bundle, "request_pkg", tb2Var.w);
        zzffu.zzg(bundle, "is_designed_for_families", tb2Var.x, i5 >= 7);
        if (i5 >= 8) {
            int i6 = tb2Var.z;
            zzffu.zze(bundle, "tag_for_under_age_of_consent", i6, i6 != -1);
            zzffu.zzc(bundle, "max_ad_content_rating", tb2Var.A);
        }
    }
}
