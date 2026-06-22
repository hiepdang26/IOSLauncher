package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class tf extends go {
    public v31 g;
    public /* synthetic */ Object h;
    public final /* synthetic */ uf i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tf(uf ufVar, go goVar) {
        super(goVar);
        this.i = ufVar;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= RtlSpacingHelper.UNDEFINED;
        return this.i.b(null, this);
    }
}
