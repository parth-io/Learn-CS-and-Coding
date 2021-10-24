https://guides.github.com/features/mastering-markdown/
https://docs.github.com/en/github/writing-on-github/basic-writing-and-formatting-syntax

https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#images

https://daringfireball.net/projects/markdown/
https://www.markdownguide.org/getting-started/

https://dont-be-afraid-to-commit.readthedocs.io/en/latest/git/remotes.html
https://github.github.com/gfm/#what-is-github-flavored-markdown-
https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet

`gh`, GitHub's CLI, works on top of `git` to manage your local repos

To create a newline in Github-flavoured Markdown, add `\` or `<\br>`  to the  end of a line. Typora and some other Markdown editors create a new paragraph for the next line if you press the `Enter` key, meaning the spacing is greater than a line spacing.

Creating new line in Typora - does it create a new paragraph? And if it does not, it is creating a new line, why does it not need a '\' character but GitHub needs it? 
Typora-generated TOC is broken on GitHub
Dirty fix for now to get TOC up on GitHub:
1. Generate the TOC from http://ecotrust-canada.github.io/markdown-toc/
2. Remove leading and trailing hyphens, and replace double or triple hyphens with a single hyphen

See why Typora's GitHub-flavoured MarkDown is not working