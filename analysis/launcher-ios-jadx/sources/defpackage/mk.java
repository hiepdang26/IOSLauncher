package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mk implements s70 {
    public final /* synthetic */ int g;

    public /* synthetic */ mk(int i) {
        this.g = i;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        nk nkVar;
        switch (this.g) {
            case 0:
                String str = (String) obj;
                wo woVar = (wo) obj2;
                qg0.l(str, "acc");
                qg0.l(woVar, "element");
                if (str.length() == 0) {
                    return woVar.toString();
                }
                return str + ", " + woVar;
            default:
                yo yoVar = (yo) obj;
                wo woVar2 = (wo) obj2;
                qg0.l(yoVar, "acc");
                qg0.l(woVar2, "element");
                yo yoVarR = yoVar.r(woVar2.getKey());
                sz szVar = sz.g;
                if (yoVarR == szVar) {
                    return woVar2;
                }
                iy iyVar = iy.g;
                ho hoVar = (ho) yoVarR.n(iyVar);
                if (hoVar == null) {
                    nkVar = new nk(woVar2, yoVarR);
                } else {
                    yo yoVarR2 = yoVarR.r(iyVar);
                    if (yoVarR2 == szVar) {
                        return new nk(hoVar, woVar2);
                    }
                    nkVar = new nk(hoVar, new nk(woVar2, yoVarR2));
                }
                return nkVar;
        }
    }
}
