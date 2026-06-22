package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcher6.t;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class br extends Drawable implements iz0 {
    public final float g;
    public final float h;
    public final float j;
    public float k;
    public final int m;
    public final Paint o;
    public final Paint p;
    public final Paint q;
    public final Paint r;
    public final Paint s;
    public boolean u;
    public boolean v;
    public final String[] i = {"3", "6", "9", "12"};
    public float l = 0.0f;
    public float n = 0.0f;
    public final Rect t = new Rect();

    public br(Context context, float f, float f2) {
        this.h = f;
        this.g = f2;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e51.clock_hand_size);
        this.m = dimensionPixelSize;
        this.j = context.getResources().getDimensionPixelSize(e51.clock_padding);
        Paint paint = new Paint();
        this.o = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextMedium.otf"));
        Paint paint2 = new Paint();
        this.p = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(-16777216);
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.q = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(-1);
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        float f3 = dimensionPixelSize;
        paint3.setStrokeWidth(0.9f * f3);
        Paint paint4 = new Paint();
        this.r = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(-37632);
        paint4.setStyle(style);
        paint4.setStrokeCap(cap);
        paint4.setStrokeWidth(f3 * 0.36f);
        Paint paint5 = new Paint(1);
        this.s = paint5;
        paint5.setColor(-7829368);
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        if (context instanceof t) {
            t tVar = (t) context;
            boolean z = tVar.isDarkMode;
            this.v = z;
            a(z);
            bo1 tinyDB = tVar.getTinyDB();
            if (tinyDB != null) {
                SharedPreferences sharedPreferences = tinyDB.a;
                if (sharedPreferences.getInt("color_icon_style", 1) == 2) {
                    int i = sharedPreferences.getInt("color_tinted_app", -1);
                    paint2.setColor(i != -1 ? i == 0 ? -7829368 : i : -1);
                }
            }
            context.toString();
            tVar.setOnTinyDBChangeListener(this);
        }
    }

    @Override // defpackage.iz0
    public final void a(boolean z) {
        this.v = z;
        this.p.setColor(z ? -15198184 : -1184275);
        this.q.setColor(z ? -1 : -16777216);
        this.o.setColor(z ? -1 : -16777216);
    }

    public final void b(Canvas canvas, float f, float f2, double d, boolean z, boolean z2) {
        double d2 = ((3.141592653589793d * d) / 30.0d) - 1.5707963267948966d;
        float f3 = this.n - this.k;
        if (z) {
            f3 -= this.l;
        }
        if (!z2) {
            double d3 = f3;
            canvas.drawLine(f, f2, (float) ((Math.cos(d2) * d3) + ((double) f)), (float) ((Math.sin(d2) * d3) + ((double) f2)), this.q);
            return;
        }
        Paint paint = this.r;
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f, f2, this.m, paint);
        paint.setStyle(Paint.Style.STROKE);
        double d4 = f;
        double d5 = f3;
        double d6 = f2;
        canvas.drawLine((float) (d4 - ((Math.cos(d2) * d5) / 3.0d)), (float) (d6 - ((Math.sin(d2) * d5) / 3.0d)), (float) ((Math.cos(d2) * d5 * 1.2000000476837158d) + d4), (float) ((Math.sin(d2) * d5 * 1.2000000476837158d) + d6), paint);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f;
        Region region;
        int i;
        br brVar = this;
        Canvas canvas2 = canvas;
        Rect rect = brVar.t;
        try {
            int iSave = canvas2.save();
            boolean z = brVar.u;
            float f2 = brVar.g;
            float f3 = brVar.h;
            if (!z) {
                float fMin = Math.min(f2, f3);
                brVar.n = (fMin / 2.0f) - brVar.j;
                brVar.k = fMin / 15.0f;
                brVar.l = fMin / 9.0f;
                brVar.u = true;
            }
            float f4 = f3 / 2.0f;
            float f5 = f2 / 2.0f;
            Paint paint = brVar.p;
            paint.getColor();
            ve0.a(canvas2, f3, f2, paint);
            Path pathC = ve0.c(f3, f2);
            new PathMeasure(pathC, true);
            Region region2 = new Region(0, 0, (int) f3, (int) f2);
            Region region3 = new Region();
            region3.setPath(pathC, region2);
            float f6 = brVar.m;
            float f7 = f6 * 2.0f;
            float f8 = f6 * 4.0f;
            float f9 = f6 * 2.5f;
            float f10 = f6 * 1.5f;
            int i2 = 0;
            while (i2 < 60) {
                double radians = Math.toRadians(i2 * 6);
                int i3 = iSave;
                float fCos = (float) Math.cos(radians);
                float fSin = (float) Math.sin(radians);
                float f11 = f6;
                float fHypot = (float) Math.hypot(f3, f2);
                float f12 = -1.0f;
                float f13 = -1.0f;
                float f14 = 0.0f;
                boolean z2 = false;
                while (true) {
                    if (f14 > fHypot) {
                        f = f12;
                        break;
                    }
                    float f15 = (fCos * f14) + f4;
                    float f16 = (fSin * f14) + f5;
                    float f17 = fHypot;
                    f = f12;
                    if (!region3.contains((int) f15, (int) f16)) {
                        break;
                    }
                    f14 += 0.5f;
                    f12 = f15;
                    f13 = f16;
                    fHypot = f17;
                    z2 = true;
                }
                if (z2) {
                    float f18 = f - (fCos * f10);
                    float f19 = f13 - (fSin * f10);
                    float f20 = i2 % 5 == 0 ? i2 % 15 == 0 ? f9 : f8 : f7;
                    float f21 = f18 - (fCos * f20);
                    float f22 = f19 - (f20 * fSin);
                    int i4 = i2 % 5;
                    region = region3;
                    Paint paint2 = brVar.s;
                    if (i4 == 0) {
                        paint2.setStrokeWidth(0.39f * f11);
                        paint2.setColor(brVar.v ? -1 : -16777216);
                    } else {
                        paint2.setStrokeWidth(0.3f * f11);
                        paint2.setColor(-7829368);
                    }
                    i = i2;
                    canvas2 = canvas;
                    canvas2.drawLine(f18, f19, f21, f22, paint2);
                } else {
                    canvas2 = canvas;
                    i = i2;
                    region = region3;
                }
                i2 = i + 1;
                region3 = region;
                iSave = i3;
                f6 = f11;
            }
            int i5 = iSave;
            float f23 = f3 / 6.99f;
            Paint paint3 = brVar.o;
            paint3.setTextSize(f23);
            int i6 = 0;
            while (i6 < 4) {
                String str = brVar.i[i6];
                paint3.getTextBounds(str, 0, str.length(), rect);
                double d = ((double) i6) * 1.5707963267948966d;
                float f24 = 1.2f * f23;
                canvas2.drawText(str, (float) ((Math.cos(d) * ((double) (brVar.n - f24))) + ((double) f4)), (float) ((Math.sin(d) * ((double) (brVar.n - f24))) + ((double) f5) + ((double) (r15.height() / 2.0f))), paint3);
                i6++;
                brVar = this;
                rect = rect;
            }
            Calendar calendar = Calendar.getInstance();
            float f25 = calendar.get(11);
            float f26 = calendar.get(12);
            float f27 = (f26 / 60.0f) + f25;
            if (f27 > 12.0f) {
                f27 -= 12.0f;
            }
            b(canvas2, f4, f5, f27 * 5.0f, true, false);
            b(canvas, f4, f5, f26, false, false);
            b(canvas, f4, f5, calendar.get(13), false, true);
            canvas.restoreToCount(i5);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
