package defpackage;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class nt extends v9 {
    public final /* synthetic */ qt d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt(qt qtVar) {
        super(qtVar, qtVar.f(), 0);
        this.d = qtVar;
    }

    @Override // defpackage.v9, defpackage.x9
    public final long a(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int iD = y9.d(xmlResourceParser, "folderItems");
        if (iD != 0) {
            xmlResourceParser = this.d.c.getXml(iD);
            y9.b(xmlResourceParser, "folder");
        }
        return super.a(xmlResourceParser);
    }
}
