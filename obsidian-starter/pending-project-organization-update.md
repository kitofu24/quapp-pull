# Pending Quapp vault update

### 2026-10-12 00:10 UTC+08:00 | Model: Model unknown
**Project:** Quapp  
**Source:** Current Codex chat; title/link unavailable.

**Confirmed request:** Organize the entire project into an easy-to-use structure that supports immediate debugging.

**Decision:** Preserve Android-standard source/resource paths and root contract documents. Add a navigation, documentation, tooling, and diagnostics layer around them instead of performing a risky package/resource migration.

**Implemented:** Added the root `README.md`; `docs/README.md`, `repo-map.md`, `debugging.md`, `development.md`, and `lint-status.md`; reusable `scripts/doctor.ps1`, `check.ps1`, `install-debug.ps1`, `logcat.ps1`, and environment discovery; README indexes for tools, artifacts, design experiments, diagnostics, and licenses; diagnostic folders; and generated-output ignore rules.

**Verification:** Every PowerShell script parsed successfully. The environment doctor found Java, Android SDK, ADB, and required files. Quick and full Gradle checks passed, including unit tests, resource processing, lint, and debug APK assembly. Lint reported zero errors and 136 warnings. Device installation and smoke testing remain pending.

**Limitation:** Windows denied moving two existing JVM crash logs from the repository root into `diagnostics/jvm-crashes`, even with elevated access. They remain unchanged and ignored; nothing was deleted.

**Next actions:** Run the install/debug script with one connected device; smoke-test launch, session routing, queuer and owner homes, queue detail, and ticket state; then triage lint warnings in focused batches.

**Vault status:** A direct append to `Projects/Quapp/PROGRESS.md` was attempted after implementation and was denied by Windows. No vault destination was changed or verified.

**Reconciliation:** Append this entry without duplication to [[Projects/Quapp/PROGRESS]], [[Projects/Quapp/DECISIONS]], [[Projects/Quapp]], [[Projects/Quapp/WORKLOG]], and [[Daily/2026-10-12]] when vault write access is available.
