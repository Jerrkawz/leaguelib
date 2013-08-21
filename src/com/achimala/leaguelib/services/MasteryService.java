package com.achimala.leaguelib.services;

import com.achimala.leaguelib.connection.LeagueConnection;
import com.achimala.leaguelib.errors.LeagueException;
import com.achimala.leaguelib.models.LeagueSummoner;
import com.achimala.leaguelib.models.masteries.MasteryBook;
import com.achimala.util.Callback;
import com.gvaneyck.rtmp.TypedObject;

/**
 * This service is an addition to the existing services provided by leage lib.
 * @author Jerrod Lankford
 *
 */
public class MasteryService extends LeagueAbstractService {

	public MasteryService(LeagueConnection connection) {
		super(connection);
	}

	@Override
	public String getServiceName() {
		return "masteryBookService";
	}
	
    public MasteryBook getMasteryBook(LeagueSummoner summoner) throws LeagueException 
    {
        TypedObject obj = call("getMasteryBook", new Object[] { summoner.getId() });
        return new MasteryBook(obj.getTO("body"));

    }
    
    public void getMasteryBook(LeagueSummoner summoner, final Callback<MasteryBook> callback)
    {
    	callAsynchronously("getMasteryBook", new Object[] { summoner.getId()}, new Callback<TypedObject>(){

			@Override
			public void onCompletion(TypedObject result) {
				callback.onCompletion(new MasteryBook(result.getTO("body")));
			}
			//test
			@Override
			public void onError(Exception ex) {
				callback.onError(ex);
			}
    		
    	});
    }


}
