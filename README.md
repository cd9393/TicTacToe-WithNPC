"# TicTacToe-WithNPC" 

<h1>STAGE 1 -- </h1>
<p>The program should work in the following way:</p>
<ul>
  <li>Ask the user to provide the initial state of the 3x3 table with the first input line. This must include nine symbols that can be X, O or _ (the latter represents an empty cell).Output the specified 3x3 table before the user makes a move. 
  </li>
  <li>
    Ask the user to provide the initial state of the 3x3 table with the first input line. This must include nine symbols that can be X, O or _ (the latter represents an empty cell).Output the specified 3x3 table before the user makes a move.
  </li>
  <li>
    Ask the user to provide the initial state of the 3x3 table with the first input line. This must include nine symbols that can be X, O or _ (the latter represents an empty cell).Output the specified 3x3 table before the user makes a move.
  </li>
  <li>
    Request that the user enters the coordinates of the move they wish to make.
  </li>
  <li>
    The user then inputs two numbers representing the cell in which they wish to place their X or O. The game always starts with X, so the user's move should be made with this symbol if there are an equal number of X's and O's in the table. If the table contains an extra X, the move should be made with O.
  </li>
  <li>
    Analyze the user input and show messages in the following situations:
• This cell is occupied! Choose another one! — if the cell is not empty;
• You should enter numbers! — if the user tries to enter letters or symbols instead of numbers;
• Coordinates should be from 1 to 3! — if the user attempts to enter coordinates outside of the table's range.
  </li>
  <li>
    Display the table again with the user's most recent move included.
  </li>
  <li>
    Output the state of the game.
The possible states are:

Game not finished — when no side has three in a row, but the table still has empty cells;
Draw — when no side has three in a row, and the table is complete;
X wins — when there are three X's in a row;
O wins — when there are three O's in a row.
If the user provides invalid coordinates, the program should repeat the request until numbers that represent an empty cell on the table are supplied. You should ensure that the program only outputs the table twice — before the move and after the user makes a legal move.
  </li>
</ul>
