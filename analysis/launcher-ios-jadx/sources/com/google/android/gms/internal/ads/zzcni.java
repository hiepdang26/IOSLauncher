package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import androidx.appcompat.widget.ActivityChooserView;
import defpackage.do0;
import defpackage.ib2;
import defpackage.n42;
import defpackage.za2;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzcni {
    zzbts zza;
    zzbts zzb;
    private final Context zzc;
    private final za2 zzd;
    private final zzeep zze;
    private final zzdpq zzf;
    private final zzgcu zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    public zzcni(Context context, za2 za2Var, zzeep zzeepVar, zzdpq zzdpqVar, zzgcu zzgcuVar, zzgcu zzgcuVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = za2Var;
        this.zze = zzeepVar;
        this.zzf = zzdpqVar;
        this.zzg = zzgcuVar;
        this.zzh = zzgcuVar2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) n42.d.c.zza(zzbbw.zzjn));
    }

    private final do0 zzk(final String str, final InputEvent inputEvent, Random random) {
        try {
            zzbbn zzbbnVar = zzbbw.zzjn;
            n42 n42Var = n42.d;
            if (!str.contains((CharSequence) n42Var.c.zza(zzbbnVar)) || ((ib2) this.zzd).q()) {
                return zzgcj.zzh(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) n42Var.c.zza(zzbbw.zzjo), String.valueOf(random.nextInt(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)));
            if (inputEvent != null) {
                return zzgcj.zzf(zzgcj.zzn(zzgca.zzu(this.zze.zza()), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcnc
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final do0 zza(Object obj) {
                        return this.zza.zzd(builderBuildUpon, str, inputEvent, (Integer) obj);
                    }
                }, this.zzh), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcnd
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final do0 zza(Object obj) {
                        return this.zza.zze(builderBuildUpon, (Throwable) obj);
                    }
                }, this.zzg);
            }
            builderBuildUpon.appendQueryParameter((String) n42Var.c.zza(zzbbw.zzjp), "11");
            return zzgcj.zzh(builderBuildUpon.toString());
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }

    public final do0 zzb(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgcj.zzh(str) : zzgcj.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcmz
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                return this.zza.zzc(str, (Throwable) obj);
            }
        }, this.zzg);
    }

    public final /* synthetic */ do0 zzc(String str, final Throwable th) {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg(th);
            }
        });
        return zzgcj.zzh(str);
    }

    public final do0 zzd(final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) n42.d.c.zza(zzbbw.zzjp), "10");
            return zzgcj.zzh(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        zzbbn zzbbnVar = zzbbw.zzjq;
        n42 n42Var = n42.d;
        builderBuildUpon.appendQueryParameter((String) n42Var.c.zza(zzbbnVar), "1");
        builderBuildUpon.appendQueryParameter((String) n42Var.c.zza(zzbbw.zzjp), "12");
        if (str.contains((CharSequence) n42Var.c.zza(zzbbw.zzjr))) {
            builderBuildUpon.authority((String) n42Var.c.zza(zzbbw.zzjs));
        }
        return zzgcj.zzn(zzgca.zzu(this.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcne
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final do0 zza(Object obj) {
                String str2 = (String) n42.d.c.zza(zzbbw.zzjp);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzgcj.zzh(builder2.toString());
            }
        }, this.zzh);
    }

    public final do0 zze(Uri.Builder builder, final Throwable th) {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcna
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(th);
            }
        });
        builder.appendQueryParameter((String) n42.d.c.zza(zzbbw.zzjp), "9");
        return zzgcj.zzh(builder.toString());
    }

    public final void zzg(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzju)).booleanValue()) {
            zzbts zzbtsVarZzc = zzbtq.zzc(this.zzc);
            this.zzb = zzbtsVarZzc;
            zzbtsVarZzc.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
        } else {
            zzbts zzbtsVarZza = zzbtq.zza(this.zzc);
            this.zza = zzbtsVarZza;
            zzbtsVarZza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
        }
    }

    public final void zzh(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzju)).booleanValue()) {
            zzbts zzbtsVarZzc = zzbtq.zzc(this.zzc);
            this.zzb = zzbtsVarZzc;
            zzbtsVarZzc.zzh(th, "AttributionReporting");
        } else {
            zzbts zzbtsVarZza = zzbtq.zza(this.zzc);
            this.zza = zzbtsVarZza;
            zzbtsVarZza.zzh(th, "AttributionReportingSampled");
        }
    }

    public final void zzi(String str, zzfll zzfllVar, Random random) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzgcj.zzr(zzgcj.zzo(zzk(str, this.zzf.zza(), random), ((Integer) n42.d.c.zza(zzbbw.zzjt)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcnh(this, zzfllVar, str), this.zzg);
    }
}
