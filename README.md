casing
======

Clojure CamelCase to lisp-case converter


#### Example Usage ####
```clojure
casing.core> (casing "CamelCase")
"camel-case"
casing.core> (casing "GoodHTTPRequestAPPLE")
"good-http-request-apple"
```

#### Installation ####

```bash
git clone https://github.com/runexec/casing.git
cd casing
lein install
```
Add to Clojure project
```clojure
[casing/casing "0.1.0-SNAPSHOT"]
```

Test if it's installed from terminal
```bash
$ echo "(use 'casing.core) (casing \"IsInstalled\")" | lein repl
```