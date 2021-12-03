package app.business.services;

import app.business.model.ForkliftOperator;
import app.persistence.*;
import app.presentation.*;

public class ReceivingOperation implements IReceivingOperation {
	private IHumanResources humanResources;
	private IWarehouse warehouse;

	public ReceivingOperation(IHumanResources humanResources, IWarehouse warehouse) {
		this.humanResources = humanResources;
		this.warehouse = warehouse;
	}

	public void receive(String item, int count) {
		ForkliftOperator forkliftOperator = humanResources.getForkLiftOperator();
		forkliftOperator.storeItem(item, count);

		warehouse.add(item, count);

		Output.printMessage("Received " + count + " " + item);
	}
}
