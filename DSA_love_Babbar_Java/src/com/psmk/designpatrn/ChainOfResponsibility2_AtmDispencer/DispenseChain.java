package com.psmk.designpatrn.ChainOfResponsibility2_AtmDispencer;
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}