package data_struct;

import java.util.EnumMap;

import data.Badge;
import data.Stat;

public class BadgeBoosts {
	private EnumMap<Stat, Badge> badgeBoosts;
	
	public BadgeBoosts() {
		badgeBoosts = new EnumMap<Stat, Badge>(Stat.class);
	}
	
	public void addBadge(Badge badge) {
		for(Stat stat : badge.getBoostedStats())
			badgeBoosts.put(stat, badge);
	}
	
	public boolean hasBadgeBoost(Stat stat) {
		return badgeBoosts.containsKey(stat);
	}

	public EnumMap<Stat, Badge> getBadges() {
		return badgeBoosts;
	}

	public void setBadges(EnumMap<Stat, Badge> badgeBoosts) {
		this.badgeBoosts = badgeBoosts;
	}

	public void dropBadges() {
		badgeBoosts.clear();
	}
}
