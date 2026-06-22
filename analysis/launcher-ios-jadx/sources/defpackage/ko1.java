package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class ko1 extends go {
    public lo1 g;
    public /* synthetic */ Object h;
    public final /* synthetic */ lo1 i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko1(lo1 lo1Var, eo eoVar) {
        super(eoVar);
        this.i = lo1Var;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= RtlSpacingHelper.UNDEFINED;
        return lo1.c(this.i, null, this);
    }
}
