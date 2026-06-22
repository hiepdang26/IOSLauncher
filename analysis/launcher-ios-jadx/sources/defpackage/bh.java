package defpackage;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class bh implements Comparator {
    public int g = 0;
    public final /* synthetic */ ch h;

    public bh(ch chVar) {
        this.h = chVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ch chVar = this.h;
        wg wgVar = (wg) chVar.b.a.get((View) obj);
        wg wgVar2 = (wg) chVar.b.a.get((View) obj2);
        int i6 = this.g;
        if (i6 == 0) {
            i = wgVar2.a + wgVar2.c;
            i2 = wgVar.a;
            i3 = wgVar.c;
        } else {
            if (i6 != 1) {
                if (i6 != 2) {
                    i4 = wgVar.b;
                    i5 = wgVar2.b;
                } else {
                    i4 = wgVar.a;
                    i5 = wgVar2.a;
                }
                return i4 - i5;
            }
            i = wgVar2.b + wgVar2.d;
            i2 = wgVar.b;
            i3 = wgVar.d;
        }
        return i - (i2 + i3);
    }
}
