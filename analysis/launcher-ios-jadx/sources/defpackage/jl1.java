package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
public class jl1 implements xo, yw1, nb1, oc, qe, mu0, p60, wa1, h20, z20, vk1, lb1, t21, vp0, d01 {
    public static final /* synthetic */ jl1 h = new jl1(1);
    public static final String[] i = new String[0];
    public static final jl1 j = new jl1(3);
    public static final jl1 k = new jl1(4);
    public static final jl1 l = new jl1(5);
    public static final jl1 m = new jl1(6);
    public static jl1 n;
    public final /* synthetic */ int g;

    public /* synthetic */ jl1(int i2) {
        this.g = i2;
    }

    public static ArrayList u(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new jb0((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.qe
    public Class a() {
        switch (this.g) {
        }
        return InputStream.class;
    }

    @Override // defpackage.z20
    public void b(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    @Override // defpackage.vp0
    public void c(Level level, String str) {
        System.out.println("[" + level + "] " + str);
    }

    @Override // defpackage.h20
    public Object create() {
        return new ArrayList();
    }

    @Override // defpackage.yw1
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // defpackage.vk1
    public wk1 d(xh xhVar) {
        return new x60((Context) xhVar.c, (String) xhVar.d, (ei) xhVar.e, xhVar.a, xhVar.b);
    }

    @Override // defpackage.oc
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // defpackage.zz
    public boolean f(Object obj, File file, g01 g01Var) throws Throwable {
        try {
            cf.d(((r80) ((l80) ((eb1) obj).get()).g.b).a.d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }

    @Override // defpackage.yw1
    public StaticsBoundaryInterface getStatics() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // defpackage.yw1
    public String[] h() {
        return i;
    }

    @Override // defpackage.oc
    public Bitmap i(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public void j(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // defpackage.lb1
    public int k(g01 g01Var) {
        return 1;
    }

    @Override // defpackage.qe
    public Object m(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @Override // defpackage.t21
    public CharSequence n(Preference preference) {
        CharSequence[] charSequenceArr;
        CharSequence[] charSequenceArr2;
        ListPreference listPreference = (ListPreference) preference;
        int iW = listPreference.w(listPreference.a0);
        if (TextUtils.isEmpty((iW < 0 || (charSequenceArr2 = listPreference.Y) == null) ? null : charSequenceArr2[iW])) {
            return listPreference.g.getString(r61.not_set);
        }
        int iW2 = listPreference.w(listPreference.a0);
        if (iW2 < 0 || (charSequenceArr = listPreference.Y) == null) {
            return null;
        }
        return charSequenceArr[iW2];
    }

    @Override // defpackage.z20
    public Object p(File file) {
        return new FileInputStream(file);
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new aq1(1);
    }

    @Override // defpackage.vp0
    public void t(Level level, String str, Throwable th) {
        System.out.println("[" + level + "] " + str);
        th.printStackTrace(System.out);
    }

    public String toString() {
        switch (this.g) {
            case 22:
                return "EmptyConsumer";
            default:
                return super.toString();
        }
    }

    public se v(yi0 yi0Var, Map map) throws Throwable {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(Collections.EMPTY_MAP);
        URL url = new URL(yi0Var.h);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int i2 = yi0Var.p.a;
        httpURLConnection.setConnectTimeout(i2);
        httpURLConnection.setReadTimeout(i2);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                se seVar = new se(responseCode, u(httpURLConnection.getHeaderFields()), -1, (InputStream) null);
                httpURLConnection.disconnect();
                return seVar;
            }
            try {
                try {
                    return new se(responseCode, u(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new rd0(httpURLConnection));
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    if (!z) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public jl1(h60 h60Var) {
        this.g = 20;
    }

    @Override // defpackage.oc
    public void r() {
    }

    @Override // defpackage.oc
    public void o(int i2) {
    }

    @Override // defpackage.p60
    public void q(e6 e6Var) {
    }

    @Override // defpackage.nb1
    public eb1 l(eb1 eb1Var, g01 g01Var) {
        return eb1Var;
    }

    @Override // defpackage.d01
    public void g(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }
}
