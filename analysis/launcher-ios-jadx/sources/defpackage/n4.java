package defpackage;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Trace;
import android.widget.RemoteViews;
import com.luutinhit.launcher6.widget.widgetprovider.AnalogClockWidgetProvider;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final class n4 implements Runnable {
    public final /* synthetic */ int g;

    public /* synthetic */ n4(int i) {
        this.g = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = true;
        int i = 0;
        switch (this.g) {
            case 0:
                if (AnalogClockWidgetProvider.c == null || !AnalogClockWidgetProvider.b) {
                    return;
                }
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(AnalogClockWidgetProvider.c);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(AnalogClockWidgetProvider.c, (Class<?>) AnalogClockWidgetProvider.class));
                int length = appWidgetIds.length;
                while (i < length) {
                    int i2 = appWidgetIds[i];
                    Context context = AnalogClockWidgetProvider.c;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(jCurrentTimeMillis);
                    int i3 = calendar.get(10);
                    int i4 = calendar.get(12);
                    float f = (calendar.get(14) / 1000.0f) + calendar.get(13);
                    float f2 = (f / 60.0f) + i4;
                    float f3 = ((f2 / 60.0f) + i3) * 30.0f;
                    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), m61.analog_clock_widget_provider);
                    remoteViews.setFloat(v51.hourHand, "setRotation", f3);
                    remoteViews.setFloat(v51.minuteHand, "setRotation", f2 * 6.0f);
                    remoteViews.setFloat(v51.secondHand, "setRotation", f * 6.0f);
                    appWidgetManager.updateAppWidget(i2, remoteViews);
                    i++;
                }
                AnalogClockWidgetProvider.a.postDelayed(this, 32L);
                return;
            case 1:
                try {
                    int i5 = no1.a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (zy.j == null) {
                        z = false;
                    }
                    if (z) {
                        zy.a().c();
                        break;
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    int i6 = no1.a;
                    Trace.endSection();
                    throw th;
                }
            case 2:
                return;
            default:
                ArrayList arrayList = new ArrayList(wd1.d.keySet());
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) obj;
                    if (scheduledThreadPoolExecutor.isShutdown()) {
                        wd1.d.remove(scheduledThreadPoolExecutor);
                    } else {
                        scheduledThreadPoolExecutor.purge();
                    }
                }
                return;
        }
    }

    public String toString() {
        switch (this.g) {
            case 2:
                return "EmptyRunnable";
            default:
                return super.toString();
        }
    }

    private final void a() {
    }
}
