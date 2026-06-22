package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class rn0 implements Iterator {
    public final String g;
    public int h;
    public int i;
    public int j;
    public int k;

    public rn0(String str) {
        this.g = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i2;
        int i3 = this.h;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.k < 0) {
            this.h = 2;
            return false;
        }
        String str = this.g;
        int length = str.length();
        int length2 = str.length();
        for (int i4 = this.i; i4 < length2; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < str.length() && str.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.h = 1;
                this.k = i;
                this.j = length;
                return true;
            }
        }
        i = -1;
        this.h = 1;
        this.k = i;
        this.j = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.h = 0;
        int i = this.j;
        int i2 = this.i;
        this.i = this.k + i;
        return this.g.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
