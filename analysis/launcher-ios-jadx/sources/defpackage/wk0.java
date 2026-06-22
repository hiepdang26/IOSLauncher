package defpackage;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class wk0 {
    public final ArrayList a;

    public wk0() {
        this.a = new ArrayList();
    }

    public synchronized nb1 a(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return jl1.l;
        }
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            qo1 qo1Var = (qo1) obj;
            if (qo1Var.a.isAssignableFrom(cls) && cls2.isAssignableFrom(qo1Var.b)) {
                return qo1Var.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            qo1 qo1Var = (qo1) obj;
            if ((qo1Var.a.isAssignableFrom(cls) && cls2.isAssignableFrom(qo1Var.b)) && !arrayList.contains(qo1Var.b)) {
                arrayList.add(qo1Var.b);
            }
        }
        return arrayList;
    }

    public wk0(xk0 xk0Var, int i) {
        ArrayList arrayList;
        if (i == 0) {
            arrayList = new ArrayList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            XmlResourceParser xml = xk0Var.a.getResources().getXml(i);
            try {
                y9.b(xml, "resolve");
                int depth = xml.getDepth();
                while (true) {
                    int next = xml.next();
                    if (next == 3 && xml.getDepth() <= depth) {
                        break;
                    }
                    if (next == 1) {
                        break;
                    } else if (next == 2 && "favorite".equals(xml.getName())) {
                        arrayList2.add(Intent.parseUri(y9.e(xml, "uri"), 0));
                    }
                }
            } catch (IOException | URISyntaxException | XmlPullParserException unused) {
            } catch (Throwable th) {
                xml.close();
                throw th;
            }
            xml.close();
            arrayList = arrayList2;
        }
        this.a = arrayList;
    }
}
