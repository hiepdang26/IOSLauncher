package defpackage;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class v5 extends Exception {
    public final Status g;

    /* JADX WARN: Illegal instructions before constructor call */
    public v5(Status status) {
        int i = status.g;
        String str = status.h;
        super(i + ": " + (str == null ? "" : str));
        this.g = status;
    }
}
