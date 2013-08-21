package com.achimala.leaguelib.models.runes;

import java.util.ArrayList;
import java.util.List;

import com.gvaneyck.rtmp.TypedObject;

public class RunePage {

	private int _pageId;
	private String _name;
	private boolean _current;
	
	List<Rune> _quints = new ArrayList<Rune>();
	List<Rune> _marks = new ArrayList<Rune>();
	List<Rune> _seals = new ArrayList<Rune>();
	List<Rune> _glyphs= new ArrayList<Rune>();
	
	public RunePage(TypedObject page)
	{
		_pageId = page.getInt("pageId");
		_name = page.getString("name");
		_current = page.getBool("current");
		
		Object[] entries = page.getArray("slotEntries");
		
		for (Object entry : entries)
		{
			Rune rune = new Rune((TypedObject) entry);
			int slotId = rune.getSlotId();
			
			if (slotId <= 9)
				_marks.add(rune);
			else if (slotId > 9 && slotId <= 18)
				_seals.add(rune);
			else if (slotId > 18 && slotId <= 27)
				_glyphs.add(rune);
			else
				_quints.add(rune);
		}
	}
	
	public List<Rune> getMarks(){
		return _marks;
	}
	
	public List<Rune> getSeals(){
		return _seals;
	}
	
	public List<Rune> getGlyphs(){
		return _glyphs;
	}
	
	public List<Rune> getQuints()
	{
		return _quints;
	}
	
	public List<Rune> getAllRunes()
	{
		List<Rune> runes = new ArrayList<Rune>();
		runes.addAll(_marks);
		runes.addAll(_seals);
		runes.addAll(_glyphs);
		runes.addAll(_quints);
		
		return runes;
	}
	
	public boolean isCurrent()
	{
		return _current;
	}
	
	public String getName(){
		return _name;
	}
	
	public int getPageId()
	{
		return _pageId;
	}
}
