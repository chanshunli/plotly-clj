# plotly-clj

[![Clojars Project](https://img.shields.io/clojars/v/plotly-clj.svg)](https://clojars.org/plotly-clj)

A Clojure library designed for creating interactive web graphics via the open source JavaScript graphing library [plotly.js](https://github.com/plotly/plotly.j://github.com/plotly/plotly.js).

This library is still under development. Any suggestions are welcome!

## Installation

Install with Leiningen, add the following to your `:dependencies`:

```
[plotly-clj "0.1.1"]
```

## Usage

There are three ways to use this library.

### Plot offline with Gorilla-REPL

This is the most common way to use this library. By integrating with [Gorilla-REPL](http://gorilla-repl.org/), 
you can easily plot figures like what you do in ipython notebooks. 

```clojure
(ns x (:use [plotly-clj.core]))

(offline-init)

(-> (plotly [2 1 3])
    add-scatter
    iplot)
```

Checkout the following examples for how to use:

1. [Scatter](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/scatter.clj)
2. [Bubble-Charts](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/bubble-charts.clj)
3. [Line-Charts](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/line-charts.clj)
4. [Bar-Charts](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/bar-charts.clj)
4. [Horizontal-Bar-Charts](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/horizontal-bar-charts.clj)
5. [Subplot](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/subplot.clj)
6. [Scater-3d](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/scatter-3d.clj)
7. [Surface](http://viewer.gorilla-repl.org/view.html?source=github&user=findmyway&repo=plotly-clj&path=examples/surface.clj)

### Plot offline in a html page

In this way, you can save the plot in a html page and check it out in a browser.

```clojure
(ns x (:use [plotly-clj.core]))

(-> (plotly [2 1 3])
    add-scatter
    (save-html "plotly.html" :open))
```

### Plot online

You can also send your figure to the [plot.ly](https://plot.ly) and get a sharable url.
Notice that you should set the user-name and api-key first. You can register a count first
and find your api-key at [here](https://plot.ly/settings/api).

```clojure
(ns x (:use [plotly-clj.core]))

(set-credentials "your-name" "your-api-key")

(-> (plotly [2 1 3])
    add-scatter
    (plot "filename"))
;; https://plot.ly/~findmyway/98
```

## License

```
MIT License

Copyright (c) 2017 Tian Jun

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
