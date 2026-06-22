package defpackage;

import android.util.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class ub2 {
    public static boolean c = false;
    public static boolean d = false;
    public final List a;
    public static final Object b = new Object();
    public static final HashSet e = new HashSet(Arrays.asList(new String[0]));

    public ub2() {
        this.a = !c() ? new ArrayList() : Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
    }

    public static boolean c() {
        boolean z;
        synchronized (b) {
            try {
                z = false;
                if (c && d) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public static void e(JsonWriter jsonWriter, Map map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (!e.contains(str)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        k92.e("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(str);
                    jsonWriter.name("value").value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value(str2);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    public final void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (c()) {
            d("onNetworkRequest", new ol1(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr));
        }
    }

    public final void b(HttpURLConnection httpURLConnection, int i) {
        if (c()) {
            String responseMessage = null;
            d("onNetworkResponse", new t3(i, httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields())));
            if (i < 200 || i >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    k92.h("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e2.getMessage())));
                }
                d("onNetworkRequestError", new wg1(responseMessage, 3));
            }
        }
    }

    public final void d(String str, nb2 nb2Var) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(System.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                jsonWriter.value((String) it.next());
            }
            jsonWriter.endArray();
            nb2Var.a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException unused) {
            k92.f();
        }
        String string = stringWriter.toString();
        synchronized (ub2.class) {
            try {
                k92.g("GMA Debug BEGIN");
                int i = 0;
                while (i < string.length()) {
                    int i2 = i + 4000;
                    k92.g("GMA Debug CONTENT ".concat(String.valueOf(string.substring(i, Math.min(i2, string.length())))));
                    i = i2;
                }
                k92.g("GMA Debug FINISH");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
