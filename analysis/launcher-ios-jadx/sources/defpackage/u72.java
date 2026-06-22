package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class u72 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ String l;
    public final /* synthetic */ r92 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u72(r92 r92Var, String str, int i) {
        super(r92Var, true);
        this.k = i;
        this.m = r92Var;
        this.l = str;
    }

    @Override // defpackage.z82
    public final void a() {
        switch (this.k) {
            case 0:
                v62 v62Var = this.m.h;
                hg0.i(v62Var);
                String str = this.l;
                long j = this.h;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                parcelF.writeString(str);
                parcelF.writeLong(j);
                q62Var.p(23, parcelF);
                break;
            default:
                v62 v62Var2 = this.m.h;
                hg0.i(v62Var2);
                String str2 = this.l;
                long j2 = this.h;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                parcelF2.writeString(str2);
                parcelF2.writeLong(j2);
                q62Var2.p(24, parcelF2);
                break;
        }
    }
}
