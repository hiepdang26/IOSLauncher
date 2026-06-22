package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import defpackage.a22;
import defpackage.cd2;
import defpackage.do0;
import defpackage.hd2;
import defpackage.ja2;
import defpackage.m62;
import defpackage.n42;
import defpackage.or1;
import defpackage.p21;
import defpackage.s61;
import defpackage.yb2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfb extends FrameLayout implements zzcej {
    private final zzcej zza;
    private final zzcaz zzb;
    private final AtomicBoolean zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public zzcfb(zzcej zzcejVar) {
        super(zzcejVar.getContext());
        this.zzc = new AtomicBoolean();
        this.zza = zzcejVar;
        this.zzb = new zzcaz(zzcejVar.zzE(), this, this);
        addView((View) zzcejVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void destroy() {
        final zzeem zzeemVarZzP;
        final zzeeo zzeeoVarZzQ = zzQ();
        if (zzeeoVarZzQ != null) {
            ja2 ja2Var = cd2.l;
            ja2Var.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcez
                @Override // java.lang.Runnable
                public final void run() {
                    hd2.B.w.zzi(zzeeoVarZzQ.zza());
                }
            });
            zzcej zzcejVar = this.zza;
            Objects.requireNonNull(zzcejVar);
            ja2Var.postDelayed(new zzcex(zzcejVar), ((Integer) n42.d.c.zza(zzbbw.zzeA)).intValue());
            return;
        }
        if (!((Boolean) n42.d.c.zza(zzbbw.zzeC)).booleanValue() || (zzeemVarZzP = zzP()) == null) {
            this.zza.destroy();
        } else {
            cd2.l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfa
                @Override // java.lang.Runnable
                public final void run() {
                    zzeemVarZzP.zzf(new zzcey(this.zza));
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void goBack() {
        this.zza.goBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, defpackage.b22
    public final void onAdClicked() {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void onResume() {
        this.zza.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcej
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcej
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzB(int i) {
        this.zzb.zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final void zzC(zzcfl zzcflVar) {
        this.zza.zzC(zzcflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcea
    public final zzfel zzD() {
        return this.zza.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final Context zzE() {
        return this.zza.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfy
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final WebView zzG() {
        return (WebView) this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfw
    public final zzauo zzI() {
        return this.zza.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzazj zzJ() {
        return this.zza.zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzber zzK() {
        return this.zza.zzK();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final yb2 zzL() {
        return this.zza.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final yb2 zzM() {
        return this.zza.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzcgb zzN() {
        return ((zzcfi) this.zza).zzaO();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfv
    public final zzcgd zzO() {
        return this.zza.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzeem zzP() {
        return this.zza.zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzeeo zzQ() {
        return this.zza.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfm
    public final zzfeo zzR() {
        return this.zza.zzR();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final zzffk zzS() {
        return this.zza.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final do0 zzT() {
        return this.zza.zzT();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final String zzU() {
        return this.zza.zzU();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final List zzV() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.zza) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzW(zzfel zzfelVar, zzfeo zzfeoVar) {
        this.zza.zzW(zzfelVar, zzfeoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzX() {
        this.zzb.zze();
        this.zza.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzY() {
        this.zza.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzZ(int i) {
        this.zza.zzZ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zza(String str) {
        ((zzcfi) this.zza).zzaT(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaA(String str, p21 p21Var) {
        this.zza.zzaA(str, p21Var);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaD(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) n42.d.c.zza(zzbbw.zzaD)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaD(z, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaF() {
        return this.zza.zzaF();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaG() {
        return this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final boolean zzaH() {
        return this.zza.zzaH();
    }

    public final /* synthetic */ void zzaI(boolean z) {
        zzcej zzcejVar = this.zza;
        ja2 ja2Var = cd2.l;
        Objects.requireNonNull(zzcejVar);
        ja2Var.post(new zzcex(zzcejVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaJ(m62 m62Var, boolean z, boolean z2) {
        this.zza.zzaJ(m62Var, z, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaK(String str, String str2, int i) {
        this.zza.zzaK(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaL(boolean z, int i, boolean z2) {
        this.zza.zzaL(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaM(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcft
    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaN(z, i, str, z2, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaa() {
        this.zza.zzaa();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0047  */
    @Override // com.google.android.gms.internal.ads.zzcej
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzab() {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r1 = 3
            r0.<init>(r1)
            hd2 r2 = defpackage.hd2.B
            k22 r3 = r2.h
            boolean r3 = r3.d()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "app_muted"
            r0.put(r4, r3)
            k22 r2 = r2.h
            float r2 = r2.a()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "app_volume"
            r0.put(r3, r2)
            com.google.android.gms.internal.ads.zzcej r2 = r5.zza
            com.google.android.gms.internal.ads.zzcfi r2 = (com.google.android.gms.internal.ads.zzcfi) r2
            android.content.Context r3 = r2.getContext()
            java.lang.String r4 = "audio"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.media.AudioManager r3 = (android.media.AudioManager) r3
            if (r3 != 0) goto L39
            goto L47
        L39:
            int r4 = r3.getStreamMaxVolume(r1)
            int r1 = r3.getStreamVolume(r1)
            if (r4 == 0) goto L47
            float r1 = (float) r1
            float r3 = (float) r4
            float r1 = r1 / r3
            goto L48
        L47:
            r1 = 0
        L48:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "device_volume"
            r0.put(r3, r1)
            java.lang.String r1 = "volume"
            r2.zzd(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfb.zzab():void");
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzac(boolean z) {
        this.zza.zzac(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzad() {
        this.zza.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzae(String str, String str2, String str3) {
        this.zza.zzae(str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaf() {
        this.zza.zzaf();
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzag(String str, zzbix zzbixVar) {
        this.zza.zzag(str, zzbixVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzah() {
        zzeeo zzeeoVarZzQ;
        zzeem zzeemVarZzP;
        TextView textView = new TextView(getContext());
        hd2 hd2Var = hd2.B;
        cd2 cd2Var = hd2Var.c;
        Resources resourcesZze = hd2Var.g.zze();
        textView.setText(resourcesZze != null ? resourcesZze.getString(s61.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
        zzbbn zzbbnVar = zzbbw.zzeC;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && (zzeemVarZzP = zzP()) != null) {
            zzeemVarZzP.zza(textView);
        } else if (((Boolean) n42Var.c.zza(zzbbw.zzeB)).booleanValue() && (zzeeoVarZzQ = zzQ()) != null && zzeeoVarZzQ.zzb()) {
            hd2Var.w.zzg(zzeeoVarZzQ.zza(), textView);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzai(yb2 yb2Var) {
        this.zza.zzai(yb2Var);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaj(zzcgd zzcgdVar) {
        this.zza.zzaj(zzcgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzak(zzazj zzazjVar) {
        this.zza.zzak(zzazjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzal(boolean z) {
        this.zza.zzal(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzam() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzan(Context context) {
        this.zza.zzan(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzap(zzbep zzbepVar) {
        this.zza.zzap(zzbepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaq(boolean z) {
        this.zza.zzaq(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzar(zzber zzberVar) {
        this.zza.zzar(zzberVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzas(zzeem zzeemVar) {
        this.zza.zzas(zzeemVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzat(zzeeo zzeeoVar) {
        this.zza.zzat(zzeeoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzau(int i) {
        this.zza.zzau(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzav(boolean z) {
        this.zza.zzav(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaw(yb2 yb2Var) {
        this.zza.zzaw(yb2Var);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzax(boolean z) {
        this.zza.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzay(boolean z) {
        this.zza.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcej
    public final void zzaz(String str, zzbix zzbixVar) {
        this.zza.zzaz(str, zzbixVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdG() {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.zzdG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzdf() {
        zzcej zzcejVar = this.zza;
        if (zzcejVar != null) {
            zzcejVar.zzdf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcej, defpackage.cc2
    public final void zzdg() {
        this.zza.zzdg();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, defpackage.cc2
    public final void zzdh() {
        this.zza.zzdh();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final String zzdi() {
        return this.zza.zzdi();
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        this.zza.zzdp(zzaxvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzg() {
        return ((Boolean) n42.d.c.zza(zzbbw.zzdx)).booleanValue() ? this.zza.getMeasuredHeight() : getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final int zzh() {
        return ((Boolean) n42.d.c.zza(zzbbw.zzdx)).booleanValue() ? this.zza.getMeasuredWidth() : getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcbk
    public final Activity zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final a22 zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzbci zzk() {
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzbme
    public final void zzl(String str, JSONObject jSONObject) {
        ((zzcfi) this.zza).zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final zzbcj zzm() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcfx, com.google.android.gms.internal.ads.zzcbk
    public final or1 zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzcaz zzo() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final zzccv zzp(String str) {
        return this.zza.zzp(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final zzcfl zzq() {
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final String zzr() {
        return this.zza.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzcej, com.google.android.gms.internal.ads.zzcbk
    public final void zzt(String str, zzccv zzccvVar) {
        this.zza.zzt(str, zzccvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzu() {
        this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzw() {
        this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcbk
    public final void zzz(boolean z) {
        this.zza.zzz(false);
    }
}
