package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.rc2;
import defpackage.x32;
import defpackage.z71;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkv {
    private final zzdpl zza;
    private final zzdoa zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdkv(zzdpl zzdplVar, zzdoa zzdoaVar) {
        this.zza = zzdplVar;
        this.zzb = zzdoaVar;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        ka2 ka2Var = x32.f.a;
        return ka2.n(context, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza(final View view, final WindowManager windowManager) {
        zzcej zzcejVarZza = this.zza.zza(rc2.b(), null, null);
        View view2 = (View) zzcejVarZza;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zzcejVarZza.zzag("/sendMessageToSdk", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkp
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcej) obj, map);
            }
        });
        zzcejVarZza.zzag("/hideValidatorOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkq
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzc(windowManager, view, (zzcej) obj, map);
            }
        });
        zzcejVarZza.zzag("/open", new zzbjj(null, null, null, null, null));
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/loadNativeAdPolicyViolations", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkr
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zze(view, windowManager, (zzcej) obj, map);
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/showValidatorOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdks
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                k92.d("Show native ad policy validator overlay.");
                ((zzcej) obj).zzF().setVisibility(0);
            }
        });
        return (View) zzcejVarZza;
    }

    public final /* synthetic */ void zzb(zzcej zzcejVar, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcej zzcejVar, Map map) {
        k92.d("Hide native ad policy validator overlay.");
        zzcejVar.zzF().setVisibility(8);
        if (zzcejVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcejVar.zzF());
        }
        zzcejVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzc);
    }

    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", map2);
    }

    public final void zze(final View view, final WindowManager windowManager, final zzcej zzcejVar, final Map map) {
        zzcejVar.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdku
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z, int i, String str, String str2) {
                this.zza.zzd(map, z, i, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        String str = (String) map.get("validator_width");
        zzbbn zzbbnVar = zzbbw.zzhl;
        n42 n42Var = n42.d;
        int iZzf = zzf(context, str, ((Integer) n42Var.c.zza(zzbbnVar)).intValue());
        int iZzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) n42Var.c.zza(zzbbw.zzhm)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcejVar.zzaj(zzcgd.zzb(iZzf, iZzf2));
        try {
            zzcejVar.zzG().getSettings().setUseWideViewPort(((Boolean) n42Var.c.zza(zzbbw.zzhn)).booleanValue());
            zzcejVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) n42Var.c.zza(zzbbw.zzho)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsQ = z71.q();
        layoutParamsQ.x = iZzf3;
        layoutParamsQ.y = iZzf4;
        windowManager.updateViewLayout(zzcejVar.zzF(), layoutParamsQ);
        final String str2 = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i = (("1".equals(str2) || "2".equals(str2)) ? rect.bottom : rect.top) - iZzf4;
            this.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdkt
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcej zzcejVar2 = zzcejVar;
                        if (zzcejVar2.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i2 = i;
                        WindowManager.LayoutParams layoutParams = layoutParamsQ;
                        String str3 = str2;
                        if ("1".equals(str3) || "2".equals(str3)) {
                            layoutParams.y = rect2.bottom - i2;
                        } else {
                            layoutParams.y = rect2.top - i2;
                        }
                        windowManager.updateViewLayout(zzcejVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzc);
            }
        }
        String str3 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        zzcejVar.loadUrl(str3);
    }
}
