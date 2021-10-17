# Solver for the Snake Cube Puzzle

![snake](docs/snake.jpeg)
![cube](docs/cube.jpeg)

For the snake of the shape (`-` is straight, `.` is corner) 

```
--...-..-...-.-....-.-.-.--
```
it prints two solutions. 
The syntax is borrowed from https://www.jaapsch.net/puzzles/snakecube.htm.
>  The solutions will also be given using the letters F, L, U, B, R, D standing for the six directions in space where the next cube might be, viz. Front, Left, Up, Back, Right, Down respectively.


```
winners:

Start: 0,0,0
F F R B U U R D D F U L L B B R D R U U L L F F R R R 
Y\X  Z0     Z1     Z2
     ↓→Z    →zZ    ↓←←    
     ↓Z↓    ↑Zz    ↓→z    
     →↑Z    ↑←←    →→→    
     

Start: 0,0,0
F F U B R R U L L F R D D B B U L U R R D D F F U U U 
Y\X  Z0     Z1     Z2
     ↓Z↓    Z←z    →→z    
     ↓↑↓    →→Z    ↓←←    
     Z↑Z    ↑zZ    →zZ    
     

     
```


It also works with any other snake shape and cube size. 

## See also
 - https://www.jaapsch.net/puzzles/snakecube.htm