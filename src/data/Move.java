package data;

import utility.LookupTable;

public enum Move {
	// see : https://github.com/pret/pokeruby/blob/f839afb24aa2c7b70e9c28a5c069aacc46993099/src/data/battle_moves.c
	//           displayName    , moveEffect                       , power, type    , accuracy,  pp, secondaryEffectChance, target   , priority, flags...
	NONE        ("-"            , MoveEffect.HIT                     ,   0, Type.NORMAL  ,   0,   0,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	POUND       ("POUND"        , MoveEffect.HIT                     ,  40, Type.NORMAL  , 100,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	KARATECHOP  ("KARATE CHOP"  , MoveEffect.HIGH_CRITICAL           ,  50, Type.FIGHTING, 100,  25,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	DOUBLESLAP  ("DOUBLE SLAP"  , MoveEffect.MULTI_HIT               ,  15, Type.NORMAL  ,  85,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	COMETPUNCH  ("COMET PUNCH"  , MoveEffect.MULTI_HIT               ,  18, Type.NORMAL  ,  85,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MEGAPUNCH   ("MEGA PUNCH"   , MoveEffect.HIT                     ,  80, Type.NORMAL  ,  85,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	PAYDAY      ("PAY DAY"      , MoveEffect.PAY_DAY                 ,  40, Type.NORMAL  , 100,  20, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FIREPUNCH   ("FIRE PUNCH"   , MoveEffect.BURN_HIT                ,  75, Type.FIRE    , 100,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ICEPUNCH    ("ICE PUNCH"    , MoveEffect.FREEZE_HIT              ,  75, Type.ICE     , 100,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	THUNDERPUNCH("THUNDER PUNCH", MoveEffect.PARALYZE_HIT            ,  75, Type.ELECTRIC, 100,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SCRATCH     ("SCRATCH"      , MoveEffect.HIT                     ,  40, Type.NORMAL  , 100,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	VICEGRIP    ("VICE GRIP"    , MoveEffect.HIT                     ,  55, Type.NORMAL  , 100,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	GUILLOTINE  ("GUILLOTINE"   , MoveEffect.OHKO                    ,   1, Type.NORMAL  ,  30,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	RAZORWIND   ("RAZOR WIND"   , MoveEffect.RAZOR_WIND              ,  80, Type.NORMAL  , 100,  10,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SWORDSDANCE ("SWORDS DANCE" , MoveEffect.ATTACK_UP_2             ,   0, Type.NORMAL  ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	CUT         ("CUT"          , MoveEffect.HIT                     ,  50, Type.NORMAL  ,  95,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	GUST        ("GUST"         , MoveEffect.GUST                    ,  40, Type.FLYING  , 100,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	WINGATTACK  ("WING ATTACK"  , MoveEffect.HIT                     ,  60, Type.FLYING  , 100,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	WHIRLWIND   ("WHIRLWIND"    , MoveEffect.ROAR                    ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,  -6, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FLY         ("FLY"          , MoveEffect.FLY                     ,  70, Type.FLYING  ,  95,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	BIND        ("BIND"         , MoveEffect.TRAP                    ,  15, Type.NORMAL  ,  75,  20, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SLAM        ("SLAM"         , MoveEffect.HIT                     ,  80, Type.NORMAL  ,  75,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	VINEWHIP    ("VINE WHIP"    , MoveEffect.HIT                     ,  35, Type.GRASS   , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	STOMP       ("STOMP"        , MoveEffect.FLINCH_HIT_2            ,  65, Type.NORMAL  , 100,  20,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	DOUBLEKICK  ("DOUBLE KICK"  , MoveEffect.DOUBLE_HIT              ,  30, Type.FIGHTING, 100,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MEGAKICK    ("MEGA KICK"    , MoveEffect.HIT                     , 120, Type.NORMAL  ,  75,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	JUMPKICK    ("JUMP KICK"    , MoveEffect.RECOIL_IF_MISS          ,  70, Type.FIGHTING,  95,  25,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ROLLINGKICK ("ROLLING KICK" , MoveEffect.FLINCH_HIT              ,  60, Type.FIGHTING,  85,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SANDATTACK  ("SAND ATTACK"  , MoveEffect.ACCURACY_DOWN           ,   0, Type.GROUND  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	HEADBUTT    ("HEADBUTT"     , MoveEffect.FLINCH_HIT              ,  70, Type.NORMAL  , 100,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	HORNATTACK  ("HORN ATTACK"  , MoveEffect.HIT                     ,  65, Type.NORMAL  , 100,  25,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	FURYATTACK  ("FURY ATTACK"  , MoveEffect.MULTI_HIT               ,  15, Type.NORMAL  ,  85,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	HORNDRILL   ("HORN DRILL"   , MoveEffect.OHKO                    ,   1, Type.NORMAL  ,  30,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	TACKLE      ("TACKLE"       , MoveEffect.HIT                     ,  35, Type.NORMAL  ,  95,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	BODYSLAM    ("BODY SLAM"    , MoveEffect.PARALYZE_HIT            ,  85, Type.NORMAL  , 100,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	WRAP        ("WRAP"         , MoveEffect.TRAP                    ,  15, Type.NORMAL  ,  85,  20, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	TAKEDOWN    ("TAKE DOWN"    , MoveEffect.RECOIL                  ,  90, Type.NORMAL  ,  85,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	THRASH      ("THRASH"       , MoveEffect.RAMPAGE                 ,  90, Type.NORMAL  , 100,  20, 100, MoveTarget.RANDOM          ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	DOUBLEEDGE  ("DOUBLE EDGE"  , MoveEffect.DOUBLE_EDGE             , 120, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	TAILWHIP    ("TAIL WHIP"    , MoveEffect.DEFENSE_DOWN            ,   0, Type.NORMAL  , 100,  30,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	POISONSTING ("POISON STING" , MoveEffect.POISON_HIT              ,  15, Type.POISON  , 100,  35,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	TWINEEDLE   ("TWINEEDLE"    , MoveEffect.TWINEEDLE               ,  25, Type.BUG     , 100,  20,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	PINMISSILE  ("PIN MISSILE"  , MoveEffect.MULTI_HIT               ,  14, Type.BUG     ,  85,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	LEER        ("LEER"         , MoveEffect.DEFENSE_DOWN            ,   0, Type.NORMAL  , 100,  30,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	BITE        ("BITE"         , MoveEffect.FLINCH_HIT              ,  60, Type.DARK    , 100,  25,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	GROWL       ("GROWL"        , MoveEffect.ATTACK_DOWN             ,   0, Type.NORMAL  , 100,  40,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	ROAR        ("ROAR"         , MoveEffect.ROAR                    ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,  -6, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SING        ("SING"         , MoveEffect.SLEEP                   ,   0, Type.NORMAL  ,  55,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	SUPERSONIC  ("SUPERSONIC"   , MoveEffect.CONFUSE                 ,   0, Type.NORMAL  ,  55,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	SONICBOOM   ("SONIC BOOM"   , MoveEffect.SONICBOOM               ,   1, Type.NORMAL  ,  90,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DISABLE     ("DISABLE"      , MoveEffect.DISABLE                 ,   0, Type.NORMAL  ,  55,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	ACID        ("ACID"         , MoveEffect.DEFENSE_DOWN_HIT        ,  40, Type.POISON  , 100,  30,  10, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	EMBER       ("EMBER"        , MoveEffect.BURN_HIT                ,  40, Type.FIRE    , 100,  25,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FLAMETHROWER("FLAMETHROWER" , MoveEffect.BURN_HIT                ,  95, Type.FIRE    , 100,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MIST        ("MIST"         , MoveEffect.MIST                    ,   0, Type.ICE     ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	WATERGUN    ("WATER GUN"    , MoveEffect.HIT                     ,  40, Type.WATER   , 100,  25,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	HYDROPUMP   ("HYDRO PUMP"   , MoveEffect.HIT                     , 120, Type.WATER   ,  80,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SURF        ("SURF"         , MoveEffect.HIT                     ,  95, Type.WATER   , 100,  15,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	ICEBEAM     ("ICE BEAM"     , MoveEffect.FREEZE_HIT              ,  95, Type.ICE     , 100,  10,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BLIZZARD    ("BLIZZARD"     , MoveEffect.FREEZE_HIT              , 120, Type.ICE     ,  70,   5,  10, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	PSYBEAM     ("PSYBEAM"      , MoveEffect.CONFUSE_HIT             ,  65, Type.PSYCHIC , 100,  20,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BUBBLEBEAM  ("BUBBLE BEAM"  , MoveEffect.SPEED_DOWN_HIT          ,  65, Type.WATER   , 100,  20,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	AURORABEAM  ("AURORA BEAM"  , MoveEffect.ATTACK_DOWN_HIT         ,  65, Type.ICE     , 100,  20,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	HYPERBEAM   ("HYPER BEAM"   , MoveEffect.RECHARGE                , 150, Type.NORMAL  ,  90,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	PECK        ("PECK"         , MoveEffect.HIT                     ,  35, Type.FLYING  , 100,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	DRILLPECK   ("DRILL PECK"   , MoveEffect.HIT                     ,  80, Type.FLYING  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SUBMISSION  ("SUBMISSION"   , MoveEffect.RECOIL                  ,  80, Type.FIGHTING,  80,  25,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	LOWKICK     ("LOW KICK"     , MoveEffect.LOW_KICK                ,   1, Type.FIGHTING, 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	COUNTER     ("COUNTER"      , MoveEffect.COUNTER                 ,   1, Type.FIGHTING, 100,  20,   0, MoveTarget.SPECIAL         , - 5, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.MAKES_CONTACT),
	SEISMICTOSS ("SEISMIC TOSS" , MoveEffect.LEVEL_DAMAGE            ,   1, Type.FIGHTING, 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	STRENGTH    ("STRENGTH"     , MoveEffect.HIT                     ,  80, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ABSORB      ("ABSORB"       , MoveEffect.ABSORB                  ,  20, Type.GRASS   , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MEGADRAIN   ("MEGA DRAIN"   , MoveEffect.ABSORB                  ,  40, Type.GRASS   , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	LEECHSEED   ("LEECH SEED"   , MoveEffect.LEECH_SEED              ,   0, Type.GRASS   ,  90,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	GROWTH      ("GROWTH"       , MoveEffect.SPECIAL_ATTACK_UP       ,   0, Type.NORMAL  ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	RAZORLEAF   ("RAZOR LEAF"   , MoveEffect.HIGH_CRITICAL           ,  55, Type.GRASS   ,  95,  25,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SOLARBEAM   ("SOLAR BEAM"   , MoveEffect.SOLARBEAM               , 120, Type.GRASS   , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	POISONPOWDER("POISON POWDER", MoveEffect.POISON                  ,   0, Type.POISON  ,  75,  35,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	STUNSPORE   ("STUN SPORE"   , MoveEffect.PARALYZE                ,   0, Type.GRASS   ,  75,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	SLEEPPOWDER ("SLEEP POWDER" , MoveEffect.SLEEP                   ,   0, Type.GRASS   ,  75,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	PETALDANCE  ("PETAL DANCE"  , MoveEffect.RAMPAGE                 ,  70, Type.GRASS   , 100,  20, 100, MoveTarget.RANDOM          ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	STRINGSHOT  ("STRING SHOT"  , MoveEffect.SPEED_DOWN              ,   0, Type.BUG     ,  95,  40,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	DRAGONRAGE  ("DRAGON RAGE"  , MoveEffect.DRAGON_RAGE             ,   1, Type.DRAGON  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FIRESPIN    ("FIRE SPIN"    , MoveEffect.TRAP                    ,  15, Type.FIRE    ,  70,  15, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	THUNDERSHOCK("THUNDER SHOCK", MoveEffect.PARALYZE_HIT            ,  40, Type.ELECTRIC, 100,  30,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	THUNDERBOLT ("THUNDERBOLT"  , MoveEffect.PARALYZE_HIT            ,  95, Type.ELECTRIC, 100,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	THUNDERWAVE ("THUNDER WAVE" , MoveEffect.PARALYZE                ,   0, Type.ELECTRIC, 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	THUNDER     ("THUNDER"      , MoveEffect.THUNDER                 , 120, Type.ELECTRIC,  70,  10,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	ROCKTHROW   ("ROCK THROW"   , MoveEffect.HIT                     ,  50, Type.ROCK    ,  90,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	EARTHQUAKE  ("EARTHQUAKE"   , MoveEffect.EARTHQUAKE              , 100, Type.GROUND  , 100,  10,   0, MoveTarget.ALL_EXCEPT_USER ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FISSURE     ("FISSURE"      , MoveEffect.OHKO                    ,   1, Type.GROUND  ,  30,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DIG         ("DIG"          , MoveEffect.FLY                     ,  60, Type.GROUND  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	TOXIC       ("TOXIC"        , MoveEffect.TOXIC                   ,   0, Type.POISON  ,  85,  10, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	CONFUSION   ("CONFUSION"    , MoveEffect.CONFUSE_HIT             ,  50, Type.PSYCHIC , 100,  25,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	PSYCHIC     ("PSYCHIC"      , MoveEffect.SPECIAL_DEFENSE_DOWN_HIT,  90, Type.PSYCHIC , 100,  10,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	HYPNOSIS    ("HYPNOSIS"     , MoveEffect.SLEEP                   ,   0, Type.PSYCHIC ,  60,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	MEDITATE    ("MEDITATE"     , MoveEffect.ATTACK_UP               ,   0, Type.PSYCHIC ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	AGILITY     ("AGILITY"      , MoveEffect.SPEED_UP_2              ,   0, Type.PSYCHIC ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	QUICKATTACK ("QUICK ATTACK" , MoveEffect.QUICK_ATTACK            ,  40, Type.NORMAL  , 100,  30,   0, MoveTarget.SELECTED_POKEMON,   1, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	RAGE        ("RAGE"         , MoveEffect.RAGE                    ,  20, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	TELEPORT    ("TELEPORT"     , MoveEffect.TELEPORT                ,   0, Type.PSYCHIC ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	NIGHTSHADE  ("NIGHT SHADE"  , MoveEffect.LEVEL_DAMAGE            ,   1, Type.GHOST   , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MIMIC       ("MIMIC"        , MoveEffect.MIMIC                   ,   0, Type.NORMAL  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_PROTECT),
	SCREECH     ("SCREECH"      , MoveEffect.DEFENSE_DOWN_2          ,   0, Type.NORMAL  ,  85,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	DOUBLETEAM  ("DOUBLE TEAM"  , MoveEffect.EVASION_UP              ,   0, Type.NORMAL  ,   0,  15,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	RECOVER     ("RECOVER"      , MoveEffect.RESTORE_HP              ,   0, Type.NORMAL  ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	HARDEN      ("HARDEN"       , MoveEffect.DEFENSE_UP              ,   0, Type.NORMAL  ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	MINIMIZE    ("MINIMIZE"     , MoveEffect.MINIMIZE                ,   0, Type.NORMAL  ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	SMOKESCREEN ("SMOKESCREEN"  , MoveEffect.ACCURACY_DOWN           ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	CONFUSERAY  ("CONFUSE RAY"  , MoveEffect.CONFUSE                 ,   0, Type.GHOST   , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	WITHDRAW    ("WITHDRAW"     , MoveEffect.DEFENSE_UP              ,   0, Type.WATER   ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	DEFENSECURL ("DEFENSE CURL" , MoveEffect.DEFENSE_CURL            ,   0, Type.NORMAL  ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	BARRIER     ("BARRIER"      , MoveEffect.DEFENSE_UP_2            ,   0, Type.PSYCHIC ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	LIGHTSCREEN ("LIGHT SCREEN" , MoveEffect.LIGHT_SCREEN            ,   0, Type.PSYCHIC ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	HAZE        ("HAZE"         , MoveEffect.HAZE                    ,   0, Type.ICE     ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_PROTECT),
	REFLECT     ("REFLECT"      , MoveEffect.REFLECT                 ,   0, Type.PSYCHIC ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	FOCUSENERGY ("FOCUS ENERGY" , MoveEffect.FOCUS_ENERGY            ,   0, Type.NORMAL  ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	BIDE        ("BIDE"         , MoveEffect.BIDE                    ,   1, Type.NORMAL  , 100,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	METRONOME   ("METRONOME"    , MoveEffect.METRONOME               ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.SPECIAL         ,   0, MoveFlag.NONE),
	MIRRORMOVE  ("MIRROR MOVE"  , MoveEffect.MIRROR_MOVE             ,   0, Type.FLYING  ,   0,  20,   0, MoveTarget.SPECIAL         ,   0, MoveFlag.NONE),
	SELFDESTRUCT("SELF DESTRUCT", MoveEffect.EXPLOSION               , 200, Type.NORMAL  , 100,   5,   0, MoveTarget.ALL_EXCEPT_USER ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	EGGBOMB     ("EGG BOMB"     , MoveEffect.HIT                     , 100, Type.NORMAL  ,  75,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	LICK        ("LICK"         , MoveEffect.PARALYZE_HIT            ,  20, Type.GHOST   , 100,  30,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SMOG        ("SMOG"         , MoveEffect.POISON_HIT              ,  20, Type.POISON  ,  70,  20,  40, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SLUDGE      ("SLUDGE"       , MoveEffect.POISON_HIT              ,  65, Type.POISON  , 100,  20,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BONECLUB    ("BONE CLUB"    , MoveEffect.FLINCH_HIT              ,  65, Type.GROUND  ,  85,  20,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FIREBLAST   ("FIRE BLAST"   , MoveEffect.BURN_HIT                , 120, Type.FIRE    ,  85,   5,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	WATERFALL   ("WATERFALL"    , MoveEffect.HIT                     ,  80, Type.WATER   , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	CLAMP       ("CLAMP"        , MoveEffect.TRAP                    ,  35, Type.WATER   ,  75,  10, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SWIFT       ("SWIFT"        , MoveEffect.ALWAYS_HIT              ,  60, Type.NORMAL  ,   0,  20,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SKULLBASH   ("SKULL BASH"   , MoveEffect.SKULL_BASH              , 100, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SPIKECANNON ("SPIKE CANNON" , MoveEffect.MULTI_HIT               ,  20, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	CONSTRICT   ("CONSTRICT"    , MoveEffect.SPEED_DOWN_HIT          ,  10, Type.NORMAL  , 100,  35,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	AMNESIA     ("AMNESIA"      , MoveEffect.SPECIAL_DEFENSE_UP_2    ,   0, Type.PSYCHIC ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	KINESIS     ("KINESIS"      , MoveEffect.ACCURACY_DOWN           ,   0, Type.PSYCHIC ,  80,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SOFTBOILED  ("SOFT BOILED"  , MoveEffect.SOFTBOILED              ,   0, Type.NORMAL  , 100,  10,   0, MoveTarget.USER            ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_SNATCH),
	HIJUMPKICK  ("HI JUMP KICK" , MoveEffect.RECOIL_IF_MISS          ,  85, Type.FIGHTING,  90,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	GLARE       ("GLARE"        , MoveEffect.PARALYZE                ,   0, Type.NORMAL  ,  75,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	DREAMEATER  ("DREAM EATER"  , MoveEffect.DREAM_EATER             , 100, Type.PSYCHIC , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	POISONGAS   ("POISON GAS"   , MoveEffect.POISON                  ,   0, Type.POISON  ,  55,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	BARRAGE     ("BARRAGE"      , MoveEffect.MULTI_HIT               ,  15, Type.NORMAL  ,  85,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	LEECHLIFE   ("LEECH LIFE"   , MoveEffect.ABSORB                  ,  20, Type.BUG     , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	LOVELYKISS  ("LOVELY KISS"  , MoveEffect.SLEEP                   ,   0, Type.NORMAL  ,  75,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	SKYATTACK   ("SKY ATTACK"   , MoveEffect.SKY_ATTACK              , 140, Type.FLYING  ,  90,   5,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	TRANSFORM   ("TRANSFORM"    , MoveEffect.TRANSFORM               ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	BUBBLE      ("BUBBLE"       , MoveEffect.SPEED_DOWN_HIT          ,  20, Type.WATER   , 100,  30,  10, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DIZZYPUNCH  ("DIZZY PUNCH"  , MoveEffect.CONFUSE_HIT             ,  70, Type.NORMAL  , 100,  10,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SPORE       ("SPORE"        , MoveEffect.SLEEP                   ,   0, Type.GRASS   , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	FLASH       ("FLASH"        , MoveEffect.ACCURACY_DOWN           ,   0, Type.NORMAL  ,  70,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	PSYWAVE     ("PSYWAVE"      , MoveEffect.PSYWAVE                 ,   1, Type.PSYCHIC ,  80,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SPLASH      ("SPLASH"       , MoveEffect.SPLASH                  ,   0, Type.NORMAL  ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	ACIDARMOR   ("ACID ARMOR"   , MoveEffect.DEFENSE_UP_2            ,   0, Type.POISON  ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	CRABHAMMER  ("CRABHAMMER"   , MoveEffect.HIGH_CRITICAL           ,  90, Type.WATER   ,  85,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	EXPLOSION   ("EXPLOSION"    , MoveEffect.EXPLOSION               , 250, Type.NORMAL  , 100,   5,   0, MoveTarget.ALL_EXCEPT_USER ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FURYSWIPES  ("FURY SWIPES"  , MoveEffect.MULTI_HIT               ,  18, Type.NORMAL  ,  80,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	BONEMERANG  ("BONEMERANG"   , MoveEffect.DOUBLE_HIT              ,  50, Type.GROUND  ,  90,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	REST        ("REST"         , MoveEffect.REST                    ,   0, Type.PSYCHIC ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	ROCKSLIDE   ("ROCK SLIDE"   , MoveEffect.FLINCH_HIT              ,  75, Type.ROCK    ,  90,  10,  30, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	HYPERFANG   ("HYPER FANG"   , MoveEffect.FLINCH_HIT              ,  80, Type.NORMAL  ,  90,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SHARPEN     ("SHARPEN"      , MoveEffect.ATTACK_UP               ,   0, Type.NORMAL  ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	CONVERSION  ("CONVERSION"   , MoveEffect.CONVERSION              ,   0, Type.NORMAL  ,   0,  30,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	TRIATTACK   ("TRI ATTACK"   , MoveEffect.TRI_ATTACK              ,  80, Type.NORMAL  , 100,  10,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SUPERFANG   ("SUPER FANG"   , MoveEffect.SUPER_FANG              ,   1, Type.NORMAL  ,  90,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SLASH       ("SLASH"        , MoveEffect.HIGH_CRITICAL           ,  70, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SUBSTITUTE  ("SUBSTITUTE"   , MoveEffect.SUBSTITUTE              ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	STRUGGLE    ("STRUGGLE"     , MoveEffect.RECOIL                  ,  50, Type.NONE    , 100,   1,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT), // edited to NONE to avoid special cases
	SKETCH      ("SKETCH"       , MoveEffect.SKETCH                  ,   0, Type.NORMAL  ,   0,   1,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	TRIPLEKICK  ("TRIPLE KICK"  , MoveEffect.TRIPLE_KICK             ,  10, Type.FIGHTING,  90,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	THIEF       ("THIEF"        , MoveEffect.THIEF                   ,  40, Type.DARK    , 100,  10, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SPIDERWEB   ("SPIDER WEB"   , MoveEffect.MEAN_LOOK               ,   0, Type.BUG     , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	MINDREADER  ("MIND READER"  , MoveEffect.LOCK_ON                 ,   0, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	NIGHTMARE   ("NIGHTMARE"    , MoveEffect.NIGHTMARE               ,   0, Type.GHOST   , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FLAMEWHEEL  ("FLAME WHEEL"  , MoveEffect.THAW_HIT                ,  60, Type.FIRE    , 100,  25,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SNORE       ("SNORE"        , MoveEffect.SNORE                   ,  40, Type.NORMAL  , 100,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	CURSE       ("CURSE"        , MoveEffect.CURSE                   ,   0, Type.MYSTERY ,   0,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	FLAIL       ("FLAIL"        , MoveEffect.FLAIL                   ,   1, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	CONVERSION2 ("CONVERSION 2" , MoveEffect.CONVERSION_2            ,   0, Type.NORMAL  , 100,  30,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	AEROBLAST   ("AEROBLAST"    , MoveEffect.HIGH_CRITICAL           , 100, Type.FLYING  ,  95,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	COTTONSPORE ("COTTON SPORE" , MoveEffect.SPEED_DOWN_2            ,   0, Type.GRASS   ,  85,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	REVERSAL    ("REVERSAL"     , MoveEffect.FLAIL                   ,   1, Type.FIGHTING, 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SPITE       ("SPITE"        , MoveEffect.SPITE                   ,   0, Type.GHOST   , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	POWDERSNOW  ("POWDER SNOW"  , MoveEffect.FREEZE_HIT              ,  40, Type.ICE     , 100,  25,  10, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	PROTECT     ("PROTECT"      , MoveEffect.PROTECT                 ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   3, MoveFlag.NONE),
	MACHPUNCH   ("MACH PUNCH"   , MoveEffect.QUICK_ATTACK            ,  40, Type.FIGHTING, 100,  30,   0, MoveTarget.SELECTED_POKEMON,   1, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SCARYFACE   ("SCARY FACE"   , MoveEffect.SPEED_DOWN_2            ,   0, Type.NORMAL  ,  90,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	FAINTATTACK ("FAINT ATTACK" , MoveEffect.ALWAYS_HIT              ,  60, Type.DARK    ,   0,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SWEETKISS   ("SWEET KISS"   , MoveEffect.CONFUSE                 ,   0, Type.NORMAL  ,  75,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	BELLYDRUM   ("BELLY DRUM"   , MoveEffect.BELLY_DRUM              ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	SLUDGEBOMB  ("SLUDGE BOMB"  , MoveEffect.POISON_HIT              ,  90, Type.POISON  , 100,  10,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MUDSLAP     ("MUD SLAP"     , MoveEffect.ACCURACY_DOWN_HIT       ,  20, Type.GROUND  , 100,  10, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	OCTAZOOKA   ("OCTAZOOKA"    , MoveEffect.ACCURACY_DOWN_HIT       ,  65, Type.WATER   ,  85,  10,  50, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SPIKES      ("SPIKES"       , MoveEffect.SPIKES                  ,   0, Type.GROUND  ,   0,  20,   0, MoveTarget.ENEMY_SIDE      ,   0, MoveFlag.NONE),
	ZAPCANNON   ("ZAP CANNON"   , MoveEffect.PARALYZE_HIT            , 100, Type.ELECTRIC,  50,   5, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FORESIGHT   ("FORESIGHT"    , MoveEffect.FORESIGHT               ,   0, Type.NORMAL  , 100,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DESTINYBOND ("DESTINY BOND" , MoveEffect.DESTINY_BOND            ,   0, Type.GHOST   ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	PERISHSONG  ("PERISH SONG"  , MoveEffect.PERISH_SONG             ,   0, Type.NORMAL  ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	ICYWIND     ("ICY WIND"     , MoveEffect.SPEED_DOWN_HIT          ,  55, Type.ICE     ,  95,  15, 100, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DETECT      ("DETECT"       , MoveEffect.PROTECT                 ,   0, Type.FIGHTING,   0,   5,   0, MoveTarget.USER            ,   3, MoveFlag.NONE),
	BONERUSH    ("BONE RUSH"    , MoveEffect.MULTI_HIT               ,  25, Type.GROUND  ,  80,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	LOCKON      ("LOCK ON"      , MoveEffect.LOCK_ON                 ,   0, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	OUTRAGE     ("OUTRAGE"      , MoveEffect.RAMPAGE                 ,  90, Type.DRAGON  , 100,  15, 100, MoveTarget.RANDOM          ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SANDSTORM   ("SANDSTORM"    , MoveEffect.SANDSTORM               ,   0, Type.ROCK    ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	GIGADRAIN   ("GIGA DRAIN"   , MoveEffect.ABSORB                  ,  60, Type.GRASS   , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	ENDURE      ("ENDURE"       , MoveEffect.ENDURE                  ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   3, MoveFlag.NONE),
	CHARM       ("CHARM"        , MoveEffect.ATTACK_DOWN_2           ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	ROLLOUT     ("ROLLOUT"      , MoveEffect.ROLLOUT                 ,  30, Type.ROCK    ,  90,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	FALSESWIPE  ("FALSE SWIPE"  , MoveEffect.FALSE_SWIPE             ,  40, Type.NORMAL  , 100,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SWAGGER     ("SWAGGER"      , MoveEffect.SWAGGER                 ,   0, Type.NORMAL  ,  90,  15, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	MILKDRINK   ("MILK DRINK"   , MoveEffect.SOFTBOILED              ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH, MoveFlag.AFFECTED_BY_PROTECT),
	SPARK       ("SPARK"        , MoveEffect.PARALYZE_HIT            ,  65, Type.ELECTRIC, 100,  20,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	FURYCUTTER  ("FURY CUTTER"  , MoveEffect.FURY_CUTTER             ,  10, Type.BUG     ,  95,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	STEELWING   ("STEEL WING"   , MoveEffect.DEFENSE_UP_HIT          ,  70, Type.STEEL   ,  90,  25,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MEANLOOK    ("MEAN LOOK"    , MoveEffect.MEAN_LOOK               ,   0, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	ATTRACT     ("ATTRACT"      , MoveEffect.ATTRACT                 ,   0, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	SLEEPTALK   ("SLEEP TALK"   , MoveEffect.SLEEP_TALK              ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.SPECIAL         ,   0, MoveFlag.NONE),
	HEALBELL    ("HEAL BELL"    , MoveEffect.HEAL_BELL               ,   0, Type.NORMAL  ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	RETURN      ("RETURN"       , MoveEffect.RETURN                  ,   1, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	PRESENT     ("PRESENT"      , MoveEffect.PRESENT                 ,   1, Type.NORMAL  ,  90,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FRUSTRATION ("FRUSTRATION"  , MoveEffect.FRUSTRATION             ,   1, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SAFEGUARD   ("SAFEGUARD"    , MoveEffect.SAFEGUARD               ,   0, Type.NORMAL  ,   0,  25,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	PAINSPLIT   ("PAIN SPLIT"   , MoveEffect.PAIN_SPLIT              ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SACREDFIRE  ("SACRED FIRE"  , MoveEffect.THAW_HIT                , 100, Type.FIRE    ,  95,   5,  50, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MAGNITUDE   ("MAGNITUDE"    , MoveEffect.MAGNITUDE               ,   1, Type.GROUND  , 100,  30,   0, MoveTarget.ALL_EXCEPT_USER ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DYNAMICPUNCH("DYNAMIC PUNCH", MoveEffect.CONFUSE_HIT             , 100, Type.FIGHTING,  50,   5, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MEGAHORN    ("MEGAHORN"     , MoveEffect.HIT                     , 120, Type.BUG     ,  85,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	DRAGONBREATH("DRAGON BREATH", MoveEffect.PARALYZE_HIT            ,  60, Type.DRAGON  , 100,  20,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BATONPASS   ("BATON PASS"   , MoveEffect.BATON_PASS              ,   0, Type.NORMAL  ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	ENCORE      ("ENCORE"       , MoveEffect.ENCORE                  ,   0, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	PURSUIT     ("PURSUIT"      , MoveEffect.PURSUIT                 ,  40, Type.DARK    , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	RAPIDSPIN   ("RAPID SPIN"   , MoveEffect.RAPID_SPIN              ,  20, Type.NORMAL  , 100,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SWEETSCENT  ("SWEET SCENT"  , MoveEffect.EVASION_DOWN            ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	IRONTAIL    ("IRON TAIL"    , MoveEffect.DEFENSE_DOWN_HIT        , 100, Type.STEEL   ,  75,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	METALCLAW   ("METAL CLAW"   , MoveEffect.ATTACK_UP_HIT           ,  50, Type.STEEL   ,  95,  35,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	VITALTHROW  ("VITAL THROW"  , MoveEffect.VITAL_THROW             ,  70, Type.FIGHTING, 100,  10,   0, MoveTarget.SELECTED_POKEMON,  -1, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MORNINGSUN  ("MORNING SUN"  , MoveEffect.MORNING_SUN             ,   0, Type.NORMAL  ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	SYNTHESIS   ("SYNTHESIS"    , MoveEffect.SYNTHESIS               ,   0, Type.GRASS   ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	MOONLIGHT   ("MOONLIGHT"    , MoveEffect.MOONLIGHT               ,   0, Type.NORMAL  ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	HIDDENPOWER ("HIDDEN POWER" , MoveEffect.HIDDEN_POWER            ,   1, Type.NORMAL  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	CROSSCHOP   ("CROSS CHOP"   , MoveEffect.HIGH_CRITICAL           , 100, Type.FIGHTING,  80,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	TWISTER     ("TWISTER"      , MoveEffect.TWISTER                 ,  40, Type.DRAGON  , 100,  20,  20, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	RAINDANCE   ("RAIN DANCE"   , MoveEffect.RAIN_DANCE              ,   0, Type.WATER   ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	SUNNYDAY    ("SUNNY DAY"    , MoveEffect.SUNNY_DAY               ,   0, Type.FIRE    ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	CRUNCH      ("CRUNCH"       , MoveEffect.SPECIAL_DEFENSE_DOWN_HIT,  80, Type.DARK    , 100,  15,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MIRRORCOAT  ("MIRROR COAT"  , MoveEffect.MIRROR_COAT             ,   1, Type.PSYCHIC , 100,  20,   0, MoveTarget.SPECIAL         ,  -5, MoveFlag.MIRROR_MOVE_COMPATIBLE),
	PSYCHUP     ("PSYCH UP"     , MoveEffect.PSYCH_UP                ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_SNATCH),
	EXTREMESPEED("EXTREME SPEED", MoveEffect.QUICK_ATTACK            ,  80, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   1, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ANCIENTPOWER("ANCIENT POWER", MoveEffect.ALL_STATS_UP_HIT        ,  60, Type.ROCK    , 100,   5,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SHADOWBALL  ("SHADOW BALL"  , MoveEffect.SPECIAL_DEFENSE_DOWN_HIT,  80, Type.GHOST   , 100,  15,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FUTURESIGHT ("FUTURE SIGHT" , MoveEffect.FUTURE_SIGHT            ,  80, Type.PSYCHIC ,  90,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	ROCKSMASH   ("ROCK SMASH"   , MoveEffect.DEFENSE_DOWN_HIT        ,  20, Type.FIGHTING, 100,  15,  50, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	WHIRLPOOL   ("WHIRLPOOL"    , MoveEffect.TRAP                    ,  15, Type.WATER   ,  70,  15, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BEATUP      ("BEAT UP"      , MoveEffect.BEAT_UP                 ,  10, Type.DARK    , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FAKEOUT     ("FAKE OUT"     , MoveEffect.FAKE_OUT                ,  40, Type.NORMAL  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   1, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	UPROAR      ("UPROAR"       , MoveEffect.UPROAR                  ,  50, Type.NORMAL  , 100,  10, 100, MoveTarget.RANDOM          ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	STOCKPILE   ("STOCKPILE"    , MoveEffect.STOCKPILE               ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	SPITUP      ("SPIT UP"      , MoveEffect.SPIT_UP                 , 100, Type.NORMAL  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.AFFECTED_BY_PROTECT),
	SWALLOW     ("SWALLOW"      , MoveEffect.SWALLOW                 ,   0, Type.NORMAL  ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	HEATWAVE    ("HEAT WAVE"    , MoveEffect.BURN_HIT                , 100, Type.FIRE    ,  90,  10,  10, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	HAIL        ("HAIL"         , MoveEffect.HAIL                    ,   0, Type.ICE     ,   0,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_PROTECT),
	TORMENT     ("TORMENT"      , MoveEffect.TORMENT                 ,   0, Type.DARK    , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FLATTER     ("FLATTER"      , MoveEffect.FLATTER                 ,   0, Type.DARK    , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	WILLOWISP   ("WILL O WISP"  , MoveEffect.WILL_O_WISP             ,   0, Type.FIRE    ,  75,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	MEMENTO     ("MEMENTO"      , MoveEffect.MEMENTO                 ,   0, Type.DARK    , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FACADE      ("FACADE"       , MoveEffect.FACADE                  ,  70, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	FOCUSPUNCH  ("FOCUS PUNCH"  , MoveEffect.FOCUS_PUNCH             , 150, Type.FIGHTING, 100,  20,   0, MoveTarget.SELECTED_POKEMON,  -3, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SMELLINGSALT("SMELLING SALT", MoveEffect.SMELLINGSALT            ,  60, Type.NORMAL  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	FOLLOWME    ("FOLLOW ME"    , MoveEffect.FOLLOW_ME               ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.USER            ,   3, MoveFlag.NONE),
	NATUREPOWER ("NATURE POWER" , MoveEffect.NATURE_POWER            ,   0, Type.NORMAL  ,  95,  20,   0, MoveTarget.SPECIAL         ,   0, MoveFlag.NONE),
	CHARGE      ("CHARGE"       , MoveEffect.CHARGE                  ,   0, Type.ELECTRIC, 100,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	TAUNT       ("TAUNT"        , MoveEffect.TAUNT                   ,   0, Type.DARK    , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_PROTECT),
	HELPINGHAND ("HELPING HAND" , MoveEffect.HELPING_HAND            ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.USER            ,   5, MoveFlag.NONE),
	TRICK       ("TRICK"        , MoveEffect.TRICK                   ,   0, Type.PSYCHIC , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	ROLEPLAY    ("ROLE PLAY"    , MoveEffect.ROLE_PLAY               ,   0, Type.PSYCHIC , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	WISH        ("WISH"         , MoveEffect.WISH                    ,   0, Type.NORMAL  , 100,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_PROTECT),
	ASSIST      ("ASSIST"       , MoveEffect.ASSIST                  ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SPECIAL         ,   0, MoveFlag.NONE),
	INGRAIN     ("INGRAIN"      , MoveEffect.INGRAIN                 ,   0, Type.GRASS   , 100,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	SUPERPOWER  ("SUPERPOWER"   , MoveEffect.SUPERPOWER              , 120, Type.FIGHTING, 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MAGICCOAT   ("MAGIC COAT"   , MoveEffect.MAGIC_COAT              ,   0, Type.PSYCHIC , 100,  15,   0, MoveTarget.SPECIAL         ,   4, MoveFlag.NONE),
	RECYCLE     ("RECYCLE"      , MoveEffect.RECYCLE                 ,   0, Type.NORMAL  , 100,  10,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	REVENGE     ("REVENGE"      , MoveEffect.REVENGE                 ,  60, Type.FIGHTING, 100,  10,   0, MoveTarget.SELECTED_POKEMON,  -4, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	BRICKBREAK  ("BRICK BREAK"  , MoveEffect.BRICK_BREAK             ,  75, Type.FIGHTING, 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	YAWN        ("YAWN"         , MoveEffect.YAWN                    ,   0, Type.NORMAL  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	KNOCKOFF    ("KNOCK OFF"    , MoveEffect.KNOCK_OFF               ,  20, Type.DARK    , 100,  20, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ENDEAVOR    ("ENDEAVOR"     , MoveEffect.ENDEAVOR                ,   1, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ERUPTION    ("ERUPTION"     , MoveEffect.ERUPTION                , 150, Type.FIRE    , 100,   5,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SKILLSWAP   ("SKILL SWAP"   , MoveEffect.SKILL_SWAP              ,   0, Type.PSYCHIC , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	IMPRISON    ("IMPRISON"     , MoveEffect.IMPRISON                ,   0, Type.PSYCHIC , 100,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_PROTECT),
	REFRESH     ("REFRESH"      , MoveEffect.REFRESH                 ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	GRUDGE      ("GRUDGE"       , MoveEffect.GRUDGE                  ,   0, Type.GHOST   , 100,   5,   0, MoveTarget.USER            ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SNATCH      ("SNATCH"       , MoveEffect.SNATCH                  ,   0, Type.DARK    , 100,  10,   0, MoveTarget.SPECIAL         ,   4, MoveFlag.MIRROR_MOVE_COMPATIBLE),
	SECRETPOWER ("SECRET POWER" , MoveEffect.SECRET_POWER            ,  70, Type.NORMAL  , 100,  20,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DIVE        ("DIVE"         , MoveEffect.FLY                     ,  60, Type.WATER   , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ARMTHRUST   ("ARM THRUST"   , MoveEffect.MULTI_HIT               ,  15, Type.FIGHTING, 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	CAMOUFLAGE  ("CAMOUFLAGE"   , MoveEffect.CAMOUFLAGE              ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	TAILGLOW    ("TAIL GLOW"    , MoveEffect.SPECIAL_ATTACK_UP_2     ,   0, Type.BUG     , 100,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	LUSTERPURGE ("LUSTER PURGE" , MoveEffect.SPECIAL_DEFENSE_DOWN_HIT,  70, Type.PSYCHIC , 100,   5,  50, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MISTBALL    ("MIST BALL"    , MoveEffect.SPECIAL_ATTACK_DOWN_HIT ,  70, Type.PSYCHIC , 100,   5,  50, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	FEATHERDANCE("FEATHER DANCE", MoveEffect.ATTACK_DOWN_2           ,   0, Type.FLYING  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	TEETERDANCE ("TEETER DANCE" , MoveEffect.TEETER_DANCE            ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.ALL_EXCEPT_USER ,   0, MoveFlag.AFFECTED_BY_PROTECT),
	BLAZEKICK   ("BLAZE KICK"   , MoveEffect.BLAZE_KICK              ,  85, Type.FIRE    ,  90,  10,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MUDSPORT    ("MUD SPORT"    , MoveEffect.MUD_SPORT               ,   0, Type.GROUND  , 100,  15,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	ICEBALL     ("ICE BALL"     , MoveEffect.ROLLOUT                 ,  30, Type.ICE     ,  90,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	NEEDLEARM   ("NEEDLE ARM"   , MoveEffect.FLINCH_HIT_2            ,  60, Type.GRASS   , 100,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SLACKOFF    ("SLACK OFF"    , MoveEffect.RESTORE_HP              ,   0, Type.NORMAL  , 100,  10,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	HYPERVOICE  ("HYPER VOICE"  , MoveEffect.HIT                     ,  90, Type.NORMAL  , 100,  10,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	POISONFANG  ("POISON FANG"  , MoveEffect.POISON_FANG             ,  50, Type.POISON  , 100,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	CRUSHCLAW   ("CRUSH CLAW"   , MoveEffect.DEFENSE_DOWN_HIT        ,  75, Type.NORMAL  ,  95,  10,  50, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	BLASTBURN   ("BLAST BURN"   , MoveEffect.RECHARGE                , 150, Type.FIRE    ,  90,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	HYDROCANNON ("HYDRO CANNON" , MoveEffect.RECHARGE                , 150, Type.WATER   ,  90,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	METEORMASH  ("METEOR MASH"  , MoveEffect.ATTACK_UP_HIT           , 100, Type.STEEL   ,  85,  10,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ASTONISH    ("ASTONISH"     , MoveEffect.FLINCH_HIT_2            ,  30, Type.GHOST   , 100,  15,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	WEATHERBALL ("WEATHER BALL" , MoveEffect.WEATHER_BALL            ,  50, Type.NORMAL  , 100,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	AROMATHERAPY("AROMATHERAPY" , MoveEffect.HEAL_BELL               ,   0, Type.GRASS   ,   0,   5,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	FAKETEARS   ("FAKE TEARS"   , MoveEffect.SPECIAL_DEFENSE_DOWN_2  ,   0, Type.DARK    , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	AIRCUTTER   ("AIR CUTTER"   , MoveEffect.HIGH_CRITICAL           ,  55, Type.FLYING  ,  95,  25,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	OVERHEAT    ("OVERHEAT"     , MoveEffect.OVERHEAT                , 140, Type.FIRE    ,  90,   5, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ODORSLEUTH  ("ODOR SLEUTH"  , MoveEffect.FORESIGHT               ,   0, Type.NORMAL  , 100,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	ROCKTOMB    ("ROCK TOMB"    , MoveEffect.SPEED_DOWN_HIT          ,  50, Type.ROCK    ,  80,  10, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SILVERWIND  ("SILVER WIND"  , MoveEffect.ALL_STATS_UP_HIT        ,  60, Type.BUG     , 100,   5,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	METALSOUND  ("METAL SOUND"  , MoveEffect.SPECIAL_DEFENSE_DOWN_2  ,   0, Type.STEEL   ,  85,  40,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	GRASSWHISTLE("GRASS WHISTLE", MoveEffect.SLEEP                   ,   0, Type.GRASS   ,  55,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	TICKLE      ("TICKLE"       , MoveEffect.TICKLE                  ,   0, Type.NORMAL  , 100,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	COSMICPOWER ("COSMIC POWER" , MoveEffect.COSMIC_POWER            ,   0, Type.PSYCHIC ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	WATERSPOUT  ("WATER SPOUT"  , MoveEffect.ERUPTION                , 150, Type.WATER   , 100,   5,   0, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SIGNALBEAM  ("SIGNAL BEAM"  , MoveEffect.CONFUSE_HIT             ,  75, Type.BUG     , 100,  15,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SHADOWPUNCH ("SHADOW PUNCH" , MoveEffect.ALWAYS_HIT              ,  60, Type.GHOST   ,   0,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	EXTRASENSORY("EXTRASENSORY" , MoveEffect.FLINCH_HIT_2            ,  80, Type.PSYCHIC , 100,  30,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SKYUPPERCUT ("SKY UPPERCUT" , MoveEffect.SKY_UPPERCUT            ,  85, Type.FIGHTING,  90,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	SANDTOMB    ("SAND TOMB"    , MoveEffect.TRAP                    ,  15, Type.GROUND  ,  70,  15, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SHEERCOLD   ("SHEER COLD"   , MoveEffect.OHKO                    ,   1, Type.ICE     ,  30,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	MUDDYWATER  ("MUDDY WATER"  , MoveEffect.ACCURACY_DOWN_HIT       ,  95, Type.WATER   ,  85,  10,  30, MoveTarget.BOTH_ENEMIES    ,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BULLETSEED  ("BULLET SEED"  , MoveEffect.MULTI_HIT               ,  10, Type.GRASS   , 100,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	AERIALACE   ("AERIAL ACE"   , MoveEffect.ALWAYS_HIT              ,  60, Type.FLYING  ,   0,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	ICICLESPEAR ("ICICLE SPEAR" , MoveEffect.MULTI_HIT               ,  10, Type.ICE     , 100,  30,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	IRONDEFENSE ("IRON DEFENSE" , MoveEffect.DEFENSE_UP_2            ,   0, Type.STEEL   ,   0,  15,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	BLOCK       ("BLOCK"        , MoveEffect.MEAN_LOOK               ,   0, Type.NORMAL  , 100,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_MAGIC_COAT, MoveFlag.AFFECTED_BY_PROTECT),
	HOWL        ("HOWL"         , MoveEffect.ATTACK_UP               ,   0, Type.NORMAL  ,   0,  40,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	DRAGONCLAW  ("DRAGON CLAW"  , MoveEffect.HIT                     ,  80, Type.DRAGON  , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	FRENZYPLANT ("FRENZY PLANT" , MoveEffect.RECHARGE                , 150, Type.GRASS   ,  90,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	BULKUP      ("BULK UP"      , MoveEffect.BULK_UP                 ,   0, Type.FIGHTING,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	BOUNCE      ("BOUNCE"       , MoveEffect.FLY                     ,  85, Type.FLYING  ,  85,   5,  30, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MUDSHOT     ("MUD SHOT"     , MoveEffect.SPEED_DOWN_HIT          ,  55, Type.GROUND  ,  95,  15, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	POISONTAIL  ("POISON TAIL"  , MoveEffect.POISON_TAIL             ,  50, Type.POISON  , 100,  25,  10, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	COVET       ("COVET"        , MoveEffect.THIEF                   ,  40, Type.NORMAL  , 100,  40, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	VOLTTACKLE  ("VOLT TACKLE"  , MoveEffect.DOUBLE_EDGE             , 120, Type.ELECTRIC, 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	MAGICALLEAF ("MAGICAL LEAF" , MoveEffect.ALWAYS_HIT              ,  60, Type.GRASS   ,   0,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	WATERSPORT  ("WATER SPORT"  , MoveEffect.WATER_SPORT             ,   0, Type.WATER   , 100,  15,   0, MoveTarget.USER            ,   0, MoveFlag.NONE),
	CALMMIND    ("CALM MIND"    , MoveEffect.CALM_MIND               ,   0, Type.PSYCHIC ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	LEAFBLADE   ("LEAF BLADE"   , MoveEffect.HIGH_CRITICAL           ,  70, Type.GRASS   , 100,  15,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT, MoveFlag.MAKES_CONTACT),
	DRAGONDANCE ("DRAGON DANCE" , MoveEffect.DRAGON_DANCE            ,   0, Type.DRAGON  ,   0,  20,   0, MoveTarget.USER            ,   0, MoveFlag.AFFECTED_BY_SNATCH),
	ROCKBLAST   ("ROCK BLAST"   , MoveEffect.MULTI_HIT               ,  25, Type.ROCK    ,  80,  10,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	SHOCKWAVE   ("SHOCK WAVE"   , MoveEffect.ALWAYS_HIT              ,  60, Type.ELECTRIC,   0,  20,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	WATERPULSE  ("WATER PULSE"  , MoveEffect.CONFUSE_HIT             ,  60, Type.WATER   , 100,  20,  20, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT),
	DOOMDESIRE  ("DOOM DESIRE"  , MoveEffect.FUTURE_SIGHT            , 120, Type.STEEL   ,  85,   5,   0, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.NONE),
	PSYCHOBOOST ("PSYCHO BOOST" , MoveEffect.OVERHEAT                , 140, Type.PSYCHIC ,  90,   5, 100, MoveTarget.SELECTED_POKEMON,   0, MoveFlag.AFFECTED_BY_KINGS_ROCK, MoveFlag.MIRROR_MOVE_COMPATIBLE, MoveFlag.AFFECTED_BY_PROTECT);

	private static LookupTable<Move> moveTable = new LookupTable<>();
	static {
		for(Move move : Move.values()) {
			moveTable.put(move.name(), move);
		}
	}
	
	public static Move getMoveFromString(String name) {
		return moveTable.get(name);
	}
	

	private String displayName;
	private MoveEffect effect;
	private int power;
	private Type type;
	private int accuracy;
	private int pp;
	private int secondaryEffectChance;
	private MoveTarget target;
	private int priority;
	private MoveFlag[] flags;
	
	private Move(String displayName, MoveEffect effect, int power, Type type, 
			int accuracy, int pp, int secondaryEffectChance,
			MoveTarget target, int priority, MoveFlag... flags) {
		this.setDisplayName(displayName);
		this.setEffect(effect);
		this.setPower(power);
		this.setType(type);
		this.setAccuracy(accuracy);
		this.setPp(pp);
		this.setSecondaryEffectChance(secondaryEffectChance);
		this.setTarget(target);
		this.setPriority(priority);
		this.setFlags(flags);
	}

	public String getName() {
		return displayName;
	}

	public MoveEffect getEffect() {
		return effect;
	}

	public int getPower() {
		return power;
	}

	public Type getType() {
		return type;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public int getPp() {
		return pp;
	}

	public int getSecondaryEffectChance() {
		return secondaryEffectChance;
	}

	public MoveTarget getTarget() {
		return target;
	}

	public int getPriority() {
		return priority;
	}

	public MoveFlag[] getFlags() {
		return flags;
	}

	private void setDisplayName(String name) {
		this.displayName = name;
	}

	private void setEffect(MoveEffect effect) {
		this.effect = effect;
	}

	private void setPower(int power) {
		this.power = power;
	}

	private void setType(Type type) {
		this.type = type;
	}

	private void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	private void setPp(int pp) {
		this.pp = pp;
	}

	private void setSecondaryEffectChance(int secondaryEffectChance) {
		this.secondaryEffectChance = secondaryEffectChance;
	}

	private void setTarget(MoveTarget target) {
		this.target = target;
	}

	private void setPriority(int priority) {
		this.priority = priority;
	}

	private void setFlags(MoveFlag[] flags) {
		this.flags = flags;
	}
}
