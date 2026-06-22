package defpackage;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b91 {
    public SparseArray a;
    public int b;
    public Set c;

    public final a91 a(int i) {
        SparseArray sparseArray = this.a;
        a91 a91Var = (a91) sparseArray.get(i);
        if (a91Var != null) {
            return a91Var;
        }
        a91 a91Var2 = new a91();
        sparseArray.put(i, a91Var2);
        return a91Var2;
    }

    public final void b(int i, int i2) {
        a91 a91VarA = a(i);
        a91VarA.b = i2;
        ArrayList arrayList = a91VarA.a;
        while (arrayList.size() > i2) {
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
