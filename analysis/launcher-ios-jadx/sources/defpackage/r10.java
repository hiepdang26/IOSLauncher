package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class r10 extends n10 {
    public r10(byte[] bArr) {
        super(bArr);
        this.g.mark(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public final void b(long j) throws IOException {
        int i = this.h;
        if (i > j) {
            this.h = 0;
            this.g.reset();
        } else {
            j -= (long) i;
        }
        a((int) j);
    }

    public r10(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.g.mark(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
