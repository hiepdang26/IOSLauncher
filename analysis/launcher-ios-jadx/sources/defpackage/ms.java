package defpackage;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ms extends BaseAdapter {
    public static final int j;
    public final Calendar g;
    public final int h;
    public final int i;

    static {
        j = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public ms() {
        Calendar calendarC = sq1.c(null);
        this.g = calendarC;
        this.h = calendarC.getMaximum(7);
        this.i = calendarC.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.h;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i2 = this.h;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.i;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(l61.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i2 = i + this.i;
        int i3 = this.h;
        if (i2 > i3) {
            i2 -= i3;
        }
        Calendar calendar = this.g;
        calendar.set(7, i2);
        textView.setText(calendar.getDisplayName(7, j, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(v61.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
