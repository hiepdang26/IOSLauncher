package defpackage;

import android.app.Activity;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class d92 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ Activity l;
    public final /* synthetic */ q92 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d92(q92 q92Var, Activity activity, int i) {
        super(q92Var.g, true);
        this.k = i;
        switch (i) {
            case 1:
                this.m = q92Var;
                this.l = activity;
                super(q92Var.g, true);
                break;
            case 2:
                this.m = q92Var;
                this.l = activity;
                super(q92Var.g, true);
                break;
            case 3:
                this.m = q92Var;
                this.l = activity;
                super(q92Var.g, true);
                break;
            case 4:
                this.m = q92Var;
                this.l = activity;
                super(q92Var.g, true);
                break;
            default:
                this.m = q92Var;
                this.l = activity;
                break;
        }
    }

    @Override // defpackage.z82
    public final void a() {
        switch (this.k) {
            case 0:
                v62 v62Var = this.m.g.h;
                hg0.i(v62Var);
                gy0 gy0Var = new gy0(this.l);
                long j = this.h;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                m52.b(parcelF, gy0Var);
                parcelF.writeLong(j);
                q62Var.p(25, parcelF);
                break;
            case 1:
                v62 v62Var2 = this.m.g.h;
                hg0.i(v62Var2);
                gy0 gy0Var2 = new gy0(this.l);
                long j2 = this.h;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                m52.b(parcelF2, gy0Var2);
                parcelF2.writeLong(j2);
                q62Var2.p(30, parcelF2);
                break;
            case 2:
                v62 v62Var3 = this.m.g.h;
                hg0.i(v62Var3);
                gy0 gy0Var3 = new gy0(this.l);
                long j3 = this.h;
                q62 q62Var3 = (q62) v62Var3;
                Parcel parcelF3 = q62Var3.f();
                m52.b(parcelF3, gy0Var3);
                parcelF3.writeLong(j3);
                q62Var3.p(29, parcelF3);
                break;
            case 3:
                v62 v62Var4 = this.m.g.h;
                hg0.i(v62Var4);
                gy0 gy0Var4 = new gy0(this.l);
                long j4 = this.h;
                q62 q62Var4 = (q62) v62Var4;
                Parcel parcelF4 = q62Var4.f();
                m52.b(parcelF4, gy0Var4);
                parcelF4.writeLong(j4);
                q62Var4.p(26, parcelF4);
                break;
            default:
                v62 v62Var5 = this.m.g.h;
                hg0.i(v62Var5);
                gy0 gy0Var5 = new gy0(this.l);
                long j5 = this.h;
                q62 q62Var5 = (q62) v62Var5;
                Parcel parcelF5 = q62Var5.f();
                m52.b(parcelF5, gy0Var5);
                parcelF5.writeLong(j5);
                q62Var5.p(28, parcelF5);
                break;
        }
    }
}
