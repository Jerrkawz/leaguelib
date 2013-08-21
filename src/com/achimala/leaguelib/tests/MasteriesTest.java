package com.achimala.leaguelib.tests;

import java.util.Map;

import com.achimala.leaguelib.connection.LeagueAccount;
import com.achimala.leaguelib.connection.LeagueConnection;
import com.achimala.leaguelib.connection.LeagueServer;
import com.achimala.leaguelib.errors.LeagueException;
import com.achimala.leaguelib.models.LeagueSummoner;


public class MasteriesTest {

	public static void main(String args[]) throws Exception
	{
	    final LeagueConnection c = new LeagueConnection(LeagueServer.NORTH_AMERICA);
	    c.getAccountQueue().addAccount(new LeagueAccount(LeagueServer.NORTH_AMERICA, "3.10.xx", "jman2807", args[0]));
	    
	    Map<LeagueAccount, LeagueException> exceptions = c.getAccountQueue().connectAll();
	    if(exceptions != null) {
	        for(LeagueAccount account : exceptions.keySet())
	            System.out.println(account + " error: " + exceptions.get(account));
	        return;
	    }
	    
	    LeagueSummoner s = c.getSummonerService().getSummonerByName("jerrkawz");
	    c.getMasteryService().fillMasteryBook(s);
	    
	    System.out.println("");
	}
}
