package defpackage;

import android.appwidget.AppWidgetHost;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class qt extends y9 {
    public qt(Context context, AppWidgetHost appWidgetHost, w9 w9Var, Resources resources, int i) {
        super(context, appWidgetHost, w9Var, resources, i, "favorites");
    }

    @Override // defpackage.y9
    public final HashMap f() {
        HashMap map = new HashMap();
        map.put("favorite", new mt(this));
        map.put("shortcut", new pt(this, this.c, 1));
        return map;
    }

    @Override // defpackage.y9
    public final HashMap g() {
        HashMap map = new HashMap();
        map.put("favorite", new mt(this));
        map.put("appwidget", new u9(this, 1));
        map.put("shortcut", new pt(this, this.c, 1));
        map.put("resolve", new ot(this, 1));
        map.put("folder", new nt(this));
        map.put("partner-folder", new ot(this, 0));
        return map;
    }

    @Override // defpackage.y9
    public final void h(XmlResourceParser xmlResourceParser, long[] jArr) {
        jArr[0] = -100;
        String strE = y9.e(xmlResourceParser, "container");
        if (strE != null) {
            jArr[0] = Long.valueOf(strE).longValue();
        }
        jArr[1] = Long.parseLong(y9.e(xmlResourceParser, "screen"));
    }
}
