package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
final class zzbzj extends ScheduledThreadPoolExecutor {
    public zzbzj(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
