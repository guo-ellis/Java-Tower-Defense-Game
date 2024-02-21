# Java-Tower-Defense-Game
Tower Defense games are strategy games where the goal is to defend the player’s territories by obstructing the advance of the enemies troops. In this game, it's bees vs hornets fighting on Tiles. 

**Tile:**
Represents a square on the game board.
Contains fields for food, bee hive, hornet nest, path presence, adjacent tiles, and insects positioned on it.
Methods to manipulate and retrieve information about the tile and its contents.

**Insect:**
Abstract class representing an insect in the game.
Has fields for position and health points, with methods to retrieve and update them.
Includes a method for taking damage and an abstract method for taking action.

**Hornet:**
Subclass of Insect representing a hornet.
Includes an attack damage field and methods for initializing and taking actions.

**HoneyBee:**
Abstract subclass of Insect representing a honey bee.
Includes a field for food cost and methods for initialization and retrieving the cost.

**BusyBee:**
Subclass of HoneyBee representing bees collecting pollen.
Includes fields for base health and cost, with methods for initialization and taking action.

**AngryBee:**
Subclass of HoneyBee representing aggressive bees.
Contains fields for attack damage, base health, and cost, with methods for initialization and taking action.

**SwarmOfHornets:**
Represents a group of hornets.
Uses an array to store hornets and includes methods for adding, removing, and retrieving hornets.
These classes lay the foundation for implementing game mechanics and interactions between insects in the game.
