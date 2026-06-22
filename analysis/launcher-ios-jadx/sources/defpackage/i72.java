package defpackage;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class i72 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ r92 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i72(r92 r92Var, Bundle bundle, int i) {
        super(r92Var, true);
        this.k = i;
        this.m = r92Var;
        this.l = bundle;
    }

    @Override // defpackage.z82
    public final void a() {
        switch (this.k) {
            case 0:
                v62 v62Var = this.m.h;
                hg0.i(v62Var);
                Bundle bundle = (Bundle) this.l;
                long j = this.g;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                m52.a(parcelF, bundle);
                parcelF.writeLong(j);
                q62Var.p(8, parcelF);
                break;
            case 1:
                v62 v62Var2 = this.m.h;
                hg0.i(v62Var2);
                Bundle bundle2 = (Bundle) this.l;
                long j2 = this.g;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                m52.a(parcelF2, bundle2);
                parcelF2.writeLong(j2);
                q62Var2.p(44, parcelF2);
                break;
            default:
                v62 v62Var3 = this.m.h;
                hg0.i(v62Var3);
                gy0 gy0Var = new gy0((Exception) this.l);
                gy0 gy0Var2 = new gy0(null);
                gy0 gy0Var3 = new gy0(null);
                q62 q62Var3 = (q62) v62Var3;
                Parcel parcelF3 = q62Var3.f();
                parcelF3.writeInt(5);
                parcelF3.writeString("Error with data collection. Data lost.");
                m52.b(parcelF3, gy0Var);
                m52.b(parcelF3, gy0Var2);
                m52.b(parcelF3, gy0Var3);
                q62Var3.p(33, parcelF3);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i72(r92 r92Var, Exception exc) {
        super(r92Var, false);
        this.k = 2;
        this.m = r92Var;
        this.l = exc;
    }
}
