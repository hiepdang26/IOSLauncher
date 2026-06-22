package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class qi1 {
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int[] f;
    public final /* synthetic */ StaggeredGridLayoutManager g;

    public qi1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.a = -1;
        this.b = RtlSpacingHelper.UNDEFINED;
        this.c = false;
        this.d = false;
        this.e = false;
        int[] iArr = this.f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
