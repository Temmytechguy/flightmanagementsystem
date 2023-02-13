Feature: Statistics Policy
  The company follows a statistics about the flights, the passengers and the distance they travel

  Scenario Outline: Calculate total distance
    Given There is a usual passenger
    And there is a VIP passenger
    When the usual passenger travels distance <distance1> and <distance2> and <distance3>
    And the VIP passenger travels distance <distance4> and <distance5> and <distance6>
    Then the total travel distance should be <total_distance>

    Examples:
      | distance1 | distance2 | distance3| distance4 | distance5 | distance6  | total_distance  |
      | 349       | 319       | 623      | 164       |  234      |   233      |   1922          |
      | 312       | 356       | 135      | 420       |  123      |   441      |   1787          |
      | 223       | 786       | 503      | 275       |  221      |   231      |   2239          |
      | 482       | 98        | 591      | 158       |  127      |   228      |   1684          |
      | 128       | 176       | 304      | 320       |  101      |   541      |   1570          |
