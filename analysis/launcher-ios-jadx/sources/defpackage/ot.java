package defpackage;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ot implements x9 {
    public final /* synthetic */ int a;
    public final Object b;

    public ot(qt qtVar, int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new mt(qtVar);
                break;
            default:
                this.b = qtVar;
                break;
        }
    }

    @Override // defpackage.x9
    public final long a(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        switch (this.a) {
            case 0:
                qt qtVar = (qt) this.b;
                q11 q11VarE = q11.E(qtVar.b);
                if (q11VarE != null) {
                    String str = (String) q11VarE.h;
                    Resources resources = (Resources) q11VarE.i;
                    int identifier = resources.getIdentifier("partner_folder", "xml", str);
                    if (identifier != 0) {
                        XmlResourceParser xml = resources.getXml(identifier);
                        y9.b(xml, "folder");
                        HashMap map = new HashMap();
                        map.put("favorite", new mt(qtVar));
                        map.put("shortcut", new pt(qtVar, resources, 1));
                        return new v9(qtVar, map, 0).a(xml);
                    }
                }
                return -1L;
            default:
                int depth = xmlResourceParser.getDepth();
                long jA = -1;
                while (true) {
                    int next = xmlResourceParser.next();
                    if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                        return jA;
                    }
                    if (next == 2 && jA <= -1 && "favorite".equals(xmlResourceParser.getName())) {
                        jA = ((mt) this.b).a(xmlResourceParser);
                    }
                }
                break;
        }
    }
}
