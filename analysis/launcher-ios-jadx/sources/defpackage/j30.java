package defpackage;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public final class j30 implements TypeEvaluator {
    public final float[] a = new float[9];
    public final float[] b = new float[9];
    public final Matrix c = new Matrix();
    public final /* synthetic */ o30 d;

    public j30(o30 o30Var) {
        this.d = o30Var;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        this.d.p = f;
        float[] fArr = this.a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i = 0; i < 9; i++) {
            float f2 = fArr2[i];
            float f3 = fArr[i];
            fArr2[i] = uo.s(f2, f3, f, f3);
        }
        Matrix matrix = this.c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
