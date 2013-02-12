# elasticsearch-clojure

An Elasticsearch plugin, written entirely in Clojure.

Heavily a work in progress.

This work came about due to this Clojure ticket:
[CLJ-948](http://dev.clojure.org/jira/browse/CLJ-948) being resolved.
It's mostly an experiment to see if building an Elasticsearch plugin
is possible without Java shims.

It works right now, but getting the `TransportClojureFibonacciAction`
working is having difficulty due to Clojure not allowing a gen-class
to extend a class using generics.

If you have any suggestions or comments, feel free to open an issue.

## Usage

(Requires [leiningen](http://leiningen.org) version 2.x)

```
$ lein es
```

Then:

```
∴ curl -s -XGET "localhost:9200/_fibonacci?num=30" | python -mjson.tool
{
    "fibonacci": [
        0,
        1,
        1,
        2,
        3,
        5,
        8,
        13,
        21,
        34,
        55,
        89,
        144,
        233,
        377,
        610,
        987,
        1597,
        2584,
        4181,
        6765,
        10946,
        17711,
        28657,
        46368,
        75025,
        121393,
        196418,
        317811,
        514229
    ]
}
```

## License

Copyright © 2013 Matthew Lee Hinman

Distributed under the Eclipse Public License, the same as Clojure.
