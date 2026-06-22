package defpackage;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public interface yw1 {
    WebViewProviderBoundaryInterface createWebView(WebView webView);

    StaticsBoundaryInterface getStatics();

    String[] h();
}
