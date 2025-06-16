package dev.dp.machinecode.tictatoe.entity;

public class Rule {
    private final int ruleId;
    private final String ruleName;

   public Rule(int ruleId, String ruleName) {
       this.ruleId = ruleId;
       this.ruleName = ruleName;
   }

   public int getRuleId() {
       return this.ruleId;
   }
   public String getRuleName() {
       return this.ruleName;
   }

}
