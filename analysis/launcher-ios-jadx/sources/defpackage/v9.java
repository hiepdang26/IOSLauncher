package defpackage;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;

/* JADX INFO: loaded from: classes.dex */
public class v9 implements x9 {
    public final /* synthetic */ int a;
    public final /* synthetic */ y9 b;
    public final Object c;

    public /* synthetic */ v9(y9 y9Var, Object obj, int i) {
        this.a = i;
        this.b = y9Var;
        this.c = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x039d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029b  */
    @Override // defpackage.x9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(android.content.res.XmlResourceParser r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v9.a(android.content.res.XmlResourceParser):long");
    }

    public Intent b(XmlResourceParser xmlResourceParser) {
        String strE = y9.e(xmlResourceParser, "url");
        if (TextUtils.isEmpty(strE) || !Patterns.WEB_URL.matcher(strE).matches()) {
            return null;
        }
        return new Intent("android.intent.action.VIEW", (Uri) null).setData(Uri.parse(strE));
    }
}
