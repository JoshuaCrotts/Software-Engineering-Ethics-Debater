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

package com.uncg.save.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class CommentPaneController implements Initializable
{
    //////////////////////// INSTANCE VARIABLES /////////////////////////////    
    
    //
    //
    //
    @FXML private Pane                        mainPane;
    @FXML private TextArea                    commentArea;
    private       PropositionBoxController    parent;

    //
    //
    //
    protected     boolean                     visible = false;
    private       String                      comment = null;
    private       double                      x       = 0.0;
    private       double                      y       = 0.0;

    //////////////////////// INSTANCE VARIABLES /////////////////////////////
    
    /**
      * Controls the comment panes that can be added to a proposition
      * 
      * @param url
      * @param rb
      */
    @Override
    public void initialize( URL url, ResourceBundle rb )
    {
        mainPane.toFront();
        commentArea.setWrapText( true );
        commentArea.setMaxWidth( 380 );
        commentArea.setFont( new Font( "System Regular", 18 ) );

        ContextMenu contextMenu = new ContextMenu();
        try
        {
            setContextMenuItems( contextMenu );
        } catch ( IOException ex )
        {
            Logger.getLogger( PropositionBoxController.class.getName() ).log( Level.SEVERE, null, ex );
        }
        commentArea.setContextMenu( contextMenu );

        mainPane.addEventFilter( MouseEvent.MOUSE_PRESSED, ( MouseEvent mouseEvent ) ->
        {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
//                mouseEvent.consume();
        } );
        mainPane.addEventFilter( MouseEvent.MOUSE_DRAGGED, ( MouseEvent mouseEvent ) ->
        {
            onDragRelease( mouseEvent );
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        } );
    }

    //Sets the context menu items
    private void setContextMenuItems( ContextMenu contextMenu ) throws IOException
    {
        MenuItem clear = new MenuItem( "Clear comment" );

        setHandlerForClear( clear );

        contextMenu.getItems().addAll( clear );
    }

    private void setHandlerForClear( MenuItem item )
    {
        item.setOnAction( action ->
        {
            commentArea.clear();
            updateComment();
        } );
    }

    //Initializes width of comment pane
    private void initializeCommentPaneWidth()
    {
        int i = parent.getCommentText().length() - 24;
        if ( i > 0 )
        {
            int toAdd = i * 10;
            commentArea.setPrefWidth( commentArea.getPrefWidth() + toAdd );
            commentArea.setMinWidth( commentArea.getPrefWidth() + toAdd );
            commentArea.setMaxWidth( commentArea.getPrefWidth() + toAdd );
            mainPane.setPrefWidth( commentArea.getPrefWidth() );
        }
    }

    //Fits the comment pane to fully display the comment
    private void updateCommentPaneSize()
    {
        int i = commentArea.getText().length();
        int j = i / 25;
        int change = ( 50 + ( j * 20 ) );
        commentArea.setPrefHeight( change );
        commentArea.setMaxHeight( change );
    }

    @FXML
    private void updateComment()
    {
        updateCommentPaneSize();
        this.parent.setComment( commentArea.getText() );
    }

    @FXML
    private void onClick()
    {

    }

    public void setComment( String s )
    {
        commentArea.setText( s );
    }

    public String getComment()
    {
        return this.comment;
    }

    public void setParent( PropositionBoxController pbc )
    {
        this.parent = pbc;
        initializeCommentPaneWidth();
    }

    @FXML
    private void onDragRelease( MouseEvent mouseEvent )
    {
        double a = mouseEvent.getScreenX() - x;
        double b = mouseEvent.getScreenY() - y;
        this.parent.translateComment( a, b );
    }
}
