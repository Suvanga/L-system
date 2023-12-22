L-Systems are used to describe plant growth. They are based on grammars and have minimal symbols.Inourcase,thesymbolsareuppercasealphabeticletters,‘[‘,‘]’,‘+’,and‘-‘. A grammar for a simple L-system is:
δ = 90 degrees StartPattern:F–F–F–F FFF–F–F-F-F-F+F
Starting up:
Initially, the start pattern is added to a queue
While the number of times to expand the symbols is greater than zero:
A special character is added to the end of the string to mark the end of the pattern.
Characters are removed from the queue one at a time. If they are not an upper- case alphabetic character they are simply added to the end of the queue. If they are an upper-case alphabetic character the expansion (right hand side of the production) is added to the queue one character at a time.
When the end of the string mark is removed from the queue decrement the number of times to expand the symbols
The system can be expanded any number of times using this procedure. Once it has been sufficiently expanded then the string is used to draw the plant or object. In doing the draw, a letter represents drawing a line segment, the – represents a clockwise (right) turn of how ever many degrees the system is set up for, a + represents a counterclockwise (left) turn of how ever many degrees the system is set up for, ‘[‘ pushes the current state of the system (position and angle) onto a stack, and ‘]’ pops a state off the stack and uses it as the new position and angle.
We are not concerned with drawing the resultingobject. You will simply expand and output the final string.

Input:

The input for this project is organized as:
angle (a real value)
starting pattern – symbols separated by spaces.
Number of Rules (an integer)
Rule 1 – symbols separated by spaces and no arrow – the arrow is implied after the first symbol. Rule 2
...
Rule n
The number of times to expand the sequence (an integer)
So, for the example above you would read in:
90.0 F–F–F–F 1
F FF–F–F-F-F-F+F
2

Output: 

Your output should be the resulting characters from the queue after the given number of expansions.
