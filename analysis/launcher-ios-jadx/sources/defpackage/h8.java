package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.service.notification.StatusBarNotification;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcherios.notification.NotificationListener;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h8 implements Handler.Callback {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ h8(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    private final boolean a(Message message) {
        if (message.what != 0) {
            return false;
        }
        fz1 fz1Var = (fz1) this.h;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (fz1Var.h) {
            throw null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Intent intent = null;
        ComponentName componentName = null;
        int i = 3;
        switch (this.g) {
            case 0:
                try {
                    q8 q8Var = ((l8) this.h).t;
                    if (q8Var != null) {
                        q8Var.m.filter((String) message.obj);
                    }
                    break;
                } catch (Throwable th) {
                    th.getMessage();
                }
                return true;
            case 1:
                int i2 = message.what;
                r80 r80Var = (r80) this.h;
                if (i2 == 1) {
                    r80Var.b((p80) message.obj);
                    return true;
                }
                if (i2 != 2) {
                    return false;
                }
                r80Var.d.n((p80) message.obj);
                return false;
            case 2:
                try {
                    int i3 = message.what;
                    t tVar = (t) this.h;
                    if (i3 != 0) {
                        if (i3 == 1) {
                            tVar.clearBadgeCount();
                            Iterator it = ((List) message.obj).iterator();
                            while (it.hasNext()) {
                                t.m(tVar, (String) it.next());
                            }
                            tVar.mUiHandler.obtainMessage(message.what).sendToTarget();
                        } else if (i3 == 3) {
                            try {
                                BubbleTextView bubbleTextView = (BubbleTextView) message.obj;
                                if (tVar.mSearchView != null && bubbleTextView != null) {
                                    Object tag = bubbleTextView.getTag();
                                    if (tag instanceof og1) {
                                        intent = ((og1) tag).x;
                                    } else if (tag instanceof v6) {
                                        intent = ((v6) tag).x;
                                    }
                                    if (intent != null && intent.getComponent() != null) {
                                        String strFlattenToString = intent.getComponent().flattenToString();
                                        if (tVar.mSearchView != null) {
                                            SearchViewLayout searchViewLayout = tVar.mSearchView;
                                            searchViewLayout.getClass();
                                            try {
                                                new ur0(new f8(searchViewLayout, strFlattenToString, i)).B(ee1.a).z(new vr0(new ow1(searchViewLayout, 25), x4.a(), 0));
                                            } catch (NullPointerException e) {
                                                throw e;
                                            } catch (Throwable th2) {
                                                hg0.C(th2);
                                                NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                                                nullPointerException.initCause(th2);
                                                throw nullPointerException;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th3.getMessage();
                            }
                        }
                        break;
                    } else {
                        tVar.clearBadgeCount();
                        tVar.mUiHandler.obtainMessage(message.what).sendToTarget();
                    }
                    return true;
                } catch (Throwable th4) {
                    th4.getMessage();
                    return false;
                }
            case 3:
                NotificationListener notificationListener = (NotificationListener) this.h;
                try {
                    int i4 = message.what;
                    Handler handler = notificationListener.i;
                    if (i4 == 1 || i4 == 2) {
                        handler.obtainMessage(i4, message.obj).sendToTarget();
                    } else if (i4 == 3) {
                        ArrayList arrayListA = NotificationListener.a(notificationListener, notificationListener.getActiveNotifications());
                        if (arrayListA == null || arrayListA.size() <= 0) {
                            handler.obtainMessage(message.what).sendToTarget();
                        } else {
                            ArrayList arrayList = new ArrayList();
                            int size = arrayListA.size();
                            int i5 = 0;
                            while (i5 < size) {
                                Object obj = arrayListA.get(i5);
                                i5++;
                                StatusBarNotification statusBarNotification = (StatusBarNotification) obj;
                                if (statusBarNotification != null) {
                                    arrayList.add(statusBarNotification.getPackageName());
                                }
                            }
                            handler.obtainMessage(message.what, arrayList).sendToTarget();
                        }
                    }
                    return true;
                } catch (Throwable th5) {
                    th5.getMessage();
                    return false;
                }
            case 4:
                try {
                    ue1 ue1Var = ((SearchViewLayout) this.h).w;
                    if (ue1Var != null) {
                        ue1Var.n.filter((String) message.obj);
                    }
                    break;
                } catch (Throwable th6) {
                    int i6 = SearchViewLayout.C;
                    th6.getMessage();
                }
                return true;
            case 5:
                return a(message);
            default:
                int i7 = message.what;
                if (i7 != 0) {
                    if (i7 != 1) {
                        return false;
                    }
                    synchronized (((ad2) this.h).d) {
                        try {
                            kc2 kc2Var = (kc2) message.obj;
                            oc2 oc2Var = (oc2) ((ad2) this.h).d.get(kc2Var);
                            if (oc2Var != null && oc2Var.b == 3) {
                                String.valueOf(kc2Var);
                                new Exception();
                                ComponentName componentName2 = oc2Var.f;
                                if (componentName2 == null) {
                                    kc2Var.getClass();
                                } else {
                                    componentName = componentName2;
                                }
                                if (componentName == null) {
                                    String str = kc2Var.b;
                                    hg0.i(str);
                                    componentName = new ComponentName(str, "unknown");
                                }
                                oc2Var.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                        break;
                    }
                } else {
                    synchronized (((ad2) this.h).d) {
                        try {
                            kc2 kc2Var2 = (kc2) message.obj;
                            oc2 oc2Var2 = (oc2) ((ad2) this.h).d.get(kc2Var2);
                            if (oc2Var2 != null && oc2Var2.a.isEmpty()) {
                                if (oc2Var2.c) {
                                    oc2Var2.g.f.removeMessages(1, oc2Var2.e);
                                    ad2 ad2Var = oc2Var2.g;
                                    ad2Var.g.b(ad2Var.e, oc2Var2);
                                    oc2Var2.c = false;
                                    oc2Var2.b = 2;
                                }
                                ((ad2) this.h).d.remove(kc2Var2);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return true;
        }
    }
}
