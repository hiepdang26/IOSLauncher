package defpackage;

import android.database.Cursor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class o1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ o1(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    public lf1 a() throws IOException {
        vg0 vg0Var = (vg0) this.h;
        lf1 lf1Var = new lf1();
        Cursor cursorL = vg0Var.a.l(new wg1("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        while (cursorL.moveToNext()) {
            try {
                lf1Var.add(Integer.valueOf(cursorL.getInt(0)));
            } finally {
            }
        }
        cursorL.close();
        lf1 lf1VarD = hs0.d(lf1Var);
        if (lf1VarD.g.isEmpty()) {
            return lf1VarD;
        }
        if (((vg0) this.h).g == null) {
            throw new IllegalStateException("Required value was null.");
        }
        z60 z60Var = ((vg0) this.h).g;
        if (z60Var == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        z60Var.a();
        return lf1VarD;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o1.run():void");
    }
}
