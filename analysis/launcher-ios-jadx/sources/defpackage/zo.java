package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class zo extends jj0 implements s70 {
    public static final zo h = new zo(2, 0);
    public static final zo i = new zo(2, 1);
    public static final zo j = new zo(2, 2);
    public static final zo k = new zo(2, 3);
    public static final zo l = new zo(2, 4);
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zo(int i2, int i3) {
        super(i2);
        this.g = i3;
    }

    @Override // defpackage.s70
    public final Object d(Object obj, Object obj2) {
        switch (this.g) {
            case 0:
                return ((yo) obj).k((wo) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 2:
                wo woVar = (wo) obj2;
                if (!(woVar instanceof nn1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? woVar : Integer.valueOf(iIntValue + 1);
            case 3:
                nn1 nn1Var = (nn1) obj;
                wo woVar2 = (wo) obj2;
                if (nn1Var != null) {
                    return nn1Var;
                }
                if (woVar2 instanceof nn1) {
                    return (nn1) woVar2;
                }
                return null;
            case 4:
                return (qn1) obj;
            default:
                return ((yo) obj).k((wo) obj2);
        }
    }
}
