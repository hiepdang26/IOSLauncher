package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.do0;
import defpackage.hd2;
import defpackage.k92;
import defpackage.m21;
import defpackage.m62;
import defpackage.or1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzegi implements zzeet {
    private final Context zza;
    private final zzdgp zzb;
    private final Executor zzc;
    private final zzfek zzd;

    public zzegi(Context context, Executor executor, zzdgp zzdgpVar, zzfek zzfekVar) {
        this.zza = context;
        this.zzb = zzdgpVar;
        this.zzc = executor;
        this.zzd = zzfekVar;
    }

    private static String zzd(zzfel zzfelVar) {
        try {
            return zzfelVar.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final do0 zza(final zzfex zzfexVar, final zzfel zzfelVar) {
        String strZzd = zzd(zzfelVar);
        final Uri uri = strZzd != null ? Uri.parse(strZzd) : null;
        return zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzegg
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc(uri, zzfexVar, zzfelVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbct.zzg(context) && !TextUtils.isEmpty(zzd(zzfelVar));
    }

    public final do0 zzc(Uri uri, zzfex zzfexVar, zzfel zzfelVar, Object obj) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                intent.putExtras(bundle);
            }
            intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
            intent.putExtras(new Bundle());
            intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
            intent.setData(uri);
            m62 m62Var = new m62(intent, null);
            final zzbzt zzbztVar = new zzbzt();
            zzdfp zzdfpVarZze = this.zzb.zze(new zzcsk(zzfexVar, zzfelVar, null), new zzdfs(new zzdgx() { // from class: com.google.android.gms.internal.ads.zzegh
                @Override // com.google.android.gms.internal.ads.zzdgx
                public final void zza(boolean z, Context context, zzcxd zzcxdVar) {
                    zzbzt zzbztVar2 = zzbztVar;
                    try {
                        m21 m21Var = hd2.B.b;
                        m21.f(context, (AdOverlayInfoParcel) zzbztVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }, null));
            zzbztVar.zzc(new AdOverlayInfoParcel(m62Var, null, zzdfpVarZze.zza(), null, new or1(0, 0, false, false), null, null));
            this.zzd.zza();
            return zzgcj.zzh(zzdfpVarZze.zzg());
        } catch (Throwable th) {
            k92.f();
            throw th;
        }
    }
}
