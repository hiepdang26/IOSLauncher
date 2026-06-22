package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public final class hm {
    public boolean a = false;
    public String b;
    public int c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    public hm(hm hmVar, Object obj) {
        this.b = hmVar.b;
        this.c = hmVar.c;
        f(obj);
    }

    public static void d(Context context, XmlPullParser xmlPullParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), j71.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf = null;
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == j71.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == j71.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z = true;
            } else if (index == j71.CustomAttribute_customBoolean) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i = 6;
            } else if (index == j71.CustomAttribute_customColorValue) {
                objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                i = 3;
            } else if (index == j71.CustomAttribute_customColorDrawableValue) {
                objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                i = 4;
            } else {
                if (index == j71.CustomAttribute_customPixelDimension) {
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == j71.CustomAttribute_customDimension) {
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == j71.CustomAttribute_customFloatValue) {
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    i = 2;
                } else if (index == j71.CustomAttribute_customIntegerValue) {
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    i = 1;
                } else if (index == j71.CustomAttribute_customStringValue) {
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                    i = 5;
                } else if (index == j71.CustomAttribute_customReference) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                    i = 8;
                }
                i = 7;
            }
        }
        if (string != null && objValueOf != null) {
            hm hmVar = new hm();
            hmVar.b = string;
            hmVar.c = i;
            hmVar.a = z;
            hmVar.f(objValueOf);
            map.put(string, hmVar);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void e(View view, HashMap map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            hm hmVar = (hm) map.get(str);
            if (!hmVar.a) {
                str = "set" + str;
            }
            try {
                int iV = uo.v(hmVar.c);
                Class<?> cls2 = Float.TYPE;
                Class<?> cls3 = Integer.TYPE;
                switch (iV) {
                    case 0:
                        cls.getMethod(str, cls3).invoke(view, Integer.valueOf(hmVar.d));
                        break;
                    case 1:
                        cls.getMethod(str, cls2).invoke(view, Float.valueOf(hmVar.e));
                        break;
                    case 2:
                        cls.getMethod(str, cls3).invoke(view, Integer.valueOf(hmVar.h));
                        break;
                    case 3:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(hmVar.h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(str, CharSequence.class).invoke(view, hmVar.f);
                        break;
                    case 5:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(hmVar.g));
                        break;
                    case 6:
                        cls.getMethod(str, cls2).invoke(view, Float.valueOf(hmVar.e));
                        break;
                    case 7:
                        cls.getMethod(str, cls3).invoke(view, Integer.valueOf(hmVar.d));
                        break;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }

    public final float a() {
        switch (uo.v(this.c)) {
            case 0:
                return this.d;
            case 1:
            case 6:
                return this.e;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.g ? 1.0f : 0.0f;
            default:
                return Float.NaN;
        }
    }

    public final void b(float[] fArr) {
        switch (uo.v(this.c)) {
            case 0:
                fArr[0] = this.d;
                return;
            case 1:
                fArr[0] = this.e;
                return;
            case 2:
            case 3:
                int i = (this.h >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.g ? 1.0f : 0.0f;
                return;
            case 6:
                fArr[0] = this.e;
                return;
            default:
                return;
        }
    }

    public final int c() {
        int iV = uo.v(this.c);
        return (iV == 2 || iV == 3) ? 4 : 1;
    }

    public final void f(Object obj) {
        switch (uo.v(this.c)) {
            case 0:
            case 7:
                this.d = ((Integer) obj).intValue();
                break;
            case 1:
                this.e = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.h = ((Integer) obj).intValue();
                break;
            case 4:
                this.f = (String) obj;
                break;
            case 5:
                this.g = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.e = ((Float) obj).floatValue();
                break;
        }
    }
}
