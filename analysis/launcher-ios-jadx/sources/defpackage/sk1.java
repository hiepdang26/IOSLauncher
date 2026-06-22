package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class sk1 {
    public CharSequence A;
    public CharSequence B;
    public final /* synthetic */ tk1 E;
    public final Menu a;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public m1 z;
    public ColorStateList C = null;
    public PorterDuff.Mode D = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public boolean f = true;
    public boolean g = true;

    public sk1(tk1 tk1Var, Menu menu) {
        this.E = tk1Var;
        this.a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.E.c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z = false;
        menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
        int i = this.v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        String str = this.y;
        tk1 tk1Var = this.E;
        if (str != null) {
            if (tk1Var.c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (tk1Var.d == null) {
                tk1Var.d = tk1.a(tk1Var.c);
            }
            Object obj = tk1Var.d;
            String str2 = this.y;
            rk1 rk1Var = new rk1();
            rk1Var.h = obj;
            Class<?> cls = obj.getClass();
            try {
                rk1Var.i = cls.getMethod(str2, rk1.j);
                menuItem.setOnMenuItemClickListener(rk1Var);
            } catch (Exception e) {
                StringBuilder sbO = uo.o("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbO.append(cls.getName());
                InflateException inflateException = new InflateException(sbO.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.r >= 2) {
            if (menuItem instanceof mt0) {
                ((mt0) menuItem).f(true);
            } else if (menuItem instanceof qt0) {
                qt0 qt0Var = (qt0) menuItem;
                try {
                    Method method = qt0Var.j;
                    uk1 uk1Var = qt0Var.i;
                    if (method == null) {
                        qt0Var.j = uk1Var.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    qt0Var.j.invoke(uk1Var, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
        String str3 = this.x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, tk1.e, tk1Var.a));
            z = true;
        }
        int i2 = this.w;
        if (i2 > 0 && !z) {
            menuItem.setActionView(i2);
        }
        m1 m1Var = this.z;
        if (m1Var != null && (menuItem instanceof uk1)) {
            ((uk1) menuItem).b(m1Var);
        }
        CharSequence charSequence = this.A;
        boolean z2 = menuItem instanceof uk1;
        if (z2) {
            ((uk1) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            ao.g(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.B;
        if (z2) {
            ((uk1) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            ao.o(menuItem, charSequence2);
        }
        char c = this.n;
        int i3 = this.o;
        if (z2) {
            ((uk1) menuItem).setAlphabeticShortcut(c, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            ao.e(menuItem, c, i3);
        }
        char c2 = this.p;
        int i4 = this.q;
        if (z2) {
            ((uk1) menuItem).setNumericShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            ao.k(menuItem, c2, i4);
        }
        PorterDuff.Mode mode = this.D;
        if (mode != null) {
            if (z2) {
                ((uk1) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                ao.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.C;
        if (colorStateList != null) {
            if (z2) {
                ((uk1) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                ao.i(menuItem, colorStateList);
            }
        }
    }
}
