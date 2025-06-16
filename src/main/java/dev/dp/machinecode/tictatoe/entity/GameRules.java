package dev.dp.machinecode.tictatoe.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameRules implements Serializable {

        private List<Rule> listOfRules = new ArrayList<Rule>();

        private GameRules(){}

        public List<Rule> queryGamesRule(){
            return listOfRules;
        }

}
