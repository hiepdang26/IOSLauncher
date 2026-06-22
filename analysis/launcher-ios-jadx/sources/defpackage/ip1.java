package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class ip1 implements Iterator {
    public final ArrayList g = new ArrayList();
    public Iterator h;

    public ip1(y8 y8Var) {
        this.h = y8Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.h.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object next = this.h.next();
        View view = (View) next;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        y8 y8Var = viewGroup != null ? new y8(viewGroup, 2) : null;
        ArrayList arrayList = this.g;
        if (y8Var != null && y8Var.hasNext()) {
            arrayList.add(this.h);
            this.h = y8Var;
            return next;
        }
        while (!this.h.hasNext() && !arrayList.isEmpty()) {
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            this.h = (Iterator) arrayList.get(xj.u(arrayList));
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            arrayList.remove(xj.u(arrayList));
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
