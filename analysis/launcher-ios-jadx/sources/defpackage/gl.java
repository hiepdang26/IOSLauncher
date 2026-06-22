package defpackage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class gl extends RuntimeException {
    public final List g;
    public final String h;
    public wk i;

    public gl(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof gl) {
                    linkedHashSet.addAll(((gl) th).g);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.g = listUnmodifiableList;
        this.h = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public static void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    public final void b(hg0 hg0Var) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.g) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, th, "\t");
            i++;
        }
        hg0Var.x(sb.toString());
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        try {
            if (this.i == null) {
                wk wkVar = new wk(1);
                HashSet hashSet = new HashSet();
                wk wkVar2 = wkVar;
                for (Throwable runtimeException : this.g) {
                    if (!hashSet.contains(runtimeException)) {
                        hashSet.add(runtimeException);
                        ArrayList arrayList = new ArrayList();
                        Throwable cause = runtimeException.getCause();
                        if (cause != null && cause != runtimeException) {
                            while (true) {
                                arrayList.add(cause);
                                Throwable cause2 = cause.getCause();
                                if (cause2 == null || cause2 == cause) {
                                    break;
                                }
                                cause = cause2;
                            }
                        }
                        int size = arrayList.size();
                        int i = 0;
                        while (i < size) {
                            Object obj = arrayList.get(i);
                            i++;
                            Throwable th = (Throwable) obj;
                            if (hashSet.contains(th)) {
                                runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th);
                            }
                        }
                        try {
                            wkVar2.initCause(runtimeException);
                        } catch (Throwable unused) {
                        }
                        Throwable cause3 = wkVar2.getCause();
                        if (cause3 != null && wkVar2 != cause3) {
                            while (true) {
                                Throwable cause4 = cause3.getCause();
                                if (cause4 == null || cause4 == cause3) {
                                    break;
                                }
                                cause3 = cause4;
                            }
                            wkVar2 = cause3;
                        }
                    }
                }
                this.i = wkVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.i;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.h;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        b(new fl(printStream, 0));
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        b(new fl(printWriter, 1));
    }
}
