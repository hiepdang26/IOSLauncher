package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public final class dk {
    public final int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final /* synthetic */ ek j;

    public dk(ek ekVar, int i, int i2) {
        this.j = ekVar;
        this.a = i;
        this.b = i2;
        a();
    }

    public final void a() {
        ek ekVar = this.j;
        int[] iArr = (int[]) ekVar.h;
        int[] iArr2 = (int[]) ekVar.i;
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i4 = RtlSpacingHelper.UNDEFINED;
        int i5 = RtlSpacingHelper.UNDEFINED;
        int i6 = RtlSpacingHelper.UNDEFINED;
        int i7 = 0;
        for (int i8 = this.a; i8 <= this.b; i8++) {
            int i9 = iArr[i8];
            i7 += iArr2[i9];
            int i10 = (i9 >> 10) & 31;
            int i11 = (i9 >> 5) & 31;
            int i12 = i9 & 31;
            if (i10 > i4) {
                i4 = i10;
            }
            if (i10 < i) {
                i = i10;
            }
            if (i11 > i5) {
                i5 = i11;
            }
            if (i11 < i2) {
                i2 = i11;
            }
            if (i12 > i6) {
                i6 = i12;
            }
            if (i12 < i3) {
                i3 = i12;
            }
        }
        this.d = i;
        this.e = i4;
        this.f = i2;
        this.g = i5;
        this.h = i3;
        this.i = i6;
        this.c = i7;
    }

    public final int b() {
        return ((this.i - this.h) + 1) * ((this.g - this.f) + 1) * ((this.e - this.d) + 1);
    }
}
