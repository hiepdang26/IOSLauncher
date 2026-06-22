package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.luutinhit.weather.WeatherActivity;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class u71 extends View {
    public final Paint g;
    public final Path h;
    public int i;
    public int j;
    public int k;
    public final Random l;
    public ArrayList m;
    public int n;
    public int o;
    public float p;
    public float q;
    public float r;
    public int s;
    public final boolean t;

    public u71(WeatherActivity weatherActivity) {
        super(weatherActivity, null);
        this.k = 60;
        this.l = new Random();
        this.m = new ArrayList();
        this.n = 38;
        this.o = 18;
        this.p = 40.0f;
        this.q = 20.0f;
        this.r = 3.0f;
        this.s = 80;
        this.t = true;
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(-1);
        Paint paint2 = this.g;
        if (paint2 == null) {
            qg0.O("mPaint");
            throw null;
        }
        paint2.setStyle(Paint.Style.FILL);
        this.h = new Path();
    }

    public final void a() {
        this.m = new ArrayList();
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList = this.m;
            Random random = this.l;
            int iNextInt = random.nextInt(this.i);
            int iNextInt2 = random.nextInt(this.j);
            int iNextInt3 = random.nextInt(this.n);
            float fNextFloat = random.nextFloat();
            t71 t71Var = new t71();
            t71Var.a = iNextInt;
            t71Var.b = iNextInt2;
            t71Var.c = iNextInt3;
            t71Var.d = fNextFloat;
            if (iNextInt3 <= 0) {
                t71Var.c = 1;
            }
            if (fNextFloat < 0.2f) {
                t71Var.d = 0.2f;
            } else if (fNextFloat > 1.0f) {
                t71Var.d = 1.0f;
            }
            arrayList.add(t71Var);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        qg0.l(canvas, "canvas");
        super.onDraw(canvas);
        if (this.i <= 0 || this.j <= 0) {
            return;
        }
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            if (((t71) this.m.get(i2)).a > this.i || ((t71) this.m.get(i2)).b > this.j) {
                ((t71) this.m.get(i2)).a = this.l.nextInt(this.i);
                ((t71) this.m.get(i2)).b = 0;
            }
            t71 t71Var = (t71) this.m.get(i2);
            t71Var.b = ((t71) this.m.get(i2)).c + this.o + t71Var.b;
            Path path = this.h;
            if (path == null) {
                qg0.O("mPath");
                throw null;
            }
            path.reset();
            float f = (this.p * ((t71) this.m.get(i2)).c) / this.n;
            float f2 = this.r;
            float f3 = this.q + f;
            Path path2 = this.h;
            if (path2 == null) {
                qg0.O("mPath");
                throw null;
            }
            path2.addCircle(f2, f3, f2, Path.Direction.CW);
            Path path3 = this.h;
            if (path3 == null) {
                qg0.O("mPath");
                throw null;
            }
            path3.moveTo(f2, 0.0f);
            double d = f2;
            double d2 = f3;
            double dSqrt = Math.sqrt(Math.pow(d, 2.0d) - (Math.pow(d, 4.0d) / Math.pow(d2, 2.0d))) + d;
            double dPow = d2 - (Math.pow(d, 2.0d) / d2);
            Path path4 = this.h;
            if (path4 == null) {
                qg0.O("mPath");
                throw null;
            }
            float f4 = (float) dPow;
            path4.lineTo((float) dSqrt, f4);
            Path path5 = this.h;
            if (path5 == null) {
                qg0.O("mPath");
                throw null;
            }
            path5.lineTo((float) (((double) (2 * f2)) - dSqrt), f4);
            Path path6 = this.h;
            if (path6 == null) {
                qg0.O("mPath");
                throw null;
            }
            path6.close();
            Path path7 = this.h;
            if (path7 == null) {
                qg0.O("mPath");
                throw null;
            }
            path7.offset(((t71) this.m.get(i2)).a, ((t71) this.m.get(i2)).b);
            if (this.t) {
                Paint paint = this.g;
                if (paint == null) {
                    qg0.O("mPaint");
                    throw null;
                }
                paint.setAlpha((int) (((t71) this.m.get(i2)).d * this.s));
            } else {
                Paint paint2 = this.g;
                if (paint2 == null) {
                    qg0.O("mPaint");
                    throw null;
                }
                paint2.setAlpha(this.s);
            }
            Path path8 = this.h;
            if (path8 == null) {
                qg0.O("mPath");
                throw null;
            }
            Paint paint3 = this.g;
            if (paint3 == null) {
                qg0.O("mPaint");
                throw null;
            }
            canvas.drawPath(path8, paint3);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getWidth() > 0 && getHeight() > 0) {
            this.i = getWidth();
            this.j = getHeight();
        }
        a();
    }

    public final void setMaxAlpha(float f) {
        if (f <= 0.0f) {
            f = 0.01f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.s = (int) (255 * f);
    }

    public final void setMaxLength(float f) {
        this.p = f;
    }

    public final void setMaxSpeed(int i) {
        this.n = i;
    }

    public final void setMinLength(float f) {
        this.q = f;
    }

    public final void setMinSpeed(int i) {
        this.o = i;
    }

    public final void setRainCount(int i) {
        if (i < 1) {
            i = 1;
        }
        this.k = i;
        a();
    }

    public final void setWaterRadius(float f) {
        this.r = f;
    }
}
