package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.internal.ads.zzbbw;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p42 implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    public /* synthetic */ p42(Object obj, Object obj2, int i) {
        this.g = i;
        this.h = obj;
        this.i = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        SharedPreferences sharedPreferences;
        boolean z = false;
        Object obj = this.h;
        Object obj2 = this.i;
        switch (this.g) {
            case 0:
                return ((km1) obj).getClickSignals((String) obj2);
            case 1:
                Context context = (Context) obj;
                Context context2 = (Context) obj2;
                if (context != null) {
                    k92.a("Attempting to read user agent from Google Play Services.");
                    sharedPreferences = context.getSharedPreferences("admob_user_agent", 0);
                } else {
                    k92.a("Attempting to read user agent from local cache.");
                    sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                    z = true;
                }
                String string = sharedPreferences.getString("user_agent", "");
                if (TextUtils.isEmpty(string)) {
                    k92.a("Reading user agent from WebSettings");
                    string = WebSettings.getDefaultUserAgent(context2);
                    if (z) {
                        sharedPreferences.edit().putString("user_agent", string).apply();
                        k92.a("Persisting user agent.");
                    }
                }
                return string;
            default:
                ja2 ja2Var = cd2.l;
                WebSettings webSettings = (WebSettings) obj;
                webSettings.setDatabasePath(((Context) obj2).getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) n42.d.c.zza(zzbbw.zzaC)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return Boolean.TRUE;
        }
    }
}
