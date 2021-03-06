/*
===========================================================================
                        Software Engineering Ethics Debater (SWED) Source Code
                           Copyright (C) 2019 Nancy Green

Software Engineering Ethics Debater (SWED) is free software: you can redistribute it and/or 
modify it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

SWED Source Code is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with SWED Source Code.  If not, see <http://www.gnu.org/licenses/>.

If you have questions concerning this license or the applicable additional 
terms, you may contact Dr. Nancy Green at the University of North
Carolina at Greensboro.

===========================================================================
*/

package com.uncg.save.util;

public abstract class MouseUtils {
    
    public static double Mouse_X;
    public static double Mouse_Y;
    public static double Delta_X;
    public static double Delta_Y;
    
    // Perhaps replace this with the system's clipboard? Or is this
    // better just because it's not as memory-intensive?s
    public static String ClipBoard = "";
    
    public static boolean hasContent()
    {
        return !ClipBoard.isEmpty();
    }
}
