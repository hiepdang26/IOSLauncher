# Realtime Clock Icon Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Replace the launcher Clock icon with an iOS-style analog icon that appears everywhere clock app icons are rendered and updates smoothly from system time.

**Architecture:** Keep `CustomAnalogClock` as the single launcher view bound by `app_view.xml`, but render the entire clock face and hands with Canvas instead of bitmap face/hand assets. Move hand-angle calculations into a pure Kotlin policy object so realtime millisecond behavior can be tested with JVM unit tests.

**Tech Stack:** Android View Canvas drawing, Kotlin, Gradle Android JVM unit tests, existing launcher binding through `ApplicationItem.TYPE_CLOCK`.

## Global Constraints

- Applies anywhere the launcher binds an `ApplicationItem` as `ApplicationItem.TYPE_CLOCK`.
- The icon must always reflect the device's current system time.
- The second hand includes millisecond progress for continuous sweeping.
- The minute hand includes second and millisecond progress for realtime movement.
- The hour hand includes minute, second, and millisecond progress.
- The public `CustomAnalogClock` methods remain available for existing binding code.
- No new dependencies.

---

## File Structure

- Create `app/src/main/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAngles.kt` for pure angle math.
- Create `app/src/test/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAnglesTest.kt` for JVM coverage of smooth realtime angles.
- Modify `app/src/main/java/com/vhmsoft/launcherios26/core/customviews/CustomAnalogClock.kt` to draw the iOS-style face and schedule frame invalidation only while attached and visible.

### Task 1: Smooth Clock Angle Policy

**Files:**
- Create: `app/src/main/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAngles.kt`
- Test: `app/src/test/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAnglesTest.kt`

**Interfaces:**
- Produces: `data class ClockHandAngles(val hour: Float, val minute: Float, val second: Float)`
- Produces: `object ClockHandAnglePolicy { fun fromTime(hourOfDay: Int, minute: Int, second: Int, millisecond: Int, is24Hour: Boolean = false): ClockHandAngles }`
- Consumes: integer time fields from `Calendar`.

- [ ] **Step 1: Write the failing test**

```kotlin
package com.vhmsoft.launcherios26.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Test

class ClockHandAnglesTest {
    @Test
    fun secondHandIncludesMilliseconds() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 10,
            minute = 15,
            second = 30,
            millisecond = 500
        )

        assertEquals(183f, angles.second, 0.0001f)
    }

    @Test
    fun minuteHandIncludesSecondsAndMilliseconds() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 10,
            minute = 15,
            second = 30,
            millisecond = 500
        )

        assertEquals(93.05f, angles.minute, 0.0001f)
    }

    @Test
    fun hourHandIncludesMinuteSecondAndMilliseconds() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 10,
            minute = 15,
            second = 30,
            millisecond = 500
        )

        assertEquals(307.75418f, angles.hour, 0.0001f)
    }

    @Test
    fun hourHandSupportsTwentyFourHourModeForLegacyCompatibility() {
        val angles = ClockHandAnglePolicy.fromTime(
            hourOfDay = 18,
            minute = 0,
            second = 0,
            millisecond = 0,
            is24Hour = true
        )

        assertEquals(90f, angles.hour, 0.0001f)
    }
}
```

- [ ] **Step 2: Run test to verify it fails**

Run: `./gradlew.bat testDebugUnitTest --tests com.vhmsoft.launcherios26.core.customviews.ClockHandAnglesTest`

Expected: FAIL because `ClockHandAnglePolicy` does not exist.

- [ ] **Step 3: Write minimal implementation**

```kotlin
package com.vhmsoft.launcherios26.core.customviews

data class ClockHandAngles(
    val hour: Float,
    val minute: Float,
    val second: Float
)

object ClockHandAnglePolicy {
    fun fromTime(
        hourOfDay: Int,
        minute: Int,
        second: Int,
        millisecond: Int,
        is24Hour: Boolean = false
    ): ClockHandAngles {
        val secondProgress = second + millisecond.coerceIn(0, 999) / 1000f
        val minuteProgress = minute + secondProgress / 60f
        val hourDivisor = if (is24Hour) 24f else 12f
        val normalizedHour = if (is24Hour) {
            ((hourOfDay % 24) + 24) % 24
        } else {
            ((hourOfDay % 12) + 12) % 12
        }
        val hourProgress = normalizedHour + minuteProgress / 60f

        return ClockHandAngles(
            hour = (hourProgress / hourDivisor) * 360f,
            minute = (minuteProgress / 60f) * 360f,
            second = (secondProgress / 60f) * 360f
        )
    }
}
```

