package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import defpackage.a22;
import defpackage.b22;
import defpackage.cc2;
import defpackage.do0;
import defpackage.or1;
import defpackage.p21;
import defpackage.yb2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface zzcej extends b22, zzdeq, zzcea, zzbls, zzcfm, zzcfq, zzbme, zzaxw, zzcft, cc2, zzcfw, zzcfx, zzcbk, zzcfy {
    boolean canGoBack();

    void destroy();

    @Override // com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcbk
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    @Override // defpackage.b22
    /* synthetic */ void onAdClicked();

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzcbk
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    @Override // com.google.android.gms.internal.ads.zzcbk
    void zzC(zzcfl zzcflVar);

    @Override // com.google.android.gms.internal.ads.zzcea
    zzfel zzD();

    Context zzE();

    @Override // com.google.android.gms.internal.ads.zzcfy
    View zzF();

    WebView zzG();

    WebViewClient zzH();

    @Override // com.google.android.gms.internal.ads.zzcfw
    zzauo zzI();

    zzazj zzJ();

    zzber zzK();

    yb2 zzL();

    yb2 zzM();

    zzcgb zzN();

    @Override // com.google.android.gms.internal.ads.zzcfv
    zzcgd zzO();

    zzeem zzP();

    zzeeo zzQ();

    @Override // com.google.android.gms.internal.ads.zzcfm
    zzfeo zzR();

    zzffk zzS();

    do0 zzT();

    String zzU();

    List zzV();

    void zzW(zzfel zzfelVar, zzfeo zzfeoVar);

    void zzX();

    void zzY();

    void zzZ(int i);

    void zzaA(String str, p21 p21Var);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD(boolean z, int i);

    boolean zzaE();

    boolean zzaF();

    boolean zzaG();

    boolean zzaH();

    void zzaa();

    void zzab();

    void zzac(boolean z);

    void zzad();

    void zzae(String str, String str2, String str3);

    void zzaf();

    void zzag(String str, zzbix zzbixVar);

    void zzah();

    void zzai(yb2 yb2Var);

    void zzaj(zzcgd zzcgdVar);

    void zzak(zzazj zzazjVar);

    void zzal(boolean z);

    void zzam();

    void zzan(Context context);

    void zzao(boolean z);

    void zzap(zzbep zzbepVar);

    void zzaq(boolean z);

    void zzar(zzber zzberVar);

    void zzas(zzeem zzeemVar);

    void zzat(zzeeo zzeeoVar);

    void zzau(int i);

    void zzav(boolean z);

    void zzaw(yb2 yb2Var);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(String str, zzbix zzbixVar);

    @Override // defpackage.cc2
    /* synthetic */ void zzdg();

    @Override // defpackage.cc2
    /* synthetic */ void zzdh();

    @Override // com.google.android.gms.internal.ads.zzcfq, com.google.android.gms.internal.ads.zzcbk
    Activity zzi();

    @Override // com.google.android.gms.internal.ads.zzcbk
    a22 zzj();

    @Override // com.google.android.gms.internal.ads.zzcbk
    zzbcj zzm();

    @Override // com.google.android.gms.internal.ads.zzcfx, com.google.android.gms.internal.ads.zzcbk
    or1 zzn();

    @Override // com.google.android.gms.internal.ads.zzcbk
    zzcfl zzq();

    @Override // com.google.android.gms.internal.ads.zzcbk
    void zzt(String str, zzccv zzccvVar);
}
