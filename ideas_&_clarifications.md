# Coding-Puzzle 

***
**Aspects**
Code quality & design.
Code coverage.
Test

**How game will be**
1. I will create a grid (which is also called palace) which is of 100 rooms. 
2. Player will enter each room at a time. If he sees puzzle at the room and he answers for it, he will get the points. 
3. Player will be a boss when he creates a character.

***
**Requirements:**
**Important clarification:**
Is it a multi player game or single player game(Player and Enemy)?
    
***    
**As a player I want to create a character**
1. How many characters can be created by a player?
    - Can player pay for character creation?
      - It should be yes in order to limit creating the characters.
2. What is the initial health or points given to character?
    - 100 points as health(Max health point is also 100 points).
  
3. Can player create and send more characters to the battle? 
    - If yes, how two characters created by a player are known to eachother. 
        - It can be identified by an identifier.
    - In which direction will they go to attack the enemy?
        - Top down or bottom up.
4. Can player create character with resources?
   - If yes, does he pay some points to get that.
5. Can I have some default characters in the game?
   - As of now, Boss and Enemy
   
6. If character or player finds a resource, ask puzzle here to get the resource? 
    - If he answers, he will get the resource. 
    - Else, he can go to next room.
7. What is the maximum points or strength a character can hold?
8. How a character is powerful?
9. Does player controls the navigation of the character? 

***  
**As a player I want to explore**
1. How will player explore the game? 
    - Through answering the puzzle or fighting against the enemy.
2. Can player answer for the puzzle when they try to access the resource?
    - Yes, he needs to answer the puzzle.
3. Does the game give some hints or tips to get the exploration?
    - Yes, I will need to provide some tips to get explored and for the puzzle. 

***
**As a player I want to gain experience through fighting**
1. How a player will fight with enemy? With or without resources?
2. What he will get if the player wins the enemy?
    - He will be winner title.
3. Will player ask for a help? 
    - If he needs help, points can be deducted and provide the power or health.
4. Will player ask for a giveup?
    - Yes, He will.
5. how does the player boost his strength to fight?
    - By answering the puzzle.
***
**As a player I want to save and resume a game**
1. What will happen if the machine abnormally stops?
    - Timely save will help in this case.
2. Is it a timely save?
    - It will be more effective.
3. Will ask player for save when he quits the game?
    - Yes, better to ask the player when he quits
4. How I store the positions of enemy and the player to identify for game resume?
    - some xx(10,9) and yy(9,7)
