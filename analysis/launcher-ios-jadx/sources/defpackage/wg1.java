package defpackage;

import android.util.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class wg1 implements yk1, nb2 {
    public final /* synthetic */ int g;
    public String h;

    @Override // defpackage.nb2
    public void a(JsonWriter jsonWriter) throws IOException {
        Object obj = ub2.b;
        jsonWriter.name("params").beginObject();
        String str = this.h;
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    @Override // defpackage.yk1
    public String b() {
        return this.h;
    }

    public String toString() {
        switch (this.g) {
            case 1:
                return "<" + this.h + '>';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ wg1(String str, int i) {
        this.g = i;
        this.h = str;
    }

    public wg1(String str) {
        this.g = 0;
        qg0.l(str, "query");
        this.h = str;
    }

    @Override // defpackage.yk1
    public void h(xk1 xk1Var) {
    }
}
