package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import defpackage.hd2;
import defpackage.k92;
import defpackage.n42;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzayv extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzaym zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzayv() {
        zzaym zzaymVar = new zzaym();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzaymVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbdj.zzd.zze()).intValue();
        this.zzg = ((Long) zzbdj.zza.zze()).intValue();
        this.zzh = ((Long) zzbdj.zze.zze()).intValue();
        this.zzi = ((Long) zzbdj.zzc.zze()).intValue();
        zzbbn zzbbnVar = zzbbw.zzL;
        n42 n42Var = n42.d;
        this.zzj = ((Integer) n42Var.c.zza(zzbbnVar)).intValue();
        this.zzk = ((Integer) n42Var.c.zza(zzbbw.zzM)).intValue();
        this.zzl = ((Integer) n42Var.c.zza(zzbbw.zzN)).intValue();
        this.zze = ((Long) zzbdj.zzf.zze()).intValue();
        this.zzm = (String) n42Var.c.zza(zzbbw.zzP);
        this.zzn = ((Boolean) n42Var.c.zza(zzbbw.zzQ)).booleanValue();
        this.zzo = ((Boolean) n42Var.c.zza(zzbbw.zzR)).booleanValue();
        this.zzp = ((Boolean) n42Var.c.zza(zzbbw.zzS)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r3.importance != 100) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r2.inKeyguardRestrictedInputMode() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        r0 = (android.os.PowerManager) r0.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        if (r0.isScreenOn() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        r0 = defpackage.hd2.B.f.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r0 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        defpackage.k92.d("ContentFetchThread: no activity. Sleeping.");
        zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r0.getWindow() == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        if (r0.getWindow().getDecorView() == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        r1 = r0.getWindow().getDecorView().findViewById(android.R.id.content);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
    
        defpackage.hd2.B.g.zzw(r0, "ContentFetchTask.extractContent");
        defpackage.k92.d("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c5, code lost:
    
        defpackage.k92.f();
        defpackage.hd2.B.g.zzw(r0, "ContentFetchTask.run");
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d2, code lost:
    
        defpackage.k92.f();
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d8 A[EXC_TOP_SPLITTER, LOOP:1: B:62:0x00d8->B:71:0x00d8, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayv.run():void");
    }

    public final zzayl zza() {
        return this.zzd.zza(this.zzp);
    }

    public final zzayu zzb(View view, zzayl zzaylVar) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzaylVar.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                    return new zzayu(this, 1, 0);
                }
            } else {
                if ((view instanceof WebView) && !(view instanceof zzcej)) {
                    WebView webView = (WebView) view;
                    zzaylVar.zzh();
                    webView.post(new zzayt(this, zzaylVar, webView, globalVisibleRect));
                    return new zzayu(this, 0, 1);
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        zzayu zzayuVarZzb = zzb(viewGroup.getChildAt(i3), zzaylVar);
                        i += zzayuVarZzb.zza;
                        i2 += zzayuVarZzb.zzb;
                    }
                    return new zzayu(this, i, i2);
                }
            }
        }
        return new zzayu(this, 0, 0);
    }

    public final void zzc(View view) {
        try {
            zzayl zzaylVar = new zzayl(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZzb = hd2.B.f.zzb();
            if (contextZzb != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(contextZzb.getResources().getIdentifier((String) n42.d.c.zza(zzbbw.zzO), "id", contextZzb.getPackageName()));
                if (str != null && str.equals(this.zzm)) {
                    return;
                }
            }
            zzayu zzayuVarZzb = zzb(view, zzaylVar);
            zzaylVar.zzm();
            if (zzayuVarZzb.zza == 0 && zzayuVarZzb.zzb == 0) {
                return;
            }
            int i = zzayuVarZzb.zzb;
            if (i != 0) {
                if (i == 0) {
                }
                this.zzd.zzb(zzaylVar);
            } else if (zzaylVar.zzc() == 0) {
                return;
            }
            if (this.zzd.zzd(zzaylVar)) {
                return;
            }
            this.zzd.zzb(zzaylVar);
        } catch (Exception e) {
            k92.f();
            hd2.B.g.zzw(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzd(zzayl zzaylVar, WebView webView, String str, boolean z) {
        zzayl zzaylVar2;
        zzaylVar.zzg();
        try {
            if (TextUtils.isEmpty(str)) {
                zzaylVar2 = zzaylVar;
            } else {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzaylVar2 = zzaylVar;
                    zzaylVar2.zzl(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzaylVar.zzl(webView.getTitle() + "\n" + strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                    zzaylVar2 = zzaylVar;
                }
            }
            if (zzaylVar2.zzo()) {
                this.zzd.zzc(zzaylVar2);
            }
        } catch (JSONException unused) {
            k92.d("Json string may be malformed.");
        } catch (Throwable th) {
            k92.j(3);
            hd2.B.g.zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            try {
                if (this.zza) {
                    k92.d("Content hash thread already started, quitting...");
                } else {
                    this.zza = true;
                    start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            k92.d("ContentFetchThread: paused, pause = true");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            k92.d("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
