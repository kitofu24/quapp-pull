# Pending Quapp vault update

### 2026-10-11 23:52 UTC+08:00 | Model: Model unknown
**Project:** Quapp  
**Source:** Current Codex chat; title/link unavailable.

**Confirmed design change:** The custom app-loading splash now shows the existing Quapp ticket logo alone, centered horizontally and vertically. The loading bar remains at the bottom. The previous splash wordmark and tagline were removed to match the current Civic Paper specification.

**Implementation:** Updated `app/src/main/res/layout/activity_splash.xml` and added reusable `splash_mark_width` and `splash_mark_height` resources in `app/src/main/res/values/dimens.xml`. Startup timing, session routing, background, and system-bar behavior were unchanged.

**Verification:** Both edited XML files parse successfully. A structural check confirmed all four centering constraints and confirmed the wordmark is absent. Gradle resource processing could not run because Gradle could not create its configuration-cache directory in the current environment. Emulator and physical-device visual checks remain pending; do not mark those complete.

**Next action:** Launch on the Pixel emulator and Xiaomi device and confirm the ticket mark appears centered within the usable screen while the bottom loading bar remains visible.

**Project progress status:** Backfilled into the repository `PROGRESS.md` on 2026-10-12 at 00:14 UTC+08:00. The Obsidian copy still requires reconciliation.

**Reconciliation:** Append this entry without duplication to [[Projects/Quapp/PROGRESS]], [[Projects/Quapp/DESIGN]], [[Projects/Quapp]], and [[Daily/2026-10-11]] when vault write access is available.
