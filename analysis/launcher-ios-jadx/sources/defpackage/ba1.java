package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public abstract class ba1 {
    private final String zza;
    private Object zzb;

    public ba1(String str) {
        this.zza = str;
    }

    public abstract Object getRemoteCreator(IBinder iBinder);

    public final Object getRemoteCreatorInstance(Context context) throws aa1 {
        Context contextCreatePackageContext;
        if (this.zzb == null) {
            hg0.i(context);
            int i = ja0.c;
            try {
                contextCreatePackageContext = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                contextCreatePackageContext = null;
            }
            if (contextCreatePackageContext == null) {
                throw new aa1("Could not get remote context.");
            }
            try {
                this.zzb = getRemoteCreator((IBinder) contextCreatePackageContext.getClassLoader().loadClass(this.zza).newInstance());
            } catch (ClassNotFoundException e) {
                throw new aa1("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new aa1("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new aa1("Could not instantiate creator.", e3);
            }
        }
        return this.zzb;
    }
}
