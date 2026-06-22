package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zf1 extends fg1 {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Matrix c;

    public zf1(ArrayList arrayList, Matrix matrix) {
        this.b = arrayList;
        this.c = matrix;
    }

    @Override // defpackage.fg1
    public final void a(Matrix matrix, uf1 uf1Var, int i, Canvas canvas) {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((fg1) obj).a(this.c, uf1Var, i, canvas);
        }
    }
}
