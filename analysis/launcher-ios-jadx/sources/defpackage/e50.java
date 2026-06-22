package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class e50 implements Callable {
    public final /* synthetic */ int g;
    public final /* synthetic */ String h;
    public final /* synthetic */ Context i;
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public /* synthetic */ e50(String str, Context context, Object obj, int i, int i2) {
        this.g = i2;
        this.h = str;
        this.i = context;
        this.k = obj;
        this.j = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.j;
        Object obj = this.k;
        Context context = this.i;
        String str = this.h;
        switch (this.g) {
            case 0:
                Object[] objArr = {(b50) obj};
                ArrayList arrayList = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList.add(obj2);
                return h50.b(str, context, Collections.unmodifiableList(arrayList), i);
            default:
                try {
                    return h50.b(str, context, (List) obj, i);
                } catch (Throwable unused) {
                    return new g50(-3);
                }
        }
    }
}
