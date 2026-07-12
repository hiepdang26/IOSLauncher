# TestLiquidGlass Replacement Design

## Goal

Replace the launcher Liquid Glass implementation with the same direct `LiquidGlassView` behavior used by `/Users/hiepdang26/Documents/Workspace/TestLiquidGlass/app/src/main/java/com/hdc/testliquidglass/MainActivity.kt`.

The change applies only when the existing Liquid Glass option is enabled from the menu/settings. When the option is disabled, or realtime Liquid Glass is unavailable, existing launcher behavior, fallback blur, layout, gestures, drag/drop, uninstall, app launch, folder, app library, and search flows must continue to work as they do now.

## Source Of Truth

The reference project configures each glass surface by creating or finding a `com.qmdeve.liquidglass.widget.LiquidGlassView`, binding it to a content container, and applying this profile:

```kotlin
glass.bind(content)
glass.setCornerRadius(90f)
glass.setBlurRadius(2.5f)
glass.setRefractionHeight(50f)
glass.setRefractionOffset(120f)
glass.setDispersion(0.08f)
glass.setTintAlpha(0.008f)
glass.setTintColorRed(1f)
glass.setTintColorGreen(1f)
glass.setTintColorBlue(1f)
glass.setTouchEffectEnabled(false)
glass.setElasticEnabled(false)
glass.setDraggableEnabled(false)
```

These values are global Liquid Glass parameters. The old launcher-specific liquid material colors, strokes, diagonal highlights, gradients, and surface-specific Liquid Glass tint variants are no longer part of the enabled Liquid Glass path.

## Scope

Apply the replacement to both launcher code paths:

- Main home implementation under `app/src/main/java/com/vhmsoft/launcherios26/features/launcher`.
- Workspace/app-library implementation under `app/src/main/java/com/vhmsoft/launcherios26/ui/launcher/workspace`.

Surfaces covered:

- Dock.
- Folder preview icons.
- Open folder panel/content surface.
- App Library category folders.
- App Library search pill/search field.
- Home search bar/search pill.
- Search suggestions/results panels.
- Page indicator/search indicator.
- App icon remove/uninstall minus badge.

## Architecture

Introduce one shared TestLiquidGlass profile API in core code. Both existing wrapper views, `LauncherRealtimeLiquidGlassLayout` and `AndroidLiquidGlassLayout`, must configure their internal `LiquidGlassView` from that profile instead of from old per-surface material style parameters.

The wrappers remain responsible for lifecycle, measurement, binding to the source view group, and fallback drawing. This keeps the change scoped and avoids rewriting launcher layout, RecyclerView adapters, folder open animation, drag/drop, search, or app library behavior.

## Enabled Behavior

When Liquid Glass is enabled and realtime glass is supported:

- A `LiquidGlassView` is inserted behind the surface content.
- The view is bound to the nearest stable content source, matching the reference project's `bind(content)` pattern.
- The TestLiquidGlass profile is applied exactly.
- Surface content backgrounds that previously represented Liquid Glass material become transparent or null so the actual `LiquidGlassView` is visible.
- No old liquid material overlay is drawn above the `LiquidGlassView`.
- Remove badge, folder preview, dock, search, suggestions, app library, page indicator, and open folder panel all use the same Liquid Glass profile.

## Disabled And Fallback Behavior

When Liquid Glass is disabled, unsupported, or cannot bind safely:

- Existing non-Liquid-Glass fallback backgrounds remain.
- Existing blur toggles for dock, folder, and search keep their current behavior.
- Existing dark mode fallback behavior remains.
- The wrappers hide or skip the internal `LiquidGlassView`.
- No behavior changes are allowed for click, drag, focus, accessibility, uninstall, app open, folder open/close, search input, or app library navigation.

## Removal Of Old Liquid Glass Path

Remove the enabled-path dependency on:

- `setLiquidMaterial(...)` overlays.
- `LauncherLiquidGlassDrawableFactory` for Liquid Glass-enabled surfaces.
- Liquid Glass-specific colors, strokes, diagonal corner strokes, top/bottom/side highlights, and dock gradients.
- Surface-specific Liquid Glass material variants in both `core.LauncherLiquidGlassStylePolicy` and `ui.launcher.workspace.LauncherLiquidGlassStylePolicy`.

Fallback style policy may remain for non-Liquid-Glass backgrounds, but it must not provide the enabled Liquid Glass visual.

## Testing

Use test-first changes for implementation. Add or update unit tests to prove:

- Both Liquid Glass policy layers return the TestLiquidGlass profile, including corner radius `90f`.
- Enabled Liquid Glass ignores old surface-specific radii/material tints.
- Fallback background still draws when realtime Liquid Glass is inactive.
- Material overlay decisions no longer draw old Liquid Glass overlays when realtime Liquid Glass is active.
- Folder open panel, folder preview, dock, app library, search, suggestions/results, page/search indicator, and remove badge are mapped to the direct TestLiquidGlass path.
- Existing non-Liquid-Glass behavior is preserved.

Verification must include the focused unit tests and an Android build/test command that compiles the changed Kotlin/XML code.

## Risks

`LiquidGlassView.setCornerRadius(90f)` is used exactly as the reference project does, not scaled per surface. This may visually differ from old rounded fallback backgrounds, but it is intentional because the requested source of truth is `TestLiquidGlass/MainActivity`.

RecyclerView item surfaces must avoid binding to a source that contains the target view. Existing source containment checks must remain or be mirrored in both wrappers.

The repository currently has many pre-existing uncommitted changes. Implementation must stage and commit only files changed for this task unless the user explicitly asks otherwise.
