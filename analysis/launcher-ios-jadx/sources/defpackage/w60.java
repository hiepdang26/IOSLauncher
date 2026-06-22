package defpackage;

import android.content.Context;
import android.os.Build;
import androidx.activity.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class w60 extends jj0 implements d70 {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w60(Object obj, int i) {
        super(0);
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.d70
    public final Object c() {
        v60 v60Var;
        switch (this.g) {
            case 0:
                int i = Build.VERSION.SDK_INT;
                x60 x60Var = (x60) this.h;
                if (i < 23 || x60Var.h == null || !x60Var.j) {
                    v60Var = new v60(x60Var.g, x60Var.h, new ow1(16), x60Var.i, x60Var.k);
                } else {
                    Context context = x60Var.g;
                    qg0.l(context, "context");
                    File noBackupFilesDir = context.getNoBackupFilesDir();
                    qg0.k(noBackupFilesDir, "context.noBackupFilesDir");
                    v60Var = new v60(x60Var.g, new File(noBackupFilesDir, x60Var.h).getAbsolutePath(), new ow1(16), x60Var.i, x60Var.k);
                }
                v60Var.setWriteAheadLoggingEnabled(x60Var.m);
                return v60Var;
            case 1:
                a aVar = (a) this.h;
                ArrayList arrayList = new ArrayList();
                u91.a.getClass();
                Class clsA = new zi(kd1.class).a();
                qg0.i(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
                arrayList.add(new bt1(clsA));
                bt1[] bt1VarArr = (bt1[]) arrayList.toArray(new bt1[0]);
                bt1[] bt1VarArr2 = (bt1[]) Arrays.copyOf(bt1VarArr, bt1VarArr.length);
                qg0.l(bt1VarArr2, "initializers");
                ct1 ct1VarJ = aVar.j();
                fb fbVarH = aVar.h();
                qg0.l(ct1VarJ, "store");
                qg0.l(fbVarH, "defaultCreationExtras");
                LinkedHashMap linkedHashMap = ct1VarJ.a;
                at1 kd1Var = (at1) linkedHashMap.get("androidx.lifecycle.internal.SavedStateHandlesVM");
                if (kd1.class.isInstance(kd1Var)) {
                    qg0.i(kd1Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
                } else {
                    ((LinkedHashMap) new jv0(fbVarH).g).put(jl1.m, "androidx.lifecycle.internal.SavedStateHandlesVM");
                    try {
                        kd1Var = null;
                        for (bt1 bt1Var : bt1VarArr2) {
                            if (bt1Var.a.equals(kd1.class)) {
                                kd1Var = new kd1();
                            }
                        }
                        if (kd1Var == null) {
                            throw new IllegalArgumentException("No initializer set for given class ".concat(kd1.class.getName()));
                        }
                        at1 at1Var = (at1) linkedHashMap.put("androidx.lifecycle.internal.SavedStateHandlesVM", kd1Var);
                        if (at1Var != null) {
                            at1Var.a();
                        }
                    } catch (AbstractMethodError unused) {
                        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
                    }
                }
                return (kd1) kd1Var;
            case 2:
                return ((ig1) this.h).b();
            default:
                return new sn[((a40[]) this.h).length];
        }
    }
}
