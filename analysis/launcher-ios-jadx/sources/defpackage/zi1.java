package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zi1 extends View {
    public ArrayList g;

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        qg0.l(canvas, "canvas");
        super.onDraw(canvas);
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            yi1 yi1Var = (yi1) obj;
            int height = getHeight();
            int width = getWidth();
            yi1Var.getClass();
            if (yi1Var.d) {
                int i2 = yi1Var.c - yi1Var.i;
                yi1Var.c = i2;
                if (i2 <= 60) {
                    yi1Var.d = false;
                    yi1Var.c = 60;
                }
            } else {
                int i3 = yi1Var.c + yi1Var.i;
                yi1Var.c = i3;
                if (i3 >= 255) {
                    yi1Var.d = true;
                    yi1Var.c = 255;
                }
            }
            Paint paint = yi1.k;
            qg0.h(paint);
            paint.setAlpha(yi1Var.c);
            Paint paint2 = yi1.j;
            qg0.h(paint2);
            paint2.setAlpha(yi1Var.c);
            float f = yi1Var.a - yi1Var.f;
            yi1Var.a = f;
            float f2 = yi1Var.b;
            float f3 = yi1Var.e;
            float f4 = 2;
            float f5 = f3 * f4;
            if (f2 > height + f5 || f < (-f3) * f4 || f > f5 + width) {
                yi1Var.a = width;
                yi1Var.b = b21.f(f3, height);
            }
            RadialGradient radialGradient = new RadialGradient(yi1Var.a, yi1Var.b, yi1Var.e, new int[]{yi1Var.g, yi1Var.h, 0}, new float[]{0.0f, 0.3f, 1.0f}, Shader.TileMode.MIRROR);
            Paint paint3 = yi1.k;
            qg0.h(paint3);
            paint3.setShader(radialGradient);
            float f6 = yi1Var.a;
            float f7 = yi1Var.b;
            float f8 = yi1Var.e;
            Paint paint4 = yi1.k;
            qg0.h(paint4);
            canvas.drawCircle(f6, f7, f8, paint4);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((yi1) obj).a(getHeight(), getWidth());
        }
    }
}
