# Sample CLJ/CLJS project

## Project set up

- most of the work is done in `project.clj`
- source files are in `src/[clj, cljs]`

## Development

- Do `cider-jack-in-clojurescript`
- start dev server in CLJ REPL: `(def server (-dev-main 9010))`
  - can stop with `(.stop server)`
- set up Figwheel server in the CLJS REPL

## Deploying

- JAR the CLJ: `lein clean`, `lein uberjar`
- Compile the CLJS: `lein cljsbuild once prod`
- `scp` the uberjar & `resources` folder to the same server folder
- start the server: `java -cp "resources:duniyahai.jar" duniyahai.core 9010`
