package data;

import utility.LookupTable;

public enum Ability {
	// see : https://github.com/pret/pokeruby/blob/d63e99c418de98005eac31ba3e6c1abdd6e3ecaf/include/constants/abilities.h#L4
	NONE         ("NONE"),
	STENCH       ("STENCH"),
	DRIZZLE      ("DRIZZLE"),
	SPEED_BOOST  ("SPEEDBOOST"),
	BATTLE_ARMOR ("BATTLEARMOR"),
	STURDY       ("STURDY"),
	DAMP         ("DAMP"),
	LIMBER       ("LIMBER"),
	SAND_VEIL    ("SANDVEIL"),
	STATIC       ("STATIC"),
	VOLT_ABSORB  ("VOLTABSORB"),
	WATER_ABSORB ("WATERABSORB"),
	OBLIVIOUS    ("OBLIVIOUS"),
	CLOUD_NINE   ("CLOUDNINE"),
	COMPOUND_EYES("COMPOUNDEYES"),
	INSOMNIA     ("INSOMNIA"),
	COLOR_CHANGE ("COLORCHANGE"),
	IMMUNITY     ("IMMUNITY"),
	FLASH_FIRE   ("FLASHFIRE"),
	SHIELD_DUST  ("SHIELDDUST"),
	OWN_TEMPO    ("OWNTEMPO"),
	SUCTION_CUPS ("SUCTIONCUPS"),
	INTIMIDATE   ("INTIMIDATE"),
	SHADOW_TAG   ("SHADOWTAG"),
	ROUGH_SKIN   ("ROUGHSKIN"),
	WONDER_GUARD ("WONDERGUARD"),
	LEVITATE     ("LEVITATE"),
	EFFECT_SPORE ("EFFECTSPORE"),
	SYNCHRONIZE  ("SYNCHRONIZE"),
	CLEAR_BODY   ("CLEARBODY"),
	NATURAL_CURE ("NATURALCURE"),
	LIGHTNING_ROD("LIGHTNINGROD"),
	SERENE_GRACE ("SERENEGRACE"),
	SWIFT_SWIM   ("SWIFTSWIM"),
	CHLOROPHYLL  ("CHLOROPHYLL"),
	ILLUMINATE   ("ILLUMINATE"),
	TRACE        ("TRACE"),
	HUGE_POWER   ("HUGEPOWER"),
	POISON_POINT ("POISONPOINT"),
	INNER_FOCUS  ("INNERFOCUS"),
	MAGMA_ARMOR  ("MAGMAARMOR"),
	WATER_VEIL   ("WATERVEIL"),
	MAGNET_PULL  ("MAGNETPULL"),
	SOUNDPROOF   ("SOUNDPROOF"),
	RAIN_DISH    ("RAINDISH"),
	SAND_STREAM  ("SANDSTREAM"),
	PRESSURE     ("PRESSURE"),
	THICK_FAT    ("THICKFAT"),
	EARLY_BIRD   ("EARLYBIRD"),
	FLAME_BODY   ("FLAMEBODY"),
	RUN_AWAY     ("RUNAWAY"),
	KEEN_EYE     ("KEENEYE"),
	HYPER_CUTTER ("HYPERCUTTER"),
	PICKUP       ("PICKUP"),
	TRUANT       ("TRUANT"),
	HUSTLE       ("HUSTLE"),
	CUTE_CHARM   ("CUTECHARM"),
	PLUS         ("PLUS"),
	MINUS        ("MINUS"),
	FORECAST     ("FORECAST"),
	STICKY_HOLD  ("STICKYHOLD"),
	SHED_SKIN    ("SHEDSKIN"),
	GUTS         ("GUTS"),
	MARVEL_SCALE ("MARVELSCALE"),
	LIQUID_OOZE  ("LIQUIDOOZE"),
	OVERGROW     ("OVERGROW"),
	BLAZE        ("BLAZE"),
	TORRENT      ("TORRENT"),
	SWARM        ("SWARM"),
	ROCK_HEAD    ("ROCKHEAD"),
	DROUGHT      ("DROUGHT"),
	ARENA_TRAP   ("ARENATRAP"),
	VITAL_SPIRIT ("VITALSPIRIT"),
	WHITE_SMOKE  ("WHITESMOKE"),
	PURE_POWER   ("PUREPOWER"),
	SHELL_ARMOR  ("SHELLARMOR"),
	CACOPHONY    ("CACOPHONY"),
	AIR_LOCK     ("AIRLOCK");
	
	public static LookupTable<Ability> abilityTable = new LookupTable<>();
	static {
		for(Ability ability : Ability.values()) {
			abilityTable.put(ability.getName(), ability);
		}
	}
	
	public static Ability getAbilityFromString(String name) {
		return abilityTable.get(name);
	}
	
	private String name;
	
	private Ability(String name) {
		this.name = name;
	}
	

	// Getters
	public String getName() {
		return name;
	}

}
