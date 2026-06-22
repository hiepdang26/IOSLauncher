package defpackage;

import com.google.android.gms.internal.ads.zzaqm;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e52 extends zzaqm {
    public final /* synthetic */ byte[] g;
    public final /* synthetic */ HashMap h;
    public final /* synthetic */ ub2 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e52(int i, String str, g52 g52Var, b52 b52Var, byte[] bArr, HashMap map, ub2 ub2Var) {
        super(i, str, g52Var, b52Var);
        this.g = bArr;
        this.h = map;
        this.i = ub2Var;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final Map zzl() {
        HashMap map = this.h;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final byte[] zzx() {
        byte[] bArr = this.g;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaqm, com.google.android.gms.internal.ads.zzaph
    /* JADX INFO: renamed from: zzz */
    public final void zzo(String str) {
        ub2 ub2Var = this.i;
        if (ub2.c() && str != null) {
            ub2Var.d("onNetworkResponseBody", new xz1(str.getBytes()));
        }
        super.zzo(str);
    }
}
