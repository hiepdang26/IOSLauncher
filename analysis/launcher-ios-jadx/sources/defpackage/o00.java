package defpackage;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class o00 extends ThreadLocal {
    public final /* synthetic */ int a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.a) {
            case 0:
                return new q00();
            case 1:
                return new Random();
            case 2:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(wq1.h);
                return simpleDateFormat;
            default:
                return 0L;
        }
    }
}
