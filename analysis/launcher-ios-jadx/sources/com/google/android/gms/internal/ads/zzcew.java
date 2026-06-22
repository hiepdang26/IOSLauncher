package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import defpackage.a22;
import defpackage.cc2;
import defpackage.hd2;
import defpackage.or1;

/* JADX INFO: loaded from: classes.dex */
public final class zzcew {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzcej, java.lang.Object] */
    public static final zzcej zza(final Context context, final zzcgd zzcgdVar, final String str, final boolean z, final boolean z2, final zzauo zzauoVar, final zzbcz zzbczVar, final or1 or1Var, zzbcl zzbclVar, final cc2 cc2Var, final a22 a22Var, final zzbav zzbavVar, final zzfel zzfelVar, final zzfeo zzfeoVar, final zzeds zzedsVar, final zzffk zzffkVar) throws zzcev {
        zzbbw.zza(context);
        try {
            final zzbcl zzbclVar2 = null;
            zzfvk zzfvkVar = new zzfvk(context, zzcgdVar, str, z, z2, zzauoVar, zzbczVar, or1Var, zzbclVar2, cc2Var, a22Var, zzbavVar, zzfelVar, zzfeoVar, zzffkVar, zzedsVar) { // from class: com.google.android.gms.internal.ads.zzces
                public final /* synthetic */ Context zza;
                public final /* synthetic */ zzcgd zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ boolean zzd;
                public final /* synthetic */ boolean zze;
                public final /* synthetic */ zzauo zzf;
                public final /* synthetic */ zzbcz zzg;
                public final /* synthetic */ or1 zzh;
                public final /* synthetic */ cc2 zzi;
                public final /* synthetic */ a22 zzj;
                public final /* synthetic */ zzbav zzk;
                public final /* synthetic */ zzfel zzl;
                public final /* synthetic */ zzfeo zzm;
                public final /* synthetic */ zzffk zzn;
                public final /* synthetic */ zzeds zzo;

                {
                    this.zzi = cc2Var;
                    this.zzj = a22Var;
                    this.zzk = zzbavVar;
                    this.zzl = zzfelVar;
                    this.zzm = zzfeoVar;
                    this.zzn = zzffkVar;
                    this.zzo = zzedsVar;
                }

                @Override // com.google.android.gms.internal.ads.zzfvk
                public final Object zza() {
                    zzcgd zzcgdVar2 = this.zzb;
                    String str2 = this.zzc;
                    boolean z3 = this.zzd;
                    zzbav zzbavVar2 = this.zzk;
                    boolean z4 = this.zze;
                    zzauo zzauoVar2 = this.zzf;
                    zzfel zzfelVar2 = this.zzl;
                    zzbcz zzbczVar2 = this.zzg;
                    cc2 cc2Var2 = this.zzi;
                    zzfeo zzfeoVar2 = this.zzm;
                    Context context2 = this.zza;
                    or1 or1Var2 = this.zzh;
                    a22 a22Var2 = this.zzj;
                    zzffk zzffkVar2 = this.zzn;
                    zzeds zzedsVar2 = this.zzo;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i = zzcfi.zza;
                        zzcfb zzcfbVar = new zzcfb(new zzcfi(new zzcgc(context2), zzcgdVar2, str2, z3, z4, zzauoVar2, zzbczVar2, or1Var2, null, cc2Var2, a22Var2, zzbavVar2, zzfelVar2, zzfeoVar2, zzffkVar2));
                        hd2.B.e.getClass();
                        zzcfbVar.setWebViewClient(new zzcfs(zzcfbVar, zzbavVar2, z4, zzedsVar2));
                        zzcfbVar.setWebChromeClient(new zzcei(zzcfbVar));
                        return zzcfbVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return zzfvkVar.zza();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            throw new zzcev("Webview initialization failed.", th);
        }
    }
}
