package defpackage;

import android.view.View;
import com.luutinhit.weather.WeatherActivity;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class ci1 extends View {
    public ArrayList g;
    public int h;
    public final Random i;

    public ci1(WeatherActivity weatherActivity) {
        super(weatherActivity);
        this.g = new ArrayList();
        this.h = 100;
        this.i = new Random();
        a();
    }

    public final void a() {
        this.g = new ArrayList();
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            this.g.add(new bi1(getHeight(), getWidth(), this.i.nextFloat()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0072  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r12) {
        /*
            r11 = this;
            java.lang.String r0 = "canvas"
            defpackage.qg0.l(r12, r0)
            super.onDraw(r12)
            java.util.ArrayList r0 = r11.g
            int r1 = r0.size()
            r2 = 0
        Lf:
            if (r2 >= r1) goto Lad
            java.lang.Object r3 = r0.get(r2)
            int r2 = r2 + 1
            bi1 r3 = (defpackage.bi1) r3
            int r4 = r11.getHeight()
            int r5 = r11.getWidth()
            r3.getClass()
            float r6 = r3.c
            float r7 = r3.f
            double r7 = (double) r7
            float r9 = r3.g
            double r9 = (double) r9
            double r9 = java.lang.Math.cos(r9)
            double r9 = r9 * r7
            float r7 = (float) r9
            float r6 = r6 + r7
            r3.c = r6
            float r6 = r3.d
            float r7 = r3.f
            double r7 = (double) r7
            r9 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r7 = r7 * r9
            float r9 = r3.g
            double r9 = (double) r9
            double r9 = java.lang.Math.sin(r9)
            double r9 = java.lang.Math.abs(r9)
            double r9 = r9 * r7
            float r7 = (float) r9
            float r6 = r6 + r7
            r3.d = r6
            float r7 = r3.g
            float r8 = r3.b
            float r7 = r7 + r8
            r3.g = r7
            float r4 = (float) r4
            float r7 = r3.e
            r8 = 2
            float r8 = (float) r8
            float r9 = r7 * r8
            float r4 = r4 + r9
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 > 0) goto L72
            float r4 = r3.c
            float r6 = -r7
            float r6 = r6 * r8
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 < 0) goto L72
            float r6 = (float) r5
            float r9 = r9 + r6
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 <= 0) goto L95
        L72:
            double r6 = java.lang.Math.random()
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r6 * r9
            r9 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r6 = r6 * r9
            float r4 = (float) r6
            r3.g = r4
            float r4 = (float) r5
            double r5 = java.lang.Math.random()
            float r5 = (float) r5
            float r4 = r4 * r5
            r3.c = r4
            float r4 = r3.e
            float r4 = -r4
            float r4 = r4 * r8
            r3.d = r4
        L95:
            android.graphics.Paint r4 = defpackage.bi1.h
            defpackage.qg0.h(r4)
            r4.getAlpha()
            float r4 = r3.c
            float r5 = r3.d
            float r3 = r3.e
            android.graphics.Paint r6 = defpackage.bi1.h
            defpackage.qg0.h(r6)
            r12.drawCircle(r4, r5, r3, r6)
            goto Lf
        Lad:
            r11.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ci1.onDraw(android.graphics.Canvas):void");
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
            ((bi1) obj).a(getHeight(), getWidth());
        }
    }

    public final void setSnowCount(int i) {
        this.h = i;
        a();
    }
}
