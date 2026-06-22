package defpackage;

import androidx.constraintlayout.motion.widget.MotionScene;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.Workspace;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class se implements my0 {
    public static final y4 k = new y4(1);
    public int g;
    public final Object h;
    public final int i;
    public final Object j;

    public se(int i, ArrayList arrayList, int i2, InputStream inputStream) {
        this.g = i;
        this.h = arrayList;
        this.i = i2;
        this.j = inputStream;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < ((ArrayList) this.j).size(); i2++) {
            byte[] bArr = (byte[]) ((ArrayList) this.j).get(i2);
            if (bArr.length >= i) {
                this.g -= bArr.length;
                ((ArrayList) this.j).remove(i2);
                ((ArrayList) this.h).remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.i) {
                ((ArrayList) this.h).add(bArr);
                int iBinarySearch = Collections.binarySearch((ArrayList) this.j, bArr, k);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                ((ArrayList) this.j).add(iBinarySearch, bArr);
                this.g += bArr.length;
                c();
            }
        }
    }

    public synchronized void c() {
        while (this.g > this.i) {
            byte[] bArr = (byte[]) ((ArrayList) this.h).remove(0);
            ((ArrayList) this.j).remove(bArr);
            this.g -= bArr.length;
        }
    }

    @Override // defpackage.my0
    public void p(g3 g3Var) {
        Objects.toString(g3Var);
        Workspace workspace = (Workspace) this.j;
        t40 t40Var = workspace.q1;
        if (t40Var != null) {
            t40Var.b();
        }
        t40 t40Var2 = new t40(workspace.S0, null);
        workspace.q1 = t40Var2;
        t40Var2.a = this.g;
        t40Var2.b = this.i;
        CellLayout cellLayout = (CellLayout) this.h;
        Objects.toString(cellLayout);
        t40Var2.c = cellLayout;
        workspace.q1.a();
        cellLayout.G(workspace.q1);
        workspace.setDragMode(1);
    }

    public se() {
        this.h = new ArrayList();
        this.j = new ArrayList(64);
        this.g = 0;
        this.i = MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
    }

    public se(Workspace workspace, CellLayout cellLayout, int i, int i2) {
        this.j = workspace;
        this.h = cellLayout;
        this.g = i;
        this.i = i2;
    }
}
