package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import com.google.android.gms.internal.ads.zzbbc;
import defpackage.y31;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    public static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class Result {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$create$0(Context context, long j) {
        installAfterDelay(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeInBackground(Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new y31(context, 1));
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.EMPTY_LIST;
    }

    public void installAfterDelay(Context context) {
        (Build.VERSION.SDK_INT >= 28 ? Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new y31(context, 0), new Random().nextInt(Math.max(zzbbc.zzq.zzf, 1)) + DELAY_MS);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Result create(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: x31
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                this.g.lambda$create$0(applicationContext, j);
            }
        });
        return new Result();
    }
}
