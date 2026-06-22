package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import defpackage.do0;
import defpackage.tb2;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzeic implements zzeet {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(zzfex zzfexVar, zzfel zzfelVar) {
        String strOptString = zzfelVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzffg zzffgVar = zzfexVar.zza.zza;
        zzffe zzffeVar = new zzffe();
        zzffeVar.zzq(zzffgVar);
        zzffeVar.zzt(strOptString);
        Bundle bundleZzd = zzd(zzffgVar.zzd.s);
        Bundle bundleZzd2 = zzd(bundleZzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleZzd2.putInt("gw", 1);
        String strOptString2 = zzfelVar.zzv.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzd2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = zzfelVar.zzv.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzd2.putString("_ad", strOptString3);
        }
        bundleZzd2.putBoolean("_noRefresh", true);
        Iterator<String> itKeys = zzfelVar.zzD.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = zzfelVar.zzD.optString(next, null);
            if (next != null) {
                bundleZzd2.putString(next, strOptString4);
            }
        }
        bundleZzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzd2);
        tb2 tb2Var = zzffgVar.zzd;
        zzffeVar.zzH(new tb2(tb2Var.g, tb2Var.h, bundleZzd2, tb2Var.j, tb2Var.k, tb2Var.l, tb2Var.m, tb2Var.n, tb2Var.o, tb2Var.p, tb2Var.q, tb2Var.r, bundleZzd, tb2Var.t, tb2Var.u, tb2Var.v, tb2Var.w, tb2Var.x, tb2Var.y, tb2Var.z, tb2Var.A, tb2Var.B, tb2Var.C, tb2Var.D, tb2Var.E, tb2Var.F));
        zzffg zzffgVarZzJ = zzffeVar.zzJ();
        Bundle bundle = new Bundle();
        zzfeo zzfeoVar = zzfexVar.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzfeoVar.zza));
        bundle2.putInt("refresh_interval", zzfeoVar.zzc);
        bundle2.putString("gws_query_id", zzfeoVar.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        zzffg zzffgVar2 = zzfexVar.zza.zza;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", zzffgVar2.zzf);
        bundle3.putString("allocation_id", zzfelVar.zzw);
        bundle3.putString("ad_source_name", zzfelVar.zzF);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzfelVar.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzfelVar.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfelVar.zzp));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzfelVar.zzm));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzfelVar.zzg));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzfelVar.zzh));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzfelVar.zzi));
        bundle3.putString("transaction_id", zzfelVar.zzj);
        bundle3.putString("valid_from_timestamp", zzfelVar.zzk);
        bundle3.putBoolean("is_closable_area_disabled", zzfelVar.zzP);
        bundle3.putString("recursive_server_response_data", zzfelVar.zzao);
        if (zzfelVar.zzl != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzfelVar.zzl.zzb);
            bundle4.putString("rb_type", zzfelVar.zzl.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzffgVarZzJ, bundle, zzfelVar, zzfexVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        return !TextUtils.isEmpty(zzfelVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    public abstract do0 zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar);
}
