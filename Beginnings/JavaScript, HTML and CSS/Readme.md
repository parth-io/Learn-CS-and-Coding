 

You learnt so much advanced JavaScript, and have forgotten so much of it.

This is meant to serve as a compilation of whatever you can remember having learnt, when you remember.

JS

1. `for ... of` vs `for ... in`

   1. You could also iterate over an array using a `for... in` loop, however this does not iterate over the array elements, but the array indices. Furthermore, if someone added new properties to `Array.prototype`, they would also be iterated over by such a loop. Therefore this loop type is not recommended for arrays.

2. `call(), apply(), bind()`

   1. `apply()` can be replaced by the spread operators

3. Closures

4. Class vs Prototype

   1. https://www.toptal.com/javascript/es6-class-chaos-keeps-js-developer-up

5. `Function()` vs `eval()`

6. `defer` vs `await`

7. `async and await` vs `.then()`

8. Destructuring

9. Best practices I've forgotten about/Ways to shorten code and make it more readable

   1. The length of a function should be <= 7 lines, 10-12 for the more exceptional ones.
   2. https://deepsource.io/blog/javascript-code-quality-best-practices/
   3. [Optional chaining](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining)
   4. https://modernweb.com/45-javascript-tips-tricks-practices/
   5. https://github.com/rwaldron/idiomatic.js
   6. https://jstherightway.org/#js-code-style
   7. https://thewebdev.info/category/javascript/javascript-best-practices/
   8. With multiple if checks,  do a `return`  at the end of each if check
   9. Chaining promises and functions in JS
      1. `const x = await getProducts({id, result: true, source})
                 .then((products) => generateQuery(id, products)) //One-liner functions don't need a return statement
                 .then(uploadQuery) //Note here how we do not need to specify a parameter, the function uploadQuery takes in the result of generateQuery() as its argument automatically
                 .catch(onError) //similarly, onError takes in the argument automatically`

10. Some npm libraries I used

    1. winston

    2. yargs

    3.     "aws-sdk": "2.727.1",
           "aws-serverless-express": "3.3.5",
           "axios": "^0.21.1",
           "base64-stream": "1.0.0",
           "body-parser": "1.17.1",
           "detect-character-encoding": "^0.8.0",
           "express": "4.15.2",
           "imap": "0.8.19",
           "lodash": "4.17.21",
           "multer": "^1.4.2",
           "node-cron": "^3.0.0",
           "papaparse": "5.3.0",
           "pdf-parse": "^1.1.1",
           "pdfreader": "^1.2.8"
           "aws-amplify": "2.2.5",
           "cheerio": "1.0.0-rc.9",
           "commander": "7.2.0",
           "dayjs": "1.10.5",
           "express": "4.17.1",
           "extendify": "1.0.0",
           "lodash": "4.17.15",
           "nanoid": "3.1.23",
           "promise-throttle": "1.0.1",
           "semaphore-async-await": "1.5.1",
           "threads": "1.6.5"
           "extendify": "~1.0.0",

CSS and HTML

1. Arranging blocks
   1. Block, Inline, and Inline-Block
   2. Flex --> note that you would use inline/inline-block for some cases, and flex for others
   3. New feature - https://developer.mozilla.org/en-US/docs/Web/CSS/display/two-value_syntax_of_display
2. Icons
   1. https://react-icons.github.io/react-icons/
3. CSS
   1. https://tailwindcss.com/
