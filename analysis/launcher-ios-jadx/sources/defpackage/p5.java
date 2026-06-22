package defpackage;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
public final class p5 implements TypeEvaluator {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ p5(int i) {
        this.a = i;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                t11[] t11VarArr = (t11[]) obj;
                t11[] t11VarArr2 = (t11[]) obj2;
                if (!p02.b(t11VarArr, t11VarArr2)) {
                    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
                }
                if (!p02.b((t11[]) this.b, t11VarArr)) {
                    this.b = p02.j(t11VarArr);
                }
                for (int i = 0; i < t11VarArr.length; i++) {
                    t11 t11Var = ((t11[]) this.b)[i];
                    t11 t11Var2 = t11VarArr[i];
                    t11 t11Var3 = t11VarArr2[i];
                    t11Var.getClass();
                    t11Var.a = t11Var2.a;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = t11Var2.b;
                        if (i2 < fArr.length) {
                            t11Var.b[i2] = (t11Var3.b[i2] * f) + ((1.0f - f) * fArr[i2]);
                            i2++;
                        }
                    }
                }
                return (t11[]) this.b;
            default:
                float fFloatValue = ((FloatEvaluator) this.b).evaluate(f, (Number) obj, (Number) obj2).floatValue();
                if (fFloatValue < 0.1f) {
                    fFloatValue = 0.0f;
                }
                return Float.valueOf(fFloatValue);
        }
    }
}
