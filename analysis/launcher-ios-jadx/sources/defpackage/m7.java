package defpackage;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.luutinhit.launcher6.t;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class m7 {
    public static final Object c = new Object();
    public static m7 d;
    public final AppWidgetManager a;
    public final Context b;

    public m7(Context context) {
        this.b = context;
        this.a = AppWidgetManager.getInstance(context);
    }

    public static m7 f(Context context) {
        m7 m7Var;
        synchronized (c) {
            try {
                if (d == null) {
                    if (ar1.m) {
                        d = new p7(context.getApplicationContext());
                    } else {
                        d = new n7(context.getApplicationContext());
                    }
                }
                m7Var = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return m7Var;
    }

    public abstract boolean a(int i, AppWidgetProviderInfo appWidgetProviderInfo, Bundle bundle);

    public abstract rk0 b(ComponentName componentName, jq1 jq1Var);

    public abstract List c();

    public abstract HashMap d();

    public abstract Bitmap e(rk0 rk0Var, Bitmap bitmap, int i, int i2);

    public final rk0 g(int i) {
        AppWidgetProviderInfo appWidgetInfo = this.a.getAppWidgetInfo(i);
        if (appWidgetInfo == null) {
            return null;
        }
        return rk0.a(appWidgetInfo);
    }

    public abstract jq1 h(rk0 rk0Var);

    public abstract Drawable i(rk0 rk0Var, oe0 oe0Var);

    public abstract String j(rk0 rk0Var);

    public abstract Drawable k(rk0 rk0Var);

    public abstract void l(rk0 rk0Var, int i, t tVar, AppWidgetHost appWidgetHost, int i2);
}
