package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class fw extends go {
    public /* synthetic */ Object g;
    public final /* synthetic */ wb2 h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw(wb2 wb2Var, go goVar) {
        super(goVar);
        this.h = wb2Var;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= RtlSpacingHelper.UNDEFINED;
        return this.h.b(null, this);
    }
}
