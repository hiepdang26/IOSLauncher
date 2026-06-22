package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.a22;
import defpackage.bf1;
import defpackage.cc2;
import defpackage.cd2;
import defpackage.d72;
import defpackage.do0;
import defpackage.ew1;
import defpackage.hd2;
import defpackage.ja0;
import defpackage.k92;
import defpackage.ka2;
import defpackage.m62;
import defpackage.n42;
import defpackage.np1;
import defpackage.or1;
import defpackage.p21;
import defpackage.p42;
import defpackage.tw1;
import defpackage.ww1;
import defpackage.x32;
import defpackage.xw1;
import defpackage.yb2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzcfi extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcej {
    public static final /* synthetic */ int zza = 0;
    private final String zzA;
    private zzcfl zzB;
    private boolean zzC;
    private boolean zzD;
    private zzber zzE;
    private zzbep zzF;
    private zzazj zzG;
    private int zzH;
    private int zzI;
    private zzbci zzJ;
    private final zzbci zzK;
    private zzbci zzL;
    private final zzbcj zzM;
    private int zzN;
    private yb2 zzO;
    private boolean zzP;
    private final d72 zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private Map zzV;
    private final WindowManager zzW;
    private final zzbav zzX;
    private boolean zzY;
    private final zzcgc zzb;
    private final zzauo zzc;
    private final zzffk zzd;
    private final zzbcz zze;
    private final or1 zzf;
    private cc2 zzg;
    private final a22 zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfel zzk;
    private zzfeo zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcer zzo;
    private yb2 zzp;
    private zzeeo zzq;
    private zzeem zzr;
    private zzcgd zzs;
    private final String zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private Boolean zzy;
    private boolean zzz;

    public zzcfi(zzcgc zzcgcVar, zzcgd zzcgdVar, String str, boolean z, boolean z2, zzauo zzauoVar, zzbcz zzbczVar, or1 or1Var, zzbcl zzbclVar, cc2 cc2Var, a22 a22Var, zzbav zzbavVar, zzfel zzfelVar, zzfeo zzfeoVar, zzffk zzffkVar) {
        zzfeo zzfeoVar2;
        super(zzcgcVar);
        this.zzm = false;
        this.zzn = false;
        this.zzz = true;
        this.zzA = "";
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzU = -1;
        this.zzb = zzcgcVar;
        this.zzs = zzcgdVar;
        this.zzt = str;
        this.zzw = z;
        this.zzc = zzauoVar;
        this.zzd = zzffkVar;
        this.zze = zzbczVar;
        this.zzf = or1Var;
        this.zzg = cc2Var;
        this.zzh = a22Var;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzW = windowManager;
        cd2 cd2Var = hd2.B.c;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.zzi = displayMetrics;
        this.zzj = displayMetrics.density;
        this.zzX = zzbavVar;
        this.zzk = zzfelVar;
        this.zzl = zzfeoVar;
        this.zzQ = new d72(zzcgcVar.zza(), this, this);
        this.zzY = false;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException unused) {
            k92.f();
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        zzbbn zzbbnVar = zzbbw.zzkJ;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        hd2 hd2Var = hd2.B;
        settings.setUserAgentString(hd2Var.c.w(zzcgcVar, or1Var.g));
        Context context = getContext();
        bf1.C(context, new p42(settings, context, 2));
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzba();
        addJavascriptInterface(new zzcfp(this, new zzcfo(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbi();
        zzbcj zzbcjVar = new zzbcj(new zzbcl(true, "make_wv", this.zzt));
        this.zzM = zzbcjVar;
        Context contextCreatePackageContext = null;
        zzbcjVar.zza().zzc(null);
        if (((Boolean) n42Var.c.zza(zzbbw.zzbG)).booleanValue() && (zzfeoVar2 = this.zzl) != null && zzfeoVar2.zzb != null) {
            zzbcjVar.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbcjVar.zza();
        zzbci zzbciVarZzf = zzbcl.zzf();
        this.zzK = zzbciVarZzf;
        zzbcjVar.zzb("native:view_create", zzbciVarZzf);
        this.zzL = null;
        this.zzJ = null;
        if (ew1.i == null) {
            ew1.i = new ew1();
        }
        ew1 ew1Var = ew1.i;
        ew1Var.getClass();
        k92.a("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(zzcgcVar);
        if (!defaultUserAgent.equals((String) ew1Var.h)) {
            int i = ja0.c;
            try {
                contextCreatePackageContext = zzcgcVar.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (contextCreatePackageContext == null) {
                zzcgcVar.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(zzcgcVar)).apply();
            }
            ew1Var.h = defaultUserAgent;
        }
        k92.a("User agent is updated.");
        hd2Var.g.zzt();
    }

    private final synchronized void zzba() {
        zzfel zzfelVar = this.zzk;
        if (zzfelVar != null && zzfelVar.zzam) {
            k92.d("Disabling hardware acceleration on an overlay.");
            zzbc();
            return;
        }
        if (!this.zzw && !this.zzs.zzi()) {
            k92.d("Enabling hardware acceleration on an AdView.");
            zzbe();
            return;
        }
        k92.d("Enabling hardware acceleration on an overlay.");
        zzbe();
    }

    private final synchronized void zzbb() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        hd2.B.g.zzr();
    }

    private final synchronized void zzbc() {
        try {
            if (!this.zzx) {
                setLayerType(1, null);
            }
            this.zzx = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzbd(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", true != z ? "0" : "1");
        zzd("onAdVisibilityChanged", map);
    }

    private final synchronized void zzbe() {
        try {
            if (this.zzx) {
                setLayerType(0, null);
            }
            this.zzx = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzbf(String str) {
        try {
            final String str2 = "about:blank";
            if (((Boolean) n42.d.c.zza(zzbbw.zzkq)).booleanValue()) {
                cd2.l.post(new Runnable(str2) { // from class: com.google.android.gms.internal.ads.zzcfd
                    public final /* synthetic */ String zzb = "about:blank";

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzaW(this.zzb);
                    }
                });
            } else {
                super.loadUrl("about:blank");
            }
        } catch (Throwable th) {
            hd2.B.g.zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            k92.j(5);
        }
    }

    private final void zzbg() {
        zzbcd.zza(this.zzM.zza(), this.zzK, "aeh2");
    }

    private final synchronized void zzbh() {
        try {
            Map map = this.zzV;
            if (map != null) {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzccv) it.next()).release();
                }
            }
            this.zzV = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzbi() {
        zzbcj zzbcjVar = this.zzM;
        if (zzbcjVar == null) {
            return;
        }
        zzbcl zzbclVarZza = zzbcjVar.zza();
        zzbcb zzbcbVarZzg = hd2.B.g.zzg();
        if (zzbcbVarZzg != null) {
            zzbcbVarZzg.zzf(zzbclVarZza);
        }
    }

    private final synchronized void zzbj() {
        Boolean boolZzl = hd2.B.g.zzl();
        this.zzy = boolZzl;
        if (boolZzl == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaY(Boolean.TRUE);
            } catch (IllegalStateException unused) {
                zzaY(Boolean.FALSE);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void destroy() {
        View decorView;
        try {
            zzbi();
            d72 d72Var = this.zzQ;
            d72Var.e = false;
            Activity activity = d72Var.b;
            if (activity != null && d72Var.c) {
                Window window = activity.getWindow();
                ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(d72Var.f);
                }
                d72Var.c = false;
            }
            yb2 yb2Var = this.zzp;
            if (yb2Var != null) {
                yb2Var.zzb();
                this.zzp.zzm();
                this.zzp = null;
            }
            this.zzq = null;
            this.zzr = null;
            this.zzo.zzh();
            this.zzG = null;
            this.zzg = null;
            setOnClickListener(null);
            setOnTouchListener(null);
            if (this.zzv) {
                return;
            }
            hd2.B.z.zzd(this);
            zzbh();
            this.zzv = true;
            if (!((Boolean) n42.d.c.zza(zzbbw.zzjS)).booleanValue()) {
                k92.a("Destroying the WebView immediately...");
                zzX();
            } else {
                k92.a("Initiating WebView self destruct sequence in 3...");
                k92.a("Loading blank page in WebView, 2...");
                zzbf("about:blank");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzaE()) {
            k92.i("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) n42.d.c.zza(zzbbw.zzjT)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzbzo.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaU(str, valueCallback);
                }
            });
        }
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                try {
                    if (!this.zzv) {
                        this.zzo.zzh();
                        hd2.B.z.zzd(this);
                        zzbh();
                        zzbb();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void loadData(String str, String str2, String str3) {
        if (zzaE()) {
            k92.h("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) throws Throwable {
        try {
            try {
                if (zzaE()) {
                    k92.h("#004 The webview is destroyed. Ignoring action.");
                    return;
                } else {
                    super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                    return;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final synchronized void loadUrl(final String str) {
        if (zzaE()) {
            k92.h("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkq)).booleanValue()) {
                cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcff
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzaV(str);
                    }
                });
            } else {
                super.loadUrl(str);
            }
        } catch (Throwable th) {
            hd2.B.g.zzw(th, "AdWebViewImpl.loadUrl");
            k92.j(5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej, defpackage.b22
    public final void onAdClicked() {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final synchronized void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            boolean z = true;
            if (!zzaE()) {
                d72 d72Var = this.zzQ;
                d72Var.d = true;
                if (d72Var.e) {
                    d72Var.a();
                }
            }
            if (this.zzY) {
                onResume();
                this.zzY = false;
            }
            boolean z2 = this.zzC;
            zzcer zzcerVar = this.zzo;
            if (zzcerVar == null || !zzcerVar.zzQ()) {
                z = z2;
            } else {
                if (!this.zzD) {
                    this.zzo.zza();
                    this.zzo.zzb();
                    this.zzD = true;
                }
                zzaZ();
            }
            zzbd(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        zzcer zzcerVar;
        View decorView;
        synchronized (this) {
            try {
                if (!zzaE()) {
                    d72 d72Var = this.zzQ;
                    d72Var.d = false;
                    Activity activity = d72Var.b;
                    if (activity != null && d72Var.c) {
                        Window window = activity.getWindow();
                        ViewTreeObserver viewTreeObserver = (window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(d72Var.f);
                        }
                        d72Var.c = false;
                    }
                }
                super.onDetachedFromWindow();
                if (this.zzD && (zzcerVar = this.zzo) != null && zzcerVar.zzQ() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                    this.zzo.zza();
                    this.zzo.zzb();
                    this.zzD = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) n42.d.c.zza(zzbbw.zzke)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            cd2 cd2Var = hd2.B.c;
            cd2.p(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            k92.d("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
            hd2.B.g.zzw(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (zzaE()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaZ = zzaZ();
        yb2 yb2VarZzL = zzL();
        if (yb2VarZzL != null && zZzaZ && yb2VarZzL.r) {
            yb2VarZzL.r = false;
            yb2VarZzL.i.zzaa();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void onMeasure(int r10, int r11) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfi.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final void onPause() {
        if (zzaE()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) n42.d.c.zza(zzbbw.zzlE)).booleanValue() && np1.z("MUTE_AUDIO")) {
                k92.d("Muting webview");
                int i = tw1.a;
                if (!ww1.d.b()) {
                    throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
                }
                xw1.a.createWebView(this).setAudioMuted(true);
            }
        } catch (Exception e) {
            k92.f();
            if (((Boolean) n42.d.c.zza(zzbbw.zzlH)).booleanValue()) {
                hd2.B.g.zzw(e, "AdWebViewImpl.onPause");
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final void onResume() {
        if (zzaE()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) n42.d.c.zza(zzbbw.zzlE)).booleanValue() && np1.z("MUTE_AUDIO")) {
                k92.d("Unmuting webview");
                int i = tw1.a;
                if (!ww1.d.b()) {
                    throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
                }
                xw1.a.createWebView(this).setAudioMuted(false);
            }
        } catch (Exception e) {
            k92.f();
            if (((Boolean) n42.d.c.zza(zzbbw.zzlH)).booleanValue()) {
                hd2.B.g.zzw(e, "AdWebViewImpl.onResume");
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzo.zzQ() || this.zzo.zzO()) {
            zzauo zzauoVar = this.zzc;
            if (zzauoVar != null) {
                zzauoVar.zzd(motionEvent);
            }
            zzbcz zzbczVar = this.zze;
            if (zzbczVar != null) {
                zzbczVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                try {
                    zzber zzberVar = this.zzE;
                    if (zzberVar != null) {
                        zzberVar.zzd(motionEvent);
                    }
                } finally {
                }
            }
        }
        if (zzaE()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcej
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcer) {
            this.zzo = (zzcer) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaE()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception unused) {
            k92.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzA(int i) {
        this.zzN = i;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzC(zzcfl zzcflVar) {
        if (this.zzB != null) {
            k92.e("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzB = zzcflVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcea
    public final zzfel zzD() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfy
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final WebViewClient zzH() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfw
    public final zzauo zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzazj zzJ() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzber zzK() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized yb2 zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized yb2 zzM() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final /* synthetic */ zzcgb zzN() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfv
    public final synchronized zzcgd zzO() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzeem zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized zzeeo zzQ() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfm
    public final zzfeo zzR() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzffk zzS() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final do0 zzT() {
        zzbcz zzbczVar = this.zze;
        return zzbczVar == null ? zzgcj.zzh(null) : zzbczVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized String zzU() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final List zzV() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzW(zzfel zzfelVar, zzfeo zzfeoVar) {
        this.zzk = zzfelVar;
        this.zzl = zzfeoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzX() {
        k92.a("Destroying WebView!");
        zzbb();
        cd2.l.post(new zzcfh(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzY() {
        zzbg();
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.g);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzZ(int i) {
        if (i == 0) {
            zzbcj zzbcjVar = this.zzM;
            zzbcd.zza(zzbcjVar.zza(), this.zzK, "aebb2");
        }
        zzbg();
        this.zzM.zza();
        this.zzM.zza().zzd("close_type", String.valueOf(i));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zzf.g);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zza(String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaA(String str, p21 p21Var) {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzN(str, p21Var);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaC() {
        return this.zzH > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaD(final boolean z, final int i) {
        destroy();
        this.zzX.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzcfe
            @Override // com.google.android.gms.internal.ads.zzbau
            public final void zza(zzbbc.zzt.zza zzaVar) {
                int i2 = zzcfi.zza;
                zzbbc.zzbl.zza zzaVarZzc = zzbbc.zzbl.zzc();
                boolean zZzf = zzaVarZzc.zzf();
                boolean z2 = z;
                if (zZzf != z2) {
                    zzaVarZzc.zzd(z2);
                }
                zzaVarZzc.zze(i);
                zzaVar.zzab(zzaVarZzc.zzbr());
            }
        });
        this.zzX.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaE() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaF() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaG() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized boolean zzaH() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaJ(m62 m62Var, boolean z, boolean z2) {
        this.zzo.zzu(m62Var, z, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaK(String str, String str2, int i) {
        this.zzo.zzv(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaL(boolean z, int i, boolean z2) {
        this.zzo.zzw(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zzo.zzy(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzo.zzz(z, i, str, z2, z3);
    }

    public final zzcer zzaO() {
        return this.zzo;
    }

    public final synchronized Boolean zzaP() {
        return this.zzy;
    }

    public final synchronized void zzaS(String str, ValueCallback valueCallback) {
        if (zzaE()) {
            k92.h("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    public final void zzaT(String str) {
        if (zzaP() == null) {
            zzbj();
        }
        if (zzaP().booleanValue()) {
            zzaS(str, null);
        } else {
            zzaX("javascript:".concat(str));
        }
    }

    public final /* synthetic */ void zzaU(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    public final /* synthetic */ void zzaV(String str) {
        super.loadUrl(str);
    }

    public final /* synthetic */ void zzaW(String str) {
        super.loadUrl("about:blank");
    }

    public final synchronized void zzaX(String str) {
        if (zzaE()) {
            k92.h("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    public final void zzaY(Boolean bool) {
        synchronized (this) {
            this.zzy = bool;
        }
        hd2.B.g.zzy(bool);
    }

    public final boolean zzaZ() {
        int i;
        int iRound;
        if (this.zzo.zzP() || this.zzo.zzQ()) {
            ka2 ka2Var = x32.f.a;
            int iRound2 = Math.round(r0.widthPixels / this.zzi.density);
            int iRound3 = Math.round(r0.heightPixels / this.zzi.density);
            Activity activityZza = this.zzb.zza();
            if (activityZza == null || activityZza.getWindow() == null) {
                i = iRound2;
                iRound = iRound3;
            } else {
                cd2 cd2Var = hd2.B.c;
                int[] iArrM = cd2.m(activityZza);
                int iRound4 = Math.round(iArrM[0] / this.zzi.density);
                iRound = Math.round(iArrM[1] / this.zzi.density);
                i = iRound4;
            }
            int i2 = this.zzS;
            if (i2 != iRound2 || this.zzR != iRound3 || this.zzT != i || this.zzU != iRound) {
                boolean z = (i2 == iRound2 && this.zzR == iRound3) ? false : true;
                this.zzS = iRound2;
                this.zzR = iRound3;
                this.zzT = i;
                this.zzU = iRound;
                new zzbrq(this, "").zzj(iRound2, iRound3, i, iRound, this.zzi.density, this.zzW.getDefaultDisplay().getRotation());
                return z;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaa() {
        if (this.zzJ == null) {
            zzbcj zzbcjVar = this.zzM;
            zzbcd.zza(zzbcjVar.zza(), this.zzK, "aes2");
            this.zzM.zza();
            zzbci zzbciVarZzf = zzbcl.zzf();
            this.zzJ = zzbciVarZzf;
            this.zzM.zzb("native:view_show", zzbciVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.g);
        zzd("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzab() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzac(boolean z) {
        this.zzo.zzi(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzad() {
        d72 d72Var = this.zzQ;
        d72Var.e = true;
        if (d72Var.d) {
            d72Var.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzae(String str, String str2, String str3) throws Throwable {
        Throwable th;
        String str4;
        try {
            try {
                if (zzaE()) {
                    k92.h("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
                String str5 = (String) n42.d.c.zza(zzbbw.zzI);
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("version", str5);
                        jSONObject.put("sdk", "Google Mobile Ads");
                        jSONObject.put("sdkVersion", "12.4.51-000");
                        str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (JSONException unused) {
                    k92.j(5);
                    str4 = null;
                }
                super.loadDataWithBaseURL(str, zzcfu.zzb(str2, str4), "text/html", "UTF-8", null);
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaf() {
        if (this.zzL == null) {
            this.zzM.zza();
            zzbci zzbciVarZzf = zzbcl.zzf();
            this.zzL = zzbciVarZzf;
            this.zzM.zzb("native:view_load", zzbciVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzag(String str, zzbix zzbixVar) {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzA(str, zzbixVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzah() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzai(yb2 yb2Var) {
        this.zzp = yb2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzaj(zzcgd zzcgdVar) {
        this.zzs = zzcgdVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzak(zzazj zzazjVar) {
        this.zzG = zzazjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzal(boolean z) {
        this.zzz = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzam() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzan(Context context) {
        this.zzb.setBaseContext(context);
        this.zzQ.b = this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzao(boolean z) {
        yb2 yb2Var = this.zzp;
        if (yb2Var != null) {
            yb2Var.u(this.zzo.zzP(), z);
        } else {
            this.zzu = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzap(zzbep zzbepVar) {
        this.zzF = zzbepVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzaq(boolean z) {
        try {
            boolean z2 = this.zzw;
            this.zzw = z;
            zzba();
            if (z != z2) {
                if (((Boolean) n42.d.c.zza(zzbbw.zzJ)).booleanValue()) {
                    if (!this.zzs.zzi()) {
                    }
                }
                new zzbrq(this, "").zzl(true != z ? "default" : "expanded");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzar(zzber zzberVar) {
        this.zzE = zzberVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzas(zzeem zzeemVar) {
        this.zzr = zzeemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzat(zzeeo zzeeoVar) {
        this.zzq = zzeeoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzau(int i) {
        yb2 yb2Var = this.zzp;
        if (yb2Var != null) {
            yb2Var.f(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzav(boolean z) {
        this.zzY = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzaw(yb2 yb2Var) {
        this.zzO = yb2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzax(boolean z) {
        yb2 yb2Var;
        int i = this.zzH + (true != z ? -1 : 1);
        this.zzH = i;
        if (i > 0 || (yb2Var = this.zzp) == null) {
            return;
        }
        yb2Var.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final synchronized void zzay(boolean z) {
        if (z) {
            try {
                setBackgroundColor(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        yb2 yb2Var = this.zzp;
        if (yb2Var != null) {
            if (z) {
                yb2Var.q.setBackgroundColor(0);
            } else {
                yb2Var.q.setBackgroundColor(-16777216);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaz(String str, zzbix zzbixVar) {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzM(str, zzbixVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zzb(String str, String str2) {
        zzaT(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzd(String str, Map map) {
        try {
            zze(str, x32.f.a.h(map));
        } catch (JSONException unused) {
            k92.h("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzdG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzcer zzcerVar = this.zzo;
        if (zzcerVar != null) {
            zzcerVar.zzdf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej, defpackage.cc2
    public final synchronized void zzdg() {
        cc2 cc2Var = this.zzg;
        if (cc2Var != null) {
            cc2Var.zzdg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej, defpackage.cc2
    public final synchronized void zzdh() {
        cc2 cc2Var = this.zzg;
        if (cc2Var != null) {
            cc2Var.zzdh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized String zzdi() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        boolean z;
        synchronized (this) {
            z = zzaxvVar.zzj;
            this.zzC = z;
        }
        zzbd(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        k92.d("Dispatching AFMA event: ".concat(sb.toString()));
        zzaT(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized int zzf() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcbk
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final a22 zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzbci zzk() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final zzbcj zzm() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfx, com.google.android.gms.internal.ads.zzcbk
    public final or1 zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzcaz zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized zzccv zzp(String str) {
        Map map = this.zzV;
        if (map == null) {
            return null;
        }
        return (zzccv) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final synchronized zzcfl zzq() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized String zzr() {
        zzfeo zzfeoVar = this.zzl;
        if (zzfeoVar == null) {
            return null;
        }
        return zzfeoVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzt(String str, zzccv zzccvVar) {
        try {
            if (this.zzV == null) {
                this.zzV = new HashMap();
            }
            this.zzV.put(str, zzccvVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzu() {
        yb2 yb2VarZzL = zzL();
        if (yb2VarZzL != null) {
            yb2VarZzL.q.h = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzv(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put("success", true != z ? "0" : "1");
        map.put("duration", Long.toString(j));
        zzd("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final synchronized void zzw() {
        zzbep zzbepVar = this.zzF;
        if (zzbepVar != null) {
            final zzdnb zzdnbVar = (zzdnb) zzbepVar;
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmz
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdnbVar.zzd();
                    } catch (RemoteException e) {
                        k92.i("#007 Could not call remote method.", e);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzz(boolean z) {
        this.zzo.zzD(false);
    }
}
