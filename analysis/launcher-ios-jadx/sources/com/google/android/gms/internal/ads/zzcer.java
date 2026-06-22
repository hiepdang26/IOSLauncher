package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import defpackage.b22;
import defpackage.cd2;
import defpackage.e22;
import defpackage.h42;
import defpackage.hd2;
import defpackage.k92;
import defpackage.m21;
import defpackage.m62;
import defpackage.mc2;
import defpackage.n42;
import defpackage.p21;
import defpackage.qs1;
import defpackage.sv;
import defpackage.yb2;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzcer extends WebViewClient implements zzcgb {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private int zzB;
    private boolean zzC;
    private final zzeds zzE;
    private View.OnAttachStateChangeListener zzF;
    protected zzbxl zza;
    private final zzcej zzc;
    private final zzbav zzd;
    private b22 zzg;
    private mc2 zzh;
    private zzcfz zzi;
    private zzcga zzj;
    private zzbhn zzk;
    private zzbhp zzl;
    private zzdeq zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private e22 zzv;
    private zzbrp zzw;
    private h42 zzx;
    private boolean zzz;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbrk zzy = null;
    private final HashSet zzD = new HashSet(Arrays.asList(((String) n42.d.c.zza(zzbbw.zzfb)).split(",")));

    public zzcer(zzcej zzcejVar, zzbav zzbavVar, boolean z, zzbrp zzbrpVar, zzbrk zzbrkVar, zzeds zzedsVar) {
        this.zzd = zzbavVar;
        this.zzc = zzcejVar;
        this.zzs = z;
        this.zzw = zzbrpVar;
        this.zzE = zzedsVar;
    }

    private static WebResourceResponse zzS() {
        if (((Boolean) n42.d.c.zza(zzbbw.zzaB)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f0, code lost:
    
        r14 = r3.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f8, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fc, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fe, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0100, code lost:
    
        r6 = r14.split(";")[0].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010b, code lost:
    
        r14 = r3.getContentType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0113, code lost:
    
        if (android.text.TextUtils.isEmpty(r14) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0115, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0117, code lost:
    
        r14 = r14.split(";");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011c, code lost:
    
        if (r14.length != 1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011f, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0121, code lost:
    
        if (r0 >= r14.length) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012f, code lost:
    
        if (r14[r0].trim().startsWith("charset") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0131, code lost:
    
        r1 = r14[r0].trim().split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013e, code lost:
    
        if (r1.length <= 1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0140, code lost:
    
        r4 = r1[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0147, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014a, code lost:
    
        r14 = r3.getHeaderFields();
        r10 = new java.util.HashMap(r14.size());
        r14 = r14.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0163, code lost:
    
        if (r14.hasNext() == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0165, code lost:
    
        r0 = r14.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x016f, code lost:
    
        if (r0.getKey() == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0175, code lost:
    
        if (r0.getValue() == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0181, code lost:
    
        if (r0.getValue().isEmpty() != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0183, code lost:
    
        r10.put(r0.getKey(), r0.getValue().get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0199, code lost:
    
        r13 = defpackage.hd2.B.e;
        r8 = r3.getResponseCode();
        r9 = r3.getResponseMessage();
        r11 = r3.getInputStream();
        r13.getClass();
        r5 = new android.webkit.WebResourceResponse(r6, r7, r8, r9, r10, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.webkit.WebResourceResponse zzT(java.lang.String r13, java.util.Map r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcer.zzT(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU(Map map, List list, String str) {
        if (k92.b()) {
            k92.a("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                k92.a("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbix) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzV() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzF;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzW(final View view, final zzbxl zzbxlVar, final int i) {
        if (!zzbxlVar.zzi() || i <= 0) {
            return;
        }
        zzbxlVar.zzg(view);
        if (zzbxlVar.zzi()) {
            cd2.l.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcek
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(view, zzbxlVar, i);
                }
            }, 100L);
        }
    }

    private static final boolean zzX(zzcej zzcejVar) {
        if (zzcejVar.zzD() != null) {
            return zzcejVar.zzD().zzai;
        }
        return false;
    }

    private static final boolean zzY(boolean z, zzcej zzcejVar) {
        return (!z || zzcejVar.zzO().zzi() || zzcejVar.zzU().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb, defpackage.b22
    public final void onAdClicked() {
        b22 b22Var = this.zzg;
        if (b22Var != null) {
            b22Var.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        k92.a("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzj(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Toolbar toolbar;
        synchronized (this.zzf) {
            try {
                if (this.zzc.zzaE()) {
                    k92.a("Blank page loaded, 1...");
                    this.zzc.zzX();
                    return;
                }
                this.zzz = true;
                zzcga zzcgaVar = this.zzj;
                if (zzcgaVar != null) {
                    zzcgaVar.zza();
                    this.zzj = null;
                }
                zzg();
                if (this.zzc.zzL() != null) {
                    if (!((Boolean) n42.d.c.zza(zzbbw.zzkV)).booleanValue() || (toolbar = this.zzc.zzL().A) == null) {
                        return;
                    }
                    toolbar.setSubtitle(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaD(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.EMPTY_MAP);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        k92.a("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzj(uriZza);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = uriZza.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    b22 b22Var = this.zzg;
                    if (b22Var != null) {
                        b22Var.onAdClicked();
                        zzbxl zzbxlVar = this.zza;
                        if (zzbxlVar != null) {
                            zzbxlVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdeq zzdeqVar = this.zzm;
                    if (zzdeqVar != null) {
                        zzdeqVar.zzdG();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzc.zzG().willNotDraw()) {
                k92.h("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzauo zzauoVarZzI = this.zzc.zzI();
                    zzffk zzffkVarZzS = this.zzc.zzS();
                    if (!((Boolean) n42.d.c.zza(zzbbw.zzla)).booleanValue() || zzffkVarZzS == null) {
                        if (zzauoVarZzI != null && zzauoVarZzI.zzf(uriZza)) {
                            Context context = this.zzc.getContext();
                            zzcej zzcejVar = this.zzc;
                            uriZza = zzauoVarZzI.zza(uriZza, context, (View) zzcejVar, zzcejVar.zzi());
                        }
                    } else if (zzauoVarZzI != null && zzauoVarZzI.zzf(uriZza)) {
                        Context context2 = this.zzc.getContext();
                        zzcej zzcejVar2 = this.zzc;
                        uriZza = zzffkVarZzS.zza(uriZza, context2, (View) zzcejVar2, zzcejVar2.zzi());
                    }
                } catch (zzaup unused) {
                    k92.h("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                h42 h42Var = this.zzx;
                if (h42Var == null || h42Var.b()) {
                    zzu(new m62("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null, null), true, false);
                } else {
                    this.zzx.a(str);
                }
            }
        }
        return true;
    }

    public final void zzA(String str, zzbix zzbixVar) {
        synchronized (this.zzf) {
            try {
                List copyOnWriteArrayList = (List) this.zze.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                    this.zze.put(str, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(zzbixVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzB(zzcfz zzcfzVar) {
        this.zzi = zzcfzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzC(int i, int i2) {
        zzbrk zzbrkVar = this.zzy;
        if (zzbrkVar != null) {
            zzbrkVar.zze(i, i2);
        }
    }

    public final void zzD(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzu = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzF() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcel
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzG(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzH(zzcga zzcgaVar) {
        this.zzj = zzcgaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzI(zzcni zzcniVar, zzedh zzedhVar, zzfll zzfllVar) {
        zzL("/click");
        if (zzedhVar == null || zzfllVar == null) {
            zzA("/click", new zzbhv(this.zzm, zzcniVar));
        } else {
            zzA("/click", new zzffo(this.zzm, zzcniVar, zzfllVar, zzedhVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzJ(zzcni zzcniVar) {
        zzL("/click");
        zzA("/click", new zzbhv(this.zzm, zzcniVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzK(zzcni zzcniVar, zzedh zzedhVar, zzdsk zzdskVar) {
        zzL("/open");
        zzA("/open", new zzbjj(this.zzx, this.zzy, zzedhVar, zzdskVar, zzcniVar));
    }

    public final void zzL(String str) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzM(String str, zzbix zzbixVar) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.remove(zzbixVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzN(String str, p21 p21Var) {
        synchronized (this.zzf) {
            try {
                List<zzbix> list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (zzbix zzbixVar : list) {
                    if (p21Var.apply(zzbixVar)) {
                        arrayList.add(zzbixVar);
                    }
                }
                list.removeAll(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzO() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final boolean zzP() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzQ() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzR(b22 b22Var, zzbhn zzbhnVar, mc2 mc2Var, zzbhp zzbhpVar, e22 e22Var, boolean z, zzbja zzbjaVar, h42 h42Var, zzbrr zzbrrVar, zzbxl zzbxlVar, final zzedh zzedhVar, final zzfll zzfllVar, zzdsk zzdskVar, zzbjr zzbjrVar, zzdeq zzdeqVar, zzbjq zzbjqVar, zzbjk zzbjkVar, zzbiy zzbiyVar, zzcni zzcniVar) {
        h42 h42Var2 = h42Var == null ? new h42(this.zzc.getContext(), zzbxlVar) : h42Var;
        this.zzy = new zzbrk(this.zzc, zzbrrVar);
        this.zza = zzbxlVar;
        zzbbn zzbbnVar = zzbbw.zzaI;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            zzA("/adMetadata", new zzbhm(zzbhnVar));
        }
        if (zzbhpVar != null) {
            zzA("/appEvent", new zzbho(zzbhpVar));
        }
        zzA("/backButton", zzbiw.zzj);
        zzA("/refresh", zzbiw.zzk);
        zzA("/canOpenApp", zzbiw.zzb);
        zzA("/canOpenURLs", zzbiw.zza);
        zzA("/canOpenIntents", zzbiw.zzc);
        zzA("/close", zzbiw.zzd);
        zzA("/customClose", zzbiw.zze);
        zzA("/instrument", zzbiw.zzn);
        zzA("/delayPageLoaded", zzbiw.zzp);
        zzA("/delayPageClosed", zzbiw.zzq);
        zzA("/getLocationInfo", zzbiw.zzr);
        zzA("/log", zzbiw.zzg);
        zzA("/mraid", new zzbje(h42Var2, this.zzy, zzbrrVar));
        zzbrp zzbrpVar = this.zzw;
        if (zzbrpVar != null) {
            zzA("/mraidLoaded", zzbrpVar);
        }
        h42 h42Var3 = h42Var2;
        zzA("/open", new zzbjj(h42Var3, this.zzy, zzedhVar, zzdskVar, zzcniVar));
        zzA("/precache", new zzccw());
        zzA("/touch", zzbiw.zzi);
        zzA("/video", zzbiw.zzl);
        zzA("/videoMeta", zzbiw.zzm);
        if (zzedhVar == null || zzfllVar == null) {
            zzA("/click", new zzbhv(zzdeqVar, zzcniVar));
            zzA("/httpTrack", zzbiw.zzf);
        } else {
            zzA("/click", new zzffo(zzdeqVar, zzcniVar, zzfllVar, zzedhVar));
            zzA("/httpTrack", new zzbix() { // from class: com.google.android.gms.internal.ads.zzffp
                @Override // com.google.android.gms.internal.ads.zzbix
                public final void zza(Object obj, Map map) {
                    zzcea zzceaVar = (zzcea) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        k92.h("URL missing from httpTrack GMSG.");
                    } else {
                        if (!zzceaVar.zzD().zzai) {
                            zzfllVar.zzc(str, null);
                            return;
                        }
                        zzedh zzedhVar2 = zzedhVar;
                        hd2.B.j.getClass();
                        zzedhVar2.zzd(new zzedj(System.currentTimeMillis(), ((zzcfm) zzceaVar).zzR().zzb, str, 2));
                    }
                }
            });
        }
        if (hd2.B.x.zzp(this.zzc.getContext())) {
            Map map = new HashMap();
            if (this.zzc.zzD() != null) {
                map = this.zzc.zzD().zzaw;
            }
            zzA("/logScionEvent", new zzbjd(this.zzc.getContext(), map));
        }
        if (zzbjaVar != null) {
            zzA("/setInterstitialProperties", new zzbiz(zzbjaVar));
        }
        zzbbu zzbbuVar = n42Var.c;
        if (zzbjrVar != null && ((Boolean) zzbbuVar.zza(zzbbw.zzia)).booleanValue()) {
            zzA("/inspectorNetworkExtras", zzbjrVar);
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zzit)).booleanValue() && zzbjqVar != null) {
            zzA("/shareSheet", zzbjqVar);
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zziy)).booleanValue() && zzbjkVar != null) {
            zzA("/inspectorOutOfContextTest", zzbjkVar);
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zziC)).booleanValue() && zzbiyVar != null) {
            zzA("/inspectorStorage", zzbiyVar);
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zzkD)).booleanValue()) {
            zzA("/bindPlayStoreOverlay", zzbiw.zzu);
            zzA("/presentPlayStoreOverlay", zzbiw.zzv);
            zzA("/expandPlayStoreOverlay", zzbiw.zzw);
            zzA("/collapsePlayStoreOverlay", zzbiw.zzx);
            zzA("/closePlayStoreOverlay", zzbiw.zzy);
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zzcT)).booleanValue()) {
            zzA("/setPAIDPersonalizationEnabled", zzbiw.zzA);
            zzA("/resetPAID", zzbiw.zzz);
        }
        if (((Boolean) zzbbuVar.zza(zzbbw.zzkU)).booleanValue()) {
            zzcej zzcejVar = this.zzc;
            if (zzcejVar.zzD() != null && zzcejVar.zzD().zzar) {
                zzA("/writeToLocalStorage", zzbiw.zzB);
                zzA("/clearLocalStorageKeys", zzbiw.zzC);
            }
        }
        this.zzg = b22Var;
        this.zzh = mc2Var;
        this.zzk = zzbhnVar;
        this.zzl = zzbhpVar;
        this.zzv = e22Var;
        this.zzx = h42Var3;
        this.zzm = zzdeqVar;
        this.zzn = z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02b8 A[Catch: NoClassDefFoundError -> 0x0022, Exception -> 0x0025, TryCatch #12 {Exception -> 0x0025, NoClassDefFoundError -> 0x0022, blocks: (B:3:0x000c, B:5:0x0019, B:10:0x0028, B:12:0x003a, B:14:0x0041, B:16:0x004d, B:18:0x0069, B:20:0x0082, B:22:0x0099, B:23:0x009c, B:25:0x009f, B:28:0x00bb, B:31:0x00d5, B:33:0x00e6, B:78:0x01bb, B:50:0x0170, B:97:0x02a2, B:100:0x02b2, B:102:0x02b8, B:104:0x02c6, B:86:0x022a, B:87:0x0253, B:85:0x0202, B:49:0x014b, B:32:0x00de, B:88:0x0254, B:90:0x025e, B:92:0x0264, B:94:0x0297), top: B:112:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f7 A[Catch: all -> 0x01ae, TryCatch #7 {all -> 0x01ae, blocks: (B:71:0x0193, B:73:0x01a5, B:77:0x01b1, B:81:0x01e5, B:83:0x01f7, B:84:0x01fe), top: B:111:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a2 A[Catch: NoClassDefFoundError -> 0x0022, Exception -> 0x0025, TryCatch #12 {Exception -> 0x0025, NoClassDefFoundError -> 0x0022, blocks: (B:3:0x000c, B:5:0x0019, B:10:0x0028, B:12:0x003a, B:14:0x0041, B:16:0x004d, B:18:0x0069, B:20:0x0082, B:22:0x0099, B:23:0x009c, B:25:0x009f, B:28:0x00bb, B:31:0x00d5, B:33:0x00e6, B:78:0x01bb, B:50:0x0170, B:97:0x02a2, B:100:0x02b2, B:102:0x02b8, B:104:0x02c6, B:86:0x022a, B:87:0x0253, B:85:0x0202, B:49:0x014b, B:32:0x00de, B:88:0x0254, B:90:0x025e, B:92:0x0264, B:94:0x0297), top: B:112:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.webkit.WebResourceResponse zzc(java.lang.String r20, java.util.Map r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcer.zzc(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final h42 zzd() {
        return this.zzx;
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzdeq zzdeqVar = this.zzm;
        if (zzdeqVar != null) {
            zzdeqVar.zzdG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzdeq zzdeqVar = this.zzm;
        if (zzdeqVar != null) {
            zzdeqVar.zzdf();
        }
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzz && this.zzB <= 0) || this.zzA || this.zzo)) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue() && this.zzc.zzm() != null) {
                zzbcd.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzcfz zzcfzVar = this.zzi;
            boolean z = false;
            if (!this.zzA && !this.zzo) {
                z = true;
            }
            zzcfzVar.zza(z, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzaf();
    }

    public final void zzh() {
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            zzbxlVar.zze();
            this.zza = null;
        }
        zzV();
        synchronized (this.zzf) {
            try {
                this.zze.clear();
                this.zzg = null;
                this.zzh = null;
                this.zzi = null;
                this.zzj = null;
                this.zzk = null;
                this.zzl = null;
                this.zzn = false;
                this.zzs = false;
                this.zzt = false;
                this.zzv = null;
                this.zzx = null;
                this.zzw = null;
                zzbrk zzbrkVar = this.zzy;
                if (zzbrkVar != null) {
                    zzbrkVar.zza(true);
                    this.zzy = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi(boolean z) {
        this.zzC = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzj(Uri uri) {
        k92.a("Received GMSG: ".concat(String.valueOf(uri)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            k92.a("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (!((Boolean) n42.d.c.zza(zzbbw.zzgb)).booleanValue() || hd2.B.g.zzg() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcem
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i = zzcer.zzb;
                    hd2.B.g.zzg().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        zzbbn zzbbnVar = zzbbw.zzfa;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && this.zzD.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) n42Var.c.zza(zzbbw.zzfc)).intValue()) {
                k92.a("Parsing gmsg query params on BG thread: ".concat(path));
                cd2 cd2Var = hd2.B.c;
                cd2Var.getClass();
                zzgcj.zzr(zzgcj.zzj(new sv(uri, 4), cd2Var.k), new zzcep(this, list, path, uri), zzbzo.zze);
                return;
            }
        }
        cd2 cd2Var2 = hd2.B.c;
        zzU(cd2.l(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzk() {
        zzbav zzbavVar = this.zzd;
        if (zzbavVar != null) {
            zzbavVar.zzc(10005);
        }
        this.zzA = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzg();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzB++;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzm() {
        this.zzB--;
        zzg();
    }

    public final void zzn() {
        this.zzc.zzad();
        yb2 yb2VarZzL = this.zzc.zzL();
        if (yb2VarZzL != null) {
            yb2VarZzL.q.removeView(yb2VarZzL.k);
            yb2VarZzL.t(true);
        }
    }

    public final /* synthetic */ void zzo(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    public final /* synthetic */ void zzp(View view, zzbxl zzbxlVar, int i) {
        zzW(view, zzbxlVar, i - 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzq(int i, int i2, boolean z) {
        zzbrp zzbrpVar = this.zzw;
        if (zzbrpVar != null) {
            zzbrpVar.zzb(i, i2);
        }
        zzbrk zzbrkVar = this.zzy;
        if (zzbrkVar != null) {
            zzbrkVar.zzd(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzr() {
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            WebView webViewZzG = this.zzc.zzG();
            WeakHashMap weakHashMap = qs1.a;
            if (webViewZzG.isAttachedToWindow()) {
                zzW(webViewZzG, zzbxlVar, 10);
                return;
            }
            zzV();
            zzceo zzceoVar = new zzceo(this, zzbxlVar);
            this.zzF = zzceoVar;
            ((View) this.zzc).addOnAttachStateChangeListener(zzceoVar);
        }
    }

    public final void zzu(m62 m62Var, boolean z, boolean z2) {
        zzcej zzcejVar = this.zzc;
        boolean zZzaF = zzcejVar.zzaF();
        boolean z3 = zzY(zZzaF, zzcejVar) || z2;
        boolean z4 = z3 || !z;
        b22 b22Var = z3 ? null : this.zzg;
        mc2 mc2Var = zZzaF ? null : this.zzh;
        e22 e22Var = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(m62Var, b22Var, mc2Var, e22Var, zzcejVar2.zzn(), zzcejVar2, z4 ? null : this.zzm));
    }

    public final void zzv(String str, String str2, int i) {
        zzeds zzedsVar = this.zzE;
        zzcej zzcejVar = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcejVar, zzcejVar.zzn(), str, str2, zzedsVar));
    }

    public final void zzw(boolean z, int i, boolean z2) {
        zzcej zzcejVar = this.zzc;
        boolean zZzY = zzY(zzcejVar.zzaF(), zzcejVar);
        boolean z3 = true;
        if (!zZzY && z2) {
            z3 = false;
        }
        b22 b22Var = zZzY ? null : this.zzg;
        mc2 mc2Var = this.zzh;
        e22 e22Var = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(b22Var, mc2Var, e22Var, zzcejVar2, z, i, zzcejVar2.zzn(), z3 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null));
    }

    public final void zzx(AdOverlayInfoParcel adOverlayInfoParcel) {
        m62 m62Var;
        zzbrk zzbrkVar = this.zzy;
        boolean zZzf = zzbrkVar != null ? zzbrkVar.zzf() : false;
        m21 m21Var = hd2.B.b;
        m21.f(this.zzc.getContext(), adOverlayInfoParcel, !zZzf);
        zzbxl zzbxlVar = this.zza;
        if (zzbxlVar != null) {
            String str = adOverlayInfoParcel.r;
            if (str == null && (m62Var = adOverlayInfoParcel.g) != null) {
                str = m62Var.h;
            }
            zzbxlVar.zzh(str);
        }
    }

    public final void zzy(boolean z, int i, String str, String str2, boolean z2) {
        zzcej zzcejVar = this.zzc;
        boolean zZzaF = zzcejVar.zzaF();
        boolean zZzY = zzY(zZzaF, zzcejVar);
        boolean z3 = true;
        if (!zZzY && z2) {
            z3 = false;
        }
        b22 b22Var = zZzY ? null : this.zzg;
        zzceq zzceqVar = zZzaF ? null : new zzceq(this.zzc, this.zzh);
        zzbhn zzbhnVar = this.zzk;
        zzbhp zzbhpVar = this.zzl;
        e22 e22Var = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(b22Var, zzceqVar, zzbhnVar, zzbhpVar, e22Var, zzcejVar2, z, i, str, str2, zzcejVar2.zzn(), z3 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null));
    }

    public final void zzz(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcej zzcejVar = this.zzc;
        boolean zZzaF = zzcejVar.zzaF();
        boolean zZzY = zzY(zZzaF, zzcejVar);
        boolean z4 = true;
        if (!zZzY && z2) {
            z4 = false;
        }
        b22 b22Var = zZzY ? null : this.zzg;
        zzceq zzceqVar = zZzaF ? null : new zzceq(this.zzc, this.zzh);
        zzbhn zzbhnVar = this.zzk;
        zzbhp zzbhpVar = this.zzl;
        e22 e22Var = this.zzv;
        zzcej zzcejVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(b22Var, zzceqVar, zzbhnVar, zzbhpVar, e22Var, zzcejVar2, z, i, str, zzcejVar2.zzn(), z4 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null, z3));
    }
}
