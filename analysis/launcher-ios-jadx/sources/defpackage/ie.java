package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class ie extends go {
    public /* synthetic */ Object g;
    public final /* synthetic */ je h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie(je jeVar, go goVar) {
        super(goVar);
        this.h = jeVar;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= RtlSpacingHelper.UNDEFINED;
        Object objZ = this.h.z(null, 0, 0L, this);
        return objZ == hp.g ? objZ : new uh(objZ);
    }
}
