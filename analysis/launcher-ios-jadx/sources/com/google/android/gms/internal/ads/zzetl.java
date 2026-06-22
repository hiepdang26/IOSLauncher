package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import defpackage.do0;
import defpackage.ib2;
import defpackage.k92;
import defpackage.n42;
import defpackage.za2;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzetl implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;
    private final PackageInfo zzc;
    private final za2 zzd;

    public zzetl(zzgcu zzgcuVar, zzffg zzffgVar, PackageInfo packageInfo, za2 za2Var) {
        this.zza = zzgcuVar;
        this.zzb = zzffgVar;
        this.zzc = packageInfo;
        this.zzd = za2Var;
    }

    public static /* synthetic */ zzetm zzc(final zzetl zzetlVar) {
        final ArrayList arrayList = zzetlVar.zzb.zzg;
        return arrayList == null ? new zzetm() { // from class: com.google.android.gms.internal.ads.zzeti
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
            }
        } : arrayList.isEmpty() ? new zzetm() { // from class: com.google.android.gms.internal.ads.zzetj
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                ((Bundle) obj).putInt("native_version", 0);
            }
        } : new zzetm() { // from class: com.google.android.gms.internal.ads.zzetk
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                this.zza.zzd(arrayList, (Bundle) obj);
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final do0 zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeth
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetl.zzc(this.zza);
            }
        });
    }

    public final void zzd(ArrayList arrayList, Bundle bundle) {
        int i;
        String str;
        JSONArray jSONArrayOptJSONArray;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.zzb.zzh);
        if (this.zzb.zzi.zza > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            int i2 = this.zzb.zzi.zzh;
            String str2 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "unknown" : "square" : "portrait" : "landscape" : "any";
            if (!"unknown".equals(str2)) {
                bundle.putString("native_media_orientation", str2);
            }
        }
        int i3 = this.zzb.zzi.zzc;
        String str3 = i3 != 0 ? i3 != 1 ? i3 != 2 ? "unknown" : "landscape" : "portrait" : "any";
        if (!"unknown".equals(str3)) {
            bundle.putString("native_image_orientation", str3);
        }
        bundle.putBoolean("native_multiple_images", this.zzb.zzi.zzd);
        bundle.putBoolean("use_custom_mute", this.zzb.zzi.zzg);
        zzbes zzbesVar = this.zzb.zzi;
        if (zzbesVar.zzi != 0) {
            bundle.putBoolean("sccg_tap", zzbesVar.zzj);
            bundle.putInt("sccg_dir", this.zzb.zzi.zzi);
        }
        PackageInfo packageInfo = this.zzc;
        int i4 = packageInfo == null ? 0 : packageInfo.versionCode;
        ib2 ib2Var = (ib2) this.zzd;
        ib2Var.r();
        synchronized (ib2Var.a) {
            i = ib2Var.r;
        }
        if (i4 > i) {
            ((ib2) this.zzd).E();
            ((ib2) this.zzd).F(i4);
        }
        JSONObject jSONObjectC = ((ib2) this.zzd).C();
        String string = null;
        if (jSONObjectC != null && (jSONArrayOptJSONArray = jSONObjectC.optJSONArray(this.zzb.zzf)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i5 = this.zzb.zzk;
        if (i5 > 1) {
            bundle.putInt("max_num_ads", i5);
        }
        zzblh zzblhVar = this.zzb.zzb;
        if (zzblhVar != null) {
            if (TextUtils.isEmpty(zzblhVar.zzc)) {
                if (zzblhVar.zza >= 2) {
                    int i6 = zzblhVar.zzd;
                    str = (i6 == 2 || i6 != 3) ? "l" : "p";
                } else {
                    int i7 = zzblhVar.zzb;
                    if (i7 == 1) {
                        str = "l";
                    } else if (i7 != 2) {
                        k92.e("Instream ad video aspect ratio " + i7 + " is wrong.");
                        str = "l";
                    } else {
                        str = "p";
                    }
                }
                bundle.putString("ia_var", str);
            } else {
                bundle.putString("ad_tag", zzblhVar.zzc);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.zzb.zza() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzkS)).booleanValue()) {
            if (this.zzb.zzi.zzf != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("startMuted", this.zzb.zzi.zzf.g);
                bundle2.putBoolean("clickToExpandRequested", this.zzb.zzi.zzf.i);
                bundle2.putBoolean("customControlsRequested", this.zzb.zzi.zzf.h);
                bundle.putBundle("video", bundle2);
            }
            bundle.putBoolean("disable_image_loading", this.zzb.zzi.zzb);
            bundle.putInt("preferred_ad_choices_position", this.zzb.zzi.zze);
        }
    }
}
