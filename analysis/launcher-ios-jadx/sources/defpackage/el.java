package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class el implements cw {
    public final /* synthetic */ int g;
    public volatile boolean h;
    public Object i;

    public /* synthetic */ el(int i) {
        this.g = i;
    }

    private final boolean c(cw cwVar) {
        if (!this.h) {
            synchronized (this) {
                try {
                    if (!this.h) {
                        c80 c80Var = (c80) this.i;
                        if (c80Var == null) {
                            c80Var = new c80();
                            int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(15));
                            c80Var.a = iNumberOfLeadingZeros - 1;
                            c80Var.c = (int) (0.75f * iNumberOfLeadingZeros);
                            c80Var.d = new Object[iNumberOfLeadingZeros];
                            this.i = c80Var;
                        }
                        c80Var.a(cwVar);
                        return true;
                    }
                } finally {
                }
            }
        }
        cwVar.b();
        return false;
    }

    private final boolean e(cw cwVar) {
        Object obj;
        if (this.h) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.h) {
                    return false;
                }
                c80 c80Var = (c80) this.i;
                if (c80Var != null) {
                    Object[] objArr = (Object[]) c80Var.d;
                    int i = c80Var.a;
                    int iHashCode = cwVar.hashCode() * (-1640531527);
                    int i2 = (iHashCode ^ (iHashCode >>> 16)) & i;
                    Object obj2 = objArr[i2];
                    if (obj2 != null) {
                        if (obj2.equals(cwVar)) {
                            c80Var.d(i2, i, objArr);
                        } else {
                            do {
                                i2 = (i2 + 1) & i;
                                obj = objArr[i2];
                                if (obj == null) {
                                }
                            } while (!obj.equals(cwVar));
                            c80Var.d(i2, i, objArr);
                        }
                        return true;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    private final void f() {
        if (this.h) {
            return;
        }
        synchronized (this) {
            try {
                if (this.h) {
                    return;
                }
                this.h = true;
                c80 c80Var = (c80) this.i;
                ArrayList arrayList = null;
                this.i = null;
                if (c80Var == null) {
                    return;
                }
                for (Object obj : (Object[]) c80Var.d) {
                    if (obj instanceof cw) {
                        try {
                            ((cw) obj).b();
                        } catch (Throwable th) {
                            hg0.C(th);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(th);
                        }
                    }
                }
                if (arrayList != null) {
                    if (arrayList.size() != 1) {
                        throw new gl(arrayList);
                    }
                    throw a10.a((Throwable) arrayList.get(0));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean a(cw cwVar) {
        switch (this.g) {
            case 0:
                return c(cwVar);
            default:
                if (!this.h) {
                    synchronized (this) {
                        try {
                            if (!this.h) {
                                LinkedList linkedList = (LinkedList) this.i;
                                if (linkedList == null) {
                                    linkedList = new LinkedList();
                                    this.i = linkedList;
                                }
                                linkedList.add(cwVar);
                                return true;
                            }
                        } finally {
                        }
                    }
                }
                cwVar.b();
                return false;
        }
    }

    @Override // defpackage.cw
    public final void b() {
        switch (this.g) {
            case 0:
                f();
                return;
            default:
                if (this.h) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (!this.h) {
                            this.h = true;
                            LinkedList linkedList = (LinkedList) this.i;
                            ArrayList arrayList = null;
                            this.i = null;
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    try {
                                        ((cw) it.next()).b();
                                    } catch (Throwable th) {
                                        hg0.C(th);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(th);
                                    }
                                }
                                if (arrayList != null) {
                                    if (arrayList.size() != 1) {
                                        throw new gl(arrayList);
                                    }
                                    throw a10.a((Throwable) arrayList.get(0));
                                }
                            }
                        }
                    } finally {
                    }
                }
                return;
        }
    }

    public final boolean d(cw cwVar) {
        switch (this.g) {
            case 0:
                return e(cwVar);
            default:
                boolean z = false;
                if (!this.h) {
                    synchronized (this) {
                        try {
                            if (!this.h) {
                                LinkedList linkedList = (LinkedList) this.i;
                                if (linkedList != null && linkedList.remove(cwVar)) {
                                    z = true;
                                }
                            }
                        } finally {
                        }
                    }
                    break;
                }
                return z;
        }
    }

    public final boolean g(cw cwVar) {
        switch (this.g) {
            case 0:
                if (d(cwVar)) {
                    cwVar.b();
                }
                break;
            default:
                if (d(cwVar)) {
                    ((qd1) cwVar).b();
                }
                break;
        }
        return true;
    }
}
