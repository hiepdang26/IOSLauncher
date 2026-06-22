package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import defpackage.cd2;
import defpackage.do0;
import defpackage.e9;
import defpackage.gy0;
import defpackage.hd2;
import defpackage.he0;
import defpackage.k92;
import defpackage.m82;
import defpackage.n42;
import defpackage.or1;
import defpackage.p72;
import defpackage.s72;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdiw extends zzcru {
    private final Executor zzc;
    private final zzdjb zzd;
    private final zzdjj zze;
    private final zzdkb zzf;
    private final zzdjg zzg;
    private final zzdjm zzh;
    private final zzhew zzi;
    private final zzhew zzj;
    private final zzhew zzk;
    private final zzhew zzl;
    private final zzhew zzm;
    private zzdkx zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private final zzbxw zzr;
    private final zzauo zzs;
    private final or1 zzt;
    private final Context zzu;
    private final zzdiy zzv;
    private final zzemn zzw;
    private final Map zzx;
    private final List zzy;

    static {
        zzfxr.zzr("3010", "3008", "1005", "1009", "2011", "2007");
    }

    public zzdiw(zzcrt zzcrtVar, Executor executor, zzdjb zzdjbVar, zzdjj zzdjjVar, zzdkb zzdkbVar, zzdjg zzdjgVar, zzdjm zzdjmVar, zzhew zzhewVar, zzhew zzhewVar2, zzhew zzhewVar3, zzhew zzhewVar4, zzhew zzhewVar5, zzbxw zzbxwVar, zzauo zzauoVar, or1 or1Var, Context context, zzdiy zzdiyVar, zzemn zzemnVar, zzaxy zzaxyVar) {
        super(zzcrtVar);
        this.zzc = executor;
        this.zzd = zzdjbVar;
        this.zze = zzdjjVar;
        this.zzf = zzdkbVar;
        this.zzg = zzdjgVar;
        this.zzh = zzdjmVar;
        this.zzi = zzhewVar;
        this.zzj = zzhewVar2;
        this.zzk = zzhewVar3;
        this.zzl = zzhewVar4;
        this.zzm = zzhewVar5;
        this.zzr = zzbxwVar;
        this.zzs = zzauoVar;
        this.zzt = or1Var;
        this.zzu = context;
        this.zzv = zzdiyVar;
        this.zzw = zzemnVar;
        this.zzx = new HashMap();
        this.zzy = new ArrayList();
    }

    public static boolean zzX(View view) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzjJ)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
        }
        cd2 cd2Var = hd2.B.c;
        long jI = cd2.I(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), null)) {
            if (jI >= ((Integer) r1.c.zza(zzbbw.zzjK)).intValue()) {
                return true;
            }
        }
        return false;
    }

    private final synchronized ImageView.ScaleType zzZ() {
        zzdkx zzdkxVar = this.zzn;
        if (zzdkxVar == null) {
            k92.d("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        he0 he0VarZzj = zzdkxVar.zzj();
        if (he0VarZzj != null) {
            return (ImageView.ScaleType) gy0.r(he0VarZzj);
        }
        return zzdkb.zza;
    }

    private final void zzaa(String str, boolean z) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzeH)).booleanValue()) {
            zzf("Google", true);
            return;
        }
        do0 do0VarZzw = this.zzd.zzw();
        if (do0VarZzw == null) {
            return;
        }
        zzgcj.zzr(do0VarZzw, new zzdiu(this, "Google", true), this.zzc);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzf.zzd(this.zzn);
        this.zze.zzq(view, map, map2, zzZ());
        this.zzp = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(View view, zzeeo zzeeoVar) {
        zzcej zzcejVarZzr = this.zzd.zzr();
        if (!this.zzg.zzd() || zzeeoVar == null || zzcejVarZzr == null || view == null) {
            return;
        }
        hd2.B.w.zzj(zzeeoVar.zza(), view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzz(zzdkx zzdkxVar) {
        Iterator<String> itKeys;
        View view;
        zzauk zzaukVarZzc;
        try {
            if (!this.zzo) {
                this.zzn = zzdkxVar;
                this.zzf.zze(zzdkxVar);
                this.zze.zzy(zzdkxVar.zzf(), zzdkxVar.zzm(), zzdkxVar.zzn(), zzdkxVar, zzdkxVar);
                zzbbn zzbbnVar = zzbbw.zzcq;
                n42 n42Var = n42.d;
                if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && (zzaukVarZzc = this.zzs.zzc()) != null) {
                    zzaukVarZzc.zzo(zzdkxVar.zzf());
                }
                if (((Boolean) n42Var.c.zza(zzbbw.zzbA)).booleanValue()) {
                    zzfel zzfelVar = this.zzb;
                    if (zzfelVar.zzak && (itKeys = zzfelVar.zzaj.keys()) != null) {
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            WeakReference weakReference = (WeakReference) this.zzn.zzl().get(next);
                            this.zzx.put(next, Boolean.FALSE);
                            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                                zzaxx zzaxxVar = new zzaxx(this.zzu, view);
                                this.zzy.add(zzaxxVar);
                                zzaxxVar.zzc(new zzdit(this, next));
                            }
                        }
                    }
                }
                if (zzdkxVar.zzi() != null) {
                    zzdkxVar.zzi().zzc(this.zzr);
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public final void zzA(zzdkx zzdkxVar) {
        this.zze.zzz(zzdkxVar.zzf(), zzdkxVar.zzl());
        if (zzdkxVar.zzh() != null) {
            zzdkxVar.zzh().setClickable(false);
            zzdkxVar.zzh().removeAllViews();
        }
        if (zzdkxVar.zzi() != null) {
            zzdkxVar.zzi().zze(this.zzr);
        }
        this.zzn = null;
    }

    public static /* synthetic */ void zzl(zzdiw zzdiwVar) {
        try {
            zzdjb zzdjbVar = zzdiwVar.zzd;
            int iZzc = zzdjbVar.zzc();
            if (iZzc == 1) {
                if (zzdiwVar.zzh.zzb() != null) {
                    zzdiwVar.zzaa("Google", true);
                    zzdiwVar.zzh.zzb().zze((zzbfu) zzdiwVar.zzi.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 2) {
                if (zzdiwVar.zzh.zza() != null) {
                    zzdiwVar.zzaa("Google", true);
                    zzdiwVar.zzh.zza().zze((zzbfs) zzdiwVar.zzj.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 3) {
                if (zzdiwVar.zzh.zzd(zzdjbVar.zzA()) != null) {
                    if (zzdiwVar.zzd.zzs() != null) {
                        zzdiwVar.zzf("Google", true);
                    }
                    zzdiwVar.zzh.zzd(zzdiwVar.zzd.zzA()).zze((zzbfx) zzdiwVar.zzm.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 6) {
                if (zzdiwVar.zzh.zzf() != null) {
                    zzdiwVar.zzaa("Google", true);
                    zzdiwVar.zzh.zzf().zze((zzbha) zzdiwVar.zzk.zzb());
                    return;
                }
                return;
            }
            if (iZzc != 7) {
                k92.e("Wrong native template id!");
                return;
            }
            zzdjm zzdjmVar = zzdiwVar.zzh;
            if (zzdjmVar.zzg() != null) {
                zzdjmVar.zzg().zzg((zzblk) zzdiwVar.zzl.zzb());
            }
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:19:0x0048, B:22:0x005c, B:23:0x0064, B:25:0x006a, B:27:0x007e, B:29:0x0084, B:34:0x008b), top: B:39:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b A[Catch: all -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:19:0x0048, B:22:0x005c, B:23:0x0064, B:25:0x006a, B:27:0x007e, B:29:0x0084, B:34:0x008b), top: B:39:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzB(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzp     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L7
            goto L89
        L7:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzbA     // Catch: java.lang.Throwable -> L44
            n42 r1 = defpackage.n42.d     // Catch: java.lang.Throwable -> L44
            com.google.android.gms.internal.ads.zzbbu r1 = r1.c     // Catch: java.lang.Throwable -> L44
            java.lang.Object r0 = r1.zza(r0)     // Catch: java.lang.Throwable -> L44
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L44
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            com.google.android.gms.internal.ads.zzfel r0 = r3.zzb     // Catch: java.lang.Throwable -> L44
            boolean r0 = r0.zzak     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            java.util.Map r0 = r3.zzx     // Catch: java.lang.Throwable -> L44
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Throwable -> L44
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L44
        L29:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L46
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L44
            java.util.Map r2 = r3.zzx     // Catch: java.lang.Throwable -> L44
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Throwable -> L44
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L44
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L44
            if (r1 != 0) goto L29
            goto L89
        L44:
            r4 = move-exception
            goto L90
        L46:
            if (r7 != 0) goto L8b
            com.google.android.gms.internal.ads.zzbbn r7 = com.google.android.gms.internal.ads.zzbbw.zzdy     // Catch: java.lang.Throwable -> L44
            n42 r0 = defpackage.n42.d     // Catch: java.lang.Throwable -> L44
            com.google.android.gms.internal.ads.zzbbu r0 = r0.c     // Catch: java.lang.Throwable -> L44
            java.lang.Object r7 = r0.zza(r7)     // Catch: java.lang.Throwable -> L44
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L44
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L44
            if (r7 == 0) goto L89
            if (r5 == 0) goto L89
            java.util.Set r7 = r5.entrySet()     // Catch: java.lang.Throwable -> L44
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L44
        L64:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L89
            java.lang.Object r0 = r7.next()     // Catch: java.lang.Throwable -> L44
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L44
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L44
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch: java.lang.Throwable -> L44
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L44
            android.view.View r0 = (android.view.View) r0     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L64
            boolean r0 = zzX(r0)     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L64
            r3.zzab(r4, r5, r6)     // Catch: java.lang.Throwable -> L44
            monitor-exit(r3)
            return
        L89:
            monitor-exit(r3)
            return
        L8b:
            r3.zzab(r4, r5, r6)     // Catch: java.lang.Throwable -> L44
            monitor-exit(r3)
            return
        L90:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L44
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdiw.zzB(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzC(s72 s72Var) {
        this.zze.zzj(s72Var);
    }

    public final synchronized void zzD(View view, View view2, Map map, Map map2, boolean z) {
        this.zzf.zzc(this.zzn);
        this.zze.zzk(view, view2, map, map2, z, zzZ());
        if (this.zzq) {
            zzdjb zzdjbVar = this.zzd;
            if (zzdjbVar.zzs() != null) {
                zzdjbVar.zzs().zzd("onSdkAdUserInteractionClick", new e9(0));
            }
        }
    }

    public final synchronized void zzE(final View view, final int i) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzkE)).booleanValue()) {
            zzdkx zzdkxVar = this.zzn;
            if (zzdkxVar == null) {
                k92.d("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzdkxVar instanceof zzdjv;
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdiq
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzx(view, z, i);
                    }
                });
            }
        }
    }

    public final synchronized void zzF(String str) {
        this.zze.zzl(str);
    }

    public final synchronized void zzG(Bundle bundle) {
        this.zze.zzm(bundle);
    }

    public final synchronized void zzH() {
        zzdkx zzdkxVar = this.zzn;
        if (zzdkxVar == null) {
            k92.d("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzdkxVar instanceof zzdjv;
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdis
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzy(z);
                }
            });
        }
    }

    public final synchronized void zzI() {
        if (this.zzp) {
            return;
        }
        this.zze.zzr();
    }

    public final void zzJ(View view) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzeH)).booleanValue()) {
            zzac(view, this.zzd.zzu());
            return;
        }
        zzbzt zzbztVarZzp = this.zzd.zzp();
        if (zzbztVarZzp == null) {
            return;
        }
        zzgcj.zzr(zzbztVarZzp, new zzdiv(this, view), this.zzc);
    }

    public final synchronized void zzK(View view, MotionEvent motionEvent, View view2) {
        this.zze.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzL(Bundle bundle) {
        this.zze.zzt(bundle);
    }

    public final synchronized void zzM(View view) {
        this.zze.zzu(view);
    }

    public final synchronized void zzN() {
        this.zze.zzv();
    }

    public final synchronized void zzO(p72 p72Var) {
        this.zze.zzw(p72Var);
    }

    public final synchronized void zzP(m82 m82Var) {
        this.zzw.zza(m82Var);
    }

    public final synchronized void zzQ(zzbgx zzbgxVar) {
        this.zze.zzx(zzbgxVar);
    }

    public final synchronized void zzR(final zzdkx zzdkxVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzby)).booleanValue()) {
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdim
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzz(zzdkxVar);
                }
            });
        } else {
            zzz(zzdkxVar);
        }
    }

    public final synchronized void zzS(final zzdkx zzdkxVar) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzby)).booleanValue()) {
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdin
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzA(zzdkxVar);
                }
            });
        } else {
            zzA(zzdkxVar);
        }
    }

    public final boolean zzT() {
        return this.zzg.zze();
    }

    public final synchronized boolean zzU() {
        return this.zze.zzA();
    }

    public final synchronized boolean zzV() {
        return this.zze.zzB();
    }

    public final boolean zzW() {
        return this.zzg.zzd();
    }

    public final synchronized boolean zzY(Bundle bundle) {
        if (this.zzp) {
            return true;
        }
        boolean zZzC = this.zze.zzC(bundle);
        this.zzp = zZzC;
        return zZzC;
    }

    public final synchronized int zza() {
        return this.zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final synchronized void zzb() {
        this.zzo = true;
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdir
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzw();
            }
        });
        super.zzb();
    }

    public final zzdiy zzc() {
        return this.zzv;
    }

    public final zzeeo zzf(String str, boolean z) {
        String str2;
        zzeel zzeelVar;
        zzeek zzeekVar;
        if (!this.zzg.zzd() || TextUtils.isEmpty(str)) {
            return null;
        }
        zzdjb zzdjbVar = this.zzd;
        zzcej zzcejVarZzr = zzdjbVar.zzr();
        zzcej zzcejVarZzs = zzdjbVar.zzs();
        if (zzcejVarZzr == null && zzcejVarZzs == null) {
            k92.h("Omid display and video webview are null. Skipping initialization.");
            return null;
        }
        boolean z2 = zzcejVarZzr != null;
        boolean z3 = zzcejVarZzs != null;
        if (((Boolean) n42.d.c.zza(zzbbw.zzeF)).booleanValue()) {
            this.zzg.zza();
            int iZzc = this.zzg.zza().zzc();
            int i = iZzc - 1;
            if (i != 0) {
                if (i != 1) {
                    k92.h("Unknown omid media type: " + (iZzc != 1 ? iZzc != 2 ? "UNKNOWN" : "DISPLAY" : "VIDEO") + ". Not initializing Omid.");
                    return null;
                }
                if (zzcejVarZzr == null) {
                    k92.h("Omid media type was display but there was no display webview.");
                    return null;
                }
                z2 = true;
                z3 = false;
            } else {
                if (zzcejVarZzs == null) {
                    k92.h("Omid media type was video but there was no video webview.");
                    return null;
                }
                z2 = false;
                z3 = true;
            }
        }
        if (z2) {
            str2 = null;
        } else {
            str2 = "javascript";
            zzcejVarZzr = zzcejVarZzs;
        }
        zzcejVarZzr.zzG();
        Context context = this.zzu;
        hd2 hd2Var = hd2.B;
        if (!hd2Var.w.zzl(context)) {
            k92.h("Failed to initialize omid in InternalNativeAd");
            return null;
        }
        or1 or1Var = this.zzt;
        String str3 = or1Var.h + "." + or1Var.i;
        if (z3) {
            zzeekVar = zzeek.VIDEO;
            zzeelVar = zzeel.DEFINED_BY_JAVASCRIPT;
        } else {
            zzdjb zzdjbVar2 = this.zzd;
            zzeek zzeekVar2 = zzeek.NATIVE_DISPLAY;
            zzeelVar = zzdjbVar2.zzc() == 3 ? zzeel.UNSPECIFIED : zzeel.ONE_PIXEL;
            zzeekVar = zzeekVar2;
        }
        zzeeo zzeeoVarZzb = hd2Var.w.zzb(str3, zzcejVarZzr.zzG(), "", "javascript", str2, str, zzeelVar, zzeekVar, this.zzb.zzal);
        if (zzeeoVarZzb == null) {
            k92.h("Failed to create omid session in InternalNativeAd");
            return null;
        }
        this.zzd.zzW(zzeeoVarZzb);
        zzcejVarZzr.zzat(zzeeoVarZzb);
        zzeei zzeeiVar = hd2Var.w;
        if (z3) {
            zzeeiVar.zzj(zzeeoVarZzb.zza(), zzcejVarZzs.zzF());
            this.zzq = true;
        }
        if (z) {
            zzeeiVar.zzk(zzeeoVarZzb.zza());
            zzcejVarZzr.zzd("onSdkLoaded", new e9(0));
        }
        return zzeeoVarZzb;
    }

    public final String zzg() {
        return this.zzg.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zze.zze(view, map, map2, zzZ());
    }

    public final synchronized JSONObject zzj(View view, Map map, Map map2) {
        return this.zze.zzf(view, map, map2, zzZ());
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zzk() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdio
            @Override // java.lang.Runnable
            public final void run() {
                zzdiw.zzl(this.zza);
            }
        });
        if (this.zzd.zzc() != 7) {
            Executor executor = this.zzc;
            final zzdjj zzdjjVar = this.zze;
            Objects.requireNonNull(zzdjjVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdip
                @Override // java.lang.Runnable
                public final void run() {
                    zzdjjVar.zzp();
                }
            });
        }
        super.zzk();
    }

    public final void zzu(View view) {
        zzeeo zzeeoVarZzu = this.zzd.zzu();
        if (!this.zzg.zzd() || zzeeoVarZzu == null || view == null) {
            return;
        }
        hd2.B.w.zzg(zzeeoVarZzu.zza(), view);
    }

    public final synchronized void zzv() {
        this.zze.zzh();
    }

    public final /* synthetic */ void zzw() {
        this.zze.zzi();
        this.zzd.zzI();
    }

    public final /* synthetic */ void zzx(View view, boolean z, int i) {
        this.zze.zzo(view, this.zzn.zzf(), this.zzn.zzl(), this.zzn.zzm(), z, zzZ(), i);
    }

    public final /* synthetic */ void zzy(boolean z) {
        this.zze.zzo(null, this.zzn.zzf(), this.zzn.zzl(), this.zzn.zzm(), z, zzZ(), 0);
    }
}
