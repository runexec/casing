casing
======

Clojure CamelCase to lisp-case converter


#### Example Usage ####
```clojure
user> (use 'casing.core)
nil
user> (casing "SomeLongJavaMethod")
"some-long-java-method"
```

#### Installation ####

```bash
git clone https://github.com/runexec/casing.git
cd casing
lein install
```

Test if it's installed from terminal
```bash
$ echo "(use 'casing.core) (casing \"IsInstalled\")" | lein repl
```