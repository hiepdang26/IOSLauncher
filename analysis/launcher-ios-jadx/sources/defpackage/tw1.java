package defpackage;

import android.content.pm.PackageInfo;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class tw1 {
    public static final /* synthetic */ int a = 0;

    static {
        Uri.parse("*");
        Uri.parse("");
    }

    public static PackageInfo a() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }
}
