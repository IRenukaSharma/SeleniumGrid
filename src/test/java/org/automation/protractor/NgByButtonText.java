package org.automation.protractor;

public class NgByButtonText extends ProtractorBy {

	public NgByButtonText(String value) {
		super(ClientSideScripts.FindByButtonText, value,true);
	}

}
