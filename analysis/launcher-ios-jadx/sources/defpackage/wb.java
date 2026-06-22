package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.luutinhit.launcher6.widget.widgetprovider.BatteryWidgetProvider;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class wb implements yy {
    public static PendingIntent b;
    public static wb c;
    public final Context a;

    public wb(Context context, int i) {
        switch (i) {
            case 1:
                this.a = context.getApplicationContext();
                break;
            case 2:
                this.a = context;
                break;
            default:
                this.a = context;
                Intent intent = new Intent(context, (Class<?>) BatteryWidgetProvider.class);
                intent.setPackage(context.getPackageName());
                intent.setAction("com.luutinhit.ACTION_UPDATE_BATTERY_WIDGET");
                b = PendingIntent.getBroadcast(context, 868686868, intent, ar1.i ? 335544320 : 268435456);
                break;
        }
    }

    @Override // defpackage.yy
    public void a(os osVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ll("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new bd(this, osVar, threadPoolExecutor, 1));
    }
}
