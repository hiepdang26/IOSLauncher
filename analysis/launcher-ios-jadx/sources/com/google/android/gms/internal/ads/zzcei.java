package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.cd2;
import defpackage.h42;
import defpackage.hd2;
import defpackage.k92;
import defpackage.uo;
import defpackage.yb2;

/* JADX INFO: loaded from: classes.dex */
public final class zzcei extends WebChromeClient {
    private final zzcej zza;

    public zzcei(zzcej zzcejVar) {
        this.zza = zzcejVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcej)) {
            return webView.getContext();
        }
        zzcej zzcejVar = (zzcej) webView;
        Activity activityZzi = zzcejVar.zzi();
        return activityZzi != null ? activityZzi : zzcejVar.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcej)) {
            k92.h("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        yb2 yb2VarZzL = ((zzcej) webView).zzL();
        if (yb2VarZzL == null) {
            k92.h("Tried to close an AdWebView not associated with an overlay.");
        } else {
            yb2VarZzL.zzb();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage = consoleMessage.message();
        String strSourceId = consoleMessage.sourceId();
        int iLineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder("JS: ");
        sb.append(strMessage);
        sb.append(" (");
        sb.append(strSourceId);
        sb.append(":");
        String strJ = uo.j(sb, iLineNumber, ")");
        if (strJ.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzceh.zza[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            k92.e(strJ);
        } else if (i == 2) {
            k92.h(strJ);
        } else if (i == 3 || i == 4 || i != 5) {
            k92.g(strJ);
        } else {
            k92.d(strJ);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzH() != null) {
            webView2.setWebViewClient(this.zza.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072L, j4) + j, 1048576L);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onGeolocationPermissionsShowPrompt(java.lang.String r4, android.webkit.GeolocationPermissions.Callback r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L2b
            com.google.android.gms.internal.ads.zzcej r0 = r3.zza
            hd2 r1 = defpackage.hd2.B
            cd2 r2 = r1.c
            android.content.Context r0 = r0.getContext()
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = defpackage.cd2.a(r0, r2)
            r2 = 1
            if (r0 != 0) goto L25
            com.google.android.gms.internal.ads.zzcej r0 = r3.zza
            cd2 r1 = r1.c
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = defpackage.cd2.a(r0, r1)
            if (r0 == 0) goto L27
        L25:
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            r5.invoke(r4, r0, r2)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcei.onGeolocationPermissionsShowPrompt(java.lang.String, android.webkit.GeolocationPermissions$Callback):void");
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        yb2 yb2VarZzL = this.zza.zzL();
        if (yb2VarZzL == null) {
            k92.h("Could not get ad overlay when hiding custom view.");
        } else {
            yb2VarZzL.zzg();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        yb2 yb2VarZzL = this.zza.zzL();
        if (yb2VarZzL == null) {
            k92.h("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        Activity activity = yb2VarZzL.g;
        FrameLayout frameLayout = new FrameLayout(activity);
        yb2VarZzL.m = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        yb2VarZzL.m.addView(view, -1, -1);
        activity.setContentView(yb2VarZzL.m);
        yb2VarZzL.w = true;
        yb2VarZzL.n = customViewCallback;
        yb2VarZzL.l = true;
        yb2VarZzL.f(i);
    }

    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzcej zzcejVar;
        h42 h42VarZzd;
        try {
            zzcejVar = this.zza;
        } catch (WindowManager.BadTokenException unused) {
            k92.j(5);
        }
        if (zzcejVar != null && zzcejVar.zzN() != null && this.zza.zzN().zzd() != null && (h42VarZzd = this.zza.zzN().zzd()) != null && !h42VarZzd.b()) {
            h42VarZzd.a("window." + str + "('" + str3 + "')");
            return false;
        }
        cd2 cd2Var = hd2.B.c;
        AlertDialog.Builder builderI = cd2.i(context);
        builderI.setTitle(str2);
        if (z) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builderI.setView(linearLayout).setPositiveButton(R.string.ok, new zzceg(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new zzcef(jsPromptResult)).setOnCancelListener(new zzcee(jsPromptResult)).create().show();
        } else {
            builderI.setMessage(str3).setPositiveButton(R.string.ok, new zzced(jsResult)).setNegativeButton(R.string.cancel, new zzcec(jsResult)).setOnCancelListener(new zzceb(jsResult)).create().show();
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
