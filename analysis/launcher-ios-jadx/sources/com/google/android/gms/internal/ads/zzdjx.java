package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.k92;
import defpackage.n42;
import defpackage.z71;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdjx extends zzbfg implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdkx {
    public static final zzfxr zza = zzfxr.zzp("2011", "1009", "3010");
    private final String zzb;
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzgcu zzf;
    private View zzg;
    private zzdiw zzi;
    private zzaxx zzj;
    private zzbfa zzl;
    private boolean zzm;
    private GestureDetector zzo;
    private Map zzc = new HashMap();
    private he0 zzk = null;
    private boolean zzn = false;
    private final int zzh = 242402000;

    public zzdjx(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzb = str;
        hd2 hd2Var = hd2.B;
        zzcab zzcabVar = hd2Var.A;
        zzcab.zza(frameLayout, this);
        zzcab zzcabVar2 = hd2Var.A;
        zzcab.zzb(frameLayout, this);
        this.zzf = zzbzo.zze;
        this.zzj = new zzaxx(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzt(String str) {
        DisplayMetrics displayMetrics;
        try {
            View frameLayout = new FrameLayout(this.zze.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Context context = this.zze.getContext();
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            if (!TextUtils.isEmpty(str)) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                    try {
                        byte[] bArrDecode = Base64.decode(str, 0);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        bitmapDrawable.setTileModeXY(tileMode, tileMode);
                        frameLayout.setBackground(bitmapDrawable);
                    } catch (IllegalArgumentException unused) {
                        k92.j(5);
                    }
                }
            }
            this.zze.addView(frameLayout);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzu() {
        this.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdjw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzs();
            }
        });
    }

    private final synchronized void zzv() {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue() || this.zzi.zza() == 0) {
            return;
        }
        this.zzo = new GestureDetector(this.zzd.getContext(), new zzdkd(this.zzi, this));
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar == null || !zzdiwVar.zzU()) {
            return;
        }
        this.zzi.zzv();
        this.zzi.zzD(view, this.zzd, zzl(), zzm(), false);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar != null) {
            FrameLayout frameLayout = this.zzd;
            zzdiwVar.zzB(frameLayout, zzl(), zzm(), zzdiw.zzX(frameLayout));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar != null) {
            FrameLayout frameLayout = this.zzd;
            zzdiwVar.zzB(frameLayout, zzl(), zzm(), zzdiw.zzX(frameLayout));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar != null) {
            zzdiwVar.zzK(view, motionEvent, this.zzd);
            if (((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue() && this.zzo != null && this.zzi.zza() != 0) {
                this.zzo.onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized he0 zzb(String str) {
        return new gy0(zzg(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zzc() {
        try {
            if (this.zzn) {
                return;
            }
            zzdiw zzdiwVar = this.zzi;
            if (zzdiwVar != null) {
                zzdiwVar.zzS(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzd(he0 he0Var) {
        onTouch(this.zzd, (MotionEvent) gy0.r(he0Var));
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zzdv(String str, he0 he0Var) {
        zzq(str, (View) gy0.r(he0Var), true);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zzdw(he0 he0Var) {
        this.zzi.zzM((View) gy0.r(he0Var));
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zzdx(zzbfa zzbfaVar) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbfaVar;
            zzdiw zzdiwVar = this.zzi;
            if (zzdiwVar != null) {
                zzdiwVar.zzc().zzb(zzbfaVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zzdy(he0 he0Var) {
        if (this.zzn) {
            return;
        }
        this.zzk = he0Var;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zzdz(he0 he0Var) {
        if (this.zzn) {
            return;
        }
        Object objR = gy0.r(he0Var);
        if (!(objR instanceof zzdiw)) {
            k92.h("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar != null) {
            zzdiwVar.zzS(this);
        }
        zzu();
        zzdiw zzdiwVar2 = (zzdiw) objR;
        this.zzi = zzdiwVar2;
        zzdiwVar2.zzR(this);
        this.zzi.zzJ(this.zzd);
        this.zzi.zzu(this.zze);
        if (this.zzm) {
            this.zzi.zzc().zzb(this.zzl);
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzdz)).booleanValue() && !TextUtils.isEmpty(this.zzi.zzg())) {
            zzt(this.zzi.zzg());
        }
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final synchronized void zze(he0 he0Var, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized View zzg(String str) {
        WeakReference weakReference;
        if (!this.zzn && (weakReference = (WeakReference) this.zzc.get(str)) != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final FrameLayout zzh() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final zzaxx zzi() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final he0 zzj() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized String zzk() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized Map zzl() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized Map zzm() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized Map zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized JSONObject zzo() {
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar == null) {
            return null;
        }
        return zzdiwVar.zzi(this.zzd, zzl(), zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized JSONObject zzp() {
        zzdiw zzdiwVar = this.zzi;
        if (zzdiwVar == null) {
            return null;
        }
        return zzdiwVar.zzj(this.zzd, zzl(), zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzdkx
    public final synchronized void zzq(String str, View view, boolean z) {
        if (!this.zzn) {
            if (view == null) {
                this.zzc.remove(str);
                return;
            }
            this.zzc.put(str, new WeakReference(view));
            if (!"1098".equals(str) && !"3011".equals(str)) {
                if (z71.x(this.zzh)) {
                    view.setOnTouchListener(this);
                }
                view.setClickable(true);
                view.setOnClickListener(this);
            }
        }
    }

    public final FrameLayout zzr() {
        return this.zzd;
    }

    public final /* synthetic */ void zzs() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
