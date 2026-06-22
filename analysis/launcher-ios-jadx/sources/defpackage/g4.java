package defpackage;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class g4 extends iy {
    public final Object n;
    public final Method o;
    public final Method p;

    public g4(Context context) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Locale locale = context.getResources().getConfiguration().locale;
        Class<?> cls = Class.forName("libcore.icu.AlphabeticIndex");
        this.o = cls.getDeclaredMethod("getBucketIndex", String.class);
        this.p = cls.getDeclaredMethod("getBucketLabel", Integer.TYPE);
        Object objNewInstance = cls.getConstructor(Locale.class).newInstance(locale);
        this.n = objNewInstance;
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        if (language.equals(locale2.getLanguage())) {
            return;
        }
        cls.getDeclaredMethod("addLabels", Locale.class).invoke(objNewInstance, locale2);
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
            return (String) this.p.invoke(this.n, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
            return super.l(i);
        }
    }
}
