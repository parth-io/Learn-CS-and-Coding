The **emacs** editor is a popular competitor for **vi**. Unlike **vi**, it does not work with modes. **emacs** is highly customizable and includes a large number of features. It was  initially designed for use on a console, but was soon adapted to work  with a GUI as well. **emacs** has many other capabilities other than simple text editing. For example, it can be used for email, debugging, etc.

Rather than having different modes for command and insert, like vi, **emacs** uses the **CTRL** and Meta **(Alt** or **Esc)** keys for special commands.

The table lists some of the most important key combinations that are used when starting, exiting, reading, and writing files in **emacs**.

| **Key**           | **Usage**                                            |
| ----------------- | ---------------------------------------------------- |
| **emacs myfile**  | Start **emacs** and edit **myfile**                  |
| **CTRL-x i**      | Insert prompted for file at current position         |
| **CTRL-x s**      | Save all files                                       |
| **CTRL-x CTRL-w** | Write to the file giving a new name when prompted    |
| **CTRL-x CTRL-s** | Saves the current file                               |
| **CTRL-x CTRL-c** | Exit after being prompted to save any modified files |

The **emacs** tutorial is a good place to start learning basic commands. It is available any time when in **emacs** by simply typing **CTRL-h** (for help) and then the letter **t** for tutorial.

The table lists some of the keys and key combinations that are used for changing cursor positions in **emacs**.

| **Key**                     | **Usage**                                             |
| --------------------------- | ----------------------------------------------------- |
| Arrow keys                  | Use the arrow keys for up, down, left and right       |
| **CTRL-n**                  | One line down                                         |
| **CTRL-p**                  | One line up                                           |
| **CTRL-f**                  | One character forward/right                           |
| **CTRL-b**                  | One character back/left                               |
| **CTRL-a**                  | Move to beginning of line                             |
| **CTRL-e**                  | Move to end of line                                   |
| **Meta-f**                  | Move to beginning of next word                        |
| **Meta-b**                  | Move back to beginning of preceding word              |
| **Meta-<**                  | Move to beginning of file                             |
| **Meta-g-g-n**              | Move to line n (can also use '**Esc-x Goto-line n**') |
| **Meta->**                  | Move to end of file                                   |
| **CTRL-v** or **Page Down** | Move forward one page                                 |
| **Meta-v** or **Page Up**   | Move backward one page                                |
| **CTRL-l**                  | Refresh and center screen                             |

The table lists the key combinations that are used for searching for text in **emacs**.

| **Key**    | **Usage**                                                  |
| ---------- | ---------------------------------------------------------- |
| **CTRL-s** | Search forward for prompted pattern, or for next pattern   |
| **CTRL-r** | Search backwards for prompted pattern, or for next pattern |

The table lists some of the key combinations used for changing, adding, and deleting text in **emacs:**

| **Key**                         | **Usage**                                                    |
| ------------------------------- | ------------------------------------------------------------ |
| **CTRL-o**                      | Insert a blank line                                          |
| **CTRL-d**                      | Delete character at current position                         |
| **CTRL-k**                      | Delete the rest of the current line                          |
| **CTRL-_**                      | Undo the previous operation                                  |
| **CTRL-** (space or **CTRL-@**) | Mark the beginning of the selected region. The end will be at the cursor position |
| **CTRL-w**                      | Delete the current marked text and write it to the buffer    |
| **CTRL-y**                      | Insert at current cursor location whatever was most recently deleted |