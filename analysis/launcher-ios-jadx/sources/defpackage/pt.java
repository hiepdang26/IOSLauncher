package defpackage;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes.dex */
public final class pt extends v9 {
    @Override // defpackage.v9
    public final Intent b(XmlResourceParser xmlResourceParser) {
        try {
            return Intent.parseUri(y9.e(xmlResourceParser, "uri"), 0);
        } catch (URISyntaxException unused) {
            return null;
        }
    }
}
