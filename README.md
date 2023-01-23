# PONG_JAVA
A simple Java Game which utilises concepts from OOP.
Disclaimer : This Game's code was  heaviliy inspired by @GamesWithGabe 's Youtube playlist 
link to it is here : https://www.youtube.com/watch?v=-uEFy0nPlgM&list=PLtrSb4XxIVborujf7DDM2MCi6yyMCw46d

the functionality has a few tweaks from the original buit 
such as 
1)Player and Computer paddles having restricted access to both Right and left directions of their respective screen area
ie: positive and negative X-axis
2)The Ball has updated physics logic which i'll explain in just a bit 
so instead of the ball having a constant velocity of vx & vy 
i made it so that the difference between the screen_width/2 and the balla X coordinate is the factor by which the new velocity component Vx and Vy get multiplied by , so that when the paddles are far back the balls speed is maximun , and the closer the ball is to the centre the less is it's velocity.
thereby making the game more fun.
i'm still trying to learn so feel free to criticise where needed. =)
