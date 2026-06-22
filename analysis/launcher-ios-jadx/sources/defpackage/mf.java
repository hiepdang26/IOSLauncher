package defpackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.luutinhit.launcher6.widget.CalendarWidget;
import com.luutinhit.launcher6.widget.CalendarWidget_2x2;
import com.luutinhit.launcher6.widget.FavoriteContactWidget;

/* JADX INFO: loaded from: classes.dex */
public final class mf extends ContentObserver {
    public final /* synthetic */ int a;
    public final /* synthetic */ vm b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mf(vm vmVar, Handler handler, int i) {
        super(handler);
        this.a = i;
        this.b = vmVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        switch (this.a) {
            case 0:
                super.onChange(z);
                CalendarWidget calendarWidget = (CalendarWidget) this.b;
                if (calendarWidget.x) {
                    calendarWidget.y.removeCallbacksAndMessages(null);
                    calendarWidget.y.postDelayed(calendarWidget.z, 5000L);
                }
                break;
            case 1:
                super.onChange(z);
                CalendarWidget_2x2 calendarWidget_2x2 = (CalendarWidget_2x2) this.b;
                if (calendarWidget_2x2.q) {
                    calendarWidget_2x2.r.removeCallbacksAndMessages(null);
                    calendarWidget_2x2.r.postDelayed(calendarWidget_2x2.s, 5000L);
                }
                break;
            default:
                super.onChange(z);
                FavoriteContactWidget favoriteContactWidget = (FavoriteContactWidget) this.b;
                if (favoriteContactWidget.x) {
                    Handler handler = favoriteContactWidget.y;
                    handler.removeCallbacksAndMessages(null);
                    handler.postDelayed(favoriteContactWidget.z, 5000L);
                }
                break;
        }
    }
}
