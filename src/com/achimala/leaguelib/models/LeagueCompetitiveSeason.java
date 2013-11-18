/*
 *  This file is part of LeagueLib.
 *  LeagueLib is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  LeagueLib is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with LeagueLib.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.achimala.leaguelib.models;

public enum LeagueCompetitiveSeason {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    CURRENT(-1);
    
    public final int value;
    
    private LeagueCompetitiveSeason(int value) {
    	this.value = value;
	}
    
    public int getValue() {
    	return this.value;
    }
}