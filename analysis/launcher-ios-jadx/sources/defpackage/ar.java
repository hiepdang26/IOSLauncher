package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcher6.t;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ar extends Drawable implements iz0 {
    public static Typeface p;
    public static Typeface q;
    public final float g;
    public final float h;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final Context o;
    public final Rect i = new Rect();
    public boolean m = false;
    public SimpleDateFormat n = null;

    public ar(Context context, float f, float f2) {
        Typeface typefaceCreateFromAsset;
        Typeface typefaceCreateFromAsset2;
        this.o = context;
        this.g = f;
        this.h = f2;
        if (p == null) {
            try {
                typefaceCreateFromAsset2 = Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextMedium.otf");
            } catch (Throwable th) {
                th.getMessage();
                typefaceCreateFromAsset2 = Typeface.DEFAULT;
            }
            p = typefaceCreateFromAsset2;
        }
        if (q == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf");
            } catch (Throwable th2) {
                th2.getMessage();
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
            q = typefaceCreateFromAsset;
        }
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setColor(-1);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.k = paint2;
        paint2.setColor(-65536);
        paint2.setStyle(style);
        paint2.setTypeface(p);
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        Paint paint3 = new Paint(1);
        this.l = paint3;
        paint3.setColor(-16777216);
        paint3.setStyle(style);
        paint3.setTypeface(q);
        paint3.setTextAlign(align);
        if (context instanceof t) {
            t tVar = (t) context;
            bo1 tinyDB = tVar.getTinyDB();
            if (tinyDB.a.getInt("color_icon_style", 1) == 2) {
                int i = tinyDB.a.getInt("color_tinted_app", -1);
                paint.setColor(i == -1 ? -1 : i == 0 ? -16777216 : i);
                paint3.setColor(i != 0 ? -16777216 : -1);
                invalidateSelf();
            }
            a(tVar.isDarkMode);
            tVar.setOnTinyDBChangeListener(this);
        }
    }

    @Override // defpackage.iz0
    public final void a(boolean z) {
        this.j.setColor(z ? -16777216 : -1);
        this.l.setColor(z ? -1 : -16777216);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f = this.h;
        Rect rect = this.i;
        try {
            int iSave = canvas.save();
            if (!this.m) {
                this.m = true;
            }
            float f2 = this.g;
            float f3 = f2 / 2.0f;
            ve0.a(canvas, f2, f, this.j);
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            if (this.n == null) {
                try {
                    Locale locale = hs0.m(this.o.getResources().getConfiguration()).a.get();
                    if (locale == null) {
                        locale = Locale.getDefault();
                    }
                    this.n = new SimpleDateFormat("EEE", locale);
                } catch (Throwable th) {
                    th.getMessage();
                    this.n = new SimpleDateFormat("EEE", Locale.ENGLISH);
                }
            }
            String upperCase = this.n.format(time).toUpperCase();
            String strValueOf = String.valueOf(calendar.get(5));
            rect.setEmpty();
            Paint paint = this.l;
            paint.setTextSize(f / 1.5f);
            paint.getTextBounds(strValueOf, 0, strValueOf.length(), rect);
            canvas.drawText(strValueOf, f3, f - (0.15f * f), paint);
            rect.setEmpty();
            float f4 = f / 6.0f;
            Paint paint2 = this.k;
            paint2.setTextSize(f4);
            paint2.getTextBounds(upperCase, 0, upperCase.length(), rect);
            paint2.setTextSize(Math.min(((f2 * 0.9f) * f4) / rect.width(), f4));
            paint2.getTextBounds(upperCase, 0, upperCase.length(), rect);
            canvas.drawText(upperCase, f3, f * 0.26f, paint2);
            canvas.restoreToCount(iSave);
        } catch (Throwable th2) {
            th2.getMessage();
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
