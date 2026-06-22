package defpackage;

import android.content.ComponentName;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class fx1 extends dl {
    public final String d;

    public fx1(ComponentName componentName, jq1 jq1Var, String str) {
        super(componentName, jq1Var);
        this.d = str;
    }

    @Override // defpackage.dl
    public final boolean equals(Object obj) {
        Objects.toString(obj);
        return super.equals(obj) && ((fx1) obj).d.equals(this.d);
    }

    @Override // defpackage.dl
    public final int hashCode() {
        return this.d.hashCode() ^ this.c;
    }
}
