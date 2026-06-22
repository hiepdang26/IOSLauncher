package defpackage;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcher6.t;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class vc extends Drawable implements ed, SharedPreferences.OnSharedPreferenceChangeListener {
    public boolean A;
    public boolean B;
    public Bitmap C;
    public final Paint E;
    public final int[] F;
    public final float[] G;
    public final t g;
    public final fd l;
    public final float m;
    public float n;
    public float p;
    public LightingColorFilter s;
    public boolean t;
    public final bo1 v;
    public final int w;
    public boolean x;
    public boolean y;
    public boolean z;
    public final Paint h = new Paint(1);
    public boolean i = false;
    public final RectF j = new RectF();
    public final RectF k = new RectF();
    public boolean o = true;
    public final int q = 1090519039;
    public final Matrix r = new Matrix();
    public int u = 255;
    public final Paint D = new Paint(1);

    public vc(fd fdVar, float f, int i) {
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        Paint paint = new Paint(1);
        this.E = paint;
        this.F = new int[]{0, 1677721599, 0, 1677721599, 0};
        this.G = new float[]{0.0f, 0.125f, 0.5f, 0.625f, 1.0f};
        this.l = fdVar;
        this.w = i;
        t tVar = fdVar.a;
        if (tVar != null) {
            this.g = tVar;
            bo1 tinyDB = tVar.getTinyDB();
            this.v = tinyDB;
            this.x = tinyDB.a("dark_mode");
            tinyDB.j(this);
            if (i == 1) {
                this.y = b("preference_blur_dock", true);
            } else if (i == 2) {
                this.B = b("preference_blur_folder", true);
            } else if (i == 3) {
                this.z = b("preference_blur_widget", true);
            } else if (i == 4) {
                this.A = b("preference_blur_search", true);
            }
        }
        this.m = f;
        boolean z = this.x;
        this.s = new LightingColorFilter(z ? 8421504 : 16777215, z ? 0 : 2500134);
        Bitmap bitmap = fdVar.e;
        bitmap = bitmap == null ? fdVar.g : bitmap;
        this.C = bitmap;
        Objects.toString(bitmap);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2.0f);
    }

    @Override // defpackage.ed
    public final void a() {
        fd fdVar = this.l;
        Bitmap bitmap = fdVar.e;
        if (bitmap == null) {
            bitmap = fdVar.g;
        }
        this.C = bitmap;
        invalidateSelf();
    }

    public final boolean b(String str, boolean z) {
        try {
            return this.v.a.getBoolean(str, z);
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void c(float f) {
        if (Math.abs(this.p - f) > 0.1f) {
            this.p = f;
            invalidateSelf();
        }
    }

    public final void d(float f) {
        this.n = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        fd fdVar = this.l;
        Bitmap bitmap = fdVar.e;
        if (bitmap == null) {
            bitmap = fdVar.g;
        }
        this.C = bitmap;
        System.nanoTime();
        boolean z = fdVar.i;
        RectF rectF = this.j;
        float f = this.m;
        int i = this.w;
        if ((!z || fdVar.j) && this.C != null && ((i == 1 && this.y) || ((i == 2 && this.B) || ((i == 3 && this.z) || (i == 4 && this.A))))) {
            if (!this.o) {
                return;
            }
            float f2 = (-0.0f) - this.p;
            float f3 = -this.n;
            if (rectF.isEmpty() || !this.i) {
                rectF.set(0.0f, 0.0f, getBounds().width(), getBounds().height());
            }
            Bitmap bitmap2 = this.C;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
            Matrix matrix = this.r;
            matrix.setTranslate(f2, f3);
            bitmapShader.setLocalMatrix(matrix);
            Paint paint = this.D;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            paint.setColorFilter(this.s);
            if (i == 2) {
                ve0.a(canvas, rectF.width(), rectF.height(), paint);
            } else if (i != 1 || f <= 0.0f) {
                Objects.toString(rectF);
                canvas.drawRoundRect(rectF, f, f, paint);
                if (i == 4) {
                    RectF rectF2 = this.k;
                    rectF2.set(rectF);
                    rectF2.inset(2.0f, 2.0f);
                    float f4 = f - 2.0f;
                    if (this.g.isUseLiquidGlass) {
                        paint = this.E;
                    }
                    canvas.drawRoundRect(rectF2, f4, f4, paint);
                }
            } else {
                ve0.b(canvas, rectF, rectF.width(), rectF.height(), paint);
            }
        } else {
            if (!this.o) {
                return;
            }
            if (rectF.isEmpty() || !this.i) {
                rectF.set(0.0f, 0.0f, getBounds().width(), getBounds().height());
            }
            boolean z2 = this.t;
            Paint paint2 = this.h;
            if (z2) {
                paint2.setAlpha((int) (this.u * 0.14901961f));
            }
            paint2.setColor(this.x ? 1964776476 : this.q);
            if (f <= 0.0f) {
                canvas.drawRect(rectF, paint2);
            } else if (i == 2) {
                ve0.a(canvas, rectF.width(), rectF.height(), paint2);
            } else if (i == 1) {
                Objects.toString(rectF);
                ve0.b(canvas, rectF, rectF.width(), rectF.height(), paint2);
            } else {
                canvas.drawRoundRect(rectF, f, f, paint2);
            }
        }
        System.nanoTime();
    }

    @Override // defpackage.ed
    public final void g() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.E.setShader(new SweepGradient(rect.centerX(), rect.centerY(), this.F, this.G));
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "dark_mode":
                    this.x = b(str, false);
                    boolean z = this.x;
                    this.s = new LightingColorFilter(z ? 8421504 : 16777215, z ? 0 : 2500134);
                    break;
                case "preference_blur_folder":
                    this.B = b(str, false);
                    break;
                case "preference_blur_search":
                    this.A = b(str, true);
                    break;
                case "preference_blur_widget":
                    this.z = b(str, true);
                    break;
                case "preference_blur_dock":
                    this.y = b(str, true);
                    break;
            }
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.o = i == 255;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
