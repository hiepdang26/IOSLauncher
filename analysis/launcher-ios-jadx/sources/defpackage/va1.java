package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bumptech.glide.manager.a;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class va1 implements Handler.Callback {
    public static final ta1 l = new ta1(0);
    public volatile sa1 g;
    public final ua1 h;
    public final e9 i = new e9(0);
    public final p60 j;
    public final a k;

    public va1(ua1 ua1Var) {
        ua1Var = ua1Var == null ? l : ua1Var;
        this.h = ua1Var;
        this.k = new a(ua1Var);
        this.j = (gb0.f && gb0.e) ? new d30() : new jl1(14);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void b(List list, e9 e9Var) {
        View view;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w50 w50Var = (w50) it.next();
            if (w50Var != null && (view = w50Var.L) != null) {
                e9Var.put(view, w50Var);
                b(w50Var.o().c.t(), e9Var);
            }
        }
    }

    public final sa1 c(e6 e6Var) {
        char[] cArr = vq1.a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return d(e6Var.getApplicationContext());
        }
        if (e6Var.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
        this.j.q(e6Var);
        Activity activityA = a(e6Var);
        return this.k.a(e6Var, com.bumptech.glide.a.a(e6Var.getApplicationContext()), e6Var.j, e6Var.o(), activityA == null || !activityA.isFinishing());
    }

    public final sa1 d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = vq1.a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof e6) {
                return c((e6) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return d(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.g == null) {
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.g = this.h.e(com.bumptech.glide.a.a(context.getApplicationContext()), new ka0(8), new jl1(16), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.g;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return false;
    }
}
