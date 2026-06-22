package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import defpackage.cd2;
import defpackage.do0;
import defpackage.ea0;
import defpackage.g52;
import defpackage.hd2;
import defpackage.hg0;
import defpackage.j02;
import defpackage.k92;
import defpackage.l52;
import defpackage.or1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxg implements zzbxl {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzhbz zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbxi zzi;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbxg(Context context, or1 or1Var, zzbxi zzbxiVar, String str, zzbxh zzbxhVar) {
        hg0.j(zzbxiVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzbxiVar;
        Iterator it = zzbxiVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhbz zzhbzVarZzc = zzhdy.zzc();
        zzhbzVarZzc.zzn(9);
        zzhbzVarZzc.zzj(str);
        zzhbzVarZzc.zzh(str);
        zzhca zzhcaVarZzc = zzhcb.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzhcaVarZzc.zza(str2);
        }
        zzhbzVarZzc.zzg((zzhcb) zzhcaVarZzc.zzbr());
        zzhdp zzhdpVarZzc = zzhdq.zzc();
        zzhdpVarZzc.zzc(j02.a(this.zzh).i());
        String str3 = or1Var.g;
        if (str3 != null) {
            zzhdpVarZzc.zza(str3);
        }
        ea0 ea0Var = ea0.b;
        Context context2 = this.zzh;
        ea0Var.getClass();
        long jA = ea0.a(context2);
        if (jA > 0) {
            zzhdpVarZzc.zzb(jA);
        }
        zzhbzVarZzc.zzf((zzhdq) zzhdpVarZzc.zzbr());
        this.zzd = zzhbzVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final zzbxi zza() {
        return this.zzi;
    }

    public final do0 zzb(Map map) {
        zzhdn zzhdnVar;
        do0 do0VarZzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        synchronized (this.zzj) {
                            try {
                                int length = jSONArrayOptJSONArray.length();
                                synchronized (this.zzj) {
                                    zzhdnVar = (zzhdn) this.zze.get(str);
                                }
                                if (zzhdnVar == null) {
                                    zzbxk.zza("Cannot find the corresponding resource object for " + str);
                                } else {
                                    for (int i = 0; i < length; i++) {
                                        zzhdnVar.zza(jSONArrayOptJSONArray.getJSONObject(i).getString("threat_type"));
                                    }
                                    this.zza = (length > 0) | this.zza;
                                }
                            } finally {
                            }
                        }
                    }
                }
            } catch (JSONException unused) {
                if (((Boolean) zzbea.zza.zze()).booleanValue()) {
                    k92.j(3);
                }
                return zzgcj.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z = this.zza;
        if (!(z && this.zzi.zzg) && (!(this.zzm && this.zzi.zzf) && (z || !this.zzi.zzd))) {
            return zzgcj.zzh(null);
        }
        synchronized (this.zzj) {
            try {
                Iterator it = this.zze.values().iterator();
                while (it.hasNext()) {
                    this.zzd.zzc((zzhdo) ((zzhdn) it.next()).zzbr());
                }
                this.zzd.zza(this.zzf);
                this.zzd.zzb(this.zzg);
                if (zzbxk.zzb()) {
                    StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + this.zzd.zzl() + "\n  clickUrl: " + this.zzd.zzk() + "\n  resources: \n");
                    for (zzhdo zzhdoVar : this.zzd.zzm()) {
                        sb.append("    [");
                        sb.append(zzhdoVar.zzc());
                        sb.append("] ");
                        sb.append(zzhdoVar.zzf());
                    }
                    zzbxk.zza(sb.toString());
                }
                byte[] bArrZzaV = ((zzhdy) this.zzd.zzbr()).zzaV();
                String str2 = this.zzi.zzb;
                new l52(this.zzh);
                g52 g52VarA = l52.a(1, str2, null, bArrZzaV);
                if (zzbxk.zzb()) {
                    g52VarA.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxd
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzbxk.zza("Pinged SB successfully.");
                        }
                    }, zzbzo.zza);
                }
                do0VarZzm = zzgcj.zzm(g52VarA, new zzful() { // from class: com.google.android.gms.internal.ads.zzbxe
                    @Override // com.google.android.gms.internal.ads.zzful
                    public final Object apply(Object obj) {
                        int i2 = zzbxg.zzb;
                        return null;
                    }
                }, zzbzo.zzf);
            } finally {
            }
        }
        return do0VarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzd(String str, Map map, int i) {
        synchronized (this.zzj) {
            if (i == 3) {
                try {
                    this.zzm = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.zze.containsKey(str)) {
                if (i == 3) {
                    ((zzhdn) this.zze.get(str)).zze(4);
                }
                return;
            }
            zzhdn zzhdnVarZzd = zzhdo.zzd();
            int iZza = zzhdm.zza(i);
            if (iZza != 0) {
                zzhdnVarZzd.zze(iZza);
            }
            zzhdnVarZzd.zzb(this.zze.size());
            zzhdnVarZzd.zzd(str);
            zzhcm zzhcmVarZzc = zzhcp.zzc();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzhck zzhckVarZzc = zzhcl.zzc();
                        zzhckVarZzc.zza(zzgwm.zzw(str2));
                        zzhckVarZzc.zzb(zzgwm.zzw(str3));
                        zzhcmVarZzc.zza((zzhcl) zzhckVarZzc.zzbr());
                    }
                }
            }
            zzhdnVarZzd.zzc((zzhcp) zzhcmVarZzc.zzbr());
            this.zze.put(str, zzhdnVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            do0 do0VarZzh = zzgcj.zzh(Collections.EMPTY_MAP);
            zzgbq zzgbqVar = new zzgbq() { // from class: com.google.android.gms.internal.ads.zzbxb
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final do0 zza(Object obj) {
                    return this.zza.zzb((Map) obj);
                }
            };
            zzgcu zzgcuVar = zzbzo.zzf;
            do0 do0VarZzn = zzgcj.zzn(do0VarZzh, zzgbqVar, zzgcuVar);
            do0 do0VarZzo = zzgcj.zzo(do0VarZzn, 10L, TimeUnit.SECONDS, zzbzo.zzd);
            zzgcj.zzr(do0VarZzn, new zzbxf(this, do0VarZzo), zzgcuVar);
            zzc.add(do0VarZzo);
        }
    }

    public final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgwl zzgwlVarZzt = zzgwm.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzgwlVarZzt);
        synchronized (this.zzj) {
            zzhbz zzhbzVar = this.zzd;
            zzhdh zzhdhVarZzc = zzhdj.zzc();
            zzhdhVarZzc.zza(zzgwlVarZzt.zzb());
            zzhdhVarZzc.zzb("image/png");
            zzhdhVarZzc.zzc(2);
            zzhbzVar.zzi((zzhdj) zzhdhVarZzc.zzbr());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzg(View view) {
        Bitmap bitmapCreateBitmap;
        if (this.zzi.zzc && !this.zzl) {
            cd2 cd2Var = hd2.B.c;
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                    try {
                        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                    } catch (RuntimeException unused) {
                        k92.f();
                    }
                } catch (RuntimeException unused2) {
                    bitmapCreateBitmap = null;
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            k92.h("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException unused3) {
                        k92.f();
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzbxk.zza("Failed to capture the webview bitmap.");
                return;
            }
            this.zzl = true;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf(bitmap);
                }
            };
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                runnable.run();
            } else {
                zzbzo.zza.execute(runnable);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzh(String str) {
        synchronized (this.zzj) {
            try {
                if (str == null) {
                    this.zzd.zzd();
                } else {
                    this.zzd.zze(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final boolean zzi() {
        return this.zzi.zzc && !this.zzl;
    }
}
