`vimtutor` to learn vim

| **Mode**    | **Feature**                                                  |
| ----------- | ------------------------------------------------------------ |
| **Command** | By default, **vi** starts in Command mode. Each key is an editor command. Keyboard strokes are interpreted as commands that can modify file contents. |
| **Insert**  | Type **i** to switch to Insert mode from Command mode. Insert mode is used to enter (insert) text into a file. Insert mode is indicated by an “`**? INSERT ?**`” indicator at the bottom of the screen. Press **`Esc`** to exit Insert mode and return to Command mode. |
| **Line**    | Type **:** to switch to the Line mode from Command mode. Each key is an external  command, including operations such as writing the file contents to disk  or exiting. Uses line editing commands inherited from older line editors. Most  of these commands are actually no longer used. Some line editing  commands are very powerful. Press `**Esc** `to exit Line mode and return to Command mode. |

The following table shows common commands to work with files. The **ENTER** key needs to be pressed after all of these commands: 

| **Command**      | **Usage**                                                    |
| ---------------- | ------------------------------------------------------------ |
| **vi myfile**    | Start the editor and edit **myfile**                         |
| **vi -r myfile** | Start and edit **myfile** in recovery mode from a system crash |
| **:r file2**     | Read in **file2** and insert at current position             |
| **:w**           | Write to the file                                            |
| **:w myfile**    | Write out to **myfile**                                      |
| **:w! file2**    | Overwrite **file2**                                          |
| **:x or :wq**    | Exit and write out modified file                             |
| **:q**           | Quit                                                         |
| **:q!**          | Quit even though modifications have not been saved           |

The following table describes the most important keystrokes used when changing cursor position in **vi**. Line mode commands (those following colon **:** ) require the **ENTER** key to be pressed after the command is typed. 

| **Key**                     | **Usage**                         |
| --------------------------- | --------------------------------- |
| arrow keys                  | To move up, down, left and right  |
| **j** or **<ret>**          | To move one line down             |
| **k**                       | To move one line up               |
| **h** or Backspace          | To move one character left        |
| **l** or Space              | To move one character right       |
| **0**                       | To move to beginning of line      |
| **$**                       | To move to end of line            |
| **w**                       | To move to beginning of next word |
| **:0** or **1G**            | To move to beginning of file      |
| **:n** or **nG**            | To move to line n                 |
| **:$** or **G**             | To move to last line in file      |
| **CTRL-F** or **Page Down** | To move forward one page          |
| **CTRL-B** or **Page Up**   | To move backward one page         |
| **^l**                      | To refresh and center screen      |

The table describes the most important *commands* used when searching for text in vi. The **ENTER** key should be pressed after typing the search pattern.

| **Command**  | **Usage**                   |
| ------------ | --------------------------- |
| **/pattern** | Search forward for pattern  |
| **?pattern** | Search backward for pattern |

The table describes the most important *keystrokes* used when searching for text in vi. 

| **Key** | **Usage**                                     |
| ------- | --------------------------------------------- |
| **n**   | Move to next occurrence of search pattern     |
| **N**   | Move to previous occurrence of search pattern |

The table describes the most important keystrokes used when changing, adding, and deleting text in vi.

| **Key**            | **Usage**                                                    |
| ------------------ | ------------------------------------------------------------ |
| **a**              | Append text after cursor; stop upon **Escape** key           |
| **A**              | Append text at end of current line; stop upon **Escape** key |
| **i**              | Insert text before cursor; stop upon **Escape** key          |
| **I**              | Insert text at beginning of current line; stop upon **Escape** key |
| **o**              | Start a new line below current line, insert text there; stop upon **Escape** key |
| **O**              | Start a new line above current line, insert text there; stop upon **Escape** key |
| **r**              | Replace character at current position                        |
| **R**              | Replace text starting with current position; stop upon **Escape** key |
| **x**              | Delete character at current position                         |
| **Nx**             | Delete N characters, starting at current position            |
| **dw**             | Delete the word at the current position                      |
| **D**              | Delete the rest of the current line                          |
| **dd**             | Delete the current line                                      |
| **Ndd** or **dNd** | Delete N lines                                               |
| **u**              | Undo the previous operation                                  |
| **yy**             | Yank (copy) the current line and put it in buffer            |
| **Nyy** or **yNy** | Yank (copy) N lines and put it in buffer                     |
| **p**              | Paste at the current position the yanked line or lines from the buffer. |

Typing **sh command** opens an external command shell. When you exit the shell, you will resume your editing session.

Typing **!** executes a command from within **vi**. The command follows the exclamation point. This technique is best suited for non-interactive commands, such as **: ! wc %**. Typing this will run the **wc** (word count) command on the file; the character **%** represents the file currently being edited.