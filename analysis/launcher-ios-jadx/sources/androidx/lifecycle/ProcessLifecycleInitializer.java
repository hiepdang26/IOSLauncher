package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import defpackage.en0;
import defpackage.n31;
import defpackage.o31;
import defpackage.qg0;
import defpackage.um0;
import defpackage.vz;
import defpackage.ym0;
import defpackage.zm0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<en0> {
    @Override // androidx.startup.Initializer
    public final en0 create(Context context) {
        qg0.l(context, "context");
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        qg0.k(appInitializer, "getInstance(context)");
        if (!appInitializer.isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!zm0.a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            qg0.i(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new ym0());
        }
        o31 o31Var = o31.o;
        o31Var.getClass();
        o31Var.k = new Handler();
        o31Var.l.d(um0.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        qg0.i(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new n31(o31Var));
        return o31Var;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return vz.g;
    }
}
