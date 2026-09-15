# CLAUDE.md

Guidance for agents working in this repository.

## What this repo is

Teaching material for the **laboratory module of Programmazione ad Oggetti** (Object Oriented
Programming) at the University of Bologna. The deliverable is a set of Reveal.js slide decks,
written in Markdown, built with **Hugo** + the `reveal-hugo` theme, deployed to GitHub Pages
(<https://unibo-oop.github.io/lab-slides>) and additionally released as PDFs.

**Slide content is written in Italian.** Keep new or edited slide text in Italian, matching the
surrounding tone; code, identifiers and shell commands stay in English.

## Layout

| Path | What it is |
| --- | --- |
| `slides-markdown/` | The Hugo site. Almost all real work happens here. |
| `slides-markdown/content/<deck>/generator.md` | **The source of every deck.** Edit these. |
| `slides-markdown/content/_index.md` | Hand-written landing page / table of contents. Tracked. |
| `slides-markdown/content/*-lifecycle.md` | Hand-written fragments included by decks; not decks themselves. |
| `slides-markdown/shared-slides/` | Submodule of <https://github.com/DanySK/shared-slides>: reusable decks plus the `preprocess.rb` / `makepdfs.rb` / `serve.sh` tooling. |
| `slides-markdown/layouts/shortcodes/` | Project-local Hugo shortcodes. |
| `slides-markdown/assets/custom-theme.scss` | Deck styling (compiled by Hugo). |
| `slides-markdown/build/` | Hugo output. Generated, gitignored — never edit or commit. |
| `slides/` | Leftovers of the retired LaTeX/Beamer slides: `oop-slides-lab.sty` plus the `13 - report-template` submodule. No `.tex` sources remain in this repo. |
| `workspace/` | C# lab submodules (`lab-csharp`, `lab-csharp-sol`) and the PMD/Checkstyle configs. |
| `replacer.rb` | One-off LaTeX→Markdown migration helper; not part of any build. |
| `cleanup_project_files.rb` | Used only by the currently commented-out workspace-archive CI job. |
| `shame.md` | A joke list of bad student `user.name` values. Leave it alone. |

## The single most important rule: `generator.md`, never `_index.md`

`slides-markdown/content/<deck>/_index.md` is **generated** and **gitignored** (each deck dir
carries a `.gitignore` containing `_index.md`). It is produced by `shared-slides/preprocess.rb`
from `generator.md` and will be silently overwritten on the next build.

Edits go in `generator.md`. The only hand-written, tracked files under `content/` are
`content/_index.md` (the site index) and the top-level `*-lifecycle.md` fragments.

### Include blocks

`preprocess.rb` expands, in place, every block of the form:

```markdown
<!-- write-here "shared-slides/git/intro.md" -->
<!-- end-write -->
```

- Paths are relative to `slides-markdown/`.
- Whatever sits between the two markers is **replaced** on every run — never put hand-written text
  there, and never delete the closing `<!-- end-write -->`.
- `write-here` injects a "do not edit" HTML comment before the content; `write-here-code` does not
  (use it when the inclusion lands inside a fenced code block).
- Expansion loops, so included files may themselves contain `write-here` blocks.
- Nearly every deck opens with `<!-- write-here "cover.md" -->`; `cover.md` is the shared title slide.

## Build and preview

Requires `hugo` (extended), `ruby`, `node`, and `inotifywait` for the watch loop. All commands run
from `slides-markdown/`:

```sh
shared-slides/preprocess.rb   # expand generator.md -> _index.md
hugo                          # build into build/
shared-slides/serve.sh        # preprocess + `hugo server` + re-preprocess on every content change
```

Always run `preprocess.rb` before `hugo`: Hugo only ever sees `_index.md`.

The PDFs are produced by `shared-slides/makepdfs.rb <checkout-of-gh-pages>`, which drives headless
Chrome against the **published** site — it is a CI concern, not a local one.

## Slide conventions

- Front matter is TOML between `+++` fences, with `outputs = ["Reveal"]`. `aliases` defines the
  public URL of a deck (e.g. `aliases = ["/intro/"]` → `/intro/`), and that is the URL
  `content/_index.md` links to — the directory name is not the URL. When adding a deck, add both
  the alias and the index entry.
- `---` on its own line separates horizontal slides. `{{% section %}}…{{% /section %}}` groups
  vertical ones.
- Project-local shortcodes live in `layouts/shortcodes/`: `import` / `import-raw` (embed a file or
  a line range), `github` (embed a file from a GitHub repo), `multicol` / `col`, `image`, `today`,
  `gravizo`, `mentimeter`, `smaller`, `align-right`, `emoji`, `markdown`, `comment_frag`,
  `course_name`, `academic_year`. `section`, `slide` (per-slide options, e.g.
  `{{< slide transition="none" >}}`), `fragment` and `youtube` come from the `reveal-hugo` theme.
- `config.toml` sets `ignoreFiles = ['.*generator.md$']`, so Hugo never renders the sources
  directly — another reason the preprocessing step is not optional.
- Raw HTML in Markdown is enabled (goldmark `unsafe = true`) and used for layout tweaks.
- Mermaid diagrams are rendered and inlined in CI by `cric96/inline-mermaid`; they will not appear
  in a plain local `hugo` build.
- `.editorconfig` governs formatting: UTF-8, LF, final newline, 4-space indent (2 for YAML, JSON,
  HTML/CSS/JS/SVG); trailing whitespace is preserved in Markdown, so do not mass-strip it.

## Submodules

Clone with `--recurse-submodules`, or run `git submodule update --init --recursive`.

`shared-slides` is a **different repository**. Changes to files under
`slides-markdown/shared-slides/` must be committed and pushed there; this repo only records a
commit pointer. Committing here without pushing upstream produces a build that nobody else can
reproduce. Do not push submodule changes without asking.

## CI

- `.github/workflows/markdown-slides.yml` — preprocess, build with the pinned Hugo version, inline
  Mermaid, deploy `slides-markdown/build/` to `gh-pages` on `master`.
- `.github/workflows/build-and-deploy.yml` — computes a `<commits>.<year>.<Mdd>` version, compiles
  the (now empty) LaTeX set, and renders the published site to PDFs attached to a GitHub release.
- Renovate + Mergify keep dependencies and pinned action/tool versions current and auto-merge them;
  the Hugo version lives in a `TRICK_RENOVATE` heredoc inside the workflow, so bump it there.
