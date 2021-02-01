package demoblaze;

import java.io.IOException;

public class DemoBlazeNew extends NavigationNew{

	public static void main(String[] args) throws InterruptedException, IOException {
		
DemoBlazeNew db=new DemoBlazeNew();
db.customernavigation();
db.NavigationToCartSony();
db.NavigationToCartDell();	
db.Purchase("Rajat K", "India", "Pune", "1223455634564534", "Jan", "2021");
db.takescreenshot("PurchaseOrder");
	}

}
