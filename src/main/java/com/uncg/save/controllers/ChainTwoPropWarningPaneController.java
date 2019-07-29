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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChainTwoPropWarningPaneController implements Initializable
{
    //////////////////////// INSTANCE VARIABLES /////////////////////////////
    
    @FXML
    private VBox                    mainContainer;
    private ChainPropositionChoice  userChoice;
    
    //////////////////////// INSTANCE VARIABLES /////////////////////////////

    /**
     Controls the picker for which proposition is to be kept when trying to
     merge two panes that both have a proposition
     */
    @Override
    public void initialize( URL url, ResourceBundle rb )
    {
        userChoice = ChainPropositionChoice.CANCEL;
    }

    //Keeps the proposition of the pane being dragged onto
    @FXML
    private void keepPremise( ActionEvent action )
    {
        userChoice = ChainPropositionChoice.PREMISE;
        Stage stage = ( Stage ) mainContainer.getScene().getWindow();
        stage.close();
        action.consume();
    }

    //Keeps the proposition of the pane being dragged
    @FXML
    private void keepConclusion( ActionEvent action )
    {
        userChoice = ChainPropositionChoice.CONCLUSION;
        Stage stage = ( Stage ) mainContainer.getScene().getWindow();
        stage.close();
        action.consume();
    }

    //Cancels the action and does not merge
    @FXML
    private void cancel( ActionEvent action )
    {
        userChoice = ChainPropositionChoice.CANCEL;
        Stage stage = ( Stage ) mainContainer.getScene().getWindow();
        stage.close();
        action.consume();
    }

    public ChainPropositionChoice getUserPropositionChoice()
    {
        return userChoice;
    }
}
