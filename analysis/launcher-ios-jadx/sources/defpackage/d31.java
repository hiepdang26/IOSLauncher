package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreference;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class d31 {
    public static final Class[] e = {Context.class, AttributeSet.class};
    public static final HashMap f = new HashMap();
    public final Context a;
    public final e31 c;
    public final Object[] b = new Object[2];
    public final String[] d = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    public d31(Context context, e31 e31Var) {
        this.a = context;
        this.c = e31Var;
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) throws ClassNotFoundException {
        Class<?> cls;
        HashMap map = f;
        Constructor<?> constructor = (Constructor) map.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.a.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException e2 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e3) {
                                e2 = e3;
                            }
                        }
                        if (cls == null) {
                            if (e2 != null) {
                                throw e2;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = cls.getConstructor(e);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                } catch (Exception e4) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e4);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e5) {
                throw e5;
            }
        }
        Object[] objArr = this.b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? a(str, this.d, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    public final PreferenceGroup c(XmlResourceParser xmlResourceParser, PreferenceGroup preferenceGroup) {
        int next;
        synchronized (this.b) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
            this.b[0] = this.a;
            do {
                try {
                    try {
                        try {
                            next = xmlResourceParser.next();
                            if (next == 2) {
                                break;
                            }
                        } catch (IOException e2) {
                            InflateException inflateException = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e2.getMessage());
                            inflateException.initCause(e2);
                            throw inflateException;
                        }
                    } catch (InflateException e3) {
                        throw e3;
                    }
                } catch (XmlPullParserException e4) {
                    InflateException inflateException2 = new InflateException(e4.getMessage());
                    inflateException2.initCause(e4);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
            }
            PreferenceGroup preferenceGroup2 = (PreferenceGroup) b(xmlResourceParser.getName(), attributeSetAsAttributeSet);
            if (preferenceGroup == null) {
                preferenceGroup2.j(this.c);
                preferenceGroup = preferenceGroup2;
            }
            d(xmlResourceParser, preferenceGroup, attributeSetAsAttributeSet);
        }
        return preferenceGroup;
    }

    public final void d(XmlResourceParser xmlResourceParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        long jD;
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next == 3 && xmlResourceParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.r = Intent.parseIntent(this.a.getResources(), xmlResourceParser, attributeSet);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e2);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    Resources resources = this.a.getResources();
                    if (preference.t == null) {
                        preference.t = new Bundle();
                    }
                    resources.parseBundleExtra("extra", attributeSet, preference.t);
                    try {
                        int depth2 = xmlResourceParser.getDepth();
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == 1 || (next2 == 3 && xmlResourceParser.getDepth() <= depth2)) {
                                break;
                            }
                        }
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e3);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                    if (!preferenceGroup.T.contains(preferenceB)) {
                        if (preferenceB.q != null) {
                            PreferenceGroup preferenceGroup2 = preferenceGroup;
                            while (true) {
                                PreferenceGroup preferenceGroup3 = preferenceGroup2.N;
                                if (preferenceGroup3 == null) {
                                    break;
                                } else {
                                    preferenceGroup2 = preferenceGroup3;
                                }
                            }
                            preferenceGroup2.w(preferenceB.q);
                        }
                        int i = preferenceB.l;
                        if (i == Integer.MAX_VALUE) {
                            if (preferenceGroup.U) {
                                int i2 = preferenceGroup.V;
                                preferenceGroup.V = i2 + 1;
                                if (i2 != i) {
                                    preferenceB.l = i2;
                                    c31 c31Var = preferenceB.L;
                                    if (c31Var != null) {
                                        Handler handler = c31Var.n;
                                        fl0 fl0Var = c31Var.o;
                                        handler.removeCallbacks(fl0Var);
                                        handler.post(fl0Var);
                                    }
                                }
                            }
                            if (preferenceB instanceof PreferenceGroup) {
                                ((PreferenceGroup) preferenceB).U = preferenceGroup.U;
                            }
                        }
                        int iBinarySearch = Collections.binarySearch(preferenceGroup.T, preferenceB);
                        if (iBinarySearch < 0) {
                            iBinarySearch = (iBinarySearch * (-1)) - 1;
                        }
                        boolean zU = preferenceGroup.u();
                        if (preferenceB.A == zU) {
                            preferenceB.A = !zU;
                            preferenceB.h(preferenceB.u());
                            preferenceB.g();
                        }
                        synchronized (preferenceGroup) {
                            preferenceGroup.T.add(iBinarySearch, preferenceB);
                        }
                        e31 e31Var = preferenceGroup.h;
                        String str = preferenceB.q;
                        if (str == null || !preferenceGroup.S.containsKey(str)) {
                            jD = e31Var.d();
                        } else {
                            jD = ((Long) preferenceGroup.S.get(str)).longValue();
                            preferenceGroup.S.remove(str);
                        }
                        preferenceB.i = jD;
                        preferenceB.j = true;
                        try {
                            preferenceB.j(e31Var);
                            preferenceB.j = false;
                            if (preferenceB.N != null) {
                                throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
                            }
                            preferenceB.N = preferenceGroup;
                            if (preferenceGroup.W) {
                                preferenceB.i();
                            }
                            c31 c31Var2 = preferenceGroup.L;
                            if (c31Var2 != null) {
                                Handler handler2 = c31Var2.n;
                                fl0 fl0Var2 = c31Var2.o;
                                handler2.removeCallbacks(fl0Var2);
                                handler2.post(fl0Var2);
                            }
                        } catch (Throwable th) {
                            preferenceB.j = false;
                            throw th;
                        }
                    }
                    d(xmlResourceParser, preferenceB, attributeSet);
                }
            }
        }
    }
}
