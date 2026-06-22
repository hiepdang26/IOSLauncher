package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class wk extends RuntimeException {
    public final /* synthetic */ int g;

    @Override // java.lang.Throwable
    public String getMessage() {
        switch (this.g) {
            case 1:
                return "Chain of Causes for CompositeException In Order Received =>";
            default:
                return super.getMessage();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wk(String str, int i) {
        super(str);
        this.g = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wk(String str, Throwable th, int i) {
        super(str, th);
        this.g = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wk(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        this.g = 5;
    }
}
