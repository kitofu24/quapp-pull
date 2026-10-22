# Automatic Quapp change logging

### 2026-10-11 23:57 UTC+08:00 | Model: Model unknown
**Project:** Quapp  
**Source:** Current Codex chat; title/link unavailable.

**Confirmed workflow decision:** After every implemented code, UI, design, configuration, documentation, or workflow change, Codex must update the Obsidian project record automatically before reporting completion. The user does not need to request logging separately.

**Required destinations:**

- Always update `Projects/Quapp/PROGRESS.md` and the current `Daily/YYYY-MM-DD.md`.
- Update `Projects/Quapp.md` when current status or next actions change.
- Update `Projects/Quapp/DESIGN.md` for visual, interaction, layout, typography, color, accessibility, or design-system changes.
- Update `Projects/Quapp/DECISIONS.md` for confirmed decisions or replacements, preserving superseded decisions.
- Update other project notes when their subject changes.

**Required entry content:** Actual Asia/Manila date and time, exact model name when available or `Model unknown`, project and source, what changed, why, affected files or screens, implementation status, verification, unresolved questions, and next actions.

**Safety and verification:** Read each destination first, preserve existing content and wikilinks, avoid duplicate entries, and read every edited note back. Never mark unverified work complete. If a vault write fails, stage a named pending record in `obsidian-starter/` and report that it is pending.

**Implementation status:** This rule is active in the repository `AGENTS.md` and `.codex/agents/frontend_senior.toml`. Saving it into the Obsidian vault remains pending because direct vault writes are blocked and Windows app control is unavailable.

**Next action:** Attach `C:\Users\JUSKWAA\Documents\Obsidian Vault` to Codex with write access, then merge this note and all other staged records without duplicates.
