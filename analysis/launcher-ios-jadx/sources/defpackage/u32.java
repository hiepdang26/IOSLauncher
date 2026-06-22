package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbeb;

/* JADX INFO: loaded from: classes.dex */
public abstract class u32 {
    public static final x62 a;

    static {
        x62 w62Var = null;
        try {
            Object objNewInstance = s32.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    w62Var = iInterfaceQueryLocalInterface instanceof x62 ? (x62) iInterfaceQueryLocalInterface : new w62(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
                }
            } else {
                k92.h("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            k92.h("Failed to instantiate ClientApi class.");
        }
        a = w62Var;
    }

    public abstract Object a();

    public abstract Object b(x62 x62Var);

    public abstract Object c();

    public final Object d(Context context, boolean z) {
        boolean z2;
        Object objC;
        Object objB;
        if (!z) {
            ka2 ka2Var = x32.f.a;
            if (ea0.b.c(context, 12451000) != 0) {
                k92.d("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z3 = false;
        boolean z4 = !(dy.a(context, ModuleDescriptor.MODULE_ID) <= dy.d(context, ModuleDescriptor.MODULE_ID, false));
        zzbbw.zza(context);
        if (((Boolean) zzbdn.zza.zze()).booleanValue()) {
            z2 = false;
        } else if (((Boolean) zzbdn.zzb.zze()).booleanValue()) {
            z2 = true;
            z3 = true;
        } else {
            z3 = z | z4;
            z2 = false;
        }
        x62 x62Var = a;
        Object objB2 = null;
        if (z3) {
            if (x62Var != null) {
                try {
                    objB = b(x62Var);
                } catch (RemoteException unused) {
                    k92.j(5);
                    objB = null;
                }
                if (objB == null && !z2) {
                    try {
                        objB2 = c();
                    } catch (RemoteException unused2) {
                        k92.j(5);
                    }
                    objB = objB2;
                }
            } else {
                k92.h("ClientApi class cannot be loaded.");
            }
            objB = null;
            if (objB == null) {
                objB2 = c();
                objB = objB2;
            }
        } else {
            try {
                objC = c();
            } catch (RemoteException unused3) {
                k92.j(5);
                objC = null;
            }
            if (objC == null) {
                int iIntValue = ((Long) zzbeb.zza.zze()).intValue();
                x32 x32Var = x32.f;
                if (x32Var.e.nextInt(iIntValue) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    String str = x32Var.d.g;
                    ka2 ka2Var2 = x32Var.a;
                    ka2Var2.getClass();
                    ka2.m(context, str, bundle, new ta1(ka2Var2));
                }
            }
            if (objC == null) {
                if (x62Var != null) {
                    try {
                        objB2 = b(x62Var);
                    } catch (RemoteException unused4) {
                        k92.j(5);
                    }
                } else {
                    k92.h("ClientApi class cannot be loaded.");
                }
                objB = objB2;
            } else {
                objB = objC;
            }
        }
        return objB == null ? a() : objB;
    }
}
