package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c50 implements yy {
    public final Context a;
    public final b50 b;
    public final ka0 c;
    public final Object d;
    public Handler e;
    public ThreadPoolExecutor f;
    public ThreadPoolExecutor g;
    public os h;

    public c50(Context context, b50 b50Var) {
        ka0 ka0Var = d50.d;
        this.d = new Object();
        qg0.j(context, "Context cannot be null");
        this.a = context.getApplicationContext();
        this.b = b50Var;
        this.c = ka0Var;
    }

    @Override // defpackage.yy
    public final void a(os osVar) {
        synchronized (this.d) {
            this.h = osVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.d) {
            try {
                this.h = null;
                Handler handler = this.e;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.e = null;
                ThreadPoolExecutor threadPoolExecutor = this.g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f = null;
                this.g = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.d) {
            try {
                if (this.h == null) {
                    return;
                }
                if (this.f == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ll("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.g = threadPoolExecutor;
                    this.f = threadPoolExecutor;
                }
                this.f.execute(new r1(this, 15));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final m50 d() {
        try {
            ka0 ka0Var = this.c;
            Context context = this.a;
            b50 b50Var = this.b;
            ka0Var.getClass();
            Object[] objArr = {b50Var};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            t3 t3VarA = a50.a(context, Collections.unmodifiableList(arrayList));
            int i = t3VarA.g;
            if (i != 0) {
                throw new RuntimeException(uo.d(i, "fetchFonts failed (", ")"));
            }
            m50[] m50VarArr = (m50[]) ((List) t3VarA.h).get(0);
            if (m50VarArr == null || m50VarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return m50VarArr[0];
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }
}
