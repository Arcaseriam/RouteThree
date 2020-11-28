package battle;

import data_struct.PlayerPokemon;

public interface Battleable {
    // makes pokemon p get exp from this object
    void battle(PlayerPokemon p, BattleOptions options);
}
