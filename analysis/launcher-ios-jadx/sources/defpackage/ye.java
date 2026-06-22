package defpackage;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.a;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class ye implements fs {
    public final /* synthetic */ int a;

    public /* synthetic */ ye(int i) {
        this.a = i;
    }

    @Override // defpackage.fs
    public final Class a() {
        switch (this.a) {
            case 0:
                return ByteBuffer.class;
            case 1:
                throw new UnsupportedOperationException("Not implemented");
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // defpackage.fs
    public final gs b(Object obj) {
        switch (this.a) {
            case 0:
                return new ze((ByteBuffer) obj);
            case 1:
                return new hs(obj);
            default:
                return new a((ParcelFileDescriptor) obj);
        }
    }
}
