package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class l82 extends z82 {
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ d62 n;
    public final /* synthetic */ r92 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l82(r92 r92Var, String str, String str2, boolean z, d62 d62Var) {
        super(r92Var, true);
        this.o = r92Var;
        this.k = str;
        this.l = str2;
        this.m = z;
        this.n = d62Var;
    }

    @Override // defpackage.z82
    public final void a() {
        v62 v62Var = this.o.h;
        hg0.i(v62Var);
        String str = this.k;
        String str2 = this.l;
        boolean z = this.m;
        d62 d62Var = this.n;
        q62 q62Var = (q62) v62Var;
        Parcel parcelF = q62Var.f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        int i = m52.a;
        parcelF.writeInt(z ? 1 : 0);
        m52.b(parcelF, d62Var);
        q62Var.p(5, parcelF);
    }

    @Override // defpackage.z82
    public final void b() {
        this.n.r(null);
    }
}
