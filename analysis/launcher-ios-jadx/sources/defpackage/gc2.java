package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzfgi;

/* JADX INFO: loaded from: classes.dex */
public final class gc2 extends WebViewClient {
    public final /* synthetic */ dd2 a;

    public gc2(dd2 dd2Var) {
        this.a = dd2Var;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        dd2 dd2Var = this.a;
        a52 a52Var = dd2Var.m;
        if (a52Var != null) {
            try {
                a52Var.zzf(zzfgi.zzd(1, null, null));
            } catch (RemoteException e) {
                k92.i("#007 Could not call remote method.", e);
            }
        }
        a52 a52Var2 = dd2Var.m;
        if (a52Var2 != null) {
            try {
                a52Var2.zze(0);
            } catch (RemoteException e2) {
                k92.i("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        dd2 dd2Var = this.a;
        int iN = 0;
        if (str.startsWith(dd2Var.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            a52 a52Var = dd2Var.m;
            if (a52Var != null) {
                try {
                    a52Var.zzf(zzfgi.zzd(3, null, null));
                } catch (RemoteException e) {
                    k92.i("#007 Could not call remote method.", e);
                }
            }
            a52 a52Var2 = dd2Var.m;
            if (a52Var2 != null) {
                try {
                    a52Var2.zze(3);
                } catch (RemoteException e2) {
                    k92.i("#007 Could not call remote method.", e2);
                }
            }
            dd2Var.f(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            a52 a52Var3 = dd2Var.m;
            if (a52Var3 != null) {
                try {
                    a52Var3.zzf(zzfgi.zzd(1, null, null));
                } catch (RemoteException e3) {
                    k92.i("#007 Could not call remote method.", e3);
                }
            }
            a52 a52Var4 = dd2Var.m;
            if (a52Var4 != null) {
                try {
                    a52Var4.zze(0);
                } catch (RemoteException e4) {
                    k92.i("#007 Could not call remote method.", e4);
                }
            }
            dd2Var.f(0);
            return true;
        }
        boolean zStartsWith = str.startsWith("gmsg://adResized");
        Context context = dd2Var.j;
        if (zStartsWith) {
            a52 a52Var5 = dd2Var.m;
            if (a52Var5 != null) {
                try {
                    a52Var5.zzi();
                } catch (RemoteException e5) {
                    k92.i("#007 Could not call remote method.", e5);
                }
            }
            String queryParameter = Uri.parse(str).getQueryParameter("height");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    ka2 ka2Var = x32.f.a;
                    iN = ka2.n(context, Integer.parseInt(queryParameter));
                } catch (NumberFormatException unused) {
                }
            }
            dd2Var.f(iN);
            return true;
        }
        if (!str.startsWith("gmsg://")) {
            a52 a52Var6 = dd2Var.m;
            if (a52Var6 != null) {
                try {
                    a52Var6.zzc();
                    dd2Var.m.zzh();
                } catch (RemoteException e6) {
                    k92.i("#007 Could not call remote method.", e6);
                }
            }
            if (dd2Var.n != null) {
                Uri uriZza = Uri.parse(str);
                try {
                    uriZza = dd2Var.n.zza(uriZza, context, null, null);
                } catch (zzaup unused2) {
                    k92.j(5);
                }
                str = uriZza.toString();
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        }
        return true;
    }
}
