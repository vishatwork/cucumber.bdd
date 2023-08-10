Feature: Rover Direction and Position Initialization

  Background: 
    Given a new rover

  Scenario Outline: Initializing rover with valid cardinal compass point and coordinates
    When the rover is initialized with valid coordinates <x> <y> <Direction>
    Then the rover should be positioned successfully

    Examples: 
      | x  | y | Direction |
      |  1 | 1 | "North"   |
      |  0 | 0 | "East"    |
      |  0 | 1 | "South"   |
      | -1 | 0 | "West"    |

  #Below Scenario can be implemented in case if we test the functionality, Step definition is already in place
  
  #Scenario Outline: Initializing rover with invalid cardinal compass point and coordinates
  #Given a new rover
  #When the rover is initialized with invalid position "<xCord>" "<yCord>" "<position>"
  #Then the rover should return exception
  #
  #Examples:
  #| x | y | Direction |
  #| A | B |   some location |
  #| $ | ! |         * |
  #|1.43|0.2|dasd2312|
  
  
  Scenario Outline: Moving rover and verifying new position
    And the rover is initialized with valid coordinates <x> <y> <Direction>
    When the rover receive with the "<command>"
    Then the rover position should be <x_result> <y_result>
    And the rover should be facing <facing_result>

    Examples: 
      | x | y | Direction | commands   | x_result | y_result | facing_result |
      | 1 | 2 | "North"   | LMLMLMLMM  |        1 |        3 | "North"       |
      | 5 | 5 | "East"    | MMRMMRMRRM |        6 |        5 | "East"        |

  Scenario Outline: Moving rover and verifying new position with invalid command
    And the rover is initialized with valid coordinates <x> <y> <Direction>
    When the rover receive with the "<command>"
    Then the rover position should be <x> <y>
    And the rover should be facing <Direction>
    Then the rover should respond with "Speak in Mars language, please!"

    Examples: 
      | x | y | Direction | commands      |
      | 1 | 2 | "North"   |        232132 |
      | 3 | 3 | "East"    | HIOJOIJOI     |
      | 2 | 1 | "West"    | +93dsa@$%12") |
