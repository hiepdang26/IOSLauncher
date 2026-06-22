package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class m72 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ String l;
    public final /* synthetic */ Object m;
    public final /* synthetic */ r92 n;
    public final /* synthetic */ Object o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m72(r92 r92Var, String str, Object obj, Object obj2, int i) {
        super(r92Var, true);
        this.k = i;
        this.n = r92Var;
        this.l = str;
        this.m = obj;
        this.o = obj2;
    }

    @Override // defpackage.z82
    public final void a() {
        boolean z;
        String str;
        String str2;
        String str3;
        switch (this.k) {
            case 0:
                v62 v62Var = this.n.h;
                hg0.i(v62Var);
                String str4 = this.l;
                String str5 = (String) this.m;
                d62 d62Var = (d62) this.o;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                parcelF.writeString(str4);
                parcelF.writeString(str5);
                m52.b(parcelF, d62Var);
                q62Var.p(10, parcelF);
                break;
            case 1:
                v62 v62Var2 = this.n.h;
                hg0.i(v62Var2);
                gy0 gy0Var = new gy0((Activity) this.o);
                String str6 = this.l;
                String str7 = (String) this.m;
                long j = this.g;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                m52.b(parcelF2, gy0Var);
                parcelF2.writeString(str6);
                parcelF2.writeString(str7);
                parcelF2.writeLong(j);
                q62Var2.p(15, parcelF2);
                break;
            case 2:
                try {
                    if (this.l != null) {
                        try {
                            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                            z = false;
                        } catch (ClassNotFoundException unused) {
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    v62 q62Var3 = null;
                    if (z) {
                        str3 = this.l;
                        str2 = "am";
                        str = this.n.a;
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    hg0.i((Context) this.m);
                    r92 r92Var = this.n;
                    Context context = (Context) this.m;
                    r92Var.getClass();
                    try {
                        IBinder iBinderB = dy.c(context, dy.c, "com.google.android.gms.measurement.dynamite").b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService");
                        int i = t62.h;
                        if (iBinderB != null) {
                            IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
                            q62Var3 = iInterfaceQueryLocalInterface instanceof v62 ? (v62) iInterfaceQueryLocalInterface : new q62(iBinderB);
                        }
                    } catch (yx e) {
                        r92Var.a(e, true, false);
                    }
                    r92Var.h = q62Var3;
                    if (this.n.h != null) {
                        int iA = dy.a((Context) this.m, "com.google.android.gms.measurement.dynamite");
                        f72 f72Var = new f72(61000L, Math.max(iA, r2), dy.d((Context) this.m, "com.google.android.gms.measurement.dynamite", false) < iA, str, str2, str3, (Bundle) this.o, az1.M((Context) this.m));
                        v62 v62Var3 = this.n.h;
                        hg0.i(v62Var3);
                        gy0 gy0Var2 = new gy0((Context) this.m);
                        long j2 = this.g;
                        q62 q62Var4 = (q62) v62Var3;
                        Parcel parcelF3 = q62Var4.f();
                        m52.b(parcelF3, gy0Var2);
                        m52.a(parcelF3, f72Var);
                        parcelF3.writeLong(j2);
                        q62Var4.p(1, parcelF3);
                    } else {
                        String str8 = this.n.a;
                    }
                } catch (Exception e2) {
                    this.n.a(e2, true, false);
                    return;
                }
                break;
            default:
                v62 v62Var4 = this.n.h;
                hg0.i(v62Var4);
                String str9 = this.l;
                String str10 = (String) this.m;
                gy0 gy0Var3 = new gy0(this.o);
                long j3 = this.g;
                q62 q62Var5 = (q62) v62Var4;
                Parcel parcelF4 = q62Var5.f();
                parcelF4.writeString(str9);
                parcelF4.writeString(str10);
                m52.b(parcelF4, gy0Var3);
                parcelF4.writeInt(1);
                parcelF4.writeLong(j3);
                q62Var5.p(4, parcelF4);
                break;
        }
    }

    @Override // defpackage.z82
    public void b() {
        switch (this.k) {
            case 0:
                ((d62) this.o).r(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m72(r92 r92Var, Activity activity, String str, String str2) {
        super(r92Var, true);
        this.k = 1;
        this.n = r92Var;
        this.o = activity;
        this.l = str;
        this.m = str2;
    }
}
