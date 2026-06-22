package defpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class tc2 implements l92 {
    public final String g;

    public tc2(String str) {
        this.g = str;
    }

    @Override // defpackage.l92
    public final boolean zza(String str) {
        boolean z = false;
        try {
            k92.d("Pinging URL: " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                ka2 ka2Var = x32.f.a;
                String str2 = this.g;
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setReadTimeout(60000);
                if (str2 != null) {
                    httpURLConnection.setRequestProperty("User-Agent", str2);
                }
                httpURLConnection.setUseCaches(false);
                ub2 ub2Var = new ub2();
                ub2Var.a(httpURLConnection, null);
                int responseCode = httpURLConnection.getResponseCode();
                ub2Var.b(httpURLConnection, responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    k92.h("Received non-success response code " + responseCode + " from pinging URL: " + str);
                } else {
                    z = true;
                }
                return z;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e = e;
            k92.h("Error while pinging URL: " + str + ". " + e.getMessage());
            return false;
        } catch (IndexOutOfBoundsException e2) {
            k92.h("Error while parsing ping URL: " + str + ". " + e2.getMessage());
            return false;
        } catch (RuntimeException e3) {
            e = e3;
            k92.h("Error while pinging URL: " + str + ". " + e.getMessage());
            return false;
        } finally {
        }
    }
}
