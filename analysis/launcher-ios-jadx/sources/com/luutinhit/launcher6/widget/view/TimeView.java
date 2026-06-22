package com.luutinhit.launcher6.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import defpackage.hs0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class TimeView extends View {
    public final Context g;
    public final Paint h;
    public final Paint i;
    public final SimpleDateFormat j;
    public final SimpleDateFormat k;
    public final Rect l;

    public TimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.h = paint;
        Paint paint2 = new Paint(1);
        this.i = paint2;
        this.l = new Rect();
        this.g = context;
        Locale locale = hs0.m(getResources().getConfiguration()).a.get();
        locale = locale == null ? Locale.ENGLISH : locale;
        this.j = new SimpleDateFormat("HH:mm", locale);
        this.k = new SimpleDateFormat("EEEE, MMMM d", locale);
        locale.getLanguage();
        if ("vi".equals(locale.getLanguage())) {
            this.k = new SimpleDateFormat("EEEE, d MMMM", locale);
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf");
        paint.setColor(-1);
        paint.setTypeface(typefaceCreateFromAsset);
        Typeface typefaceCreateFromAsset2 = Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf");
        paint2.setColor(-1);
        paint2.setTypeface(typefaceCreateFromAsset2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Context context = this.g;
        SimpleDateFormat simpleDateFormat = this.j;
        try {
            DateFormat.is24HourFormat(context);
            if (DateFormat.is24HourFormat(context)) {
                simpleDateFormat.applyPattern("HH:mm");
            } else {
                simpleDateFormat.applyPattern("h:mm");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        int width = getWidth();
        int height = getHeight();
        Paint paint = this.h;
        paint.setTextSize((height * 3) / 4.0f);
        Paint paint2 = this.i;
        paint2.setTextSize(height / 5.0f);
        Date time = Calendar.getInstance().getTime();
        String str = simpleDateFormat.format(time);
        String str2 = this.k.format(time);
        Rect rect = this.l;
        rect.setEmpty();
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, (width - rect.width()) - 20, rect.height() + 1, paint);
        rect.setEmpty();
        paint2.getTextBounds(str2, 0, str2.length(), rect);
        canvas.drawText(str2, (width - rect.width()) - 20, (height - rect.bottom) - 1, paint2);
    }
}
