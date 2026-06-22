package defpackage;

import android.content.ContentProviderClient;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class uo {
    public static final /* synthetic */ int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static /* synthetic */ int a(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            case 10:
                return 12;
            case 11:
                return 13;
            default:
                throw null;
        }
    }

    public static float b(float f, float f2, float f3, float f4) {
        return Math.max(f3, f - f2) + f4;
    }

    public static ClassCastException c(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String d(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String e(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.F());
        return sb.toString();
    }

    public static String f(String str, long j) {
        return str + j;
    }

    public static String g(String str, w50 w50Var, String str2) {
        return str + w50Var + str2;
    }

    public static String h(String str, String str2) {
        return str + str2;
    }

    public static String i(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String j(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String k(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder l(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder m(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder n(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder o(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static /* synthetic */ void p(int i, String str) {
        if (i != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(qg0.p(str));
        qg0.G(nullPointerException, qg0.class.getName());
        throw nullPointerException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(ContentProviderClient contentProviderClient) throws Exception {
        if (contentProviderClient instanceof AutoCloseable) {
            contentProviderClient.close();
        } else if (contentProviderClient instanceof ExecutorService) {
            e.y((ExecutorService) contentProviderClient);
        } else {
            contentProviderClient.release();
        }
    }

    public static /* synthetic */ boolean r(Object obj) {
        return obj != null;
    }

    public static float s(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String t(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ String u(int i) {
        switch (i) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int v(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String w(int i) {
        switch (i) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String x(int i) {
        switch (i) {
            case 1:
                return "NOT_REQUIRED";
            case 2:
                return "CONNECTED";
            case 3:
                return "UNMETERED";
            case 4:
                return "NOT_ROAMING";
            case 5:
                return "METERED";
            case 6:
                return "TEMPORARILY_UNMETERED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int[] y(int i) {
        int[] iArr = new int[i];
        System.arraycopy(a, 0, iArr, 0, i);
        return iArr;
    }
}
