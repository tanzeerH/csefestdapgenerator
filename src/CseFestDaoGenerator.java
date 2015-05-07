import java.awt.event.ItemEvent;
import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;
import de.greenrobot.daogenerator.ToOne;

public class CseFestDaoGenerator {

	public static void main(String[] args) {
		Schema schema = new Schema(1000, "com.buet_crt.csefest.dao");

		test(schema);

		try {
			new DaoGenerator().generateAll(schema, "../CseFestDaoGenerator");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void test(Schema schema)
	{
		Entity entity=schema.addEntity("Subject");
		Property id=entity.addIdProperty().autoincrement().getProperty();
		entity.addStringProperty("auther");
		entity.addStringProperty("price");
		entity.addStringProperty("subject");
		
		Entity topics=schema.addEntity("Topics");
		topics.addStringProperty("title");
		entity.addToMany(topics,id);
	}

	private static void addItem(Schema schema) {
		Entity item = schema.addEntity("AddItem");
		Property item_id = item.addIdProperty().autoincrement().getProperty();
		item.addIntProperty("store_id").notNull();
		item.addStringProperty("store_name").notNull();
		item.addIntProperty("price").notNull();
		item.addStringProperty("item_name").notNull();
		item.addIntProperty("quantity").notNull();
		item.addIntProperty("item_id").notNull();
		item.addStringProperty("notes").notNull();
		item.addIntProperty("order_type").notNull();

		Entity modItem = schema.addEntity("ModItem");
		modItem.addIntProperty("quantity").notNull();
		modItem.addIntProperty("item_id").notNull();
		modItem.addIntProperty("parent_item_id").notNull();
		modItem.addStringProperty("name").notNull();
		modItem.addIntProperty("price").notNull();

		ToMany ItemToModItem = item.addToMany(modItem, item_id);
		ItemToModItem.setName("mod_items");

		Entity store = schema.addEntity("DStore");
		store.setTableName("Stores");
		store.addStringProperty("address");
		store.addStringProperty("backgroundImageUrl");
		store.addStringProperty("backgroundThumbnailUrl");
		store.addLongProperty("beaconId");
		store.addStringProperty("bssid");
		store.addStringProperty("city");
		store.addBooleanProperty("claimed");
		store.addDoubleProperty("cosineLat");
		store.addDoubleProperty("cosineLng");
		store.addLongProperty("createdDate");
		store.addIntProperty("deliveryDistance");
		store.addIntProperty("deliveryFee");
		store.addStringProperty("executiveChef");
		store.addStringProperty("description");
		store.addStringProperty("fbUrl");
		store.addStringProperty("gplusUrl");
		store.addStringProperty("hours");
		Property store_id = store.addIdProperty().notNull().getProperty();
		store.addBooleanProperty("isActive");
		store.addDoubleProperty("lat");
		store.addDoubleProperty("lng");
		store.addIntProperty("minOrderAmtForDelivery");
		store.addLongProperty("modifiedDate");
		store.addStringProperty("name");
		store.addStringProperty("phone");
		store.addIntProperty("priceRange");
		store.addBooleanProperty("providesCarryout");
		store.addBooleanProperty("providesDelivery");
		store.addBooleanProperty("providesPreOrder");
		store.addBooleanProperty("providesReservation");
		store.addBooleanProperty("providesWaitlist");
		store.addStringProperty("rewardsDescription");
		store.addIntProperty("rewardsRate");
		store.addDoubleProperty("sinLat");
		store.addDoubleProperty("sinLng");
		store.addStringProperty("ssid");
		store.addStringProperty("state");
		store.addStringProperty("subType");
		store.addStringProperty("twitterUrl");
		store.addStringProperty("type");
		store.addStringProperty("webSiteUrl");
		store.addStringProperty("zip");

		Entity trophy = schema.addEntity("Trophies");
		trophy.addStringProperty("name").notNull();
		trophy.addLongProperty("store_id");

		store.addToMany(trophy, store_id);
		
		
		Entity menuandsubmenu=schema.addEntity("MenuAndSubmenu");
		menuandsubmenu.addBooleanProperty("active");
		menuandsubmenu.addLongProperty("createdDate");
		menuandsubmenu.addStringProperty("hours");
		menuandsubmenu.addLongProperty("id");
		menuandsubmenu.addIntProperty("level");
		menuandsubmenu.addIntProperty("menuItemCount");
		menuandsubmenu.addIntProperty("menuItemPosition");
		menuandsubmenu.addIntProperty("menuType");
		menuandsubmenu.addLongProperty("modifiedDate");
		menuandsubmenu.addStringProperty("name");
		
		
		
		

	}

}
