package defpackage;

import android.content.Context;
import android.view.GestureDetector;

/* JADX INFO: loaded from: classes.dex */
public final class h80 {
    public final GestureDetector a;

    public h80(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.a = new GestureDetector(context, onGestureListener, null);
    }
}
