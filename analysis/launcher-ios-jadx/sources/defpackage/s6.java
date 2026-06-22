package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class s6 implements View.OnClickListener {
    public final View g;
    public final String h;
    public Method i;
    public Context j;

    public s6(String str, View view) {
        this.g = view;
        this.h = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Method method;
        if (this.i == null) {
            View view2 = this.g;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.h;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder sbO = uo.o("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    sbO.append(view2.getClass());
                    sbO.append(str);
                    throw new IllegalStateException(sbO.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.i = method;
                        this.j = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.i.invoke(this.j, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
