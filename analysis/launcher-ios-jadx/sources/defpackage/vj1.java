package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class vj1 extends IOException {
    public final int g;

    /* JADX WARN: Illegal instructions before constructor call */
    public vj1(int i) {
        String str;
        switch (i) {
            case 1:
                str = "NO_ERROR";
                break;
            case 2:
                str = "PROTOCOL_ERROR";
                break;
            case 3:
                str = "INTERNAL_ERROR";
                break;
            case 4:
                str = "FLOW_CONTROL_ERROR";
                break;
            case 5:
                str = "REFUSED_STREAM";
                break;
            case 6:
                str = "CANCEL";
                break;
            case 7:
                str = "COMPRESSION_ERROR";
                break;
            case 8:
                str = "CONNECT_ERROR";
                break;
            case 9:
                str = "ENHANCE_YOUR_CALM";
                break;
            case 10:
                str = "INADEQUATE_SECURITY";
                break;
            case 11:
                str = "HTTP_1_1_REQUIRED";
                break;
            default:
                str = "null";
                break;
        }
        super("stream was reset: ".concat(str));
        this.g = i;
    }
}
