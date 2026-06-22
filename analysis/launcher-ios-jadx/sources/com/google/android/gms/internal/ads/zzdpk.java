package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import defpackage.b22;
import defpackage.do0;
import defpackage.e22;
import defpackage.h42;
import defpackage.n42;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpk {
    private final zzcwo zza;
    private final zzdeo zzb;
    private final zzcxx zzc;
    private final zzcyk zzd;
    private final zzcyw zze;
    private final zzdbn zzf;
    private final Executor zzg;
    private final zzdek zzh;
    private final zzcof zzi;
    private final h42 zzj;
    private final zzbxl zzk;
    private final zzauo zzl;
    private final zzdbe zzm;
    private final zzedh zzn;
    private final zzfll zzo;
    private final zzdsk zzp;
    private final zzcni zzq;
    private final zzdpq zzr;

    public zzdpk(zzcwo zzcwoVar, zzcxx zzcxxVar, zzcyk zzcykVar, zzcyw zzcywVar, zzdbn zzdbnVar, Executor executor, zzdek zzdekVar, zzcof zzcofVar, h42 h42Var, zzbxl zzbxlVar, zzauo zzauoVar, zzdbe zzdbeVar, zzedh zzedhVar, zzfll zzfllVar, zzdsk zzdskVar, zzdeo zzdeoVar, zzcni zzcniVar, zzdpq zzdpqVar) {
        this.zza = zzcwoVar;
        this.zzc = zzcxxVar;
        this.zzd = zzcykVar;
        this.zze = zzcywVar;
        this.zzf = zzdbnVar;
        this.zzg = executor;
        this.zzh = zzdekVar;
        this.zzi = zzcofVar;
        this.zzj = h42Var;
        this.zzk = zzbxlVar;
        this.zzl = zzauoVar;
        this.zzm = zzdbeVar;
        this.zzn = zzedhVar;
        this.zzo = zzfllVar;
        this.zzp = zzdskVar;
        this.zzb = zzdeoVar;
        this.zzq = zzcniVar;
        this.zzr = zzdpqVar;
    }

    public static final do0 zzj(zzcej zzcejVar, String str, String str2) {
        final zzbzt zzbztVar = new zzbzt();
        zzcejVar.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdpb
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z, int i, String str3, String str4) {
                zzbzt zzbztVar2 = zzbztVar;
                if (z) {
                    zzbztVar2.zzc(null);
                    return;
                }
                zzbztVar2.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcejVar.zzae(str, str2, null);
        return zzbztVar;
    }

    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    public final void zzf(View view) {
        this.zzj.b = true;
    }

    public final /* synthetic */ void zzg(zzcej zzcejVar, zzcej zzcejVar2, Map map) {
        this.zzi.zzh(zzcejVar);
    }

    public final boolean zzh(View view, MotionEvent motionEvent) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzjg)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
        }
        this.zzj.b = true;
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzi(final zzcej zzcejVar, boolean z, zzbja zzbjaVar) {
        zzauk zzaukVarZzc;
        zzcejVar.zzN().zzR(new b22() { // from class: com.google.android.gms.internal.ads.zzdpc
            @Override // defpackage.b22
            public final void onAdClicked() {
                this.zza.zzc();
            }
        }, this.zzd, this.zze, new zzbhp() { // from class: com.google.android.gms.internal.ads.zzdpd
            @Override // com.google.android.gms.internal.ads.zzbhp
            public final void zzb(String str, String str2) {
                this.zza.zzd(str, str2);
            }
        }, new e22() { // from class: com.google.android.gms.internal.ads.zzdpe
            @Override // defpackage.e22
            public final void zzg() {
                this.zza.zze();
            }
        }, z, zzbjaVar, this.zzj, new zzdpj(this), this.zzk, this.zzn, this.zzo, this.zzp, null, this.zzb, null, null, null, this.zzq);
        zzcejVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdpf
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.zza.zzh(view, motionEvent);
                return false;
            }
        });
        zzcejVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdpg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zza.zzf(view);
            }
        });
        if (((Boolean) n42.d.c.zza(zzbbw.zzcq)).booleanValue() && (zzaukVarZzc = this.zzl.zzc()) != null) {
            zzaukVarZzc.zzo((View) zzcejVar);
        }
        this.zzh.zzo(zzcejVar, this.zzg);
        this.zzh.zzo(new zzaxw() { // from class: com.google.android.gms.internal.ads.zzdph
            @Override // com.google.android.gms.internal.ads.zzaxw
            public final void zzdp(zzaxv zzaxvVar) {
                zzcgb zzcgbVarZzN = zzcejVar.zzN();
                Rect rect = zzaxvVar.zzd;
                zzcgbVarZzN.zzq(rect.left, rect.top, false);
            }
        }, this.zzg);
        this.zzh.zza((View) zzcejVar);
        zzcejVar.zzag("/trackActiveViewUnit", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdpi
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzg(zzcejVar, (zzcej) obj, map);
            }
        });
        this.zzi.zzi(zzcejVar);
    }
}
