package defpackage;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class jv0 extends fb {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jv0(fb fbVar) {
        super(1);
        qg0.l(fbVar, "initialExtras");
        ((LinkedHashMap) this.g).putAll((LinkedHashMap) fbVar.g);
    }
}
