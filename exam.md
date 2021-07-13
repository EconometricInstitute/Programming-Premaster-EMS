# Exam Introduction to Programming (FEB21011S, 2020-2021)

## Instructions

### General Instructions
- This is a closed book exam, which means that you are **not** allowed to access any outside resources, such as the course website, the book, notes or any other website.
- You are **not** allowed to use a calculator.
- You are **not** allowed to use a dictionary.
- You are **not** allowed to copy and/or disseminate exam questions and/or answers in any way. Scrap paper must be destroyed after use.
- It is **not** allowed to keep a watch within reach during the examination. Watches must be stored out of sight.
- You are allowed to use a pen and blank scrap paper (max. 5 sheets).
- Except for your PC/laptop, all mobile devices or (potential) data media must be switched off during the examination and stored out of sight.

### Programming Instructions
- You have access to the Java documentation through the `References` button in the exam environment.
- You can write your code in the exam environment or in a local code editor (development environment). The allowed local editors are IntelliJ and Eclipse. If you use a local editor, make sure to copy your code to the exam environment. **Only the code within the exam environment is considered for grading.**
- You are **not** allowed to use any existing codes that you have made or found. This means also that your IntelliJ/Eclipse project should be empty at the start of the exam.
- Follow the style guidelines of the course and add a sufficient number of comments to make your code understandable.
- Follow the naming of classes and methods as mentioned in the assignment strictly.
- Make sure to follow the output in the given examples strictly when printing output from your program.

### Additional Information
- The exam takes max. 120 minutes. During this time, it is **not** allowed to leave your seat (for example, to visit the bathroom).
- Make sure your face is visible for the webcam during the entire exam.
- It is **not** allowed to talk during the exam.
- The use of electronic headphones is **not** allowed. The use of (wax or foam) earplugs for noise reduction is allowed, but only if you show these to the webcam before use.
- Share your screen again when Proctor Exam asks you to, this may happen more than once. This is caused by minor hick-ups in the internet connection and is no reason to be alarmed.
- If you experience technical issues or have questions, you can ask for support using the button in the bottom right corner of your screen.

##### Good Luck!

[^1]: No part of this examination may be reproduced, stored in a retrieval system or transmitted in any form or by any means, without permission of the author or, when appropriate, of the Erasmus University Rotterdam.

\newpage

## Question 1: Theoretical Questions (3 + 3 points)

### Part A: Types of Errors
Explain the difference between compile-time, run-time and logical errors (also called logic errors). In particular, highlight in your answer both at which moment during the development of your code each of these types of errors can occur and in what way we can figure out what went wrong when encountering these errors.

Use **no more than 150 words** for your answer.

### Part B: Constructor and Method Overloading
Explain the concept of overloading constructors and methods. In particular, highlight in your answer both in which situations the overloading of constructors or methods is of use and how it is determined which of the overloaded constructors or methods should be run.

Use **no more than 150 words** for your answer.

## Question 2: Cash Register (1 + 1 + 3 points)
In this exercise, you will represent a cash register for a store. The products that are sold in this store can have four different before-tax prices, which are indicated on the cash register by categories. The categories and their corresponding before-tax prices are:

- Category 1: 0.99
- Category 2: 1.99
- Category 3: 4.99
- Category 4: 9.99

The sales price of a product is then determined by adding the tax that is incurred for a product to the before-tax price of the product. The tax rate can differ per product and is not related to the category of a product.

### Part A: Calculating the Before-Tax Price
Write the method
``` java
public static double computePrice(int category)
```
that determines the before-tax price for the item in a given category. The integer parameter `category` will take a value between 1 and 4 (both inclusive) which indicates the category that the product is in.

### Part B: Calculating the Sales Price
Write the method
``` java
public static double computeSalesPrice(int category, double taxRate)
```
that determines the sales (after-tax) price of a product based on the category of the item and the tax rate. The tax rate is given here as a fractional value, where `0.19`, for example, indicates a tax rate of 19%. Make sure to use the method that you have created in part A.

### Part C: The User Interface
Implement a user interface for the cash register as part of the `main` method. This user interface computes the sales price of sold products, until the user indicates to stop the sale of products. The user interface should then output the number of sold products. If at any point in time an invalid category is chosen, your program should print the text
```
Invalid category. Skipping this product.
```
and move on to the next item. You can assume that the given tax rate is always valid (non-negative). Moreover, the sales price for each item should be printed with a precision in cents, meaning that two decimals behind the decimal point should be printed, where the sales price is rounded to the closest price in cents.

Two examples of the user interface are shown below, make sure to follow these exactly. Note here that the categories and tax rates (e.g., 4, 0.19, 3, 0.05, -1 in the first example) shown in the below examples are examples of the user input and do not have to be printed in your program.

First example:
```
Category of the item (-1 to end):
4
Tax rate (in decimal format):
0.19
The sales price is: 11.89
Category of the item (-1 to end):
3
Tax rate (in decimal format):
0.05
The sales price is: 5.24
Category of the item (-1 to end):
-1
The number of sold items: 2
```

Second example:
```
Category of the item (-1 to end):
4
Tax rate (in decimal format):
0.02
The sales price is: 10.19
Category of the item (-1 to end):
8
Invalid category. Skipping this product.
Category of the item (-1 to end):
3
Tax rate (in decimal format):
0.01
The sales price is: 5.04
Category of the item (-1 to end):
-1
The number of sold items: 2
```

