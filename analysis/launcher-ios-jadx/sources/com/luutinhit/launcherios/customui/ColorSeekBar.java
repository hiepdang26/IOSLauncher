package com.luutinhit.launcherios.customui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionScene;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import defpackage.fk;
import defpackage.g71;
import defpackage.gk;
import defpackage.k8;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ColorSeekBar extends View {
    public LinearGradient A;
    public Paint B;
    public final Paint C;
    public final Paint D;
    public final Paint E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public RectF K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public final ArrayList R;
    public int S;
    public boolean T;
    public boolean U;
    public LinearGradient V;
    public int[] W;
    public int a0;
    public int b0;
    public int c0;
    public final int g;
    public int[] h;
    public int i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public fk o;
    public final Context p;
    public boolean q;
    public final boolean r;
    public boolean s;
    public boolean t;
    public Bitmap u;
    public RectF v;
    public final int w;
    public float x;
    public float y;
    public int z;

    public ColorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.h = new int[]{-16777216, -6749953, -16776961, -16711936, -16711681, -65536, -65281, -39424, -256, -1, -16777216};
        this.q = false;
        this.w = 20;
        this.z = 2;
        new Paint();
        this.C = new Paint();
        this.D = new Paint();
        this.E = new Paint();
        new Paint();
        this.N = 5;
        this.R = new ArrayList();
        this.S = -1;
        this.T = false;
        this.U = true;
        this.a0 = -1;
        this.b0 = -1;
        this.c0 = -1;
        this.p = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.ColorSeekBar, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(g71.ColorSeekBar_colorSeeds, 0);
        this.J = typedArrayObtainStyledAttributes.getInteger(g71.ColorSeekBar_maxPosition, MotionScene.Transition.TransitionOnClick.JUMP_TO_END);
        this.L = typedArrayObtainStyledAttributes.getInteger(g71.ColorSeekBar_colorBarPosition, 0);
        this.M = typedArrayObtainStyledAttributes.getInteger(g71.ColorSeekBar_alphaBarPosition, 0);
        this.r = typedArrayObtainStyledAttributes.getBoolean(g71.ColorSeekBar_isVertical, false);
        this.q = typedArrayObtainStyledAttributes.getBoolean(g71.ColorSeekBar_showAlphaBar, false);
        this.g = typedArrayObtainStyledAttributes.getColor(g71.ColorSeekBar_bgColor, 0);
        this.z = (int) typedArrayObtainStyledAttributes.getDimension(g71.ColorSeekBar_barHeight, b(30.0f));
        this.w = (int) typedArrayObtainStyledAttributes.getDimension(g71.ColorSeekBar_thumbHeight, b(28.0f));
        this.N = (int) typedArrayObtainStyledAttributes.getDimension(g71.ColorSeekBar_barMargin, b(5.0f));
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            this.h = c(resourceId);
        }
        setBackgroundColor(this.g);
    }

    public static int f(float f, int i, int i2) {
        return Math.round(f * (i2 - i)) + i;
    }

    public final void a() {
        if (this.I < 1) {
            return;
        }
        ArrayList arrayList = this.R;
        arrayList.clear();
        for (int i = 0; i <= this.J; i++) {
            arrayList.add(Integer.valueOf(g(i)));
        }
    }

    public final int b(float f) {
        return (int) ((f * this.p.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final int[] c(int i) {
        int i2 = 0;
        if (isInEditMode()) {
            String[] stringArray = this.p.getResources().getStringArray(i);
            int[] iArr = new int[stringArray.length];
            while (i2 < stringArray.length) {
                iArr[i2] = Color.parseColor(stringArray[i2]);
                i2++;
            }
            return iArr;
        }
        TypedArray typedArrayObtainTypedArray = this.p.getResources().obtainTypedArray(i);
        int[] iArr2 = new int[typedArrayObtainTypedArray.length()];
        while (i2 < typedArrayObtainTypedArray.length()) {
            iArr2[i2] = typedArrayObtainTypedArray.getColor(i2, -16777216);
            i2++;
        }
        typedArrayObtainTypedArray.recycle();
        return iArr2;
    }

    public final void d() {
        float f = this.w / 2.0f;
        this.x = f;
        this.O = (int) f;
        this.y = f / 6.0f;
        int height = ((getHeight() - getPaddingBottom()) - this.O) - (((int) this.y) + 1);
        int width = ((getWidth() - getPaddingRight()) - this.O) - ((int) this.y);
        this.F = ((int) this.y) + 1 + getPaddingLeft() + this.O;
        if (!this.r) {
            height = width;
        }
        this.G = height;
        this.H = getPaddingTop() + this.O + ((int) this.y);
        this.I = this.G - this.F;
        this.v = new RectF(this.F, this.H, this.G, r3 + this.z);
        this.K = new RectF(this.F, this.w + this.z + this.N, this.G, r0 + this.z);
        this.A = new LinearGradient(0.0f, 0.0f, this.v.width(), 0.0f, this.h, (float[]) null, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.B = paint;
        paint.setShader(this.A);
        this.B.setAntiAlias(true);
        Paint paint2 = this.E;
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(this.y);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.W = new int[2];
        a();
    }

    public final boolean e(RectF rectF, float f, float f2) {
        try {
            float f3 = rectF.left;
            float f4 = this.x;
            if (f3 - f4 < f && f < rectF.right + f4 && rectF.top - f4 < f2) {
                if (f2 < rectF.bottom + f4) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public final int g(int i) {
        float f = this.I;
        float f2 = ((i / this.J) * f) / f;
        if (f2 <= 0.0d) {
            return this.h[0];
        }
        if (f2 >= 1.0f) {
            return this.h[r6.length - 1];
        }
        int[] iArr = this.h;
        float length = f2 * (iArr.length - 1);
        int i2 = (int) length;
        float f3 = length - i2;
        int i3 = iArr[i2];
        this.i = i3;
        this.j = iArr[i2 + 1];
        this.k = f(f3, Color.red(i3), Color.red(this.j));
        this.l = f(f3, Color.green(this.i), Color.green(this.j));
        return Color.rgb(this.k, this.l, f(f3, Color.blue(this.i), Color.blue(this.j)));
    }

    public int getAlphaBarPosition() {
        return this.M;
    }

    public int getColor() {
        int i = this.L;
        ArrayList arrayList = this.R;
        if (i >= arrayList.size()) {
            return g(this.L);
        }
        int i2 = this.a0;
        return (i2 == -1 || i2 != this.L) ? ((Integer) arrayList.get(this.L)).intValue() : ((Integer) arrayList.get(i2)).intValue();
    }

    public int getColorWhite() {
        float f = this.I;
        float f2 = ((this.M / 255.0f) * f) / f;
        if (f2 <= 0.0d) {
            return this.W[0];
        }
        if (f2 >= 1.0f) {
            return this.W[r0.length - 1];
        }
        int[] iArr = this.W;
        float length = f2 * (iArr.length - 1);
        int i = (int) length;
        float f3 = length - i;
        int i2 = iArr[i];
        this.i = i2;
        this.j = iArr[i + 1];
        this.k = f(f3, Color.red(i2), Color.red(this.j));
        this.l = f(f3, Color.green(this.i), Color.green(this.j));
        return Color.rgb(this.k, this.l, f(f3, Color.blue(this.i), Color.blue(this.j)));
    }

    public List<Integer> getColors() {
        return this.R;
    }

    public int getMaxValue() {
        return this.J;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.r) {
            canvas.rotate(-90.0f);
            canvas.translate(-getHeight(), 0.0f);
            canvas.scale(-1.0f, 1.0f, getHeight() / 2.0f, getWidth() / 2.0f);
        }
        int i = this.L;
        float f = (i / this.J) * this.I;
        if (this.a0 != i) {
            int color = getColor();
            this.c0 = color;
            int[] iArr = this.W;
            iArr[0] = color;
            iArr[1] = -1;
            this.a0 = this.L;
        }
        int i2 = this.c0;
        Paint paint = this.C;
        paint.setColor(i2);
        canvas.drawColor(this.g);
        RectF rectF = this.v;
        float f2 = this.x;
        canvas.drawRoundRect(rectF, f2, f2, this.B);
        float f3 = f + this.F;
        RectF rectF2 = this.v;
        float fHeight = (rectF2.height() / 2.0f) + rectF2.top;
        canvas.drawCircle(f3, fHeight, (this.z / 2.0f) + 5.0f, paint);
        Paint paint2 = this.E;
        canvas.drawCircle(f3, fHeight, (this.z / 2.0f) + 5.0f, paint2);
        if (this.q) {
            Paint paint3 = this.D;
            paint3.setAntiAlias(true);
            if (this.b0 != this.M) {
                getColorWhite();
                paint.setColor(getColorWhite());
                this.b0 = this.M;
            }
            float f4 = ((this.M / 255.0f) * this.I) + this.F;
            RectF rectF3 = this.K;
            float fHeight2 = (rectF3.height() / 2.0f) + rectF3.top;
            if (this.V == null || paint3.getColor() != this.c0) {
                this.V = new LinearGradient(0.0f, 0.0f, this.K.width(), 0.0f, this.W, (float[]) null, Shader.TileMode.CLAMP);
            }
            paint3.setShader(this.V);
            RectF rectF4 = this.K;
            float f5 = this.x;
            canvas.drawRoundRect(rectF4, f5, f5, paint3);
            canvas.drawCircle(f4, fHeight2, (this.z / 2.0f) + 5.0f, paint);
            canvas.drawCircle(f4, fHeight2, (this.z / 2.0f) + 5.0f, paint2);
        }
        if (this.U) {
            this.U = false;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.P = i;
        this.Q = i2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z = this.q;
        int i3 = this.z;
        if (z) {
            i3 *= 2;
        }
        int i4 = z ? this.w * 2 : this.w;
        if (this.r) {
            if (mode == Integer.MIN_VALUE || mode == 0) {
                int i5 = i4 + i3 + this.N;
                this.P = i5;
                setMeasuredDimension(i5, this.Q);
                return;
            }
            return;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int i6 = i4 + i3 + this.N;
            this.Q = i6;
            setMeasuredDimension(this.P, i6);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        try {
            if (this.r) {
                this.u = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
            } else {
                this.u = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            }
            this.u.eraseColor(0);
            d();
            this.T = true;
            int i5 = this.S;
            if (i5 != -1) {
                setColor(i5);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.m = this.r ? motionEvent.getY() : motionEvent.getX();
        this.n = this.r ? motionEvent.getX() : motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.s = false;
                this.t = false;
                return true;
            }
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                boolean z = this.s;
                if (z) {
                    float f = (this.m - this.F) / this.I;
                    int i = this.J;
                    int i2 = (int) (f * i);
                    this.L = i2;
                    if (i2 < 0) {
                        this.L = 0;
                    }
                    if (this.L > i) {
                        this.L = i;
                    }
                } else if (this.q && this.t) {
                    int i3 = (int) (((this.m - this.F) / this.I) * 255.0f);
                    this.M = i3;
                    if (i3 < 0) {
                        this.M = 0;
                    }
                    if (this.M > 255) {
                        this.M = 255;
                    }
                }
                fk fkVar = this.o;
                if (fkVar != null && (this.t || z)) {
                    k8 k8Var = (k8) fkVar;
                    SlidingUpCustomizeColorIconStyle.j((SlidingUpCustomizeColorIconStyle) k8Var.h, (Bitmap) k8Var.i, getColorWhite());
                }
                invalidate();
                return true;
            }
        } else {
            if (e(this.v, this.m, this.n)) {
                this.s = true;
                return true;
            }
            if (this.q && e(this.K, this.m, this.n)) {
                this.t = true;
            }
        }
        return true;
    }

    public void setAlphaBarPosition(int i) {
        this.M = i;
        invalidate();
    }

    public void setBarHeight(float f) {
        this.z = b(f);
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setBarHeightPx(int i) {
        this.z = i;
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setBarMargin(float f) {
        this.N = b(f);
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setBarMarginPx(int i) {
        this.N = i;
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setColor(int i) {
        int iRgb = Color.rgb(Color.red(i), Color.green(i), Color.blue(i));
        if (this.T) {
            setColorBarPosition(this.R.indexOf(Integer.valueOf(iRgb)));
        } else {
            this.S = i;
        }
    }

    public void setColorBarPosition(int i) {
        this.L = i;
        int iMin = Math.min(i, this.J);
        this.L = iMin;
        this.L = Math.max(iMin, 0);
        invalidate();
        fk fkVar = this.o;
        if (fkVar != null) {
            k8 k8Var = (k8) fkVar;
            SlidingUpCustomizeColorIconStyle.j((SlidingUpCustomizeColorIconStyle) k8Var.h, (Bitmap) k8Var.i, getColorWhite());
        }
    }

    public void setColorSeeds(int i) {
        setColorSeeds(c(i));
    }

    public void setMaxPosition(int i) {
        this.J = i;
        invalidate();
        a();
    }

    public void setOnColorChangeListener(fk fkVar) {
        this.o = fkVar;
    }

    public void setShowAlphaBar(boolean z) {
        this.q = z;
        setLayoutParams(getLayoutParams());
        invalidate();
        fk fkVar = this.o;
        if (fkVar != null) {
            k8 k8Var = (k8) fkVar;
            SlidingUpCustomizeColorIconStyle.j((SlidingUpCustomizeColorIconStyle) k8Var.h, (Bitmap) k8Var.i, getColorWhite());
        }
    }

    public void setColorSeeds(int[] iArr) {
        this.h = iArr;
        invalidate();
        a();
        fk fkVar = this.o;
        if (fkVar != null) {
            k8 k8Var = (k8) fkVar;
            SlidingUpCustomizeColorIconStyle.j((SlidingUpCustomizeColorIconStyle) k8Var.h, (Bitmap) k8Var.i, getColorWhite());
        }
    }

    public void setOnInitDoneListener(gk gkVar) {
    }
}
