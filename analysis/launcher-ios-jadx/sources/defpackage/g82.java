package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class g82 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ d62 l;
    public final /* synthetic */ r92 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g82(r92 r92Var, d62 d62Var, int i) {
        super(r92Var, true);
        this.k = i;
        this.m = r92Var;
        this.l = d62Var;
    }

    @Override // defpackage.z82
    public final void a() {
        switch (this.k) {
            case 0:
                v62 v62Var = this.m.h;
                hg0.i(v62Var);
                d62 d62Var = this.l;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                m52.b(parcelF, d62Var);
                q62Var.p(21, parcelF);
                break;
            case 1:
                v62 v62Var2 = this.m.h;
                hg0.i(v62Var2);
                d62 d62Var2 = this.l;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                m52.b(parcelF2, d62Var2);
                q62Var2.p(19, parcelF2);
                break;
            case 2:
                v62 v62Var3 = this.m.h;
                hg0.i(v62Var3);
                d62 d62Var3 = this.l;
                q62 q62Var3 = (q62) v62Var3;
                Parcel parcelF3 = q62Var3.f();
                m52.b(parcelF3, d62Var3);
                q62Var3.p(22, parcelF3);
                break;
            case 3:
                v62 v62Var4 = this.m.h;
                hg0.i(v62Var4);
                d62 d62Var4 = this.l;
                q62 q62Var4 = (q62) v62Var4;
                Parcel parcelF4 = q62Var4.f();
                m52.b(parcelF4, d62Var4);
                q62Var4.p(16, parcelF4);
                break;
            default:
                v62 v62Var5 = this.m.h;
                hg0.i(v62Var5);
                d62 d62Var5 = this.l;
                q62 q62Var5 = (q62) v62Var5;
                Parcel parcelF5 = q62Var5.f();
                m52.b(parcelF5, d62Var5);
                q62Var5.p(17, parcelF5);
                break;
        }
    }

    @Override // defpackage.z82
    public final void b() {
        switch (this.k) {
            case 0:
                this.l.r(null);
                break;
            case 1:
                this.l.r(null);
                break;
            case 2:
                this.l.r(null);
                break;
            case 3:
                this.l.r(null);
                break;
            default:
                this.l.r(null);
                break;
        }
    }
}
