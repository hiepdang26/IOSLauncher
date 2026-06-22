package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class he extends go {
    public /* synthetic */ Object g;
    public final /* synthetic */ je h;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public he(je jeVar, go goVar) {
        super(goVar);
        this.h = jeVar;
    }

    @Override // defpackage.za
    public final Object invokeSuspend(Object obj) {
        this.g = obj;
        this.i |= RtlSpacingHelper.UNDEFINED;
        Object objY = je.y(this.h, this);
        return objY == hp.g ? objY : new uh(objY);
    }
}
