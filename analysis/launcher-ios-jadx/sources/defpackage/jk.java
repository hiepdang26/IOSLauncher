package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class jk extends go {
    public /* synthetic */ Object g;
    public final /* synthetic */ t3 h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jk(t3 t3Var, go goVar) {
        super(goVar);
        this.h = t3Var;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= RtlSpacingHelper.UNDEFINED;
        return this.h.b(null, this);
    }
}
