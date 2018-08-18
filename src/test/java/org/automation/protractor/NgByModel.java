package org.automation.protractor;

public class NgByModel extends ProtractorBy {

	public NgByModel(String value) {
		super(ClientSideScripts.FindByModel, value);
	}

}
