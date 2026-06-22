package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class h4 extends iy {
    public final Object n;
    public final Method o;
    public final Method p;
    public final Method q;

    public h4(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke = Configuration.class.getDeclaredMethod("getLocales", null).invoke(context.getResources().getConfiguration(), null);
        int iIntValue = ((Integer) objInvoke.getClass().getDeclaredMethod("size", null).invoke(objInvoke, null)).intValue();
        Class<?> cls = objInvoke.getClass();
        Class<?> cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("get", cls2);
        Locale locale = iIntValue == 0 ? Locale.ENGLISH : (Locale) declaredMethod.invoke(objInvoke, 0);
        Class<?> cls3 = Class.forName("android.icu.text.AlphabeticIndex");
        this.n = cls3.getConstructor(Locale.class).newInstance(locale);
        Method declaredMethod2 = cls3.getDeclaredMethod("addLabels", Locale[].class);
        for (int i = 1; i < iIntValue; i++) {
            declaredMethod2.invoke(this.n, new Locale[]{(Locale) declaredMethod.invoke(objInvoke, Integer.valueOf(i))});
        }
        declaredMethod2.invoke(this.n, new Locale[]{Locale.ENGLISH});
        Object objInvoke2 = this.n.getClass().getDeclaredMethod("buildImmutableIndex", null).invoke(this.n, null);
        this.n = objInvoke2;
        this.o = objInvoke2.getClass().getDeclaredMethod("getBucketIndex", CharSequence.class);
        Method declaredMethod3 = objInvoke2.getClass().getDeclaredMethod("getBucket", cls2);
        this.p = declaredMethod3;
        this.q = declaredMethod3.getReturnType().getDeclaredMethod("getLabel", null);
    }

    @Override // defpackage.iy
    public final int k(String str) {
        try {
            return ((Integer) this.o.invoke(this.n, str)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return super.k(str);
        }
    }

    @Override // defpackage.iy
    public final String l(int i) {
        try {
            return (String) this.q.invoke(this.p.invoke(this.n, Integer.valueOf(i)), null);
        } catch (Exception e) {
            e.printStackTrace();
            return super.l(i);
        }
    }
}
