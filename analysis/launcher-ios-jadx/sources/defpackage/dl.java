package defpackage;

import android.content.ComponentName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class dl {
    public final ComponentName a;
    public final jq1 b;
    public final int c;

    public dl(ComponentName componentName, jq1 jq1Var) {
        this.a = componentName;
        this.b = jq1Var;
        this.c = Arrays.hashCode(new Object[]{componentName, jq1Var});
    }

    public boolean equals(Object obj) {
        dl dlVar = (dl) obj;
        return dlVar.a.equals(this.a) && dlVar.b.equals(this.b);
    }

    public int hashCode() {
        return this.c;
    }
}
