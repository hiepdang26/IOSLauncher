package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Trace;
import defpackage.z71;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = new Object();
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered = new HashSet();
    final Map<Class<?>, Object> mInitialized = new HashMap();

    public AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static AppInitializer getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new AppInitializer(context);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public static void setDelegate(AppInitializer appInitializer) {
        synchronized (sLock) {
            sInstance = appInitializer;
        }
    }

    public void discoverAndInitialize() {
        try {
            try {
                z71.c(SECTION_NAME);
                discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e) {
                throw new StartupException(e);
            }
        } finally {
            Trace.endSection();
        }
    }

    public <T> T doInitialize(Class<? extends Initializer<?>> cls) {
        T t;
        synchronized (sLock) {
            try {
                t = (T) this.mInitialized.get(cls);
                if (t == null) {
                    t = (T) doInitialize(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> cls) {
        return (T) doInitialize(cls);
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> cls) {
        return this.mDiscovered.contains(cls);
    }

    private <T> T doInitialize(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        T t;
        if (z71.j()) {
            try {
                z71.c(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.mInitialized.containsKey(cls)) {
                set.add(cls);
                try {
                    Initializer<?> initializerNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class<? extends Initializer<?>>> listDependencies = initializerNewInstance.dependencies();
                    if (!listDependencies.isEmpty()) {
                        for (Class<? extends Initializer<?>> cls2 : listDependencies) {
                            if (!this.mInitialized.containsKey(cls2)) {
                                doInitialize(cls2, set);
                            }
                        }
                    }
                    t = (T) initializerNewInstance.create(this.mContext);
                    set.remove(cls);
                    this.mInitialized.put(cls, t);
                } catch (Throwable th2) {
                    throw new StartupException(th2);
                }
            } else {
                t = (T) this.mInitialized.get(cls);
            }
            Trace.endSection();
            return t;
        }
        throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
    }

    public void discoverAndInitialize(Bundle bundle) {
        String string = this.mContext.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.mDiscovered.add((Class<? extends Initializer<?>>) cls);
                        }
                    }
                }
                Iterator<Class<? extends Initializer<?>>> it = this.mDiscovered.iterator();
                while (it.hasNext()) {
                    doInitialize(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e) {
                throw new StartupException(e);
            }
        }
    }
}
