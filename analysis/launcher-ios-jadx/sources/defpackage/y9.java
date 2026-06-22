package defpackage;

import android.appwidget.AppWidgetHost;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class y9 {
    public static final String n;
    public final w9 a;
    public final PackageManager b;
    public final Resources c;
    public final int d;
    public final String e;
    public final Context f;
    public final AppWidgetHost g;
    public final int i;
    public final int j;
    public final int k;
    public SQLiteDatabase m;
    public final long[] l = new long[2];
    public final ContentValues h = new ContentValues();

    static {
        Uri uri = wl0.a;
        n = "hotseat";
    }

    public y9(Context context, AppWidgetHost appWidgetHost, w9 w9Var, Resources resources, int i, String str) {
        this.f = context;
        this.g = appWidgetHost;
        this.a = w9Var;
        this.b = context.getPackageManager();
        this.e = str;
        this.c = resources;
        this.d = i;
        xg0 xg0Var = jk0.a().e;
        this.i = xg0Var.l;
        this.j = xg0Var.c;
        this.k = xg0Var.d;
    }

    public static final void b(XmlResourceParser xmlResourceParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xmlResourceParser.getName().equals(str)) {
            return;
        }
        throw new XmlPullParserException("Unexpected start tag: found " + xmlResourceParser.getName() + ", expected " + str);
    }

    public static y9 c(Context context, String str, Resources resources, AppWidgetHost appWidgetHost, w9 w9Var) {
        xg0 xg0Var = jk0.a().e;
        Locale locale = Locale.ENGLISH;
        StringBuilder sbL = uo.l(xg0Var.d, "default_layout_", "x");
        int i = xg0Var.c;
        sbL.append(i);
        sbL.append("_h");
        sbL.append(xg0Var.k);
        int identifier = resources.getIdentifier(sbL.toString(), "xml", str);
        if (identifier == 0) {
            identifier = resources.getIdentifier("default_layout_" + xg0Var.d + "x" + i, "xml", str);
        }
        if (identifier == 0) {
            identifier = resources.getIdentifier("default_layout", "xml", str);
        }
        int i2 = identifier;
        if (i2 == 0) {
            return null;
        }
        return new y9(context, appWidgetHost, w9Var, resources, i2, "workspace");
    }

    public static int d(XmlResourceParser xmlResourceParser, String str) {
        int attributeResourceValue = xmlResourceParser.getAttributeResourceValue("http://schemas.android.com/apk/res-auto/com.luutinhit.launcher6", str, 0);
        return attributeResourceValue == 0 ? xmlResourceParser.getAttributeResourceValue(null, str, 0) : attributeResourceValue;
    }

    public static String e(XmlResourceParser xmlResourceParser, String str) {
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res-auto/com.luutinhit.launcher6", str);
        return attributeValue == null ? xmlResourceParser.getAttributeValue(null, str) : attributeValue;
    }

    public long a(String str, Intent intent, int i) {
        w9 w9Var = this.a;
        long jGenerateNewItemId = w9Var.generateNewItemId();
        String uri = intent.toUri(0);
        ContentValues contentValues = this.h;
        contentValues.put("intent", uri);
        contentValues.put("title", str);
        contentValues.put("itemType", Integer.valueOf(i));
        contentValues.put("spanX", (Integer) 1);
        contentValues.put("spanY", (Integer) 1);
        contentValues.put("_id", Long.valueOf(jGenerateNewItemId));
        if (w9Var.insertAndCheck(this.m, contentValues) < 0) {
            return -1L;
        }
        return jGenerateNewItemId;
    }

    public HashMap f() {
        HashMap map = new HashMap();
        map.put("appicon", new u9(this, 0));
        map.put("autoinstall", new u9(this, 2));
        map.put("shortcut", new v9(this, this.c, 1));
        return map;
    }

    public HashMap g() {
        HashMap map = new HashMap();
        map.put("appicon", new u9(this, 0));
        map.put("autoinstall", new u9(this, 2));
        map.put("folder", new v9(this, f(), 0));
        map.put("appwidget", new u9(this, 1));
        map.put("shortcut", new v9(this, this.c, 1));
        return map;
    }

    public void h(XmlResourceParser xmlResourceParser, long[] jArr) {
        if (!n.equals(e(xmlResourceParser, "container"))) {
            jArr[0] = -100;
            jArr[1] = Long.parseLong(e(xmlResourceParser, "screen"));
            return;
        }
        jArr[0] = -101;
        long j = Long.parseLong(e(xmlResourceParser, "rank"));
        if (j >= this.i) {
            j++;
        }
        jArr[1] = j;
    }

    public final int i(ArrayList arrayList, int i) throws XmlPullParserException, IOException {
        int i2;
        int i3;
        XmlResourceParser xml = this.c.getXml(i);
        b(xml, this.e);
        int depth = xml.getDepth();
        HashMap mapG = g();
        int i4 = 0;
        while (true) {
            int next = xml.next();
            if (next == 3 && xml.getDepth() <= depth) {
                break;
            }
            int i5 = 1;
            if (next == 1) {
                break;
            }
            if (next == 2) {
                if ("include".equals(xml.getName())) {
                    int iD = d(xml, "workspace");
                    i5 = iD != 0 ? i(arrayList, iD) : 0;
                    i4 += i5;
                } else {
                    ContentValues contentValues = this.h;
                    contentValues.clear();
                    long[] jArr = this.l;
                    h(xml, jArr);
                    long j = jArr[0];
                    long j2 = jArr[1];
                    contentValues.put("container", Long.valueOf(j));
                    contentValues.put("screen", Long.valueOf(j2));
                    String strE = e(xml, "x");
                    if (!TextUtils.isEmpty(strE) && (i3 = Integer.parseInt(strE)) < 0) {
                        strE = Integer.toString(this.k + i3);
                    }
                    contentValues.put("cellX", strE);
                    String strE2 = e(xml, "y");
                    if (!TextUtils.isEmpty(strE2) && (i2 = Integer.parseInt(strE2)) < 0) {
                        strE2 = Integer.toString(this.j + i2);
                    }
                    contentValues.put("cellY", strE2);
                    x9 x9Var = (x9) mapG.get(xml.getName());
                    if (x9Var == null) {
                        xml.getName();
                    } else {
                        if (x9Var.a(xml) >= 0) {
                            if (!arrayList.contains(Long.valueOf(j2)) && j == -100) {
                                arrayList.add(Long.valueOf(j2));
                            }
                        }
                        i4 += i5;
                    }
                    i4 += i5;
                }
            }
        }
        return i4;
    }
}
