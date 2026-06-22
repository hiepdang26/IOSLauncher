package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import defpackage.k92;
import defpackage.rc2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkn {
    private final zzdpl zza;
    private final zzdoa zzb;
    private final zzcop zzc;
    private final zzdjj zzd;

    public zzdkn(zzdpl zzdplVar, zzdoa zzdoaVar, zzcop zzcopVar, zzdjj zzdjjVar) {
        this.zza = zzdplVar;
        this.zzb = zzdoaVar;
        this.zzc = zzcopVar;
        this.zzd = zzdjjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza() {
        zzcej zzcejVarZza = this.zza.zza(rc2.b(), null, null);
        ((View) zzcejVarZza).setVisibility(8);
        zzcejVarZza.zzag("/sendMessageToSdk", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdki
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcej) obj, map);
            }
        });
        zzcejVarZza.zzag("/adMuted", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkj
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcej) obj, map);
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/loadHtml", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkk
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, final Map map) {
                zzcej zzcejVar = (zzcej) obj;
                zzcgb zzcgbVarZzN = zzcejVar.zzN();
                final zzdkn zzdknVar = this.zza;
                zzcgbVarZzN.zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdkh
                    @Override // com.google.android.gms.internal.ads.zzcfz
                    public final void zza(boolean z, int i, String str, String str2) {
                        zzdknVar.zzd(map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcejVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcejVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/showOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkl
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zze((zzcej) obj, map);
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/hideOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkm
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzf((zzcej) obj, map);
            }
        });
        return (View) zzcejVarZza;
    }

    public final /* synthetic */ void zzb(zzcej zzcejVar, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(zzcej zzcejVar, Map map) {
        this.zzd.zzg();
    }

    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", map2);
    }

    public final /* synthetic */ void zze(zzcej zzcejVar, Map map) {
        k92.g("Showing native ads overlay.");
        zzcejVar.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    public final /* synthetic */ void zzf(zzcej zzcejVar, Map map) {
        k92.g("Hiding native ads overlay.");
        zzcejVar.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
