package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class k42 {
    public static final ThreadPoolExecutor a = new ThreadPoolExecutor(2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 10, TimeUnit.SECONDS, new SynchronousQueue(), new w12("ClientDefault"));
    public static final ExecutorService b = Executors.newSingleThreadExecutor(new w12("ClientSingle"));
}
