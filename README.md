# Sample CLJ/CLJS project

## Project set up

- most of the work is done in `project.clj`
- source files are in `src/[clj, cljs]`

## Development

- Do `cider-jack-in-clojurescript`
- start dev server in CLJ REPL: `(def server (-dev-main 9010))`
  - can stop with `(.stop server)`
- set up Figwheel server in the CLJS REPL

## Testing

- `cljs` tests are run
  - xx--either in REPL: `(require 'cljs.maintests.testrunner)`, `(cljs.maintests.testrunner/run-all-tests)`--xx
    - not working after setting up lein-doo
  - or from command line: `lein doo phantom test` (here `test` is the build id from `project.clj` and `phantomjs` needs to be in $PATH)
- `clj` tests are run:
  - in the REPL via cider test commands
  - or via `lein test`

## Deploying

- JAR the CLJ: `lein clean`, `lein uberjar`
- Compile the CLJS: `lein cljsbuild once prod`
- `scp` the uberjar & `resources` folder to the same server folder
- start the server: `java -cp "resources:duniyahai.jar" duniyahai.core 9010`
