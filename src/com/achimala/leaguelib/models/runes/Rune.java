package com.achimala.leaguelib.models.runes;

import com.gvaneyck.rtmp.TypedObject;

public class Rune {

	private int _runeId;
	private int _slotId;
	private String _name;
	private String _description;
	private int _tier;
	
	public Rune(TypedObject entry) {
		_runeId = entry.getInt("runeId");
		_slotId = entry.getInt("runeSlotId");
		TypedObject rune = entry.getTO("rune");
		_name = rune.getString("name");
		_tier = rune.getInt("tier");
		_description = rune.getString("description");
	}

	public int getRuneId() {
		return _runeId;
	}

	public int getSlotId() {
		return _slotId;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}

	public int getTier() {
		return _tier;
	}

	public String toString(){
		return _runeId + ": " + _name;
	}
}
