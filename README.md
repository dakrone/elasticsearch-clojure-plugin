# elasticsearch-clojure

An Elasticsearch plugin, written entirely in Clojure.

Heavily a work in progress.

## Usage

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
