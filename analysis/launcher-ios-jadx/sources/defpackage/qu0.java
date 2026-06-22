package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class qu0 extends BaseAdapter {
    public static final int j = sq1.c(null).getMaximum(4);
    public final pu0 g;
    public wb2 h;
    public final lf i;

    public qu0(pu0 pu0Var, lf lfVar) {
        this.g = pu0Var;
        this.i = lfVar;
        throw null;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        pu0 pu0Var = this.g;
        if (i < pu0Var.d() || i > b()) {
            return null;
        }
        int iD = (i - pu0Var.d()) + 1;
        Calendar calendarA = sq1.a(pu0Var.g);
        calendarA.set(5, iD);
        return Long.valueOf(calendarA.getTimeInMillis());
    }

    public final int b() {
        pu0 pu0Var = this.g;
        return (pu0Var.d() + pu0Var.k) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        pu0 pu0Var = this.g;
        return pu0Var.d() + pu0Var.k;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.g.j;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        Context context = viewGroup.getContext();
        if (this.h == null) {
            this.h = new wb2(context, 5);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(l61.mtrl_calendar_day, viewGroup, false);
        }
        pu0 pu0Var = this.g;
        int iD = i - pu0Var.d();
        if (iD < 0 || iD >= pu0Var.k) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i2 = iD + 1;
            textView.setTag(pu0Var);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
            Calendar calendarA = sq1.a(pu0Var.g);
            calendarA.set(5, i2);
            long timeInMillis = calendarA.getTimeInMillis();
            Calendar calendarB = sq1.b();
            calendarB.set(5, 1);
            Calendar calendarA2 = sq1.a(calendarB);
            calendarA2.get(2);
            int i3 = calendarA2.get(1);
            calendarA2.getMaximum(7);
            calendarA2.getActualMaximum(5);
            calendarA2.getTimeInMillis();
            if (pu0Var.i == i3) {
                Locale locale = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", locale);
                    instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                    str2 = instanceForSkeleton.format(new Date(timeInMillis));
                } else {
                    java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(0, locale);
                    dateInstance.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                    str2 = dateInstance.format(new Date(timeInMillis));
                }
                textView.setContentDescription(str2);
            } else {
                Locale locale2 = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    DateFormat instanceForSkeleton2 = DateFormat.getInstanceForSkeleton("yMMMEd", locale2);
                    instanceForSkeleton2.setTimeZone(TimeZone.getTimeZone("UTC"));
                    str = instanceForSkeleton2.format(new Date(timeInMillis));
                } else {
                    java.text.DateFormat dateInstance2 = java.text.DateFormat.getDateInstance(0, locale2);
                    dateInstance2.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                    str = dateInstance2.format(new Date(timeInMillis));
                }
                textView.setContentDescription(str);
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        long jLongValue = item.longValue();
        if (textView != null) {
            if (jLongValue >= this.i.i.g) {
                textView.setEnabled(true);
                throw null;
            }
            textView.setEnabled(false);
            y2 y2Var = (y2) this.h.j;
            y2Var.getClass();
            rr0 rr0Var = new rr0();
            rr0 rr0Var2 = new rr0();
            wf1 wf1Var = (wf1) y2Var.f;
            rr0Var.setShapeAppearanceModel(wf1Var);
            rr0Var2.setShapeAppearanceModel(wf1Var);
            rr0Var.k((ColorStateList) y2Var.d);
            rr0Var.g.j = y2Var.a;
            rr0Var.invalidateSelf();
            qr0 qr0Var = rr0Var.g;
            ColorStateList colorStateList = qr0Var.d;
            ColorStateList colorStateList2 = (ColorStateList) y2Var.e;
            if (colorStateList != colorStateList2) {
                qr0Var.d = colorStateList2;
                rr0Var.onStateChange(rr0Var.getState());
            }
            ColorStateList colorStateList3 = (ColorStateList) y2Var.c;
            textView.setTextColor(colorStateList3);
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList3.withAlpha(30), rr0Var, rr0Var2);
            Rect rect = (Rect) y2Var.b;
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
            WeakHashMap weakHashMap = qs1.a;
            textView.setBackground(insetDrawable);
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
