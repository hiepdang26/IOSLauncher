package defpackage;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ic0 {
    public static final ib0[] a;
    public static final Map b;

    static {
        ib0 ib0Var = new ib0(ib0.i, "");
        df dfVar = ib0.f;
        ib0 ib0Var2 = new ib0(dfVar, "GET");
        ib0 ib0Var3 = new ib0(dfVar, "POST");
        df dfVar2 = ib0.g;
        ib0 ib0Var4 = new ib0(dfVar2, "/");
        ib0 ib0Var5 = new ib0(dfVar2, "/index.html");
        df dfVar3 = ib0.h;
        ib0 ib0Var6 = new ib0(dfVar3, "http");
        ib0 ib0Var7 = new ib0(dfVar3, "https");
        df dfVar4 = ib0.e;
        ib0[] ib0VarArr = {ib0Var, ib0Var2, ib0Var3, ib0Var4, ib0Var5, ib0Var6, ib0Var7, new ib0(dfVar4, "200"), new ib0(dfVar4, "204"), new ib0(dfVar4, "206"), new ib0(dfVar4, "304"), new ib0(dfVar4, "400"), new ib0(dfVar4, "404"), new ib0(dfVar4, "500"), new ib0("accept-charset", ""), new ib0("accept-encoding", "gzip, deflate"), new ib0("accept-language", ""), new ib0("accept-ranges", ""), new ib0("accept", ""), new ib0("access-control-allow-origin", ""), new ib0("age", ""), new ib0("allow", ""), new ib0("authorization", ""), new ib0("cache-control", ""), new ib0("content-disposition", ""), new ib0("content-encoding", ""), new ib0("content-language", ""), new ib0("content-length", ""), new ib0("content-location", ""), new ib0("content-range", ""), new ib0("content-type", ""), new ib0("cookie", ""), new ib0("date", ""), new ib0("etag", ""), new ib0("expect", ""), new ib0("expires", ""), new ib0("from", ""), new ib0("host", ""), new ib0("if-match", ""), new ib0("if-modified-since", ""), new ib0("if-none-match", ""), new ib0("if-range", ""), new ib0("if-unmodified-since", ""), new ib0("last-modified", ""), new ib0("link", ""), new ib0("location", ""), new ib0("max-forwards", ""), new ib0("proxy-authenticate", ""), new ib0("proxy-authorization", ""), new ib0("range", ""), new ib0("referer", ""), new ib0("refresh", ""), new ib0("retry-after", ""), new ib0("server", ""), new ib0("set-cookie", ""), new ib0("strict-transport-security", ""), new ib0("transfer-encoding", ""), new ib0("user-agent", ""), new ib0("vary", ""), new ib0("via", ""), new ib0("www-authenticate", "")};
        a = ib0VarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ib0VarArr.length);
        for (int i = 0; i < ib0VarArr.length; i++) {
            if (!linkedHashMap.containsKey(ib0VarArr[i].a)) {
                linkedHashMap.put(ib0VarArr[i].a, Integer.valueOf(i));
            }
        }
        b = Collections.unmodifiableMap(linkedHashMap);
    }

    public static void a(df dfVar) throws IOException {
        int i = dfVar.i();
        for (int i2 = 0; i2 < i; i2++) {
            byte bD = dfVar.d(i2);
            if (bD >= 65 && bD <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + dfVar.l());
            }
        }
    }
}
