package defpackage;

import android.content.Intent;
import androidx.activity.result.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d2 extends p02 {
    public final /* synthetic */ int m;
    public final /* synthetic */ String n;
    public final /* synthetic */ a o;
    public final /* synthetic */ az1 p;

    public /* synthetic */ d2(a aVar, String str, az1 az1Var, int i) {
        this.m = i;
        this.o = aVar;
        this.n = str;
        this.p = az1Var;
    }

    public final void F(Intent intent) {
        switch (this.m) {
            case 0:
                a aVar = this.o;
                HashMap map = aVar.c;
                String str = this.n;
                Integer num = (Integer) map.get(str);
                c2 c2Var = (c2) this.p;
                if (num != null) {
                    aVar.e.add(str);
                    try {
                        aVar.b(num.intValue(), c2Var, intent);
                        return;
                    } catch (Exception e) {
                        aVar.e.remove(str);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + c2Var + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                a aVar2 = this.o;
                HashMap map2 = aVar2.c;
                String str2 = this.n;
                Integer num2 = (Integer) map2.get(str2);
                az1 az1Var = this.p;
                if (num2 != null) {
                    aVar2.e.add(str2);
                    try {
                        aVar2.b(num2.intValue(), az1Var, intent);
                        return;
                    } catch (Exception e2) {
                        aVar2.e.remove(str2);
                        throw e2;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + az1Var + " and input " + intent + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }
}
