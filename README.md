# Final-project
Name of your final project: Text-Adventure 
Group: SE-2222
Team members: Alikhan Tileubay
Project Overview:
• Provide some information about your project. It is a small game, where you will able to move, attack monsters and use potions to heal.
• Describe the idea of the project. The main idea of the project is to create a game.
• The purpose of the work. To create an engaging and interactive game that allows players to explore a virtual world, battle monsters, and achieve specific objectives.
• The objectives of the work. Develop a Functional Game Engine:
    Objective: Design and implement a robust game engine capable of handling player movements, combat, and interactions within a virtual environment.
    Create Diverse Monster Types:
    Objective: Implement a variety of monster types with distinct characteristics, such as health, damage, and attack strategies.
    Implement Player-Game Interaction:
    Objective: Allow players to move within the game world, engage in combat with monsters, pick up items, and use them strategically.
    Incorporate Design Patterns:
    Objective: Integrate relevant design patterns (e.g., Singleton, Factory, Observer) to improve code structure, maintainability, and scalability.
    Provide a Command-Line Interface:
    Objective: Develop a user-friendly command-line interface (CLI) to facilitate player input and interaction with the game.
    Ensure Game Stability and Bug-Free Operation:
    Objective: Conduct thorough testing to identify and resolve any bugs or issues, ensuring a stable and enjoyable gaming experience.

Main Body:

Singleton Pattern (GameManager):
The GameManager class implements the Singleton pattern using the static getInstance method.

Factory Method Pattern (MonsterFactory, SimpleMonsterFactory, StrongMonsterFactory):
The classes mentioned above implement the Factory Method pattern. They create instances of monsters with different characteristics.

Strategy Pattern (Monster Classes - Skeleton, Goblin, Hobgoblin, Orc):
The code appears to use the Strategy pattern for handling monster attacks. Different monster types implement attack strategies through the attack method.
Observer Pattern (Observer Interface, RoomObserver):

The Observer pattern is employed. The Observer interface and the RoomObserver class suggest that RoomObserver registers with GameManager as an observer and receives notifications about player movements.

Facade Pattern (GameManager):
The GameManager class serves as a potential facade, providing a simplified interface for interacting with the game world.

Builder Pattern (Potential Future Use):
The current code creates instances of monsters and rooms in the Main class. Depending on the project's future direction, using the Builder pattern for creating complex structures might be beneficial.

Conclusion:
• Key points of your project. The text-based game project successfully achieved its key objectives, providing an engaging and interactive gaming experience. Key points of the project include the implementation of various game features, the incorporation of design patterns for code organization, and the successful integration of a command-line interface (CLI) for user interaction.
• Project outcomes. Challenges faced. The project successfully delivered a functional text-based game with features such as player movement, combat with diverse monster types, item pickup, and strategic item usage. The CLI provided an intuitive interface for user input, contributing to a seamless gaming experience.
Challenges Faced:
While developing the project, some challenges were encountered, including:
Design Complexity:
Balancing the complexity of the game design to make it engaging while keeping the codebase manageable required careful consideration and iterative development.
Testing and Bug Resolution:
Ensuring the stability of the game and resolving unexpected bugs during testing posed challenges, emphasizing the importance of thorough testing.
• Future improvements. Several areas for future improvement and expansion of the project include:
Graphics and User Interface (UI):
Enhancing the user experience by incorporating graphics and a graphical user interface (GUI) for a more visually appealing game.
Expanded Storyline:
Developing a more intricate and expansive storyline to further immerse players in the game world and provide additional motivation for exploration.
Multiplayer Functionality:
Introducing multiplayer capabilities to allow players to interact and collaborate within the game environment.
Additional Features:
Implementing new features such as character customization, additional monster types, and diverse environments to broaden the game's scope and replayability.

