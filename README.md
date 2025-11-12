# Project Documentation

...existing documentation...

6) CI (GitHub Actions)

- A GitHub Actions workflow has been added at `.github/workflows/ci.yml`.
- What it does:
  - Checks out the repo, sets up JDK 17, caches the Maven repository.
  - Optionally reads a `CI_CONFIG` secret to create `ci-config.properties`.
  - Runs `mvn -Dvideo.enabled=false -Dconfig.file=${{ github.workspace }}/ci-config.properties test`.
  - Uploads surefire reports as an artifact.

- How to configure CI:
  1. Go to your repository Settings → Secrets and add a secret named `CI_CONFIG` containing the contents of a `config.properties` file (optional). If not provided, the workflow will run with classpath config.
  2. The workflow disables video recording (`-Dvideo.enabled=false`) to avoid Monte screen-recorder conflicts on shared CI runners. If you must capture video in CI, run tests on separate VMs/agents where each job has its own display.

- Example: to run the workflow locally or in a different CI, the job uses this command (inside the workflow):
```
mvn -B -V -Dvideo.enabled=false -Dconfig.file=${{ github.workspace }}/ci-config.properties test
```

- Notes:
  - If you prefer per-branch customization, duplicate or adjust the workflow YAML to match branch names or add matrix builds.
  - The workflow currently targets `main`/`master` on push and PR; change `on:` triggers as needed.

...existing documentation...
