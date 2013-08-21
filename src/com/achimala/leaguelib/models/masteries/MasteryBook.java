package com.achimala.leaguelib.models.masteries;

import java.util.ArrayList;
import java.util.List;

import com.achimala.leaguelib.models.LeagueSummoner;
import com.gvaneyck.rtmp.TypedObject;

public class MasteryBook {

	private List<MasteryBookPage> _pages = new ArrayList<MasteryBookPage>();
	private LeagueSummoner _summoner;
	
	public MasteryBook (TypedObject data) {
		
		Object[] objects = data.getArray("bookPages");
		
		for (Object pageObject : objects)
		{
			TypedObject page = (TypedObject) pageObject;
			_pages.add(new MasteryBookPage(page));
		}
		
	}
}
