#coriander

Uses [Gorilla REPL](http://gorilla-repl.org/) to run code in the browser, built with [Boot](http://boot-clj.com/).

## Usage

Assuming you have [boot 2](http://boot-clj.com/) installed:

```bash
boot gorilla -b
```

Then navigate to the worksheet URL, by default: [http://127.0.01:4000/worksheet.html]

## What's in a name?

I already had [falcor](https://github.com/mathias/falcor) so I decided to name this *workbook* library after another character from The Neverending Story: Mr. Coriander, who owns the book shop that Bastion steals The Neverending Story from.

![4715321_std](https://cloud.githubusercontent.com/assets/3340/5512956/4e757838-87aa-11e4-92a8-3b577105cb71.jpg)

Of course, in the movie he's Mr. Koreander and in the novel he's Carl Conrad Coreander, but I liked the name **coriander** so I went with it.

## Options

See the [boot project](https://github.com/boot-clj/boot) for more information
on how to use these. Otherwise, you can use the defaults.

```clojure
 [p port       PORT int "The port to run the web REPL on. Defaults to 4000."
  i ip         IP   str "The IP address the server listens on. Defaults to 127.0.0.1"
  n nrepl-port PORT int "The port that the nREPL server will be started up on. Defaults to a free port."
  b block             bool "Blocking (for standalone use)"]
```

## License

Copyright 2014 Matt Gauger.

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
