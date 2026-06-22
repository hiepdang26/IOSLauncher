package defpackage;

import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfk;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class j32 implements zzhfc {
    public final /* synthetic */ int a;
    public final g32 b;

    public /* synthetic */ j32(g32 g32Var, int i) {
        this.a = i;
        this.b = g32Var;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        switch (this.a) {
            case 0:
                String lowerCase = this.b.a.toLowerCase(Locale.ROOT);
                zzhfk.zzb(lowerCase);
                return lowerCase;
            default:
                g32 g32Var = this.b;
                g32Var.getClass();
                HashSet hashSet = new HashSet();
                hashSet.add(g32Var.a.toLowerCase(Locale.ROOT));
                return hashSet;
        }
    }
}
