package defpackage;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q90 extends Exception {
    public static final StackTraceElement[] l = new StackTraceElement[0];
    public final List g;
    public bj0 h;
    public int i;
    public Class j;
    public final String k;

    public q90(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (!(th instanceof q90)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((q90) th).g.iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), arrayList);
        }
    }

    public static void b(List list, p90 p90Var) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            p90Var.append("Cause (");
            int i2 = i + 1;
            p90Var.append(String.valueOf(i2));
            p90Var.append(" of ");
            p90Var.append(String.valueOf(size));
            p90Var.append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof q90) {
                ((q90) th).d(p90Var);
            } else {
                c(th, p90Var);
            }
            i = i2;
        }
    }

    public static void c(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public final void d(Appendable appendable) {
        c(this, appendable);
        try {
            b(this.g, new p90(appendable));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String strConcat;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.k);
        String str2 = "";
        if (this.j != null) {
            str = ", " + this.j;
        } else {
            str = "";
        }
        sb.append(str);
        int i = this.i;
        if (i != 0) {
            strConcat = ", ".concat(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL");
        } else {
            strConcat = "";
        }
        sb.append(strConcat);
        if (this.h != null) {
            str2 = ", " + this.h;
        }
        sb.append(str2);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Throwable th = (Throwable) obj;
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        d(System.err);
    }

    public q90(String str, List list) {
        this.k = str;
        setStackTrace(l);
        this.g = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        d(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        d(printWriter);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
