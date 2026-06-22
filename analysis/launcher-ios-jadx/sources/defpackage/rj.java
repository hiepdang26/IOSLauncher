package defpackage;

import androidx.appcompat.widget.ActivityChooserView;

/* JADX INFO: loaded from: classes.dex */
public final class rj {
    public final byte[] a;
    public int b;
    public int c;
    public int e;
    public int g;
    public int f = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public int d = 0;

    public rj(byte[] bArr, int i) {
        this.a = bArr;
        this.b = i;
    }

    public final byte[] a() throws tg0 {
        int iG = g();
        int i = this.b;
        int i2 = this.d;
        if (iG > i - i2 || iG <= 0) {
            return iG == 0 ? az1.c : e(iG);
        }
        byte[] bArr = new byte[iG];
        System.arraycopy(this.a, i2, bArr, 0, iG);
        this.d += iG;
        return bArr;
    }

    public final long b() throws tg0 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bD = d();
            j |= ((long) (bD & 127)) << i;
            if ((bD & 128) == 0) {
                return j;
            }
        }
        throw new tg0("CodedInputStream encountered a malformed varint.");
    }

    public final void c(au0 au0Var) throws tg0 {
        int iG = g();
        int i = this.g;
        if (i >= 64) {
            throw new tg0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (iG < 0) {
            throw new tg0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = iG + this.d;
        int i3 = this.f;
        if (i2 > i3) {
            throw tg0.a();
        }
        this.f = i2;
        int i4 = this.b + this.c;
        this.b = i4;
        if (i4 > i2) {
            int i5 = i4 - i2;
            this.c = i5;
            this.b = i4 - i5;
        } else {
            this.c = 0;
        }
        this.g = i + 1;
        au0Var.b(this);
        if (this.e != 0) {
            throw new tg0("Protocol message end-group tag did not match expected tag.");
        }
        this.g--;
        this.f = i3;
        int i6 = this.b + this.c;
        this.b = i6;
        if (i6 <= i3) {
            this.c = 0;
            return;
        }
        int i7 = i6 - i3;
        this.c = i7;
        this.b = i6 - i7;
    }

    public final byte d() throws tg0 {
        int i = this.d;
        if (i == this.b) {
            throw tg0.a();
        }
        this.d = i + 1;
        return this.a[i];
    }

    public final byte[] e(int i) throws tg0 {
        if (i < 0) {
            throw new tg0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.d;
        int i3 = i2 + i;
        int i4 = this.f;
        if (i3 > i4) {
            k(i4 - i2);
            throw tg0.a();
        }
        if (i > this.b - i2) {
            throw tg0.a();
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.a, i2, bArr, 0, i);
        this.d += i;
        return bArr;
    }

    public final int f() throws tg0 {
        return (d() & 255) | ((d() & 255) << 8) | ((d() & 255) << 16) | ((d() & 255) << 24);
    }

    public final int g() throws tg0 {
        int i;
        byte bD = d();
        if (bD >= 0) {
            return bD;
        }
        int i2 = bD & 127;
        byte bD2 = d();
        if (bD2 >= 0) {
            i = bD2 << 7;
        } else {
            i2 |= (bD2 & 127) << 7;
            byte bD3 = d();
            if (bD3 >= 0) {
                i = bD3 << 14;
            } else {
                i2 |= (bD3 & 127) << 14;
                byte bD4 = d();
                if (bD4 < 0) {
                    int i3 = i2 | ((bD4 & 127) << 21);
                    byte bD5 = d();
                    int i4 = i3 | (bD5 << 28);
                    if (bD5 < 0) {
                        for (int i5 = 0; i5 < 5; i5++) {
                            if (d() < 0) {
                            }
                        }
                        throw new tg0("CodedInputStream encountered a malformed varint.");
                    }
                    return i4;
                }
                i = bD4 << 21;
            }
        }
        return i2 | i;
    }

    public final String h() throws tg0 {
        int iG = g();
        int i = this.b;
        int i2 = this.d;
        if (iG > i - i2 || iG <= 0) {
            return new String(e(iG), ng0.a);
        }
        String str = new String(this.a, i2, iG, ng0.a);
        this.d += iG;
        return str;
    }

    public final int i() throws tg0 {
        if (this.d == this.b) {
            this.e = 0;
            return 0;
        }
        int iG = g();
        this.e = iG;
        if (iG != 0) {
            return iG;
        }
        throw new tg0("Protocol message contained an invalid tag (zero).");
    }

    public final boolean j(int i) throws tg0 {
        int i2;
        int i3 = i & 7;
        if (i3 == 0) {
            g();
            return true;
        }
        if (i3 == 1) {
            d();
            d();
            d();
            d();
            d();
            d();
            d();
            d();
            return true;
        }
        if (i3 == 2) {
            k(g());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw new tg0("Protocol message tag had invalid wire type.");
            }
            f();
            return true;
        }
        do {
            i2 = i();
            if (i2 == 0) {
                break;
            }
        } while (j(i2));
        if (this.e == (((i >>> 3) << 3) | 4)) {
            return true;
        }
        throw new tg0("Protocol message end-group tag did not match expected tag.");
    }

    public final void k(int i) throws tg0 {
        if (i < 0) {
            throw new tg0("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.d;
        int i3 = i2 + i;
        int i4 = this.f;
        if (i3 > i4) {
            k(i4 - i2);
            throw tg0.a();
        }
        if (i > this.b - i2) {
            throw tg0.a();
        }
        this.d = i3;
    }
}