## Question 3: Matrix Transpose (3 points)
Transposing a matrix refers to switching the rows and columns of the matrix. In other words, the first row of the matrix now becomes the first column, the second row now becomes the second column and so on for the other rows and columns. As an example, consider the matrix
```
1 8 7 5
2 5 4 9
0 3 2 6
```
of which the transpose would be the matrix
```
1 2 0
8 5 3
7 4 2
5 9 6
```

For this question you should write a method:
```
public static void printTranspose(int[][] matrix)
```
that prints the transpose of a given matrix as passed by the parameter `matrix`. Your method should work for matrices of all dimensions, where you can assume that the matrix is rectangular (all rows of the two-dimensional array are of the same length).

For example, when your program is called as
``` java
int[][] matrix = {{1, 8, 7, 5}, {2, 5, 4, 9}, {0, 3, 2, 6}};
printTranspose(matrix);
```
the output of your code should be:
```
1 2 0
8 5 3
7 4 2
5 9 6
```

## Question 4: Soccer Scoreboard (1 + 1 + 2 + 2 + 2 points)
In this question, you will write a scoreboard for a soccer competition. In particular, you will have to write two classes: a `Goal` class and a `Scoreboard` class, where goals are registered in the scoreboard of the competition. The scoreboard then offers methods to obtain statistics about the goals scored in the competition.

*Note that you can access the different classes by clicking on the tab with the name of the class in the code editor.*


### Part A: The Goal Class
A template for the `Goal` class is already given in the code editor. The `Goal` class has three instance variables:

- `team`, which indicates the team that has scored the goal
- `player`, which indicates the player that has scored the goal
- `minute`, which indicates the minute of the game in which the goal was scored

Complete the following parts of the class:

- The constructor `public Goal(String team, String player, int minute)` which stores the team and player that scored the goal and the minute in which the goal was scored.
- The method `public String getTeam()` that returns the team that scored the goal.
- The method `public String getPlayer()` that returns the player that scored the goal.
- The method `public int getMinute()` that returns the minute in which the goal was scored.

### Part B: Adding a toString Method
Complete the `public String toString()` method of the `Goal` class. This method should return a textual representation of a goal. The output should be in the form `{player} ({team}, minute {minute})`, where the placeholders `{player}`, `{team}` and `{minute}` refer respectively to the player and team that scored the goal, and the minute in which the goal was scored.

For example, the code:
``` java
Goal goal = new Goal("Barcelona", "Messi", 12);
System.out.println(goal);
```
should return the output:
```
Messi (Barcelona, minute 12)
```

### Part C: The Scoreboard Class
A template for the Scoreboard class is already given in the code editor. Complete the following parts of the `Scoreboard` class:

- The constructor `public Scoreboard(String competition)` that initializes an empty scoreboard for a given competition, where `competition` is the name of the competition.
- The method `public String getCompetition()` that returns the name of the competition.
- The method `public void addGoal(Goal goal)` that adds a goal to the scoreboard.
- The method `public List<Goal> getGoals()` that returns all goals scored in the competition.

For this question, you should decide yourself on the instance variables that need to be used.

### Part D: Latest Scored Goal in Competition
In this part, we want to create a method that allows us to determine the latest goal, in terms of the minute scored, that was scored. Create the method
```
public Goal getLatestGoal()
```
that returns the goal in the scoreboard that was scored the latest. If no goals are yet present in the scoreboard, the method should return a `null` reference. Moreover, If there are multiple latest goals (i.e. multiple goals scored in that same minute), your method can return any of those.

For example, if your program is run as:
``` java
Scoreboard scoreboard = new Scoreboard("Champions League");
scoreboard.addGoal(new Goal("Barcelona", "Messi", 18));
scoreboard.addGoal(new Goal("Juventus", "Ronaldo", 24));
scoreboard.addGoal(new Goal("Valencia", "Zaza", 73));
scoreboard.addGoal(new Goal("Barcelona", "De Jong", 58));

System.out.println(scoreboard.getLatestGoal());
```

the following output should be returned:
```
Zaza (Valencia, minute 73)
```

### Part E: Minutes Scored
In this part, we want to determine the minutes of the played games in which a certain team scored its goals. Write the method:
```
public List<Integer> getMinutesScored(String team)
```
that returns all the minutes in which the team indicated by the parameter `team` scored. If a team scored multiple times in the same minute, then that minute should be contained only once in the returned list.

For example, if your program is run as:
``` java
Scoreboard scoreboard = new Scoreboard("Champions League");
scoreboard.addGoal(new Goal("Barcelona", "Messi", 18));
scoreboard.addGoal(new Goal("Juventus", "Ronaldo", 24));
scoreboard.addGoal(new Goal("Barcelona", "Neymar", 49));
scoreboard.addGoal(new Goal("Barcelona", "Messi", 49));
scoreboard.addGoal(new Goal("Barcelona", "De Jong", 84));

System.out.println(scoreboard.getMinutesScored("Barcelona"));
```

the following output should be returned:
```
[18, 49, 84]
```

Note that the list containing the minutes scored does **not** have to be sorted, meaning that you could also return a list that contains these same elements in a different order.
