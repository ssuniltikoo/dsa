package dev.dp.machinecode.cards;

 interface Game {
    Game startGame();
    void distributeCards(Player players,Cards cards);
    Player declareWinner();
}

