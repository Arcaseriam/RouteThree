package data;

import java.util.HashMap;

import utility.LookupTable;

public enum Item {
	// see : https://github.com/pret/pokeruby/blob/747a3b4b3e76db3a8f94bafcbe8d38e740850d59/src/data/items_en.h
	// regex (/gms) : {\s*\.name = _\(([^)]+)\),\s*\.itemId = ITEM_([^,]+),\s*\.price = (\d+),\s*\.holdEffect = HOLD_EFFECT_([^,]+),\s*\.\w+ = [^,]+,\s*\.\w+ = [^,]+,\s*\.\w+ = [^,]+,\s*\.\w+ = [^,]+,\s*\.pocket = POCKET_([^,]+),[^}]*},\s*
	// replacement : \2(\1, \3, PocketType.\5, HoldEffect.\4, "\2"),\n
	
	// displayName, price, pocketType, holdEffect, commandName...
	NONE             ("-"                ,     0, PocketType.ITEMS     , HoldEffect.NONE          , "NONE"),
	MASTER_BALL      ("MASTER BALL"      ,     0, PocketType.POKE_BALLS, HoldEffect.NONE          , "MASTERBALL"),
	ULTRA_BALL       ("ULTRA BALL"       ,  1200, PocketType.POKE_BALLS, HoldEffect.NONE          , "ULTRABALL"),
	GREAT_BALL       ("GREAT BALL"       ,   600, PocketType.POKE_BALLS, HoldEffect.NONE          , "GREATBALL"),
	POKE_BALL        ("POK� BALL"        ,   200, PocketType.POKE_BALLS, HoldEffect.NONE          , "POKEBALL"),
	SAFARI_BALL      ("SAFARI BALL"      ,     0, PocketType.POKE_BALLS, HoldEffect.NONE          , "SAFARIBALL"),
	NET_BALL         ("NET BALL"         ,  1000, PocketType.POKE_BALLS, HoldEffect.NONE          , "NETBALL"),
	DIVE_BALL        ("DIVE BALL"        ,  1000, PocketType.POKE_BALLS, HoldEffect.NONE          , "DIVEBALL"),
	NEST_BALL        ("NEST BALL"        ,  1000, PocketType.POKE_BALLS, HoldEffect.NONE          , "NESTBALL"),
	REPEAT_BALL      ("REPEAT BALL"      ,  1000, PocketType.POKE_BALLS, HoldEffect.NONE          , "REPEATBALL"),
	TIMER_BALL       ("TIMER BALL"       ,  1000, PocketType.POKE_BALLS, HoldEffect.NONE          , "TIMERBALL"),
	LUXURY_BALL      ("LUXURY BALL"      ,  1000, PocketType.POKE_BALLS, HoldEffect.NONE          , "LUXURYBALL"),
	PREMIER_BALL     ("PREMIER BALL"     ,   200, PocketType.POKE_BALLS, HoldEffect.NONE          , "PREMIERBALL"),
	POTION           ("POTION"           ,   300, PocketType.ITEMS     , HoldEffect.NONE          , "POTION"),
	ANTIDOTE         ("ANTIDOTE"         ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "ANTIDOTE"),
	BURN_HEAL        ("BURN HEAL"        ,   250, PocketType.ITEMS     , HoldEffect.NONE          , "BURNHEAL"),
	ICE_HEAL         ("ICE HEAL"         ,   250, PocketType.ITEMS     , HoldEffect.NONE          , "ICEHEAL"),
	AWAKENING        ("AWAKENING"        ,   250, PocketType.ITEMS     , HoldEffect.NONE          , "AWAKENING"),
	PARALYZE_HEAL    ("PARLYZ HEAL"      ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "PARALYZE_HEAL"),
	FULL_RESTORE     ("FULL RESTORE"     ,  3000, PocketType.ITEMS     , HoldEffect.NONE          , "FULLRESTORE"),
	MAX_POTION       ("MAX POTION"       ,  2500, PocketType.ITEMS     , HoldEffect.NONE          , "MAXPOTION"),
	HYPER_POTION     ("HYPER POTION"     ,  1200, PocketType.ITEMS     , HoldEffect.NONE          , "HYPERPOTION"),
	SUPER_POTION     ("SUPER POTION"     ,   700, PocketType.ITEMS     , HoldEffect.NONE          , "SUPERPOTION"),
	FULL_HEAL        ("FULL HEAL"        ,   600, PocketType.ITEMS     , HoldEffect.NONE          , "FULLHEAL"),
	REVIVE           ("REVIVE"           ,  1500, PocketType.ITEMS     , HoldEffect.NONE          , "REVIVE"),
	MAX_REVIVE       ("MAX REVIVE"       ,  4000, PocketType.ITEMS     , HoldEffect.NONE          , "MAXREVIVE"),
	FRESH_WATER      ("FRESH WATER"      ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "FRESHWATER"),
	SODA_POP         ("SODA POP"         ,   300, PocketType.ITEMS     , HoldEffect.NONE          , "SODAPOP"),
	LEMONADE         ("LEMONADE"         ,   350, PocketType.ITEMS     , HoldEffect.NONE          , "LEMONADE"),
	MOOMOO_MILK      ("MOOMOO MILK"      ,   500, PocketType.ITEMS     , HoldEffect.NONE          , "MOOMOOMILK"),
	ENERGY_POWDER    ("ENERGYPOWDER"     ,   500, PocketType.ITEMS     , HoldEffect.NONE          , "ENERGYPOWDER"),
	ENERGY_ROOT      ("ENERGY ROOT"      ,   800, PocketType.ITEMS     , HoldEffect.NONE          , "ENERGYROOT"),
	HEAL_POWDER      ("HEAL POWDER"      ,   450, PocketType.ITEMS     , HoldEffect.NONE          , "HEALPOWDER"),
	REVIVAL_HERB     ("REVIVAL HERB"     ,  2800, PocketType.ITEMS     , HoldEffect.NONE          , "REVIVALHERB"),
	ETHER            ("ETHER"            ,  1200, PocketType.ITEMS     , HoldEffect.NONE          , "ETHER"),
	MAX_ETHER        ("MAX ETHER"        ,  2000, PocketType.ITEMS     , HoldEffect.NONE          , "MAXETHER"),
	ELIXIR           ("ELIXIR"           ,  3000, PocketType.ITEMS     , HoldEffect.NONE          , "ELIXIR"),
	MAX_ELIXIR       ("MAX ELIXIR"       ,  4500, PocketType.ITEMS     , HoldEffect.NONE          , "MAXELIXIR"),
	LAVA_COOKIE      ("LAVA COOKIE"      ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "LAVACOOKIE"),
	BLUE_FLUTE       ("BLUE FLUTE"       ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "BLUEFLUTE"),
	YELLOW_FLUTE     ("YELLOW FLUTE"     ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "YELLOWFLUTE"),
	RED_FLUTE        ("RED FLUTE"        ,   300, PocketType.ITEMS     , HoldEffect.NONE          , "REDFLUTE"),
	BLACK_FLUTE      ("BLACK FLUTE"      ,   400, PocketType.ITEMS     , HoldEffect.NONE          , "BLACKFLUTE"),
	WHITE_FLUTE      ("WHITE FLUTE"      ,   500, PocketType.ITEMS     , HoldEffect.NONE          , "WHITEFLUTE"),
	BERRY_JUICE      ("BERRY JUICE"      ,   100, PocketType.ITEMS     , HoldEffect.RESTORE_HP    , "BERRYJUICE"),
	SACRED_ASH       ("SACRED ASH"       ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "SACREDASH"),
	SHOAL_SALT       ("SHOAL SALT"       ,    20, PocketType.ITEMS     , HoldEffect.NONE          , "SHOALSALT"),
	SHOAL_SHELL      ("SHOAL SHELL"      ,    20, PocketType.ITEMS     , HoldEffect.NONE          , "SHOALSHELL"),
	RED_SHARD        ("RED SHARD"        ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "REDSHARD"),
	BLUE_SHARD       ("BLUE SHARD"       ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "BLUESHARD"),
	YELLOW_SHARD     ("YELLOW SHARD"     ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "YELLOWSHARD"),
	GREEN_SHARD      ("GREEN SHARD"      ,   200, PocketType.ITEMS     , HoldEffect.NONE          , "GREENSHARD"),
	HP_UP            ("HP UP"            ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "HPUP"),
	PROTEIN          ("PROTEIN"          ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "PROTEIN"),
	IRON             ("IRON"             ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "IRON"),
	CARBOS           ("CARBOS"           ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "CARBOS"),
	CALCIUM          ("CALCIUM"          ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "CALCIUM"),
	RARE_CANDY       ("RARE CANDY"       ,  4800, PocketType.ITEMS     , HoldEffect.NONE          , "RARECANDY"),
	PP_UP            ("PP UP"            ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "PPUP"),
	ZINC             ("ZINC"             ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "ZINC"),
	PP_MAX           ("PP MAX"           ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "PPMAX"),
	GUARD_SPEC       ("GUARD SPEC."      ,   700, PocketType.ITEMS     , HoldEffect.NONE          , "GUARDSPEC"),
	DIRE_HIT         ("DIRE HIT"         ,   650, PocketType.ITEMS     , HoldEffect.NONE          , "DIREHIT"),
	X_ATTACK         ("X ATTACK"         ,   500, PocketType.ITEMS     , HoldEffect.NONE          , "XATTACK"),
	X_DEFEND         ("X DEFEND"         ,   550, PocketType.ITEMS     , HoldEffect.NONE          , "XDEFEND"),
	X_SPEED          ("X SPEED"          ,   350, PocketType.ITEMS     , HoldEffect.NONE          , "XSPEED"),
	X_ACCURACY       ("X ACCURACY"       ,   950, PocketType.ITEMS     , HoldEffect.NONE          , "XACCURACY"),
	X_SPECIAL        ("X SPECIAL"        ,   350, PocketType.ITEMS     , HoldEffect.NONE          , "XSPECIAL"),
	POKE_DOLL        ("POK� DOLL"        ,  1000, PocketType.ITEMS     , HoldEffect.NONE          , "POKEDOLL"),
	FLUFFY_TAIL      ("FLUFFY TAIL"      ,  1000, PocketType.ITEMS     , HoldEffect.NONE          , "FLUFFYTAIL"),
	SUPER_REPEL      ("SUPER REPEL"      ,   500, PocketType.ITEMS     , HoldEffect.NONE          , "SUPERREPEL"),
	MAX_REPEL        ("MAX REPEL"        ,   700, PocketType.ITEMS     , HoldEffect.NONE          , "MAXREPEL"),
	ESCAPE_ROPE      ("ESCAPE ROPE"      ,   550, PocketType.ITEMS     , HoldEffect.NONE          , "ESCAPEROPE"),
	REPEL            ("REPEL"            ,   350, PocketType.ITEMS     , HoldEffect.NONE          , "REPEL"),
	SUN_STONE        ("SUN STONE"        ,  2100, PocketType.ITEMS     , HoldEffect.NONE          , "SUNSTONE"),
	MOON_STONE       ("MOON STONE"       ,     0, PocketType.ITEMS     , HoldEffect.NONE          , "MOONSTONE"),
	FIRE_STONE       ("FIRE STONE"       ,  2100, PocketType.ITEMS     , HoldEffect.NONE          , "FIRESTONE"),
	THUNDER_STONE    ("THUNDERSTONE"     ,  2100, PocketType.ITEMS     , HoldEffect.NONE          , "THUNDERSTONE"),
	WATER_STONE      ("WATER STONE"      ,  2100, PocketType.ITEMS     , HoldEffect.NONE          , "WATERSTONE"),
	LEAF_STONE       ("LEAF STONE"       ,  2100, PocketType.ITEMS     , HoldEffect.NONE          , "LEAFSTONE"),
	TINY_MUSHROOM    ("TINYMUSHROOM"     ,   500, PocketType.ITEMS     , HoldEffect.NONE          , "TINYMUSHROOM"),
	BIG_MUSHROOM     ("BIG MUSHROOM"     ,  5000, PocketType.ITEMS     , HoldEffect.NONE          , "BIGMUSHROOM"),
	PEARL            ("PEARL"            ,  1400, PocketType.ITEMS     , HoldEffect.NONE          , "PEARL"),
	BIG_PEARL        ("BIG PEARL"        ,  7500, PocketType.ITEMS     , HoldEffect.NONE          , "BIGPEARL"),
	STARDUST         ("STARDUST"         ,  2000, PocketType.ITEMS     , HoldEffect.NONE          , "STARDUST"),
	STAR_PIECE       ("STAR PIECE"       ,  9800, PocketType.ITEMS     , HoldEffect.NONE          , "STARPIECE"),
	NUGGET           ("NUGGET"           , 10000, PocketType.ITEMS     , HoldEffect.NONE          , "NUGGET"),
	HEART_SCALE      ("HEART SCALE"      ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "HEARTSCALE"),
	ORANGE_MAIL      ("ORANGE MAIL"      ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "ORANGEMAIL"),
	HARBOR_MAIL      ("HARBOR MAIL"      ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "HARBORMAIL"),
	GLITTER_MAIL     ("GLITTER MAIL"     ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "GLITTERMAIL"),
	MECH_MAIL        ("MECH MAIL"        ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "MECHMAIL"),
	WOOD_MAIL        ("WOOD MAIL"        ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "WOODMAIL"),
	WAVE_MAIL        ("WAVE MAIL"        ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "WAVEMAIL"),
	BEAD_MAIL        ("BEAD MAIL"        ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "BEADMAIL"),
	SHADOW_MAIL      ("SHADOW MAIL"      ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "SHADOWMAIL"),
	TROPIC_MAIL      ("TROPIC MAIL"      ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "TROPICMAIL"),
	DREAM_MAIL       ("DREAM MAIL"       ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "DREAMMAIL"),
	FAB_MAIL         ("FAB MAIL"         ,    50, PocketType.ITEMS     , HoldEffect.NONE          , "FABMAIL"),
	RETRO_MAIL       ("RETRO MAIL"       ,     0, PocketType.ITEMS     , HoldEffect.NONE          , "RETROMAIL"),
	CHERI_BERRY      ("CHERI BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.CURE_PAR      , "CHERIBERRY"),
	CHESTO_BERRY     ("CHESTO BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.CURE_SLP      , "CHESTOBERRY"),
	PECHA_BERRY      ("PECHA BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.CURE_PSN      , "PECHABERRY"),
	RAWST_BERRY      ("RAWST BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.CURE_BRN      , "RAWSTBERRY"),
	ASPEAR_BERRY     ("ASPEAR BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.CURE_FRZ      , "ASPEARBERRY"),
	LEPPA_BERRY      ("LEPPA BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.RESTORE_PP    , "LEPPABERRY"),
	ORAN_BERRY       ("ORAN BERRY"       ,    20, PocketType.BERRIES   , HoldEffect.RESTORE_HP    , "ORANBERRY"),
	PERSIM_BERRY     ("PERSIM BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.CURE_CONFUSION, "PERSIMBERRY"),
	LUM_BERRY        ("LUM BERRY"        ,    20, PocketType.BERRIES   , HoldEffect.CURE_STATUS   , "LUMBERRY"),
	SITRUS_BERRY     ("SITRUS BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.RESTORE_HP    , "SITRUSBERRY"),
	FIGY_BERRY       ("FIGY BERRY"       ,    20, PocketType.BERRIES   , HoldEffect.CONFUSE_SPICY , "FIGYBERRY"),
	WIKI_BERRY       ("WIKI BERRY"       ,    20, PocketType.BERRIES   , HoldEffect.CONFUSE_DRY   , "WIKIBERRY"),
	MAGO_BERRY       ("MAGO BERRY"       ,    20, PocketType.BERRIES   , HoldEffect.CONFUSE_SWEET , "MAGOBERRY"),
	AGUAV_BERRY      ("AGUAV BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.CONFUSE_BITTER, "AGUAVBERRY"),
	IAPAPA_BERRY     ("IAPAPA BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.CONFUSE_SOUR  , "IAPAPABERRY"),
	RAZZ_BERRY       ("RAZZ BERRY"       ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "RAZZBERRY"),
	BLUK_BERRY       ("BLUK BERRY"       ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "BLUKBERRY"),
	NANAB_BERRY      ("NANAB BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "NANABBERRY"),
	WEPEAR_BERRY     ("WEPEAR BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "WEPEARBERRY"),
	PINAP_BERRY      ("PINAP BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "PINAPBERRY"),
	POMEG_BERRY      ("POMEG BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "POMEGBERRY"),
	KELPSY_BERRY     ("KELPSY BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "KELPSYBERRY"),
	QUALOT_BERRY     ("QUALOT BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "QUALOTBERRY"),
	HONDEW_BERRY     ("HONDEW BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "HONDEWBERRY"),
	GREPA_BERRY      ("GREPA BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "GREPABERRY"),
	TAMATO_BERRY     ("TAMATO BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "TAMATOBERRY"),
	CORNN_BERRY      ("CORNN BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "CORNNBERRY"),
	MAGOST_BERRY     ("MAGOST BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "MAGOSTBERRY"),
	RABUTA_BERRY     ("RABUTA BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "RABUTABERRY"),
	NOMEL_BERRY      ("NOMEL BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "NOMELBERRY"),
	SPELON_BERRY     ("SPELON BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "SPELONBERRY"),
	PAMTRE_BERRY     ("PAMTRE BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "PAMTREBERRY"),
	WATMEL_BERRY     ("WATMEL BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "WATMELBERRY"),
	DURIN_BERRY      ("DURIN BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "DURINBERRY"),
	BELUE_BERRY      ("BELUE BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "BELUEBERRY"),
	LIECHI_BERRY     ("LIECHI BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.ATTACK_UP     , "LIECHIBERRY"),
	GANLON_BERRY     ("GANLON BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.DEFENSE_UP    , "GANLONBERRY"),
	SALAC_BERRY      ("SALAC BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.SPEED_UP      , "SALACBERRY"),
	PETAYA_BERRY     ("PETAYA BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.SP_ATTACK_UP  , "PETAYABERRY"),
	APICOT_BERRY     ("APICOT BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.SP_DEFENSE_UP , "APICOTBERRY"),
	LANSAT_BERRY     ("LANSAT BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.CRITICAL_UP   , "LANSATBERRY"),
	STARF_BERRY      ("STARF BERRY"      ,    20, PocketType.BERRIES   , HoldEffect.RANDOM_STAT_UP, "STARFBERRY"),
	ENIGMA_BERRY     ("ENIGMA BERRY"     ,    20, PocketType.BERRIES   , HoldEffect.NONE          , "ENIGMABERRY"),
	BRIGHT_POWDER    ("BRIGHTPOWDER"     ,    10, PocketType.ITEMS     , HoldEffect.EVASION_UP    , "BRIGHTPOWDER"),
	WHITE_HERB       ("WHITE HERB"       ,   100, PocketType.ITEMS     , HoldEffect.RESTORE_STATS , "WHITEHERB"),
	MACHO_BRACE      ("MACHO BRACE"      ,  3000, PocketType.ITEMS     , HoldEffect.MACHO_BRACE   , "MACHOBRACE"),
	EXP_SHARE        ("EXP. SHARE"       ,  3000, PocketType.ITEMS     , HoldEffect.EXP_SHARE     , "EXPSHARE"),
	QUICK_CLAW       ("QUICK CLAW"       ,   100, PocketType.ITEMS     , HoldEffect.QUICK_CLAW    , "QUICKCLAW"),
	SOOTHE_BELL      ("SOOTHE BELL"      ,   100, PocketType.ITEMS     , HoldEffect.HAPPINESS_UP  , "SOOTHEBELL"),
	MENTAL_HERB      ("MENTAL HERB"      ,   100, PocketType.ITEMS     , HoldEffect.CURE_ATTRACT  , "MENTALHERB"),
	CHOICE_BAND      ("CHOICE BAND"      ,   100, PocketType.ITEMS     , HoldEffect.CHOICE_BAND   , "CHOICEBAND"),
	KINGS_ROCK       ("KING'S ROCK"      ,   100, PocketType.ITEMS     , HoldEffect.FLINCH        , "KINGSROCK"),
	SILVER_POWDER    ("SILVERPOWDER"     ,   100, PocketType.ITEMS     , HoldEffect.BUG_POWER     , "SILVERPOWDER"),
	AMULET_COIN      ("AMULET COIN"      ,   100, PocketType.ITEMS     , HoldEffect.DOUBLE_PRIZE  , "AMULETCOIN"),
	CLEANSE_TAG      ("CLEANSE TAG"      ,   200, PocketType.ITEMS     , HoldEffect.REPEL         , "CLEANSETAG"),
	SOUL_DEW         ("SOUL DEW"         ,   200, PocketType.ITEMS     , HoldEffect.SOUL_DEW      , "SOULDEW"),
	DEEP_SEA_TOOTH   ("DEEPSEATOOTH"     ,   200, PocketType.ITEMS     , HoldEffect.DEEP_SEA_TOOTH, "DEEPSEATOOTH"),
	DEEP_SEA_SCALE   ("DEEPSEASCALE"     ,   200, PocketType.ITEMS     , HoldEffect.DEEP_SEA_SCALE, "DEEPSEASCALE"),
	SMOKE_BALL       ("SMOKE BALL"       ,   200, PocketType.ITEMS     , HoldEffect.CAN_ALWAYS_RUN, "SMOKEBALL"),
	EVERSTONE        ("EVERSTONE"        ,   200, PocketType.ITEMS     , HoldEffect.PREVENT_EVOLVE, "EVERSTONE"),
	FOCUS_BAND       ("FOCUS BAND"       ,   200, PocketType.ITEMS     , HoldEffect.FOCUS_BAND    , "FOCUSBAND"),
	LUCKY_EGG        ("LUCKY EGG"        ,   200, PocketType.ITEMS     , HoldEffect.LUCKY_EGG     , "LUCKYEGG"),
	SCOPE_LENS       ("SCOPE LENS"       ,   200, PocketType.ITEMS     , HoldEffect.SCOPE_LENS    , "SCOPELENS"),
	METAL_COAT       ("METAL COAT"       ,   100, PocketType.ITEMS     , HoldEffect.STEEL_POWER   , "METALCOAT"),
	LEFTOVERS        ("LEFTOVERS"        ,   200, PocketType.ITEMS     , HoldEffect.LEFTOVERS     , "LEFTOVERS"),
	DRAGON_SCALE     ("DRAGON SCALE"     ,  2100, PocketType.ITEMS     , HoldEffect.DRAGON_SCALE  , "DRAGONSCALE"),
	LIGHT_BALL       ("LIGHT BALL"       ,   100, PocketType.ITEMS     , HoldEffect.LIGHT_BALL    , "LIGHTBALL"),
	SOFT_SAND        ("SOFT SAND"        ,   100, PocketType.ITEMS     , HoldEffect.GROUND_POWER  , "SOFTSAND"),
	HARD_STONE       ("HARD STONE"       ,   100, PocketType.ITEMS     , HoldEffect.ROCK_POWER    , "HARDSTONE"),
	MIRACLE_SEED     ("MIRACLE SEED"     ,   100, PocketType.ITEMS     , HoldEffect.GRASS_POWER   , "MIRACLESEED"),
	BLACK_GLASSES    ("BLACKGLASSES"     ,   100, PocketType.ITEMS     , HoldEffect.DARK_POWER    , "BLACKGLASSES"),
	BLACK_BELT       ("BLACK BELT"       ,   100, PocketType.ITEMS     , HoldEffect.FIGHTING_POWER, "BLACKBELT"),
	MAGNET           ("MAGNET"           ,   100, PocketType.ITEMS     , HoldEffect.ELECTRIC_POWER, "MAGNET"),
	MYSTIC_WATER     ("MYSTIC WATER"     ,   100, PocketType.ITEMS     , HoldEffect.WATER_POWER   , "MYSTICWATER"),
	SHARP_BEAK       ("SHARP BEAK"       ,   100, PocketType.ITEMS     , HoldEffect.FLYING_POWER  , "SHARPBEAK"),
	POISON_BARB      ("POISON BARB"      ,   100, PocketType.ITEMS     , HoldEffect.POISON_POWER  , "POISONBARB"),
	NEVER_MELT_ICE   ("NEVERMELTICE"     ,   100, PocketType.ITEMS     , HoldEffect.ICE_POWER     , "NEVERMELTICE"),
	SPELL_TAG        ("SPELL TAG"        ,   100, PocketType.ITEMS     , HoldEffect.GHOST_POWER   , "SPELLTAG"),
	TWISTED_SPOON    ("TWISTEDSPOON"     ,   100, PocketType.ITEMS     , HoldEffect.PSYCHIC_POWER , "TWISTEDSPOON"),
	CHARCOAL         ("CHARCOAL"         ,  9800, PocketType.ITEMS     , HoldEffect.FIRE_POWER    , "CHARCOAL"),
	DRAGON_FANG      ("DRAGON FANG"      ,   100, PocketType.ITEMS     , HoldEffect.DRAGON_POWER  , "DRAGONFANG"),
	SILK_SCARF       ("SILK SCARF"       ,   100, PocketType.ITEMS     , HoldEffect.NORMAL_POWER  , "SILKSCARF"),
	UP_GRADE         ("UP-GRADE"         ,  2100, PocketType.ITEMS     , HoldEffect.UP_GRADE      , "UPGRADE"),
	SHELL_BELL       ("SHELL BELL"       ,   200, PocketType.ITEMS     , HoldEffect.SHELL_BELL    , "SHELLBELL"),
	SEA_INCENSE      ("SEA INCENSE"      ,  9600, PocketType.ITEMS     , HoldEffect.WATER_POWER   , "SEAINCENSE"),
	LAX_INCENSE      ("LAX INCENSE"      ,  9600, PocketType.ITEMS     , HoldEffect.EVASION_UP    , "LAXINCENSE"),
	LUCKY_PUNCH      ("LUCKY PUNCH"      ,    10, PocketType.ITEMS     , HoldEffect.LUCKY_PUNCH   , "LUCKYPUNCH"),
	METAL_POWDER     ("METAL POWDER"     ,    10, PocketType.ITEMS     , HoldEffect.METAL_POWDER  , "METALPOWDER"),
	THICK_CLUB       ("THICK CLUB"       ,   500, PocketType.ITEMS     , HoldEffect.THICK_CLUB    , "THICKCLUB"),
	STICK            ("STICK"            ,   200, PocketType.ITEMS     , HoldEffect.STICK         , "STICK"),
	RED_SCARF        ("RED SCARF"        ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "REDSCARF"),
	BLUE_SCARF       ("BLUE SCARF"       ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "BLUESCARF"),
	PINK_SCARF       ("PINK SCARF"       ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "PINKSCARF"),
	GREEN_SCARF      ("GREEN SCARF"      ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "GREENSCARF"),
	YELLOW_SCARF     ("YELLOW SCARF"     ,   100, PocketType.ITEMS     , HoldEffect.NONE          , "YELLOWSCARF"),
	MACH_BIKE        ("MACH BIKE"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "MACHBIKE"),
	COIN_CASE        ("COIN CASE"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "COINCASE"),
	ITEMFINDER       ("ITEMFINDER"       ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ITEMFINDER"),
	OLD_ROD          ("OLD ROD"          ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "OLDROD"),
	GOOD_ROD         ("GOOD ROD"         ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "GOODROD"),
	SUPER_ROD        ("SUPER ROD"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "SUPERROD"),
	SS_TICKET        ("S.S. TICKET"      ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "SSTICKET"),
	CONTEST_PASS     ("CONTEST PASS"     ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "CONTESTPASS"),
	WAILMER_PAIL     ("WAILMER PAIL"     ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "WAILMERPAIL"),
	DEVON_GOODS      ("DEVON GOODS"      ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "DEVONGOODS"),
	SOOT_SACK        ("SOOT SACK"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "SOOTSACK"),
	BASEMENT_KEY     ("BASEMENT KEY"     ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "BASEMENTKEY"),
	ACRO_BIKE        ("ACRO BIKE"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ACROBIKE"),
	POKEBLOCK_CASE   ("{POKEBLOCK} CASE" ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "POKEBLOCKCASE"),
	LETTER           ("LETTER"           ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "LETTER"),
	EON_TICKET       ("EON TICKET"       ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "EONTICKET"),
	RED_ORB          ("RED ORB"          ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "REDORB"),
	BLUE_ORB         ("BLUE ORB"         ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "BLUEORB"),
	SCANNER          ("SCANNER"          ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "SCANNER"),
	GO_GOGGLES       ("GO-GOGGLES"       ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "GOGOGGLES"),
	METEORITE        ("METEORITE"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "METEORITE"),
	ROOM_1_KEY       ("RM. 1 KEY"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ROOM1KEY"),
	ROOM_2_KEY       ("RM. 2 KEY"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ROOM2KEY"),
	ROOM_4_KEY       ("RM. 4 KEY"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ROOM4KEY"),
	ROOM_6_KEY       ("RM. 6 KEY"        ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ROOM6KEY"),
	STORAGE_KEY      ("STORAGE KEY"      ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "STORAGEKEY"),
	ROOT_FOSSIL      ("ROOT FOSSIL"      ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "ROOTFOSSIL"),
	CLAW_FOSSIL      ("CLAW FOSSIL"      ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "CLAWFOSSIL"),
	DEVON_SCOPE      ("DEVON SCOPE"      ,     0, PocketType.KEY_ITEMS , HoldEffect.NONE          , "DEVONSCOPE"),
	TM01_FOCUS_PUNCH ("TM01 FOCUS PUNCH" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM01", "FOCUSPUNCH"),
	TM02_DRAGON_CLAW ("TM02 DRAGON CLAW" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM02", "DRAGONCLAW"),
	TM03_WATER_PULSE ("TM03 WATER PULSE" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM03", "WATER_PULSE"),
	TM04_CALM_MIND   ("TM04 CALM MIND"   ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM04", "CALMMIND"),
	TM05_ROAR        ("TM05 ROAR"        ,  1000, PocketType.TM_HM     , HoldEffect.NONE          , "TM05", "ROAR"),
	TM06_TOXIC       ("TM06 TOXIC"       ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM06", "TOXIC"),
	TM07_HAIL        ("TM07 HAIL"        ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM07", "HAIL"),
	TM08_BULK_UP     ("TM08 BULK UP"     ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM08", "BULKUP"),
	TM09_BULLET_SEED ("TM09 BULLET SEED" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM09", "BULLETSEED"),
	TM10_HIDDEN_POWER("TM10 HIDDEN POWER",  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM10", "HIDDENPOWER"),
	TM11_SUNNY_DAY   ("TM11 SUNNY DAY"   ,  2000, PocketType.TM_HM     , HoldEffect.NONE          , "TM11", "SUNNYDAY"),
	TM12_TAUNT       ("TM12 TAUNT"       ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM12", "TAUNT"),
	TM13_ICE_BEAM    ("TM13 ICE BEAM"    ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM13", "ICEBEAM"),
	TM14_BLIZZARD    ("TM14 BLIZZARD"    ,  5500, PocketType.TM_HM     , HoldEffect.NONE          , "TM14", "BLIZZARD"),
	TM15_HYPER_BEAM  ("TM15 HYPER BEAM"  ,  7500, PocketType.TM_HM     , HoldEffect.NONE          , "TM15", "HYPERBEAM"),
	TM16_LIGHT_SCREEN("TM16 LIGHT SCREEN",  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM16", "LIGHTSCREEN"),
	TM17_PROTECT     ("TM17 PROTECT"     ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM17", "PROTECT"),
	TM18_RAIN_DANCE  ("TM18 RAIN DANCE"  ,  2000, PocketType.TM_HM     , HoldEffect.NONE          , "TM18", "RAINDANCE"),
	TM19_GIGA_DRAIN  ("TM19 GIGA DRAIN"  ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM19", "GIGADRAIN"),
	TM20_SAFEGUARD   ("TM20 SAFEGUARD"   ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM20", "SAFEGUARD"),
	TM21_FRUSTRATION ("TM21 FRUSTRATION" ,  1000, PocketType.TM_HM     , HoldEffect.NONE          , "TM21", "FRUSTRATION"),
	TM22_SOLARBEAM   ("TM22 SOLARBEAM"   ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM22", "SOLARBEAM"),
	TM23_IRON_TAIL   ("TM23 IRON TAIL"   ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM23", "IRONTAIL"),
	TM24_THUNDERBOLT ("TM24 THUNDERBOLT" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM24", "THUNDERBOLT"),
	TM25_THUNDER     ("TM25 THUNDER"     ,  5500, PocketType.TM_HM     , HoldEffect.NONE          , "TM25", "THUNDER"),
	TM26_EARTHQUAKE  ("TM26 EARTHQUAKE"  ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM26", "EARTHQUAKE"),
	TM27_RETURN      ("TM27 RETURN"      ,  1000, PocketType.TM_HM     , HoldEffect.NONE          , "TM27", "RETURN"),
	TM28_DIG         ("TM28 DIG"         ,  2000, PocketType.TM_HM     , HoldEffect.NONE          , "TM28", "DIG"),
	TM29_PSYCHIC     ("TM29 PSYCHIC"     ,  2000, PocketType.TM_HM     , HoldEffect.NONE          , "TM29", "PSYCHIC"),
	TM30_SHADOW_BALL ("TM30 SHADOW BALL" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM30", "SHADOWBALL"),
	TM31_BRICK_BREAK ("TM31 BRICK BREAK" ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM31", "BRICKBREAK"),
	TM32_DOUBLE_TEAM ("TM32 DOUBLE TEAM" ,  2000, PocketType.TM_HM     , HoldEffect.NONE          , "TM32", "DOUBLETEAM"),
	TM33_REFLECT     ("TM33 REFLECT"     ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM33", "REFLECT"),
	TM34_SHOCK_WAVE  ("TM34 SHOCK WAVE"  ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM34", "SHOCKWAVE"),
	TM35_FLAMETHROWER("TM35 FLAMETHROWER",  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM35", "FLAMETHROWER"),
	TM36_SLUDGE_BOMB ("TM36 SLUDGE BOMB" ,  1000, PocketType.TM_HM     , HoldEffect.NONE          , "TM36", "SLUDGEBOMB"),
	TM37_SANDSTORM   ("TM37 SANDSTORM"   ,  2000, PocketType.TM_HM     , HoldEffect.NONE          , "TM37", "SANDSTORM"),
	TM38_FIRE_BLAST  ("TM38 FIRE BLAST"  ,  5500, PocketType.TM_HM     , HoldEffect.NONE          , "TM38", "FIREBLAST"),
	TM39_ROCK_TOMB   ("TM39 ROCK TOMB"   ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM39", "ROCKTOMB"),
	TM40_AERIAL_ACE  ("TM40 AERIAL ACE"  ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM40", "AERIALACE"),
	TM41_TORMENT     ("TM41 TORMENT"     ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM41", "TORMENT"),
	TM42_FACADE      ("TM42 FACADE"      ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM42", "FACADE"),
	TM43_SECRET_POWER("TM43 SECRET POWER",  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM43", "SECRETPOWER"),
	TM44_REST        ("TM44 REST"        ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM44", "REST"),
	TM45_ATTRACT     ("TM45 ATTRACT"     ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM45", "ATTRACT"),
	TM46_THIEF       ("TM46 THIEF"       ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM46", "THIEF"),
	TM47_STEEL_WING  ("TM47 STEEL WING"  ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM47", "STEELWING"),
	TM48_SKILL_SWAP  ("TM48 SKILL SWAP"  ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM48", "SKILLSWAP"),
	TM49_SNATCH      ("TM49 SNATCH"      ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM49", "SNATCH"),
	TM50_OVERHEAT    ("TM50 OVERHEAT"    ,  3000, PocketType.TM_HM     , HoldEffect.NONE          , "TM50", "OVERHEAT"),
	HM01_CUT         ("HM01 CUT"         ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM01", "CUT"),
	HM02_FLY         ("HM02 FLY"         ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM02", "FLY"),
	HM03_SURF        ("HM03 SURF"        ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM03", "SURF"),
	HM04_STRENGTH    ("HM04 STRENGTH"    ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM04", "STRENGTH"),
	HM05_FLASH       ("HM05 FLASH"       ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM05", "FLASH"),
	HM06_ROCK_SMASH  ("HM06 ROCK SMASH"  ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM06", "ROCKSMASH"),
	HM07_WATERFALL   ("HM07 WATERFALL"   ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM07", "WATERFALL"),
	HM08_DIVE        ("HM08 DIVE"        ,     0, PocketType.TM_HM     , HoldEffect.NONE          , "HM08", "DIVE");

	private static LookupTable<Item> itemTable = new LookupTable<>();
	static {
		for(Item item : Item.values()) {
			for(String commandName : item.commandNames) {
				itemTable.put(commandName, item);
			}
		}
	}
	
	public static Item getItemFromString(String name) {
		return itemTable.get(name);
	}
	
	
	private String displayName;
	private int cost;
	private PocketType pocketType;
	private HoldEffect holdEffect;
	private String[] commandNames;
	
	private Item(String displayName, int cost, PocketType pocketType, HoldEffect holdEffect, String... commandNames) {
		this.displayName = displayName;
		this.cost = cost;
		this.pocketType = pocketType;
		this.holdEffect = holdEffect;
		this.commandNames = commandNames;
	}

	public String getDisplayName() {
		return displayName;
	}

	public int getCost() {
		return cost;
	}

	public PocketType getPocketType() {
		return pocketType;
	}

	public HoldEffect getHoldEffect() {
		return holdEffect;
	}

	public String[] getCommandNames() {
		return commandNames;
	}
}