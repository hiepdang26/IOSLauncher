# Realtime Clock Icon Design

## Goal

Make every launcher-rendered Clock app icon appear like the iOS-style analog clock shown by the user: a white rounded-square face, black tick marks, black hour and minute hands, and a red/orange second hand. The icon must always reflect the device's current system time.

## Scope

This applies anywhere the launcher binds an `ApplicationItem` as `ApplicationItem.TYPE_CLOCK`, including the home screen, folders, App Library, and search/suggestion surfaces that reuse the same `app_view.xml` clock view path.

The change is limited to the launcher-owned dynamic clock view. It does not change the real Clock app, launcher labels, app detection, calendar icons, or unrelated app icon rendering.

## Architecture

`CustomAnalogClock` remains the single view used by `app_view.xml` for clock icons. Instead of depending on bitmap face and hand assets for the visible clock, the view renders the full icon with Canvas:

- Rounded white icon plate with a subtle border.
- Minute tick marks around the dial, with stronger marks at hour positions.
- Numerals at 12, 3, 6, and 9.
- Smooth hour, minute, and second hands drawn from the current system timestamp.

The view owns its frame callback lifecycle. It starts invalidating while attached and visible, and stops when detached or hidden. This keeps the clock realtime without leaving orphaned delayed callbacks.

## Time Model

The clock reads `System.currentTimeMillis()` when drawing. Rotation uses milliseconds:

- Second hand includes millisecond progress for continuous sweeping.
- Minute hand includes second and millisecond progress for realtime movement.
- Hour hand includes minute, second, and millisecond progress.

Because each frame reads system time directly, manual time changes and timezone changes are reflected on the next draw without needing a separate broadcast.

## Compatibility

The public `CustomAnalogClock` methods remain available so existing binding code can continue calling `setAutoUpdate(true)` and `setTime(...)`. The legacy drawable parameters can remain accepted for compatibility, but the launcher clock rendering uses the Canvas design.

## Testing

Add focused unit tests for pure clock-angle math so the realtime behavior is verifiable without Android UI instrumentation:

- Second hand uses milliseconds.
- Minute hand advances smoothly with seconds and milliseconds.
- Hour hand advances smoothly within the hour.

Run the relevant JVM tests and a debug build compile check after implementation.