- [ ] **Step 4: Run test to verify it passes**

Run: `./gradlew.bat testDebugUnitTest --tests com.vhmsoft.launcherios26.core.customviews.ClockHandAnglesTest`

Expected: PASS.

- [ ] **Step 5: Commit**

```bash
git add app/src/main/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAngles.kt app/src/test/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAnglesTest.kt
git commit -m "Add smooth clock hand angle policy"
```

### Task 2: Canvas Clock Icon Renderer

**Files:**
- Modify: `app/src/main/java/com/vhmsoft/launcherios26/core/customviews/CustomAnalogClock.kt`
- Test: `app/src/test/java/com/vhmsoft/launcherios26/core/customviews/ClockHandAnglesTest.kt`

**Interfaces:**
- Consumes: `ClockHandAnglePolicy.fromTime(hourOfDay: Int, minute: Int, second: Int, millisecond: Int, is24Hour: Boolean): ClockHandAngles`
- Preserves: `CustomAnalogClock.setAutoUpdate(autoUpdate: Boolean)`, `setTime(time: Long)`, `setTime(calendar: Calendar)`, `setScale(scale: Float)`, `setFace(drawableRes: Int)`, and legacy `init(...)`.
- Produces: a self-invalidating Canvas-drawn realtime clock icon whenever the view is attached and visible.

- [ ] **Step 1: Update `CustomAnalogClock.kt` imports and fields**

Use Android drawing primitives: `Paint`, `Path`, `RectF`, `Color`, `Typeface`, `SystemClock`, `ViewCompat`, `cos`, `sin`, and remove the old `Handler`/`HandsOverlay` drawing path.

- [ ] **Step 2: Replace legacy bitmap drawing with Canvas rendering**

Draw a square rounded white plate based on the smaller view dimension. Draw 60 ticks around the dial, with hour ticks darker and longer. Draw numerals `12`, `3`, `6`, and `9` using centered text. Draw hour and minute hands in black and the second hand in red/orange. Draw a small center cap.

- [ ] **Step 3: Add realtime frame scheduling**

Add:

```kotlin
private val tickRunnable = object : Runnable {
    override fun run() {
        if (shouldAnimate()) {
            invalidate()
            ViewCompat.postOnAnimation(this@CustomAnalogClock, this)
        }
    }
}

private fun shouldAnimate(): Boolean =
    autoUpdate && isAttachedToWindow && visibility == VISIBLE && windowVisibility == VISIBLE
```

Call `startTicker()` from `setAutoUpdate(true)`, `onAttachedToWindow()`, and `onVisibilityChanged(...)`. Call `stopTicker()` from `setAutoUpdate(false)`, `onDetachedFromWindow()`, and hidden visibility states.

- [ ] **Step 4: Preserve explicit time compatibility**

If `autoUpdate` is true, `onDraw` reads `System.currentTimeMillis()`. If false, `setTime(...)` updates `mCalendar` and invalidates the static display.

- [ ] **Step 5: Run focused tests**

Run: `./gradlew.bat testDebugUnitTest --tests com.vhmsoft.launcherios26.core.customviews.ClockHandAnglesTest`

Expected: PASS.

- [ ] **Step 6: Run compile check**

Run: `./gradlew.bat assembleDebug`

Expected: BUILD SUCCESSFUL.

- [ ] **Step 7: Commit**

```bash
git add app/src/main/java/com/vhmsoft/launcherios26/core/customviews/CustomAnalogClock.kt
git commit -m "Render realtime iOS-style clock icon"
```

## Self-Review

- Spec coverage: Task 1 covers smooth millisecond angle math. Task 2 covers iOS-style Canvas rendering, lifecycle-safe realtime updates, existing public method compatibility, and use everywhere `TYPE_CLOCK` is bound.
- Placeholder scan: No TODO/TBD placeholders are present.
- Type consistency: Task 2 consumes the exact `ClockHandAnglePolicy.fromTime(...)` signature produced by Task 1.
