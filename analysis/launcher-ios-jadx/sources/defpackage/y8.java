package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class y8 implements Iterator {
    public final /* synthetic */ int g;
    public int h;
    public final Object i;

    public /* synthetic */ y8(Object obj, int i) {
        this.g = i;
        this.i = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.g) {
            case 0:
                if (this.h < ((Object[]) this.i).length) {
                }
                break;
            case 1:
                if (this.h < ((wp0) this.i).size()) {
                }
                break;
            default:
                if (this.h < ((ViewGroup) this.i).getChildCount()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.g) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.i;
                    int i = this.h;
                    this.h = i + 1;
                    return objArr[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.h--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 1:
                int i2 = this.h;
                this.h = i2 + 1;
                return ((wp0) this.i).valueAt(i2);
            default:
                int i3 = this.h;
                this.h = i3 + 1;
                View childAt = ((ViewGroup) this.i).getChildAt(i3);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.g) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException();
            default:
                int i = this.h - 1;
                this.h = i;
                ((ViewGroup) this.i).removeViewAt(i);
                return;
        }
    }

    public y8(wp0 wp0Var) {
        this.g = 1;
        this.i = wp0Var;
        this.h = 0;
    }
}
