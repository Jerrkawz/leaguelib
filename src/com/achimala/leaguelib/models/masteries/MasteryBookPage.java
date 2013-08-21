package com.achimala.leaguelib.models.masteries;

import java.util.ArrayList;
import java.util.List;

import com.gvaneyck.rtmp.TypedObject;

public class MasteryBookPage {

	public MasteryBookPage(TypedObject page) {
		_current = page.getBool("current");
		_name = page.getString("name");
		
		Object[] entries = page.getArray("talentEntries");
		for (Object entry : entries)
		{
			Talent talent = new Talent((TypedObject) entry);
			switch(talent.getGroupId())
			{
			case 1:
				_offense.add(talent);
				break;
			case 2:
				_defense.add(talent);
				break;
			case 3:
				_utility.add(talent);
				break;
			}
		}
	}

	private List<Talent> _defense = new ArrayList<Talent>();
	private List<Talent> _offense = new ArrayList<Talent>();
	private List<Talent> _utility = new ArrayList<Talent>();
	private boolean _current = false;
	private String _name;
	
	
}
