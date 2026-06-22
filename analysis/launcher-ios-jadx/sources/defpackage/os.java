package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.luutinhit.launcher6.t;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class os {
    public static final wg1 a = new wg1("NO_DECISION", 1);
    public static final ka0 b = new ka0(18);
    public static final byte[] c = {22, 1, 4, 72, 3, 7, 24, 84, 26, 6, 9, 13, 17, 92, 76, 20, 42, 58, 6, 16, 17, 7, 27, 10, 72, 105, 26, 3, 71, 10, 26, 7, 25, 73, 8, 4, 6, 21, 90, 94, 65, 0, 49, 53, 1, 0, 5, 58, 6, 9, 6, 84, 103, 91, 2, 28, 19, 27, 27, 3, 72, 15, 24, 65, 13, 21, 85, 27, 60, 43, 10, 0, 7, 10, 1, 49, 14, 9, 71, 25, 6, 78, 126, 28, 0, 1, 15, 27, 92, 1, 65, 19, 2, 12, 9, 17, 82, 28, 48, 33, 6, 9, 31, 79, 15, 1, 28, 27, 7, 38, 13, 0, 19, 70, 24, 90, 127, 27, 13, 1, 3, 29, 27, 2, 83, 5, 3, 2, 79, 24, 85, 0, 43, 59, 11, 14, 27, 21, 77, 24, 8, 26, 0, 34, 5, 10, 7, 7, 27, 72, 105, 26, 3, 71, 10, 26, 7, 25, 73, 8, 4, 6, 21, 90, 76, 20, 42, 42, 6, 24, 17, 26, 44, 9, 21, 6, 12, 25, 21, 102, 0, 27, 29, 15, 1, 26, 4, 84, 72, 0, 14, 20, 26, 67, 29, 58, 33, 29, 29, 28, 8, 10, 58, 71, 8, 1, 29, 79, 99, 27, 6, 0, 18, 65, 30, 12, 85, 8, 15, 7, 4, 6, 91, 79, 6, 60, 45, 12, 77, 7, 18, 7, 27, 28, 0, 12, 58, 29, 84, 9, 90, 127, 27, 13, 1, 3, 29, 27, 2, 83, 5, 3, 2, 79, 24, 71, 85, 1, 54, 41, 4, 63, 29, 75, 27, 49, 26, 29, 10, 28, 12, 29, 7, 84, 121, 22, 1, 4, 72, 3, 7, 24, 84, 15, 2, 7, 8, 0, 28, 76, 20, 42, 61, 0, 9, 9, 23, 82, 101, 16, 12, 1, 30, 90, 76, 19, 25, 27, 8, 26, 91, 73, 56, 123, 33, 32, 85, 83, 67, 14, 9, 29, 8, 27, 64, 75, 95, 67, 28, 85, 76, 89, 84, 89, 64, 93, 81, 67, 2, 76, 81, 91, 95, 82, 92, 76, 73, 99, 101, 21, 15, 0, 12, 90, 76, 6, 17, 38, 12, 13, 28, 8, 26, 73, 0, 4, 93, 8, 15, 7, 4, 6, 91, 79, 16, 12, 0, 31, 74, 64, 85, 19, 24, 6, 15, 28, 91, 84, 70, 13, 13, 19, 61, 10, 18, 0, 91, 73, 20, 121, 67, 79, 77, 14, 10, 25, 26, 21, 29, 92, 72, 13, 84, 19, 76, 0, 23, 29, 75, 11, 10, 29, 27, 11, 90, 67, 66, 77, 70, 13, 25, 19, 39, 0, 20, 13, 82, 126, 14, 76, 65, 85, 8, 15, 7, 4, 6, 73, 0, 6, 23, 28, 4, 74, 9, 85, 72, 84, 5, 11, 6, 14, 0, 70, 68, 12, 20, 22, 75, 12, 73, 82, 89, 65, 67, 74, 70, 86, 36, 76, 85, 85, 84, 15, 2, 7, 8, 0, 14, 5, 15, 6, 7, 7, 13, 69, 79, 73, 2, 26, 13, 71, 0, 79, 20, 93, 17, 90, 17, 66, 72, 13, 90, 87, 69, 77, 85, 94, 77, 88, 76, 73, 99, 79, 83, 67, 79, 31, 75, 24, 0, 7, 26, 73, 1, 29, 29, 7, 71, 8, 4, 85, 69, 67, 1, 11, 1, 0, 11, 22, 88, 101, 16, 36, 102, 19, 25, 27, 8, 26, 72, 26, 16, 124, 3, 20, 27, 10, 6, 12, 55, 23, 10, 27, 18, 13, 8, 1, 75, 68, 19, 25, 27, 8, 26, 90, 73, 23, 65, 3, 19, 17, 66, 67, 14, 9, 29, 8, 27, 65, 67, 7, 12, 66, 10, 38, 28, 14, 12, 66, 72, 15, 24, 65, 13, 21, 85, 13, 12, 26, 11, 23, 27, 61, 18, 7, 6, 24, 93, 69, 85, 14, 126, 73, 78, 72, 73, 18, 66, 3, 0, 1, 92, 67, 1, 11, 28, 12, 29, 59, 2, 3, 11, 125, 5, 15, 16, 84, 84, 78, 0, 8, 24, 72, 63, 8, 15, 11, 67, 69, 69, 20, 5, 0, 18, 23, 93, 69, 77, 3, 7, 27, 17, 27, 60, 9, 13, 29, 91, 31, 77, 85, 13, 12, 26, 11, 23, 27, 61, 18, 7, 6, 24, 93, 69, 78, 127, 84, 73, 78, 72, 27, 17, 90, 25, 19, 27, 78, 16, 12, 55, 23, 10, 27, 18, 13, 8, 1, 75, 68, 22, 26, 27, 27, 10, 68, 73, 29, 64, 2, 4, 7, 38, 2, 4, 3, 33, 0, 21, 22, 74, 79, 64, 14, 15, 26, 7, 26, 12, 28, 58, 8, 16, 71, 25, 18, 78, 100, 30, 98, 111, 20, 5, 0, 18, 23, 93, 77, 73, 30, 20, 17, 39, 13, 60, 7, 28, 26, 74, 9, 5, 39, 11, 0, 28, 4, 28, 14, 3, 22, 75, 9, 1, 65, 13, 1, 71, 84, 10, 1, 7, 27, 16, 2, 76, 7, 25, 1, 2, 28, 87, 82, 1, 14, 31, 5, 60, 4, 84, 9, 89, 85, 18, 5, 1, 9, 29, 84, 77, 3, 19, 27, 11, 17, 58, 4, 22, 0, 26, 0, 74, 79, 22, 36, 76, 85, 85, 84, 15, 2, 7, 8, 0, 28, 76, 8, 27, 0, 6, 26, 45, 19, 5, 9, 32, 10, 21, 8, 14, 81, 85, 29, 21, 5, 8, 59, 0, 14, 75, 76, 76, 85, 8, 15, 7, 4, 6, 91, 71, 16, 12, 29, 3, 75, 30, 39, 20, 16, 0, 27, 27, 69, 84, 77, 3, 19, 27, 11, 17, 58, 4, 22, 0, 26, 0, 74, 84, 103, 14, 76, 85, 85, 18, 5, 1, 9, 29, 70, 14, 15, 14, 7, 0, 6, 26, 38, 29, 6, 29, 23, 67, 82, 77, 79, 14, 6, 93, 23, 6, 1, 26, 13, 93, 14, 65, 65, 28, 0, 13, 13, 23, 58, 8, 3, 21, 48, 6, 23, 75, 87, 127, 127, 84, 73, 78, 72, 15, 24, 65, 13, 21, 85, 7, 13, 27, 12, 22, 12, 44, 28, 
    17, 1, 8, 92, 76, 72, 85, 7, 29, 11, 24, 65, 68, 0, 92, 77, 85, 3, 10, 6, 77, 17, 6, 29, 29, 6, 29, 46, 65, 3, 7, 17, 90, 17, 66, 72, 10, 27, 92, 2, 4, 7, 45, 12, 7, 23, 22, 71, 22, 90, 74, 84, 103, 14, 76, 85, 85, 18, 5, 1, 9, 29, 84, 86, 33, 0, 31, 1, 17, 72, 88, 82, 26, 27, 22, 19, 71, 14, 65, 30, 27, 16, 6, 42, 1, 7, 27, 16, 0, 21, 77, 85, 13, 12, 26, 11, 23, 27, 44, 28, 12, 29, 9, 0, 20, 92, 78, 126, 73, 78, 72, 73, 18, 66, 3, 0, 1, 92, 67, 15, 23, 19, 13, 42, 23, 4, 10, 77, 19, 76, 19, 25, 27, 8, 26, 90, 65, 12, 99, 13, 11, 26, 28, 79, 72, 84, 92, 89, 79, 94, 67, 23, 32, 79, 6, 26, 7, 93, 82, 100, 72, 73, 84, 14, 10, 13, 26, 15, 23, 90, 69, 21, 27, 14, 23, 32, 0, 31, 64, 9, 7, 85, 73, 73, 0, 7, 27, 25, 79, 0, 8, 15, 11, 75, 11, 10, 0, 7, 10, 1, 32, 0, 2, 92, 8, 92, 78, 126, 73, 78, 72, 73, 6, 75, 24, 20, 7, 0, 67, 27, 12, 21, 7, 71, 16, 12, 0, 31, 74, 69, 85, 95, 84, 4, 7, 16, 65, 19, 92, 13, 5, 48, 10, 4, 13, 73, 82, 14, 29, 18, 7, 44, 2, 92, 2, 16, 7, 88, 73, 7, 6, 26, 29, 74, 9, 34, 26, 28, 13, 13, 23, 91, 82, 101, 14, 105, 101, 11, 66, 3, 20, 1, 84, 10, 7, 26, 10, 24, 75, 33, 0, 5, 70, 5, 4, 10, 19, 29, 79, 11, 74, 79, 22, 36, 76, 85, 85, 84, 27, 11, 28, 28, 6, 64, 76, 80, 91, 94, 67, 69, 69, 1, 24, 29, 7, 75, 94, 67, 30, 76, 88, 85, 12, 73, 68, 72, 17, 93, 21, 102, 28, 127, 100, 11, 9, 9, 20, 93, 79, 30, 2, 6, 3, 6, 10, 25, 26, 21, 29, 92, 72, 15, 6, 79, 11, 34, 26, 1, 17, 12, 76, 82, 18, 101, 83, 67, 79, 77, 72, 0, 26, 20, 0, 91, 78, 29, 7, 7, 77, 13, 13, 16, 10, 37, 26, 4, 21, 42, 0, 28, 17, 11, 77, 19, 76, 19, 7, 21, 14, 45, 7, 6, 6, 74, 76, 75, 85, 27, 60, 59, 6, 19, 5, 10, 72, 105, 79, 77, 14, 76, 19, 25, 27, 8, 26, 90, 73, 1, 64, 31, 2, 20, 2, 6, 12, 54, 27, 19, 10, 83, 94, 79, 24, 113, 58, 28, 16, 3, 58, 7, 18, 12, 84, 4, 76, 20, 42, 61, 0, 9, 9, 23, 82, 101, 83, 67, 79, 77, 72, 0, 26, 20, 0, 91, 78, 30, 54, 32, 75, 20, 34, 26, 1, 17, 12, 69, 79, 73, 26, 29, 16, 12, 12, 66, 9, 17, 51, 6, 8, 9, 43, 6, 27, 92, 8, 65, 90, 78, 22, 6, 22, 17, 8, 3, 22, 7, 60, 4, 84, 9, 78, 127, 84, 73, 78, 72, 15, 24, 65, 13, 21, 71, 78, 1, 9, 6, 25, 14, 29, 28, 22, 1, 9, 126, 5, 13, 16, 24, 42, 1, 7, 27, 16, 14, 81, 65, 3, 49, 55, 13, 29, 49, 6, 0, 1, 7, 79, 71, 14, 25, 27, 6, 23, 8, 2, 13, 13, 39, 71, 22, 4, 85, 69, 67, 29, 58, 53, 5, 57, 26, 6, 24, 61, 65, 31, 28, 1, 29, 6, 0, 83, 99, 84, 14, 76, 65, 19, 2, 12, 9, 17, 64, 73, 9, 26, 13, 14, 1, 122, 9, 13, 1, 1, 27, 11, 43, 6, 27, 92, 8, 65, 72, 78, 1, 9, 6, 25, 14, 29, 28, 22, 1, 9, 126, 5, 13, 16, 24, 42, 1, 7, 27, 16, 21, 102, 65, 85, 78, 67, 14, 9, 29, 8, 27, 65, 67, 7, 12, 66, 10, 38, 28, 14, 12, 78, 85, 73, 1, 64, 31, 2, 20, 2, 6, 12, 54, 27, 19, 10, 83, 73, 79, 93, 0, 89, 78, 127, 84, 73, 78, 72, 15, 24, 65, 13, 21, 71, 78, 0, 13, 11, 6, 12, 29, 22, 7, 44, 2, 65, 30, 17, 85, 73, 73, 70, 30, 54, 32, 75, 20, 34, 26, 1, 17, 12, 69, 95, 73, 95, 93, 86, 70, 77, 4, 76, 0, 27, 7, 10, 15, 4, 12, 16, 125, 5, 27, 16, 85, 105, 98, 69, 82, 73, 79, 21, 15, 0, 12, 90, 76, 6, 17, 84, 84, 78, 27, 13, 38, 65, 25, 15, 17, 11, 7, 58, 0, 17, 29, 14, 29, 4, 3, 8, 6, 15, 16, 27, 0, 12, 28, 13, 13, 55, 65, 3, 19, 17, 66, 67, 0, 4, 30, 15, 60, 26, 25, 10, 65, 14, 25, 42, 54, 27, 27, 0, 13, 27, 38, 79, 8, 8, 0, 29, 74, 83, 111, 82, 73, 79, 83, 5, 3, 2, 79, 24, 71, 85, 4, 0, 22, 13, 5, 48, 75, 0, 21, 20, 78, 94, 72, 84, 92, 89, 79, 92, 67, 26, 3, 93, 15, 20, 25, 17, 13, 61, 1, 19, 17, 21, 102, 65, 85, 78, 67, 14, 9, 29, 8, 27, 83, 16, 2, 2, 65, 24, 29, 27, 17, 26, 29, 72, 84, 84, 67, 5, 15, 93, 30, 10, 16, 0, 30, 45, 10, 31, 23, 14, 67, 86, 64, 85, 5, 29, 17, 11, 4, 45, 17, 66, 24, 0, 91, 23, 74, 72, 79, 82, 88, 65, 70, 88, 101, 77, 14, 76, 85, 19, 24, 6, 15, 28, 73, 6, 65, 25, 15, 17, 11, 7, 58, 0, 17, 29, 46, 31, 19, 7, 12, 14, 81, 85, 6, 25, 6, 1, 28, 1, 7, 90, 9, 17, 93, 29, 14, 7, 10, 6, 1, 1, 22, 
    16, 28, 65, 14, 65, 6, 24, 27, 6, 26, 0, 7, 17, 93, 31, 77, 85, 29, 7, 65, 94, 120, 73, 79, 83, 67, 6, 11, 14, 68, 7, 26, 1, 7, 10, 13, 13, 38, 75, 15, 21, 52, 2, 19, 0, 4, 82, 85, 82, 83, 83, 65, 93, 7, 76, 14, 127, 84, 73, 78, 72, 73, 84, 14, 76, 19, 16, 26, 22, 26, 11, 82, 1, 14, 31, 5, 91, 69, 30, 66, 69, 89, 84, 89, 64, 88, 69, 84, 30, 66, 81, 89, 78, 83, 70, 85, 91, 82, 101, 83, 67, 79, 77, 83, 102, 127, 85, 84, 73, 78, 0, 8, 24, 72, 88, 65, 19, 7, 13, 9, 9, 49, 6, 3, 28, 17, 84, 103, 14, 76, 85, 85, 29, 15, 78, 64, 68, 7, 74, 76, 95, 72, 78, 22, 55, 55, 23, 15, 29, 18, 0, 27, 4, 65, 2, 61, 16, 29, 14, 6, 28, 64, 84, 85, 102, 65, 85, 78, 67, 72, 69, 82, 73, 9, 26, 13, 14, 1, 109, 3, 25, 26, 6, 73, 83, 72, 28, 43, 122, 9, 25, 1, 27, 17, 13, 75, 23, 31, 14, 31, 75, 9, 4, 64, 13, 25, 33, 17, 17, 26, 29, 27, 17, 109, 3, 14, 7, 10, 74, 83, 111, 82, 73, 79, 83, 30, 79, 8, 66, 31, 16, 85, 15, 99, 78, 72, 73, 84, 14, 76, 65, 85, 8, 15, 7, 4, 6, 73, 2, 18, 27, 40, 31, 79, 8, 39, 20, 16, 0, 27, 27, 73, 73, 14, 1, 0, 13, 70, 14, 1, 11, 90, 1, 14, 31, 5, 60, 4, 84, 9, 91, 13, 88, 73, 6, 9, 5, 18, 125, 5, 27, 16, 64, 26, 65, 73, 82, 28, 48, 48, 12, 29, 3, 75, 30, 39, 20, 16, 0, 27, 27, 64, 79, 36, 76, 65, 85, 78, 67, 72, 69, 82, 15, 3, 28, 2, 27, 77, 73, 30, 20, 17, 38, 8, 10, 1, 28, 7, 14, 81, 65, 24, 7, 13, 64, 16, 45, 42, 0, 1, 13, 10, 31, 124, 13, 17, 28, 1, 26, 78, 66, 73, 69, 0, 89, 77, 85, 3, 2, 16, 34, 0, 8, 11, 33, 2, 11, 4, 91, 31, 92, 78, 126, 73, 78, 72, 73, 84, 14, 76, 65, 19, 2, 12, 9, 17, 64, 73, 1, 28, 17, 2, 12, 66, 76, 72, 85, 19, 27, 15, 12, 58, 16, 124, 3, 20, 27, 10, 6, 12, 55, 23, 10, 27, 18, 13, 8, 1, 75, 68, 22, 16, 26, 29, 11, 26, 12, 16, 109, 3, 14, 7, 10, 79, 72, 13, 19, 5, 9, 32, 10, 21, 8, 2, 76, 18, 7, 21, 13, 60, 9, 13, 29, 91, 31, 72, 78, 100, 67, 72, 69, 82, 73, 79, 83, 67, 9, 1, 65, 13, 1, 85, 6, 12, 8, 26, 8, 23, 90, 9, 5, 49, 7, 16, 28, 4, 28, 10, 10, 83, 94, 79, 14, 71, 30, 22, 25, 17, 36, 15, 24, 65, 69, 0, 92, 65, 88, 78, 78, 27, 1, 82, 70, 79, 6, 60, 61, 8, 72, 30, 20, 22, 0, 0, 1, 6, 33, 17, 71, 11, 9, 1, 71, 67, 66, 69, 7, 54, 61, 22, 5, 29, 12, 77, 24, 28, 26, 26, 40, 3, 7, 28, 26, 90, 87, 107, 85, 78, 67, 72, 69, 82, 73, 79, 21, 15, 0, 12, 90, 94, 85, 7, 17, 15, 28, 9, 10, 0, 75, 8, 37, 28, 28, 6, 11, 17, 27, 6, 1, 83, 94, 79, 3, 65, 30, 24, 20, 24, 0, 20, 13, 65, 26, 65, 30, 12, 20, 2, 67, 67, 69, 7, 54, 43, 22, 19, 27, 5, 107, 10, 19, 16, 23, 29, 78, 66, 73, 26, 65, 30, 12, 20, 2, 10, 18, 0, 90, 10, 10, 29, 23, 10, 31, 75, 8, 54, 26, 27, 27, 10, 65, 64, 79, 36, 76, 65, 85, 78, 67, 72, 69, 82, 15, 3, 28, 2, 27, 95, 14, 30, 16, 19, 6, 8, 13, 28, 12, 16, 109, 3, 14, 7, 10, 67, 85, 69, 20, 0, 1, 18, 15, 59, 8, 86, 24, 0, 7, 17, 42, 1, 7, 27, 16, 14, 71, 65, 7, 11, 5, 26, 4, 17, 29, 10, 23, 39, 6, 30, 90, 13, 27, 22, 17, 73, 68, 72, 27, 17, 72, 30, 0, 22, 26, 6, 12, 33, 27, 27, 10, 16, 23, 6, 2, 64, 87, 127, 85, 84, 73, 78, 72, 73, 84, 14, 10, 8, 27, 15, 15, 43, 10, 30, 6, 29, 83, 94, 79, 24, 113, 56, 16, 13, 0, 28, 28, 13, 71, 17, 88, 13, 13, 93, 28, 6, 14, 23, 19, 10, 27, 22, 7, 44, 2, 65, 30, 17, 92, 79, 99, 100, 72, 73, 84, 14, 76, 65, 85, 78, 5, 4, 10, 19, 29, 79, 27, 2, 3, 11, 125, 24, 7, 26, 31, 12, 78, 85, 73, 1, 113, 63, 21, 7, 1, 8, 13, 50, 27, 13, 27, 27, 67, 69, 77, 30, 66, 64, 78, 126, 73, 78, 72, 73, 84, 14, 76, 65, 19, 2, 12, 9, 17, 82, 26, 27, 1, 12, 4, 8, 111, 0, 5, 29, 21, 73, 83, 72, 26, 25, 65, 3, 21, 29, 29, 23, 13, 21, 90, 1, 14, 31, 5, 60, 25, 92, 3, 30, 16, 84, 66, 78, 27, 4, 27, 65, 24, 9, 27, 11, 16, 27, 73, 82, 1, 14, 31, 5, 60, 25, 92, 3, 30, 16, 84, 68, 78, 27, 4, 27, 65, 24, 9, 27, 11, 16, 27, 73, 82, 8, 13, 0, 75, 28, 9, 7, 69, 78, 127, 84, 73, 78, 72, 73, 84, 14, 76, 7, 25, 1, 2, 28, 86, 82, 11, 29, 26, 4, 7, 25, 14, 81, 85, 19, 29, 7, 15, 4, 42, 27, 66, 3, 19, 91, 28, 4, 10, 69, 88, 73, 93, 93, 
    83, 84, 103, 14, 76, 85, 85, 84, 73, 78, 72, 15, 24, 65, 13, 21, 70, 78, 7, 9, 23, 25, 73, 82, 83, 1, 29, 4, 73, 4, 1, 85, 94, 73, 94, 70, 92, 70, 21, 102, 65, 85, 78, 67, 72, 69, 82, 73, 9, 31, 12, 14, 25, 14, 11, 7, 20, 16, 0, 11, 6, 29, 84, 19, 76, 80, 91, 94, 67, 69, 69, 19, 11, 28, 91, 21, 48, 57, 75, 20, 54, 26, 27, 27, 10, 70, 17, 84, 5, 76, 23, 42, 58, 6, 16, 38, 29, 6, 29, 23, 77, 22, 77, 3, 76, 68, 91, 68, 64, 85, 98, 73, 84, 14, 76, 65, 85, 78, 67, 14, 9, 29, 8, 27, 64, 67, 28, 25, 92, 3, 30, 16, 57, 0, 22, 72, 84, 84, 67, 5, 25, 93, 12, 17, 1, 2, 26, 29, 67, 83, 7, 14, 31, 69, 64, 85, 18, 6, 8, 10, 1, 12, 26, 90, 69, 90, 127, 78, 67, 72, 69, 82, 73, 79, 83, 11, 14, 1, 72, 88, 85, 6, 0, 27, 1, 3, 12, 55, 65, 0, 65, 72, 78, 11, 9, 9, 20, 93, 71, 0, 23, 29, 2, 69, 9, 56, 28, 12, 69, 78, 14, 0, 26, 79, 0, 34, 26, 2, 12, 26, 75, 19, 64, 84, 121, 67, 79, 77, 14, 76, 85, 85, 84, 15, 7, 6, 8, 24, 109, 3, 13, 26, 28, 67, 85, 69, 31, 0, 23, 91, 5, 6, 3, 79, 0, 54, 26, 24, 6, 28, 68, 73, 7, 90, 30, 14, 30, 11, 32, 7, 9, 94, 73, 28, 7, 17, 0, 6, 75, 45, 25, 5, 28, 8, 71, 83, 99, 84, 14, 76, 65, 8, 100, 67, 72, 69, 82, 15, 3, 28, 2, 27, 77, 73, 30, 20, 12, 84, 84, 78, 12, 6, 0, 6, 10, 8, 27, 15, 15, 43, 10, 30, 6, 29, 93, 17, 8, 15, 2, 76, 57, 32, 57, 40, 71, 83, 99, 84, 14, 76, 65, 19, 7, 13, 9, 9, 49, 6, 3, 28, 17, 65, 31, 73, 14, 85, 72, 84, 4, 7, 16, 65, 18, 66, 3, 0, 1, 93, 75, 15, 23, 19, 16, 67, 83, 4, 29, 12, 87, 64, 85, 18, 6, 8, 23, 65, 69, 84, 72, 5, 15, 20, 2, 32, 7, 9, 29, 27, 65, 1, 4, 13, 65, 14, 93, 91, 70, 93, 82, 100, 72, 73, 84, 14, 10, 8, 27, 15, 15, 43, 10, 30, 6, 29, 93, 2, 79, 71, 19, 76, 7, 26, 1, 7, 10, 13, 13, 38, 75, 15, 21, 52, 2, 19, 0, 4, 73, 99, 79, 83, 67, 79, 31, 75, 24, 0, 7, 26, 73, 8, 1, 7, 21, 66, 47, 14, 25, 1, 17, 83, 111, 15};
    public static final v20 d;
    public static final v20[] e;

    static {
        v20 v20Var = new v20("app_set_id");
        d = v20Var;
        e = new v20[]{v20Var};
    }

    public static void A(Parcel parcel, int i, String[] strArr) {
        if (strArr == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeStringArray(strArr);
        F(iE, parcel);
    }

    public static void B(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeStringList(list);
        F(iE, parcel);
    }

    public static void C(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i2);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        F(iE, parcel);
    }

    public static void D(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iE = E(i, parcel);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        F(iE, parcel);
    }

    public static int E(int i, Parcel parcel) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void F(int i, Parcel parcel) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void G(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                qg0.b(th, th2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x039d, code lost:
    
        if (r31 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x039f, code lost:
    
        if (r10 == null) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03a1, code lost:
    
        r2 = new android.animation.Animator[r10.size()];
        r3 = r10.size();
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03ac, code lost:
    
        if (r1 >= r3) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x03ae, code lost:
    
        r4 = r10.get(r1);
        r1 = r1 + 1;
        r2[r11] = (android.animation.Animator) r4;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03bc, code lost:
    
        if (r32 != 0) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03be, code lost:
    
        r31.playTogether(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03c1, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03c2, code lost:
    
        r31.playSequentially(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03c5, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0375 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0379  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator b(android.content.Context r26, android.content.res.Resources r27, android.content.res.Resources.Theme r28, android.content.res.XmlResourceParser r29, android.util.AttributeSet r30, android.animation.AnimatorSet r31, int r32) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 966
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.os.b(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.content.res.XmlResourceParser, android.util.AttributeSet, android.animation.AnimatorSet, int):android.animation.Animator");
    }

    public static final cz1 c(Context context, rl rlVar) {
        jc1 jc1VarM;
        ud1 il1Var;
        int i = 10;
        qg0.l(context, "context");
        qm0 qm0Var = new qm0(rlVar.b);
        Context applicationContext = context.getApplicationContext();
        qg0.k(applicationContext, "context.applicationContext");
        jf1 jf1Var = (jf1) qm0Var.a;
        qg0.k(jf1Var, "workTaskExecutor.serialTaskExecutor");
        boolean z = context.getResources().getBoolean(s41.workmanager_test_configuration);
        jl1 jl1Var = rlVar.c;
        qg0.l(jl1Var, "clock");
        ud1 ud1Var = null;
        if (z) {
            jc1VarM = new jc1(applicationContext, WorkDatabase.class, null);
            jc1VarM.j = true;
        } else {
            jc1VarM = az1.m(applicationContext, WorkDatabase.class, "androidx.work.workdb");
            jc1VarM.i = new o5(applicationContext, i);
        }
        jc1VarM.g = jf1Var;
        jc1VarM.d.add(new dj(jl1Var));
        jc1VarM.a(hu0.h);
        jc1VarM.a(new ab1(applicationContext, 2, 3));
        jc1VarM.a(hu0.i);
        jc1VarM.a(hu0.j);
        jc1VarM.a(new ab1(applicationContext, 5, 6));
        jc1VarM.a(hu0.k);
        jc1VarM.a(hu0.l);
        jc1VarM.a(hu0.m);
        jc1VarM.a(new ab1(applicationContext));
        jc1VarM.a(new ab1(applicationContext, 10, 11));
        jc1VarM.a(hu0.d);
        jc1VarM.a(hu0.e);
        jc1VarM.a(hu0.f);
        jc1VarM.a(hu0.g);
        jc1VarM.l = false;
        jc1VarM.m = true;
        WorkDatabase workDatabase = (WorkDatabase) jc1VarM.b();
        Context applicationContext2 = context.getApplicationContext();
        qg0.k(applicationContext2, "context.applicationContext");
        hz1 hz1Var = new hz1(applicationContext2, qm0Var);
        s31 s31Var = new s31(context.getApplicationContext(), rlVar, qm0Var, workDatabase);
        int i2 = fe1.a;
        if (Build.VERSION.SDK_INT >= 23) {
            il1Var = new ql1(context, workDatabase, rlVar);
            t01.a(context, SystemJobService.class, true);
            ka0.j().getClass();
        } else {
            try {
                ud1 ud1Var2 = (ud1) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class, jl1.class).newInstance(context, jl1Var);
                ka0.j().getClass();
                ud1Var = ud1Var2;
            } catch (Throwable unused) {
                ka0.j().getClass();
            }
            if (ud1Var == null) {
                il1Var = new il1(context);
                t01.a(context, SystemAlarmService.class, true);
                ka0.j().getClass();
            } else {
                il1Var = ud1Var;
            }
        }
        return new cz1(context.getApplicationContext(), rlVar, qm0Var, workDatabase, xj.v(il1Var, new ma0(context, rlVar, hz1Var, s31Var, new q11(s31Var, qm0Var), qm0Var)), s31Var, hz1Var);
    }

    public static String d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (i == 0) {
                stringBuffer.append(Character.toLowerCase(cCharAt));
            } else if (Character.isUpperCase(cCharAt)) {
                stringBuffer.append('_');
                stringBuffer.append(Character.toLowerCase(cCharAt));
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    public static final String e(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static PropertyValuesHolder f(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolderOfFloat;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        int i4 = 0;
        boolean z = typedValuePeekValue != null;
        int i5 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i6 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && l(i5)) || (z2 && l(i6))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            t11[] t11VarArrH = p02.h(string);
            t11[] t11VarArrH2 = p02.h(string2);
            if (t11VarArrH != null || t11VarArrH2 != null) {
                if (t11VarArrH != null) {
                    p5 p5Var = new p5(i4);
                    if (t11VarArrH2 == null) {
                        return PropertyValuesHolder.ofObject(str, p5Var, t11VarArrH);
                    }
                    if (p02.b(t11VarArrH, t11VarArrH2)) {
                        return PropertyValuesHolder.ofObject(str, p5Var, t11VarArrH, t11VarArrH2);
                    }
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                if (t11VarArrH2 != null) {
                    return PropertyValuesHolder.ofObject(str, new p5(i4), t11VarArrH2);
                }
            }
            return null;
        }
        v8 v8Var = i == 3 ? v8.a : null;
        if (z3) {
            if (z) {
                float dimension = i5 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (z2) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z) {
            int dimension2 = i5 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : l(i5) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            if (z2) {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2, i6 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : l(i6) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2);
            }
        } else if (z2) {
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, i6 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : l(i6) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
        }
        if (propertyValuesHolderOfInt != null && v8Var != null) {
            propertyValuesHolderOfInt.setEvaluator(v8Var);
        }
        return propertyValuesHolderOfInt;
    }

    public static s60 g(ow1 ow1Var, SQLiteDatabase sQLiteDatabase) {
        qg0.l(ow1Var, "refHolder");
        s60 s60Var = (s60) ow1Var.h;
        if (s60Var != null && s60Var.g.equals(sQLiteDatabase)) {
            return s60Var;
        }
        s60 s60Var2 = new s60(sQLiteDatabase);
        ow1Var.h = s60Var2;
        return s60Var2;
    }

    public static final void h(yo yoVar, Throwable th) throws IllegalAccessException, InvocationTargetException {
        try {
            q4 q4Var = (q4) yoVar.n(jl1.h);
            if (q4Var != null) {
                q4Var.z(th);
            } else {
                wd.u(yoVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                qg0.b(runtimeException, th);
                th = runtimeException;
            }
            wd.u(yoVar, th);
        }
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean l(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        int resourceId = 0;
        TypedArray typedArrayC = np1.C(resources, theme, attributeSet, wd.m);
        TypedArray typedArrayC2 = np1.C(resources, theme, attributeSet, wd.q);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        boolean zX = np1.x(xmlResourceParser, "duration");
        int i = t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT;
        if (zX) {
            i = typedArrayC.getInt(1, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT);
        }
        long j = i;
        long j2 = !(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "startOffset") != null) ? 0 : typedArrayC.getInt(2, 0);
        int i2 = !(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueType") != null) ? 4 : typedArrayC.getInt(7, 4);
        if (xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueFrom") != null && xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "valueTo") != null) {
            if (i2 == 4) {
                TypedValue typedValuePeekValue = typedArrayC.peekValue(5);
                boolean z = typedValuePeekValue != null;
                int i3 = z ? typedValuePeekValue.type : 0;
                TypedValue typedValuePeekValue2 = typedArrayC.peekValue(6);
                boolean z2 = typedValuePeekValue2 != null;
                i2 = ((z && l(i3)) || (z2 && l(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder propertyValuesHolderF = f(typedArrayC, i2, 5, 6, "");
            if (propertyValuesHolderF != null) {
                valueAnimator3.setValues(propertyValuesHolderF);
            }
        }
        valueAnimator3.setDuration(j);
        valueAnimator3.setStartDelay(j2);
        valueAnimator3.setRepeatCount(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatCount") != null ? typedArrayC.getInt(3, 0) : 0);
        valueAnimator3.setRepeatMode(xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "repeatMode") != null ? typedArrayC.getInt(4, 1) : 1);
        if (typedArrayC2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String strP = np1.p(typedArrayC2, xmlResourceParser, "pathData", 1);
            if (strP != null) {
                String strP2 = np1.p(typedArrayC2, xmlResourceParser, "propertyXName", 2);
                String strP3 = np1.p(typedArrayC2, xmlResourceParser, "propertyYName", 3);
                if (i2 != 2) {
                }
                if (strP2 == null && strP3 == null) {
                    throw new InflateException(typedArrayC2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path pathI = p02.i(strP);
                PathMeasure pathMeasure = new PathMeasure(pathI, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float length = 0.0f;
                do {
                    length += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(length));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(pathI, false);
                int iMin = Math.min(100, ((int) (length / 0.5f)) + 1);
                float[] fArr = new float[iMin];
                float[] fArr2 = new float[iMin];
                float[] fArr3 = new float[2];
                float f = length / (iMin - 1);
                valueAnimator = valueAnimator3;
                float f2 = 0.0f;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= iMin) {
                        break;
                    }
                    int i6 = i4;
                    pathMeasure2.getPosTan(f2 - ((Float) arrayList.get(i5)).floatValue(), fArr3, null);
                    fArr[i6] = fArr3[0];
                    fArr2[i6] = fArr3[1];
                    int i7 = i5 + 1;
                    f2 += f;
                    if (i7 < arrayList.size() && f2 > ((Float) arrayList.get(i7)).floatValue()) {
                        pathMeasure2.nextContour();
                        i5 = i7;
                    }
                    i4 = i6 + 1;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = strP2 != null ? PropertyValuesHolder.ofFloat(strP2, fArr) : null;
                PropertyValuesHolder propertyValuesHolderOfFloat2 = strP3 != null ? PropertyValuesHolder.ofFloat(strP3, fArr2) : null;
                if (propertyValuesHolderOfFloat == null) {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat2);
                } else if (propertyValuesHolderOfFloat2 == null) {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat);
                } else {
                    objectAnimator2.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
                }
                resourceId = 0;
            } else {
                valueAnimator = valueAnimator3;
                resourceId = 0;
                objectAnimator2.setPropertyName(np1.p(typedArrayC2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
        }
        if (xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "interpolator") != null) {
            resourceId = typedArrayC.getResourceId(resourceId, resourceId);
        }
        if (resourceId > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        } else {
            valueAnimator2 = valueAnimator;
        }
        typedArrayC.recycle();
        if (typedArrayC2 != null) {
            typedArrayC2.recycle();
        }
        return valueAnimator2;
    }

    public static void p(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException {
        int i = 8;
        if (obj == null) {
            return;
        }
        if (obj instanceof au0) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(d(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getFields();
            int length2 = fields.length;
            int i2 = 0;
            while (i2 < length2) {
                Field field = fields[i2];
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & i) != i && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray()) {
                        p(name, obj2, stringBuffer, stringBuffer2);
                    } else if (type.getComponentType() == Byte.TYPE) {
                        p(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length3 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i3 = 0; i3 < length3; i3++) {
                            p(name, Array.get(obj2, i3), stringBuffer, stringBuffer2);
                        }
                    }
                }
                i2++;
                i = 8;
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String strSubstring = name2.substring(3);
                    try {
                        if (((Boolean) cls.getMethod("has" + strSubstring, null).invoke(obj, null)).booleanValue()) {
                            p(strSubstring, cls.getMethod("get" + strSubstring, null).invoke(obj, null), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
                return;
            }
            return;
        }
        if (obj instanceof Map) {
            String strD = d(str);
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(strD);
                stringBuffer2.append(" <\n");
                int length4 = stringBuffer.length();
                stringBuffer.append("  ");
                p("key", entry.getKey(), stringBuffer, stringBuffer2);
                p("value", entry.getValue(), stringBuffer, stringBuffer2);
                stringBuffer.setLength(length4);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
            }
            return;
        }
        String strD2 = d(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(strD2);
        stringBuffer2.append(": ");
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.startsWith("http") && str2.length() > 200) {
                str2 = str2.substring(0, 200) + "[...]";
            }
            int length5 = str2.length();
            StringBuilder sb = new StringBuilder(length5);
            for (int i4 = 0; i4 < length5; i4++) {
                char cCharAt = str2.charAt(i4);
                if (cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\'') {
                    sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            stringBuffer2.append("\"");
            stringBuffer2.append(string);
            stringBuffer2.append("\"");
        } else if (obj instanceof byte[]) {
            stringBuffer2.append('\"');
            for (byte b2 : (byte[]) obj) {
                int i5 = b2 & 255;
                if (i5 == 92 || i5 == 34) {
                    stringBuffer2.append('\\');
                    stringBuffer2.append((char) i5);
                } else if (i5 < 32 || i5 >= 127) {
                    stringBuffer2.append(String.format("\\%03o", Integer.valueOf(i5)));
                } else {
                    stringBuffer2.append((char) i5);
                }
            }
            stringBuffer2.append('\"');
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n");
    }

    public static final List q(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        un0 un0Var = new un0(10);
        while (cursor.moveToNext()) {
            int i = cursor.getInt(columnIndex);
            int i2 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            qg0.k(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            qg0.k(string2, "cursor.getString(toColumnIndex)");
            un0Var.add(new hm1(i, i2, string, string2));
        }
        un0 un0VarB = m90.b(un0Var);
        qg0.l(un0VarB, "<this>");
        if (un0VarB.a() <= 1) {
            return wj.A(un0VarB);
        }
        Object[] array = un0VarB.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        List listAsList = Arrays.asList(array);
        qg0.k(listAsList, "asList(...)");
        return listAsList;
    }

    public static final im1 r(s60 s60Var, String str, boolean z) throws IOException {
        Cursor cursorC = s60Var.C("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorC.getColumnIndex("seqno");
            int columnIndex2 = cursorC.getColumnIndex("cid");
            int columnIndex3 = cursorC.getColumnIndex("name");
            int columnIndex4 = cursorC.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorC.moveToNext()) {
                    if (cursorC.getInt(columnIndex2) >= 0) {
                        int i = cursorC.getInt(columnIndex);
                        String string = cursorC.getString(columnIndex3);
                        String str2 = cursorC.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i);
                        qg0.k(string, "columnName");
                        treeMap.put(numValueOf, string);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                qg0.k(collectionValues, "columnsMap.values");
                List listA = wj.A(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                qg0.k(collectionValues2, "ordersMap.values");
                im1 im1Var = new im1(str, z, listA, wj.A(collectionValues2));
                cursorC.close();
                return im1Var;
            }
            cursorC.close();
            return null;
        } finally {
        }
    }

    public static final Object s(he1 he1Var, he1 he1Var2, s70 s70Var) throws Throwable {
        Object ukVar;
        Object objG;
        cf0 cf0Var;
        try {
            np1.c(2, s70Var);
            ukVar = s70Var.d(he1Var2, he1Var);
        } catch (Throwable th) {
            ukVar = new uk(false, th);
        }
        hp hpVar = hp.g;
        if (ukVar == hpVar || (objG = he1Var.G(ukVar)) == hg0.e) {
            return hpVar;
        }
        if (objG instanceof uk) {
            throw ((uk) objG).a;
        }
        df0 df0Var = objG instanceof df0 ? (df0) objG : null;
        return (df0Var == null || (cf0Var = df0Var.a) == null) ? objG : cf0Var;
    }

    public static wb2 t(int i, h20 h20Var) {
        return new wb2(new l21(i), h20Var, b);
    }

    public static final String u(eo eoVar) {
        Object objE;
        if (eoVar instanceof yv) {
            return eoVar.toString();
        }
        try {
            objE = eoVar + '@' + e(eoVar);
        } catch (Throwable th) {
            objE = np1.e(th);
        }
        if (yb1.a(objE) != null) {
            objE = eoVar.getClass().getName() + '@' + e(eoVar);
        }
        return (String) objE;
    }

    public static void v(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeBundle(bundle);
        F(iE, parcel);
    }

    public static void w(Parcel parcel, int i, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeByteArray(bArr);
        F(iE, parcel);
    }

    public static void x(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeStrongBinder(iBinder);
        F(iE, parcel);
    }

    public static void y(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            return;
        }
        int iE = E(i, parcel);
        parcelable.writeToParcel(parcel, i2);
        F(iE, parcel);
    }

    public static void z(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iE = E(i, parcel);
        parcel.writeString(str);
        F(iE, parcel);
    }

    public abstract void n(Throwable th);

    public abstract void o(hz1 hz1Var);
}
