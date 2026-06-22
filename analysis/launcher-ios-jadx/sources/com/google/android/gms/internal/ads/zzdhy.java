package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import defpackage.cd2;
import defpackage.hd2;
import defpackage.k92;
import defpackage.ka2;
import defpackage.n42;
import defpackage.nj;
import defpackage.or1;
import defpackage.os;
import defpackage.p72;
import defpackage.s72;
import defpackage.us;
import defpackage.x32;
import defpackage.z71;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdhy implements zzdjj {
    private p72 zzC;
    private final Context zza;
    private final zzdjm zzb;
    private final JSONObject zzc;
    private final zzdoa zzd;
    private final zzdjb zze;
    private final zzauo zzf;
    private final zzcxi zzg;
    private final zzcwo zzh;
    private final zzdeo zzi;
    private final zzfel zzj;
    private final or1 zzk;
    private final zzffg zzl;
    private final zzcof zzm;
    private final zzdkf zzn;
    private final nj zzo;
    private final zzdek zzp;
    private final zzfll zzq;
    private final zzdpq zzr;
    private final zzfkf zzs;
    private final zzeds zzt;
    private boolean zzv;
    private boolean zzu = false;
    private boolean zzw = false;
    private boolean zzx = false;
    private Point zzy = new Point();
    private Point zzz = new Point();
    private long zzA = 0;
    private long zzB = 0;

    public zzdhy(Context context, zzdjm zzdjmVar, JSONObject jSONObject, zzdoa zzdoaVar, zzdjb zzdjbVar, zzauo zzauoVar, zzcxi zzcxiVar, zzcwo zzcwoVar, zzdeo zzdeoVar, zzfel zzfelVar, or1 or1Var, zzffg zzffgVar, zzcof zzcofVar, zzdkf zzdkfVar, nj njVar, zzdek zzdekVar, zzfll zzfllVar, zzfkf zzfkfVar, zzeds zzedsVar, zzdpq zzdpqVar) {
        this.zza = context;
        this.zzb = zzdjmVar;
        this.zzc = jSONObject;
        this.zzd = zzdoaVar;
        this.zze = zzdjbVar;
        this.zzf = zzauoVar;
        this.zzg = zzcxiVar;
        this.zzh = zzcwoVar;
        this.zzi = zzdeoVar;
        this.zzj = zzfelVar;
        this.zzk = or1Var;
        this.zzl = zzffgVar;
        this.zzm = zzcofVar;
        this.zzn = zzdkfVar;
        this.zzo = njVar;
        this.zzp = zzdekVar;
        this.zzq = zzfllVar;
        this.zzs = zzfkfVar;
        this.zzt = zzedsVar;
        this.zzr = zzdpqVar;
    }

    private final String zzD(View view) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzdf)).booleanValue()) {
            return null;
        }
        try {
            return this.zzf.zzc().zzh(this.zza, view, null);
        } catch (Exception unused) {
            k92.e("Exception getting data.");
            return null;
        }
    }

    private final String zzE(View view, Map map) {
        if (map != null && view != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int iZzc = this.zze.zzc();
        if (iZzc == 1) {
            return "1099";
        }
        if (iZzc == 2) {
            return "2099";
        }
        if (iZzc != 6) {
            return null;
        }
        return "3099";
    }

    private final boolean zzF(String str) {
        JSONObject jSONObjectOptJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        return jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(str, false);
    }

    private final boolean zzG() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zzH(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) n42.d.c.zza(zzbbw.zzdf)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            cd2 cd2Var = hd2.B.c;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            zzdhu zzdhuVar = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            try {
                int i = displayMetrics.widthPixels;
                x32 x32Var = x32.f;
                jSONObject7.put("width", x32Var.a.e(context, i));
                jSONObject7.put("height", x32Var.a.e(context, displayMetrics.heightPixels));
            } catch (JSONException unused) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", jSONObject7);
            if (((Boolean) n42.d.c.zza(zzbbw.zzhK)).booleanValue()) {
                this.zzd.zzl("/clickRecorded", new zzdhv(this, zzdhuVar));
            } else {
                this.zzd.zzl("/logScionEvent", new zzdht(this, objArr == true ? 1 : 0));
            }
            this.zzd.zzl("/nativeImpression", new zzdhx(this, objArr2 == true ? 1 : 0));
            zzbzr.zza(this.zzd.zzg("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzu) {
                return true;
            }
            this.zzu = hd2.B.m.l(this.zza, this.zzk.g, this.zzj.zzC.toString(), this.zzl.zzf);
            return true;
        } catch (JSONException unused2) {
            k92.f();
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzA() {
        if (zza() == 0) {
            return true;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue()) {
            return this.zzl.zzi.zzj;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzB() {
        return zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final boolean zzC(Bundle bundle) {
        JSONObject jSONObjectG;
        if (!zzF("impression_reporting")) {
            k92.e("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        ka2 ka2Var = x32.f.a;
        ka2Var.getClass();
        if (bundle != null) {
            try {
                jSONObjectG = ka2Var.g(bundle);
            } catch (JSONException unused) {
                k92.f();
                jSONObjectG = null;
            }
        } else {
            jSONObjectG = null;
        }
        return zzH(null, null, null, null, ((Boolean) n42.d.c.zza(zzbbw.zzkA)).booleanValue() ? zzD(null) : null, jSONObjectG, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final int zza() {
        if (this.zzl.zzi == null) {
            return 0;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue()) {
            return this.zzl.zzi.zzi;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectS = z71.s(context, map, map2, view, scaleType);
        JSONObject jSONObjectV = z71.v(context, view);
        JSONObject jSONObjectU = z71.u(view);
        JSONObject jSONObjectT = z71.t(context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", jSONObjectS);
            jSONObject.put("ad_view_signal", jSONObjectV);
            jSONObject.put("scroll_view_signal", jSONObjectU);
            jSONObject.put("lock_screen_signal", jSONObjectT);
            return jSONObject;
        } catch (JSONException unused) {
            k92.f();
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        JSONObject jSONObjectZze = zze(view, map, map2, scaleType);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzx && zzG()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (jSONObjectZze != null) {
                jSONObject.put("nas", jSONObjectZze);
                return jSONObject;
            }
        } catch (JSONException unused) {
            k92.f();
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzg() {
        try {
            p72 p72Var = this.zzC;
            if (p72Var != null) {
                p72Var.zze();
            }
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzh() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzi() {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzj(s72 s72Var) {
        try {
            if (this.zzw) {
                return;
            }
            if (s72Var == null) {
                zzdjb zzdjbVar = this.zze;
                if (zzdjbVar.zzk() != null) {
                    this.zzw = true;
                    this.zzq.zzc(zzdjbVar.zzk().h, this.zzs);
                    zzg();
                    return;
                }
            }
            this.zzw = true;
            this.zzq.zzc(s72Var.zzf(), this.zzs);
            zzg();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject jSONObjectS = z71.s(context, map, map2, view2, scaleType);
        JSONObject jSONObjectV = z71.v(context, view2);
        JSONObject jSONObjectU = z71.u(view2);
        JSONObject jSONObjectT = z71.t(context, view2);
        String strZzE = zzE(view, map);
        zzn(true == ((Boolean) n42.d.c.zza(zzbbw.zzdm)).booleanValue() ? view2 : view, jSONObjectV, jSONObjectS, jSONObjectU, jSONObjectT, strZzE, z71.r(strZzE, context, this.zzz, this.zzy), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzl(String str) {
        zzn(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzm(Bundle bundle) {
        if (bundle == null) {
            k92.d("Click data is null. No click is reported.");
            return;
        }
        if (!zzF("click_reporting")) {
            k92.e("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
            return;
        }
        Bundle bundle2 = bundle.getBundle("click_signal");
        JSONObject jSONObjectG = null;
        String string = bundle2 != null ? bundle2.getString("asset_id") : null;
        ka2 ka2Var = x32.f.a;
        ka2Var.getClass();
        try {
            jSONObjectG = ka2Var.g(bundle);
        } catch (JSONException unused) {
            k92.f();
        }
        zzn(null, null, null, null, null, string, null, jSONObjectG, false, false);
    }

    public final void zzn(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        String strZze;
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzc);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.zzb.zzc(this.zze.zzA()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zze.zzc());
            jSONObject8.put("view_aware_api_used", z);
            zzbes zzbesVar = this.zzl.zzi;
            jSONObject8.put("custom_mute_requested", zzbesVar != null && zzbesVar.zzg);
            jSONObject8.put("custom_mute_enabled", (this.zze.zzH().isEmpty() || this.zze.zzk() == null) ? false : true);
            if (this.zzn.zza() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            ((us) this.zzo).getClass();
            jSONObject8.put("timestamp", System.currentTimeMillis());
            if (this.zzx && zzG()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.zzb.zzc(this.zze.zzA()) != null);
            try {
                JSONObject jSONObjectOptJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                strZze = this.zzf.zzc().zze(this.zza, jSONObjectOptJSONObject.optString("click_string"), view);
            } catch (Exception unused) {
                k92.f();
                strZze = null;
            }
            jSONObject8.put("click_signals", strZze);
            zzbbn zzbbnVar = zzbbw.zzee;
            n42 n42Var = n42.d;
            zzbbu zzbbuVar = n42Var.c;
            zzbbu zzbbuVar2 = n42Var.c;
            if (((Boolean) zzbbuVar.zza(zzbbnVar)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzbbuVar2.zza(zzbbw.zzhO)).booleanValue() && os.k()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzbbuVar2.zza(zzbbw.zzhP)).booleanValue() && os.k()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            ((us) this.zzo).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", jCurrentTimeMillis - this.zzA);
            jSONObject9.put("time_from_last_touch", jCurrentTimeMillis - this.zzB);
            jSONObject7.put("touch_signal", jSONObject9);
            if (this.zzj.zzai) {
                JSONObject jSONObject10 = (JSONObject) this.zzc.get("tracking_urls_and_actions");
                String string = jSONObject10 != null ? jSONObject10.getString("gws_query_id") : null;
                if (string != null) {
                    this.zzt.zzq(string, this.zze);
                }
            }
            zzbzr.zza(this.zzd.zzg("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException unused2) {
            k92.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        JSONObject jSONObject;
        boolean z2 = false;
        if (this.zzc.optBoolean("allow_sdk_custom_click_gesture", false)) {
            if (((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue()) {
                z2 = true;
            }
        }
        if (!z2) {
            if (!this.zzx) {
                k92.d("Custom click reporting failed. enableCustomClickGesture is not set.");
                return;
            } else if (!zzG()) {
                k92.d("Custom click reporting failed. Ad unit id not in the allow list.");
                return;
            }
        }
        JSONObject jSONObjectS = z71.s(this.zza, map, map2, view2, scaleType);
        JSONObject jSONObjectV = z71.v(this.zza, view2);
        boolean z3 = z2;
        JSONObject jSONObjectU = z71.u(view2);
        JSONObject jSONObjectT = z71.t(this.zza, view2);
        String strZzE = zzE(view, map);
        JSONObject jSONObjectR = z71.r(strZzE, this.zza, this.zzz, this.zzy);
        if (z3) {
            try {
                JSONObject jSONObject2 = this.zzc;
                Point point = this.zzz;
                Point point2 = this.zzy;
                try {
                    jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        if (point != null) {
                            jSONObject3.put("x", point.x);
                            jSONObject3.put("y", point.y);
                        }
                        if (point2 != null) {
                            jSONObject4.put("x", point2.x);
                            jSONObject4.put("y", point2.y);
                        }
                        jSONObject.put("start_point", jSONObject3);
                        jSONObject.put("end_point", jSONObject4);
                        jSONObject.put("duration_ms", i);
                    } catch (Exception unused) {
                        k92.f();
                    }
                } catch (Exception unused2) {
                    jSONObject = null;
                }
                jSONObject2.put("custom_click_gesture_signal", jSONObject);
            } catch (JSONException e) {
                k92.f();
                hd2.B.g.zzw(e, "FirstPartyNativeAdCore.performCustomClickGesture");
            }
        }
        zzn(view2, jSONObjectV, jSONObjectS, jSONObjectU, jSONObjectT, strZzE, jSONObjectR, null, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzbzr.zza(this.zzd.zzg("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException unused) {
            k92.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        zzH(z71.v(context, view), z71.s(context, map, map2, view, scaleType), z71.u(view), z71.t(context, view), zzD(view), null, z71.w(context, this.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzr() {
        zzH(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzs(View view, MotionEvent motionEvent, View view2) {
        int[] iArr = new int[2];
        if (view2 != null) {
            view2.getLocationOnScreen(iArr);
        }
        this.zzy = new Point(((int) motionEvent.getRawX()) - iArr[0], ((int) motionEvent.getRawY()) - iArr[1]);
        ((us) this.zzo).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.zzB = jCurrentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
            this.zzA = jCurrentTimeMillis;
            this.zzz = this.zzy;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzy;
        motionEventObtain.setLocation(point.x, point.y);
        this.zzf.zzd(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzt(Bundle bundle) {
        if (bundle == null) {
            k92.d("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!zzF("touch_reporting")) {
            k92.e("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
            return;
        }
        this.zzf.zzc().zzl((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzu(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            k92.h("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdkf zzdkfVar = this.zzn;
        if (view == null) {
            return;
        }
        view.setOnClickListener(zzdkfVar);
        view.setClickable(true);
        zzdkfVar.zzc = new WeakReference(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzv() {
        this.zzx = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzw(p72 p72Var) {
        this.zzC = p72Var;
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzx(zzbgx zzbgxVar) {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzc(zzbgxVar);
        } else {
            k92.h("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (!this.zzv) {
            this.zzp.zza(view);
            this.zzv = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzi(this);
        boolean zX = z71.x(this.zzk.i);
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                if (view2 != null) {
                    if (zX) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = (View) ((WeakReference) ((Map.Entry) it2.next()).getValue()).get();
                if (view3 != null) {
                    if (zX) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjj
    public final void zzz(View view, Map map) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzv = false;
    }
}
