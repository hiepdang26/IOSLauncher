package defpackage;

import android.net.Uri;
import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class z12 extends Thread {
    public final /* synthetic */ int g;
    public final /* synthetic */ Serializable h;

    public /* synthetic */ z12(Serializable serializable, int i) {
        this.g = i;
        this.h = serializable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
                HashMap map = (HashMap) this.h;
                for (String str : map.keySet()) {
                    builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
                }
                String string = builderBuildUpon.build().toString();
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode < 200 || responseCode >= 300) {
                            new StringBuilder(String.valueOf(string).length() + 65);
                            break;
                        }
                        httpURLConnection.disconnect();
                        return;
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    String message = e.getMessage();
                    new StringBuilder(String.valueOf(message).length() + String.valueOf(string).length() + 27);
                    return;
                } catch (IndexOutOfBoundsException e2) {
                    String message2 = e2.getMessage();
                    new StringBuilder(String.valueOf(message2).length() + String.valueOf(string).length() + 32);
                    return;
                } catch (RuntimeException e3) {
                    e = e3;
                    String message3 = e.getMessage();
                    new StringBuilder(String.valueOf(message3).length() + String.valueOf(string).length() + 27);
                    return;
                } finally {
                }
            default:
                new tc2(null).zza((String) this.h);
                return;
        }
    }
}
