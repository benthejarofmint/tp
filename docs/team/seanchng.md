# Sean Chng's Project Portfolio Page

## Project: MoneyBagProMax

MoneyBagProMax is a command-line personal finance application written in Java that helps users track income/expenses, manage budgets, and gain spending insights.

---

## Summary of Contributions

### New Feature: Income Class
Represents an income transaction by extending `Transaction` with valid categories (salary, allowance, freelance, investment, misc). Formatted display (e.g. `[Income] salary "monthly pay" $3000.00 (2026-03-20)`) omits empty descriptions. Exposing `VALID_CATEGORIES` as a public static final field lets `AddCommand` and `EditCommand` determine transaction type without coupling to the Parser. Category validity is enforced at construction time, mirroring `Expense` so future transaction types only require a new subclass.

---

### New Feature: Storage (Save and Load)
Handles persistent saving and loading of all transactions to/from a local data file. Transactions are saved after every mutating command and restored on startup. Missing files are created fresh; corrupted entries are skipped with a warning rather than crashing. A final save is triggered on exit as a safety net.

---

### Enhancements Implemented
- Defensive programming via assertions in `Income` constructor and command `execute()` methods.
- Javadoc for `Income` and `Storage` classes.
- JUnit tests for `Income` (valid/invalid categories, formatted display, empty description, case-insensitive input) and `Storage` (save/load round-trip, missing file creation, corrupted entry handling).
- Cross-platform stress tests for `CsvExporter` covering embedded newlines, carriage returns, combined quote+comma escaping, and large decimals.

---

### Bug Fixes
- **Missing `isMutating()` override:** `AddCommand` and `EditCommand` were not saving to disk after execution. Fixed by overriding `isMutating()` to return `true` in both.
- **Data loss on exit:** Added a final `storage.save()` and `storage.saveRecurring()` call when `isExit` is true.
- **Misleading error message for invalid dates:** Documented that the fallback message is inaccurate — the command is rejected entirely. Flagged for correction before next release.
- **Extra whitespace in commands:** Fixed `Parser.parse()` to normalise consecutive spaces before tokenization; added 4 JUnit tests.
- **Help menu gaps:** Added `category`, `export-csv`, and `export-data` entries; corrected the `undo` description to include `edit`; updated `EXPECTED.TXT`.
- **`CsvExporter` returning null:** Fixed `export()` to return the output `Path`.
- **Malformed CSV rows:** Descriptions with `\n`/`\r` were written as literal line breaks. Fixed by sanitising to spaces in `CsvExporter.escape()`; verified cross-platform via CI.
- **Case-insensitive category not normalised before storage:** Raw (potentially uppercase) category strings caused inconsistent display. Fixed by lowercasing in `AddCommand` before construction, and updating the `Income` assertion accordingly.

---

### Code Contributed
[SeanChng's RepoSense](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=SeanChng&breakdown=true)

---

### Contributions to the User Guide
I contributed the following sections to the User Guide:
- Add income command
- Storage and data persistence section

Each section includes the command format, examples, and explanations.

---

### Contributions to the Developer Guide
I contributed the following sections to the Developer Guide:
- Implementation of the Income class, including the category table, key methods, design considerations, and alternatives considered.
- Implementation of the Storage component, including architecture and flow, save/load logic, error handling strategy, and sequence diagrams for both load and save execution paths.
- Implementation of the Export feature, covering both `CsvExporter` and `TextFileExporter`, including design considerations and alternatives considered.
- Parser, Command, and Ui component descriptions, written from the actual source code.
- Non-Functional Requirements, Glossary, and Instructions for Manual Testing sections.
- Acknowledgements section, crediting Duke, AB3, Java SE 17 documentation, PlantUML, and the CS2113 Teaching Team.
- Error handling documentation for invalid date input in the Parser section, including the known misleading error message bug.
- Contributor warning in the Command section documenting the `isMutating()` contract and the v2.0 persistence bug.

---

### Contributions to Team-Based Tasks
- Reviewed pull requests and provided feedback on code quality and documentation.
- Actively managed the team's GitHub Issues board and assigned issues to relevant team members.
- Fixed checkstyle issues and improved code quality.
- Performed manual testing and text-ui testing.
- Responded to PE-D bug reports and triaged documentation and functionality issues.

### Review / Mentoring Contributions
- Reviewed teammates' pull requests and suggested improvements to code correctness and documentation.

---

### Beyond-Team Contributions
- Reported 12 bugs during the Practical Exam (Dry Run) for another team's product.

---

### Tools Used
- Gradle for build automation
- JUnit for unit testing
- Checkstyle for code quality
- GitHub for version control and pull request management