package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class n82 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Object m;
    public final /* synthetic */ Object n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n82(r92 r92Var, Object obj, d62 d62Var, int i) {
        super(r92Var, true);
        this.k = i;
        this.m = r92Var;
        this.n = obj;
        this.l = d62Var;
    }

    @Override // defpackage.z82
    public final void a() {
        Bundle bundle;
        switch (this.k) {
            case 0:
                v62 v62Var = ((r92) this.m).h;
                hg0.i(v62Var);
                Bundle bundle2 = (Bundle) this.n;
                d62 d62Var = (d62) this.l;
                long j = this.g;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                m52.a(parcelF, bundle2);
                m52.b(parcelF, d62Var);
                parcelF.writeLong(j);
                q62Var.p(32, parcelF);
                break;
            case 1:
                v62 v62Var2 = ((r92) this.m).h;
                hg0.i(v62Var2);
                String str = (String) this.n;
                d62 d62Var2 = (d62) this.l;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                parcelF2.writeString(str);
                m52.b(parcelF2, d62Var2);
                q62Var2.p(6, parcelF2);
                break;
            case 2:
                if (((Bundle) this.n) != null) {
                    bundle = new Bundle();
                    if (((Bundle) this.n).containsKey("com.google.app_measurement.screen_service")) {
                        Object obj = ((Bundle) this.n).get("com.google.app_measurement.screen_service");
                        if (obj instanceof Bundle) {
                            bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                        }
                    }
                } else {
                    bundle = null;
                }
                v62 v62Var3 = ((q92) this.m).g.h;
                hg0.i(v62Var3);
                gy0 gy0Var = new gy0((Activity) this.l);
                long j2 = this.h;
                q62 q62Var3 = (q62) v62Var3;
                Parcel parcelF3 = q62Var3.f();
                m52.b(parcelF3, gy0Var);
                m52.a(parcelF3, bundle);
                parcelF3.writeLong(j2);
                q62Var3.p(27, parcelF3);
                break;
            default:
                v62 v62Var4 = ((q92) this.m).g.h;
                hg0.i(v62Var4);
                gy0 gy0Var2 = new gy0((Activity) this.n);
                d62 d62Var3 = (d62) this.l;
                long j3 = this.h;
                q62 q62Var4 = (q62) v62Var4;
                Parcel parcelF4 = q62Var4.f();
                m52.b(parcelF4, gy0Var2);
                m52.b(parcelF4, d62Var3);
                parcelF4.writeLong(j3);
                q62Var4.p(31, parcelF4);
                break;
        }
    }

    @Override // defpackage.z82
    public void b() {
        switch (this.k) {
            case 0:
                ((d62) this.l).r(null);
                break;
            case 1:
                ((d62) this.l).r(null);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n82(q92 q92Var, Activity activity, d62 d62Var) {
        super(q92Var.g, true);
        this.k = 3;
        this.m = q92Var;
        this.n = activity;
        this.l = d62Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n82(q92 q92Var, Bundle bundle, Activity activity) {
        super(q92Var.g, true);
        this.k = 2;
        this.m = q92Var;
        this.n = bundle;
        this.l = activity;
    }
}
