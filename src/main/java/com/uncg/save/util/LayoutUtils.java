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

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class LayoutUtils
{

    /**

     @param pane
     @param x
     @param y

     @return
     */
    public static Point2D getLocalCoords( Pane pane, double x, double y )
    {
        Point2D localCoords;
        localCoords = pane.sceneToLocal( x, y, true );
        return localCoords;
    }

    /**
     Sets the layout of a pane

     @param pane Pane
     @param coords Point2D
     */
    public static void setChildLayout( Pane pane, Point2D coords )
    {
        pane.setLayoutX( coords.getX() );
        pane.setLayoutY( coords.getY() );
    }

}
