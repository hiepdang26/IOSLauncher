package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class pd0 implements cs {
    public final x90 g;
    public final int h;
    public HttpURLConnection i;
    public InputStream j;
    public volatile boolean k;

    public pd0(x90 x90Var, int i) {
        this.g = x90Var;
        this.h = i;
    }

    @Override // defpackage.cs
    public final Class a() {
        return InputStream.class;
    }

    @Override // defpackage.cs
    public final void b() {
        InputStream inputStream = this.j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.i = null;
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) {
        x90 x90Var = this.g;
        int i = tp0.a;
        SystemClock.elapsedRealtimeNanos();
        try {
            try {
                bsVar.g(e(x90Var.d(), 0, null, x90Var.b.b()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
            } catch (IOException e) {
                Log.isLoggable("HttpUrlFetcher", 3);
                bsVar.e(e);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
            throw th;
        }
    }

    @Override // defpackage.cs
    public final void cancel() {
        this.k = true;
    }

    @Override // defpackage.cs
    public final int d() {
        return 2;
    }

    public final InputStream e(URL url, int i, URL url2, Map map) throws sj {
        int responseCode;
        int responseCode2 = -1;
        if (i >= 5) {
            throw new sj("Too many (> 5) redirects!", -1, null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new sj("In re-direct loop", -1, null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int i2 = this.h;
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.i = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.j = this.i.getInputStream();
                if (this.k) {
                    return null;
                }
                try {
                    responseCode = this.i.getResponseCode();
                } catch (IOException unused2) {
                    Log.isLoggable("HttpUrlFetcher", 3);
                    responseCode = -1;
                }
                int i3 = responseCode / 100;
                if (i3 == 2) {
                    HttpURLConnection httpURLConnection2 = this.i;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.j = new yn(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                httpURLConnection2.getContentEncoding();
                            }
                            this.j = httpURLConnection2.getInputStream();
                        }
                        return this.j;
                    } catch (IOException e) {
                        try {
                            responseCode2 = httpURLConnection2.getResponseCode();
                        } catch (IOException unused3) {
                            Log.isLoggable("HttpUrlFetcher", 3);
                        }
                        throw new sj("Failed to obtain InputStream", responseCode2, e);
                    }
                }
                if (i3 != 3) {
                    if (responseCode == -1) {
                        throw new sj("Http request failed", responseCode, null);
                    }
                    try {
                        throw new sj(this.i.getResponseMessage(), responseCode, null);
                    } catch (IOException e2) {
                        throw new sj("Failed to get a response message", responseCode, e2);
                    }
                }
                String headerField = this.i.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new sj("Received empty or null redirect url", responseCode, null);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return e(url3, i + 1, url, map);
                } catch (MalformedURLException e3) {
                    throw new sj("Bad redirect url: " + headerField, responseCode, e3);
                }
            } catch (IOException e4) {
                try {
                    responseCode2 = this.i.getResponseCode();
                } catch (IOException unused4) {
                    Log.isLoggable("HttpUrlFetcher", 3);
                }
                throw new sj("Failed to connect or obtain data", responseCode2, e4);
            }
        } catch (IOException e5) {
            throw new sj("URL.openConnection threw", 0, e5);
        }
    }
}
