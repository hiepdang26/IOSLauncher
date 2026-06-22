package defpackage;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class os1 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static xn b(View view, xn xnVar) {
        ContentInfo contentInfoO = xnVar.a.o();
        Objects.requireNonNull(contentInfoO);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoO);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoO ? xnVar : new xn(new mc1(contentInfoPerformReceiveContent));
    }
}
