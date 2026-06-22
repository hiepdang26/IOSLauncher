package defpackage;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class rk1 implements MenuItem.OnMenuItemClickListener {
    public static final Class[] j = {MenuItem.class};
    public final /* synthetic */ int g = 0;
    public Object h;
    public Object i;

    public /* synthetic */ rk1() {
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.g) {
            case 0:
                Method method = (Method) this.i;
                try {
                    Class<?> returnType = method.getReturnType();
                    Class<?> cls = Boolean.TYPE;
                    Object obj = this.h;
                    if (returnType == cls) {
                        return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                    }
                    method.invoke(obj, menuItem);
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            default:
                return ((MenuItem.OnMenuItemClickListener) this.h).onMenuItemClick(((qt0) this.i).g(menuItem));
        }
    }

    public rk1(qt0 qt0Var, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.i = qt0Var;
        this.h = onMenuItemClickListener;
    }
}
