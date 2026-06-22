package defpackage;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class k72 extends z82 {
    public final /* synthetic */ int k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ Bundle n;
    public final /* synthetic */ r92 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k72(r92 r92Var, String str, String str2, Bundle bundle, int i) {
        super(r92Var, true);
        this.k = i;
        this.o = r92Var;
        this.l = str;
        this.m = str2;
        this.n = bundle;
    }

    @Override // defpackage.z82
    public final void a() {
        switch (this.k) {
            case 0:
                v62 v62Var = this.o.h;
                hg0.i(v62Var);
                String str = this.l;
                String str2 = this.m;
                Bundle bundle = this.n;
                q62 q62Var = (q62) v62Var;
                Parcel parcelF = q62Var.f();
                parcelF.writeString(str);
                parcelF.writeString(str2);
                m52.a(parcelF, bundle);
                q62Var.p(9, parcelF);
                break;
            default:
                long j = this.g;
                v62 v62Var2 = this.o.h;
                hg0.i(v62Var2);
                String str3 = this.l;
                String str4 = this.m;
                Bundle bundle2 = this.n;
                q62 q62Var2 = (q62) v62Var2;
                Parcel parcelF2 = q62Var2.f();
                parcelF2.writeString(str3);
                parcelF2.writeString(str4);
                m52.a(parcelF2, bundle2);
                parcelF2.writeInt(1);
                parcelF2.writeInt(1);
                parcelF2.writeLong(j);
                q62Var2.p(2, parcelF2);
                break;
        }
    }
}
