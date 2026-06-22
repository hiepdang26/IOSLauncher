package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import defpackage.a22;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.ja2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.or1;
import defpackage.p21;
import defpackage.x32;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmd implements zzblv, zzblu {
    private final zzcej zza;

    /* JADX WARN: Multi-variable type inference failed */
    public zzbmd(Context context, or1 or1Var, zzauo zzauoVar, a22 a22Var) throws zzcev {
        zzcew zzcewVar = hd2.B.d;
        zzcej zzcejVarZza = zzcew.zza(context, zzcgd.zza(), "", false, false, null, null, or1Var, null, null, null, zzbav.zza(), null, null, null, null);
        this.zza = zzcejVarZza;
        ((View) zzcejVarZza).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        ka2 ka2Var = x32.f.a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            k92.a("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            k92.a("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (cd2.l.post(runnable)) {
                return;
            }
            k92.h("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zza(final String str) {
        k92.a("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzblz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzm(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzb(String str, String str2) {
        zzblt.zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzc() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ void zzd(String str, Map map) {
        zzblt.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzblt.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzf(final String str) {
        k92.a("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbma
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzn(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzg(final String str) {
        k92.a("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzblx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzh(String str) {
        k92.a("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = "<!DOCTYPE html><html><head><script src=\"" + str + "\"></script></head><body></body></html>";
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzp(str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final boolean zzi() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final zzbnc zzj() {
        return new zzbnc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzblv
    public final void zzk(final zzbmj zzbmjVar) {
        zzcgb zzcgbVarZzN = this.zza.zzN();
        Objects.requireNonNull(zzbmjVar);
        zzcgbVarZzN.zzH(new zzcga() { // from class: com.google.android.gms.internal.ads.zzbly
            @Override // com.google.android.gms.internal.ads.zzcga
            public final void zza() {
                hd2.B.j.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                zzbmj zzbmjVar2 = zzbmjVar;
                final long j = zzbmjVar2.zzc;
                final ArrayList arrayList = zzbmjVar2.zzb;
                arrayList.add(Long.valueOf(jCurrentTimeMillis - j));
                k92.a("LoadNewJavascriptEngine(onEngLoaded) latency is " + String.valueOf(arrayList.get(0)) + " ms.");
                ja2 ja2Var = cd2.l;
                final zzbna zzbnaVar = zzbmjVar2.zza;
                final zzbmz zzbmzVar = zzbmjVar2.zzd;
                final zzblv zzblvVar = zzbmjVar2.zze;
                ja2Var.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmf
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbnaVar.zzi(zzbmzVar, zzblvVar, arrayList, j);
                    }
                }, ((Integer) n42.d.c.zza(zzbbw.zzb)).intValue());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzblt.zzd(this, str, jSONObject);
    }

    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    @Override // com.google.android.gms.internal.ads.zzbnb
    public final void zzq(String str, zzbix zzbixVar) {
        this.zza.zzag(str, new zzbmc(this, zzbixVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbnb
    public final void zzr(String str, final zzbix zzbixVar) {
        this.zza.zzaA(str, new p21() { // from class: com.google.android.gms.internal.ads.zzblw
            @Override // defpackage.p21
            public final boolean apply(Object obj) {
                zzbix zzbixVar2 = (zzbix) obj;
                if (zzbixVar2 instanceof zzbmc) {
                    return ((zzbmc) zzbixVar2).zzb.equals(zzbixVar);
                }
                return false;
            }
        });
    }
}
