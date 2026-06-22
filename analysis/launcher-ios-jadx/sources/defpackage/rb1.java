package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class rb1 {
    public static final ThreadLocal a = new ThreadLocal();
    public static final WeakHashMap b = new WeakHashMap(0);
    public static final Object c = new Object();

    public static void a(pb1 pb1Var, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (c) {
            try {
                WeakHashMap weakHashMap = b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(pb1Var);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(pb1Var, sparseArray);
                }
                sparseArray.append(i, new ob1(colorStateList, pb1Var.a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface b(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return c(context, i, new TypedValue(), 0, null, false, false);
    }

    public static Typeface c(Context context, int i, TypedValue typedValue, int i2, qb1 qb1Var, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        Typeface typefaceA = null;
        if (string.startsWith("res/")) {
            int i3 = typedValue.assetCookie;
            gq0 gq0Var = op1.b;
            Typeface typeface = (Typeface) gq0Var.get(op1.b(resources, i, string, i3, i2));
            if (typeface != null) {
                if (qb1Var != null) {
                    qb1Var.callbackSuccessAsync(typeface, null);
                }
                typefaceA = typeface;
            } else if (!z2) {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        i50 i50VarR = p02.r(resources.getXml(i), resources);
                        if (i50VarR != null) {
                            typefaceA = op1.a(context, i50VarR, resources, i, string, typedValue.assetCookie, i2, qb1Var, z);
                        } else if (qb1Var != null) {
                            qb1Var.callbackFailAsync(-3, null);
                        }
                    } else {
                        int i4 = typedValue.assetCookie;
                        Typeface typefaceK = op1.a.k(context, resources, i, string, i2);
                        if (typefaceK != null) {
                            gq0Var.put(op1.b(resources, i, string, i4, i2), typefaceK);
                        }
                        if (qb1Var != null) {
                            if (typefaceK != null) {
                                qb1Var.callbackSuccessAsync(typefaceK, null);
                            } else {
                                qb1Var.callbackFailAsync(-3, null);
                            }
                        }
                        typefaceA = typefaceK;
                    }
                } catch (IOException | XmlPullParserException unused) {
                    if (qb1Var != null) {
                        qb1Var.callbackFailAsync(-3, null);
                    }
                }
            }
        } else if (qb1Var != null) {
            qb1Var.callbackFailAsync(-3, null);
        }
        if (typefaceA != null || qb1Var != null || z2) {
            return typefaceA;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }
}
